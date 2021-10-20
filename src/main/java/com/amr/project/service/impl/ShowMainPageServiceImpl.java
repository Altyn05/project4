package com.amr.project.service.impl;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.dao.abstracts.ItemMainPageDao;
import com.amr.project.dao.abstracts.ShopMainPageDao;
import com.amr.project.model.dto.ShowMainPageDTO;
import com.amr.project.model.entity.Category;
import com.amr.project.service.abstracts.ShowMainPageService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShowMainPageServiceImpl implements ShowMainPageService {

    private final ItemMainPageDao itemMainPageDao;
    private final ShopMainPageDao shopMainPageDao;
    private final CategoryDao categoryDao;
    private final ShopMapper shopMapper = Mappers.getMapper(ShopMapper.class);
    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);
    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);



    @Autowired
    public ShowMainPageServiceImpl(ItemMainPageDao itemMainPageDao, ShopMainPageDao shopMainPageDao,
                                   CategoryDao categoryDao) {
        this.itemMainPageDao = itemMainPageDao;
        this.shopMainPageDao = shopMainPageDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public ShowMainPageDTO showSearch(String s) {

        return new ShowMainPageDTO(
                shopMapper.shopListToListShopMainPageDTO(shopMainPageDao.searchShops(s)),
                itemMapper.itemListToListItemMainPageDTO(itemMainPageDao.searchItems(s)),
                categoryMapper.categoryListToListCategoryMainPageDTO(categoryDao.getAll(Category.class)),
                "Поиск товаров",
                "Поиск магазинов"
        );
    }

    @Override
    public ShowMainPageDTO show() {
        return new ShowMainPageDTO(
                shopMapper.shopListToListShopMainPageDTO(shopMainPageDao.findPopularShops()),
                itemMapper.itemListToListItemMainPageDTO(itemMainPageDao.findPopularItems()),
                categoryMapper.categoryListToListCategoryMainPageDTO(categoryDao.getAll(Category.class)),
                "Подборка популярных товаров",
                "Подборка популярных магазинов"
        );
    }
}
