package at.htlleonding.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ArztDto(
        @NotNull
        @NotEmpty
        String name,
        @NotNull
        @NotEmpty
        String profession
) {



}
