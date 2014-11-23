
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hello_QNAME = new QName("http://services/", "hello");
    private final static QName _SolveQuadraticResponse_QNAME = new QName("http://services/", "solveQuadraticResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://services/", "helloResponse");
    private final static QName _SolveQuadratic_QNAME = new QName("http://services/", "solveQuadratic");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolveQuadratic }
     * 
     */
    public SolveQuadratic createSolveQuadratic() {
        return new SolveQuadratic();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SolveQuadraticResponse }
     * 
     */
    public SolveQuadraticResponse createSolveQuadraticResponse() {
        return new SolveQuadraticResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveQuadraticResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "solveQuadraticResponse")
    public JAXBElement<SolveQuadraticResponse> createSolveQuadraticResponse(SolveQuadraticResponse value) {
        return new JAXBElement<SolveQuadraticResponse>(_SolveQuadraticResponse_QNAME, SolveQuadraticResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveQuadratic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "solveQuadratic")
    public JAXBElement<SolveQuadratic> createSolveQuadratic(SolveQuadratic value) {
        return new JAXBElement<SolveQuadratic>(_SolveQuadratic_QNAME, SolveQuadratic.class, null, value);
    }

}
