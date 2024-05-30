package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {

    // @ / 날짜호출
    @Select("SELECT CURDATE() FROM DUAL")
    // 메소드 이름(selectSysDate)으로 기능 실행시킨다
    Date selectSysDate();



}
