
package org.signserver.clientws;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for processSOD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processSOD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="worker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="metadata" type="{http://clientws.signserver.org/}metadata" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="sodData" type="{http://clientws.signserver.org/}sodRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processSOD", propOrder = {
    "worker",
    "metadata",
    "sodData"
})
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
public class ProcessSOD {

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected String worker;
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected List<Metadata> metadata;
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected SodRequest sodData;

    /**
     * Gets the value of the worker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public String getWorker() {
        return worker;
    }

    /**
     * Sets the value of the worker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public void setWorker(String value) {
        this.worker = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Metadata }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public List<Metadata> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Metadata>();
        }
        return this.metadata;
    }

    /**
     * Gets the value of the sodData property.
     * 
     * @return
     *     possible object is
     *     {@link SodRequest }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public SodRequest getSodData() {
        return sodData;
    }

    /**
     * Sets the value of the sodData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SodRequest }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public void setSodData(SodRequest value) {
        this.sodData = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }

}
