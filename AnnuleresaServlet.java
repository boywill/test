package web;

import gestion.Cgestion;
import gestion.CgestionImpl;
import gestion.Reservation;
import gestion.Vol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnuleresaServlet
 */
@WebServlet("/AnnuleresaServlet")
public class AnnuleresaServlet extends HttpServlet {
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
		String id=request.getParameter("x");
		CompagnieModele comp1 = (CompagnieModele) request.getSession(true).getAttribute("isthere");
		g.annuleResa(comp1.getEmailc(), Integer.parseInt(id));
		//List<Reservation> resas =g.getResaParC(comp1.getEmailc());
		CompagnieModele modresa = new CompagnieModele();
		CompagnieModele comp2 = (CompagnieModele) request.getSession(true).getAttribute("isthere");
		List <Vol> vols = new ArrayList<Vol>();;
		List<Reservation> resas = g.getResaParC(comp2.getEmailc());
			for(Reservation r : resas){
				Vol v = g.getVol(r.getNumVol());
				vols.add(v);
			}
		modresa.setResa(resas);	
		modresa.setVols(vols);
		request.setAttribute("modeleresa", modresa);
		request.getRequestDispatcher("MesReservations.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("x");
		CompagnieModele comp1 = (CompagnieModele) request.getSession(true).getAttribute("isthere");
		g.annuleResa(comp1.getEmailc(), Integer.parseInt(id));
		//List<Reservation> resas =g.getResaParC(comp1.getEmailc());
		CompagnieModele modresa = new CompagnieModele();
		CompagnieModele comp2 = (CompagnieModele) request.getSession(true).getAttribute("isthere");
		List <Vol> vols = new ArrayList<Vol>();;
		List<Reservation> resas = g.getResaParC(comp2.getEmailc());
			for(Reservation r : resas){
				Vol v = g.getVol(r.getNumVol());
				vols.add(v);
			}
		modresa.setResa(resas);	
		modresa.setVols(vols);
		request.setAttribute("modeleresa", modresa);
		String page = "MesReservations.jsp";
		if(resas.isEmpty()){
			page = "Pasdereservation.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
