package gelvikh.yuri.webInterfaceForREST_API.service.convert;

import gelvikh.yuri.webInterfaceForREST_API.model.Candlestick;
import gelvikh.yuri.webInterfaceForREST_API.service.CandlesticksDBManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCandlestickConverter implements Converter<String, Candlestick> {

    private final CandlesticksDBManagementService candlesticksDBManagementService;

    public StringToCandlestickConverter(CandlesticksDBManagementService candlesticksDBManagementService) {
        this.candlesticksDBManagementService = candlesticksDBManagementService;
    }

    @Override
    public Candlestick convert(String source) {
        Long id = Long.valueOf(source);
        return candlesticksDBManagementService.getCandlestickById(id);
    }
}

