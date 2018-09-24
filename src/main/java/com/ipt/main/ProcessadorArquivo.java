package com.ipt.main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;

import com.ipt.model.*;
import com.ipt.utils.*;

/**
 * This is a sample class to launch a rule.
 */
public class ProcessadorArquivo {

	public static final void main(String[] args) {

		/*
		try {

			ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
			ManipuladorCsv manipuladorCsv = new ManipuladorCsv();

			Date ini = new Date();
			ini.setTime(System.currentTimeMillis());

			int cont = 0;

			System.out.println("lendo arquivos");
			List<Sinistro> sinistros = manipuladorCsv.readCsvSinistros(100,
					"sinistros.csv");
			SortedSet<Long> fraudes = manipuladorCsv
					.readCsvFraudes("fraudes.csv");

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");

			ini.setTime(System.currentTimeMillis());

			System.out.println("setNumSinistros90dias");
			cont = 0;
			for (Sinistro sinistro : sinistros) {
				sinistro.setExcessoNumSinistrosBenef(processadorArquivo
						.numSinistros90dias(sinistros, sinistro, cont, 90));
				cont++;
				//System.out.println(cont + " de " + sinistros.size());
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			ini.setTime(System.currentTimeMillis());

			System.out.println("setNumSinistrosFam90dias");
			cont = 0;
			for (Sinistro sinistro : sinistros) {
				sinistro.setExcessoNumSinistrosFam(processadorArquivo
						.numSinistrosFam90dias(sinistros, sinistro, cont, 90));
				cont++;
				//System.out.println(cont + " de " + sinistros.size());
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			
			ini.setTime(System.currentTimeMillis());

			System.out.println("domingoFeriado");
			cont = 0;
			for (Sinistro sinistro : sinistros) {
				sinistro.setDomingoFeriado(processadorArquivo
						.domingoFeriado(sinistro));
				cont++;
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			ini.setTime(System.currentTimeMillis());

			System.out.println("setMediaProcedimentoCrm");
			cont = 0;
			for (Sinistro sinistro : sinistros) {
				sinistro.setMediaProcedimentoCrm(processadorArquivo
						.mediaProcedimentoCrm(sinistros, sinistro, cont));
				cont++;
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			ini.setTime(System.currentTimeMillis());

			System.out.println("setDispersaoSinistrosUfBenef");
			cont = 0;
			for (Sinistro sinistro : sinistros) {
				sinistro.setDispersaoSinistrosUfBenef(processadorArquivo
						.dispersaoSinistrosUfBenef(sinistros, sinistro, cont));
				cont++;
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");

			ini.setTime(System.currentTimeMillis());

			System.out.println("setFraude");
			for (Sinistro sinistro : sinistros) {
				if (fraudes.contains(sinistro.getIdtDocumento())) {
					sinistro.setFraude(true);
				}
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			ini.setTime(System.currentTimeMillis());

			System.out.println("escrevendo");
			manipuladorCsv.writeCsvSinistros(sinistros,
					"sinistros_flagfraudes_redflags.csv");
			manipuladorCsv.writeCsvSinistros2(sinistros,
					"sinistros_flagfraudes.csv");
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System
					.currentTimeMillis() - ini.getTime())
					+ " segs");
			System.out.println("fim");

		} catch (Throwable t) {
			t.printStackTrace();
		}
	*/
	}

