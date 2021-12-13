package sg.lab.jmrtd.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

public class JmrtdTest2 {

	@Test
	public void test1() throws IOException, NoSuchAlgorithmException {
		Properties p = new Properties();
		p.load(new FileInputStream(System.getenv("conffile")));
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
					dataGroupHashes.get(key), p.getProperty("base64ops")))+"");
		}
		
		
		System.out.println();
		List<X509Certificate> docSigningCertificates = sodf.getDocSigningCertificates();
		
		for (X509Certificate x509Certificate : docSigningCertificates) {
			Principal issuerDN = x509Certificate.getIssuerDN();
			Principal subjectDN = x509Certificate.getSubjectDN();
			System.out.println("issuer DN : "+issuerDN.getName());
			System.out.println("subject DN : "+subjectDN.getName());
		}
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
