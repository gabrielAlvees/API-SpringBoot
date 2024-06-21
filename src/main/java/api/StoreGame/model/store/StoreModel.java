package api.StoreGame.model.store;

import api.StoreGame.dto.store.CreateStoreDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name="store")
@Table(name="store")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StoreModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double price;
    private String about;
    private LocalDate releaseDate; // Data lançamento do jogo
    private LocalDate publishDate; // Data de publicação do jogo (data atual)

    public StoreModel(CreateStoreDTO dto){
        this.name = dto.name();
        this.price = dto.price();
        this.about = dto.about();
        this.releaseDate = dto.releaseDate();
    }

    // Método chamado antes de persistir a entidade
    @PrePersist
    protected void onCreate(){
        this.publishDate = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
