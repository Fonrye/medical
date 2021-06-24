package com.gxuwz.medical.sfy.system.web.chronicdis;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.area.Area;
import com.gxuwz.medical.sfy.domain.chronicdis.Chronicdis;
import com.gxuwz.medical.sfy.system.service.ChronicdisService;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class ChronicdisServlet
 */
@WebServlet("/system/chronicdis")
public class ChronicdisServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	ChronicdisService cs = new ChronicdisServiceImpl();
	
	//慢性病信息分页显示
	public void findChronicdis(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取响应数据
		   String sindex = request.getParameter("index");
		   int index = 1;
		   try {
			   index = Integer.parseInt(sindex);
		     }catch (NumberFormatException n) {
			   n.printStackTrace();
		     }
		   PageBean<Chronicdis> pc = new PageBean<Chronicdis>();
		   pc.setIndex(index);
		   cs.pageChronicdis(pc);
		
		
		request.setAttribute("pc", pc);
		request.getRequestDispatcher("/view/system/chronicdis/chronicdis_list.jsp").forward(request, response);
	}
   
	//修改慢性病信息
	public void updateChr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String illCode = request.getParameter("illCode");
		String illName = request.getParameter("illName");
		String pyCode = request.getParameter("pyCode");
		String wbCode = request.getParameter("wbCode");
		
		Chronicdis chr = new Chronicdis();
		chr.setIllCode(illCode);
		chr.setIllName(illName);
		chr.setPyCode(pyCode);
		chr.setWbCode(wbCode);
		
		if(cs.updateChr(chr)) {
			request.setAttribute("url", "system/chronicdis?method=findChronicdis&&index=1");
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}

	//添加慢性病信息
		public void addChr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			String illCode = request.getParameter("illCode");
			String illName = request.getParameter("illName");
			String pyCode = request.getParameter("pyCode");
			String wbCode = request.getParameter("wbCode");
			
			Chronicdis chr = new Chronicdis();
			chr.setIllCode(illCode);
			chr.setIllName(illName);
			chr.setPyCode(pyCode);
			chr.setWbCode(wbCode);
			
			if(cs.addChr(chr)) {
				request.setAttribute("url", "system/chronicdis?method=findChronicdis&&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
		}
		
		//删除慢性病信息
		public void deleteChr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			String illCode = request.getParameter("illCode");
			boolean mark = cs.deleteChr(illCode);
			if(mark) {
				 response.getWriter().write("true");
			}
		}
		
		//查询所有慢性病
		public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			List <Chronicdis> Chronicdis = cs.findAllChronicdis();
			 request.setAttribute("Chronicdis", Chronicdis);
			 request.getRequestDispatcher("/view/system/chronicdisSet/set_add.jsp").forward(request, response);
		}
}
