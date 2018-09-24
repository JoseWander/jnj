package com.ipt.main;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ipt.model.*;
import com.ipt.utils.*;

/**
 * This is a sample class to launch a rule.
 */
public class ProcessadorDrools {

	public static final void main(String[] args) {

		try { 
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			ManipuladorCsv manipuladorCsv = new ManipuladorCsv();
			
			Date ini = new Date();
			ini.setTime(System.currentTimeMillis());

			System.out.println("lendo arquivo");
			
			List<Sinistro> sinistros = manipuladorCsv.readCsvSinistros2(0,"sinistros_2.2.csv");
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ini.getTime()) + " segs");
			ini.setTime(System.currentTimeMillis());
			
			System.out.println("inserindo kSession");
			
			for (Sinistro sinistro : sinistros) {
				//if(sinistro.getFraude()==1)
				kSession.insert(sinistro);
			}

			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ini.getTime()) + " segs");
			ini.setTime(System.currentTimeMillis());
			
			System.out.println("fireAllRules");
			
			kSession.fireAllRules();

			
			int count=0;
			int contScore=0;		
			for (Sinistro sinistro : sinistros) {
				if(sinistro.isFlgFraude() ){
					count++;
					contScore=contScore+sinistro.getScore();
					System.out.println("codSinistro " + sinistro.getCodSinistro() 
							+ " probalidadeParcelamento " + sinistro.isProbalidadeParcelamento()
							+ " probalidade " + sinistro.getProbalidadeFraude()
							+ "  score " + sinistro.getScore() );

				}
			}
			
			System.out.println((double)contScore/count);
			
			
			 count=0;
			 contScore=0;		
			for (Sinistro sinistro : sinistros) {
				if(!sinistro.isFlgFraude() && !sinistro.getProbalidadeFraude().equals("BAIXA")){
					count++;
					contScore=contScore+sinistro.getScore();
					System.out.println("codSinistro " + sinistro.getCodSinistro() 
							+ " probalidadeParcelamento " + sinistro.isProbalidadeParcelamento()
							+ " probalidade " + sinistro.getProbalidadeFraude()
							+ "  score " + sinistro.getScore() );
					}
			}

			
			System.out.println((double)contScore/count);
	
			
			
			
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ini.getTime()) + " segs");
			ini.setTime(System.currentTimeMillis());
			
			System.out.println("escrevendo arquivo");
			manipuladorCsv.writeCsvSinistros3(sinistros,"sinistros_3.2.csv");
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ini.getTime()) + " segs");
			System.out.println("fim");

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}


}
