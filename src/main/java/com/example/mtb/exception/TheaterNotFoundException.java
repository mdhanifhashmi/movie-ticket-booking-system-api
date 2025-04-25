package com.example.mtb.exception;

public class TheaterNotFoundException extends RuntimeException {
  public TheaterNotFoundException(String message) {
    super(message);
  }
}
