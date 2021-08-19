
package org.signserver.clientws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-19T15:50:36.552+07:00
 * Generated source version: 3.4.4
 *
 */
public final class ClientWS_ClientWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://clientws.signserver.org/", "ClientWSService");

    private ClientWS_ClientWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ClientWSService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ClientWSService ss = new ClientWSService(wsdlURL, SERVICE_NAME);
        ClientWS port = ss.getClientWSPort();

        {
        System.out.println("Invoking processSOD...");
        java.lang.String _processSOD_worker = "_processSOD_worker-26555424";
        java.util.List<org.signserver.clientws.Metadata> _processSOD_metadata = new java.util.ArrayList<org.signserver.clientws.Metadata>();
        org.signserver.clientws.Metadata _processSOD_metadataVal1 = new org.signserver.clientws.Metadata();
        _processSOD_metadataVal1.setValue("Value-43390825");
        _processSOD_metadataVal1.setName("Name-548772208");
        _processSOD_metadata.add(_processSOD_metadataVal1);
        org.signserver.clientws.SodRequest _processSOD_sodData = new org.signserver.clientws.SodRequest();
        java.util.List<org.signserver.clientws.DataGroup> _processSOD_sodDataDataGroup = new java.util.ArrayList<org.signserver.clientws.DataGroup>();
        org.signserver.clientws.DataGroup _processSOD_sodDataDataGroupVal1 = new org.signserver.clientws.DataGroup();
        byte[] _processSOD_sodDataDataGroupVal1Value = new byte[] {};
        _processSOD_sodDataDataGroupVal1.setValue(_processSOD_sodDataDataGroupVal1Value);
        _processSOD_sodDataDataGroupVal1.setId(-1722653044);
        _processSOD_sodDataDataGroup.add(_processSOD_sodDataDataGroupVal1);
        _processSOD_sodData.getDataGroup().addAll(_processSOD_sodDataDataGroup);
        _processSOD_sodData.setLdsVersion("LdsVersion-1373393736");
        _processSOD_sodData.setUnicodeVersion("UnicodeVersion2100395078");
        try {
            org.signserver.clientws.SodResponse _processSOD__return = port.processSOD(_processSOD_worker, _processSOD_metadata, _processSOD_sodData);
            System.out.println("processSOD.result=" + _processSOD__return);

        } catch (RequestFailedException_Exception e) {
            System.out.println("Expected exception: RequestFailedException has occurred.");
            System.out.println(e.toString());
        } catch (InternalServerException_Exception e) {
            System.out.println("Expected exception: InternalServerException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking processData...");
        java.lang.String _processData_worker = "_processData_worker-761924330";
        java.util.List<org.signserver.clientws.Metadata> _processData_metadata = new java.util.ArrayList<org.signserver.clientws.Metadata>();
        org.signserver.clientws.Metadata _processData_metadataVal1 = new org.signserver.clientws.Metadata();
        _processData_metadataVal1.setValue("Value-1691008382");
        _processData_metadataVal1.setName("Name-1752225237");
        _processData_metadata.add(_processData_metadataVal1);
        byte[] _processData_data = new byte[] {};
        try {
            org.signserver.clientws.DataResponse _processData__return = port.processData(_processData_worker, _processData_metadata, _processData_data);
            System.out.println("processData.result=" + _processData__return);

        } catch (RequestFailedException_Exception e) {
            System.out.println("Expected exception: RequestFailedException has occurred.");
            System.out.println(e.toString());
        } catch (InternalServerException_Exception e) {
            System.out.println("Expected exception: InternalServerException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}