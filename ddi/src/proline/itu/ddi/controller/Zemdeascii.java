package proline.itu.ddi.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import proline.itu.ddi.model.UploadItem;
import proline.itu.ddi.zemberek.Zem;
import proline.itu.ddi.zemberek.ZemInput;
import proline.itu.ddi.zemberek.ZemString;
import proline.itu.ddi.zemberek.ZemberekImp;

@Controller
@RequestMapping("/zemdeascii")
public class Zemdeascii {

	private String sonuc ;
	public String zemSonuc;
	
	@RequestMapping(method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ModelAndView handleRequest(@RequestParam(value ="text", required = false) String mesg, Model model) throws  IOException,	Exception {
		
		model.addAttribute(new UploadItem());
		String aMessage = "zemberekj deascii";
		ModelAndView modelAndView = new ModelAndView("zemdeascii");
		modelAndView.addObject("message", aMessage);
		
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ModelAndView handlePost(@RequestParam(value ="text", required = false) String mesg, Model model) throws  IOException,
			Exception {
		
		model.addAttribute(new UploadItem());
		
		Zem zem = new ZemString(mesg);
        ZemberekImp zemImp = new ZemberekImp(zem.getInputStream());
		setSonuc( zemImp.doZemDeAscii());
		ModelAndView modelAndView = new ModelAndView("zemdeascii");
		modelAndView.addObject("message", getSonuc());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/zemdeascii/out", method = RequestMethod.POST)
	  public void create(UploadItem uploadItem, BindingResult result, HttpServletResponse  response ) throws IOException, ServletException
	  {

		long ikiMB = 2*1024*1024;
		MultipartFile multipartFile = uploadItem.getFileData();
		
		//String fileName = "out.txt";
     InputStream inputStream = null;
	    InputStream outStream = null;
     
     if (result.hasErrors())
	    {
	      for(ObjectError error : result.getAllErrors())
	      {
	        System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
	      }
	 
	    }
	    
      if(multipartFile.getSize() > ikiMB)
      {
     	 //ModelAndView modelerr =  new ModelAndView("out","message",zemSonuc);
     	 System.err.println("Error: file size can not be bigger than 2 MB... ");
     	 return;
      }
      
      if (multipartFile.getSize() == 0) { 
     	 
     	 System.out.println("file yok");
     	 return;
      }
      if (multipartFile.getSize() > 0) {
              inputStream = multipartFile.getInputStream();

              //System.out.println("size::" + multipartFile.getSize());
             
             // System.out.println("fileName:" + multipartFile.getOriginalFilename());

              Zem zem = new ZemInput(inputStream);
              ZemberekImp zemImp = new ZemberekImp(zem.getInputStream());
              zemSonuc = zemImp.doZemDeAscii();

              outStream = new ByteArrayInputStream( zemSonuc.getBytes("UTF-8"));
              //System.out.println(zemSonuc);
              // out(zemSonuc);
              //ModelAndView model =  new ModelAndView("out","message",zemSonuc);
              response.reset();
              response.setContentType("text/plain");
              response.setCharacterEncoding("UTF-8");
              response.encodeURL("UTF-8");
            
              response.setHeader("Content-Disposition", "attachment;filename=out.txt");
              IOUtils.copy(outStream, response.getOutputStream());//getOutputStream()
              
              response.flushBuffer();
              inputStream.close();
              outStream.close();
              //return model;
      }

	
	    System.err.println("-------------------------------------------");

	    System.err.println("Test upload: " + uploadItem.getName());
	    System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
	    System.err.println("-------------------------------------------");
      
	   // return new ModelAndView("out","message",fileName);
	  }
	
	public String getSonuc() {
		return sonuc;
	}
	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}
}
