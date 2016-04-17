package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Reservation;
import gestion.Vol;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Cgestion g ;
	   @Override
   public void init()throws ServletException{
	   g = new CgestionImpl();
	   
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "Adminlogin.jsp";
		CompagnieModele m = (CompagnieModele) request.getSession(true).getAttribute("connecta");
		if(m == null) page = "Adminlogin.jsp";
		else if(!m.isConectA()){page = "Adminlogin.jsp";}
		else{
			page = "Adminpage.jsp";
		CompagnieModele mod=new CompagnieModele();
		List<Vol> vols = g.getVol();
		mod.setVols(vols);	
		request.setAttribute("modele", mod);
		}
	//	if(vols.isEmpty()){
	//		page = "Pasdevol.jsp";
		//}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "Adminpage.jsp";
		String id=request.getParameter("x");
		if(id!=null){
		g.suppVol(Integer.parseInt(id));
		
		//List<Reservation> resas =g.getResaParC(comp1.getEmailc());
        CompagnieModele mod=new CompagnieModele();
		
		List<Vol> vols = g.getVol();
		mod.setVols(vols);	
		request.setAttribute("modele", mod);
		
		}
		
		
		
		else {
		
		
		String hd=request.getParameter("HD");
		String ha=request.getParameter("HA");
		String vd=request.getParameter("VD");
		String va=request.getParameter("VA");
		Date dd= Date.valueOf((request.getParameter("DD"))); 
		Date da= Date.valueOf((request.getParameter("DA"))); 
		String AD=request.getParameter("AD");
		String AA=request.getParameter("AA");
		String IDA=request.getParameter("IDA");
		String prix=request.getParameter("prix");
		Vol v = new Vol(Integer.parseInt(hd),
				Integer.parseInt(ha),
				vd,va,dd,da,AD,AA,
				Integer.parseInt(IDA),
				Integer.parseInt(prix));
		g.addVol(v);
		CompagnieModele mod=new CompagnieModele();
		
		List<Vol> vols = g.getVol();
		mod.setVols(vols);	
		request.setAttribute("modele", mod);
		}
	//	if(vols.isEmpty()){
	//		page = "Pasdevol.jsp";
		//}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}
}
