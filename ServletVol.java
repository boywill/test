package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Vol;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletVol
 */
@WebServlet("/ServletVol")
public class ServletVol extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
	 private Cgestion g ;
	   @Override
     public void init()throws ServletException{
  	   g = new CgestionImpl();
  	   
     }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vd=request.getParameter("vd");
		String va=request.getParameter("va");
		Date dd= Date.valueOf((request.getParameter("dd"))); 
		CompagnieModele mod=new CompagnieModele();
		mod.setVd(vd);
		mod.setVa(va);
		mod.setDd(dd);
		/* Création ou récupération de la session */
		HttpSession session = request.getSession(true);

		/* Mise en session d'un modele */
		
		session.setAttribute("modele_var", mod);
		
		List<Vol> vols = g.getVolsParMC(vd, va, dd.toString());
		mod.setVols(vols);	
		request.setAttribute("modele", mod);
		String page = "VolsView.jsp";
		if(vols.isEmpty()){
			page = "Pasdevol.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vd=request.getParameter("from");
		String va=request.getParameter("to");
		Date dd= Date.valueOf((request.getParameter("DateD"))); 
		CompagnieModele mod=new CompagnieModele();
		mod.setVd(vd);
		mod.setVa(va);
		mod.setDd(dd);
		/* Création ou récupération de la session */
		HttpSession session = request.getSession(true);

		/* Mise en session d'un modele */
		
		session.setAttribute("modele_var", mod);
		
		List<Vol> vols = g.getVolsParMC(vd, va, dd.toString());
		mod.setVols(vols);	
		request.setAttribute("modele", mod);
		String page = "VolsView.jsp";
		if(vols.isEmpty()){
			page = "Pasdevol.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}