	/*
	public int numSinistros90dias(List<Sinistro> sinistros, Sinistro sinistro,
			int posicao, int numDias) {
		int numSinistros = 0;
		long diff;
		int dias;
		int cont = 0;
		int i;
		for (Sinistro s : sinistros) {

			cont++;

			if (cont > posicao)
				break;

			
			if ((s.getCodEmpresa().equals(sinistro.getCodEmpresa()))
					&& (s.getCodFamiliarBenef().equals(sinistro.getCodFamiliarBenef()))
					&& (s.getCodRdp().equals(sinistro.getCodRdp()))
					&& (s.getCodServico() == sinistro.getCodServico())) {
				diff = sinistro.getDatExecucao().getTime() - s.getDatExecucao().getTime();
				dias = (int) TimeUnit.MILLISECONDS.toDays(diff);
				if (dias <= numDias) {
					numSinistros++;
				}
			}

		}

		return numSinistros;
	}

	public int numSinistrosFam90dias(List<Sinistro> sinistros,
			Sinistro sinistro, int posicao, int numDias) {
		int numSinistros = 0;
		long diff;
		int dias;
		int cont = 0;

		for (Sinistro s : sinistros) {

			cont++;

			if (cont > posicao )
				break;

			if ((s.getCodEmpresa().equals(sinistro.getCodEmpresa()))
					&& (s.getCodFamiliarBenef().equals(sinistro.getCodFamiliarBenef()))
					&& (s.getCodServico() == sinistro.getCodServico())) {
				diff = sinistro.getDatExecucao().getTime() - s.getDatExecucao().getTime();
				dias = (int) TimeUnit.MILLISECONDS.toDays(diff);
				if (dias <= numDias) {
					numSinistros++;
				}
			}

		}

		return numSinistros;
	}

	public int domingoFeriado(Sinistro sinistro) {

		Calendar c = Calendar.getInstance();
		c.setTime(sinistro.getDatExecucao());

		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			return 1;

		// an novo
		if (c.get(Calendar.DAY_OF_MONTH) == 1
				&& c.get(Calendar.MONTH) == Calendar.JANUARY)
			return 1;

		// tiradentes
		if (c.get(Calendar.DAY_OF_MONTH) == 21
				&& c.get(Calendar.MONTH) == Calendar.APRIL)
			return 1;

		// trab
		if (c.get(Calendar.DAY_OF_MONTH) == 1
				&& c.get(Calendar.MONTH) == Calendar.MAY)
			return 1;

		// nossa senhora
		if (c.get(Calendar.DAY_OF_MONTH) == 12
				&& c.get(Calendar.MONTH) == Calendar.OCTOBER)
			return 1;

		// finados
		if (c.get(Calendar.DAY_OF_MONTH) == 2
				&& c.get(Calendar.MONTH) == Calendar.NOVEMBER)
			return 1;

		// republica
		if (c.get(Calendar.DAY_OF_MONTH) == 15
				&& c.get(Calendar.MONTH) == Calendar.NOVEMBER)
			return 1;

		// natal
		if (c.get(Calendar.DAY_OF_MONTH) == 25
				&& c.get(Calendar.MONTH) == Calendar.DECEMBER)
			return 1;

		return 0;
	}

	public int mediaProcedimentoCrm(List<Sinistro> sinistros,
			Sinistro sinistro, int posicao) {

		int cont = 0;
		int contProcedimentos = 0;
		double valAcumulado = 0;

		if (sinistro.getCodConsProfExec() == null
				|| !sinistro.getCodConsProfExec().equals("CRM")
				|| sinistro.getSigUfCrmExec() == null
				|| sinistro.getNumCrmExec() == 0
				|| sinistro.getCodServico() == 0)
			return 0;

		for (Sinistro s : sinistros) {

			cont++;

			if (cont > posicao)
				break;

			if (s.getCodConsProfExec() != null
					&& s.getCodConsProfExec().equals("CRM")
					&& s.getSigUfCrmExec() != null
					&& s.getSigUfCrmExec().equals(sinistro.getSigUfCrmExec())
					&& s.getNumCrmExec() == sinistro.getNumCrmExec()
					&& s.getCodServico() == sinistro.getCodServico()) {
				valAcumulado = valAcumulado + s.getValItem();
				contProcedimentos++;
			}

		}

		if (valAcumulado > 0 && contProcedimentos > 0)
			return (int) (valAcumulado / contProcedimentos);
		else
			return 0;

	}

	public int dispersaoSinistrosUfBenef(List<Sinistro> sinistros,
			Sinistro sinistro, int posicao) {

		int cont = 0;
		int valAcumulado = 0;

		if (sinistro.getUfResidenciaSegurado() == null
				|| sinistro.getSigUfCrmExec() == null)
			return 0;

		for (Sinistro s : sinistros) {

			cont++;

			if (cont > posicao)
				break;

			if (s.getCodEmpresa().equals(sinistro.getCodEmpresa())
					&& s.getCodFamiliarBenef().equals(
							sinistro.getCodFamiliarBenef())
					&& s.getCodRdp().equals(sinistro.getCodRdp())
					&& s.getUfResidenciaSegurado() != null
					&& s.getSigUfCrmExec() != null
					&& !s.getSigUfCrmExec().equals(s.getUfResidenciaSegurado()))
				valAcumulado++;
		}

		return valAcumulado;
	}
	
	*/
}
