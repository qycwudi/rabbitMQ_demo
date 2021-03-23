package com.qyc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bean.OrderInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
public interface OrderInfoService extends IService<OrderInfo> {

    OrderInfo insertOrder(String name);

    List<String> selectStu();

    void p2pReceive(OrderInfo orderInfo);

    void fanout01(OrderInfo orderInfo);
    void fanout02(OrderInfo orderInfo);
    void fanout03(OrderInfo orderInfo);
    void fanout04(OrderInfo orderInfo);

    void topic01(OrderInfo orderInfo);
    void topic02(OrderInfo orderInfo);
    void topic03(OrderInfo orderInfo);
}
