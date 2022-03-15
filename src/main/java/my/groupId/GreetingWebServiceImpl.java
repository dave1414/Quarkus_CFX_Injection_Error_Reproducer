package my.groupId;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService(endpointInterface = "my.groupId.GreetingWebService", serviceName = "GreetingWebService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@HandlerChain(file = "/handlers.xml")
public class GreetingWebServiceImpl implements GreetingWebService {

    @Inject
    public HelloResource helloResource;

    @Override
    public String reply(@WebParam(name = "text") String text) {
        return helloResource.getHello() + text;
    }

    @Override
    public String ping() throws GreetingException {
        return helloResource.getHello();
    }

}
