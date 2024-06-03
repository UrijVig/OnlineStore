package gelvikh.yuri.webInterfaceForREST_API.controller.extensions;

import gelvikh.yuri.webInterfaceForREST_API.controller.AbstractWebController;
import gelvikh.yuri.webInterfaceForREST_API.model.Wax;
import gelvikh.yuri.webInterfaceForREST_API.service.DBManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/wax")
public class WaxController extends AbstractWebController<Wax> {
    public WaxController(DBManagementService<Wax> dbManagementService) {
        super(dbManagementService, "administration/product/waxpage/", "redirect:/wax/findAll");
    }
    @Override
    public String createProductForm(Wax wax, Model model) {
        model.addAttribute("product", new Wax());
        return super.createProductForm(wax, model);
    }
}