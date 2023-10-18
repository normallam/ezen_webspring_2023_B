package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// requestBody 안쓰는거는 form 형식으로 보내기 때문에 
//requestBody json으로 변경
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    // 1. C
    @PostMapping("")
    public boolean write( BoardDto boardDto){
        return boardService.write(boardDto);
    }
    // 2. R
    @GetMapping("")
    public List<BoardDto> getAll(){
        return boardService.getAll();
    }
    // 3. U
    @PutMapping("")
    public boolean update(BoardDto boardDto){
        return boardService.update(boardDto);
    }
    // 4. D
    @DeleteMapping("")
    public boolean delete(@RequestParam int bno){
        return boardService.delete(bno);
    }
}
