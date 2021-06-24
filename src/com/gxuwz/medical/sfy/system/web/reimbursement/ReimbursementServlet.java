package com.gxuwz.medical.sfy.system.web.reimbursement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.medical.sfy.domain.chronicdisSet.ChronicdisSet;
import com.gxuwz.medical.sfy.domain.illcard.IllCard;
import com.gxuwz.medical.sfy.domain.participation.Participation;
import com.gxuwz.medical.sfy.domain.reimbursement.Reimbursement;
import com.gxuwz.medical.sfy.system.service.ChronicdisSetService;
import com.gxuwz.medical.sfy.system.service.IllCardService;
import com.gxuwz.medical.sfy.system.service.ParticipationService;
import com.gxuwz.medical.sfy.system.service.ReimbursementService;
import com.gxuwz.medical.sfy.system.service.impl.ChronicdisSetServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.IllCardServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ParticipationServiceImpl;
import com.gxuwz.medical.sfy.system.service.impl.ReimbursementServiceImpl;
import com.gxuwz.medical.sfy.utils.BaseServlet;
import com.gxuwz.medical.sfy.utils.PageBean;


@WebServlet("/system/reimbursement")
public class ReimbursementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	ReimbursementService rservice = new ReimbursementServiceImpl();
	
	//查询指定添加的参合人员信息
	public void findParticipation(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		//获取请求数据
		String sfzh = request.getParameter("sfzh");
		request.setAttribute("sfzh", sfzh);
		String year = request.getParameter("year");
		
		
		ParticipationService ps = new ParticipationServiceImpl();
		List<Participation> pa = new ArrayList<Participation>();
		
		//查询所有参合登记成员
		List<Participation> lp = ps.getAllParticipation();
		
		//查询该农民否有慢病证
		//IllCardService service = new IllCardServiceImpl();
		
		
		for(int i=0;i<lp.size();i++) {
			//System.out.println(lp.get(i).getSfzh()+":"+sfzh +"  "+lp.get(i).getJfnd()+":"+year);
			if(sfzh.equals(lp.get(i).getSfzh()) && year.equals(lp.get(i).getJfnd())) {
				pa.add(lp.get(i));
			}
		}
		if(pa.size()==0) {
			response.getWriter().write("false");
		}
	}
	
	//根据身份证号查询慢性病证信息和参合信息
	public void findSfzhIllcard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取请求数据
		String sfzh = request.getParameter("sfzh");
		request.setAttribute("sfzh", sfzh);
		
		//根据身份证号查询慢性病证信息
		IllCardService service = new IllCardServiceImpl();
		List<IllCard> li = service.findSfzh(sfzh);
		
		//查指定参合农民信息
		ParticipationService ps = new ParticipationServiceImpl();
		Participation par = ps.findBySfzh(sfzh);
		
		request.setAttribute("li", li);
		request.setAttribute("par", par);
    	request.getRequestDispatcher("/view/system/reimbursement/reimbursement_add.jsp").forward(request, response);
	
	}
	
	//校验报销信息是否合法
	public void checkIllcard(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取请求数据
		String illName = request.getParameter("illName");
		String jzsj = request.getParameter("jzsj");
		String sfzh = request.getParameter("sfzh");
		
		IllCardService service = new IllCardServiceImpl();
		IllCard illcard = service.checkIllcard(illName,jzsj,sfzh);
		
		ChronicdisSetService cservice = new ChronicdisSetServiceImpl();
		//获取系统当前年份
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	     String year = sdf.format(new Date());
		ChronicdisSet chro = cservice.checkSet(illName,year);
		
		if(illcard == null || chro == null) {
			response.getWriter().write("false");
		}
	}	
	
	//接收报销信息，计算报销金额
	public void money(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取请求数据
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		String illcardNo = request.getParameter("illcardNo");
		request.setAttribute("illcardNo", illcardNo);
		
		String sfzh = request.getParameter("sfzh");
		request.setAttribute("sfzh", sfzh);
		
		String nhzh = request.getParameter("nhzh");
		request.setAttribute("nhzh", nhzh);
		
		String illName = request.getParameter("illName");
		request.setAttribute("illName", illName);
		
		String illMoney = request.getParameter("illMoney");
		request.setAttribute("illMoney", illMoney);
		
		String yyfph = request.getParameter("yyfph");
		request.setAttribute("yyfph", yyfph);
		
		String jzsj = request.getParameter("jzsj");
		request.setAttribute("jzsj", jzsj);
		
		//获取系统当前年份
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy");//设置日期格式
	     String year = sdf.format(new Date());
         request.setAttribute("year", year);
	     
	     //查询慢病报销信息
	     ChronicdisSetService service = new ChronicdisSetServiceImpl();
	     ChronicdisSet set = service.check(illName,year);
	     
	     //查询该报销人的报销信息
	     List<Reimbursement> list = rservice.findReimbursement(sfzh,year);
	    
	     double allMoney = 0;
	     for(int i=0;i<list.size();i++) {
	    	 allMoney += Double.parseDouble(list.get(i).getMoney());	 
	     }
	     //之前已报销的钱
    	 request.setAttribute("allMoney", allMoney);
	     
	     if(set !=null && allMoney<=Double.parseDouble(set.getMoneyCapping()) ){
	     //计算本次报销信息
	    	 //获取报销比例
	    	 double percentage = Double.parseDouble(set.getPercentage());
	    	 System.out.println("比例："+percentage);
	    	 //获取封顶线
	    	 String moneyCapping = set.getMoneyCapping();
	    	 //要报销金额
	    	 int illmoney = Integer.parseInt(illMoney);
	    	 //可报销金额
	    	 double money = illmoney*percentage;
	    	 
	    	 if(money+allMoney < Double.parseDouble(set.getMoneyCapping())) {
	    		 request.setAttribute("money", money);
	    	 }else {
	    		 money = Double.parseDouble(set.getMoneyCapping())-allMoney;
	    		 request.setAttribute("money", money);
	    	 }
	    	 request.setAttribute("money", money);
	    	 
	    	 //为获取当前系统时间
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		     String bxsj = df.format(new Date());
		     request.setAttribute("bxsj", bxsj);
			
	    	request.getRequestDispatcher("/view/system/reimbursement/reimbursement_add1.jsp").forward(request, response);
	     }
	     
	}
	
	    //添加报销信息
		public void addReim(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//获取请求数据
			String name = request.getParameter("name");
			String illcardNo = request.getParameter("illcardNo");
			String sfzh = request.getParameter("sfzh");
			String nhzh = request.getParameter("nhzh");
			String illName = request.getParameter("illName");
			String illMoney = request.getParameter("illMoney");
			String yyfph = request.getParameter("yyfph");
			String jzsj = request.getParameter("jzsj");
			String money = request.getParameter("money");
			String bxsj = request.getParameter("bxsj");
			String year = request.getParameter("year");
			String status = "0";
			
			Reimbursement reim = new Reimbursement();
			reim.setName(name);
			reim.setIllcardNo(illcardNo);
			reim.setSfzh(sfzh);
			reim.setNhzh(nhzh);
			reim.setIllname(illName);
			reim.setIllMoney(illMoney);
			reim.setMoney(money);
			reim.setYyfph(yyfph);
			reim.setJzsj(jzsj);
			reim.setBxsj(bxsj);
			reim.setYear(year);
			reim.setStatus(status);
			
			int i = rservice.addReim(reim);
			if(i>0) {
				request.setAttribute("url", "system/reimbursement?method=findAllReim&index=1");
				request.getRequestDispatcher("../tips.jsp").forward(request, response);
			}
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
			String status = request.getParameter("status");
			request.setAttribute("status", status);
			
			
			String sindex = request.getParameter("index");
	    	int index = 1;
	    	try {
				index = Integer.parseInt(sindex);
			} catch (NumberFormatException n) {
				n.printStackTrace();
			}
	    	PageBean<Reimbursement> pr = new PageBean<Reimbursement>();
	    	pr.setIndex(index);
	    	rservice.pageReim(pr,name,startTime,endTime,status);
	    	request.setAttribute("pr", pr);
	    	request.getRequestDispatcher("/view/system/reimbursement/reimburde_list.jsp").forward(request, response);
	    	
	    	
		}
		
		//报销状态管理
		public void updateStatus(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			//获取请求数据
			String id = request.getParameter("id");
			String status = request.getParameter("status");
			int zt = Integer.parseInt(status)+1;
			
			int i = rservice.updateStatus(id,zt);
			if(i>0) {
				   response.getWriter().write("true");
			   }
		}
			
   
}
