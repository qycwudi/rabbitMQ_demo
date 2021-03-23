package com.qyc.controller;/**
 * @ClassName: OrderinfoController
 * @Description:
 * @Author: qiangyuecheng
 * @Date: 2021/3/23 6:23 下午
 */

import com.bean.OrderInfo;
import com.bean.R;
import com.qyc.service.impl.OrderInfoServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *@ClassName: OrderinfoController
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/3/23 6:23 下午
 */
@RestController
@RequestMapping("order")
public class OrderinfoController {

    @Autowired
    private OrderInfoServiceImpl orderInfoService;

    @GetMapping("/insert/{name}")
    public R insertOrder(@PathVariable("name") String name){
        OrderInfo orderInfo = orderInfoService.insertOrder(name);
        return R.ok().data("message","success").data("order",orderInfo);
    }

    @GetMapping("/select")
    public R selectStu(){
        return R.ok().data("message","success").data("order",orderInfoService.selectStu());
    }


    /**
     * @Description: 发送消息
     * @Date: 2021/3/24
     * @Param:
     * @Return:
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @Description: 点对点 direct
     * @Date: 2021/3/24
     * @Param: convertAndSend(交换机，路由key，对象)
     * @Return:
     */
    @GetMapping("direct")
    public R directSend(String name){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(222l);
        orderInfo.setId(111l);
        orderInfo.setCreateTime(new Date());
        orderInfo.setState(0);
        rabbitTemplate.convertAndSend("mq.direct",orderInfo);
        return R.ok();
    }

    /**
     * @Description: fanout 订阅模式
     * @Date: 2021/3/24
     * @Param:
     * @Return:
     */
    @GetMapping("fanout")
    public R fanoutSend(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(333l);
        orderInfo.setId(222l);
        orderInfo.setCreateTime(new Date());
        orderInfo.setState(0);
        rabbitTemplate.convertAndSend("bean_fanoutExchange","",orderInfo);
        return R.ok();
    }

    /**
     * @Description: topic  主题模式 模糊匹配
     * @Date: 2021/3/24
     * @Param:
     * @Return:
     */
    @GetMapping("topic3")
    public R topicSend3(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(444l);
        orderInfo.setId(333l);
        orderInfo.setCreateTime(new Date());
        orderInfo.setState(0);
        rabbitTemplate.convertAndSend("bean_topicExchange","com.qyc",orderInfo);
        return R.ok().data("num",3);
    }
    @GetMapping("topic2")
    public R topicSend2(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(444l);
        orderInfo.setId(333l);
        orderInfo.setCreateTime(new Date());
        orderInfo.setState(0);
        rabbitTemplate.convertAndSend("bean_topicExchange","com.qyc.qyc",orderInfo);
        return R.ok().data("num",2);
    }
    @GetMapping("topic1")
    public R topicSend1(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(444l);
        orderInfo.setId(333l);
        orderInfo.setCreateTime(new Date());
        orderInfo.setState(0);
        rabbitTemplate.convertAndSend("bean_topicExchange","qyc.qyc.qyc",orderInfo);
        return R.ok().data("num",1);
    }

}
