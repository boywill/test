package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Vol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private Cgestion g ;
	   @Override
   public void init()throws ServletException{
	   g = new CgestionImpl();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
	    String mdp=request.getParameter("password");
		String page = "LoginFalse.jsp";
		Boolean exist = g.existClient(email, mdp);
		if(exist){
			page="Perso.jsp";
			HttpSession session = request.getSession(true);
			CompagnieModele conn = new CompagnieModele();
			CompagnieModele comp = new CompagnieModele();
			comp.setEmailc(email);
			conn.setConnect(true);
			session.setAttribute("connexion",conn);
			session.setAttribute("isthere",comp);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
