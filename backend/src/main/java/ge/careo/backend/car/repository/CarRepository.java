package ge.careo.backend.car.repository;

import ge.careo.backend.car.entity.Car;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {}
