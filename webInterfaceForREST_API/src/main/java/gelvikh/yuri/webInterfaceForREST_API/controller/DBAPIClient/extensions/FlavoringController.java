package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.extensions;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.AbstractWebController;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flavoring")
public class FlavoringController extends AbstractWebController<Flavoring> {
    public FlavoringController(DBManagementService<Flavoring> dbManagementService) {
        super(dbManagementService, "administration/product/flavoringpage/", "redirect:/flavoring/findAll");
    }
    @Override
    public String createProductForm(Flavoring flavoring, Model model) {
        model.addAttribute("product", new Flavoring());
        return super.createProductForm(flavoring, model);
    }
}