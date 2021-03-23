package com.qyc.cfg;/**
 * @ClassName: RabbitMqCfg
 * @Description:
 * @Author: qiangyuecheng
 * @Date: 2021/3/24 12:32 上午
 */

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.DigestException;

/**
 *@ClassName: RabbitMqCfg
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/3/24 12:32 上午
 */
@Configuration
public class RabbitMqCfg {

    /**
     * @Description:  声明交换机
     * @Date: 2021/3/24
     * @Param: 交换机名称，持久化 自动删除
     * @Return:
     */
//    声明交换机
    @Bean  //点对点
    public DirectExchange directExchange(){
        return new DirectExchange("bean_directExchange",true,false);
    }

    @Bean  //订阅-扇出
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("bean_fanoutExchange",true,false);
    }

    @Bean  //主题 路由*#
    public TopicExchange topicExchange(){
        return new TopicExchange("bean_topicExchange",true,false);
    }

    @Bean //
    public HeadersExchange headersExchange(){
        return new HeadersExchange("bean_headersExchange",true,false);
    }


//    声明队列
//    -------------direct---------
    @Bean
    public Queue directQueue01(){
        return new Queue("directQueue01",true,false,false);
    }
    @Bean
    public Queue directQueue02(){
        return new Queue("directQueue02",true,false,false);
    }
//   -------------- fanout-----------
    @Bean
    public Queue fanoutQueue01(){
        return new Queue("fanoutQueue01",true,false,false);
    }
    @Bean
    public Queue fanoutQueue02(){
        return new Queue("fanoutQueue02",true,false,false);
    }
    @Bean
    public Queue fanoutQueue03(){
        return new Queue("fanoutQueue03",true,false,false);
    }
    @Bean
    public Queue fanoutQueue04(){
        return new Queue("fanoutQueue04",true,false,false);
    }
//    -------------topic
    @Bean Queue topicQueue01(){
        return new Queue("topicQueue01",true,false,false);
    }
    @Bean Queue topicQueue02(){
        return new Queue("topicQueue02",true,false,false);
    }
    @Bean Queue topicQueue03(){
        return new Queue("topicQueue03",true,false,false);
    }


//    绑定
//  --------------
    @Bean
    public Binding direct01(){
        return BindingBuilder.bind(directQueue01()).to(directExchange()).with("dir01");
    }
    @Bean
    public Binding direct02(){
        return BindingBuilder.bind(directQueue02()).to(directExchange()).with("dir02");
    }
//  ---------------
    @Bean
    public Binding fanout01(){
        return BindingBuilder.bind(fanoutQueue01()).to(fanoutExchange());
    }
    @Bean
    public Binding fanout02(){
        return BindingBuilder.bind(fanoutQueue02()).to(fanoutExchange());
    }
    @Bean
    public Binding fanout03(){
        return BindingBuilder.bind(fanoutQueue03()).to(fanoutExchange());
    }
    @Bean
    public Binding fanout04(){
        return BindingBuilder.bind(fanoutQueue04()).to(fanoutExchange());
    }
//  ---------------
    @Bean
    public Binding topic01(){
        return BindingBuilder.bind(topicQueue01()).to(topicExchange()).with("com.*");
    }
    @Bean
    public Binding topic02(){
        return BindingBuilder.bind(topicQueue02()).to(topicExchange()).with("com.#");
    }
    @Bean
    public Binding topic03(){
        return BindingBuilder.bind(topicQueue03()).to(topicExchange()).with("*.qyc.#");
    }
}
