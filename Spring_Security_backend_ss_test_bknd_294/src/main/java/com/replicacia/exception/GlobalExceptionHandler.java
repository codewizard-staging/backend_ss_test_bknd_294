package com.replicacia.exception;

import com.replicacia.rest.security.dto.UserNotVerifiedResponseDTO;
import com.replicacia.web.ApiError;
import com.replicacia.web.ResponseEntityBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      final HttpMediaTypeNotSupportedException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {

    final List<String> details = new ArrayList<String>();

    final StringBuilder builder = new StringBuilder();
    builder.append(ex.getContentType());
    builder.append(" media type is not supported. Supported media types are ");
    ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

    details.add(builder.toString());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Invalid JSON", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleHttpMessageNotReadable : triggers when the JSON is malformed
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      final HttpMessageNotReadableException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getMessage());

    final ApiError err =
        new ApiError(
            LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Malformed JSON request", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleMethodArgumentNotValid : triggers when @Valid fails
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      final MethodArgumentNotValidException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {

    List<String> details = new ArrayList<String>();
    details =
        ex.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getObjectName() + " : " + error.getDefaultMessage())
            .collect(Collectors.toList());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation Errors", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleMissingServletRequestParameter : triggers when there are missing parameters
  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      final MissingServletRequestParameterException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getParameterName() + " parameter is missing");

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Missing Parameters", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleMethodArgumentTypeMismatch : triggers when a parameter's type does not match
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(
      final MethodArgumentTypeMismatchException ex, final WebRequest request) {
    final List<String> details = new ArrayList<String>();
    details.add(ex.getMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Mismatch Type", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleConstraintViolationException : triggers when @Validated fails
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> handleConstraintViolationException(
      final Exception ex, final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Constraint Violation", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleResourceNotFoundException : triggers when there is not resource with the specified ID in
  // DB
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(
      final ResourceNotFoundException ex) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Resource Not Found", details);

    return ResponseEntityBuilder.build(err);
  }

  @ExceptionHandler(ResourceExistsException.class)
  public ResponseEntity<Object> handleResourceExistsException(final ResourceExistsException ex) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.CONFLICT, "Resource Exists", details);

    return ResponseEntityBuilder.build(err);
  }

  // handleNoHandlerFoundException : triggers when the handler method is invalid
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
      final NoHandlerFoundException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(
        String.format(
            "Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Method Not Found", details);

    return ResponseEntityBuilder.build(err);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getLocalizedMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Error occurred", details);

    return ResponseEntityBuilder.build(err);
  }

  @ExceptionHandler({BadRequestException.class})
  public ResponseEntity<Object> badRequestException(final Exception ex, final WebRequest request) {

    final List<String> details = new ArrayList<String>();
    details.add(ex.getLocalizedMessage());

    final ApiError err =
        new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Error occurred", details);

    return ResponseEntityBuilder.build(err);
  }

  @ExceptionHandler({UserNotVerifiedException.class})
  public ResponseEntity<Object> userNotVerifiedException(
      final UserNotVerifiedException ex, final WebRequest request) {

    final UserNotVerifiedResponseDTO responseDTO =
        UserNotVerifiedResponseDTO.builder()
            .userId(ex.getUserId())
            .reasons(ex.getReasons())
            .build();

    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseDTO);
  }
}
