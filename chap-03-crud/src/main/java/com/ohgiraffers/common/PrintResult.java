package com.ohgiraffers.common;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

// 출력 결과를 처리하는 클래스 PrintResult
public class PrintResult {

    public static void printMenuList(List<MenuDTO> menuList){
        for (MenuDTO menu:menuList) {
            System.out.println(menu);
        }
    }

    public void printMenu(MenuDTO menuDTO){
        System.out.println(menuDTO);
    }

    // 3. 메뉴추가 - 성공메소드 만들기
    public void printSuccessMessage(String code){
        String message = null;
        switch (code){
            case "insert" : message = "메뉴 등록 성공"; break;
            case "update" : message = "메뉴 수정 성공";  break;
            case "delete" : message = "메뉴 삭제 성공";  break;
            default : message = "잘못된 처리";  break;
        }
        System.out.println(message);
    }

    // 3. 메뉴추가 - 실패메소드 만들기
    public void printErrorMessage(String code){
        String message = null;
        switch (code){
            case "insert" : message = "메뉴 등록 실패"; break;
            case "update" : message = "메뉴 수정 실패";  break;
            case "delete" : message = "메뉴 삭제 실패";  break;
            default : message = "잘못된 처리";  break;
        }
        System.out.println(message);
    }
}
