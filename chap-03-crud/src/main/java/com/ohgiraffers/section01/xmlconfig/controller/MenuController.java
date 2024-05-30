package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.secvice.MenuService;

import java.util.List;
import java.util.Map;

// 사용자 "요청을 받아 서비스로 전달" , 서비스로부터 받은 "결과를 반환" 하는 역할
public class MenuController {

    // 얘는 프론트페이지 대신 역할임 (화면부분)
    private final PrintResult printResult;

    // 메뉴 명령 실행할 부분
    private final MenuService menuService;

    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    // 메뉴선택 - 사용자에게 명령내리는 컨트롤러임 - 메뉴 1번임
    public void selectAllMenu() {

        // 메소드결과값을 리스트로 담아준다
        List<MenuDTO> menuList = menuService.selectAllMenu();  //-> 서비스로 이동

        PrintResult.printMenuList(menuList);
    }

    public void selectMenuByCode(Map<String, String> parameter) {

        // 문자열로된 숫자를 정수형으로 바꿔준다 Integer.parseInt
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        printResult.printMenu(menu);
    }

    public void registMenu(Map<String, String> parameter) {

        MenuDTO menu = new MenuDTO();
        menu.setName(parameter.get("name"));
        menu.setPrice(Integer.parseInt(parameter.get("price")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if(menuService.registMenu(menu)){
            // 메뉴등록 성공했을때 동작
            printResult.printSuccessMessage("insert");
        }else {
            // 메뉴등록 실패했을 때 동작
            printResult.printErrorMessage("insert");
        }
    }


}
