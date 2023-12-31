package org.feather.shardingjdbc;

import org.feather.shardingjdbc.dao.AreaMapper;
import org.feather.shardingjdbc.dao.OrderMapper;
import org.feather.shardingjdbc.model.Area;
import org.feather.shardingjdbc.model.AreaExample;
import org.feather.shardingjdbc.model.Order;

import org.feather.shardingjdbc.model.OrderExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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

    @Resource
    private AreaMapper areaMapper;

    @Test
    public  void contextLoads() {
    }

   @Test
    public  void  testInsertOrder(){
        Order order=new Order();
        order.setUserId(20);
        order.setId(4);
        order.setOrderAmount(BigDecimal.TEN);
        order.setOrderStatus(1);
        orderMapper.insert(order);
    }

    @Test
    public void testSelectOrder(){
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(1)
                .andUserIdEqualTo(19);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        orders.forEach(o-> System.out.println(o.getId()+"----"+o.getUserId()));
    }


    @Test
    public  void  getGolbal(){
        Area area=new Area();
        area.setId(2);
        area.setName("上海");
        areaMapper.insert(area);
    }


    @Test
    public  void  selectGlobal(){
        AreaExample areaExample=new AreaExample();
        areaExample.createCriteria().andIdEqualTo(2);
        List<Area> areaList = areaMapper.selectByExample(areaExample);
        areaList.forEach(System.out::println);

    }
}
