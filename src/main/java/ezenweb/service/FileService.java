package ezenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.UUID;

@Service // 서비스 컴포넌트 빈 등록
public class FileService {
    /*파일 관련 메소드 정의*/

    // 0. 파일 경로(배포 전) 후에는 달라짐
    private String fileRootPath ="c:\\java\\";

    // 1. 업로드
    public String fileUpload(MultipartFile multipartFile){
        // 0. 유효성 검사
        if(multipartFile.isEmpty()){ // 파일이 비어있으면 // 확장자유효성 검사 여기서 할 수 있음
            return null; // 비어 있으면 null리턴
        }
        // 1. 파일 이름[파일명은 식별자가 될 수 없다. 1.UUID조합 2.날짜/시간 조합 3.상위컨텐츠pk 등등]
        String fileName =
                UUID.randomUUID().toString()+"_"+ // UUID를 이용한 파일 식별자 만들기
                multipartFile.getOriginalFilename().replaceAll("_","-"); // 만일 식별을 위해 '_'를 제거하고 '-'변경
        // 2. 파일 경로
        File file = new File(fileRootPath + fileName);
        // 3 업로드

        try{
            multipartFile.transferTo(file);
            return fileName; // 성공시 파일명 리턴[db에 저장하려고]
        }catch (Exception e){
            System.out.println("업로드 실패 "+ e);
            return null; // 실패시 null 리턴
        }



    }

    // 2. 다운로드
    @Autowired
    private HttpServletResponse response;

    public void fileDownload(String uuidFile){

        // 1. 다운로드할 파일명 찾기
        String downloadFilePath = fileRootPath + uuidFile;

        // 2. uuid 제거된 순수 파일명 [파일로드 시 출력되는 파일명 이니까 uuid 제거]
        String fileName = uuidFile.split("_")[1]; // _기준으로 쪼갠후 뒷자리 파일명만 호출

        try {
            // 3. 다운로드 형식 구성 [브라우저가 지원하는 다운로드 형식 - 별도로 커스텀 불가능]
            response.setHeader("Content-Disposition",
            "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 4. 다운로드
            // --------------------- 서버가 해당 파일 읽어오기 -----------------------------//
                // 1. 서버가 해당 파일 읽어오기
                File file = new File(downloadFilePath);
                // 2. 버퍼스트림 이용한 바이트로 파일 읽어오기
                BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
                // 3. 파일의 용량[바이트] 만큼 바이트배열 선언
                byte[] bytes = new byte[(int)file.length()];
                // 4. 버퍼스트림이 읽어온 바이트들을 바이트배열에 저장
                fin.read(bytes);
            // --------------------- 서버가 읽어온파일을 클라이언트에게 응답하기-----------------------------//
                // 1. 버퍼스트림 이용한 response 으로 응답하기
                BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
                // 2. 읽어온 바이트[파일] 내보내기
                fout.write(bytes);
                // 3. 안전하게 스트림 닫기
                fout.flush(); fout.close(); fin.close();
                
        }catch (Exception e){



        }




    }





}
