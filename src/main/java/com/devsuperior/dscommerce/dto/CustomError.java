package com.devsuperior.dscommerce.dto;

import java.time.Instant;

// Possui apenas getters e construtor com argumentos, já que não há setters.
public class CustomError {
  private Instant timestamp;
  private Integer status;
  private String error;
  private String path;

  public CustomError(Instant timestamp, Integer status, String error, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.path = path;
  }

  public Instant getTimestamp() {
    return this.timestamp;
  }

  public Integer getStatus() {
    return this.status;
  }

  public String getError() {
    return this.error;
  }

  public String getPath() {
    return this.path;
  }
}
