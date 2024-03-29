
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.signserver.clientws;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-19T15:50:36.937+07:00
 * Generated source version: 3.4.4
 *
 */

@javax.jws.WebService(
                      serviceName = "ClientWSService",
                      portName = "ClientWSPort",
                      targetNamespace = "http://clientws.signserver.org/",
                      wsdlLocation = "file:/C:/Worksite/WORK/Project/Peruri/eclipse2/WSClientSignServer/src/main/resources/ClientWS.wsdl",
                      endpointInterface = "org.signserver.clientws.ClientWS")

public class ClientWSPortImpl implements ClientWS {

    private static final Logger LOG = Logger.getLogger(ClientWSPortImpl.class.getName());

    /* (non-Javadoc)
     * @see org.signserver.clientws.ClientWS#processSOD(java.lang.String worker, java.util.List<org.signserver.clientws.Metadata> metadata, org.signserver.clientws.SodRequest sodData)*
     */
    public org.signserver.clientws.SodResponse processSOD(java.lang.String worker, java.util.List<org.signserver.clientws.Metadata> metadata, org.signserver.clientws.SodRequest sodData) throws RequestFailedException_Exception,  InternalServerException_Exception   {
        LOG.info("Executing operation processSOD");
        System.out.println(worker);
        System.out.println(metadata);
        System.out.println(sodData);
        try {
            org.signserver.clientws.SodResponse _return = new org.signserver.clientws.SodResponse();
            _return.setArchiveId("ArchiveId944138240");
            byte[] _returnData = new byte[] {};
            _return.setData(_returnData);
            java.util.List<org.signserver.clientws.Metadata> _returnMetadata = new java.util.ArrayList<org.signserver.clientws.Metadata>();
            org.signserver.clientws.Metadata _returnMetadataVal1 = new org.signserver.clientws.Metadata();
            _returnMetadataVal1.setValue("Value1876356353");
            _returnMetadataVal1.setName("Name1766644296");
            _returnMetadata.add(_returnMetadataVal1);
            _return.getMetadata().addAll(_returnMetadata);
            _return.setRequestId(-371743410);
            byte[] _returnSignerCertificate = new byte[] {};
            _return.setSignerCertificate(_returnSignerCertificate);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RequestFailedException_Exception("RequestFailedException...");
        //throw new InternalServerException_Exception("InternalServerException...");
    }

    /* (non-Javadoc)
     * @see org.signserver.clientws.ClientWS#processData(java.lang.String worker, java.util.List<org.signserver.clientws.Metadata> metadata, byte[] data)*
     */
    public org.signserver.clientws.DataResponse processData(java.lang.String worker, java.util.List<org.signserver.clientws.Metadata> metadata, byte[] data) throws RequestFailedException_Exception,  InternalServerException_Exception   {
        LOG.info("Executing operation processData");
        System.out.println(worker);
        System.out.println(metadata);
        System.out.println(data);
        try {
            org.signserver.clientws.DataResponse _return = new org.signserver.clientws.DataResponse();
            _return.setArchiveId("ArchiveId-853773497");
            byte[] _returnData = new byte[] {};
            _return.setData(_returnData);
            java.util.List<org.signserver.clientws.Metadata> _returnMetadata = new java.util.ArrayList<org.signserver.clientws.Metadata>();
            org.signserver.clientws.Metadata _returnMetadataVal1 = new org.signserver.clientws.Metadata();
            _returnMetadataVal1.setValue("Value-2072812268");
            _returnMetadataVal1.setName("Name-1856202009");
            _returnMetadata.add(_returnMetadataVal1);
            _return.getMetadata().addAll(_returnMetadata);
            _return.setRequestId(1280677421);
            byte[] _returnSignerCertificate = new byte[] {};
            _return.setSignerCertificate(_returnSignerCertificate);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new RequestFailedException_Exception("RequestFailedException...");
        //throw new InternalServerException_Exception("InternalServerException...");
    }

}
