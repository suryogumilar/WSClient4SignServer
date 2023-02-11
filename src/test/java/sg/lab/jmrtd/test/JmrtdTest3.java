package sg.lab.jmrtd.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.jmrtd.lds.SODFile;
import org.junit.Test;


public class JmrtdTest3 {
	public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }
	@Test
	public void test1() throws IOException, NoSuchAlgorithmException{
		Properties p = new Properties();
		p.load(new FileInputStream(System.getenv("conffile")));
		
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String text="P<IDNNEGARA<<ABDI<<<<<<<<<<<<<<<<<<<<<<<<<<<";
		text += "SE00000008IDN8208190M2701013<<<<<<<<<<<<<<06";
		String textsub = null;

		if(new Boolean(p.getProperty("need_substr"))) {
			textsub = text.substring(0, 15);
		}else {
			textsub = text;
		}
		System.out.println("MRZ :" + text);
		byte[] hashsub = digest.digest(textsub.getBytes());
		System.out.println("MRZ hashed using SHA-256 :" + new String(JmrtdTest3.hex(hashsub)));
		byte[] encoded64 = Base64.encodeBase64(hashsub);
		System.out.println("base64 to throw to signserver: "+new String(encoded64)+"\n\n");
		
		String sod_poc_path = p.getProperty("sod_poc_path");
		
		if(sod_poc_path !=null && sod_poc_path.trim().length()>0) {
			InputStream inputStream = new FileInputStream(sod_poc_path);
			SODFile sodf = new SODFile(inputStream );
			
			Map<Integer, byte[]> dataGroupHashes = sodf.getDataGroupHashes();
			byte[] dg1 = dataGroupHashes.get(1);
			System.out.println("dg1 in SOD :" + new String(JmrtdTest3.hex(dg1)));
			System.out.println(new String(dg1).equals(
					new String(hashsub))?"matched" : "not matched" );
			System.out.println();
			List<X509Certificate> docSigningCertificates = sodf.getDocSigningCertificates();
			
			for (X509Certificate x509Certificate : docSigningCertificates) {
				Principal issuerDN = x509Certificate.getIssuerDN();
				Principal subjectDN = x509Certificate.getSubjectDN();
				System.out.println("issuer DN : "+issuerDN.getName());
				System.out.println("subject DN : "+subjectDN.getName());
			}
			
		}
		
		
		
	}
}
