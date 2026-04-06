package ge.careo.backend.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "cars")
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "make", nullable = false)
  private String make;

  @Column(name = "model", nullable = false)
  private String model;

  @Column(name = "generation", nullable = false)
  private String generation;

  @Column(name = "production_year", nullable = false, columnDefinition = "SMALLINT")
  private short productionYear;

  @Column(name = "body_type", nullable = true)
  private String bodyType;

  @Column(name = "engine_type", nullable = true)
  private String engineType;

  @Column(name = "cubic_capacity", nullable = true)
  private Integer cubicCapacity;

  @Column(name = "power", nullable = true)
  private Integer power;

  @Column(name = "transmission", nullable = true)
  private String transmission;

  @Column(name = "drive", nullable = true)
  private String drive;

  @Column(name = "cylinder_count", nullable = true)
  private Integer cylinderCount;

  @Column(name = "seat_count", nullable = true)
  private Integer seatCount;

  @Column(name = "door_count", nullable = true)
  private Integer doorCount;

  @Column(name = "weight", nullable = true)
  private Integer weight;

  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = Instant.now();
    updatedAt = Instant.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = Instant.now();
  }

  public Car() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getGeneration() {
    return generation;
  }

  public void setGeneration(String generation) {
    this.generation = generation;
  }

  public short getProductionYear() {
    return productionYear;
  }

  public void setProductionYear(short productionYear) {
    this.productionYear = productionYear;
  }

  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  public Integer getCubicCapacity() {
    return cubicCapacity;
  }

  public void setCubicCapacity(Integer cubicCapacity) {
    this.cubicCapacity = cubicCapacity;
  }

  public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public String getDrive() {
    return drive;
  }

  public void setDrive(String drive) {
    this.drive = drive;
  }

  public Integer getCylinderCount() {
    return cylinderCount;
  }

  public void setCylinderCount(Integer cylinderCount) {
    this.cylinderCount = cylinderCount;
  }

  public Integer getSeatCount() {
    return seatCount;
  }

  public void setSeatCount(Integer seatCount) {
    this.seatCount = seatCount;
  }

  public Integer getDoorCount() {
    return doorCount;
  }

  public void setDoorCount(Integer doorCount) {
    this.doorCount = doorCount;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }
}
