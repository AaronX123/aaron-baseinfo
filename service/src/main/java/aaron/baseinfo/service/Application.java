package aaron.baseinfo.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
