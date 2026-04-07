package ge.careo.backend.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ge.careo.backend.user.dto.request.CreateUserRequest;
import ge.careo.backend.user.dto.request.UpdateUserRequest;
import ge.careo.backend.user.entity.User;
import ge.careo.backend.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {
  @Mock private UserRepository userRepository;

  private UserService userService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    userService = new UserService(userRepository);
  }

  @Test
  void getAllUsers_returnsList() {
    User user = new User();
    user.setUsername("SandrZeus");
    user.setEmail("test@careo.ge");

    when(userRepository.findAll()).thenReturn(List.of(user));

    List<User> result = userService.getAllUsers();

    assertEquals(1, result.size());
    assertEquals("SandrZeus", result.get(0).getUsername());
  }

  @Test
  void getUserById_returnsUser() {
    UUID id = UUID.randomUUID();
    User user = new User();
    user.setUsername("SandrZeus");
    user.setEmail("test@careo.ge");

    when(userRepository.findById(id)).thenReturn(Optional.of(user));

    Optional<User> result = userService.getUserById(id);

    assertTrue(result.isPresent());
    assertEquals("SandrZeus", result.get().getUsername());
  }

  @Test
  void getUserById_returnsEmpty() {
    UUID id = UUID.randomUUID();

    when(userRepository.findById(id)).thenReturn(Optional.empty());

    Optional<User> result = userService.getUserById(id);

    assertTrue(result.isEmpty());
  }

  @Test
  void createUser_returnsUser() {
    CreateUserRequest request = new CreateUserRequest();
    request.setUsername("SandrZeus");
    request.setEmail("test@careo.ge");

    User savedUser = new User();
    savedUser.setUsername("SandrZeus");
    savedUser.setEmail("test@careo.ge");

    when(userRepository.save(any(User.class))).thenReturn(savedUser);

    User result = userService.createUser(request);

    assertEquals("SandrZeus", result.getUsername());
    assertEquals("test@careo.ge", result.getEmail());
  }

  @Test
  void deleteUser_returnsEmpty() {
    UUID id = UUID.randomUUID();

    userService.deleteUser(id);

    verify(userRepository).deleteById(id);
  }

  @Test
  void updateUser_returnsUser() {
    UUID id = UUID.randomUUID();
    User existingUser = new User();
    existingUser.setUsername("SandrZeus");
    existingUser.setEmail("test@careo.ge");

    UpdateUserRequest request = new UpdateUserRequest();
    request.setUsername("SandrZeus");
    request.setFirstName("Sandro");

    when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
    when(userRepository.save(existingUser)).thenReturn(existingUser);

    User result = userService.updateUser(id, request);

    assertEquals("SandrZeus", result.getUsername());
    assertEquals("Sandro", result.getFirstName());
  }

  @Test
  void updateUser_returnsEmpty() {
    UUID id = UUID.randomUUID();

    UpdateUserRequest request = new UpdateUserRequest();
    request.setUsername("SandrZeus");

    when(userRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> userService.updateUser(id, request));
  }
}
