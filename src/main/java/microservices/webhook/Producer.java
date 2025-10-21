package microservices.webhook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook")
public class Producer {
    @Autowired
    private WebhookFeignClient webhookFeignClient;

    @PostMapping("/sender")
    public ResponseEntity<String> sendWebhook(@RequestBody ResponseBody payload) {
        webhookFeignClient.sendWebhook(payload);
        return ResponseEntity.ok("webhook sent...!");
    }

    @PostMapping("/receiver")
    public void sendReceiver(@RequestBody ResponseBody payload) {
        System.out.println("Webhook Payload : " + payload);
        return;
    }
}

@FeignClient(name = "webhook-test", url = "http://localhost:8080/api/webhook")
interface WebhookFeignClient {
    @PostMapping(value = "/receiver", consumes = "application/json")
    void sendWebhook(@RequestBody ResponseBody payload);
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class ResponseBody {
    private String id;
    private String name;
}