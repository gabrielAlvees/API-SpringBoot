package api.StoreGame.controller.store;

import api.StoreGame.dto.store.CreateStoreDTO;
import api.StoreGame.dto.store.UpdateStroreDTO;
import api.StoreGame.model.store.StoreModel;
import api.StoreGame.repository.store.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @GetMapping
    public ResponseEntity getAllGames(){
        var games = storeRepository.findAll();
        return ResponseEntity.ok(games);
    }

    @PostMapping
    public ResponseEntity registerGames(@RequestBody @Valid CreateStoreDTO data){
        var games = new StoreModel(data);
        storeRepository.save(games);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateGames(@RequestBody @Valid UpdateStroreDTO data){
        Optional<StoreModel> optionalGames = storeRepository.findById(data.id());

        if(optionalGames.isPresent()){
            StoreModel storeModel = optionalGames.get();

            storeModel.setName(data.name());
            storeModel.setPrice(data.price());
            storeModel.setAbout(data.about());
            storeModel.setReleaseDate(data.releaseDate());

            return ResponseEntity.ok(storeModel);
        }

        throw new EntityNotFoundException();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGames(@PathVariable UUID id){
        Optional<StoreModel> optionalGames = storeRepository.findById(id);

        if(optionalGames.isPresent()){
            storeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        throw new EntityNotFoundException();
    }

}
