package ge.careo.backend.user.dto.response;

import java.time.Instant;
import java.util.UUID;

public class UserResponse {
  private UUID id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private Boolean emailVerified;
  private String oauthProvider;
  private String oauthId;
  private Instant createdAt;
  private Instant updatedAt;

  public UserResponse(
      UUID id,
      String firstName,
      String lastName,
      String username,
      String email,
      Boolean emailVerified,
      String oauthProvider,
      String oauthId,
      Instant createdAt,
      Instant updatedAt) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.emailVerified = emailVerified;
    this.oauthProvider = oauthProvider;
    this.oauthId = oauthId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getEmailVerified() {
    return emailVerified;
  }

  public String getOauthProvider() {
    return oauthProvider;
  }

  public String getOauthId() {
    return oauthId;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }
}
