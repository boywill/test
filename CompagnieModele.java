package web;


import gestion.Client;
import gestion.Reservation;
import gestion.Vol;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CompagnieModele {
	private String vd;
	private String va;
	private Date dd;
	private boolean conectA = false;
	private boolean connect = false;
	private String Emailc;
	private List<Vol> vols = new ArrayList<>();
	private List<Reservation> resa = new ArrayList<>();
	private Vol currentVol ;
	private Client currentClient;
	
	
	
	public List<Vol> getVols() {
		return vols;
	}
	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}
	public List<Reservation> getResa() {
		return resa;
	}
	public void setResa(List<Reservation> resa) {
		this.resa = resa;
	}
	public Client getCurrentClient() {
		return currentClient;
	}
	public void setCurrentClient(Client currentClient) {
		this.currentClient = currentClient;
	}
	public Vol getCurrentVol() {
		return currentVol;
	}
	public void setCurrentVol(Vol currentVol) {
		this.currentVol = currentVol;
	}
	public boolean isConnect() {
		return connect;
	}
	public void setConnect(boolean connect) {
		this.connect = connect;
	}
	public String getEmailc() {
		return Emailc;
	}
	public void setEmailc(String emailc) {
		Emailc = emailc;
	}
	public String getVa() {
		return va;
	}
	public void setVa(String va) {
		this.va = va;
	}
	public String getVd() {
		return vd;
	}
	public void setVd(String vd) {
		this.vd = vd;
	}
	public Date getDd() {
		return dd;
	}
	public void setDd(Date dd) {
		this.dd = dd;
	}
	public boolean isConectA() {
		return conectA;
	}
	public void setConectA(boolean conectA) {
		this.conectA = conectA;
	}
	
}
