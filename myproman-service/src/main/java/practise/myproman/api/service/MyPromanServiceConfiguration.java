package practise.myproman.api.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("practise.myproman.api.service")
@EntityScan("practise.myproman.api.service.entity")
public class MyPromanServiceConfiguration {

}