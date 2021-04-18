package md.usm.autotestinglabs;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import md.usm.autotestinglabs.constants.URL;
import md.usm.autotestinglabs.dto.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ResponseBody {

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

    private User getUser() throws IOException {
        response = client.execute(new HttpGet(URL.API_GITHUB + "/users/github"));

        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(EntityUtils.toString(response.getEntity()), User.class);
    }

    @Test
    public void testCorrectLogin() throws IOException {
        Assert.assertEquals(getUser().getLogin(), "github");
    }

    @Test
    public void testCorrectId() throws IOException {
        Assert.assertEquals(getUser().getId(), 9919);
    }

    @Test
    public void testCorrectBlog() throws IOException {
        Assert.assertEquals(getUser().getBlog(), "https://github.com/about");
    }

    @Test
    public void testCorrectLocation() throws IOException {
        Assert.assertEquals(getUser().getLocation(), "San Francisco, CA");
    }

    @Test
    public void readData() throws IOException {
        System.out.println(getUser());
    }

    @Test
    public void writeData() throws IOException {
        new ObjectMapper().writeValue(new File("user.json"), getUser());
    }

}