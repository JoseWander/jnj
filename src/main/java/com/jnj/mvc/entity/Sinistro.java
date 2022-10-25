package com.jnj.mvc.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sinistros_3")
public class Sinistro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String codEmpresa;
	private String codFamiliarBenef;
	private String codRdp;
	private int qtdIdadeSegurado;
	private String idcSexo;
	private String sigUfCorresp;
	private String flagLiminar;
	private int codPlano;
	private int codProduto;
	private String codBeneficiario;
	private Date datAdesaoPlano;
	private Date datExclusaoPlano;
	private long cpfBenef;
	private String codConsProfExec;
	private String sigUfCrmExec;
	private long numCrmExec;
	private String statusCrm;
	private long cnpjCpfPrestador;
	private int score;
	private String probalidadeFraude;
	private boolean probalidadeParcelamento;
	
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
	public int getCodSituacaoItem() {
		return codSituacaoItem;
	}
	public void setCodSituacaoItem(int codSituacaoItem) {
		this.codSituacaoItem = codSituacaoItem;
	}
	public long getCodServico() {
		return codServico;
	}
	public void setCodServico(long codServico) {
		this.codServico = codServico;
	}
	public String getCodItem() {
		return codItem;
	}
	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}
	public String getIdcTipoAtend() {
		return idcTipoAtend;
	}
	public void setIdcTipoAtend(String idcTipoAtend) {
		this.idcTipoAtend = idcTipoAtend;
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
	public boolean isFlgFraude() {
		return flgFraude;
	}
	public void setFlgFraude(boolean flgFraude) {
		this.flgFraude = flgFraude;
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
	public double getValMediaProcedimento() {
		return valMediaProcedimento;
	}
	public void setValMediaProcedimento(double valMediaProcedimento) {
		this.valMediaProcedimento = valMediaProcedimento;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getCodFamiliarBenef() {
		return codFamiliarBenef;
	}
	public void setCodFamiliarBenef(String codFamiliarBenef) {
		this.codFamiliarBenef = codFamiliarBenef;
	}
	public String getCodRdp() {
		return codRdp;
	}
	public void setCodRdp(String codRdp) {
		this.codRdp = codRdp;
	}
	public int getQtdIdadeSegurado() {
		return qtdIdadeSegurado;
	}
	public void setQtdIdadeSegurado(int qtdIdadeSegurado) {
		this.qtdIdadeSegurado = qtdIdadeSegurado;
	}
	public String getIdcSexo() {
		return idcSexo;
	}
	public void setIdcSexo(String idcSexo) {
		this.idcSexo = idcSexo;
	}
	public String getSigUfCorresp() {
		return sigUfCorresp;
	}
	public void setSigUfCorresp(String sigUfCorresp) {
		this.sigUfCorresp = sigUfCorresp;
	}
	public String getFlagLiminar() {
		return flagLiminar;
	}
	public void setFlagLiminar(String flagLiminar) {
		this.flagLiminar = flagLiminar;
	}
	public int getCodPlano() {
		return codPlano;
	}
	public void setCodPlano(int codPlano) {
		this.codPlano = codPlano;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getCodBeneficiario() {
		return codBeneficiario;
	}
	public void setCodBeneficiario(String codBeneficiario) {
		this.codBeneficiario = codBeneficiario;
	}
	public Date getDatAdesaoPlano() {
		return datAdesaoPlano;
	}
	public void setDatAdesaoPlano(Date datAdesaoPlano) {
		this.datAdesaoPlano = datAdesaoPlano;
	}
	public Date getDatExclusaoPlano() {
		return datExclusaoPlano;
	}
	public void setDatExclusaoPlano(Date datExclusaoPlano) {
		this.datExclusaoPlano = datExclusaoPlano;
	}
	public long getCpfBenef() {
		return cpfBenef;
	}
	public void setCpfBenef(long cpfBenef) {
		this.cpfBenef = cpfBenef;
	}
	public String getCodConsProfExec() {
		return codConsProfExec;
	}
	public void setCodConsProfExec(String codConsProfExec) {
		this.codConsProfExec = codConsProfExec;
	}
	public String getSigUfCrmExec() {
		return sigUfCrmExec;
	}
	public void setSigUfCrmExec(String sigUfCrmExec) {
		this.sigUfCrmExec = sigUfCrmExec;
	}
	public long getNumCrmExec() {
		return numCrmExec;
	}
	public void setNumCrmExec(long numCrmExec) {
		this.numCrmExec = numCrmExec;
	}
	public String getStatusCrm() {
		return statusCrm;
	}
	public void setStatusCrm(String statusCrm) {
		this.statusCrm = statusCrm;
	}
	public long getCnpjCpfPrestador() {
		return cnpjCpfPrestador;
	}
	public void setCnpjCpfPrestador(long cnpjCpfPrestador) {
		this.cnpjCpfPrestador = cnpjCpfPrestador;
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
	public boolean isProbalidadeParcelamento() {
		return probalidadeParcelamento;
	}
	public void setProbalidadeParcelamento(boolean probalidadeParcelamento) {
		this.probalidadeParcelamento = probalidadeParcelamento;
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
				+ ", codEmpresa=" + codEmpresa + ", codFamiliarBenef="
				+ codFamiliarBenef + ", codRdp=" + codRdp
				+ ", qtdIdadeSegurado=" + qtdIdadeSegurado + ", idcSexo="
				+ idcSexo + ", sigUfCorresp=" + sigUfCorresp + ", flagLiminar="
				+ flagLiminar + ", codPlano=" + codPlano + ", codProduto="
				+ codProduto + ", codBeneficiario=" + codBeneficiario
				+ ", datAdesaoPlano=" + datAdesaoPlano + ", datExclusaoPlano="
				+ datExclusaoPlano + ", cpfBenef=" + cpfBenef
				+ ", codConsProfExec=" + codConsProfExec + ", sigUfCrmExec="
				+ sigUfCrmExec + ", numCrmExec=" + numCrmExec + ", statusCrm="
				+ statusCrm + ", cnpjCpfPrestador=" + cnpjCpfPrestador
				+ ", score=" + score + ", probalidadeFraude="
				+ probalidadeFraude + ", probalidadeParcelamento="
				+ probalidadeParcelamento + "]";
	}
	
	
}