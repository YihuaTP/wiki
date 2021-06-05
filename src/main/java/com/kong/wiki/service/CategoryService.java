package com.kong.wiki.service;

import com.kong.wiki.bo.CategoryBO;
import com.kong.wiki.vo.CategoryPureVO;

import java.util.List;

public interface CategoryService {
    // 查询所有的分类
    List<CategoryPureVO> getAllCategoryList();

    // 修改分类信息
    void updateCategory(CategoryBO categoryBO);

    // 删除一个分类
    void deleteCategory(Long id);

    // 新增一个分类
    void insertCategory(CategoryBO categoryBO);
}
