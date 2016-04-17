package web;

import gestion.Cgestion;
import gestion.CgestionImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Cgestion g ;
	   @Override
 public void init()throws ServletException{
	   g = new CgestionImpl();
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "Adminlogin.jsp";
		CompagnieModele m = (CompagnieModele) request.getSession(true).getAttribute("connecta");
		if(m == null) page = "Adminlogin.jsp";
		else if(!m.isConectA()){page = "Adminlogin.jsp";}
		else{page = "adminaccueil.jsp";}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ida=request.getParameter("Ida");
	    String mdp=request.getParameter("password");
		String page = "Adminfalse.jsp";
		Boolean exist = g.existAdmin(Integer.parseInt(ida), mdp);
		if(exist){
			page="adminaccueil.jsp";
			CompagnieModele m = new CompagnieModele();
			m.setConectA(true);
			request.getSession().setAttribute("connecta", m);
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
	}


