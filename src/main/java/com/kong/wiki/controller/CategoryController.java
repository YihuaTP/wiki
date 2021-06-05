package com.kong.wiki.controller;


import com.kong.wiki.bo.CategoryBO;
import com.kong.wiki.core.UnifyResponse;
import com.kong.wiki.service.CategoryService;
import com.kong.wiki.vo.CategoryPureVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 查询所有的电子书分类
     *
     * @return
     */
    @GetMapping("/list")
    public UnifyResponse<List<CategoryPureVO>> getCategoryList() {
        UnifyResponse<List<CategoryPureVO>> us = new UnifyResponse<>();
        List<CategoryPureVO> allCategoryList = categoryService.getAllCategoryList();
        us.setContent(allCategoryList);
        return us;
    }

    /**
     * 修改电子书信息
     *
     * @param categoryBO
     * @return
     */
    @PutMapping("/edit")
    public UnifyResponse updateCategory(@RequestBody CategoryBO categoryBO) {
        categoryService.updateCategory(categoryBO);
        return new UnifyResponse();
    }

    /**
     * 新增电子书
     *
     * @param categoryBO
     * @return
     */
    @PostMapping("/add")
    public UnifyResponse addCategory(@RequestBody CategoryBO categoryBO) {
        categoryService.insertCategory(categoryBO);
        return new UnifyResponse();
    }

    /**
     * 删除电子书信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public UnifyResponse deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new UnifyResponse();
    }

}
