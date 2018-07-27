package hd.udb.formation.controller;

import java.util.Optional;

import hd.udb.formation.model.Promotion;
import hd.udb.formation.service.IPromotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/Promotion")
public class promotionController {
	
	@Autowired
	private IPromotion iPromotion;
	
	@RequestMapping(value="")
	public String view(Model model){
		Promotion p = new Promotion();
		model.addAttribute("promotion_objet", p);
		Iterable<Promotion> promotions = iPromotion.findAll();
		model.addAttribute ("lespromotions", promotions);
		return "promotion";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("promotion_objet") Promotion p , Model model){
	
		
		if(p.getDatedebut()==null || p.getDatefin()==null){
			model.addAttribute ("message","un avec ce matricule existe deja en BD");
			Iterable<Promotion> promotions = iPromotion.findAll();
			model.addAttribute ("lespromotions", promotions);
			return "promotion";
		}
	
		iPromotion.save(p);
		Iterable<Promotion> promotions = iPromotion.findAll();
		model.addAttribute ("lespromotions", promotions);
		return "redirect:/Promotion";
	}
	
	@RequestMapping(value="/edit")
	public String edit(@RequestParam("id") String id, Model model){
		
		Optional<Promotion> p = iPromotion.findById(Integer.parseInt(id));
		
		if(p.isPresent()){
			model.addAttribute ("promotion_objet", p.get());
			Iterable<Promotion> promotions = iPromotion.findAll();
			model.addAttribute ("lespromotions", promotions);
			model.addAttribute ("update", true);
			return "promotion";
		}
		Iterable<Promotion> promotions = iPromotion.findAll();
		model.addAttribute ("lespromotions", promotions);
		return "promotion";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("id") String id, Model model){
		
		Optional<Promotion> p = iPromotion.findById(Integer.parseInt(id));
		
		if(p.isPresent()){
			iPromotion.deleteById(Integer.parseInt(id));
		}
		Iterable<Promotion> promotions = iPromotion.findAll();
		model.addAttribute ("lespromotions", promotions);
		return "redirect:/Promotion";
	}
}