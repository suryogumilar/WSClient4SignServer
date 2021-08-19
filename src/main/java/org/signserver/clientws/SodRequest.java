
package org.signserver.clientws;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for sodRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sodRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataGroup" type="{http://clientws.signserver.org/}dataGroup" maxOccurs="unbounded"/&gt;
 *         &lt;element name="ldsVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unicodeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sodRequest", propOrder = {
    "dataGroup",
    "ldsVersion",
    "unicodeVersion"
})
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
public class SodRequest {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected List<DataGroup> dataGroup;
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected String ldsVersion;
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    protected String unicodeVersion;

    /**
     * Gets the value of the dataGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataGroup }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public List<DataGroup> getDataGroup() {
        if (dataGroup == null) {
            dataGroup = new ArrayList<DataGroup>();
        }
        return this.dataGroup;
    }

    /**
     * Gets the value of the ldsVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public String getLdsVersion() {
        return ldsVersion;
    }

    /**
     * Sets the value of the ldsVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public void setLdsVersion(String value) {
        this.ldsVersion = value;
    }

    /**
     * Gets the value of the unicodeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public String getUnicodeVersion() {
        return unicodeVersion;
    }

    /**
     * Sets the value of the unicodeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v2.3.4", date = "2021-08-19T15:50:36+07:00")
    public void setUnicodeVersion(String value) {
        this.unicodeVersion = value;
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
