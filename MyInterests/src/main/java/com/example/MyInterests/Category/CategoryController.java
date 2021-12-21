package com.example.MyInterests.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List <Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
}
