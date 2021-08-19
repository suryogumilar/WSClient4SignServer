
package org.signserver.clientws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-19T15:50:36.927+07:00
 * Generated source version: 3.4.4
 */

@WebFault(name = "InternalServerException", targetNamespace = "http://clientws.signserver.org/")
public class InternalServerException_Exception extends Exception {

    private org.signserver.clientws.InternalServerException faultInfo;

    public InternalServerException_Exception() {
        super();
    }

    public InternalServerException_Exception(String message) {
        super(message);
    }

    public InternalServerException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public InternalServerException_Exception(String message, org.signserver.clientws.InternalServerException internalServerException) {
        super(message);
        this.faultInfo = internalServerException;
    }

    public InternalServerException_Exception(String message, org.signserver.clientws.InternalServerException internalServerException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = internalServerException;
    }

    public org.signserver.clientws.InternalServerException getFaultInfo() {
        return this.faultInfo;
    }
}