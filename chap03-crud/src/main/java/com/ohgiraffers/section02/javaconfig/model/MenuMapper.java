package com.ohgiraffers.section02.javaconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT MENU_CODE" +
            ", MENU_NAME" +
            ", MENU_PRICE" +
            ", CATEGORY_CODE" +
            ", ORDERABLE_STATUS" +
            " FROM TBL_MENU" +
            " WHERE ORDERABLE_STATUS = 'Y'")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE"+
            ", MENU_NAME"+
            ", MENU_PRICE"+
            ", CATEGORY_CODE"+
            ", ORDERABLE_STATUS"+
            " FROM TBL_MENU"+
            " WHERE ORDERABLE_STATUS = 'Y'"+
            " AND MENU_CODE = #{ code }")
    @ResultMap("menuResultMap")  // select로 가져온 쿼리문을 result로 mapping 담아줘야한다
    MenuDTO selectMenuByCode(int code);


    // 메뉴
    @Insert("INSERT INTO TBL_MENU(" +
            "   MENU_NAEM"+
            "  ,MENU_PRICE"+
            "  ,CATEGORY_CODE"+
            "  ,ORDERABLE_STATUS"+
            ") VALUES (" +
            "#{ name }"+
            ",#{ price }"+
            ",#{ categoryCode }"+
            ", 'Y'"+
            ")")
    int registMenu(MenuDTO menu);


    // 신규 메뉴 추가
    @Update("UPDATE TBL_MENU"+
            " SET MENU_NAME = #{name}" +
            ", MENU_PRICE = #{price}"+
            ", CATEGORY_CODE = #{categoryCode}"+
            " WHERE MENU_CODE = #{code}")
    int modifyMenu(MenuDTO menu);


    @Delete("DELETE" +
            " FROM TBL_MENU" +
            " WHERE MENU_CODE = #{code}")
    int deleteMenu(int code);
}
