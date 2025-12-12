package com.mur073.billsplitter.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record SplitRequestDto(@NotEmpty(message = "Items cannot not be empty") @Valid List<ItemDto> items) {

    public record ItemDto(
            @NotBlank(message = "Item name cannot be empty") String name,

            @NotNull(message = "Price cannot not be null") @Positive(message = "Price must be greater than zero") Double price,

            @NotEmpty(message = "Users list cannot not be empty") List<@NotBlank(message = "User name cannot be empty") String> users) {
    }
}
