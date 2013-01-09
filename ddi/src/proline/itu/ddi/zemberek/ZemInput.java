package proline.itu.ddi.zemberek;

import java.io.InputStream;


public class ZemInput implements Zem {
	
	private InputStream input;
	
	public ZemInput(InputStream inputStrm ) {
	 this.input = inputStrm;
	}
	
	public InputStream getInputStream() {
	
		return getInput();
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

}
