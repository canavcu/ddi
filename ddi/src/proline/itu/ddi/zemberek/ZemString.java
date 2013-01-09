package proline.itu.ddi.zemberek;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ZemString implements Zem{

	private InputStream input;
	private String textStr;
	
	public ZemString(String str ) {
		 this.textStr = str;
		}
	
	public InputStream getInputStream() {
	
		try {
			setInput(new ByteArrayInputStream((getTextStr().getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return getInput();
	}
	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public String getTextStr() {
		return textStr;
	}

	public void setTextStr(String textStr) {
		this.textStr = textStr;
	}
	
}
