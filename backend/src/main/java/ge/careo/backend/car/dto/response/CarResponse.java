package ge.careo.backend.car.dto.response;

import java.time.Instant;
import java.util.UUID;

public class CarResponse {
  private UUID id;
  private String make;
  private String model;
  private String generation;
  private short productionYear;
  private String bodyType;
  private String engineType;
  private Integer cubicCapacity;
  private Integer power;
  private String transmission;
  private String drive;
  private Integer cylinderCount;
  private Integer seatCount;
  private Integer doorCount;
  private Integer weight;
  private Instant createdAt;
  private Instant updatedAt;

  public CarResponse(
      UUID id,
      String make,
      String model,
      String generation,
      short productionYear,
      String bodyType,
      String engineType,
      Integer cubicCapacity,
      Integer power,
      String transmission,
      String drive,
      Integer cylinderCount,
      Integer seatCount,
      Integer doorCount,
      Integer weight,
      Instant createdAt,
      Instant updatedAt) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.generation = generation;
    this.productionYear = productionYear;
    this.bodyType = bodyType;
    this.engineType = engineType;
    this.cubicCapacity = cubicCapacity;
    this.power = power;
    this.transmission = transmission;
    this.drive = drive;
    this.cylinderCount = cylinderCount;
    this.seatCount = seatCount;
    this.doorCount = doorCount;
    this.weight = weight;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UUID getId() {
    return id;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getGeneration() {
    return generation;
  }

  public short getProductionYear() {
    return productionYear;
  }

  public String getBodyType() {
    return bodyType;
  }

  public String getEngineType() {
    return engineType;
  }

  public Integer getCubicCapacity() {
    return cubicCapacity;
  }

  public Integer getPower() {
    return power;
  }

  public String getTransmission() {
    return transmission;
  }

  public String getDrive() {
    return drive;
  }

  public Integer getCylinderCount() {
    return cylinderCount;
  }

  public Integer getSeatCount() {
    return seatCount;
  }

  public Integer getDoorCount() {
    return doorCount;
  }

  public Integer getWeight() {
    return weight;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }
}
