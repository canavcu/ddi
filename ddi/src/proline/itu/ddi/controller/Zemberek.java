package proline.itu.ddi.controller;

////UrlBasedViewResolver
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

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

	@RequestMapping(value="/zemberek", method = RequestMethod.POST)
	public ModelAndView handleDemoRequest(@RequestParam(value ="text" , required = false) String mesg, Model model) throws  IOException, Exception {

		String aMessage = "zemberrek!";
		String textparm = mesg;
			
			model.addAttribute(new UploadItem());
			aMessage = textparm;
			Zem zem = new ZemString(aMessage);
            ZemberekImp zemImp = new ZemberekImp(zem.getInputStream());
			
			this.sonuc = zemImp.doIt();
			aMessage = getSonuc();
			modelAndView = new ModelAndView("zemberek");
			modelAndView.addObject("message", aMessage);
		return modelAndView;
	}
	
//value="/zemberek",
	
	@RequestMapping(value="/zemberek/out",method = RequestMethod.POST)
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
         
         
         if (multipartFile.getSize() > 0) {
                 inputStream = multipartFile.getInputStream();
                // multipartFile.
                    
              
                 System.out.println("size::" + multipartFile.getSize());
                
               
                 System.out.println("fileName:" + multipartFile.getOriginalFilename());
//                 File fileoku = new File(inputStream);
//                 fileStr = fileoku.Read();
                 Zem zem = new ZemInput(inputStream);
                 ZemberekImp zemImp = new ZemberekImp(zem.getInputStream());
                 zemSonuc = zemImp.doIt();
                 outStream = new ByteArrayInputStream( zemSonuc.getBytes("UTF-8"));
                 //System.out.println(zemSonuc);
                // out(zemSonuc);
                 //ModelAndView model =  new ModelAndView("out","message",zemSonuc);
                 response.reset();
                 response.setContentType("text/plain; charset=UTF-8");
                 response.setCharacterEncoding("UTF-8");
                 response.encodeURL("UTF-8");
               
                 response.setHeader("Content-Disposition", "attachment;filename=out.txt");
                 IOUtils.copy(outStream, response.getOutputStream());//getOutputStream()
                 
                 response.flushBuffer();
                 inputStream.close();
                 
                 //return model;
         }

	
	    System.err.println("-------------------------------------------");

	    System.err.println("Test upload: " + uploadItem.getName());
	    System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
	    System.err.println("-------------------------------------------");
	 
	   // return new ModelAndView("out","message",fileName);
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
