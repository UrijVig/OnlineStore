package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.extensions;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.AbstractWebController;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Order;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/orders")
public class OrderController extends AbstractWebController  <Order> {
    public OrderController(DBManagementService<Order> dbManagementService) {
        super(dbManagementService, "administration/product/orderpage/", "redirect:/orders/findAll");
    }
    @Override
    public String createProductForm(Order order, Model model){
        model.addAttribute("order", new Flavoring());
        return super.createProductForm(order, model);
    }

}
