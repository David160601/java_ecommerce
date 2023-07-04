package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class UpdateProductDto {
    @NotNull
    long id;
    String title;
    String description;
    @Min(0)
    int price;
    @Min(0)
    int qty;
}
