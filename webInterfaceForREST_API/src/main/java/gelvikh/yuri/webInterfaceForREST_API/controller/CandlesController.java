package gelvikh.yuri.webInterfaceForREST_API.controller;


import gelvikh.yuri.webInterfaceForREST_API.model.Candle;
import gelvikh.yuri.webInterfaceForREST_API.model.Candlestick;
import gelvikh.yuri.webInterfaceForREST_API.model.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.model.Wax;
import gelvikh.yuri.webInterfaceForREST_API.service.CandlesDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.CandlesticksDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.FlavoringDBManagementService;
import gelvikh.yuri.webInterfaceForREST_API.service.WaxDBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandlesController {

    private final CandlesDBManagementService dbManagementService;
    private final CandlesticksDBManagementService candlesticksDBManagementService;
    private final FlavoringDBManagementService flavoringDBManagementService;
    private final WaxDBManagementService waxDBManagementService;

    @GetMapping("/candles")
    public String findAll(Model model){
        List<Candle> candles = dbManagementService.getAllCandles();
        model.addAttribute("candles", candles);
        return "admin/candles-list";
    }

    @GetMapping("/candle-create")
    public String createCandleForm(Candle candle, Model model){
        List<Candlestick> candlesticks = candlesticksDBManagementService.getAllCandlesticks();
        List<Flavoring> flavorings = flavoringDBManagementService.getAllFlavoring();
        List<Wax> waxes = waxDBManagementService.getAllWax();

        model.addAttribute("candle", new Candle());
        model.addAttribute("candlesticks", candlesticks);
        model.addAttribute("flavorings", flavorings);
        model.addAttribute("waxes", waxes);

        return "admin/Candle-create";
    }

    @PostMapping("/candle-create")
    public String createCandle(@ModelAttribute Candle candle){
        dbManagementService.createCandle(candle);
        return "redirect:/candles";
    }

    @GetMapping("candle-update/{id}")
    public String updateCandleForm(@PathVariable Long id, Model model) {
        Candle candle = dbManagementService.getCandleById(id);
        model.addAttribute("candle", candle);
        return "admin/candle-update";
    }
    @PostMapping("/candle-update")
    public String updateCandleById(Candle candle) {
        dbManagementService.updateCandle(candle);
        return "redirect:/candles";
    }

    @GetMapping("candle-delete/{id}")
    public String deleteCandleById(@PathVariable Long id) {
        dbManagementService.deleteCandleById(id);
        return "redirect:/candles";
    }


}
