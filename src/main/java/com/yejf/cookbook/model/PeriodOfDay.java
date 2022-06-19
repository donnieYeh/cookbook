package com.yejf.cookbook.model;

import java.time.LocalDateTime;

public enum PeriodOfDay {
    MORNING,
    AFTERNOON,
    EVENING;

    public static PeriodOfDay getNow(){
        if (LocalDateTime.now().getHour() < 9){
            return MORNING;
        }else if (LocalDateTime.now().getHour() < 14){
            return AFTERNOON;
        }else {
            return EVENING;
        }
    }
}
