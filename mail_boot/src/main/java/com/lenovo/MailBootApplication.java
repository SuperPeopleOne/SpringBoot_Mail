package com.lenovo;

import com.lenovo.config.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
public class MailBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailBootApplication.class, args);
    }
}
