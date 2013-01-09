package proline.itu.ddi.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import proline.itu.ddi.zemberek.ZemberekImp;

@Controller
@RequestMapping("/zemdeascii")
public class Zemdeascii {

	private String sonuc ;
	
	@RequestMapping(method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ModelAndView handleRequest(@RequestParam(value ="text", required = false) String mesg, Model model) throws  IOException,
			Exception {
		
		String aMessage = "zemberekj deascii";
		ModelAndView modelAndView = new ModelAndView("zemdeascii");
		modelAndView.addObject("message", aMessage);
		
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ModelAndView handlePost(@RequestParam(value ="text", required = false) String mesg, Model model) throws  IOException,
			Exception {
		
		ZemberekImp zem = new ZemberekImp(mesg);
		setSonuc( zem.doZemDeAscii());
		ModelAndView modelAndView = new ModelAndView("zemdeascii");
		modelAndView.addObject("message", getSonuc());
		
		return modelAndView;
	}
	public String getSonuc() {
		return sonuc;
	}
	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}
}
