package example;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_incerment -> 필요한가
    private int pno;
    private String pname;
    private String pnumber;
}
