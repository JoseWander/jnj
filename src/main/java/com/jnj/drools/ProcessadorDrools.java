package com.jnj.drools;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.jnj.mvc.entity.Sinistro;

/**
 * This is a sample class to launch a rule.
 */
public class ProcessadorDrools {

	public Sinistro calculaProbalidadeFraude(Sinistro sinistro) {

		try { 
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			kSession.insert(sinistro);
			sinistro.setProbalidadeFraude("BAIXA");

			System.out.println("fireAllRules");

			kSession.fireAllRules();
			
			System.out.println("calculaProbalidadeFraude >> " + sinistro.getProbalidadeFraude());
			

		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		return sinistro;

	}
}
