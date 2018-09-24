package com.ipt.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.ipt.model.*;

public class ManipuladorCsv {

	String path="C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\";
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<Sinistro> readCsvSinistros2(int numRegs, String arquivo) throws IOException,
			URISyntaxException, ParseException {

		List<Sinistro> sinistros = new ArrayList<Sinistro>();
		Sinistro sinistro;
		Beneficiario beneficiario;
		Medico medico;
		Prestador prestador;

		Reader reader = Files.newBufferedReader(Paths.get(path + arquivo));

		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
				.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
				.withQuote('"').withDelimiter(','));

		Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		for (CSVRecord csvRecord : csvRecords) {

			if (numRegs > 0 && csvRecord.getRecordNumber() > numRegs)
				break;

			sinistro = new Sinistro();

			if (!csvRecord.get("codSinistro").isEmpty())
				sinistro.setCodSinistro(Long.parseLong(csvRecord
						.get("codSinistro")));
			if (!csvRecord.get("codDocumento").isEmpty())
				sinistro.setCodDocumento(Long.parseLong(csvRecord
						.get("codDocumento")));
			if (!csvRecord.get("datInclusao").isEmpty())
				sinistro.setDatInclusao(dateFormat.parse(csvRecord
						.get("datInclusao")));
			if (!csvRecord.get("qtdServCobrada").isEmpty())
				sinistro.setQtdServCobrada(Integer.parseInt(csvRecord
						.get("qtdServCobrada")));
			if (!csvRecord.get("valItem").isEmpty()) {
				if (NumberUtils.isNumber(csvRecord.get("valItem")))
					sinistro.setValItem(Double.parseDouble(csvRecord
							.get("valItem")));
			}
			if (!csvRecord.get("codSituacaoItem").isEmpty())
				sinistro.setCodSituacaoItem(Integer
						.parseInt(csvRecord.get("codSituacaoItem")));
			if (!csvRecord.get("codServico").isEmpty())
				sinistro.setCodServico(Long.parseLong(csvRecord
						.get("codServico")));
			if (!csvRecord.get("codItem").isEmpty())
				sinistro.setCodItem(csvRecord.get("codItem"));
			if (!csvRecord.get("idcTipoAtend").isEmpty())
				sinistro.setIdcTipoAtend(csvRecord.get("idcTipoAtend"));
			if (!csvRecord.get("flgSitEmergencia").isEmpty())
				sinistro.setFlgSitEmergencia(csvRecord.get("flgSitEmergencia"));
			if (!csvRecord.get("idcTipoInternacao").isEmpty())
				sinistro.setIdcTipoInternacao(csvRecord.get("idcTipoInternacao"));
			if (!csvRecord.get("flgInternacao").isEmpty())
				sinistro.setFlgInternacao(csvRecord.get("flgInternacao"));
			if (!csvRecord.get("flgConsulta").isEmpty())
				sinistro.setFlgConsulta(csvRecord.get("flgConsulta"));
			if (!csvRecord.get("datAtendimento").isEmpty())
				sinistro.setDatAtendimento(dateFormat.parse(csvRecord.get("datAtendimento")));
			if (!csvRecord.get("codSeqPagamento").isEmpty())
				sinistro.setCodSeqPagamento(csvRecord.get("codSeqPagamento"));
			sinistro.setTxSinistroPessoa(Double.parseDouble(csvRecord.get("txSinistroPessoa")));
			sinistro.setTxSinistroFamilia(Double.parseDouble(csvRecord.get("txSinistroFamilia")));
			if (!csvRecord.get("valMediaProcedimento").isEmpty()) {
				if (NumberUtils.isNumber(csvRecord.get("valMediaProcedimento")))
					sinistro.setValMediaProcedimento(Double.parseDouble(csvRecord
							.get("valMediaProcedimento")));
			}
			sinistro.setFlgFraude(Boolean.parseBoolean(csvRecord.get("flgFraude")));
			
			beneficiario = new Beneficiario();
			
			if (!csvRecord.get("codEmpresa").isEmpty())
				beneficiario.setCodEmpresa(csvRecord.get("codEmpresa"));
			if (!csvRecord.get("codFamiliarBenef").isEmpty())
				beneficiario.setCodFamiliarBenef(csvRecord.get("codFamiliarBenef"));
			if (!csvRecord.get("codRdp").isEmpty())
				beneficiario.setCodRdp(csvRecord.get("codRdp"));
			if (!csvRecord.get("qtdIdadeSegurado").isEmpty())
				beneficiario.setQtdIdadeSegurado(Integer
						.parseInt(csvRecord.get("qtdIdadeSegurado")));
			if (!csvRecord.get("idcSexo").isEmpty())
				beneficiario.setIdcSexo(csvRecord.get("idcSexo"));
			if (!csvRecord.get("sigUfCorresp").isEmpty())
				beneficiario.setSigUfCorresp(csvRecord
						.get("sigUfCorresp"));
			if (!csvRecord.get("flgLiminar").isEmpty())
				beneficiario.setFlagLiminar(csvRecord.get("flgLiminar"));
			if (!csvRecord.get("codPlano").isEmpty())
				beneficiario.setCodPlano(Integer.parseInt(csvRecord.get("codPlano")));
			if (!csvRecord.get("codProduto").isEmpty())
				beneficiario.setCodProduto(Integer.parseInt(csvRecord
						.get("codProduto")));
			if (!csvRecord.get("codBeneficiario").isEmpty())
				beneficiario.setCodBeneficiario(csvRecord.get("codBeneficiario"));
			if (!csvRecord.get("datAdesaoPlano").isEmpty())
				beneficiario.setDatAdesaoPlano(dateFormat.parse(csvRecord
						.get("datAdesaoPlano")));
			if (!csvRecord.get("datExclusaoPlano").isEmpty())
				beneficiario.setDatExclusaoPlano(dateFormat.parse(csvRecord
						.get("datExclusaoPlano")));
			if (!csvRecord.get("cpfBenef").isEmpty())
				beneficiario.setCpfBenef(Long.parseLong(csvRecord.get("cpfBenef")));
			
			sinistro.setBeneficiario(beneficiario);
			
			medico=new Medico();
			
			if (!csvRecord.get("codConsProfExec").isEmpty())
				medico.setCodConsProfExec(csvRecord.get("codConsProfExec")
						.trim());
			if (!csvRecord.get("sigUfCrmExec").isEmpty())
				medico.setSigUfCrmExec(csvRecord.get("sigUfCrmExec"));
			if (!csvRecord.get("numCrmExec").isEmpty())
				medico.setNumCrmExec(Long.parseLong(csvRecord
						.get("numCrmExec")));
			if (!csvRecord.get("statusCrm").isEmpty())
				medico.setStatusCrm(csvRecord.get("statusCrm")
						.trim());
			
			sinistro.setMedico(medico);
			
			prestador=new Prestador();
			
			if (!csvRecord.get("cnpjCpfPrestador").isEmpty())
				prestador.setCnpjCpfPrestador(Long.parseLong(csvRecord
						.get("cnpjCpfPrestador")));
			
			sinistro.setPrestador(prestador);
			
			//if(sinistro.isFlgFraude() ) System.out.println(  sinistro.toString());

			sinistros.add(sinistro);

		}

