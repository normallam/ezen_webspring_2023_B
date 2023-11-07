package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.PageDto;
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
    @GetMapping("") // 전체출력
    public PageDto getAll(
            @RequestParam int page,
            @RequestParam String key,
            @RequestParam String keyword)


    {
        System.out.println("BoardController.getAll");
        System.out.println("page = " + page);
        return boardService.getAll(page, key, keyword);
    }

    // 2-1. R (개별게시물출력)
    @GetMapping("/doGet")
    public BoardDto doGet(@RequestParam int bno){
        return  boardService.doGet(bno);

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
