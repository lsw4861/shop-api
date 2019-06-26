package cn.duxue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序启动入口
 * Created by liang on 2019/1/5.
 */
@SpringBootApplication
@MapperScan("cn.duxue.api.*.mapper")
public class DuXueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuXueApiApplication.class, args);
    }

}