		return sinistros;

	}


	public void writeCsvSinistros3(List<Sinistro> sinistros, String arquivo)
			throws IOException, URISyntaxException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(
				"codSinistro","codDocumento","datInclusao","qtdServCobrada","valItem","codSituacaoItem",
				"cnpjCpfPrestador","codServico","codEmpresa","codFamiliarBenef","codRdp","qtdIdadeSegurado",
				"idcSexo","sigUfCorresp","flgLiminar","codPlano","codProduto","codConsProfExec","sigUfCrmExec",
				"numCrmExec","statusCrm","codItem","codBeneficiario","idcTipoAtend","flgSitEmergencia",
				"idcTipoInternacao","flgInternacao", "flgConsulta","datAdesaoPlano","datExclusaoPlano",
				"datAtendimento","cpfBenef","codSeqPagamento","txSinistroPessoa","txSinistroFamilia",
				"valMediaProcedimento", "probalidadeParcelamento", "probalidadeFraude","score","flgFraude").withQuoteMode(QuoteMode.NON_NUMERIC);

		BufferedWriter writer = Files
				.newBufferedWriter(Paths
						.get(path +  arquivo));
		CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

		for (Sinistro s : sinistros) {
			csvPrinter.printRecord(
					
				s.getCodSinistro(),
				s.getCodDocumento(),
				dateFormat.format(s.getDatInclusao()),
				s.getQtdServCobrada(),
				s.getValItem(),
				s.getCodSituacaoItem(),
				s.getPrestador().getCnpjCpfPrestador(),
				s.getCodServico(),
				s.getBeneficiario().getCodEmpresa(),
				s.getBeneficiario().getCodFamiliarBenef(),
				s.getBeneficiario().getCodRdp(),
				s.getBeneficiario().getQtdIdadeSegurado(),
				s.getBeneficiario().getIdcSexo(),
				s.getBeneficiario().getSigUfCorresp(),
				s.getBeneficiario().getFlagLiminar(),
				s.getBeneficiario().getCodPlano(),
				s.getBeneficiario().getCodProduto(),
				s.getMedico().getCodConsProfExec(),
				s.getMedico().getSigUfCrmExec(),
				s.getMedico().getNumCrmExec(),
				s.getMedico().getStatusCrm(),
				s.getCodItem(),
				s.getBeneficiario().getCodBeneficiario(),
				s.getIdcTipoAtend(),
				s.getFlgSitEmergencia(),
				s.getIdcTipoInternacao(),
				s.getFlgInternacao(),
				s.getFlgConsulta(),
				dateFormat.format(s.getBeneficiario().getDatAdesaoPlano()),
				dateFormat.format(s.getBeneficiario().getDatExclusaoPlano()),
				dateFormat.format(s.getDatAtendimento()),
				s.getBeneficiario().getCpfBenef(),
				s.getCodSeqPagamento(),
				s.getTxSinistroPessoa(),
				s.getTxSinistroFamilia(),
				s.getValMediaProcedimento(),
				s.isProbalidadeParcelamento(),
				s.getProbalidadeFraude(),
				s.getScore(),
				s.isFlgFraude());
		}

		csvPrinter.flush();

	}
	
	/*
	public SortedSet<Long> readCsvFraudes( String arquivo) throws IOException,
			URISyntaxException, ParseException {

		SortedSet<Long> fraudes = new TreeSet<Long>();

		Reader reader = Files.newBufferedReader(Paths.get(path + arquivo));

		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
				.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
				.withQuote('"').withDelimiter(','));

		Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		for (CSVRecord csvRecord : csvRecords) {

			fraudes.add(Long.parseLong(csvRecord.get("IDTDOCUMENTO")));

		}

		return fraudes;
	}

	public void writeCsvSinistros(List<Sinistro> sinistros, String arquivo)
			throws IOException, URISyntaxException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("IDTDOCUMENTO",
				"DATINCLUSAO", "DATEXECUCAO", "QTDSERVCOBRADA", "VALITEM",
				 "CNPJCPFPRESTADOR", "CODSERVICO",
				"ESPECIALIDADE", "CODEMPRESA", "CODFAMILIARBENEF", "CODRDP",
				"IDADEANOSSEGURADOSINISTRO", "SEXOSEGURADO",
				"UFRESIDENCIASEGURADO", "FLAGLIMINAR", "DATULTPAGAMENTO",
				 "IDCESCOLARIDADE", "IDCRENDAFAMILIAR", "CPFTITULAR",
				"CPFBENEF", "CODGRAUPARENTESCO", "CODPLANO", "CODPRODUTO",
				"DATADESAOPLANO", "DATEXCLUSAOPLANO", "CODCONSPROFEXEC",
				"SIGUFCRMEXEC", "NUMCRMEXEC", "IDADEMESESAPOLICESINISTRO",
				"PERMAMESESAPOLICESINISTRO", "EXCESSONUMSINISTROSBENEF",
				"EXCESSONUMSINISTROSFAM", "MEDIAPROCEDIMENTOCRM",
				"DOMINGOFERIADO", "DISPERSAOSINISTROSUFBENEF",
				"SCORE", "PROBALIDADEFRAUDE", "FRAUDE").withQuoteMode(QuoteMode.NON_NUMERIC);

		BufferedWriter writer = Files
				.newBufferedWriter(Paths
						.get(path + arquivo));
		CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

		for (Sinistro s : sinistros) {
			csvPrinter.printRecord(
					s.getIdtDocumento(),
					dateFormat.format(s.getDatInclusao()),
					dateFormat.format(s.getDatExecucao()),
					s.getQtdServCobrada(),
					s.getValItem(),
					s.getCnpjCpfPrestador(),
					s.getCodServico(),
					s.getEspecialidade(),
					s.getCodEmpresa(),
					s.getCodFamiliarBenef(),
					s.getCodRdp(),
					s.getIdadeAnosSeguradoSinistro(),
					s.getSexoSegurado(),
					s.getUfResidenciaSegurado(),
					s.getFlagLiminar(),
					(s.getDatUltPagamento() != null) ? dateFormat.format(s
							.getDatUltPagamento()) : "", s
							.getIdcEscolaridade(), s.getIdcRendaFamiliar(), s
							.getCpfTitular(), s.getCpfBenef(), s
							.getCodGrauParentesco(), s.getCodPlano(), s
							.getCodProduto(), dateFormat.format(s
							.getDatAdesaoPlano()), dateFormat.format(s
							.getDatExclusaoPlano()), s.getCodConsProfExec(), s
							.getSigUfCrmExec(), s.getNumCrmExec(), s
							.getIdadeMesesApoliceSinistro(), s
							.getPermaMesesApoliceSinistro(),

					s.getExcessoNumSinistrosBenef(), s.getExcessoNumSinistrosFam(), s
							.getMediaProcedimentoCrm(), s.getDomingoFeriado(), s
							.getDispersaoSinistrosUfBenef(), s.getScore(), s.getProbalidadeFraude(), s
							.isFraude());

		}

		csvPrinter.flush();

	}

	
	//sinistros_flagfraudes_redflags_rules.csv
	public void writeCsvSinistros3(List<Sinistro> sinistros, String arquivo)
			throws IOException, URISyntaxException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(
				"DATINCLUSAO", "DATEXECUCAO", "QTDSERVCOBRADA", "VALITEM",
				 "CNPJCPFPRESTADOR", "CODSERVICO",
				"ESPECIALIDADE", "CODEMPRESA", "CODFAMILIARBENEF", "CODRDP",
				"IDADEANOSSEGURADOSINISTRO", "SEXOSEGURADO",
				"UFRESIDENCIASEGURADO", "FLAGLIMINAR", "DATULTPAGAMENTO",
				 "IDCESCOLARIDADE", "IDCRENDAFAMILIAR", "CPFTITULAR",
				"CPFBENEF", "CODGRAUPARENTESCO", "CODPLANO", "CODPRODUTO",
				"DATADESAOPLANO", "DATEXCLUSAOPLANO", "CODCONSPROFEXEC",
				"SIGUFCRMEXEC", "NUMCRMEXEC", "IDADEMESESAPOLICESINISTRO",
				"PERMAMESESAPOLICESINISTRO", "EXCESSONUMSINISTROSBENEF",
				"EXCESSONUMSINISTROSFAM", "MEDIAPROCEDIMENTOCRM",
				"DOMINGOFERIADO", "DISPERSAOSINISTROSUFBENEF",
				"SCORE", "PROBALIDADEFRAUDE", "FRAUDE").withQuoteMode(QuoteMode.NON_NUMERIC);

		BufferedWriter writer = Files
				.newBufferedWriter(Paths
						.get(path + arquivo));
		CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

		for (Sinistro s : sinistros) {
			csvPrinter.printRecord(
			
					dateFormat.format(s.getDatInclusao()),
					dateFormat.format(s.getDatExecucao()),
					s.getQtdServCobrada(),
					s.getValItem(),
					s.getCnpjCpfPrestador(),
					s.getCodServico(),
					s.getEspecialidade(),
					s.getCodEmpresa(),
					s.getCodFamiliarBenef(),
					s.getCodRdp(),
					s.getIdadeAnosSeguradoSinistro(),
					s.getSexoSegurado(),
					s.getUfResidenciaSegurado(),
					s.getFlagLiminar(),
					(s.getDatUltPagamento() != null) ? dateFormat.format(s
							.getDatUltPagamento()) : "", s
							.getIdcEscolaridade(), s.getIdcRendaFamiliar(), s
							.getCpfTitular(), s.getCpfBenef(), s
							.getCodGrauParentesco(), s.getCodPlano(), s
							.getCodProduto(), dateFormat.format(s
							.getDatAdesaoPlano()), dateFormat.format(s
							.getDatExclusaoPlano()), s.getCodConsProfExec(), s
							.getSigUfCrmExec(), s.getNumCrmExec(), 
							
							(s.getIdadeMesesApoliceSinistro()>=0 && s.getIdadeMesesApoliceSinistro()<=3)? 1:0, 
							(s.getPermaMesesApoliceSinistro()>=0 && s.getPermaMesesApoliceSinistro()<=3)? 1:0, 
							(s.getExcessoNumSinistrosBenef()>=13)? 1:0, 
							(s.getExcessoNumSinistrosFam()>=16)? 1:0, 
							(s.getMediaProcedimentoCrm()>0)? 1:0, 		
							s.getDomingoFeriado(), 
							(s.getDispersaoSinistrosUfBenef()>0)? 1:0, 
			
							
							s.getScore(), 
							s.getProbalidadeFraude(), s
							.isFraude());

		}

		csvPrinter.flush();

	}
	
	//sinistros_flagfraudes_redflags.csv
	public void writeCsvSinistros5(List<Sinistro> sinistros, String arquivo)
			throws IOException, URISyntaxException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(
				"DATINCLUSAO", "DATEXECUCAO", "QTDSERVCOBRADA", "VALITEM",
				 "CNPJCPFPRESTADOR", "CODSERVICO",
				"ESPECIALIDADE", "CODEMPRESA", "CODFAMILIARBENEF", "CODRDP",
				"IDADEANOSSEGURADOSINISTRO", "SEXOSEGURADO",
				"UFRESIDENCIASEGURADO", "FLAGLIMINAR", "DATULTPAGAMENTO",
				 "IDCESCOLARIDADE", "IDCRENDAFAMILIAR", "CPFTITULAR",
				"CPFBENEF", "CODGRAUPARENTESCO", "CODPLANO", "CODPRODUTO",
				"DATADESAOPLANO", "DATEXCLUSAOPLANO", "CODCONSPROFEXEC",
				"SIGUFCRMEXEC", "NUMCRMEXEC", "IDADEMESESAPOLICESINISTRO",
				"PERMAMESESAPOLICESINISTRO", "EXCESSONUMSINISTROSBENEF",
				"EXCESSONUMSINISTROSFAM", "MEDIAPROCEDIMENTOCRM",
				"DOMINGOFERIADO", "DISPERSAOSINISTROSUFBENEF",
				"FRAUDE").withQuoteMode(QuoteMode.NON_NUMERIC);

		BufferedWriter writer = Files
				.newBufferedWriter(Paths
						.get(path + arquivo));
		CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

		for (Sinistro s : sinistros) {
			csvPrinter.printRecord(
			
					dateFormat.format(s.getDatInclusao()),
					dateFormat.format(s.getDatExecucao()),
					s.getQtdServCobrada(),
					s.getValItem(),
					s.getCnpjCpfPrestador(),
					s.getCodServico(),
					s.getEspecialidade(),
					s.getCodEmpresa(),
					s.getCodFamiliarBenef(),
					s.getCodRdp(),
					s.getIdadeAnosSeguradoSinistro(),
					s.getSexoSegurado(),
					s.getUfResidenciaSegurado(),
					s.getFlagLiminar(),
					(s.getDatUltPagamento() != null) ? dateFormat.format(s
							.getDatUltPagamento()) : "", s
							.getIdcEscolaridade(), s.getIdcRendaFamiliar(), s
							.getCpfTitular(), s.getCpfBenef(), s
							.getCodGrauParentesco(), s.getCodPlano(), s
							.getCodProduto(), dateFormat.format(s
							.getDatAdesaoPlano()), dateFormat.format(s
							.getDatExclusaoPlano()), s.getCodConsProfExec(), s
							.getSigUfCrmExec(), s.getNumCrmExec(), 
							
							(s.getIdadeMesesApoliceSinistro()>=0 && s.getIdadeMesesApoliceSinistro()<=3)? 1:0, 
							(s.getPermaMesesApoliceSinistro()>=0 && s.getPermaMesesApoliceSinistro()<=3)? 1:0, 
							(s.getExcessoNumSinistrosBenef()>=13)? 1:0, 
							(s.getExcessoNumSinistrosFam()>=16)? 1:0, 
							(s.getMediaProcedimentoCrm()>0)? 1:0, 		
							s.getDomingoFeriado(), 
							(s.getDispersaoSinistrosUfBenef()>0)? 1:0, 
							s.isFraude());

		}

		csvPrinter.flush();

	}
	
	//sinistros_flagfraudes_rules.csv
	public void writeCsvSinistros4(List<Sinistro> sinistros, String arquivo)
			throws IOException, URISyntaxException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(
				"DATINCLUSAO", "DATEXECUCAO", "QTDSERVCOBRADA", "VALITEM",
				 "CNPJCPFPRESTADOR", "CODSERVICO",
				"ESPECIALIDADE", "CODEMPRESA", "CODFAMILIARBENEF", "CODRDP",
				"IDADEANOSSEGURADOSINISTRO", "SEXOSEGURADO",
				"UFRESIDENCIASEGURADO", "FLAGLIMINAR", "DATULTPAGAMENTO",
				 "IDCESCOLARIDADE", "IDCRENDAFAMILIAR", "CPFTITULAR",
				"CPFBENEF", "CODGRAUPARENTESCO", "CODPLANO", "CODPRODUTO",
				"DATADESAOPLANO", "DATEXCLUSAOPLANO", "CODCONSPROFEXEC",
				"SIGUFCRMEXEC", "NUMCRMEXEC", 
				"SCORE", "PROBALIDADEFRAUDE", "FRAUDE").withQuoteMode(QuoteMode.NON_NUMERIC);

		BufferedWriter writer = Files
				.newBufferedWriter(Paths
						.get(path + arquivo));
		CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

		for (Sinistro s : sinistros) {
			csvPrinter.printRecord(
			
					dateFormat.format(s.getDatInclusao()),
					dateFormat.format(s.getDatExecucao()),
					s.getQtdServCobrada(),
					s.getValItem(),
					s.getCnpjCpfPrestador(),
					s.getCodServico(),
					s.getEspecialidade(),
					s.getCodEmpresa(),
					s.getCodFamiliarBenef(),
					s.getCodRdp(),
					s.getIdadeAnosSeguradoSinistro(),
					s.getSexoSegurado(),
					s.getUfResidenciaSegurado(),
					s.getFlagLiminar(),
					(s.getDatUltPagamento() != null) ? dateFormat.format(s
							.getDatUltPagamento()) : "", s
							.getIdcEscolaridade(), s.getIdcRendaFamiliar(), s
							.getCpfTitular(), s.getCpfBenef(), s
							.getCodGrauParentesco(), s.getCodPlano(), s
							.getCodProduto(), dateFormat.format(s
							.getDatAdesaoPlano()), dateFormat.format(s
							.getDatExclusaoPlano()), s.getCodConsProfExec(), s
							.getSigUfCrmExec(), s.getNumCrmExec(),  s.getScore(), s.getProbalidadeFraude(), s
							.isFraude());

		}

		csvPrinter.flush();

	}
	
	*/
}
