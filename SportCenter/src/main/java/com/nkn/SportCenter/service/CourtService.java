package com.nkn.SportCenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.CourtRequest;
import com.nkn.SportCenter.entities.Category;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.mapper.CourtMapper;
import com.nkn.SportCenter.repository.CategoryRepository;
import com.nkn.SportCenter.repository.CourtRepository;

@Service
public class CourtService {
    @Autowired
    private CourtRepository courtRepo;
    @Autowired
    private CategoryRepository cateRepo;
    @Autowired
    private CourtMapper courtMapper;

    public Court createCourt(CourtRequest request){
        Court court=this.courtMapper.toCourt(request);
        Optional<Category> cate_object=this.cateRepo.findById(request.getCategory());
        Category cate=cate_object.get();
        court.setCategory(cate);
    
        return this.courtRepo.save(court);
    }

    public List<Court> getAllCourt(){
        return this.courtRepo.findAll();
    }

    public Court findCourtById(int id){
        Optional<Court> court_object= this.courtRepo.findById(id);
        Court court=court_object.get();
        return court;
    }
}
