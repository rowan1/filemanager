package com.stcassessment.filemanager.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.stcassessment.filemanager.dto.common.apierror.ApiError;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;

import java.time.LocalDateTime;

/**
 * ApiResponse that has enough fields to hold relevant information about rest api response calls.
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ApiResponse<T> {

  @JsonIgnore private static final String RESPONSE_REQUEST_ID_KEY = "requestId";

  /** status holds status code of the response. */
  private int status;

  /** timestamp holds the date-time instance of when the response happened. */
  private LocalDateTime timestamp;

  /** data holds the response object. */
  private T data;

  /** error holds the api error response if error happened. */
  private ApiError error;

  public ApiResponse(int status) {
    this.status = status;
  }

  public ApiResponse(int status, T data) {
    this.status = status;
    this.data = data;
  }

  public ApiResponse(int status, ApiError error) {
    this.status = status;
    this.error = error;
  }

  public LocalDateTime getTimestamp() {
    return LocalDateTime.now();
  }

  public String getRequestId() {
    return MDC.get(RESPONSE_REQUEST_ID_KEY);
  }
}
