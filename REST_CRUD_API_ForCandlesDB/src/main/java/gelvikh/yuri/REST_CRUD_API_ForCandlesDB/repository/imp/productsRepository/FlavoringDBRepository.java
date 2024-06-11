package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Flavoring;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavoringDBRepository extends JpaRepository<Flavoring, Long>, AbstractDBRepository<Flavoring> {
}
