package ge.careo.backend.car.dto.request;

public class CreateCarRequest {
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
}
