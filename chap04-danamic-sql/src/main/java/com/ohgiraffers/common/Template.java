package com.ohgiraffers.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// sql 연결할 메소드가 들어있는 객체
public class Template {

    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSession(){

        if(sqlSessionFactory == null){
            String resource = "config/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                // 팩토리없으면 설치할거야
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return sqlSessionFactory.openSession(false);

    }

}
