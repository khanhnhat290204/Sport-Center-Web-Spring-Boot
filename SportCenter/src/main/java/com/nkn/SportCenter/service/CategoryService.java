package com.nkn.SportCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nkn.SportCenter.dto.request.CategoryRequest;
import com.nkn.SportCenter.entities.Category;
import com.nkn.SportCenter.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository cateRepo;

    public Category createCate(CategoryRequest request){
        Category cate=new Category();
        
        cate.setName(request.getName());
        return cateRepo.save(cate);
    }

    public List<Category> getCategory(){
        return this.cateRepo.findAll();
    }
    
}
