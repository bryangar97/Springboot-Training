package com.deloitte.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/*@SpringBootApplication(scanBasePackages = {
        "com.deloitte.training",
        "com.deloitte.utils"
})*/
@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TrainingApplication.class, args);

        SpringApplication app = new SpringApplication(TrainingApplication.class);
        ApplicationContext context = app.run(args);
        Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);

    }

}
