package practise.myproman.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import practise.myproman.api.service.MyPromanServiceConfiguration;

@SpringBootApplication
@Import(MyPromanServiceConfiguration.class)
public class MyPromanApiServer {

    public static void main(String[] args) {
        SpringApplication.run(MyPromanApiServer.class, args);
    }
}