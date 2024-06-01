package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Wax;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension.WaxDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;


@Service
public class WaxCRUDService  extends AbstractDBService<Wax> {


    public WaxCRUDService(WaxDBRepository waxDBRepository) {
        super(waxDBRepository);
    }
    @Override
    public Wax updateProductById(Wax product) {
        Wax oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());

        return dbRepository.save(oldProduct);
    }
}