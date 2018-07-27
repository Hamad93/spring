package hd.udb.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Module")
public class moduleController {
	@RequestMapping(value="")
	public String view(Model model){
		return "module";
	}
}