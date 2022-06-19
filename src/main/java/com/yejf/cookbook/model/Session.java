package com.yejf.cookbook.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum Session {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    public static Session getNow() {
        int monthValue = LocalDate.now().getMonthValue();
        if (monthValue < 2){
            return WINTER;
        }else if(monthValue < 5){
            return SPRING;
        }else if(monthValue < 8){
            return SUMMER;
        }else if (monthValue < 11){
            return AUTUMN;
        }else{
            return WINTER;
        }
    }
}
