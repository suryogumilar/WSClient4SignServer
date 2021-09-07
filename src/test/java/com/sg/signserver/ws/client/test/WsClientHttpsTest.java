package com.sg.signserver.ws.client.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.junit.Test;
import org.signserver.clientws.ClientWS;
import org.signserver.clientws.ClientWSService;
import org.signserver.clientws.DataGroup;
import org.signserver.clientws.InternalServerException_Exception;
import org.signserver.clientws.Metadata;
import org.signserver.clientws.RequestFailedException_Exception;
import org.signserver.clientws.SodRequest;
import org.signserver.clientws.SodResponse;

public class WsClientHttpsTest {
	@Test
	public void tes() throws Exception {
		
		URL wsdlLocation = new URL("https://ss.gehirn.org:8443/signserver/ClientWSService/ClientWS?wsdl");
		
		ClientWSService ws = new ClientWSService(wsdlLocation);
		String worker="MRTDSODSigner_DoDgHashFalse";
		List<Metadata> metadata = null;
		SodRequest sodData = new SodRequest();
		
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
		ClientWS clientWSPort = ws.getClientWSPort();
		tslIt(clientWSPort);
		SodResponse sodResponse = clientWSPort.processSOD(worker, metadata, sodData);
		
		System.out.println(new String(Base64.encodeBase64(sodResponse.getData())));
		System.out.println(new String(Base64.encodeBase64(sodResponse.getSignerCertificate())));
	}
	
	public static void tslIt(ClientWS port) throws KeyStoreException, NoSuchAlgorithmException, 
		IOException, UnrecoverableKeyException, CertificateException {
		Client client = ClientProxy.getClient(port);
       HTTPConduit http = (HTTPConduit) client.getConduit();
       
       TLSClientParameters tlsClientParameters = http.getTlsClientParameters();

       KeyStore keyStore = getKeyStore();
       KeyStore trustStore = getTrustStore();

       KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
       TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

       keyManagerFactory.init(keyStore, "123456".toCharArray());
       KeyManager[] keyMgrs = keyManagerFactory.getKeyManagers();
       tlsClientParameters.setKeyManagers(keyMgrs);

       trustManagerFactory.init(trustStore);
       TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
       tlsClientParameters.setTrustManagers(trustManagers);

       tlsClientParameters.setDisableCNCheck(true);
       
	}
	
    public static KeyStore getKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        URL keyStoreUrl = WsClientHttpsTest.class.getResource(
        		"C:/Worksite/WORK/Project/2021/Kemenlu_peruri/dckr_vols/tuk_ws/keystore.jks");
        File keystoreFile = new File(keyStoreUrl.getPath());
        if (!keystoreFile.exists()) {
            throw new RuntimeException("keystore doesn't exists: " + keystoreFile.getAbsolutePath());
        }

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream keystoreInput = new FileInputStream(keystoreFile.getAbsolutePath());
        keystore.load(keystoreInput, "passw0rd".toCharArray());
        keystoreInput.close();
        return keystore;
    }

    public static KeyStore getTrustStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        URL trustStoreUrl = WsClientHttpsTest.class.getResource(
        		"C:/Worksite/WORK/Project/2021/Kemenlu_peruri/dckr_vols/tuk_ws/cacert.jks");
        File trustStoreFile = new File(trustStoreUrl.getPath());
        if (!trustStoreFile.exists()) {
            throw new RuntimeException("truststore doesn't exists: " + trustStoreFile.getAbsolutePath());
        }

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream trustStoreInput = new FileInputStream(trustStoreFile.getAbsolutePath());
        trustStore.load(trustStoreInput, "passw0rd_cacert".toCharArray());
        trustStoreInput.close();
        return trustStore;
    }
}
