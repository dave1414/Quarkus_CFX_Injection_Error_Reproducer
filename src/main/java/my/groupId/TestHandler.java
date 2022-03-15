package my.groupId;

import java.util.Collections;
import java.util.Set;
import javax.annotation.Resource;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class TestHandler implements SOAPHandler<SOAPMessageContext> {

  private HelloResource working = CDI.current().select(HelloResource.class).get();

  @Inject
  private HelloResource notWorking;

  private static final Set<QName> HEADERS = Collections
      .singleton(new QName(
          "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
          "Security"));



  @Override
  public Set<QName> getHeaders() {
    return HEADERS;
  }

  // GEMREQ-start A_21104#handle
  @Override
  public boolean handleMessage(SOAPMessageContext context) {

    System.out.println("Using working" + working.getHello());

    System.out.println("Using notWorking: " + notWorking.getHello());

    var webServiceContextWhichIsNull = working.getWebServiceContext();

    System.out.println("Injected message context by @Ressource: " + webServiceContextWhichIsNull.getMessageContext());


    return true;
  }
  // GEMREQ-end A_21104#handle

  @Override
  public boolean handleFault(SOAPMessageContext context) {

    return true;
  }

  @Override
  public void close(MessageContext context) {

  }

}
