package com.yejf.cookbook.service;

import com.yejf.cookbook.model.CookBook;
import com.yejf.cookbook.model.PeriodOfDay;
import com.yejf.cookbook.model.Session;
import com.yejf.cookbook.repository.CookbookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CookbookService {
    @Autowired
    private CookbookDao cookbookDao;

    public void save(CookBook cookBook){
        cookbookDao.save(cookBook);
    }

    public void remove(int id) {
        cookbookDao.remove(id);
    }

    public List<CookBook> getByExample(CookBook query) {
        fillAsNow(query);
        return cookbookDao.search(query);
    }

    public void fillAsNow(CookBook cookBook) {
        if (cookBook.getPeriodOfDay() == null){
            cookBook.setPeriodOfDay(PeriodOfDay.getNow());
        }
        if (cookBook.getDayOfWeek() == null){
            cookBook.setDayOfWeek(LocalDateTime.now().getDayOfWeek().getValue());
        }
        if (cookBook.getSession() == null){
            cookBook.setSession(Session.getNow());
        }
    }
}
