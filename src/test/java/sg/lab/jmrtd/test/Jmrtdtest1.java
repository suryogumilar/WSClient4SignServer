package sg.lab.jmrtd.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.jmrtd.lds.SODFile;
import org.junit.Test;

public class Jmrtdtest1 {

	@Test
	public void test1() throws IOException, NoSuchAlgorithmException {
		
		Properties p = new Properties();
		p.load(new FileInputStream(System.getenv("conffile")));
		
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String text="P<UTOERIKSSON<<ANNA<MARIA<<<<<<<<<<<<<<<<<<<";
		text += "L898902C36UTO7408122F1204159ZE184226B<<<<<10";
		String textsub = null;

		if(new Boolean(p.getProperty("need_substr"))) {
			textsub = text.substring(0, 15);
		}else {
			textsub = text;
		}
		
		byte[] hashsub = digest.digest(textsub.getBytes());
		byte[] encoded64 = Base64.encodeBase64(hashsub);
		System.out.println("base64 to throw to signserver: "+new String(encoded64)+"\n\n");
		
		System.out.println("File SOD path "+p.getProperty("sod_path"));
		InputStream inputStream = new FileInputStream(p.getProperty("sod_path"));
		SODFile sodf = new SODFile(inputStream );
		String digal = sodf.getDigestAlgorithm();
		
		System.out.println("SOD digest algo:  "+digal);
		System.out.println("SOD digest enc algo"+ sodf.getDigestEncryptionAlgorithm());
		
		Map<Integer, byte[]> dataGroupHashes = sodf.getDataGroupHashes();
		
		Set<Integer> keySet = dataGroupHashes.keySet();
		
		for (Integer key : keySet) {
			System.out.println("DG"+key+" in SOD  :  "+new String(needEncodeDecode(
					dataGroupHashes.get(key), p.getProperty("base64ops")))+"|||");
		}
		
		
		
		System.out.println("\n\nmrz: "+textsub+"\n\n");
		System.out.println("DG1 from SOD: "+new String(dataGroupHashes.get(1)));
		System.out.println("mrz hashed : "+new String(digest.digest(textsub.getBytes())));
		
		System.out.println("\n\n\nDG1 from SOD is same with mrz hashed? "+
				new String(dataGroupHashes.get(1)).equals(
						new String(digest.digest(textsub.getBytes()))
						)
				);
	}
	
	public byte[] needEncodeDecode(byte[] bb, String enc){
		if(enc == null) {
			return bb;
		}
		if(enc.equals("enc")) {
			return Base64.encodeBase64(bb);
		}
		if(enc.equals("dec")) {
			return Base64.decodeBase64(bb);
		}
		return bb;
	}
	
}
