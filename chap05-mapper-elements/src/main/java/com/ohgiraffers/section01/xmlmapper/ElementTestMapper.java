package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
// sql 쿼리를 메소드로 정의해서 데이터베이스 작업을 수행한다

    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();

    int insertMenuTset(MenuDTO menuDTO);

    int insertNewCategory(MenuAndCategoryDTO menuAndCategoryDTO);

    int insertNewMenu(MenuAndCategoryDTO menuAndCategoryDTO);
}
