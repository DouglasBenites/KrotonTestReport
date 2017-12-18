package br.com.kroton.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportInfoGeralBean {

	@Id
	public String qt;
	public String tmg, tmag, tmpg;
	public ReportInfoGeralBean() {
		// TODO Auto-generated constructor stub
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getTmg() {
		return tmg;
	}
	public void setTmg(String tmg) {
		this.tmg = tmg;
	}
	public String getTmag() {
		return tmag;
	}
	public void setTmag(String tmag) {
		this.tmag = tmag;
	}
	public String getTmpg() {
		return tmpg;
	}
	public void setTmpg(String tmpg) {
		this.tmpg = tmpg;
	}
	
}
