package md.usm.autotestinglabs;

import md.usm.autotestinglabs.constants.URL;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResponseHeader {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void Presence() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB));

        if (response.containsHeader("content-security-policy")) {
            System.out.println("content-security-policy exist");
        } else {
            System.out.println("content-security-policy doesn't exist");
        }
    }

    @Test
    public void Value() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB));

        Assert.assertEquals(response.getFirstHeader("content-security-policy")
                .getValue(), "default-src 'none'");
    }

}