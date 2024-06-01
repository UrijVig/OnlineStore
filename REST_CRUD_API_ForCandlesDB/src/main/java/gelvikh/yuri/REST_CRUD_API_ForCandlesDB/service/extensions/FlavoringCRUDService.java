package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Flavoring;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension.FlavoringDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;

@Service
public class FlavoringCRUDService  extends AbstractDBService<Flavoring> {


    public FlavoringCRUDService(FlavoringDBRepository flavoringDBRepository) {
        super(flavoringDBRepository);
    }
    @Override
    public Flavoring updateProductById(Flavoring product) {
        Flavoring oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());

        return dbRepository.save(oldProduct);
    }
}