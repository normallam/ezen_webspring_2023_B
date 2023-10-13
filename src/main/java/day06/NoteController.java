package day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller 사용처 : 웹 : JS(AJAX), REACT(AXIOS), 앱, 소프트웨어
// 역할 : AJAX[외부인]  <----연결다리[자바]---->  Service[자바] ---repository----entity----> DB table
// 식당 예시
// 예시 : 손님(주문 요청/ 주문응답) <---대화/행위---서빙---대화/행위---> 요리사 ---대화/행위---> 냉장고
// 대화/행위 : 상호작용
@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    // 1. C
    @PostMapping("/note")
    public boolean bwrite(@RequestBody NoteDto noteDto){
        boolean result = noteService.bwrite(noteDto);
        return false;}
    // 2. R
    @GetMapping("/do")
    public List<NoteDto> blist( NoteDto noteDto){
        List<NoteDto> result = noteService.blist();
        return result;}
    // 3. U
    @PutMapping("/do")
    public boolean bupdate(@RequestBody NoteDto noteDto){
        boolean result = noteService.bupdate(noteDto);
        return false;}
    // 4. D
    @DeleteMapping("/do")
    public boolean bdelete(@RequestParam int no){
        boolean result = noteService.bdelete(no);
        return false;}
}
