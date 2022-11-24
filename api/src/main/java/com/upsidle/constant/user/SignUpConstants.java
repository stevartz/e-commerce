package com.upsidle.constant.user;

import com.upsidle.constant.ErrorConstants;

/**
 * This class holds all constants used in controller implementations.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class SignUpConstants {

  /** URL Mapping Constants. */
  public static final String SIGN_UP_MAPPING = "/api/v1/users/sign-up";

  public static final String SIGN_UP_VERIFY_MAPPING = "/verify/";

  private SignUpConstants() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
  }
}
