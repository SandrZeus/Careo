package ge.careo.backend.car.mapper;

import ge.careo.backend.car.dto.request.CreateCarRequest;
import ge.careo.backend.car.dto.response.CarResponse;
import ge.careo.backend.car.entity.Car;

public class CarMapper {
  public static Car toEntity(CreateCarRequest request) {
    Car car = new Car();
    car.setMake(request.getMake());
    car.setModel(request.getModel());
    car.setGeneration(request.getGeneration());
    car.setProductionYear(request.getProductionYear());
    car.setBodyType(request.getBodyType());
    car.setEngineType(request.getEngineType());
    car.setCubicCapacity(request.getCubicCapacity());
    car.setPower(request.getPower());
    car.setTransmission(request.getTransmission());
    car.setDrive(request.getDrive());
    car.setCylinderCount(request.getCylinderCount());
    car.setSeatCount(request.getSeatCount());
    car.setDoorCount(request.getDoorCount());
    car.setWeight(request.getWeight());

    return car;
  }

  public static CarResponse toResponse(Car car) {
    return new CarResponse(
        car.getId(),
        car.getMake(),
        car.getModel(),
        car.getGeneration(),
        car.getProductionYear(),
        car.getBodyType(),
        car.getEngineType(),
        car.getCubicCapacity(),
        car.getPower(),
        car.getTransmission(),
        car.getDrive(),
        car.getCylinderCount(),
        car.getSeatCount(),
        car.getDoorCount(),
        car.getWeight(),
        car.getCreatedAt(),
        car.getUpdatedAt());
  }
}
