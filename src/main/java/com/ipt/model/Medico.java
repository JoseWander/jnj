package com.ipt.model;

public class Medico {

	private String codConsProfExec;
	private String sigUfCrmExec;
	private long numCrmExec;
	private String statusCrm;
	
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
	@Override
	public String toString() {
		return "Medico [codConsProfExec=" + codConsProfExec + ", sigUfCrmExec="
				+ sigUfCrmExec + ", numCrmExec=" + numCrmExec + ", statusCrm="
				+ statusCrm + "]";
	}
	  
	
}