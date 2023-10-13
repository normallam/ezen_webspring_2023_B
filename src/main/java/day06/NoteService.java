package day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// NoteService 사용처 Controller
@Service
public class NoteService {

    @Autowired NoteEntityRepository noteEntityRepository;

    // 1. C
    public boolean bwrite(NoteDto noteDto){

        // 1. dto -> 엔티티 변경

        noteEntityRepository.save(noteDto.toEntity());
        return false;}
    // 2. R
    public List<NoteDto> blist(){
        // 1. 모든 엔티티 리스트를 호출하기
        List<NoteEntity> entities = noteEntityRepository.findAll();
        // 2. 모든 엔티티 리스트 -> dto 리스트 반환
        List<NoteDto> noteDtos = new ArrayList<>();

        entities.forEach(e->{
            noteDtos.add(e.toDto());
        });

        return noteDtos;}
    // 3. U
    @Transactional // 트랜잭션 : 하나/여럿 작업들을 묶어서 최소단위 업무처리
    public boolean bupdate(NoteDto noteDto){
        // 1. pk 번호에 해당하는 엔티티 찾기
        Optional<NoteEntity> optionalNoteEntity
         = noteEntityRepository.findById(noteDto.getNo());

        // 2. 포장 내 내용물이 있는지 체크 = 안전하게 검토 ... 과정     .isPresent()
        if(optionalNoteEntity.isPresent()){
            // 3. 포장내 내용물 꺼내기 = 포장된 곳에서 엔티티 꺼내는 과정 .get()
            NoteEntity noteEntity = optionalNoteEntity.get();
            // 4. 수정 : 별도의 수정함수가 없고
            noteEntity.setTitle(noteDto.getTitle());
            noteEntity.setWriter(noteDto.getWriter());
        }

        return false;}
    // 4. D
    public boolean bdelete(int no){
        noteEntityRepository.deleteById(no); // 1. 삭제할 pk번호를 대입하여 엔티티 삭제
        return false;}
}
