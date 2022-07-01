package com.upsidle.web.rest.v1;

import com.upsidle.annotation.Loggable;
import com.upsidle.backend.service.mail.EmailService;
import com.upsidle.backend.service.security.EncryptionService;
import com.upsidle.backend.service.security.JwtService;
import com.upsidle.backend.service.user.UserService;
import com.upsidle.constant.AdminConstants;
import com.upsidle.constant.user.UserConstants;
import com.upsidle.enums.OperationStatus;
import com.upsidle.exception.user.UserAlreadyExistsException;
import com.upsidle.shared.dto.UserDto;
import com.upsidle.shared.util.UserUtils;
import com.upsidle.web.payload.request.SignUpRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

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
  private final JwtService jwtService;
  private final EncryptionService encryptionService;
  private final EmailService emailService;

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

  @Loggable
  @PostMapping
  @SecurityRequirements
  public ResponseEntity<OperationStatus> register(@RequestBody @Valid SignUpRequest signUpRequest) {

    // convert sign to userDto
    UserDto userDto = UserUtils.convertToUserDto(signUpRequest);

    // check user exist by username or email.
    if (userService.existsByUsernameOrEmailAndEnabled(userDto.getUsername(), userDto.getEmail())) {
      LOG.warn(UserConstants.USERNAME_OR_EMAIL_EXITS);
      throw new UserAlreadyExistsException(UserConstants.USERNAME_OR_EMAIL_EXITS);
    }

    // Generate JWT token for the user using the username
    // assign the new jwt token to the user as the userVerificationToken
    String userVerificationToken = jwtService.generateJwtToken(userDto.getUsername());

    // now create the user using the user service and pass the user, user.getRoles()
    UserDto newUser = userService.createUser(userDto);

    // check if the returned user is null, then you throw exception
    // otherwise, encrypt the jwt token (there is an EncryptionService)
    if (newUser == null) {
      LOG.warn(UserConstants.USERNAME_OR_EMAIL_EXITS);
      throw new UserAlreadyExistsException(UserConstants.USERNAME_OR_EMAIL_EXITS);
    }
    String encrypttoken = encryptionService.encrypt(userVerificationToken);

    // encode the encrypted token (we do not want to send the raw jwt token out)
    String encodedtoken = encryptionService.encode(encrypttoken);

    // send email (sendAccountVerificationToken) using the user and encoded token)
    emailService.sendAccountVerificationEmail(newUser, encodedtoken);

    // look into how to create a location from the current request and expand the id of the user
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{publicId}")
            .buildAndExpand(newUser.getPublicId())
            .toUri();

    // update the return below to use the location instead of null.
    return ResponseEntity.created(location).body(OperationStatus.SUCCESS);
  }
}
