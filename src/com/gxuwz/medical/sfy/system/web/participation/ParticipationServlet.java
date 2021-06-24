package com.gxuwz.medical.sfy.system.web.participation;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.FamilyService;
import com.gxuwz.medical.sfy.system.service.ParticipationService;
import com.gxuwz.medical.sfy.system.service.SwitchService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.FamilyServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ParticipationServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.SwitchServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class ParticipationServlet
 */
@WebServlet("/system/participation")
public class ParticipationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	ParticipationService ps = new ParticipationServiceImpl();
	
	   //查询家庭档案户主信息
		public void findAllFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	        
			FamilyService fs = new FamilyServiceImpl();
			String sindex = request.getParameter("index");
	    	int index = 1;
	    	try {
				index = Integer.parseInt(sindex);
			} catch (NumberFormatException n) {
				n.printStackTrace();
			}
	    	//条件查询
	    	String hzxm = request.getParameter("hzxm");
	    	
	    	PageBean<Family> pf = new PageBean<Family>();
	    	pf.setIndex(index);
	    	fs.pageFamily(pf,hzxm);
	    	
	    	request.setAttribute("pf", pf);
	    	request.setAttribute("hzxm", hzxm);
	    	request.getRequestDispatcher("/view/system/participation/familyholdAll_list.jsp").forward(request, response);
		}  
		
		//查询需要缴费的家庭成员
		public void findAllById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//接收家庭编号
			String jtbh = request.getParameter("jtbh");
			
			//查询家庭参合人员列表
			List<Familyhold> lfh = ps.findAllFamilyhold(jtbh);
			//List<Familyhold> lfh1 = new ArrayList<Familyhold>();
			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
		     String jfnd = sdf.format(new Date());
		     
		     //查询本年度是否在参合缴费时间内
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		     //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		     String jfsj = df.format(new Date());
		     
		     Tswitch tswitch = ps.findById(jfsj,jfnd);
		     
			if(tswitch == null) {
				response.getWriter().write("true");
			}else {
				//查询所有参合登记成员
				List<Participation> lp = ps.getAllParticipation();
				
				//判断是否已经登记过并且是当前年份
				for(int j=0;j<lp.size();j++) {
					for(int i=0;i<lfh.size();i++) {
						if(lfh.get(i).getSfzh().equals(lp.get(j).getSfzh())&&lp.get(j).getJfnd().equals(jfnd)) {
							lfh.remove(i);
						}
					}
				}
				if(lfh.size()==0) {
					response.getWriter().write("false");
				}else {
					request.setAttribute("familyhold", lfh);
					request.getRequestDispatcher("/view/system/participation/participation_add.jsp").forward(request, response);
				}
				
			}
		     
			
		}

		//页面显示缴费总金额
		public void allMoney(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			String se = request.getParameter("se");

			//查询个人缴费金额
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	        //System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间
	        String jfnd = sdf.format(new Date());
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	        String jfsj = df.format(new Date());
	        Tswitch tswitch = ps.findById(jfsj,jfnd);
	        String money1 = tswitch.getMoney();

			Double money = (Double.parseDouble(money1));
			int s = (Integer.parseInt(se));
			double max = money*s;
			response.getWriter().write(new Gson().toJson(max));
		}
		
		//参合缴费登记
		public void getDate(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			
			
			//获取农合证号
			String [] chzh = request.getParameterValues("nhzh");
			
			//获取家庭编号
			String [] jtbh = request.getParameterValues("jtbh");
		
			//获取身份号码
			String [] sfzh = request.getParameterValues("sfzh");
			String [] xm = request.getParameterValues("xm");
			//String money1 = request.getParameter("money");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	        String jfsj = df.format(new Date());
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	        //System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间
	        String jfnd = sdf.format(new Date());
	        
	        String czy = request.getParameter("czy");
	    
	        //查询个人缴费金额
	        Tswitch tswitch = ps.findById(jfsj,jfnd);
	        Double money = Double.parseDouble(tswitch.getMoney());
	       
	        int i = ps.saveParticipation(chzh,jtbh,sfzh,jfsj,jfnd,money,czy,xm);
	        if(i>0 ) {
				request.setAttribute("url", "system/participation?method=findAll&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
	        
	       
		}
		
		//查询所有参合登记成员信息
		public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//获取行政区域编号
			String areaCode = request.getParameter("areaCode");
			request.setAttribute("areaCode", areaCode);
			//姓名
			String xm = request.getParameter("xm");
			request.setAttribute("xm", xm);
			//获取年份
			String jfnd = request.getParameter("jfnd");
			request.setAttribute("jfnd", jfnd);
			//缴费起始时间、缴费结束时间
			String qssj = request.getParameter("qssj");
			request.setAttribute("qssj", qssj);
			String jssj = request.getParameter("jssj");
			request.setAttribute("jssj", jssj);
			
			//if(jssj.equals(arg0))
			//System.out.println(jfnd+" "+areaCode+" "+xm+" "+qssj+" "+jssj);
			String sindex = request.getParameter("index");
	    	int index = 1;
	    	try {
				index = Integer.parseInt(sindex);
			} catch (NumberFormatException n) {
				n.printStackTrace();
			}
			
	    	//分页查询所有参合登记员
	    	PageBean<Participation> pp = new PageBean<Participation>();
	    	pp.setIndex(index);
	    	ps.pageParticipation(pp,jfnd,qssj,jssj,areaCode,xm);
	    	
	    	request.setAttribute("pp", pp);
	    	request.getRequestDispatcher("/view/system/participation/participation_list.jsp").forward(request, response);
		}
		
		//查询所有行政区域
		   public void findAllArea(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			   AreaService as = new AreaServiceImpl();
			   List <Area> la = as.findAllArea();
			   response.getWriter().println(new Gson().toJson(la));
		   }
		   
		   //判断是否是本年度缴费
		  
		   public void findAllYear(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			  
			   List<Participation> lp = ps.getAllParticipation();
			   for(int i=0;i<lp.size()-1;i++) {
				   for(int j=lp.size()-1;j>i;j--) {
					   if(lp.get(j).getJfnd().equals(lp.get(i).getJfnd())) {
						   lp.remove(j);
					   }
				   }
			   }
			   response.getWriter().println(new Gson().toJson(lp));
		   }
		   
		   //导出Excel表格方法
		   public void exportXls(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException { 
			 //获取行政区域编号
				String areaCode = request.getParameter("areaCode");
				//姓名
				String xm = request.getParameter("xm");
				request.setAttribute("xm", xm);
				//获取年份
				String jfnd = request.getParameter("jfnd");
				request.setAttribute("jfnd", jfnd);
				//缴费起始时间、缴费结束时间
				String qssj = request.getParameter("qssj");
				request.setAttribute("qssj", qssj);
				String jssj = request.getParameter("jssj");
				request.setAttribute("jssj", jssj);
				
				
				//System.out.println(jfnd+" "+areaCode+" "+xm+" "+qssj+" "+jssj);
				
		    	List<Participation> lp = ps.getAllPart(jfnd,qssj,jssj,areaCode,xm);
		    	
				createExcel(lp,response);
		   }

		private static void createExcel(List<Participation> lp, HttpServletResponse response) {
			//创建一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建一个工作表
			HSSFSheet sheet = workbook.createSheet("参合登记信息");
			
			CellRangeAddress region = new CellRangeAddress(0, // first row
	                0, // last row
	                0, // first column
	                8 // last column
	        );
            sheet.addMergedRegion(region);
	        
	        HSSFRow hssfRow = sheet.createRow(0);
	        HSSFCell headCell = hssfRow.createCell(0);
	        headCell.setCellValue("参合缴费登记信息");
	        
	        // 设置单元格格式居中
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        headCell.setCellStyle(cellStyle);
	        // 添加表头行
	        hssfRow = sheet.createRow(1);
	        
	        // 添加表头内容
	        headCell = hssfRow.createCell(0);
	        headCell.setCellValue("参合证号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(1);
	        headCell.setCellValue("参合发票号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(2);
	        headCell.setCellValue("家庭编号");
	        headCell.setCellStyle(cellStyle);
	        
	        
	        headCell = hssfRow.createCell(3);
	        headCell.setCellValue("姓名");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(4);
	        headCell.setCellValue("缴费金额");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(5);
	        headCell.setCellValue("缴费年度");
	        headCell.setCellStyle(cellStyle);
	        
	        headCell = hssfRow.createCell(6);
	        headCell.setCellValue("缴费时间");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(7);
	        headCell.setCellValue("身份证号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(8);
	        headCell.setCellValue("操作员");
	        headCell.setCellStyle(cellStyle);
	        
	     // 添加数据内容
	        for (int i = 0; i <lp.size() ; i++) {
	            hssfRow = sheet.createRow((int) i + 2);
	            Participation pa = lp.get(i);

	            // 创建单元格，并设置值
	            HSSFCell cell = hssfRow.createCell(0);
	            cell.setCellValue(pa.getChzh());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(1);
	            cell.setCellValue(pa.getChfph());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(2);
	            cell.setCellValue(pa.getJtbh());
	            cell.setCellStyle(cellStyle);
	            
	            
	            cell = hssfRow.createCell(3);
	            cell.setCellValue(pa.getXm());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(4);
	            cell.setCellValue(pa.getJfje());
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(5);
	            cell.setCellValue(pa.getJfnd());
	            cell.setCellStyle(cellStyle);
	            
	            cell = hssfRow.createCell(6);
	            cell.setCellValue(pa.getJfsj());
	            cell.setCellStyle(cellStyle);
	            
	            cell = hssfRow.createCell(7);
	            cell.setCellValue(pa.getSfzh());
	            cell.setCellStyle(cellStyle);
	            
	            cell = hssfRow.createCell(8);
	            cell.setCellValue(pa.getCzy());
	            cell.setCellStyle(cellStyle);
	        }
	        
	        // 保存Excel文件
	        try {
	        	response.setContentType("application/vnd.ms-excel");
	        	
	        	response.setHeader("Content-disposition", "attachment;filename=dengjibiao.xls");//附件形式下载，文件名叫duty.xls
	        	//OutputStream outputStream = new FileOutputStream("D:/duty.xls");//保存到本地（服务器端）
	        	OutputStream outputStream = response.getOutputStream();	 //写到客户端       	
	            workbook.write(outputStream);
	            outputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		   
}
