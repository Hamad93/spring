package m2gl.sn.hospital.controller;

import java.util.Optional;

import m2gl.sn.hospital.model.Medecin;
import m2gl.sn.hospital.model.Service;
import m2gl.sn.hospital.model.Specialite;
import m2gl.sn.hospital.service.IMedecin;
import m2gl.sn.hospital.service.IService;
import m2gl.sn.hospital.service.ISpecialite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/medecin")
public class MedecinController {
	
	@Autowired
	private IMedecin iMedecin;
	
	@Autowired
	private ISpecialite iSpecialite;
	
	@Autowired
	private IService iService;
	
	@RequestMapping(value="/add")
	public String addmedecin(Model model){
		
		Medecin m = new Medecin();
		m.setSpecialite(new Specialite());
		m.setService(new Service());
		model.addAttribute("medecin_objet", m);
		Iterable<Specialite> specialites = iSpecialite.findAll();
		model.addAttribute("specialites", specialites);
		Iterable<Service> services = iService.findAll();
		model.addAttribute("services", services);
		
		return "medecin";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addspecialite(@ModelAttribute("medecin_objet") Medecin m , Model model){
	
		
		if(m.getId()==0 && iMedecin.findByMatricule(m.getMatricule())!=null){
			model.addAttribute ("message","un medecin avec ce matricule existe deja en BD");
			Iterable<Medecin> medecins = iMedecin.findAll();
			model.addAttribute ("lesmedecins", medecins);
			return "medecin";
		}
	
		
		iMedecin.save(m);
		Iterable<Medecin> medecins = iMedecin.findAll();
		model.addAttribute ("lesmedecins", medecins);
		
		return "list_medecin";
	}
	
	
	@RequestMapping(value="/list")
	public String listmedecin(Model model){
		
		Iterable<Medecin> medecins = iMedecin.findAll();
		model.addAttribute ("lesmedecins", medecins);
		return "list_medecin";
	}
	
	
	
	
	@RequestMapping(value="/edit")
	public String editMedecin(@RequestParam("id") String id, Model model){
		
		Optional<Medecin> m = iMedecin.findById(Integer.parseInt(id));
		
		if(m.isPresent()){
			Iterable<Specialite> specialites = iSpecialite.findAll();
			model.addAttribute("specialites", specialites);
			Iterable<Service> services = iService.findAll();
			model.addAttribute("services", services);
			model.addAttribute ("medecin_objet", m.get());
			return "medecin";
		}
		Iterable<Medecin> medecins = iMedecin.findAll();
		model.addAttribute ("lesmedecins", medecins);
		return "list_medecin";
	}
	
	@RequestMapping(value="/delete")
	public String deleteMedecin(@RequestParam("id") String id, Model model){
		
		Optional<Medecin> m = iMedecin.findById(Integer.parseInt(id));
		
		if(m.isPresent()){
			iMedecin.deleteById(Integer.parseInt(id));
		}
		Iterable<Medecin> medecins = iMedecin.findAll();
		model.addAttribute ("lesmedecins", medecins);
		return "redirect:list";
	}
}
