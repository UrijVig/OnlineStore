package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candlestick;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandlestickDBRepository extends JpaRepository<Candlestick, Long>, AbstractDBRepository<Candlestick> {
}