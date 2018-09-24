package com.ipt.model;

public class Prestador {

	private long cnpjCpfPrestador;

	public long getCnpjCpfPrestador() {
		return cnpjCpfPrestador;
	}

	public void setCnpjCpfPrestador(long cnpjCpfPrestador) {
		this.cnpjCpfPrestador = cnpjCpfPrestador;
	}

	@Override
	public String toString() {
		return "Prestador [cnpjCpfPrestador=" + cnpjCpfPrestador + "]";
	}

	
}