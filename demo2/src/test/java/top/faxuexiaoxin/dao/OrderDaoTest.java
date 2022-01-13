package top.faxuexiaoxin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.faxuexiaoxin.entity.Order;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    void findAllByReceiverName() {
        Order order = orderDao.findAllByReceiverName("张三");
        assertEquals("中国上海",order.getReceiver().getAddress());
    }
}