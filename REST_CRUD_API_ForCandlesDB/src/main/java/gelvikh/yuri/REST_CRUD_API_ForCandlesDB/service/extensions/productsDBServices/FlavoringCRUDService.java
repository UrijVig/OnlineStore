package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Flavoring;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository.FlavoringDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlavoringCRUDService  extends AbstractDBService<Flavoring> {


    public FlavoringCRUDService(FlavoringDBRepository flavoringDBRepository) {
        super(flavoringDBRepository);
    }
    @Override
    @Transactional
    public Flavoring updateProductById(Flavoring product) {
        Flavoring oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());

        return dbRepository.save(oldProduct);
    }
}