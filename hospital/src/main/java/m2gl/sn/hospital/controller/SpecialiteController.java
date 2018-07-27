package m2gl.sn.hospital.controller;

import java.util.List;
import java.util.Optional;

import m2gl.sn.hospital.model.Specialite;
import m2gl.sn.hospital.service.ISpecialite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jayway.jsonpath.Option;

@Controller
@RequestMapping(value="/specialite")
public class SpecialiteController {
	
	/* */
	@Autowired
	private ISpecialite iSpecialite;

	@RequestMapping(value="/add")
	public String addspecialite(Model model){
		
		Specialite s = new Specialite();
		model.addAttribute("specialite_objet", s);
		return "specialite";
	}
	
	@RequestMapping(value="/list")
	public String listspecialite(Model model){
		
		Specialite s = new Specialite();
		model.addAttribute("specialite_objet", s);
		Iterable<Specialite> specialites = iSpecialite.findAll();
		model.addAttribute ("lesspecialites", specialites);
		return "list_specialite";
	}
	
	@RequestMapping(value="/edit")
	public String editspecialite(@RequestParam("id") String id, Model model){
		
		Optional<Specialite> s = iSpecialite.findById(Integer.parseInt(id));
		
		if(s.isPresent()){
			model.addAttribute ("specialite_objet", s.get());
			return "specialite";
		}
		
		Iterable<Specialite> specialites = iSpecialite.findAll();
		model.addAttribute ("lesspecialites", specialites);
		return "list_specialite";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addspecialite(@ModelAttribute("specialite_objet") Specialite sp , Model model){
	
		
		if(iSpecialite.findByLibelle(sp.getLibelle())!=null){
			model.addAttribute ("message","une specialite avec ce libelle existe deja en BD");
			
			return "specialite";
		}
		
		iSpecialite.save(sp);
		Iterable<Specialite> specialites = iSpecialite.findAll();
		model.addAttribute ("lesspecialites", specialites);
		
		return "list_specialite";
	}
}
