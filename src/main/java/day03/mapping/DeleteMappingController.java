package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 해당 클래스를 컨트롤러임을 선언 // + ResponseBody
@RequestMapping("/day03/delete")
public class DeleteMappingController {
    // 1.
    @DeleteMapping("/method1")
    public boolean method1(@RequestParam String param1){
        System.out.println("param1 = " + param1);
        return true; // application/json // 자동으로 JSON타입으로 전송
    }
    //2.
    @DeleteMapping("/method2")
    public boolean method2(@RequestParam Map<String,String> map){
        System.out.println("map = " + map);
        return false; // application/json // 자동으로 JSON타입으로 전송
    }



}
