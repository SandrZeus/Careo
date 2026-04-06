package ge.careo.backend.car.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ge.careo.backend.car.dto.request.UpdateCarRequest;
import ge.careo.backend.car.entity.Car;
import ge.careo.backend.car.service.CarService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CarController.class)
class CarControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockitoBean private CarService carService;

  @Test
  void getAllCars_returns200() throws Exception {
    when(carService.getAllCars()).thenReturn(List.of());

    mockMvc.perform(get("/api/cars")).andExpect(status().isOk());
  }

  @Test
  void getCarById_returns200() throws Exception {
    UUID id = UUID.randomUUID();
    Car car = new Car();
    car.setMake("Porsche");

    when(carService.getCarById(id)).thenReturn(Optional.of(car));

    mockMvc.perform(get("/api/cars/{id}", id)).andExpect(status().isOk());
  }

  @Test
  void createCar_returns200() throws Exception {
    Car car = new Car();
    car.setMake("Porsche");
    car.setModel("911 Turbo S");
    car.setGeneration("992");
    car.setProductionYear((short) 2021);

    when(carService.createCar(any(Car.class))).thenReturn(car);

    mockMvc
        .perform(
            post("/api/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"make\":\"Porsche\",\"model\":\"911\",\"generation\":\"992\",\"productionYear\":2021}"))
        .andExpect(status().isCreated());
  }

  @Test
  void deleteCar_returns204() throws Exception {
    UUID id = UUID.randomUUID();

    mockMvc.perform(delete("/api/cars/{id}", id)).andExpect(status().isNoContent());
  }

  @Test
  void updateCar_returns200() throws Exception {
    UUID id = UUID.randomUUID();

    Car updatedCar = new Car();
    updatedCar.setMake("Porsche");
    updatedCar.setModel("911 Turbo S");
    updatedCar.setPower(478);

    when(carService.updateCar(any(UUID.class), any(UpdateCarRequest.class))).thenReturn(updatedCar);

    mockMvc
        .perform(
            put("/api/cars/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"make\":\"Porsche\",\"model\":\"911 Turbo"
                        + " S\",\"generation\":\"992\",\"productionYear\":2021,\"power\":478}"))
        .andExpect(status().isOk());
  }
}
