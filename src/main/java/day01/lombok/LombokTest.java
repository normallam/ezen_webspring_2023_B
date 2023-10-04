package day01.lombok;

import day01.consoleMvc.ConsoleDto;

import java.time.LocalDate;

public class LombokTest {
    public static void main(String[] args) {

        // - 롬복이 없을때 DTO

        // 1. 빈생성자로 객체 생성
        ConsoleDto consoleDto = new ConsoleDto();
        // 2. 풀생성자로 객체 생성
        ConsoleDto consoleDto1 = new ConsoleDto(0, "공부", LocalDate.now(), true);
        // 3. getter, setter 메소드 사용할 때
        consoleDto1.setTitle("공부하기");
        consoleDto1.getTitle();
        // 4. ToString() 메소드 사용할때 : 객체의 필드정보를 출력하는 함수
        System.out.println(consoleDto1);

        // 5. 빌더패턴이 없을떄
            // 1. 빈생성자 또는 풀생성자가 아닌[정의된 생성자가 아닌 생성자를 사용하고 싶을때 생성자 정의해야만 가능]
        /*ConsoleDto consoleDto2 = new ConsoleDto("공부",true); // 생성[정의]된 생성자만 사용할 수 있다있다.
            // 2. 생성자는 매개변수의 순서가 다르면 오류가 발생
        ConsoleDto consoleDto3 = new ConsoleDto(true,"공부",0,LocalDate.now())
            // 매개변수 순서와 타입 일치하지않음*/
        
        // - 롬복이 있을때 DTO
        LombokDto lombokDto = new LombokDto();
        LombokDto lombokDto1 = new LombokDto(0, "공부", LocalDate.now(), true);
        lombokDto.setTitle("자바공부");
        lombokDto.getTitle();
        System.out.println(lombokDto);
        // * 빌더 패턴 : 복잡한 객체생성과정[생성자]을 다양한 구성의 객체를 만드는 패턴 지원[builder() 함수 지원]
        LombokDto lombokDto2 = LombokDto.builder().title("공부").finished(true).build();
        LombokDto lombokDto3 = LombokDto.builder().finished(true).title("공부").dueDate(LocalDate.now()).tno(0).build();
    }
}
