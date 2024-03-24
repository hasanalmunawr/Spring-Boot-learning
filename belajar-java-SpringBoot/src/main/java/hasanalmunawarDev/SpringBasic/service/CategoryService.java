package hasanalmunawarDev.SpringBasic.service;

import hasanalmunawarDev.SpringBasic.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    @Getter
    private CategoryRepository categoryRepository;

    @Autowired /*Secara otomatis Spring akan mencari bean yang dibutuhkan di setter method yang memiliki annotation @Autowired*/
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
