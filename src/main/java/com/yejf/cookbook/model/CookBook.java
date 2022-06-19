package com.yejf.cookbook.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class CookBook {
    private int id;
    @Valid
    private Dish dish;
    @NotNull
    private Session session;
    @NotNull
    private Integer dayOfWeek;
    @NotNull
    private PeriodOfDay periodOfDay;

    public CookBook(Dish dish) {
        this.dish = dish;
    }

    public CookBook() {
    }
}
