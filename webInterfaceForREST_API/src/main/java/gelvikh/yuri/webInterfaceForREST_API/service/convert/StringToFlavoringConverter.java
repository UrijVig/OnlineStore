package gelvikh.yuri.webInterfaceForREST_API.service.convert;

import gelvikh.yuri.webInterfaceForREST_API.model.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.service.FlavoringDBManagementService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToFlavoringConverter implements Converter<String, Flavoring> {

    private final FlavoringDBManagementService flavoringDBManagementService;

    public StringToFlavoringConverter(FlavoringDBManagementService flavoringDBManagementService) {
        this.flavoringDBManagementService = flavoringDBManagementService;
    }

    @Override
    public Flavoring convert(String source) {
        Long id = Long.valueOf(source);
        return flavoringDBManagementService.getFlavoringById(id);
    }
}