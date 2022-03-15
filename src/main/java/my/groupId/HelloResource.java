package my.groupId;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.xml.ws.WebServiceContext;

@Singleton
public class HelloResource {

    @Resource
    private WebServiceContext webServiceContext;


    public String getHello() {
        return "Hello ";
    }

    public WebServiceContext getWebServiceContext(){
        return webServiceContext;
    }
}
