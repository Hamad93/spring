package hd.udb.formation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class defaultController {
	@RequestMapping(value="")
	public String acceuil(Model model){

		return "index";
	}
}
