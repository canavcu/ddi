package proline.itu.ddi.controller;

////UrlBasedViewResolver
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;




//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import proline.itu.ddi.model.UploadItem;
import proline.itu.ddi.zemberek.File;
import proline.itu.ddi.zemberek.ZemberekImp;

@Controller
@RequestMapping("/zemberek")
public class Zemberek  {

	private String sonuc;
	private String zemSOnuc = "s";
	private ModelAndView modelAndView;
	private String fileSonuc;
	public ModelAndView movPost;
	public String file;
	public String fileStr = "";
	public String zemSonuc = "";
	//public UploadItem uploadItem;
	
	
	public Zemberek(){

	}
	

	@RequestMapping(value="/zemberek", method = RequestMethod.GET)
	public ModelAndView handleGetRequest(@RequestParam(value ="text" , required = false) String mesg, Model model) throws  IOException, Exception {

		String aMessage = "zemberrek!";
	
		model.addAttribute(new UploadItem());
		modelAndView = new ModelAndView("zemberek");
		modelAndView.addObject("message", aMessage);

		return modelAndView;
	}

	@RequestMapping(value="/zemberek/demo", method = RequestMethod.POST)
	public ModelAndView handleDemoRequest(@RequestParam(value ="text" , required = false) String mesg, Model model) throws  IOException, Exception {

		String aMessage = "zemberrek!";
		String textparm = mesg;
			
			model.addAttribute(new UploadItem());
			aMessage = textparm;
			ZemberekImp zem = new ZemberekImp(aMessage);
			this.sonuc = zem.doIt();
			aMessage = getSonuc();
			modelAndView = new ModelAndView("zemberek");
			modelAndView.addObject("message", aMessage);
		return modelAndView;
	}
	
//value="/zemberek",
	
	@RequestMapping(value="/zemberek/out",method = RequestMethod.POST)
	  public ModelAndView create(UploadItem uploadItem, BindingResult result) throws IOException
	  {
	    if (result.hasErrors())
	    {
	      for(ObjectError error : result.getAllErrors())
	      {
	        System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
	      }
	 
	    }
	    
		MultipartFile multipartFile = uploadItem.getFileData();
		 String fileName = null;
         InputStream inputStream = null;
     
         if (multipartFile.getSize() > 0) {
                 inputStream = multipartFile.getInputStream();
                
                 if (multipartFile.getSize() > 10000) {
                         System.out.println("File Size:" + multipartFile.getSize());
                         return new ModelAndView("zemberek","message",zemSonuc);
                 }
                 System.out.println("size::" + multipartFile.getSize());
                
               
                 System.out.println("fileName:" + multipartFile.getOriginalFilename());
                 File fileoku = new File(inputStream);
                 fileStr = fileoku.Read();
                 ZemberekImp zem = new ZemberekImp(fileStr);
                 zemSonuc = zem.doIt();
                 //System.out.println(zemSonuc);
                // out(zemSonuc);
                 ModelAndView model =  new ModelAndView("out","message",zemSonuc);
                 inputStream.close();
                 return model;
         }

	
	    System.err.println("-------------------------------------------");

	    System.err.println("Test upload: " + uploadItem.getName());
	    System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
	    System.err.println("-------------------------------------------");
	 
	    return new ModelAndView("out","message",fileName);
	  }

	

	public String getFileSonuc() {
		return fileSonuc;
	}

	public void setFileSonuc(String fileSonuc) {
		this.fileSonuc = fileSonuc;
	}

	public String getSonuc() {
		return sonuc;
	}

	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}

	public String getZemSOnuc() {
		return zemSOnuc;
	}

	public void setZemSOnuc(String zemSOnuc) {
		this.zemSOnuc = zemSOnuc;
	}

	public Class<? extends Annotation> annotationType() {
		
		return null;
	}

	public String value() {
		
		return null;
	}

}
