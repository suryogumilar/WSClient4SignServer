package com.sg.signserver.ws.client.test;

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
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.resource.ResourceResolver;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.junit.Test;
import org.signserver.clientws.ClientWS;
import org.signserver.clientws.ClientWSService;
import org.signserver.clientws.DataGroup;
import org.signserver.clientws.Metadata;
import org.signserver.clientws.SodRequest;
import org.signserver.clientws.SodResponse;

public class WsClientHttpsTest {
	static {
	    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals("ss.gehirn.org"));
	}
	@Test
	public void tes() throws Exception {
		

		
		URL wsdlLocation = new URL("https://ss.gehirn.org:8443/signserver/ClientWSService/ClientWS?wsdl");
		
		ClientWSService ws = new ClientWSService(wsdlLocation);
		
		String worker="MRTDSODSigner";
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
		//tslIt(clientWSPort);
		SodResponse sodResponse = clientWSPort.processSOD(worker, metadata, sodData);
		
		System.out.println(new String(Base64.encodeBase64(sodResponse.getData())));
		System.out.println(new String(Base64.encodeBase64(sodResponse.getSignerCertificate())));
	}
	
	public static void tslIt(ClientWS port) throws KeyStoreException, NoSuchAlgorithmException, 
		IOException, UnrecoverableKeyException, CertificateException {
		Client client = ClientProxy.getClient(port);
       HTTPConduit http = (HTTPConduit) client.getConduit();
       System.out.println("conduit  "+http.getAddress() +"||"+ http.getConduitName());
       TLSClientParameters tlsClientParameters = http.getTlsClientParameters();
       if(tlsClientParameters == null) {
    	   tlsClientParameters = new TLSClientParameters();
       }
       tlsClientParameters.setDisableCNCheck(false); // disableCNCheck

       KeyStore keyStore = getKeyStore();
       KeyStore trustStore = getTrustStore();
       
       System.out.println("key provider = "+keyStore.getProvider().getName());
       
       KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
       TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

       keyManagerFactory.init(keyStore, "passw0rd".toCharArray());
       KeyManager[] keyMgrs = keyManagerFactory.getKeyManagers();
       //tlsClientParameters.setKeyManagers(keyMgrs);

       trustManagerFactory.init(trustStore);
       TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
       //tlsClientParameters.setTrustManagers(trustManagers);

       http.setTlsClientParameters(tlsClientParameters);
       
	}
	
    public static KeyStore getKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
       
    	
    	String path = (
        		"C:/Worksite/WORK/Project/2021/Kemenlu_peruri/dckr_vols/tuk_ws/mrtdauth_keystore.jks");
		URL keyStoreUrl = new File(path).toURI().toURL();
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
    	String path = (
        		"C:/Worksite/WORK/Project/2021/Kemenlu_peruri/dckr_vols/tuk_ws/mrtdauth_cacerts.jks");
    	URL trustStoreUrl = new File(path).toURI().toURL();
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
