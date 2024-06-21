package api.StoreGame.repository.store;

import api.StoreGame.model.store.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<StoreModel, UUID> {
}
