package com.gxuwz.medical.sfy.system.web.illcard;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.Utils;
import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.illcard.IllCard;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.ChronicdisService;
import com.gxuwz.medical.sfy.system.service.FamilyService;
import com.gxuwz.medical.sfy.system.service.IllCardService;
import com.gxuwz.medical.sfy.system.service.ParticipationService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.FamilyServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.IllCardServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ParticipationServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;



@WebServlet("/system/illcard")
public class IllCardServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	IllCardService service = new IllCardServiceImpl();
       
	    //查询已经缴费但未办理慢性病的用户
		public void search(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
			//获取响应数据
			String xm = request.getParameter("xm");
			
			//根据姓名查询缴费表
			ParticipationService ps = new ParticipationServiceImpl();
			List<Participation> lp = ps.findByXm(xm);
			
			
			//查询所有行政区域信息
			AreaService as = new AreaServiceImpl();
			List <Area> la = as.findAllArea();
			
			//根据家庭编号查询家庭信息
			FamilyService fs = new FamilyServiceImpl();
			List<Family> lf = fs.findByJtbh(lp);
			
			//根据姓名查找慢病证表
			List<IllCard> li = service.findIllCardByXm(xm);
			for(int i=0;i<li.size();i++) {
				for(int j=0;j<lp.size();j++) {
					if(lp.get(i).getSfzh().equals(li.get(j).getSfzh())) {
						lp.remove(i);
					}
				}
			}
			
			response.getWriter().write(new Gson().toJson(lp));
			
		}
		
		//分页查询，已办理慢病证的用户
		public void findIllCard(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			//获取请求数据
			String xm = request.getParameter("xm");
			//System.out.println("xm="+xm);
			request.setAttribute("xm", xm);
			String illCardId = request.getParameter("illCardId");//慢病证号
			String sfzh = request.getParameter("sfzh");//身份证号
			String nhzh = request.getParameter("nhzh");//农合证号
			String illName = request.getParameter("illName");//疾病名称
			
			String sindex = request.getParameter("index");//获取页数
	    	int index = 1;
	    	try {
				index = Integer.parseInt(sindex);
			} catch (NumberFormatException n) {
				n.printStackTrace();
			}
	    	PageBean<IllCard> pi = new PageBean<IllCard>();
	    	pi.setIndex(index);//设置当前页数
	    	service.pageIllCard(pi,illCardId,sfzh,nhzh,illName,xm);
	    	
	    	request.setAttribute("pi", pi);
	    	request.getRequestDispatcher("/view/system/illcard/illcard_list.jsp").forward(request, response);
	    	
		}
		
		//查询所有慢性病
		public void findAllChronicdis(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			 ChronicdisService cs = new ChronicdisServiceImpl();
			 List <Chronicdis> lc = cs.findAllChronicdis();
			 response.getWriter().write(new Gson().toJson(lc));
		}
		
		//保存慢病证
		public void SaveIllCard(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			//获取请求参数
			String xm = request.getParameter("xm");//姓名
			String nhzh = request.getParameter("nhzh");//农合证号
			String sfzh = request.getParameter("sfzh");//身份证号
			String illCardId = request.getParameter("illCardId");//慢病证号
			String illName = request.getParameter("illname");//疾病名称
			String startTime = request.getParameter("startTime");//开始时间
			String endTime = request.getParameter("endTime");//结束时间
			
			//声明变量
			IllCard illcard = new IllCard();
			illcard.setXm(xm);
			illcard.setNhzh(nhzh);
			illcard.setSfzh(sfzh);
			illcard.setIllCardId(illCardId);
			illcard.setIllName(illName);
			illcard.setStartTime(startTime);
			illcard.setEndTime(endTime);
			int i = service.saveIllCard(illcard);
			if(i>0) {
				request.setAttribute("url", "system/illcard?method=findIllCard&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
		}
		
		//删除慢病证
		public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			int i = service.delete(id);
			if(i>0) {
				response.getWriter().write("true");
			}
		}
		
		//根据id查询IllCard
		public void findIllcardById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//获取参数
			int id = Integer.parseInt(request.getParameter("id"));
			//根据id查慢病表
			List<IllCard> li = service.findIllcardById(id);
			//查询所有慢性病
			ChronicdisService cs = new ChronicdisServiceImpl();
			List <Chronicdis> Chronicdis = cs.findAllChronicdis();
			request.setAttribute("lc", Chronicdis);
			request.setAttribute("li", li);
			request.getRequestDispatcher("/view/system/illcard/illcard_edit.jsp").forward(request, response);
		}
		
		//更新慢性病信息
		public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		  //获取参数
			//获取请求参数
			int id = Integer.parseInt(request.getParameter("id"));
			String xm = request.getParameter("xm");//姓名
			String nhzh = request.getParameter("nhzh");//农合证号
			String sfzh = request.getParameter("sfzh");//身份证号
			String illCardId = request.getParameter("illCardId");//慢病证号
			String illName = request.getParameter("illname");//疾病名称
			String startTime = request.getParameter("startTime");//开始时间
			String endTime = request.getParameter("endTime");//结束时间
			
			//声明变量
			IllCard ic = new IllCard();
			ic.setId(id);
			ic.setXm(xm);
			ic.setNhzh(nhzh);
			ic.setSfzh(sfzh);
			ic.setIllCardId(illCardId);
			ic.setIllName(illName);
			ic.setStartTime(startTime);
			ic.setEndTime(endTime);
			
			int i = service.update(ic);
			if(i>0) {
				request.setAttribute("url", "system/illcard?method=findIllCard&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
		}
		
		   //导出Excel表格方法
		   public void exportXls(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException { 
				//姓名
				String xm = request.getParameter("xm");
				System.out.println("xm="+xm);
				request.setAttribute("xm", xm);
				//查询慢性表信息
		    	List<IllCard> list = service.getAll(xm);
		    	
		    	
				createExcel(list,response);
		   }

		private void createExcel(List<IllCard> list, HttpServletResponse response) {
			//创建一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建一个工作表
			HSSFSheet sheet = workbook.createSheet("慢病证信息");
			
			CellRangeAddress region = new CellRangeAddress(0, // first row
	                0, // last row
	                0, // first column
	                6 // last column
	        );
            sheet.addMergedRegion(region);
	        
	        HSSFRow hssfRow = sheet.createRow(0);
	        HSSFCell headCell = hssfRow.createCell(0);
	        headCell.setCellValue("慢病证信息");
	        
	        // 设置单元格格式居中
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        headCell.setCellStyle(cellStyle);
	        // 添加表头行
	        hssfRow = sheet.createRow(1);
	        
	        // 添加表头内容
	        headCell = hssfRow.createCell(0);
	        headCell.setCellValue("姓名");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(1);
	        headCell.setCellValue("慢病证号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(2);
	        headCell.setCellValue("农合证号");
	        headCell.setCellStyle(cellStyle);
	        
	        
	        headCell = hssfRow.createCell(3);
	        headCell.setCellValue("身份证号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(4);
	        headCell.setCellValue("慢性病名称");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(5);
	        headCell.setCellValue("开始时间");
	        headCell.setCellStyle(cellStyle);
	        
	        headCell = hssfRow.createCell(6);
	        headCell.setCellValue("结束时间");
	        headCell.setCellStyle(cellStyle);

	        
	        
	     // 添加数据内容
	        for (int i = 0; i <list.size() ; i++) {
	            hssfRow = sheet.createRow((int) i + 2);
	            IllCard ill = list.get(i);

	            // 创建单元格，并设置值
	            HSSFCell cell = hssfRow.createCell(0);
	            cell.setCellValue(ill.getXm());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(1);
	            cell.setCellValue(ill.getIllCardId());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(2);
	            cell.setCellValue(ill.getNhzh());
	            cell.setCellStyle(cellStyle);
	            
	            
	            cell = hssfRow.createCell(3);
	            cell.setCellValue(ill.getSfzh());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(4);
	            cell.setCellValue(ill.getIllName());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(5);
	            cell.setCellValue(ill.getStartTime());
	            cell.setCellStyle(cellStyle);
	            
	            cell = hssfRow.createCell(6);
	            cell.setCellValue(ill.getEndTime());
	            cell.setCellStyle(cellStyle);
	            
	        }
	        
	        // 保存Excel文件
	        try {
	        	response.setContentType("application/vnd.ms-excel");
	        	
	        	response.setHeader("Content-disposition", "attachment;filename=illcard.xls");//附件形式下载，文件名叫duty.xls
	        	//OutputStream outputStream = new FileOutputStream("D:/duty.xls");//保存到本地（服务器端）
	        	OutputStream outputStream = response.getOutputStream();	 //写到客户端       	
	            workbook.write(outputStream);
	            outputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}
   
}
