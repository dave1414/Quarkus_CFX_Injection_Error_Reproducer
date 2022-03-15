package my.groupId;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

@WebService
public interface GreetingWebService {

    @WebMethod
    String reply(@WebParam(name = "text") String text);

    @WebMethod
    @RequestWrapper(localName = "Ping", targetNamespace = "http://cxf.it.quarkiverse.io/", className = "my.groupId.Ping")
    String ping() throws GreetingException;

}
