package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandleDBRepository extends JpaRepository<Candle, Long>, AbstractDBRepository<Candle> {
}
