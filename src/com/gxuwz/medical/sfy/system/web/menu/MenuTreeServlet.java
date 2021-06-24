package com.gxuwz.medical.sfy.system.web.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gxuwz.medical.sfy.domain.MenuTree;
import com.gxuwz.medical.sfy.system.service.MenuTreeService;
import com.gxuwz.medical.sfy.system.service.impl.MenuTreeServiceImpl;

/**
 * Servlet implementation class MenuTreeServlet
 */
@WebServlet("/MenuTreeServlet")
public class MenuTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MenuTreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取后台数据
		response.setContentType("text/html;charset=utf-8");
		MenuTreeService mts = new MenuTreeServiceImpl();
		List<MenuTree> lm = mts.TreeShow();
		System.out.println("MenuTreeServlet======================"+lm.get(0));
		response.getWriter().write(new Gson().toJson(lm));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
