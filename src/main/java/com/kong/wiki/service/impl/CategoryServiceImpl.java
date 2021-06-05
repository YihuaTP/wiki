package com.kong.wiki.service.impl;

import com.kong.wiki.bo.CategoryBO;
import com.kong.wiki.mapper.CategoryMapper;
import com.kong.wiki.model.Category;
import com.kong.wiki.model.CategoryExample;
import com.kong.wiki.model.EbookExample;
import com.kong.wiki.service.CategoryService;
import com.kong.wiki.vo.CategoryPureVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * 查询所有的分类
     *
     * @return
     */
    @Override
    public List<CategoryPureVO> getAllCategoryList() {
        List<CategoryPureVO> list = new ArrayList<>();
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria categoryExampleCriteria = categoryExample.createCriteria();
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        for (Category category : categoryList) {
            CategoryPureVO categoryPureVO = new CategoryPureVO();
            BeanUtils.copyProperties(category, categoryPureVO);
            list.add(categoryPureVO);
        }
        return list;
    }

    /**
     * 修改分类信息
     *
     * @param categoryBO
     */
    @Override
    public void updateCategory(CategoryBO categoryBO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryBO, category);
        categoryMapper.updateByPrimaryKey(category);
    }

    /**
     * 删除某个分类
     *
     * @param id
     */
    @Override
    public void deleteCategory(Long id) {
        categoryMapper.deleteByPrimaryKey(id);

    }

    /**
     * 新增某个分类
     *
     * @param categoryBO
     */
    @Override
    public void insertCategory(CategoryBO categoryBO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryBO, category);
        categoryMapper.insert(category);
    }
}
