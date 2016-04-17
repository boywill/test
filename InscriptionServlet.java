package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Client;
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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private Cgestion g ;
	   @Override
   public void init()throws ServletException{
	   g = new CgestionImpl();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "Inscription.jsp";
		CompagnieModele conn = (CompagnieModele) request.getSession().getAttribute("connexion");
		if(conn==null){
			page = "Inscription.jsp";
		}
		else if(conn.isConnect()){
			page="Perso.jsp";		
		}
		
		
		//request.setAttribute("modele", mod);
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String firstname=request.getParameter("firstname");
		int tel=Integer.parseInt(request.getParameter("number"));
		String email=request.getParameter("email");
		String mdp=request.getParameter("password");
		Client c = new Client(name,firstname,tel,email,mdp);
		g.addClient(c);
		
		String page = "Perso.jsp";
		HttpSession session = request.getSession(true);
		CompagnieModele mod = (CompagnieModele) session.getAttribute("modele");
		
		if(mod==null){
			page = "Perso.jsp";
		}
		else {
			page="Confirmation.jsp";
			CompagnieModele comp = (CompagnieModele) request.getSession(true).getAttribute("modele");
			comp.setEmailc(c.getAdress());
			request.getSession().setAttribute("modele",comp);
		}
		CompagnieModele comp = new CompagnieModele();
		comp.setEmailc(email);
		session.setAttribute("isthere",comp);
		CompagnieModele conn = new CompagnieModele();
		conn.setConnect(true);
		session.setAttribute("connexion",conn);
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
