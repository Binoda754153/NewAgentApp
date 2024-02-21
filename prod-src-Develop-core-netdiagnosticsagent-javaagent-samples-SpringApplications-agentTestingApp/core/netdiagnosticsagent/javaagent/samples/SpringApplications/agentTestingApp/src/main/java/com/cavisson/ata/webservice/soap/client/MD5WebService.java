
package com.cavisson.ata.webservice.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MD5WebService", targetNamespace = "http://soap.webservice.cavisson.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MD5WebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hashString", targetNamespace = "http://soap.webservice.cavisson.com/", className = "com.cavisson.webservice.soap.client.HashString")
    @ResponseWrapper(localName = "hashStringResponse", targetNamespace = "http://soap.webservice.cavisson.com/", className = "com.cavisson.webservice.soap.client.HashStringResponse")
    @Action(input = "http://soap.webservice.cavisson.com/MD5WebService/hashStringRequest", output = "http://soap.webservice.cavisson.com/MD5WebService/hashStringResponse")
    public String hashString(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
