package com.ipt.model;

import java.util.Date;

public class Beneficiario {

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
	@Override
	public String toString() {
		return "Beneficiario [codEmpresa=" + codEmpresa + ", codFamiliarBenef="
				+ codFamiliarBenef + ", codRdp=" + codRdp
				+ ", qtdIdadeSegurado=" + qtdIdadeSegurado + ", idcSexo="
				+ idcSexo + ", sigUfCorresp=" + sigUfCorresp + ", flagLiminar="
				+ flagLiminar + ", codPlano=" + codPlano + ", codProduto="
				+ codProduto + ", codBeneficiario=" + codBeneficiario
				+ ", datAdesaoPlano=" + datAdesaoPlano + ", datExclusaoPlano="
				+ datExclusaoPlano + ", cpfBenef=" + cpfBenef + "]";
	}

	
}