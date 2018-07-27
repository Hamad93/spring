package m2gl.sn.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {

	@RequestMapping(value="/load")
	public String loadService(){
		return "service";
	}
}
