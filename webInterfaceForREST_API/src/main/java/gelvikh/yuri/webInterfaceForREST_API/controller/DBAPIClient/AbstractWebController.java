package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient;

import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public abstract class AbstractWebController<T> {
    protected final DBManagementService<T> dbManagementService;
    protected final String VIEW_PATH;
    protected final String WEB_PATH;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<T> listOfT = dbManagementService.getAllProduct();
        model.addAttribute("products", listOfT);
        return VIEW_PATH + "list";
    }

    @GetMapping("/create")
    public String createProductForm(T t,  Model model){
        return VIEW_PATH + "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute T t){
        dbManagementService.createProduct(t);
        return WEB_PATH;
    }

    @GetMapping("update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model) {
        T t = dbManagementService.getProductById(id);
        model.addAttribute("product", t);
        return VIEW_PATH + "update";
    }

    @PostMapping("/update")
    public String updateCandleById(T t) {
        dbManagementService.updateProduct(t);
        return WEB_PATH;
    }

    @GetMapping("delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        dbManagementService.deleteProductById(id);
        return WEB_PATH;
    }
}
