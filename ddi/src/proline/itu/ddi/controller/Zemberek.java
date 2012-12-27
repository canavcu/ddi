package proline.itu.ddi.controller;

////UrlBasedViewResolver
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import proline.itu.ddi.model.UploadItem;
import proline.itu.ddi.zemberek.File;
import proline.itu.ddi.zemberek.ZemberekImp;


@Controller
@RequestMapping("/zemberek/*")
public class Zemberek  {

	private String sonuc;
	private String zemSOnuc = "s";
	private ModelAndView modelAndView;
	private String fileSonuc;
	public ModelAndView movPost;
	public String file;
	public String fileStr = "";
	public String zemSonuc = "";
	//value="demo"
//	 @RequestMapping(method = RequestMethod.GET)
//	  public String getUploadForm()
//	  {
//	   
//	  }
	@RequestMapping(value="out")
	  public ModelAndView out(String zem) throws IOException
	  { 
		return new ModelAndView("out","message",zem);
	  }
	@SuppressWarnings("null")
	@RequestMapping(method = RequestMethod.POST)
	  public ModelAndView create(UploadItem uploadItem, BindingResult result) throws IOException
	  {
	    if (result.hasErrors())
	    {
	      for(ObjectError error : result.getAllErrors())
	      {
	        System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
	      }
	     // return "/zemberek";
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

	    // Some type of file processing...
	    System.err.println("-------------------------------------------");

	    System.err.println("Test upload: " + uploadItem.getName());
	    System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
	    System.err.println("-------------------------------------------");
	 
	    return new ModelAndView("out","message",fileName);
	  }
	//value="demo"
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response,Model model) throws ServletException, IOException,
			Exception {
		 
		  
		String aMessage = "zemberrek!";
		String textparm = (String) request.getParameter("text");

		// String tab = (String)request.getParameter("submit") ;
		// String attr = (String) request.getAttribute("text");
		if (textparm != null && textparm != "") {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			model.addAttribute(new UploadItem());
			aMessage = (String) request.getParameter("text");
			ZemberekImp zem = new ZemberekImp(aMessage);
			this.sonuc = zem.doIt();
			aMessage = getSonuc();
			modelAndView = new ModelAndView("zemberek");// zemberek ti
			modelAndView.addObject("message", aMessage);
		} else {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			model.addAttribute(new UploadItem());
			modelAndView = new ModelAndView("zemberek");
			modelAndView.addObject("message", aMessage);
		}
		return modelAndView;
	}//value="fileupload"
//	@RequestMapping(method=RequestMethod.POST)
//	public String onSubmit(UploadItem uploadItem, BindingResult result)
//			throws ServletException, IOException {
//		String can ="can";
//		try {
//			//FileUploadBean bean = (FileUploadBean) command;
//			//byte[] file = bean.getFile();
////			 if (file == null) {
////	             // hmm, that's strange, the user did not upload anything
////	        }
//			//String textFile = (String) request.getParameter("file");
//			//String fileSonuc;
//			//ZemberekImp zem = new ZemberekImp(textFile);
//			//setFileSonuc(zem.doIt());
//			fileSonuc = getFileSonuc();
//			movPost = new ModelAndView("zemberek");// zemberek ti
//			movPost.addObject("message", can);
//	
//			//return super.onSubmit(request, response, command, errors);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return "zemberek";
//	}

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
