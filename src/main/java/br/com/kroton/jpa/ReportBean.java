package br.com.kroton.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportBean {

	@Id
	public String solicitacao;
	public String  nta, leadtime, maxta, tma, tmp, stats, servico, curso;
	public ReportBean() {
		// TODO Auto-generated constructor stub
	}
	public String getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}
	public String getNta() {
		return nta;
	}
	public void setNta(String nta) {
		this.nta = nta;
	}
	public String getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(String leadtime) {
		this.leadtime = leadtime;
	}
	public String getMaxta() {
		return maxta;
	}
	public void setMaxta(String maxta) {
		this.maxta = maxta;
	}
	public String getTma() {
		return tma;
	}
	public void setTma(String tma) {
		this.tma = tma;
	}
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

}
