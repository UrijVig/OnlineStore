package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.extensions;


import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.AbstractWebController;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Candle;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Candlestick;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Wax;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.CandlesticksDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.FlavoringDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.WaxDBManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candle")
public class CandlesController extends AbstractWebController<Candle> {
    public CandlesController(DBManagementService<Candle> dbManagementService) {
        super(dbManagementService, "administration/product/candlepage/", "redirect:/candle/findAll");
    }
    @Autowired
    private CandlesticksDBManagementService candlesticksDBManagementService;
    @Autowired
    private  FlavoringDBManagementService flavoringDBManagementService;
    @Autowired
    private  WaxDBManagementService waxDBManagementService;

    @Override
    public String updateProductForm(Long id, Model model) {
        List<Candlestick> candlesticks = candlesticksDBManagementService.getAllProduct();
        List<Flavoring> flavorings = flavoringDBManagementService.getAllProduct();
        List<Wax> waxes = waxDBManagementService.getAllProduct();
        Candle candle = dbManagementService.getProductById(id);
        model.addAttribute("candle", candle);
        model.addAttribute("candlesticks", candlesticks);
        model.addAttribute("flavorings", flavorings);
        model.addAttribute("waxes", waxes);
        return VIEW_PATH + "update";
    }

    @Override
    public String createProductForm(Candle candle,  Model model) {
        List<Candlestick> candlesticks = candlesticksDBManagementService.getAllProduct();
        List<Flavoring> flavorings = flavoringDBManagementService.getAllProduct();
        List<Wax> waxes = waxDBManagementService.getAllProduct();

        model.addAttribute("candle", new Candle());
        model.addAttribute("candlesticks", candlesticks);
        model.addAttribute("flavorings", flavorings);
        model.addAttribute("waxes", waxes);
        return VIEW_PATH + "create";
    }

    @GetMapping("/homepage")
    public String getHomepage(Model model){
        List<Candle> candles = dbManagementService.getAllProduct();
        model.addAttribute("candles", candles);
        return "main/homepage";
    }
    @GetMapping("/homepage/{id}")
    public String getProductInfo(@PathVariable Long id, Model model){
        Candle candle = dbManagementService.getProductById(id);
        model.addAttribute("candle", candle);
        return "main/single-product";
    }
}
