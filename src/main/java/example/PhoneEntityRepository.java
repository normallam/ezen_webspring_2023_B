package example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneEntityRepository extends JpaRepository<PhoneEntity,Integer> {
}
