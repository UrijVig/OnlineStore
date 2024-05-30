package gelvikh.yuri.webInterfaceForREST_API.controller;


import gelvikh.yuri.webInterfaceForREST_API.model.Candle;
import gelvikh.yuri.webInterfaceForREST_API.service.CandlesDBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandlesController {

    private final CandlesDBManagementService dbManagementService;

    @GetMapping("/candles")
    public String findAll(Model model){
        List<Candle> candles = dbManagementService.getAllCandles();
        model.addAttribute("candles", candles);
        return "candles-list";
    }

    @GetMapping("/candle-create")
    public String createCandleForm(Candle candle){
        return "Candle-create";
    }

    @PostMapping("/candle-create")
    public String createCandle(Candle candle){
        dbManagementService.createCandle(candle);
        return "redirect:/candles";
    }

    @GetMapping("candle-update/{id}")
    public String updateCandleForm(@PathVariable Long id, Model model) {
        Candle candle = dbManagementService.getCandleById(id);
        model.addAttribute("candle", candle);
        return "candle-update";
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
