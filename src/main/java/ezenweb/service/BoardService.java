package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    // 1. C
    @Transactional // 함수내 여럿 SQL를 하나의 일처리 단위로 처리
    public boolean write( BoardDto boardDto){

        // 1. dto -> 엔티티 변경 후 저장
        BoardEntity boardEntity
            =boardEntityRepository.save(boardDto.saveToEntity());
        // 2.
        if(boardEntity.getBno() >= 1)


        {return true;}
        return false;
    }
    // 2. R
    @Transactional
    public List<BoardDto> getAll(){
        // 1. 모든 엔티티 리스트를 호출하기
        List<BoardEntity> boardEntities = boardEntityRepository.findAll();
        // 2. 모든 엔티티 리스트 -> dto 리스트 반환
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach(e->{
            boardDtos.add(e.alltoDto());
        });

        return boardDtos;
    }
    // 3. U
    @Transactional
    public boolean update(BoardDto boardDto){
        // 1. pk 번호에 해당하는 엔티티 찾기
        Optional<BoardEntity> optionalBoardEntity
                = boardEntityRepository.findById(boardDto.getBno());

        // 2. 포장 내 내용물이 있는지 체크 = 안전하게 검토 ... 과정     .ispresent
        if(optionalBoardEntity.isPresent()){
            // 3. 포장내 내용물 꺼내기 = 포장된 곳에서 엔티티 꺼내는 과정 .get
            BoardEntity boardEntity = optionalBoardEntity.get();
            // 4. 수정 : 별도의 수정함수가 없고
            boardEntity.setBtitle(boardDto.getBtitle());
            boardEntity.setBcontent(boardDto.getBcontent());
            //boardEntity.setBview(boardDto.getBview());
            boardEntity.setBfile(boardDto.getBfile());
            //boardEntity.setMno(boardDto.getMno());

        }



        return true;
    }
    // 4. D
    @Transactional
    public boolean delete(int bno){
        // 1. 엔티티 호출
        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById(bno);
        // 2. 엔티티가 호출 되었는지 확인
        if (optionalBoardEntity.isPresent()) {
            // 3. 삭제
            boardEntityRepository.deleteById(bno);
            return true;
        }
        return false;
    }

}
