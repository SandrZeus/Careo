package ge.careo.backend.car.service;

import ge.careo.backend.car.dto.request.CreateCarRequest;
import ge.careo.backend.car.dto.request.UpdateCarRequest;
import ge.careo.backend.car.entity.Car;
import ge.careo.backend.car.mapper.CarMapper;
import ge.careo.backend.car.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  public Optional<Car> getCarById(UUID id) {
    return carRepository.findById(id);
  }

  public Car createCar(CreateCarRequest request) {
    Car car = CarMapper.toEntity(request);
    return carRepository.save(car);
  }

  public void deleteCar(UUID id) {
    carRepository.deleteById(id);
  }

  public Car updateCar(UUID id, UpdateCarRequest updatedCar) {
    Car existingCar = getCarById(id).orElseThrow(() -> new RuntimeException("Car not found"));

    existingCar.setMake(updatedCar.getMake());
    existingCar.setModel(updatedCar.getModel());
    existingCar.setGeneration(updatedCar.getGeneration());
    existingCar.setProductionYear(updatedCar.getProductionYear());
    existingCar.setBodyType(updatedCar.getBodyType());
    existingCar.setEngineType(updatedCar.getEngineType());
    existingCar.setCubicCapacity(updatedCar.getCubicCapacity());
    existingCar.setPower(updatedCar.getPower());
    existingCar.setTransmission(updatedCar.getTransmission());
    existingCar.setDrive(updatedCar.getDrive());
    existingCar.setCylinderCount(updatedCar.getCylinderCount());
    existingCar.setSeatCount(updatedCar.getSeatCount());
    existingCar.setDoorCount(updatedCar.getDoorCount());
    existingCar.setWeight(updatedCar.getWeight());

    return carRepository.save(existingCar);
  }
}
