package hd.udb.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/Evaluation")
public class evaluationController {	
	@RequestMapping(value="")
	public String view(Model model){

		return "evaluation";
	}
}