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

public class StatusCodes {

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
    public void get200() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB + "/users/microsoft"));

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void get401() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB + "/user/emails"));

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 401);
    }

    @Test
    public void get404() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB + "/nonExistingName"));

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
    }

}