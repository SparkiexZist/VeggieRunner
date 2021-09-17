package th.ac.ku.kinkao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.kinkao.model.Order;
import th.ac.ku.kinkao.model.User;
import th.ac.ku.kinkao.model.Vegetable;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService
{
    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAll()
    {
        String url = "http://localhost:8090/order";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);
        Order[] orders = response.getBody();
        return Arrays.asList(orders);
    }

    public void addOrder(Order order) {
        String url = "http://localhost:8090/order";

        restTemplate.postForObject(url, order, Order.class);
    }
    public Order getOneById(UUID id) {
        String url = "http://localhost:8090/order/" + id;
        ResponseEntity<Order> response =
                restTemplate.getForEntity(url, Order.class);
        Order order = response.getBody();
        return order;
    }
    public void update(Order order) {
        String url = "http://localhost:8090/order/" + order.getOrder_Id();
        restTemplate.put(url, order, Order.class);
    }
}
