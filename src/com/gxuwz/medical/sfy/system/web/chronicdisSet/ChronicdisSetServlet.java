package com.gxuwz.medical.sfy.system.web.chronicdisSet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.system.service.ChronicdisSetService;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisSetServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class ChronicdisSetServlet
 */
@WebServlet("/system/chronicdisSet")
public class ChronicdisSetServlet extends BaseServlet {
	
	ChronicdisSetService service = new ChronicdisSetServiceImpl();
	private static final long serialVersionUID = 1L;
       
   //查询设置报销慢性病信息
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取响应数据
		String sindex = request.getParameter("index");
		String illName = request.getParameter("illName");
		int index = 1;
		try {
			index = Integer.parseInt(sindex);
		    }catch (NumberFormatException n) {
			  n.printStackTrace();
		    }
		PageBean<ChronicdisSet> pc = new PageBean<ChronicdisSet>();
		pc.setIndex(index);
		service.pageAll(pc,illName);
		
		request.setAttribute("illName",illName);
		request.setAttribute("pa", pc);
		request.getRequestDispatcher("/view/system/chronicdisSet/set_list.jsp").forward(request, response);
		
	}
	
	//添加慢性病政策
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		String illName = request.getParameter("illName");
		String moneyCapping = request.getParameter("moneyCapping");
		String percentage = request.getParameter("percentage");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	    String year = sdf.format(new Date());
		
		ChronicdisSet set = new ChronicdisSet();
		set.setIllName(illName);
		set.setMoneyCapping(moneyCapping);
		set.setPercentage(percentage);
		set.setYear(year);
		
		int i = service.add(set);
		if(i>0) {
			request.setAttribute("url", "system/chronicdisSet?method=findAll&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//验证本年度该慢性病是否添加过
	public void check(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		String illName = request.getParameter("illName");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	    String year = sdf.format(new Date());
	    ChronicdisSet set = service.check(illName,year);
	    if(set != null) {
    		response.getWriter().write("true");
    	}else {
    		response.getWriter().write("false");
    		
		}
	}
	
	//删除慢病政策
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		int id = Integer.parseInt(request.getParameter("id"));
		int i = service.delete(id);
		if(i>0) {
			response.getWriter().write("true");
		}
	}
	
	//修改添加慢性病政策
		public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//获取数据
			int id = Integer.parseInt(request.getParameter("id"));
			String illName = request.getParameter("illName");
			String moneyCapping = request.getParameter("moneyCapping");
			String percentage = request.getParameter("percentage");
			String year = request.getParameter("year");
			
			ChronicdisSet set = new ChronicdisSet();
			set.setId(id);
			set.setIllName(illName);
			set.setMoneyCapping(moneyCapping);
			set.setPercentage(percentage);
			set.setYear(year);
			int i = service.update(set);
			if(i>0) {
				request.setAttribute("url", "system/chronicdisSet?method=findAll&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
			
		}

}
