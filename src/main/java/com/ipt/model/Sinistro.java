package com.ipt.model;

import java.util.Date;

public class Sinistro {
	
	private long codSinistro;
	private long codDocumento;
	private Date datInclusao;
	private int qtdServCobrada;
	private double valItem;
	private int codSituacaoItem;
	private long codServico;

	private String codItem;
	private String idcTipoAtend;
	private String flgSitEmergencia;
	private String idcTipoInternacao;
	private String flgInternacao;
	private String flgConsulta;
	private Date datAtendimento;
	private String codSeqPagamento;
	private boolean flgFraude;
	private double txSinistroPessoa;
	private double txSinistroFamilia;
	private double valMediaProcedimento;
	
	private Beneficiario beneficiario;
	private Medico medico;
	private Prestador prestador;
	
	private int score;
	private String probalidadeFraude="BAIXA";
	private boolean probalidadeParcelamento;
	
	public double getValMediaProcedimento() {
		return valMediaProcedimento;
	}
	public void setValMediaProcedimento(double valMediaProcedimento) {
		this.valMediaProcedimento = valMediaProcedimento;
	}
	

	public boolean isProbalidadeParcelamento() {
		return probalidadeParcelamento;
	}
	public void setProbalidadeParcelamento(boolean probalidadeParcelamento) {
		this.probalidadeParcelamento = probalidadeParcelamento;
	}
	public long getCodSinistro() {
		return codSinistro;
	}
	public void setCodSinistro(long codSinistro) {
		this.codSinistro = codSinistro;
	}
	public long getCodDocumento() {
		return codDocumento;
	}
	public void setCodDocumento(long codDocumento) {
		this.codDocumento = codDocumento;
	}
	public Date getDatInclusao() {
		return datInclusao;
	}
	public void setDatInclusao(Date datInclusao) {
		this.datInclusao = datInclusao;
	}
	public int getQtdServCobrada() {
		return qtdServCobrada;
	}
	public void setQtdServCobrada(int qtdServCobrada) {
		this.qtdServCobrada = qtdServCobrada;
	}
	public double getValItem() {
		return valItem;
	}
	public void setValItem(double valItem) {
		this.valItem = valItem;
	}
	public long getCodServico() {
		return codServico;
	}
	public void setCodServico(long codServico) {
		this.codServico = codServico;
	}
	public int getCodSituacaoItem() {
		return codSituacaoItem;
	}
	public void setCodSituacaoItem(int codSituacaoItem) {
		this.codSituacaoItem = codSituacaoItem;
	}
	public String getCodItem() {
		return codItem;
	}
	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}
	public String getFlgSitEmergencia() {
		return flgSitEmergencia;
	}
	public void setFlgSitEmergencia(String flgSitEmergencia) {
		this.flgSitEmergencia = flgSitEmergencia;
	}
	public String getIdcTipoInternacao() {
		return idcTipoInternacao;
	}
	public void setIdcTipoInternacao(String idcTipoInternacao) {
		this.idcTipoInternacao = idcTipoInternacao;
	}
	public String getFlgInternacao() {
		return flgInternacao;
	}
	public void setFlgInternacao(String flgInternacao) {
		this.flgInternacao = flgInternacao;
	}
	public String getFlgConsulta() {
		return flgConsulta;
	}
	public void setFlgConsulta(String flgConsulta) {
		this.flgConsulta = flgConsulta;
	}
	public Date getDatAtendimento() {
		return datAtendimento;
	}
	public void setDatAtendimento(Date datAtendimento) {
		this.datAtendimento = datAtendimento;
	}
	public String getCodSeqPagamento() {
		return codSeqPagamento;
	}
	public void setCodSeqPagamento(String codSeqPagamento) {
		this.codSeqPagamento = codSeqPagamento;
	}
	public double getTxSinistroPessoa() {
		return txSinistroPessoa;
	}
	public void setTxSinistroPessoa(double txSinistroPessoa) {
		this.txSinistroPessoa = txSinistroPessoa;
	}
	public double getTxSinistroFamilia() {
		return txSinistroFamilia;
	}
	public void setTxSinistroFamilia(double txSinistroFamilia) {
		this.txSinistroFamilia = txSinistroFamilia;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Prestador getPrestador() {
		return prestador;
	}
	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProbalidadeFraude() {
		return probalidadeFraude;
	}
	public void setProbalidadeFraude(String probalidadeFraude) {
		this.probalidadeFraude = probalidadeFraude;
	}
	public String getIdcTipoAtend() {
		return idcTipoAtend;
	}
	public void setIdcTipoAtend(String idcTipoAtend) {
		this.idcTipoAtend = idcTipoAtend;
	}
	public boolean isFlgFraude() {
		return flgFraude;
	}
	public void setFlgFraude(boolean flgFraude) {
		this.flgFraude = flgFraude;
	}
	@Override
	public String toString() {
		return "Sinistro [codSinistro=" + codSinistro + ", codDocumento="
				+ codDocumento + ", datInclusao=" + datInclusao
				+ ", qtdServCobrada=" + qtdServCobrada + ", valItem=" + valItem
				+ ", codSituacaoItem=" + codSituacaoItem + ", codServico="
				+ codServico + ", codItem=" + codItem + ", idcTipoAtend="
				+ idcTipoAtend + ", flgSitEmergencia=" + flgSitEmergencia
				+ ", idcTipoInternacao=" + idcTipoInternacao
				+ ", flgInternacao=" + flgInternacao + ", flgConsulta="
				+ flgConsulta + ", datAtendimento=" + datAtendimento
				+ ", codSeqPagamento=" + codSeqPagamento + ", flgFraude="
				+ flgFraude + ", txSinistroPessoa=" + txSinistroPessoa
				+ ", txSinistroFamilia=" + txSinistroFamilia
				+ ", valMediaProcedimento=" + valMediaProcedimento
				+ ", beneficiario=" + beneficiario + ", medico=" + medico
				+ ", prestador=" + prestador + ", score=" + score
				+ ", probalidadeFraude=" + probalidadeFraude
				+ ", probalidadeParcelamento=" + probalidadeParcelamento + "]";
	}
	
	
	
}