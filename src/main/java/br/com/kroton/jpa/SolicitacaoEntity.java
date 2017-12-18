package br.com.kroton.jpa;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SOLICITACAO")
public class SolicitacaoEntity{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private BigInteger id;

	@Column(name="DT_ABERTURA")
	private Date dtAbertura;
	
	@Column(name="DT_ULTIMA_ALTERACAO")
	private Date dtUltimaAlteracao;

	@Column(name="DT_DEFERIMENTO")
	private Date dtDeferimento;

	@Column(name="DT_AGUARDANDO_ANALISE")
	private Date dtAguardandoAnalise;

	@Column(name="DT_PAGAMENTO")
	private Date dtPagamento;
	
	@ManyToOne
	@JoinColumn(name="ID_SERVICO", referencedColumnName = "ID")
	private ServicoEntity servico;
	
	@ManyToOne
	@JoinColumn(name="ID_STATUS", referencedColumnName = "ID")
	private StatusEntity status;
	
	@ManyToOne
	@JoinColumn(name="ID_CURSO", referencedColumnName = "ID")
	private CursoEntity curso;

	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtUltimaAlteracao() {
		return dtUltimaAlteracao;
	}

	public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}

	public Date getDtDeferimento() {
		return dtDeferimento;
	}

	public void setDtDeferimento(Date dtDeferimento) {
		this.dtDeferimento = dtDeferimento;
	}

	public Date getDtAguardandoAnalise() {
		return dtAguardandoAnalise;
	}

	public void setDtAguardandoAnalise(Date dtAguardandoAnalise) {
		this.dtAguardandoAnalise = dtAguardandoAnalise;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public ServicoEntity getServico() {
		return servico;
	}

	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public CursoEntity getCurso() {
		return curso;
	}

	public void setCurso(CursoEntity curso) {
		this.curso = curso;
	}
}
