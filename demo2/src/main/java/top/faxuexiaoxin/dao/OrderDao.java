package top.faxuexiaoxin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.faxuexiaoxin.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
    Order findAllByReceiverName(String receiverName);
}
