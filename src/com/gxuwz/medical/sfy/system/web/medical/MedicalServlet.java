package com.gxuwz.medical.sfy.system.web.medical;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.medical.Medical;
import com.gxuwz.medical.sfy.domain.medical.S201;
import com.gxuwz.medical.sfy.system.service.MedicalService;
import com.gxuwz.medical.sfy.system.service.impl.MedicalServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class MedicalServlet
 */
@WebServlet("/system/medical")
public class MedicalServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    MedicalService ms = new MedicalServiceImpl();
    
    //查询医疗机构信息
    public void findAllMedical(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	String sindex = request.getParameter("index");
    	
    	int index = 1;
    	try {
			index = Integer.parseInt(sindex);
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}
    	
    	PageBean<Medical> pm = new PageBean<Medical>();
    	pm.setIndex(index);
    	ms.pageMedical(pm);
    	
    	request.setAttribute("pm", pm);
    	request.getRequestDispatcher("/view/system/medical/medical_list.jsp").forward(request, response);
    }

    
    public void findAllS201(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	List<S201> ls = ms.findAllS201();
    	request.setAttribute("listS201", ls);
    	request.getRequestDispatcher("/view/system/medical/medical_add.jsp").forward(request, response);
    }
    
    //添加医疗机构信息
    public void addMedical(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	//获取页面页面数据
    	String jgbm=request.getParameter("jgbm");
		String zzjgbm=request.getParameter("zzjgbm");
		String jgmc=request.getParameter("jgmc");
		String dqbm=request.getParameter("dqbm");
		String areacode=request.getParameter("areacode");
		String lsgx=request.getParameter("lsgx");
		String jgjb=request.getParameter("jgjb");
		String sbddlx=request.getParameter("sbddlx");
		String pzddlx=request.getParameter("pzddlx");
		String ssjjlx=request.getParameter("ssjjlx");
		String wsjgdl=request.getParameter("wsjgdl");
		String wsjgxl=request.getParameter("wsjgxl");
		String zgdw=request.getParameter("zgdw");
		String kysj=request.getParameter("kysj");//日期
		String frdb=request.getParameter("frdb");
		double zczj=Double.parseDouble(request.getParameter("zczj"));//数值		
		
		Medical medical = new Medical(jgbm,zzjgbm,jgmc,dqbm,areacode,lsgx,jgjb,sbddlx,pzddlx,ssjjlx,wsjgdl,wsjgxl,zgdw,kysj,frdb,zczj);
		
		int i = ms.saveMedical(medical);
		if(i>0) {
			request.setAttribute("url", "system/medical?method=findAllMedical&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
    }
    
    //查询要修改的用户信息
    public void findById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	String jgbm=request.getParameter("jgbm");
    	
    	Medical medical = ms.findById(jgbm);
    	request.setAttribute("medical", medical);
    	
    	List<S201> ls = ms.findAllS201();
    	request.setAttribute("listS201", ls);
    	
    	request.getRequestDispatcher("/view/system/medical/medical_edit.jsp").forward(request, response);
    	
    }
    
    //修改医疗机构信息
    public void updateMedical(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//获取页面页面数据
    	String jgbm=request.getParameter("jgbm");
		String zzjgbm=request.getParameter("zzjgbm");
		String jgmc=request.getParameter("jgmc");
		String dqbm=request.getParameter("dqbm");
		String areacode=request.getParameter("areacode");
		String lsgx=request.getParameter("lsgx");
		String jgjb=request.getParameter("jgjb");
		String sbddlx=request.getParameter("sbddlx");
		String pzddlx=request.getParameter("pzddlx");
		String ssjjlx=request.getParameter("ssjjlx");
		String wsjgdl=request.getParameter("wsjgdl");
		String wsjgxl=request.getParameter("wsjgxl");
		String zgdw=request.getParameter("zgdw");
		String kysj=request.getParameter("kysj");//日期
		String frdb=request.getParameter("frdb");
		double zczj=Double.parseDouble(request.getParameter("zczj"));//数值		
		
		Medical medical = new Medical(jgbm,zzjgbm,jgmc,dqbm,areacode,lsgx,jgjb,sbddlx,pzddlx,ssjjlx,wsjgdl,wsjgxl,zgdw,kysj,frdb,zczj);
		
		int i = ms.update(medical);
		if(i>0) {
			request.setAttribute("url", "system/medical?method=findAllMedical&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
    }
    
    //删除医疗机构信息
    public void deleteMedical(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	String jgbm = request.getParameter("jgbm");
    	int i = ms.deleteMedical(jgbm);
    	System.out.println(i);
    	if(i>0) {
    		response.getWriter().write("true");
		}
    }
    
    //验证机构编码是否存在
    public void checkJgbm(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	String jgbm = request.getParameter("jgbm");
    	
    	Medical medical = ms.findById(jgbm);
    	if(medical != null) {
    		
    		response.getWriter().write("true");
    	}else {
    		response.getWriter().write("false");
    		
		}
    }
}
