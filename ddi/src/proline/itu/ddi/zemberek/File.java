package proline.itu.ddi.zemberek;


import java.io.InputStream;

public class File {

	private String fileStr;
	private InputStream inputStream;
	public String file = "";
	
	public File(InputStream input){
		 this.inputStream = input;
	}
	
	public String Read(){
		
		@SuppressWarnings("unused")
		int readBytes = 0;
        byte[] buffer = new byte[10000];
        try {
        	
			while ((readBytes = this.inputStream.read(buffer, 0, 10000)) != -1) {
			       file += new String(buffer);
			}
			setFileStr(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return getFileStr(); 
	}

	public String getFileStr() {
		return fileStr;
	}

	public void setFileStr(String fileStr) {
		this.fileStr = fileStr;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
