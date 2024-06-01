package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do{
            System.out.println("--- 매퍼 element 테스트 메뉴 ---");
            System.out.println("1. <concat> 테스트");
            System.out.println("2. <resultMap> 서브 메뉴");
            System.out.println("3. <sql> 테스트");
            System.out.println("4. <insert> 서브 메뉴");
            System.out.println("번호를 입력해주세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1: elementTestService.selectCacheTest(); break;
                case 2: resultMapSubMenu(); break;
            }

        }while(true);
    }

    private static void resultMapSubMenu(){
        Scanner scr = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("--- <resultMap> 서브 메뉴 ---");
            System.out.println("1. <resultMap> 테스트 ");
            System.out.println("2. <constructor> 테스트 ");
            System.out.println("3. <association> 테스트 ");
            System.out.println("4. <collection> 테스트 ");
            System.out.println("메뉴 번호 입력 해주세요 : ");
            int no = scr.nextInt();

            switch (no){
                case 1: elementTestService.selectResultMapTest(); break;
                case 2: elementTestService.selectResultMapConstructorTest(); break;
                case 3: elementTestService.selectResultMapAssociationTest(); break;
                case 4: elementTestService.selectResultMapCollectionTest(); break;
            }

        } while (true);
    }

}