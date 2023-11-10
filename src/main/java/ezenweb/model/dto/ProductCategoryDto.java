package ezenweb.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductCategoryDto {

    private int pcno;       // 카테고리 번호[PK]
    private String pcname;  // 카테고리명

}
