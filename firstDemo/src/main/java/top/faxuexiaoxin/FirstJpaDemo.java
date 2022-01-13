package top.faxuexiaoxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @EnableJpaRepositories 表示开启jpa
 */
@EnableJpaRepositories
@SpringBootApplication
public class FirstJpaDemo
{
    public static void main( String[] args )
    {
        SpringApplication.run(FirstJpaDemo.class,args);
    }
}
