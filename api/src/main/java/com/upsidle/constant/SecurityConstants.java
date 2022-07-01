package com.upsidle.constant;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/**
 * This class holds all security-related URL mappings constants.
 *
 * @author George Anguah
 * @version 1.0
 * @since 1.0
 */
public final class SecurityConstants {

  public static final String API_V1_AUTH_ROOT_URL = "/api/v1/auth";
  public static final String API_V1_AUTH_URL_MAPPING = "/api/v1/auth/**";
  public static final String API_ROOT_URL_MAPPING = "/api/**";
  public static final String BEARER = "Bearer";
  public static final String X_XSRF_TOKEN = "x-xsrf-token";
  public static final String BEARER_PREFIX = "Bearer ";
  public static final String H2_CONSOLE_URL_MAPPING = "/console/*";
  public static final String LOGOUT = "/logout";
  public static final String LOGIN = "/login";
  public static final String REFRESH_TOKEN = "/refresh-token";
  public static final String ROOT_PATH = "/";
  public static final String SAME_SITE = "strict";
  public static final String LOGIN_VIEW_NAME = "user/login";
  public static final int DEFAULT_TOKEN_DURATION = 7;
  public static final int SECURITY_STRENGTH = 12;

  public static final List<String> ALLOWED_HTTP_METHODS =
      List.of(
          HttpMethod.GET.name(),
          HttpMethod.POST.name(),
          HttpMethod.PUT.name(),
          HttpMethod.DELETE.name(),
          HttpMethod.PATCH.name(),
          HttpMethod.OPTIONS.name());

  public static final List<String> ALLOWED_HTTP_HEADERS =
      List.of(
          HttpHeaders.AUTHORIZATION,
          HttpHeaders.CACHE_CONTROL,
          HttpHeaders.CONTENT_TYPE,
          X_XSRF_TOKEN,
          HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
          HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
          HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);

  public static final List<String> EXPOSED_HTTP_HEADERS =
      List.of(
          HttpHeaders.AUTHORIZATION,
          HttpHeaders.CACHE_CONTROL,
          HttpHeaders.CONTENT_TYPE,
          HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
          HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
          HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);

  private static final String[] PUBLIC_MATCHERS = {ROOT_PATH};

  public static Collection<String> getPublicMatchers() {
    return Collections.unmodifiableCollection(Arrays.asList(PUBLIC_MATCHERS));
  }

  private SecurityConstants() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
  }
}
