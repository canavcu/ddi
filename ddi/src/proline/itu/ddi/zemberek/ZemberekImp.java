package proline.itu.ddi.zemberek;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;

import net.zemberek.araclar.turkce.TurkishTokenStream;
import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Alfabe;
import net.zemberek.yapi.Kelime;

public class ZemberekImp {

	private String path; 
	private Alfabe alfabe;
	private String alfebePath;
	private String fullText; 
	public Kelime[] sonuc;
	private String c ="";
	public String word = "";
	public String[] kelimeDizisi ;
	private InputStream inputStrm ;
	
	public ZemberekImp(InputStream stream){
		this.inputStrm = stream;
	}
	public ZemberekImp(String text){
		this.fullText = text;
	}
	public String doIt(){
		try {
        	
			//InputStream fullTextInputStream = getInputStrm();//new ByteArrayInputStream(getFullText().getBytes("UTF-8"));
        	TurkishTokenStream token = new TurkishTokenStream(getInputStrm(), "UTF-8");
			Zemberek z = new Zemberek(new TurkiyeTurkcesi());
			String tok ;
        	while(( tok = token.nextWord()) != null){
	        	sonuc = z.kelimeCozumle(tok);
	        	   c +=  organizeMorphAnlyzrOutput(tok,sonuc) + "\n";
        	}
        	

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.c;
	}
	public String doZemAscii(){
		
		try {
			InputStream fullTextInputStream = new ByteArrayInputStream(getFullText().getBytes("UTF-8"));
        	TurkishTokenStream token = new TurkishTokenStream(fullTextInputStream, "UTF-8");
			Zemberek z = new Zemberek(new TurkiyeTurkcesi());
			String tok ;
			while(( tok = token.nextWord()) != null){
	        	word = z.asciiyeDonustur(tok);
	        	c += word + " ";
		        
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.c;
	}

	public String doZemDeAscii(){
		int i=0;
		
		try {
			InputStream fullTextInputStream = new ByteArrayInputStream(getFullText().getBytes("UTF-8"));
        	TurkishTokenStream token = new TurkishTokenStream(fullTextInputStream, "UTF-8");
			Zemberek z = new Zemberek(new TurkiyeTurkcesi());
			String tok ;
			
			while(( tok = token.nextWord()) != null){
	        	//i = z.asciidenTurkceye(tok).length;
				i = 1;
				kelimeDizisi = new String[i];	
	        	for(int p = 0 ;p < i ; p++){
	        		
	        		kelimeDizisi[p] = z.asciidenTurkceye(tok)[p];
	        		word += kelimeDizisi[p].toString() + " ";
	        	}
	        	//i = 0;
			}
			c = word;
	        
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.c;
	}
	
	public String organizeMorphAnlyzrOutput(String word, Kelime[] result){

		String firstResult = word + " : ";
		
    	for(int i =0 ; i < sonuc.length ; i++){

    		firstResult +=  result[i].toString() + ",";		
    	}		
		return firstResult;
	}
	
	
	public InputStream getInputStrm() {
		return inputStrm;
	}
	public void setInputStrm(InputStream inputStrm) {
		this.inputStrm = inputStrm;
	}
	public String getFullText() {
		return fullText;
	}


	public void setFullText(String fullText) {
		this.fullText = fullText;
	}


	public String getAlfebePath() {
		return alfebePath;
	}


	public void setAlfebePath(String alfebePath) {
		this.alfebePath = alfebePath;
	}


	public Alfabe getAlfabe() {
		return alfabe;
	}


	public void setAlfabe(Alfabe alfabe) {
		this.alfabe = alfabe;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
}
