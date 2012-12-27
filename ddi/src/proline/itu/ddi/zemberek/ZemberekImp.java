package proline.itu.ddi.zemberek;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
	public  void main() throws Throwable {

	}
	public ZemberekImp(String text){
		this.fullText = text;
	}
	public String doIt(){


		try {

        	//setFullText("Protokolün yapısı son derece basittir.");
        	
			InputStream fullTextInputStream = new ByteArrayInputStream(getFullText().getBytes("UTF-8"));
        	TurkishTokenStream token = new TurkishTokenStream(fullTextInputStream, "UTF-8");
			Zemberek z = new Zemberek(new TurkiyeTurkcesi());
			String tok ;
        	while(( tok = token.nextWord()) != null){
        	sonuc = z.kelimeCozumle(tok);
	        	for(int i =0 ; i<sonuc.length;i++){
	             c += sonuc[i].toString() + "\n";
	        	}
        	}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.c;
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
