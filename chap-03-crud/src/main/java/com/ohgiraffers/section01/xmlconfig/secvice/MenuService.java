package com.ohgiraffers.section01.xmlconfig.secvice;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

// DAO를 호출 -> 데이터베이스 작업수행 -> 컨트롤러에 결과 반환을 한다.
public class MenuService {


    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {

        // connection 객체 생김
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList; // 리턴 받는 곳 -> controller !
    }

    public MenuDTO selectMenuByCode(int code) {

        // connection 객체 만듬
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession,code);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        // 0이상이면 트루
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        if(result > 0){
            sqlSession.commit();  // commit ?
        }else{
            sqlSession.rollback();  // rollback ?
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
