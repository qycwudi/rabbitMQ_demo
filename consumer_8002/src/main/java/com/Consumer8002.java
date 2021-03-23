package com;/**
 * @ClassName: Consumer8002
 * @Description:
 * @Author: qiangyuecheng
 * @Date: 2021/3/23 6:06 下午
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@ClassName: Consumer8002
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/3/23 6:06 下午
 */
@SpringBootApplication
@MapperScan("com.qyc.mapper")
public class Consumer8002 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer8002.class,args);
    }
}
