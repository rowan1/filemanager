package com.stcassessment.filemanager.exception;

public class UserNotAuthorizedException extends RuntimeException {
  public UserNotAuthorizedException(String msg) {
    super(msg);
  }
}