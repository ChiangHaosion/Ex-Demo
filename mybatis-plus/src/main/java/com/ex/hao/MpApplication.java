package com.ex.hao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName com.ex.hao.MpApplication
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/15
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan("com.ex.hao.mapper")
public class MpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class,args);
    }
}
