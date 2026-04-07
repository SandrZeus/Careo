package ge.careo.backend.user.controller;

import ge.careo.backend.user.dto.request.CreateUserRequest;
import ge.careo.backend.user.dto.request.UpdateUserRequest;
import ge.careo.backend.user.dto.response.UserResponse;
import ge.careo.backend.user.entity.User;
import ge.careo.backend.user.mapper.UserMapper;
import ge.careo.backend.user.service.UserService;
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
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserResponse>> getAllUsers() {
    List<UserResponse> users =
        userService.getAllUsers().stream().map(UserMapper::toResponse).toList();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
    return userService
        .getUserById(id)
        .map(UserMapper::toResponse)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

  @PostMapping
  public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
    User saved = userService.createUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(saved));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponse> updateUser(
      @PathVariable UUID id, @RequestBody UpdateUserRequest request) {
    User updated = userService.updateUser(id, request);
    return ResponseEntity.ok(UserMapper.toResponse(updated));
  }
}
