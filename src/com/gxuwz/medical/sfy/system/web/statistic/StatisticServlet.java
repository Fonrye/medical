package com.gxuwz.medical.sfy.system.web.statistic;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.ChronicdisService;
import com.gxuwz.medical.sfy.system.service.StatisticService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.StatisticServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;


@WebServlet("/system/statistic")
public class StatisticServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	StatisticService service = new StatisticServiceImpl();
	
	//查询所有行政区域
	public void allArea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 AreaService as = new AreaServiceImpl();
		 List <Area> la = as.findAllArea();
		 response.getWriter().println(new Gson().toJson(la));
	}
	
	//查询所有病种
	public void allChronicdis(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ChronicdisService cs = new ChronicdisServiceImpl();
		List <Chronicdis> Chronicdis = cs.findAllChronicdis();
		response.getWriter().println(new Gson().toJson(Chronicdis));
	}
      
	//分页查询所有报销信息
			public void findAllReim(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
				//获取请求数据
				String name = request.getParameter("name");
				request.setAttribute("name", name);
				
				String startTime = request.getParameter("startTime");
				request.setAttribute("startTime", startTime);
				
				String endTime = request.getParameter("endTime");
				request.setAttribute("endTime", endTime);
				
				String illName = request.getParameter("illName");
				request.setAttribute("illName", illName);
				
				String areaCode = request.getParameter("areaCode");
				
				String sindex = request.getParameter("index");
		    	int index = 1;
		    	try {
					index = Integer.parseInt(sindex);
				} catch (NumberFormatException n) {
					n.printStackTrace();
				}
		    	PageBean<Reimbursement> pr = new PageBean<Reimbursement>();
		    	pr.setIndex(index);
		    	service.pageReim(pr,name,startTime,endTime,illName,areaCode);
		    	request.setAttribute("pr", pr);
		    	request.getRequestDispatcher("/view/system/statistic/statistic_list.jsp").forward(request, response);
		    	
		    	
			}
			
			 //导出Excel表格方法
			public void exportXls(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				//获取请求数据
				String name = request.getParameter("name");
				
				String startTime = request.getParameter("startTime");
				
				String endTime = request.getParameter("endTime");
				
				String illName = request.getParameter("illName");
				
				String areaCode = request.getParameter("areaCode");
				
				List<Reimbursement> lr = service.getAllReim(name,startTime,endTime,illName,areaCode);
				
				createExcel(lr,response);
			}

			private void createExcel(List<Reimbursement> lr, HttpServletResponse response) {
				//创建一个Excel文件
				HSSFWorkbook workbook = new HSSFWorkbook();
				// 创建一个工作表
				HSSFSheet sheet = workbook.createSheet("慢病报销情况信息");
				
				CellRangeAddress region = new CellRangeAddress(0, // first row
		                0, // last row
		                0, // first column
		                6 // last column
		        );
	            sheet.addMergedRegion(region);
		        
		        HSSFRow hssfRow = sheet.createRow(0);
		        HSSFCell headCell = hssfRow.createCell(0);
		        headCell.setCellValue("慢病报销情况信息");
		        
		        // 设置单元格格式居中
		        HSSFCellStyle cellStyle = workbook.createCellStyle();
		    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        headCell.setCellStyle(cellStyle);
		        // 添加表头行
		        hssfRow = sheet.createRow(1);
		        
		        // 添加表头内容
		        headCell = hssfRow.createCell(0);
		        headCell.setCellValue("报销人姓名");
		        headCell.setCellStyle(cellStyle);

		        headCell = hssfRow.createCell(1);
		        headCell.setCellValue("身份证号");
		        headCell.setCellStyle(cellStyle);

		        headCell = hssfRow.createCell(2);
		        headCell.setCellValue("疾病名称");
		        headCell.setCellStyle(cellStyle);
		        
		        headCell = hssfRow.createCell(3);
		        headCell.setCellValue("缴费总金额");
		        headCell.setCellStyle(cellStyle);

		        headCell = hssfRow.createCell(4);
		        headCell.setCellValue("报销金额");
		        headCell.setCellStyle(cellStyle);
		        
		        headCell = hssfRow.createCell(5);
		        headCell.setCellValue("报销状态");
		        headCell.setCellStyle(cellStyle);

		        headCell = hssfRow.createCell(6);
		        headCell.setCellValue("报销时间");
		        headCell.setCellStyle(cellStyle);

		        // 添加数据内容
		        for (int i = 0; i <lr.size() ; i++) {
		            hssfRow = sheet.createRow((int) i + 2);
		            Reimbursement reim = lr.get(i);

		            // 创建单元格，并设置值
		            HSSFCell cell = hssfRow.createCell(0);
		            cell.setCellValue(reim.getName());
		            cell.setCellStyle(cellStyle);

		            cell = hssfRow.createCell(1);
		            cell.setCellValue(reim.getSfzh());
		            cell.setCellStyle(cellStyle);

		            cell = hssfRow.createCell(2);
		            cell.setCellValue(reim.getIllname());
		            cell.setCellStyle(cellStyle);
		            
		            
		            cell = hssfRow.createCell(3);
		            cell.setCellValue(reim.getIllMoney());
		            cell.setCellStyle(cellStyle);

		            cell = hssfRow.createCell(4);
		            cell.setCellValue(reim.getMoney());
		            cell.setCellStyle(cellStyle);

		            cell = hssfRow.createCell(5);
		            cell.setCellValue(reim.getStatus());
		            cell.setCellStyle(cellStyle);
		            
		            cell = hssfRow.createCell(6);
		            cell.setCellValue(reim.getBxsj());
		            cell.setCellStyle(cellStyle);
		            
		        }
		     // 保存Excel文件
		        try {
		        	response.setContentType("application/vnd.ms-excel");
		        	
		        	response.setHeader("Content-disposition", "attachment;filename=reim.xls");//附件形式下载，文件名叫duty.xls
		        	//OutputStream outputStream = new FileOutputStream("D:/reim.xls");//保存到本地（服务器端）
		        	OutputStream outputStream = response.getOutputStream();	 //写到客户端       	
		            workbook.write(outputStream);
		            outputStream.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
			}
}
