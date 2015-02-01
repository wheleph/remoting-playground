package wheleph;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static wheleph.Service.*;

public class CamelClientTest extends CamelSpringTestSupport {
    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-client.xml");
    }

    @Test
    public void testNormal() {
        Service service = context.getRegistry().lookupByNameAndType("serviceProxy", Service.class);

        Assert.assertEquals(10, service.execute(CODE_SUCCESS));
    }

    @Test(expected = IllegalStateException.class)
    public void testKnownException() {
        Service service = context.getRegistry().lookupByNameAndType("serviceProxy", Service.class);
        service.execute(CODE_THROW_KNOWN_EXCEPTION);
    }

    @Test(expected = Exception.class)
    public void testUnknownException() {
        Service service = context.getRegistry().lookupByNameAndType("serviceProxy", Service.class);
        service.execute(CODE_THROW_UNKNOWN_EXCEPTION);
    }
}
