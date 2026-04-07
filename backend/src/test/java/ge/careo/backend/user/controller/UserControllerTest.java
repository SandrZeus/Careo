package ge.careo.backend.user.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ge.careo.backend.user.dto.request.CreateUserRequest;
import ge.careo.backend.user.dto.request.UpdateUserRequest;
import ge.careo.backend.user.entity.User;
import ge.careo.backend.user.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockitoBean private UserService userService;

  @Test
  void getAllUsers_returns200() throws Exception {
    when(userService.getAllUsers()).thenReturn(List.of());

    mockMvc.perform(get("/api/users")).andExpect(status().isOk());
  }

  @Test
  void getUserById_returns200() throws Exception {
    UUID id = UUID.randomUUID();
    User user = new User();
    user.setUsername("SandrZeus");
    user.setEmail("test@careo.ge");

    when(userService.getUserById(id)).thenReturn(Optional.of(user));

    mockMvc.perform(get("/api/users/{id}", id)).andExpect(status().isOk());
  }

  @Test
  void getUserById_returns500WhenNotFound() throws Exception {
    UUID id = UUID.randomUUID();

    when(userService.getUserById(id)).thenReturn(Optional.empty());

    mockMvc.perform(get("/api/users/{id}", id)).andExpect(status().isNotFound());
  }

  @Test
  void createUser_returns200() throws Exception {
    User user = new User();
    user.setUsername("SandrZeus");
    user.setEmail("test@careo.ge");

    when(userService.createUser(any(CreateUserRequest.class))).thenReturn(user);

    mockMvc
        .perform(
            post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"SandrZeus\",\"email\":\"test@careo.ge\"}"))
        .andExpect(status().isCreated());
  }

  @Test
  void deleteUser_returns204() throws Exception {
    UUID id = UUID.randomUUID();

    mockMvc.perform(delete("/api/users/{id}", id)).andExpect(status().isNoContent());
  }

  @Test
  void updateUser_returns200() throws Exception {
    UUID id = UUID.randomUUID();
    User updatedUser = new User();
    updatedUser.setUsername("SandrZeus");
    updatedUser.setEmail("test@careo.ge");
    updatedUser.setFirstName("Sandro");

    when(userService.updateUser(any(UUID.class), any(UpdateUserRequest.class)))
        .thenReturn(updatedUser);

    mockMvc
        .perform(
            put("/api/users/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"username\":\"SandrZeus\",\"email\":\"test@careo.ge\",\"firstName\":\"Sandro\"}"))
        .andExpect(status().isOk());
  }

  @Test
  void updateUser_returns500WhenNotFound() throws Exception {
    UUID id = UUID.randomUUID();

    when(userService.updateUser(any(UUID.class), any(UpdateUserRequest.class)))
        .thenThrow(new RuntimeException("User not found"));

    mockMvc
        .perform(
            put("/api/users/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"SandrZeus\"}"))
        .andExpect(status().isNotFound());
  }
}
