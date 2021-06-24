package com.gxuwz.medical.sfy.system.web.institution;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.institution.Institution;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.InstitutionService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.InstitutionServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class InstitutionServlet
 */
@WebServlet("/system/institution")
public class InstitutionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	InstitutionService is = new InstitutionServiceImpl();
	
    //农合经办机构分页显示
	public void findInstitution (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		//获取数据
		String sindex = request.getParameter("index");
		int index = 1;
		try {
			index = Integer.parseInt(sindex);
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}
		//查询所有行政区域
		AreaService as = new AreaServiceImpl();
		List<Area> la = as.findAllArea();
		//分页
		PageBean<Institution> pi = new PageBean<Institution>();
		pi.setIndex(index);//设置展示的当前页数
		is.pageInstitution(pi);
		request.setAttribute("pi", pi);
		request.setAttribute("la", la);
		request.getRequestDispatcher("/view/system/institution/institution_list.jsp").forward(request, response);
	}
	
	//查询所有行政区域
	public void findAllArea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		AreaService as = new AreaServiceImpl();
		List<Area> la = as.findAllArea();
		if(la != null) {
			request.setAttribute("la", la);
			request.getRequestDispatcher("/view/system/institution/institution_add.jsp").forward(request, response);
		}
	}

	//添加农合经办机构
	public void addIns(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取页面数据
		String area = request.getParameter("area");
		String agenCode = request.getParameter("agenCode");
		String agenName = request.getParameter("agenName");
		//处理请求
	    //将option的value值分割
		String[] areaA = area.split(",");
		String areaCode = areaA[0];  //所属的行政区域编号
		String grade1 = areaA[1];     //所属的行政区域等级
		int grade = Integer.parseInt(grade1);
		
		Institution institution = new Institution();
		institution.setAreaCode(areaCode);
		institution.setAgenCode(agenCode);
		institution.setAgenName(agenName);
		institution.setGrade(grade);
		
		boolean mark = is.addIns(institution);
		System.out.println("添加农合经办机构"+mark);
		if(mark) {
			request.setAttribute("url", "system/institution?method=findInstitution&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//根据AreaCode查询农合经办信息
	public void findInsByAreaCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String areaCode = request.getParameter("areaCode");
		
		AreaService as = new AreaServiceImpl();
		List<Area> la = as.findAreaById(areaCode);
	  
	    
	    List<Institution> li = is.findIntAreacode(areaCode);
	    
	    request.setAttribute("li", li);
	    request.setAttribute("la", la);
	    request.getRequestDispatcher("/view/system/institution/institution_edit.jsp").forward(request, response);
	}
	
	//根据areaCode修改经办机构
	public void updateIns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String areaCode = request.getParameter("areaCode");
		String agenCode = request.getParameter("agenCode");
		String agenName = request.getParameter("agenName");
		
		boolean mark = is.updateIns(areaCode,agenCode,agenName);
		
		if(mark) {
			request.setAttribute("url", "system/institution?method=findInstitution&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//根据areaCode删除经办机构
	public void deleteIns(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String areaCode = request.getParameter("areaCode");
		
		if(is.deleteIns(areaCode)) {
			response.getWriter().write("true");
		}
	}
}
