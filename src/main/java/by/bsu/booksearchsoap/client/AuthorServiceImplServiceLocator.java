/**
 * AuthorServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.bsu.booksearchsoap.client;

public class AuthorServiceImplServiceLocator extends org.apache.axis.client.Service implements by.bsu.booksearchsoap.client.AuthorServiceImplService {

    public AuthorServiceImplServiceLocator() {
    }


    public AuthorServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthorServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AuthorServiceImplPort
    private java.lang.String AuthorServiceImplPort_address = "http://localhost:8888/authorWS";

    public java.lang.String getAuthorServiceImplPortAddress() {
        return AuthorServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthorServiceImplPortWSDDServiceName = "AuthorServiceImplPort";

    public java.lang.String getAuthorServiceImplPortWSDDServiceName() {
        return AuthorServiceImplPortWSDDServiceName;
    }

    public void setAuthorServiceImplPortWSDDServiceName(java.lang.String name) {
        AuthorServiceImplPortWSDDServiceName = name;
    }

    public by.bsu.booksearchsoap.client.IAuthorService getAuthorServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AuthorServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthorServiceImplPort(endpoint);
    }

    public by.bsu.booksearchsoap.client.IAuthorService getAuthorServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            by.bsu.booksearchsoap.client.AuthorServiceImplPortBindingStub _stub = new by.bsu.booksearchsoap.client.AuthorServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getAuthorServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthorServiceImplPortEndpointAddress(java.lang.String address) {
        AuthorServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (by.bsu.booksearchsoap.client.IAuthorService.class.isAssignableFrom(serviceEndpointInterface)) {
                by.bsu.booksearchsoap.client.AuthorServiceImplPortBindingStub _stub = new by.bsu.booksearchsoap.client.AuthorServiceImplPortBindingStub(new java.net.URL(AuthorServiceImplPort_address), this);
                _stub.setPortName(getAuthorServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AuthorServiceImplPort".equals(inputPortName)) {
            return getAuthorServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.booksearchsoap.bsu.by/", "AuthorServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.booksearchsoap.bsu.by/", "AuthorServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AuthorServiceImplPort".equals(portName)) {
            setAuthorServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
