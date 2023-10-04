package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day03/post")
public class PostMappingController {

    /*
        HttpServletRequest 요청 가능

    */
    @PostMapping("/method1")
    public String method1(@RequestBody String param1){
        System.out.println("PostMappingController.method1");
        System.out.println("param1 = " + param1);
        return "정상응답";
    }
    // 2.
    @PostMapping("/method2")    // http ://localhost:8080/day03/post/method1
    public String method2(@RequestBody Map<String , String> map){ // Dto 권장하지만 Dto가 없을때 여러개 매개변수 매핑할때
        System.out.println("PostMappingController.method2");
        System.out.println("map = " + map);
        return "정상응답";
    }
    // 3.
    @PostMapping("/method3")
    public String method3(@RequestBody ParamDto paramDto){
        System.out.println("PostMappingController.method3");
        System.out.println("paramDto = " + paramDto);
        return "정상응답";
    }


}
