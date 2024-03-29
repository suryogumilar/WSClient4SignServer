package org.signserver.clientws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-19T15:50:36.975+07:00
 * Generated source version: 3.4.4
 *
 */
@WebServiceClient(name = "ClientWSService",
                  wsdlLocation = "file:/C:/Worksite/WORK/Project/Peruri/eclipse2/WSClientSignServer/src/main/resources/ClientWS.wsdl",
                  targetNamespace = "http://clientws.signserver.org/")
public class ClientWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://clientws.signserver.org/", "ClientWSService");
    public final static QName ClientWSPort = new QName("http://clientws.signserver.org/", "ClientWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Worksite/WORK/Project/Peruri/eclipse2/WSClientSignServer/src/main/resources/ClientWS.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ClientWSService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Worksite/WORK/Project/Peruri/eclipse2/WSClientSignServer/src/main/resources/ClientWS.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ClientWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ClientWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientWSService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ClientWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ClientWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ClientWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ClientWS
     */
    @WebEndpoint(name = "ClientWSPort")
    public ClientWS getClientWSPort() {
        return super.getPort(ClientWSPort, ClientWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClientWS
     */
    @WebEndpoint(name = "ClientWSPort")
    public ClientWS getClientWSPort(WebServiceFeature... features) {
        return super.getPort(ClientWSPort, ClientWS.class, features);
    }

}
