package api.StoreGame.dto.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateStroreDTO(
        UUID id,
        @NotBlank String name,
        @NotNull double price,
        @NotBlank String about,
        @NotNull LocalDate releaseDate
) {
}
