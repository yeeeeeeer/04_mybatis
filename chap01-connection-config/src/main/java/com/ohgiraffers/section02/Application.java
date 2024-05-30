package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";  //파일명 작성
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            session = sqlSessionFactory.openSession(false);

            Date date = session.selectOne("mapper.selectSysDate"); // 하나 받아와서 one., 여러개는 list
            System.out.println(date + "section02 Application");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }


    }
}
