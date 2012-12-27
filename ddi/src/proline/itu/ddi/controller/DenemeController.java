package proline.itu.ddi.controller;



import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/welcome")
public class DenemeController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) throws Exception {
 
		Date date = new Date();
		model.addAttribute("msg",date);
		return "welcome";
 
	}
}
