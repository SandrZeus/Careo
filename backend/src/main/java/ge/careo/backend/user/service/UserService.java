package ge.careo.backend.user.service;

import ge.careo.backend.user.dto.request.CreateUserRequest;
import ge.careo.backend.user.dto.request.UpdateUserRequest;
import ge.careo.backend.user.entity.User;
import ge.careo.backend.user.mapper.UserMapper;
import ge.careo.backend.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(UUID id) {
    return userRepository.findById(id);
  }

  public User createUser(CreateUserRequest request) {
    User user = UserMapper.toEntity(request);
    return userRepository.save(user);
  }

  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }

  public User updateUser(UUID id, UpdateUserRequest updatedUser) {
    User existingUser = getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setFirstName(updatedUser.getFirstName());
    existingUser.setLastName(updatedUser.getLastName());
    existingUser.setUsername(updatedUser.getUsername());
    existingUser.setPassword(updatedUser.getPassword());

    return userRepository.save(existingUser);
  }
}
