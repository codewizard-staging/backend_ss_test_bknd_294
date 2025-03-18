package com.app.ss_test_bknd.Exception;

public class InvalidTokenException extends RuntimeException{
  public InvalidTokenException(String message){
    super(message);
  }
}
