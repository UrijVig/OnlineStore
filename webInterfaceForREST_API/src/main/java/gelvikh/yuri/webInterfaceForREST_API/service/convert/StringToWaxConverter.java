package gelvikh.yuri.webInterfaceForREST_API.service.convert;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Wax;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl.WaxDBManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToWaxConverter implements Converter<String, Wax> {

    private final WaxDBManagementService waxDBManagementService;

    public StringToWaxConverter(WaxDBManagementService waxDBManagementService) {
        this.waxDBManagementService = waxDBManagementService;
    }

    @Override
    public Wax convert(String source) {
        Long id = Long.valueOf(source);
        return waxDBManagementService.getProductById(id);
    }
}