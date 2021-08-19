package com.sg.signserver.ws.client.test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Test;
import org.signserver.clientws.ClientWSService;
import org.signserver.clientws.DataGroup;
import org.signserver.clientws.InternalServerException_Exception;
import org.signserver.clientws.Metadata;
import org.signserver.clientws.RequestFailedException_Exception;
import org.signserver.clientws.SodRequest;
import org.signserver.clientws.SodResponse;
import org.apache.commons.codec.binary.Base64;


public class WsClientTest {
	@Test
	public void tes() throws RequestFailedException_Exception, InternalServerException_Exception, MalformedURLException, UnsupportedEncodingException {
		
		URL wsdlLocation = new URL("http://ss.gehirn.org:8080/signserver/ClientWSService/ClientWS?wsdl");
		
		ClientWSService ws = new ClientWSService(wsdlLocation);
		String worker="MRTDSODSigner";
		List<Metadata> metadata = null;
		SodRequest sodData = new SodRequest();
		Charset charset = StandardCharsets.ISO_8859_1;
		
		DataGroup dg1 = new DataGroup();
		dg1.setId(1);
		dg1.setValue(Base64.decodeBase64("PJaDAX+eS/M9D77dJr8UP9ct6bndFFRBt18GBAR+oo4="));
		sodData.getDataGroup().add(dg1);
		
		DataGroup dg2 = new DataGroup();
		dg2.setId(2);
		dg2.setValue(Base64.decodeBase64("BTfUgfc6dXM0MoBS2jr5YmztlwKOILhJ9hFcIs12UZc="));
		sodData.getDataGroup().add(dg2);
		
		DataGroup dg3 = new DataGroup();
		dg3.setId(3);
		dg3.setValue(Base64.decodeBase64("idxq5/Bqn0a1Za8D6rDs4L9gJNNlm346HQNXPP6wtZ0="));
		sodData.getDataGroup().add(dg3);
		
		
		sodData.setUnicodeVersion("040000");
		SodResponse sodResponse = ws.getClientWSPort().processSOD(worker, metadata, sodData);
		
		System.out.println(new String(Base64.encodeBase64(sodResponse.getData())));
		System.out.println(new String(Base64.encodeBase64(sodResponse.getSignerCertificate())));
	}
}
