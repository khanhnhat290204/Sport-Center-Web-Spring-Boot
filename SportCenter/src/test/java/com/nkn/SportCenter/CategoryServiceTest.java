package com.nkn.SportCenter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nkn.SportCenter.dto.request.CategoryRequest;
import com.nkn.SportCenter.entities.Category;
import com.nkn.SportCenter.mapper.CategoryMapper;
import com.nkn.SportCenter.repository.CategoryRepository;
import com.nkn.SportCenter.service.CategoryService;

public class CategoryServiceTest {
    @Mock
    private CategoryRepository cateRepo;

    @Mock
    private CategoryMapper cateMapper;

    @InjectMocks
    private CategoryService cateService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCategory(){
        CategoryRequest request= new CategoryRequest();

        request.setName("Football");

        Category mapped= new Category();
        mapped.setName("Football");

        Category saved = new Category();
        saved.setName("Football");

        when(cateMapper.toCategory(request)).thenReturn(mapped);
        when(cateRepo.save(mapped)).thenReturn(saved);

        Category result= cateService.createCate(request);

        // assertEquals(1, result.getId());
        assertEquals("Football", result.getName());

        verify(cateMapper,times(1)).toCategory(request);
        verify(cateRepo,times(1)).save(mapped);
    }
}
