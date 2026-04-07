package ge.careo.backend.car.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ge.careo.backend.car.dto.request.CreateCarRequest;
import ge.careo.backend.car.dto.request.UpdateCarRequest;
import ge.careo.backend.car.entity.Car;
import ge.careo.backend.car.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CarServiceTest {
  @Mock private CarRepository carRepository;

  private CarService carService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    carService = new CarService(carRepository);
  }

  @Test
  void getAllCars_returnsList() {
    Car car = new Car();
    car.setMake("Porsche");
    car.setModel("911 Turbo S");

    when(carRepository.findAll()).thenReturn(List.of(car));

    List<Car> result = carService.getAllCars();

    assertEquals(1, result.size());
    assertEquals("Porsche", result.get(0).getMake());
  }

  @Test
  void getCarById_returnsCar() {
    UUID id = UUID.randomUUID();
    Car car = new Car();
    car.setMake("Porsche");
    car.setModel("911 Turbo S");

    when(carRepository.findById(id)).thenReturn(Optional.of(car));

    Optional<Car> result = carService.getCarById(id);

    assertTrue(result.isPresent());
    assertEquals("Porsche", result.get().getMake());
  }

  @Test
  void getCarById_returnsEmpty() {
    UUID id = UUID.randomUUID();

    when(carRepository.findById(id)).thenReturn(Optional.empty());

    Optional<Car> result = carService.getCarById(id);

    assertTrue(result.isEmpty());
  }

  @Test
  void createCar_returnsCar() {
    CreateCarRequest request = new CreateCarRequest();
    request.setMake("Porsche");
    request.setModel("911 Turbo S");
    request.setGeneration("992");
    request.setProductionYear((short) 2021);

    Car savedCar = new Car();
    savedCar.setMake("Porsche");
    savedCar.setModel("911 Turbo S");

    when(carRepository.save(any(Car.class))).thenReturn(savedCar);

    Car result = carService.createCar(request);

    assertEquals("Porsche", result.getMake());
    assertEquals("911 Turbo S", result.getModel());
  }

  @Test
  void deleteCar_returnEmpty() {
    UUID id = UUID.randomUUID();

    carService.deleteCar(id);

    verify(carRepository).deleteById(id);
  }

  @Test
  void updateCar_returnsCar() {
    UUID id = UUID.randomUUID();
    Car existingCar = new Car();
    existingCar.setMake("Porsche");
    existingCar.setModel("911 Turbo S");

    UpdateCarRequest request = new UpdateCarRequest();
    request.setMake("Porsche");
    request.setModel("911 Turbo S");
    request.setGeneration("992");
    request.setProductionYear((short) 2021);
    request.setPower(478);

    when(carRepository.findById(id)).thenReturn(Optional.of(existingCar));
    when(carRepository.save(existingCar)).thenReturn(existingCar);

    Car result = carService.updateCar(id, request);

    assertEquals("Porsche", result.getMake());
    assertEquals(478, result.getPower());
  }

  @Test
  void updateCar_returnsEmpty() {
    UUID id = UUID.randomUUID();

    UpdateCarRequest request = new UpdateCarRequest();
    request.setMake("Porsche");

    when(carRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> carService.updateCar(id, request));
  }
}
