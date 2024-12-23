package com.cloudthat.eventservice.service;

import com.cloudthat.eventservice.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategories();
}
