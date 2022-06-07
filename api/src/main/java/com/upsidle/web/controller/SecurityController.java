package com.upsidle.web.controller;

import com.upsidle.constant.HomeConstants;
import com.upsidle.constant.SecurityConstants;
import com.upsidle.constant.user.UserConstants;
import com.upsidle.shared.util.core.SecurityUtils;
import com.upsidle.web.payload.request.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The controller for handling all security related mappings.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Controller
public class SecurityController {

  /**
   * The login mapping.
   *
   * @param model the model
   * @return the login page.
   */
  @GetMapping(path = SecurityConstants.LOGIN)
  public String login(Model model) {

    // if the user is authenticated, redirect to the account overview.
    if (SecurityUtils.isAuthenticated()) {
      return HomeConstants.REDIRECT_TO_INDEX;
    }
    model.addAttribute(UserConstants.USER_MODEL_KEY, new LoginRequest());

    return SecurityConstants.LOGIN_VIEW_NAME;
  }
}
