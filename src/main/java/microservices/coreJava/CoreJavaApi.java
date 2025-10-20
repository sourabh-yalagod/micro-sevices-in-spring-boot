package microservices.coreJava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class CoreJavaApi {
    @GetMapping("/core/java/api")
    public void methodCall() {
        HttpURLConnection httpURLConnection = null;
        try {
            String endPoint = "https://jsonplaceholder.typicode.com/todos/1";
            URL url = new URL(endPoint);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setReadTimeout(500);
            httpURLConnection.setConnectTimeout(100);
            BufferedReader rawResponse = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String str;
            while ((str = rawResponse.readLine()) != null){
                response.append(str);
            }
            System.out.println("Response From Endpoint " + endPoint + " " + response.toString());
            rawResponse.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
