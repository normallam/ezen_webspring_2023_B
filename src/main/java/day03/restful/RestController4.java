package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // @Controller 동일한 기능 + @ResponseBody 제공

public class RestController4 {
    // 1. GET
        //@ResponseBody : 해당 클래스가 @RestController 인 경우에는 생략가능

        @GetMapping("/day03/blue")

        public String getblue(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 2. POST
        @PostMapping(value = "/day03/blue")

        public String postblue(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 3. PUT
        @PutMapping(value = "/day03/blue")

        public String putblue(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
    // 4. DELETE
        @DeleteMapping(value = "/day03/blue")

        public String deleteblue(HttpServletRequest request) throws IOException {
            // 1. 요청
            String param1 = request.getParameter("param1");
            System.out.println("param1 = " + param1); //soutv
            // 2. 응답
            return "정상응답";
        }
}
