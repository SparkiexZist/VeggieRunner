package th.ac.ku.kinkao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.kinkao.model.Order;
import th.ac.ku.kinkao.model.Vegetable;
import th.ac.ku.kinkao.service.OrderService;
import th.ac.ku.kinkao.service.VegetableService;

import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController
{

    @Autowired
    private OrderService service;

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable UUID id, Model model) {
        Order order = service.getOneById(id);
        model.addAttribute("order", order);
        return "order-edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Order order, Model model) {
        service.update(order);
        return "redirect:/order";
    }

    // Get ที่ไม่ได้ใส่อะไรคือดึงมาจากหน้า "/restaurant" และต้องมี Model เพราะต้องส่งตัวแปรอาร์เรย์ลิชไปให้
    @GetMapping
    public String getOrders(Model model)
    {
        model.addAttribute("orders", service.getAll());
        return "orders";
    }

    @GetMapping("/add")
    public String getAddForm(){
        // return vegetable-add.html
        return "order-add";
    }
    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order, Model model) {
        // พอรับเข้ามาจะเอาเข้า List
        service.addOrder(order);

        return "redirect:/order";
    }
}
