package ezenweb.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductImgDto {

    private String uuidFileName;    // 이미지식별이름[PK]
    private String realFileName;// 이미지실제이름

}
