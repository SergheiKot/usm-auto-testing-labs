package md.usm.autotestinglabs;

import md.usm.autotestinglabs.constants.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Post {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    private String userToken = "Token";

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
    public void createRepository() throws IOException {
        var request = new HttpPost(URL.API_GITHUB + "/repos/microsoft");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + userToken);

        request.setEntity(new StringEntity("{\"name\": \"linux\"}", ContentType.APPLICATION_JSON));

        response = client.execute(request);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 204);
    }

}