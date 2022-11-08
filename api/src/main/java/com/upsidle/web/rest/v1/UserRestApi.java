package com.upsidle.web.rest.v1;

import com.upsidle.annotation.Loggable;
import com.upsidle.backend.service.mail.EmailService;
import com.upsidle.backend.service.security.JwtService;
import com.upsidle.backend.service.user.UserService;
import com.upsidle.constant.AdminConstants;
import com.upsidle.constant.SecurityConstants;
import com.upsidle.enums.OperationStatus;
import com.upsidle.shared.dto.UserDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class handles all rest calls for users.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AdminConstants.API_V1_USERS_ROOT_URL)
public class UserRestApi {

  private final UserService userService;
  private final EmailService emailService;
  private final JwtService jwtService;

  /**
   * Enables the user associated with the publicId.
   *
   * @param publicId the publicId
   * @return if the operation is success
   */
  @PutMapping(value = "/{publicId}/enable", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OperationStatus> enableUser(@PathVariable String publicId) {
    var userDto = userService.enableUser(publicId);

    return ResponseEntity.ok(
        Objects.isNull(userDto) ? OperationStatus.FAILURE : OperationStatus.SUCCESS);
  }

  /**
   * Disables the user associated with the publicId.
   *
   * @param publicId the publicId
   * @return if the operation is success
   */
  @PutMapping(value = "/{publicId}/disable", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OperationStatus> disableUser(@PathVariable String publicId) {
    var userDto = userService.disableUser(publicId);

    return ResponseEntity.ok(
        Objects.isNull(userDto) ? OperationStatus.FAILURE : OperationStatus.SUCCESS);
  }

  /**
   * Deletes the user associated with the publicId.
   *
   * @param publicId the publicId
   * @return if the operation is success
   */
  @DeleteMapping(value = "/{publicId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OperationStatus> deleteUser(@PathVariable String publicId) {
    userService.deleteUser(publicId);

    return ResponseEntity.ok(OperationStatus.SUCCESS);
  }

  /**
   * Validate user when user clicks on email link.
   *
   * @param token The validation token.
   * @return response entity
   */
  @Loggable
  @SecurityRequirements
  @GetMapping(value = SecurityConstants.EMAIL_VALIDATION)
  public ResponseEntity<String> emailValidation(@PathVariable String token) {
    if (jwtService.isValidJwtToken(token)) {
      var username = jwtService.getUsernameFromToken(token);
      UserDto userDto = userService.findByUsername(username);
      userService.enableUser(userDto.getPublicId());
      emailService.sendAccountConfirmationEmail(userDto);
      return new ResponseEntity<>("User validated successfully!", HttpStatus.OK);
    }
    return new ResponseEntity<>("There was an issue validating the user", HttpStatus.BAD_REQUEST);
  }
}
