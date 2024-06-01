package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Flavoring;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavoringDBRepository extends JpaRepository<Flavoring, Long>, AbstractDBRepository<Flavoring> {
}