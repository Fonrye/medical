package com.gxuwz.medical.sfy.system.web.tswitch;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.tswitch.Tswitch;
import com.gxuwz.medical.sfy.system.service.SwitchService;
import com.gxuwz.medical.sfy.system.service.impl.SwitchServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;


@WebServlet("/system/switch")
public class SwitchServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	SwitchService ss = new SwitchServiceImpl();
	
	//查询设置缴费年度信息
	public void findAllSwitch(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取响应数据
		String sindex = request.getParameter("index");
		String year = request.getParameter("year");
		
	    int index = 1;
		try {
			index = Integer.parseInt(sindex);
		    }catch (NumberFormatException n) {
			  n.printStackTrace();
		    }
		PageBean<Tswitch> pt = new PageBean<Tswitch>();
		pt.setIndex(index);
		ss.pageSwitch(pt,year);
		
		request.setAttribute("year", year);
		request.setAttribute("pt", pt);
		request.getRequestDispatcher("/view/system/switch/switch_list.jsp").forward(request, response);
	}
       
	//添加设置缴费年度信息
	public void addSwitch(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String money = request.getParameter("money");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String year = request.getParameter("year");
		
		      
        Tswitch tswitch = new Tswitch();
        tswitch.setYear(year);
        tswitch.setMoney(money);
        tswitch.setStart(start);
        tswitch.setEnd(end);
        
        int i = ss.addSwitch(tswitch);
        if(i>0) {
           request.setAttribute("url", "system/switch?method=findAllSwitch&&index=1");
  		   request.getRequestDispatcher("../tips.jsp").forward(request, response);
        }
        
	}
	
	//根据year查询该年度是否存在
	public void checkYear(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String year = request.getParameter("year");
		Tswitch tswitch = ss.checkYear(year);
		if(tswitch != null) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
		
	}
	
	//修改设置缴费年度信息
	public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取要修改的信息
		String year = request.getParameter("year");
		String money1 = request.getParameter("money");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Double money = Double.parseDouble(money1);
		int i = ss.update(year,money,start,end);
		if(i>0) {
			 request.setAttribute("url", "system/switch?method=findAllSwitch&&index=1");
	  		 request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
		
	}
	
	//删除年度参合缴费信息
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		int i = ss.delete(year);
		if(i>0) {
			response.getWriter().write("true");
		}
	}
		
   
}
