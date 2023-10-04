package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // @Controller 동일한 기능 + @ResponseBody 제공
@RequestMapping( value = "day03") // 클래스에 매핑 url 정의할 경우, 해당 클래스 안에 메소드들의 공통url
public class RestController5 {
    // 1. GET
        //@ResponseBody : 해당 클래스가 @RestController 인 경우에는 생략가능

        @GetMapping("/Pink")

        public String getPink(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 2. POST
        @PostMapping(value = "/Pink")

        public String postPink(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 3. PUT
        @PutMapping(value = "/Pink")

        public String putPink(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 4. DELETE
        @DeleteMapping(value = "/Pink")

        public String deletePink(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
}
