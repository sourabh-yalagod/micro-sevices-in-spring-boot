package microservices.restClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/rest-client")
public class RequestClientController {
    @Autowired
    private RestClient restClient;

    @GetMapping("/test")
    public ResponseEntity<String> getResponse() {
        String response = restClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .body(String.class);
        return ResponseEntity.ok(response);
    }
}
