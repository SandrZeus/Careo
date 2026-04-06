package ge.careo.backend.car.controller;

import ge.careo.backend.car.dto.request.CreateCarRequest;
import ge.careo.backend.car.dto.request.UpdateCarRequest;
import ge.careo.backend.car.dto.response.CarResponse;
import ge.careo.backend.car.entity.Car;
import ge.careo.backend.car.mapper.CarMapper;
import ge.careo.backend.car.service.CarService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public ResponseEntity<List<CarResponse>> getAllCars() {
    List<CarResponse> cars = carService.getAllCars().stream().map(CarMapper::toResponse).toList();
    return ResponseEntity.ok(cars);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarResponse> getCarById(@PathVariable UUID id) {
    return carService
        .getCarById(id)
        .map(CarMapper::toResponse)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new RuntimeException("Car not found"));
  }

  @PostMapping
  public ResponseEntity<CarResponse> createCar(@RequestBody CreateCarRequest request) {
    Car car = CarMapper.toEntity(request);
    Car saved = carService.createCar(car);
    return ResponseEntity.status(HttpStatus.CREATED).body(CarMapper.toResponse(saved));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCar(@PathVariable UUID id) {
    carService.deleteCar(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<CarResponse> updateCar(
      @PathVariable UUID id, @RequestBody UpdateCarRequest request) {
    Car updated = carService.updateCar(id, request);
    return ResponseEntity.ok(CarMapper.toResponse(updated));
  }
}
