package App.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


public class RestAPIUtils {

    protected String currentResponse = null;

    private HttpResponse response = null;
    HttpClient client = null;

    /***
     *  This is RestAPIUtils constructor.
     */
    public RestAPIUtils()
    {
        init();
    }


    public void init() {
        client = HttpClientBuilder.create().build();

    }

    /***
     * This api accepts url and invokes HttpGet request on url.
     * @param url
     * @return HttpResponse object
     */
    public HttpResponse getHttpGetResponse(String url) {

        try {

            //Define a HttpGet request
            HttpGet request = new HttpGet(url);


            //Invoke the service
            response = client.execute(request);

            //Verify if the response is valid
            int statusCode = response.getStatusLine().getStatusCode();



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;

    }

    /***
     * This api accepts url , body and contentType and invokes post request on url
     * @param url
     * @param postBody
     * @param contentType
     * @return HttpResponse object
     */
    public HttpResponse getHttpPostResponse(String url, String postBody, String contentType) {

        try {


            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(postBody);

            if (contentType.equalsIgnoreCase("")) {
                contentType = "application/json";
            }
            input.setContentType(contentType);

            postRequest.addHeader("content-type",contentType);
            postRequest.setEntity(input);

            response = client.execute(postRequest);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;

    }
    
    public String getResponseBodyString(HttpResponse currRes) {
        String lines = "";
        try {

            BufferedReader responseBody = new BufferedReader(new InputStreamReader(currRes.getEntity().getContent()));

            String line = "";
            while ((line = responseBody.readLine()) != null) {
                lines += line;
            }

        }
        catch (java.io.IOException exc)
        {
            lines = this.currentResponse;

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return lines;
    }


}
