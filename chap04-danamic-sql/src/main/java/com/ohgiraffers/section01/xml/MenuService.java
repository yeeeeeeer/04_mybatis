package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.ohgiraffers.common.Template.getSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    // 1-1. 원하는 금액대 추천 메뉴
    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 맵으로 반환해서 넘겨줄 수 있음
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);
        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    // 1-2. 메뉴 검색(카테고리 또는 메뉴이름)
    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    // 2. 선택한 카테고리 메뉴 보여주기
    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    // 3. 랜덤메뉴 조회
    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // key value 형식으로 보내기위해 map으로 바꾼다
        Map<String, List<Integer>> codeList = new HashMap<>();
        codeList.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(codeList);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> stringObjectMap) {
        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(stringObjectMap);

        if(menuList != null && menuList.size() > 0) {
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println(" 검색 결과가 없습니다 ");
        }
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> stringObjectMap) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(stringObjectMap);

        if(result > 0){
            System.out.println("수정 불가");
            sqlSession.commit();
        }else {
            System.out.println("수정 실패");
            sqlSession.commit();
        }
        sqlSession.close();
    }
}
