package hd.udb.formation.controller;

import hd.udb.formation.model.Enseignant;
import hd.udb.formation.service.IEnseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Enseigant")
public class enseignantController {
	
	@Autowired
	private IEnseignant iEnseignant;
	
	@RequestMapping(value="")
	public String view(Model model){
		Enseignant en = new Enseignant();
		model.addAttribute("enseignant_objet", en);

		return "enseignant";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("enseignant_objet") Enseignant en , Model model){
	
		iEnseignant.save(en);
		
		return "enseignant";
	}
	
}