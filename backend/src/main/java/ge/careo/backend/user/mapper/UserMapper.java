package ge.careo.backend.user.mapper;

import ge.careo.backend.user.dto.request.CreateUserRequest;
import ge.careo.backend.user.dto.response.UserResponse;
import ge.careo.backend.user.entity.User;

public class UserMapper {
  public static User toEntity(CreateUserRequest request) {
    User user = new User();
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());

    return user;
  }

  public static UserResponse toResponse(User user) {
    return new UserResponse(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getUsername(),
        user.getEmail(),
        user.getEmailVerified(),
        user.getOauthProvider(),
        user.getOauthId(),
        user.getCreatedAt(),
        user.getUpdatedAt());
  }
}
