package com.qyc.service.impl;

import cn.hutool.db.sql.Order;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.bean.OrderInfo;
import com.qyc.mapper.OrderInfoMapper;
import com.qyc.service.OrderInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Override
    @RabbitListener(queues = "fanoutQueue01")
    public void fanout01(OrderInfo orderInfo) {
        System.out.println("fanout01 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "fanoutQueue02")
    public void fanout02(OrderInfo orderInfo) {
        System.out.println("fanoutQueue02 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "fanoutQueue03")
    public void fanout03(OrderInfo orderInfo) {
        System.out.println("fanoutQueue03 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "fanoutQueue04")
    public void fanout04(OrderInfo orderInfo) {
        System.out.println("fanoutQueue04 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "topicQueue01")
    public void topic01(OrderInfo orderInfo) {
        System.out.println("topicQueue01 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "topicQueue02")
    public void topic02(OrderInfo orderInfo) {
        System.out.println("topicQueue02 = " + orderInfo);
    }

    @Override
    @RabbitListener(queues = "topicQueue03")
    public void topic03(OrderInfo orderInfo) {
        System.out.println("topicQueue03 = " + orderInfo);
    }

    /**
    * @Description: 点对点消息接收
    * @Date: 2021/3/24
    * @Param:
    * @Return:
    */

    @Override
    @RabbitListener(queues = "direct_queue01")
    public void p2pReceive(OrderInfo orderInfo) {
        System.out.println("点对点就收到消息 = " + orderInfo);
    }




    @Override
    public List<String> selectStu() {
        return baseMapper.selectSut();
    }

    @Override
    public OrderInfo insertOrder(String name) {
        QueryWrapper wrapper = new QueryWrapper();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(Long.valueOf(name));
        int i = baseMapper.insert(orderInfo);
        if(i==1){
            System.out.println(" 插入成功 ");
            wrapper.eq("order_no",name);
            orderInfo = baseMapper.selectOne(wrapper);
        }
        return orderInfo;
    }




}
