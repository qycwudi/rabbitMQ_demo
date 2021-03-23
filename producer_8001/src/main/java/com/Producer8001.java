package com;/**
 * @ClassName: Producer8001
 * @Description:
 * @Author: qiangyuecheng
 * @Date: 2021/3/23 6:07 下午
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@ClassName: Producer8001
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/3/23 6:07 下午
 */
@SpringBootApplication
@MapperScan("com.qyc.mapper")
@EnableRabbit
public class Producer8001 {
    public static void main(String[] args) {
        SpringApplication.run(Producer8001.class,args);
    }
}
