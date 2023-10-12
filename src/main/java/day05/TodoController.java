package day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/index")
    public Resource getIndex(){
        return new ClassPathResource("templates/todo.html");
    }

    @PostMapping("")
    public boolean doPost(@RequestBody TodoDto todoDto){
        boolean result = todoService.doPost(todoDto);
        return result;}
    @GetMapping("")
    public List<TodoDto> doGet(){
        List<TodoDto> result = todoService.doGet();
        return result;
    }
    @PutMapping("")
    public boolean doPut(@RequestBody TodoDto todoDto){
        boolean result = todoService.doPut(todoDto);
        return result;
    }
    @DeleteMapping("")
    public boolean doDelete(@RequestParam int tno){
        boolean result = todoService.doDelete(tno);
        return result;

    }
//@RequestParam 매개변수 한개를 가져오는 것

}
