package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.extensions;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.AbstractWebController;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Candlestick;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/candlestick")
public class CandlestickController extends AbstractWebController<Candlestick> {
    public CandlestickController(DBManagementService<Candlestick> dbManagementService) {
        super(dbManagementService, "administration/product/candlestickpage/", "redirect:/candlestick/findAll");
    }

    @Override
    public String createProductForm(Candlestick candlestick, Model model) {
        model.addAttribute("product", new Candlestick());
        return super.createProductForm(candlestick, model);
    }
}

