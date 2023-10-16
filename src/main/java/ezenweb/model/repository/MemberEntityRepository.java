package ezenweb.model.repository;

import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 스프링 컨테이너에 등록[왜 ? 다른 곳에 객체를 써야되니까] // PK에 자료형 // 제네릭은 클래스밖에 안된다 그래서 INT는 안됨
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {
}
