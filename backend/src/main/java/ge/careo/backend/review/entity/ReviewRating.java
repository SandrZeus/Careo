package ge.careo.backend.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "review_ratings")
public class ReviewRating {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "review_id", nullable = false, unique = true)
  private UUID reviewId;

  @Column(name = "purchase_affordability", nullable = false, columnDefinition = "SMALLINT")
  private Integer purchaseAffordability;

  @Column(name = "fuel_economy", nullable = false, columnDefinition = "SMALLINT")
  private Integer fuelEconomy;

  @Column(name = "resale_value", nullable = false, columnDefinition = "SMALLINT")
  private Integer resaleValue;

  @Column(name = "maintenance_cost", nullable = false, columnDefinition = "SMALLINT")
  private Integer maintenanceCost;

  @Column(name = "acceleration", nullable = false, columnDefinition = "SMALLINT")
  private Integer acceleration;

  @Column(name = "handling", nullable = false, columnDefinition = "SMALLINT")
  private Integer handling;

  @Column(name = "ride_comfort", nullable = false, columnDefinition = "SMALLINT")
  private Integer rideComfort;

  @Column(name = "cargo_space", nullable = false, columnDefinition = "SMALLINT")
  private Integer cargoSpace;

  @Column(name = "passenger_room", nullable = false, columnDefinition = "SMALLINT")
  private Integer passengerRoom;

  @Column(name = "mechanical_reliability", nullable = false, columnDefinition = "SMALLINT")
  private Integer mechanicalReliability;

  @Column(name = "parts_availability", nullable = false, columnDefinition = "SMALLINT")
  private Integer partsAvailability;

  @Column(name = "infotainment_quality", nullable = false, columnDefinition = "SMALLINT")
  private Integer infotainmentQuality;

  @Column(name = "driver_assist", nullable = false, columnDefinition = "SMALLINT")
  private Integer driverAssist;

  public ReviewRating() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getReviewId() {
    return reviewId;
  }

  public void setReviewId(UUID reviewId) {
    this.reviewId = reviewId;
  }

  public Integer getPurchaseAffordability() {
    return purchaseAffordability;
  }

  public void setPurchaseAffordability(Integer purchaseAffordability) {
    this.purchaseAffordability = purchaseAffordability;
  }

  public Integer getFuelEconomy() {
    return fuelEconomy;
  }

  public void setFuelEconomy(Integer fuelEconomy) {
    this.fuelEconomy = fuelEconomy;
  }

  public Integer getResaleValue() {
    return resaleValue;
  }

  public void setResaleValue(Integer resaleValue) {
    this.resaleValue = resaleValue;
  }

  public Integer getMaintenanceCost() {
    return maintenanceCost;
  }

  public void setMaintenanceCost(Integer maintenanceCost) {
    this.maintenanceCost = maintenanceCost;
  }

  public Integer getAcceleration() {
    return acceleration;
  }

  public void setAcceleration(Integer acceleration) {
    this.acceleration = acceleration;
  }

  public Integer getHandling() {
    return handling;
  }

  public void setHandling(Integer handling) {
    this.handling = handling;
  }

  public Integer getRideComfort() {
    return rideComfort;
  }

  public void setRideComfort(Integer rideComfort) {
    this.rideComfort = rideComfort;
  }

  public Integer getCargoSpace() {
    return cargoSpace;
  }

  public void setCargoSpace(Integer cargoSpace) {
    this.cargoSpace = cargoSpace;
  }

  public Integer getPassengerRoom() {
    return passengerRoom;
  }

  public void setPassengerRoom(Integer passengerRoom) {
    this.passengerRoom = passengerRoom;
  }

  public Integer getMechanicalReliability() {
    return mechanicalReliability;
  }

  public void setMechanicalReliability(Integer mechanicalReliability) {
    this.mechanicalReliability = mechanicalReliability;
  }

  public Integer getPartsAvailability() {
    return partsAvailability;
  }

  public void setPartsAvailability(Integer partsAvailability) {
    this.partsAvailability = partsAvailability;
  }

  public Integer getInfotainmentQuality() {
    return infotainmentQuality;
  }

  public void setInfotainmentQuality(Integer infotainmentQuality) {
    this.infotainmentQuality = infotainmentQuality;
  }

  public Integer getDriverAssist() {
    return driverAssist;
  }

  public void setDriverAssist(Integer driverAssist) {
    this.driverAssist = driverAssist;
  }
}
