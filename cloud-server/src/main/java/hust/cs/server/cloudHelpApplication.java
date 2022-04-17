package hust.cs.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ClassName: cloudHelpApplication
 * PackageName:hust.cs.server
 * Description:项目启动类
 * date: 2022/3/25 13:06
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@SpringBootApplication
@MapperScan("hust.cs.server.mapper")
//@EnableScheduling
public class cloudHelpApplication {
    public static void main(String[] args) {
        SpringApplication.run(cloudHelpApplication.class,args);
    }

}
