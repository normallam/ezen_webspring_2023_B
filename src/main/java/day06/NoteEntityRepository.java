package day06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Repository 사용처는 서비스
@Repository // 스프링 컨테이너에 등록 [왜?? 다른 곳에 객체를 써야 되니까]
public interface NoteEntityRepository extends JpaRepository<NoteEntity, Integer> {
}
