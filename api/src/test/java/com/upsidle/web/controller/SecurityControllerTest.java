package com.upsidle.web.controller;

import com.upsidle.TestUtils;
import com.upsidle.constant.HomeConstants;
import com.upsidle.constant.SecurityConstants;
import com.upsidle.constant.user.UserConstants;
import com.upsidle.shared.util.core.SecurityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SecurityControllerTest {

  private transient MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(SecurityController.class).build();

    SecurityUtils.clearAuthentication();
  }

  @Test
  void testLoginPathAndViewNameNotAuthenticated() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get(SecurityConstants.LOGIN))
        .andExpect(MockMvcResultMatchers.view().name(SecurityConstants.LOGIN_VIEW_NAME))
        .andExpect(MockMvcResultMatchers.model().attributeExists(UserConstants.USER_MODEL_KEY))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void testLoginPathAndViewNameAuthenticated(TestInfo testInfo) throws Exception {
    TestUtils.setAuthentication(testInfo.getDisplayName(), TestUtils.ROLE_USER);

    // When the user is authenticated, the login page should redirect to the home page
    // No model attributes is set
    mockMvc
        .perform(MockMvcRequestBuilders.get(SecurityConstants.LOGIN))
        .andExpect(MockMvcResultMatchers.redirectedUrl(HomeConstants.INDEX_URL_MAPPING))
        .andExpect(
            MockMvcResultMatchers.model().attributeDoesNotExist(UserConstants.USER_MODEL_KEY))
        .andExpect(MockMvcResultMatchers.status().isFound());
  }
}
