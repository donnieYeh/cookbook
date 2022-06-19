package com.yejf.cookbook.repository;

import com.yejf.cookbook.model.CookBook;
import com.yejf.cookbook.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// @Repository
public class CookbookDaoLocal {
    private List<CookBook> cookbooks = new ArrayList<>();

    public void save(CookBook cookBook){
        this.cookbooks.add(cookBook);
    }

    public void remove(int id) {
        if (id >=0 && id < cookbooks.size()){
            cookbooks.remove(id);
        }
    }

    public List<CookBook> search(CookBook query) {
        List<CookBook> result = new ArrayList<>();
        for (int i = 0; i < cookbooks.size(); i++) {
            CookBook cookbook = cookbooks.get(i);
            if (cookbook.getSession() != query.getSession()){
                continue;
            }
            if (cookbook.getDayOfWeek() != query.getDayOfWeek()){
                continue;
            }
            if (cookbook.getPeriodOfDay() != query.getPeriodOfDay()){
                continue;
            }
            cookbook.setId(i);
            result.add(cookbook);
        }
        return result;
    }
}
