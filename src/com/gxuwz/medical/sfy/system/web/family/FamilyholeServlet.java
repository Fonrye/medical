package com.gxuwz.medical.sfy.system.web.family;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.family.Family;
import com.gxuwz.medical.sfy.domain.family.Familyhold;
import com.gxuwz.medical.sfy.system.service.FamilyService;
import com.gxuwz.medical.sfy.system.service.FamilyholdService;
import com.gxuwz.medical.sfy.system.service.impl.FamilyServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.FamilyholdServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;

/**
 * Servlet implementation class FamilyholeServlet
 */
@WebServlet("/system/familyhold")
public class FamilyholeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	FamilyholdService fhs = new FamilyholdServiceImpl();
	
	//分页查询所有参合人员信息
	public void allFamilyhold(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String sindex = request.getParameter("index");
    	int index = 1;
    	try {
			index = Integer.parseInt(sindex);
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}
    	
    	//条件查询
    	String xm = request.getParameter("xm");
    	
    	PageBean<Familyhold> pfh = new PageBean<Familyhold>();
    	pfh.setIndex(index);
    	fhs.pageFamilyhold(pfh,xm);
    	
    	request.setAttribute("pfh", pfh);
    	request.setAttribute("xm", xm);
    	request.getRequestDispatcher("/view/system/family/familyholdAll_list.jsp").forward(request, response);
	}
	
   //查询家庭参合人员列表
	public void findAllFamilyhold(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String jtbh = request.getParameter("jtbh");
		//System.out.println("jtbh:"+jtbh);
		List<Familyhold> lfh = fhs.findAllFamilyhold(jtbh);
		request.setAttribute("listFamilyhold", lfh);
		request.setAttribute("jtbh", jtbh);
		request.getRequestDispatcher("/view/system/family/familyhold_list.jsp").forward(request, response);
	}
	
	//添加参合人员信息
	public void addFamilyhode(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String jtbh = request.getParameter("jtbh");
		String nhzh = request.getParameter("nhzh");
		String ylzkh = request.getParameter("ylzkh");
		
		//String hnbh = request.getParameter("hnbh");
		//查询户内编号
		String h = fhs.getHnbhMax(jtbh);
		int h1 = Integer.parseInt(h);
		h1++;
		String hnbh = String.format("%02d",h1 );
		
		String xm = request.getParameter("xm");
		String yhzgx = request.getParameter("yhzgx");
		String sfzh = request.getParameter("sfzh");
		String xb = request.getParameter("xb");
		String jkzk = request.getParameter("jkzk");
		String mz = request.getParameter("mz");
		String whcd = request.getParameter("whcd");
		String nl = request.getParameter("nl");
		String csrq = request.getParameter("csrq");
		String rysx = request.getParameter("rysx");
		String sfnchk = request.getParameter("sfnchk");
		String zy = request.getParameter("zy");
		String gzdw = request.getParameter("gzdw");
		String lxdh = request.getParameter("lxdh");
		String czdz = request.getParameter("czdz");
		
		
		Familyhold familyhold = new Familyhold();
		familyhold.setJtbh(jtbh);
		familyhold.setNhzh(nhzh);
		familyhold.setYlzkh(ylzkh);
		familyhold.setHnbh(hnbh);
		familyhold.setXm(xm);
		familyhold.setYhzgx(yhzgx);
		familyhold.setSfzh(sfzh);
		familyhold.setXb(xb);
		familyhold.setJkzk(jkzk);
		familyhold.setMz(mz);
		familyhold.setWhcd(whcd);
		familyhold.setNl(nl);
		familyhold.setCsrq(csrq);
		familyhold.setRysx(rysx);
		familyhold.setSfnchk(sfnchk);
		familyhold.setZy(zy);
		familyhold.setGzdw(gzdw);
		familyhold.setLxdh(lxdh);
		familyhold.setCzdz(czdz);
		familyhold.setMoneyState("0");
		
		int i = fhs.addMamilyhold(familyhold);
		
		FamilyService fs = new FamilyServiceImpl();
		//查询家庭人口数
		Family family = fs.findByFamily(jtbh);
		int count = Integer.parseInt(family.getJtrks());
		int jtrks1 = count+1;
		int nyrks1 = count+1;
		String jtrks = String.valueOf(jtrks1);
		String nyrks = String.valueOf(nyrks1);
		//更新家庭人口数
		int m = fs.jtrks(jtbh,jtrks,nyrks);
		
		if(i>0 || m>0) {
			request.setAttribute("url", "system/familyhold?method=findAllFamilyhold&jtbh="+jtbh);
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//根据id查参合人员信息
	public void findByIdFamilyhold(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Familyhold familyhold = fhs.findById(id);
		
		request.setAttribute("Familyhold", familyhold);
		request.getRequestDispatcher("/view/system/family/familyhold_edit.jsp").forward(request, response);
	}

	//修改参合人员信息
	public void updateFamilyhode(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String jtbh = request.getParameter("jtbh");
		String nhzh = request.getParameter("nhzh");
		String ylzkh = request.getParameter("ylzkh");
		String hnbh = request.getParameter("hnbh");
		String xm = request.getParameter("xm");
		String yhzgx = request.getParameter("yhzgx");
		String sfzh = request.getParameter("sfzh");
		String xb = request.getParameter("xb");
		String jkzk = request.getParameter("jkzk");
		String mz = request.getParameter("mz");
		String whcd = request.getParameter("whcd");
		String nl = request.getParameter("nl");
		String csrq = request.getParameter("csrq");
		String rysx = request.getParameter("rysx");
		String sfnchk = request.getParameter("sfnchk");
		String zy = request.getParameter("zy");
		String gzdw = request.getParameter("gzdw");
		String lxdh = request.getParameter("lxdh");
		String czdz = request.getParameter("czdz");
		
		Familyhold familyhold = new Familyhold();
		familyhold.setId(id);
		familyhold.setJtbh(jtbh);
		familyhold.setNhzh(nhzh);
		familyhold.setYlzkh(ylzkh);
		familyhold.setHnbh(hnbh);
		familyhold.setXm(xm);
		familyhold.setYhzgx(yhzgx);
		familyhold.setSfzh(sfzh);
		familyhold.setXb(xb);
		familyhold.setJkzk(jkzk);
		familyhold.setMz(mz);
		familyhold.setWhcd(whcd);
		familyhold.setNl(nl);
		familyhold.setCsrq(csrq);
		familyhold.setRysx(rysx);
		familyhold.setSfnchk(sfnchk);
		familyhold.setZy(zy);
		familyhold.setGzdw(gzdw);
		familyhold.setLxdh(lxdh);
		familyhold.setCzdz(czdz);
		
		int i = fhs.update(familyhold);
		if(i>0) {
			request.setAttribute("url", "system/familyhold?method=findAllFamilyhold&jtbh="+jtbh);
			request.getRequestDispatcher("../tips.jsp").forward(request, response);
		}
	}
	
	//删除参合人员信息
	public void deleteFamilyhold(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		int i = fhs.delete(id);
		
		String jtbh = request.getParameter("jtbh");
		System.out.println("jtbh"+jtbh);
		FamilyService fs = new FamilyServiceImpl();
		//查询家庭人口数
		Family family = fs.findByFamily(jtbh);
		int count = Integer.parseInt(family.getJtrks());
		int jtrks1 = count-1;
		int nyrks1 = count-1;
		String jtrks = String.valueOf(jtrks1);
		String nyrks = String.valueOf(nyrks1);
		//更新家庭人口数
		int m = fs.jtrks(jtbh,jtrks,nyrks);
			
		if(i>0 || m>0) {
			response.getWriter().write("true");
		}
	}
	
	//验证身份证号是否存在
	 public void checkSfzh(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 String sfzh = request.getParameter("sfzh");
		 Familyhold familyhold = fhs.checkSfzh(sfzh);
		 if(familyhold != null) {
	    		
	    		response.getWriter().write("true");
	    	}else {
	    		response.getWriter().write("false");
	    		
			}
	 }
}
