package proline.itu.ddi.controller;

import java.io.IOException;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;




//public class FileUpload implements Controller{
//	
//	private ModelAndView movPost;
//	private String fileSonuc;
//	private ModelAndView model;
//
//	public ModelAndView onSubmit(HttpServletRequest request,
//			HttpServletResponse response, Object command, BindException errors)
//			throws ServletException, IOException {
//		try {
//		//	FileUploadBean bean = (FileUploadBean) command;
//		//	byte[] file = bean.getFile();
////			 if (file == null) {
////	             // hmm, that's strange, the user did not upload anything
////	        }
////			String textFile = (String) request.getParameter("file");
////			String fileSonuc;
////			ZemberekImp zem = new ZemberekImp(textFile);
////			setFileSonuc(zem.doIt());
////			fileSonuc = getFileSonuc();
////			movPost = new ModelAndView("zemberek");// zemberek ti
////			movPost.addObject("message", fileSonuc);
////	
//			//return super.onSubmit(request, response, command, errors);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return movPost;
//	}
//
//	protected void initBinder(HttpServletRequest request,
//			ServletRequestDataBinder binder) throws ServletException {
//		// to actually be able to convert Multipart instance to byte[]
//		// we have to register a custom editor
//		binder.registerCustomEditor(byte[].class,
//				new ByteArrayMultipartFileEditor());
//		// now Spring knows how to handle multipart object and convert them
//	}

//	public ModelAndView getMovPost() {
//		return movPost;
//	}
//
//	public void setMovPost(ModelAndView movPost) {
//		this.movPost = movPost;
//	}
//
//	public String getFileSonuc() {
//		return fileSonuc;
//	}
//
//	public void setFileSonuc(String fileSonuc) {
//		this.fileSonuc = fileSonuc;
//	}
//
//	public ModelAndView getModel() {
//		return model;
//	}
//
//	public void setModel(ModelAndView model) {
//		this.model = model;
//	}
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest arg0,
//			HttpServletResponse arg1) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
// }

