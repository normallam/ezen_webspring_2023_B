package day04;
/* 메타 어노테이션 ?? : 실행 또는 컴파일 했을 때 사용방법(이미 설치된 라이브러리)에 대해 정의 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@ComponentScan가 포함되어 있음 [@Controller, @RestController, @Service, @Repository, @Configure 등등//]
public class AppStart {

    public static void main(String[] args) {

        SpringApplication.run(AppStart.class);

    }
}

/*

    스프링이 정적(view) 파일들을 찾는 위치 resources폴더
      - 주의할점 : 본인이 만들고 싶은 곳에 정적(VIEW) 파일 만들면 안됭다.
    HTML : resources -> templates -> html파일
    JS/CSS/Image : resources -> static -> JS/CSS/Image파일

    -JSP 프로젝트와  SPRING 프로젝트의 정적파일 경로 차이
           -JSP는 패키지의 경로와 파일명이 곧 URL
            http://
           -SPRING은 정적파일 호출하는 URL 매핑
             매핑 후 Resource

*/
