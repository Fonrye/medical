package com.gxuwz.medical.sfy.system.web.family;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.system.service.AreaService;
import com.gxuwz.medical.sfy.system.service.FamilyService;
import com.gxuwz.medical.sfy.system.service.FamilyholdService;
import com.gxuwz.medical.sfy.system.service.impl.AreaServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.FamilyServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.FamilyholdServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class FamilyServlet
 */
@WebServlet("/system/family")
public class FamilyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	FamilyService fs = new FamilyServiceImpl();
	
   //查询家庭档案信息
	public void findAllFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
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
    	request.getRequestDispatcher("/view/system/family/family_list.jsp").forward(request, response);
	}
	
	//查询所有行政区域
	public void findAllArea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		   AreaService as = new AreaServiceImpl();
		   List <Area> la = as.findAllArea();
		  
		   request.setAttribute("listArea", la);
		   
		   request.getRequestDispatcher("/view/system/family/family_add.jsp").forward(request, response);
	}
	
	//根据组编号自动生成家庭编号
	public void addNo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String zbh = request.getParameter("zbh");
		String jtbh = fs.createCode(zbh);
		
		response.getWriter().write(new Gson().toJson(jtbh));
//		request.setAttribute("jtbh", jtbh);
//		request.getRequestDispatcher("/view/system/family/family_add.jsp").forward(request, response);
	}
	
	//添加家庭档案信息
	public void addFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取页面数据
		String xjbh = request.getParameter("xjbh");
		String xzbh = request.getParameter("xzbh");
		String cbh = request.getParameter("cbh");
		String zbh = request.getParameter("zbh");
		
		
		String jtbh = request.getParameter("jtbh");
		String hsx = request.getParameter("hsx");
		String hzxm = request.getParameter("hzxm");
		String jtrks = request.getParameter("jtrks");
		String nyrks = request.getParameter("nyrks");
		String jtdz = request.getParameter("jtdz");
		String cjdasj = request.getParameter("cjdasj");
		String djy = request.getParameter("djy");
		
		Family family = new Family(xjbh,xzbh,cbh,zbh,jtbh,hsx,hzxm,jtrks,nyrks,jtdz,cjdasj,djy);
		
		FamilyholdService fhs = new FamilyholdServiceImpl();
		Familyhold familyhold = new Familyhold();
		familyhold.setJtbh(jtbh);
		familyhold.setHnbh("01");
		familyhold.setMoneyState("0");
		int m = fhs.addMamilyhold(familyhold);
		
		int i = fs.addFamily(family);
		if(i>0 || m>0) {
			request.setAttribute("url", "system/family?method=findAllFamily&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}

	//根据jtbh查询家庭档案信息
	public void findByFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String jtbh = request.getParameter("jtbh");
		Family family = fs.findByFamily(jtbh);
		
		AreaService as = new AreaServiceImpl();
		List <Area> la = as.findAllArea();
		
		request.setAttribute("listArea", la);
		request.setAttribute("family", family);
		request.getRequestDispatcher("/view/system/family/family_edit.jsp").forward(request, response);
	}
	
	//修改家庭档案信息
	public void updateFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取页面数据
		String xjbh = request.getParameter("xjbh");
		String xzbh = request.getParameter("xzbh");
		String cbh = request.getParameter("cbh");
		String zbh = request.getParameter("zbh");
		String jtbh = request.getParameter("jtbh");
		String hsx = request.getParameter("hsx");
		String hzxm = request.getParameter("hzxm");
		String jtrks = request.getParameter("jtrks");
		String nyrks = request.getParameter("nyrks");
		String jtdz = request.getParameter("jtdz");
		String cjdasj = request.getParameter("cjdasj");
		String djy = request.getParameter("djy");
		
		Family family = new Family(xjbh,xzbh,cbh,zbh,jtbh,hsx,hzxm,jtrks,nyrks,jtdz,cjdasj,djy);
		int i = fs.update(family);
		if(i>0) {
			request.setAttribute("url", "system/family?method=findAllFamily&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//删除家庭档案信息
	public void deleteFamily(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String jtbh = request.getParameter("jtbh");
		int i = fs.delete(jtbh);
		if(i==1) {
			response.getWriter().write("true");
		}
	}
	
	//验证家庭编号是否存在
	 public void checkJtbh(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 String jtbh = request.getParameter("jtbh");
		 Family family = fs.check(jtbh);
		 if(family != null) {
	    		
	    		response.getWriter().write("true");
	    	}else {
	    		response.getWriter().write("false");
	    		
			}
	 }
	 
	 //联动查询行政区域
	 public void findArea(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// 获取请求信息
			String areaCode = request.getParameter("areaCode");
			String grade = request.getParameter("grade");
			
			AreaService as = new AreaServiceImpl();
			List<Area> list = as.findByIdArea(areaCode, grade);
           
			response.getWriter().write(new Gson().toJson(list));
		}
}
