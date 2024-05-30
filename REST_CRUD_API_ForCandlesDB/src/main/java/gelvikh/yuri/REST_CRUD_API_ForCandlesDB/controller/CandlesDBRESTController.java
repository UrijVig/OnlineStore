package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller;


import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.CandleCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candles")
public class CandlesDBRESTController {

    private final CandleCRUDService service;

    @PostMapping
    public ResponseEntity<Candle> createCandle(@RequestBody Candle candle){
        return new ResponseEntity<>(service.createPosition(candle), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Candle>> getAllCandles(){
        return new ResponseEntity<>(service.getAllPositions(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Candle> findCandleById(@PathVariable Long id){
        Candle candleById;
        try {
            candleById = service.findPositionByID(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candle());
        }
        return new ResponseEntity<>(candleById, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Candle> findCandleByName(@PathVariable String name){
        Candle candleByName;
        try {
            candleByName = service.findPositionByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candle());
        }
        return new ResponseEntity<>(candleByName, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Candle> updateCandle(@RequestBody Candle candle){
        return new ResponseEntity<>(service.updatePosition(candle), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Candle> deleteCandle(@PathVariable Long id){
        service.deletePositionById(id);
        return ResponseEntity.ok().build();
    }


}
