package com.jnj.mvc.controller;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.jnj.drools.ProcessadorDrools;
import com.jnj.mvc.entity.Sinistro;
import com.jnj.mvc.repository.SinistroRepository;
import java.util.ArrayList;
import java.util.List;
  
@Controller
@RequestMapping("/sinistros")
public class SinistroController {
       
      private SinistroRepository sinistroRepository;
  
      @Autowired
      public SinistroController(SinistroRepository sinistroRepository) {
            this.sinistroRepository = sinistroRepository;
      }
      
      @RequestMapping(method = RequestMethod.GET)
      public String listaSinistros(Model model) {
            List<Sinistro> listaSinistros =  sinistroRepository.findAll();		
            
            /*
            for (Sinistro s: listaSinistros) {
            	System.out.println("getCodSinistro " + s.getCodSinistro() + " isFlgFraude " + s.isFlgFraude());
            }
            */
            
            if (listaSinistros != null) {
                  model.addAttribute("sinistros", listaSinistros);
                  //System.out.println("listaSinistros.size() " + listaSinistros.size());
            }
            return "listaSinistros";
      }
  
      @RequestMapping(value = "/calculaProbalidadeFraude", method = RequestMethod.GET)
      public String calculaProbalidadeFraude(@RequestParam("codSinistro") Long codSinistro) {
    	  
    	    System.out.println("calculaProbalidadeFraude " + codSinistro);
    	    
    	  	Sinistro sinistro = sinistroRepository.findOne(codSinistro);
    	  	
    	  	ProcessadorDrools processadorDrools=new ProcessadorDrools();
    	  	sinistro=processadorDrools.calculaProbalidadeFraude(sinistro);
    	  	
    	  	sinistroRepository.save(sinistro);
            return "redirect:/sinistros";
      }
}