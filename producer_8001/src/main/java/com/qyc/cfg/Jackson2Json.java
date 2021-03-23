package com.qyc.cfg;/**
 * @ClassName: Jackson2Json
 * @Description:
 * @Author: qiangyuecheng
 * @Date: 2021/3/24 12:03 上午
 */

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 *@ClassName: Jackson2Json
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/3/24 12:03 上午
 */
@Configuration
public class Jackson2Json {
    /** 
     * @Description: 序列化转json 
     * @Date: 2021/3/24 
     * @Param: 
     * @Return: 
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
