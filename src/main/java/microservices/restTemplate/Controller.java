package microservices.restTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/rest-template")
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/test")
    public ResponseEntity<String> getResponse(){
        String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",String.class);
        return ResponseEntity.ok(response);
    }
}
