package wheleph;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static wheleph.Service.*;

public class CamelClientTest extends CamelSpringTestSupport {
    private Service service;

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-client.xml");
    }

    @Override
    protected void doPostSetup() throws Exception {
        super.doPostSetup();

        service = context.getRegistry().lookupByNameAndType("serviceProxy", Service.class);
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(10, service.execute(CODE_SUCCESS));
    }

    @Test(expected = IllegalStateException.class)
    public void testKnownException() {
        service.execute(CODE_THROW_KNOWN_EXCEPTION);
    }

    @Test(expected = Exception.class)
    public void testUnknownException() {
        service.execute(CODE_THROW_UNKNOWN_EXCEPTION);
    }
}
