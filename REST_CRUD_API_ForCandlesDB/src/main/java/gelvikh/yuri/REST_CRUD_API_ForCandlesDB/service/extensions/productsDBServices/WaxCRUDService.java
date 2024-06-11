package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Wax;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository.WaxDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WaxCRUDService  extends AbstractDBService<Wax> {


    public WaxCRUDService(WaxDBRepository waxDBRepository) {
        super(waxDBRepository);
    }
    @Override
    @Transactional
    public Wax updateProductById(Wax product) {
        Wax oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());

        return dbRepository.save(oldProduct);
    }
}