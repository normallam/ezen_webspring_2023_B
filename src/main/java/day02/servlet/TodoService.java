package day02.servlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TodoService { // 서비스 : 구현해야 하는 기능들의 실제 처리를 담당
    // 1. 등록 서비스
    public void register(TodoDto todoDto){
        System.out.println("TodoService.register");
    }


    // 2. 출력 서비스 [Dao 없이 테스트목적의 임의의 데이터를 반환하는 리스트]
    public List<TodoDto> getList(){

        // 1. 스트림 문법을 사용하지 않을때.
       /* List<TodoDto> list = new ArrayList<>();
        for(int i = 0, i<10; i++){
            TodoDto todoDto = TodoDto.builder().tno((long)i).title("Todo.."+i).dueDate(LocalDate.now()).build();
            list.add(todoDto);
        }
        return list;*/
        // 2. 스트림 문법을 사용했을 때.
        //List<TodoDto> todoDtos = IntStream.range(0,10).mapToObj(i -> {}).collect(Collectors.toList());
        List<TodoDto> todoDtos = IntStream.range(0,10).mapToObj(i -> {
            TodoDto todoDto = TodoDto.builder().
                    tno((long)i).title("Todo.."+i).
                    dueDate(LocalDate.now())
                    .build();
            return todoDto;

        }).collect(Collectors.toList());
            return todoDtos;
                // IntStream.range(시작정수, 끝정수)
            //mapToObj(): return 값을 반환해서 배열 리스트에 대입
        //mapToObj(i -> {}).collect(Collectors.toList()) : 해당 컬렉션 타입으로 반환해서 객체 대입
    }
}
