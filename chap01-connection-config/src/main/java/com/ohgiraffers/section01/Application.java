package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URL = "jdbc:mysql://localhost:3306/menudb";

    private static String USER = "songpa";

    private static String PASS = "songpa";

    public static void main(String[] args) {


        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 오토 커밋
        * -----------------------------------------
        * PooledDataSource : connectionPool 을 사용함 (최초 호출 시 공간 미리 만듬
        * UnPooledDataSource : 사용하지 않음 (쓸때마다 만듬?
        * */

        // 환경정보 객체를 만듬
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USER, PASS)

        );

        // 생성한 환경 설정 정보로 -> MyBatis 설정 객체 생성
        Configuration config = new Configuration(environment);  // ibatis로 임포트하기
        // - > Mapper 클래스 (인터페이스로 만들기)
        config.addMapper(Mapper.class);

        /*
        * SqlSessionFactory : sqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스(1. 바로 new를 못해서 builder를 사용함)
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할(2.)
        * build : 설정에 대한 정보를 담고있는 Configuration 타입의 객체 혹은 외부 설정파일과 연관된 stream 을
        *         매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        *
        * sqlSession : jdbc 의 connection 과 같은 역할을 하는 객체 (위에는 이걸 만들기위한 과정이라고 이해하면됨)
        * -> 여러 connection을 만들기 위한 공장을 만든거임
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        System.out.println(sqlSessionFactory);

        /*
        * openSession() : sqlSession 인터페이스 타입의 객체를 반환하는 메소드 boolean 타입 인자 전달
        *
        * - false : connection 인터페이스 타입 객체 DML 수행 후 Auto Commit 에 대한 옵션을 false 로 저장 <권장됨>
          - ture : connection 인터페이스 타입 객체 DML 수행 후 Auto Commit 에 대한 옵션을 true 로 저장
        * */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // Mapper 사용하려고 (만들어놓은 Mapper 중 선택해서 사용)
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Date date = mapper.selectSysDate();
        System.out.println(date);
        // connection 후에는 꼭 close 해야함
        sqlSession.close();

    }
}
