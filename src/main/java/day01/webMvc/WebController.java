package day01.webMvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
public class WebController {
    @GetMapping("/day01/doget")// HTTP로 부터 GET 요청을 했을때.
    public List<WebDto> doGet(){
        WebDao webDao = new WebDao();
        List<WebDto> result = webDao.doGet();
        return result;

    }
    @PostMapping("/day01/dopost")// HTTP로 부터 POST 요청을 했을때.
    public boolean doPost( String title){

        // 1. 인수 받아서 DTO 생성

        WebDto webDto = new WebDto( 0, title, LocalDate.now(), true );
        WebDao webDao = new WebDao();
        boolean result = webDao.doPost(webDto);
        return result;


    }

    @GetMapping("/day01/test")
    public String doGetter(){
        return "안녕 나는 박민재야";
    }


}
