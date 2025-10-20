package microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Server URL : http://localhost:8080");
    }
}
