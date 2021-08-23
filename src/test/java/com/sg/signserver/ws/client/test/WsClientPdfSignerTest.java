package com.sg.signserver.ws.client.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.signserver.clientws.ClientWSService;
import org.signserver.clientws.DataResponse;
import org.signserver.clientws.InternalServerException_Exception;
import org.signserver.clientws.Metadata;
import org.signserver.clientws.RequestFailedException_Exception;

public class WsClientPdfSignerTest {
	@Test
	public void tes() throws RequestFailedException_Exception, InternalServerException_Exception, IOException {
		URL wsdlLocation = new URL("http://ss.gehirn.org:8080/signserver/ClientWSService/ClientWS?wsdl");
		ClientWSService ws = new ClientWSService(wsdlLocation);
		
		String IN_FILE = System.getenv("IN_FILE");
		String OUT_FILE = System.getenv("OUT_FILE");
		String CERT_FILE = System.getenv("CERT_FILE");
		byte[] inFileBytes = Files.readAllBytes(Paths.get(IN_FILE)); 
		byte[] data = java.util.Base64.getEncoder().encode(inFileBytes); // cancelled out
		
		data = inFileBytes;
		
		String worker = "PDFSigner";
		List<Metadata> metadata = null;

		DataResponse dataResponse = ws.getClientWSPort().processData(worker, metadata, data);
		
		byte[] datasigned = dataResponse.getData();
		byte[] signerCertificate = dataResponse.getSignerCertificate();
		
		// to base 64
		byte[] decoded = java.util.Base64.getEncoder().encode(datasigned); // cancelled out, the api already return binary data
		byte[] certDecoded = java.util.Base64.getEncoder().encode(signerCertificate);

		FileOutputStream fos = new FileOutputStream(OUT_FILE);
		fos.write(datasigned);
		fos.flush();
		fos.close();
		
		fos = new FileOutputStream(CERT_FILE);
		fos.write(certDecoded);
		fos.flush();
		fos.close();
		
		System.out.println(decoded.length);
	}
}
