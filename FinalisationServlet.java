package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Vol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FinalisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Cgestion g ;
	   @Override
  public void init()throws ServletException{
	   g = new CgestionImpl();
	   
  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Création ou récupération de la session */
		//HttpSession session = request.getSession();
		/* Récupération de l'objet depuis la session */
		CompagnieModele comp = (CompagnieModele) request.getSession(true).getAttribute("modele");
		if(comp.getEmailc()==null){
		CompagnieModele comp1 = (CompagnieModele) request.getSession(true).getAttribute("isthere");
		comp.setEmailc(comp1.getEmailc()); 
		}
		/* Mise en session d'un modele */
		g.addResa(comp.getEmailc(), comp.getCurrentVol().getNumVol());
		
		//session.invalidate();

		
		//request.setAttribute("modele", mod);
		request.getRequestDispatcher("Finalisation.jsp").forward(request, response);
		
	}

}

