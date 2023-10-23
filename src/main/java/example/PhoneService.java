package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired PhoneEntityRepository phoneEntityRepository;


    // 1. C
    @Transactional
    public boolean postPhone(PhoneDto phoneDto){

        /*
         1. DTO를 Entity 변환
                 빌더패턴 사용하는 방법
                 클래스명.builder()
                           .저장할필드명(저장할 데이터)
                            .저장할필드명(저장할 데이터)
                            .build();
        */
        PhoneEntity phoneEntity = PhoneEntity.builder()
                .pname(phoneDto.getPname())
                .pnumber(phoneDto.getPnumber())
                .build();

        // 2. JPARepository 를 이용한 엔티티 저장 [insert 대체]

        phoneEntityRepository.save(phoneEntity);

        if(phoneEntity.getPno() >= 1)


        {return true;}
        return  false;
    }

    // 2. R

    public List<PhoneDto> getPhone(){
        // 1. 모든 엔티티 호출 [select 대체]
        List<PhoneEntity> phoneEntities = phoneEntityRepository.findAll();

        List<PhoneDto> list = new ArrayList<>();

        // 2. List<phoneEntitity> -> List<PhoneDto> 변환
        phoneEntities.forEach((entity)->{
            // 3. 엔티티를 dto로 변환
            PhoneDto phoneDto = PhoneDto.builder()
                    .pname(entity.getPname())
                    .pno(entity.getPno())
                    .pnumber(entity.getPnumber())
                    .build();
            // 4. 변환된 dto를 리스트에 저장
            list.add(phoneDto);

        });
        return list;
    }


    // 3. U

    // 트랜잭션 : 최소 단위 일처리 => 결과 [성공, 실패]
    @Transactional // import javax.transaction
    public  boolean putPhone(PhoneDto phoneDto){

        // 1. 수정할 엔티티 찾기
        Optional<PhoneEntity> phoneEntity = phoneEntityRepository.findById(phoneDto.getPno());
        // 2. Optional 객체에 엔티티 존재여부 확인 [안전성 보장]
        if(phoneEntity.isPresent()){
            // 3. Optional 객체에 엔티티 꺼내기
            PhoneEntity updateEntity = phoneEntity.get();
            // 4. 엔티티 찾았으니 필드 수정

            updateEntity.setPname(phoneDto.getPname());
            updateEntity.setPnumber(phoneDto.getPnumber());
        }
        return false;

    }

    // 4. D

    public boolean deletePhone(int pno){

        //
        Optional<PhoneEntity> optionalPhoneEntity = phoneEntityRepository.findById(pno);

        //
        if(optionalPhoneEntity.isPresent()){
            phoneEntityRepository.deleteById(pno);
            return true;
        }
        return  false;
    }

}
