package microservices.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "todo-service", url = "https://jsonplaceholder.typicode.com")
public interface FeignClientInterface {
    @GetMapping("/todos/{id}")
    String getTodoById(@PathVariable("id") String id);
}

