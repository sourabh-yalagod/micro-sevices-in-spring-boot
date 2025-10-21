package microservices.feignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign-client")
public class FeignClientController {
    @Autowired
    private FeignClientInterface feignClientInterface;

    @GetMapping("/test/{id}")
    public ResponseEntity<String> getTodoByID(@PathVariable String id) {
        String todo = feignClientInterface.getTodoById(id);
        return ResponseEntity.ok(todo);
    }
}
