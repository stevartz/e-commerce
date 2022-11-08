package com.upsidle.web.rest.v1;

import com.upsidle.backend.persistent.domain.user.User;
import com.upsidle.backend.service.mail.EmailService;
import com.upsidle.backend.service.security.JwtService;
import com.upsidle.backend.service.user.UserService;
import com.upsidle.constant.AdminConstants;
import com.upsidle.shared.util.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class UserRestApiTest {

  @Mock private transient UserService userService;

  @Mock private transient MockMvc mockMvc;

  @Mock private transient EmailService emailService;

  @Mock private transient JwtService jwtService;

  @InjectMocks private UserRestApi userRestApi;

  private transient String emailValidationUri;

  private User user;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(userRestApi).build();

    emailValidationUri = String.join("/", AdminConstants.API_V1_USERS_ROOT_URL, "/token/validate");

    user = UserUtils.createUser();
  }

  @Test
  void testEmailLinkValidationReturnsBAD_REQUESTResponse() throws Exception {
    Mockito.when(jwtService.isValidJwtToken(Mockito.anyString())).thenReturn(false);
    mockMvc
        .perform(MockMvcRequestBuilders.get(emailValidationUri))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  void testEmailLinkValidationReturnsOKResponse() throws Exception {
    Mockito.when(jwtService.isValidJwtToken(Mockito.anyString())).thenReturn(true);
    Mockito.when(jwtService.getUsernameFromToken(Mockito.anyString()))
        .thenReturn(user.getUsername());
    Mockito.when(userService.findByUsername(Mockito.anyString()))
        .thenReturn(UserUtils.convertToUserDto(user));
    mockMvc
        .perform(MockMvcRequestBuilders.get(emailValidationUri))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
