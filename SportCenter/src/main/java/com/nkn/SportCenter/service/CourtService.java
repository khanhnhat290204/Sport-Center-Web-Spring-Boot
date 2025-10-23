package com.nkn.SportCenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.CourtRequest;
import com.nkn.SportCenter.entities.Category;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.repository.CategoryRepository;
import com.nkn.SportCenter.repository.CourtRepository;

@Service
public class CourtService {
    @Autowired
    private CourtRepository courtRepo;
    @Autowired
    private CategoryRepository cateRepo;

    public Court createCourt(CourtRequest request){
        Court court=new Court(); 
        Optional<Category> cate_object=this.cateRepo.findById(request.getCategory());
        Category cate=cate_object.get();
        court.setPrice(request.getPrice());
        court.setCategory(cate);
        court.setCourt_status(request.getCourt_status());
        court.setDescription(request.getDescription());
        
        return this.courtRepo.save(court);
    }

    public List<Court> getAllCourt(){
        return this.courtRepo.findAll();
    }
}
