package com.yejf.cookbook.controller;

import com.yejf.cookbook.model.CookBook;
import com.yejf.cookbook.service.CookbookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class CookbookController {
    @Autowired
    private CookbookService cookbookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(CookBook query,Model model) {
        List<CookBook> cookBooks = cookbookService.getByExample(query);
        model.addAttribute("cookBooks",cookBooks);
        model.addAttribute("query",query);
        return "index";
    }

    @GetMapping("/add")
    public String add(CookBook cookBook) {
        cookbookService.fillAsNow(cookBook);
        return "add";
    }

    @PostMapping("/add")
    public String doAdd(@Valid CookBook cookBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        log.info("add dish {}", cookBook);
        cookbookService.save(cookBook);
        return "addSuccess";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam int id) {
        cookbookService.remove(id);
        return "redirect:/";
    }
}
