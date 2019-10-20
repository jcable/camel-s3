package wsinteg;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class S3ComponentTest extends CamelTestSupport {

    @Test
    public void testS3() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);       
        
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() {
                from("aws-s3://foo?accessKey=y&secretKey=x")
                  .to("aws-s3://bar?accessKey=y&secretKey=x")
                  .to("mock:result");
            }
        };
    }
}
