package com.gxuwz.medical.sfy.system.web.area;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class AreaServlet
 */
@WebServlet("/system/area")
public class AreaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	 AreaService as = new AreaServiceImpl();
	
   //行政区域分页显示
   public void findArea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	   //获取响应数据
	   String sindex = request.getParameter("index");
	   int index = 1;
	   try {
		   index = Integer.parseInt(sindex);
	     }catch (NumberFormatException n) {
		   n.printStackTrace();
	     }
	   
	   PageBean<Area> pa = new PageBean<Area>();
	   pa.setIndex(index);  //设置展示的当前页面
	   as.pageArea(pa);
	   request.setAttribute("pa", pa);
	   request.getRequestDispatcher("/view/system/area/area_list.jsp").forward(request, response);
   }
   
   //查询所有行政区域
   public void findAllArea(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	   List <Area> la = as.findAllArea();
	   request.setAttribute("la", la);
	   request.getRequestDispatcher("/view/system/area/area_add.jsp").forward(request, response);
   }

   //添加行政区域
   public void addArea(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	 //获取请求数据
	   String area = request.getParameter("area");
	   String newareaName = request.getParameter("areaName");//新行政区域名称
	 //将option的value值分割
	   String [] areaA = area.split(",");
	   String oldareaCode= areaA[0];//所属的行政区域编号
	   String oldgrade = areaA[1];//所属的行政区域等级
	   boolean mark = as.addArea(oldareaCode,oldgrade,newareaName);
	   if(mark) {
		   request.setAttribute("url", "system/area?method=findArea&&index=1");
		   request.getRequestDispatcher("../tips.jsp").forward(request, response);
	   }
   }
   
   //根据areaId查询行政区域
   public void findAreaByAreaId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	 //获取请求数据
	 String areaCode = request.getParameter("areaCode");
	 //处理请求
	 List<Area> la = as.findAreaById(areaCode);
	 request.setAttribute("la", la);
		request.getRequestDispatcher("/view/system/area/area_edit.jsp").forward(request, response);
   }
   
   //修改行政区域
   public void updateArea(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	   String areaCode = request.getParameter("areaCode");
	   String areaName = request.getParameter("areaName");
	   Area area = new Area();
	   area.setAreaCode(areaCode);
	   area.setAreaName(areaName);
	   boolean mark = as.updateArea(area);
	   if(mark) {
			request.setAttribute("url", "system/area?method=findArea&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
   }
   
   //根据areaCode删除行政区域
   public void deleteArea(HttpServletRequest request,HttpServletResponse response) throws IOException {
	   //获取数据
	   String areaCode = request.getParameter("areaCode");
	   List<Area> la = as.findAreaById(areaCode);
	   int grade = la.get(0).getGrade();
	   if(as.deleteArea(areaCode,grade)) {
		   response.getWriter().write("true");
	   }
   }
}
