package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Vol;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValiderServlet
 */
@WebServlet("/ValiderServlet")
public class ValiderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Cgestion g ;
	   @Override
   public void init()throws ServletException{
	   g = new CgestionImpl();
	   
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		String id=request.getParameter("x");
		
		CompagnieModele mod=new CompagnieModele();
		
		Vol v = g.getVol(Integer.parseInt(id));
		mod.setCurrentVol(v);;
		/* Création ou récupération de la session */
		HttpSession session = request.getSession(true);

		/* Mise en session d'un modele */
		
		session.setAttribute("modele", mod);
		
		String page = "Inscription.jsp";
		CompagnieModele conn = (CompagnieModele) request.getSession().getAttribute("connexion");
		if(conn==null){
			page = "Inscription.jsp";
		}
		else if(conn.isConnect()){
			page="Confirmation.jsp";		
		}
		
		
		//request.setAttribute("modele", mod);
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("x");
		
		CompagnieModele mod=new CompagnieModele();
		
		Vol v = g.getVol(Integer.parseInt(id));
		mod.setCurrentVol(v);;
		/* Création ou récupération de la session */
		HttpSession session = request.getSession(true);

		/* Mise en session d'un modele */
		
		session.setAttribute("modele", mod);
		
		String page = "Inscription.jsp";
		CompagnieModele conn = (CompagnieModele) request.getSession().getAttribute("connexion");
		if(conn==null){
			page = "Inscription.jsp";
		}
		else if(conn.isConnect()){
			page="Confirmation.jsp";		
		}
		
		
		//request.setAttribute("modele", mod);
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
