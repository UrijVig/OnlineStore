package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandlesDBRepository extends JpaRepository<Candle, Long> {
    Optional<Candle> findByName(String name);
}
