package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.CandlesDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandleCRUDService {
    private final CandlesDBRepository repository;

    public Candle createPosition(Candle candle){
        return repository.save(candle);
    }

    public List<Candle> getAllPositions(){
        return repository.findAll();
    }

    public Candle findPositionByID(Long id){
        return repository.findById(id).orElseThrow();
    }
    public Candle findPositionByName(String name){
        return repository.findByName(name).orElseThrow();
    }
    public Candle updatePosition(Candle position){
        Candle oldPosition = findPositionByID(position.getID());

        oldPosition.setAmount(position.getAmount());
        oldPosition.setDescription(position.getDescription());
        oldPosition.setPrice(position.getPrice());
        oldPosition.setName(position.getName());

        return repository.save(oldPosition);
    }

    public void deletePositionById(long id){
        repository.deleteById(id);
    }
}
