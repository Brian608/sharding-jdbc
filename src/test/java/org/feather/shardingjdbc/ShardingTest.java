package org.feather.shardingjdbc;

import org.feather.shardingjdbc.dao.OrderMapper;
import org.feather.shardingjdbc.model.Order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @projectName: sharding-jdbc
 * @package: org.feather.shardingjdbc
 * @className: Test
 * @author: feather
 * @description:
 * @since: 2023-08-05 8:29
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {
    @Resource
    private OrderMapper orderMapper;

    @Test
    public  void contextLoads() {
    }

   @Test
    public  void  testInsertOrder(){
        Order order=new Order();
        order.setUserId(19);
        order.setId(1);
        order.setOrderAmount(BigDecimal.TEN);
        order.setOrderStatus(1);
        orderMapper.insert(order);
    }
}
