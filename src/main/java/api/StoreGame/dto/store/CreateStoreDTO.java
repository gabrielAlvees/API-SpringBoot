package api.StoreGame.dto.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateStoreDTO(
        @NotBlank String name,
        @NotNull double price,
        @NotBlank String about,
        @NotNull LocalDate releaseDate
) {
}
