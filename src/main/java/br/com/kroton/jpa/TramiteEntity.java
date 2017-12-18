package br.com.kroton.jpa;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRAMITE")
public class TramiteEntity {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private BigInteger id;

	@Column(name = "ID_SEQUENCIA")
	private Integer idSequencia;
	
	@Column(name = "DS_OBS")
	private String dsObs;
	
	@Column(name = "DT_TRAMITE")
	private Timestamp dtTramite;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="ID_SOLICITACAO", referencedColumnName = "ID")
	private SolicitacaoEntity solicitacao;

	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getIdSequencia() {
		return idSequencia;
	}

	public void setIdSequencia(Integer idSequencia) {
		this.idSequencia = idSequencia;
	}

	public String getDsObs() {
		return dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public Timestamp getDtTramite() {
		return dtTramite;
	}

	public void setDtTramite(Timestamp dtTramite) {
		this.dtTramite = dtTramite;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public SolicitacaoEntity getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoEntity solicitacao) {
		this.solicitacao = solicitacao;
	}
	
}
