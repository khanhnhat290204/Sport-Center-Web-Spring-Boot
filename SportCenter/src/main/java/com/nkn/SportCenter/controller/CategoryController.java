package com.nkn.SportCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.CategoryRequest;
import com.nkn.SportCenter.entities.Category;
import com.nkn.SportCenter.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService cateService;

    @PostMapping("/category")
    Category createCate(@RequestBody CategoryRequest request){
        return cateService.createCate(request);
    }

    @GetMapping("/category")
    List<Category> getCategory(){
        return cateService.getCategory();
    }
}
