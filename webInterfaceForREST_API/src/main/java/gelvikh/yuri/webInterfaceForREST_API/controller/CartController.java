package gelvikh.yuri.webInterfaceForREST_API.controller;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Order;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.OrderProduct;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.CandlesDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.OrdersDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class CartController {

    private final ShoppingCartService shoppingCartService;
    private final CandlesDBManagementService candlesDBManagementService;
    private final OrdersDBManagementService ordersDBManagementService;
    @RequestMapping("/cart/add")
    public String cartAdd(@RequestParam Long candleId, @RequestParam int quantity){
        shoppingCartService.addProduct(candlesDBManagementService.getProductById(candleId), quantity);
        return "redirect:/candle/homepage/%d".formatted(candleId);
    }
    @GetMapping("/personal_area")
    public String user_personal_area(Model model){
        model.addAttribute("cart", shoppingCartService.getProducts());
        model.addAttribute("totalPrice", shoppingCartService.getSum());
        return "user/user-personal-account";
    }

    @GetMapping("delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        shoppingCartService.removeProduct(candlesDBManagementService.getProductById(id));
        return "redirect:/user/personal_area";
    }

    @GetMapping("/create_order")
    public String createOrder(Model model, @AuthenticationPrincipal UserDetails user) {
        model.addAttribute("order", new Order());
        model.addAttribute("cart", shoppingCartService.getProducts());
        model.addAttribute("totalPrice", shoppingCartService.getSum());
        model.addAttribute("user", user.getUsername());
        System.out.println(user.getUsername());
        return "user/create-order-page";
    }
    @PostMapping("/order")
    public String createOrder(Model model, @ModelAttribute Order order)  {
        shoppingCartService.getProducts().entrySet().stream()
            .forEach(e -> order.getProducts().add(new OrderProduct(e.getKey(), e.getValue())));
        order.setPrice(shoppingCartService.getSum());
        shoppingCartService.clearProducts();
        ordersDBManagementService.createProduct(order);
        return "redirect:/user/personal_area";
    }

}
