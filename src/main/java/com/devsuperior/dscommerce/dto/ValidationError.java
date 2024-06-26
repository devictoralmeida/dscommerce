package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
  private List<FieldMessage> errors = new ArrayList<>();

  public ValidationError(Instant timestamp, Integer status, String error, String path) {
    super(timestamp, status, error, path);
  }

  public List<FieldMessage> getErrors() {
    return this.errors;
  }

  public void addError(String fieldName, String message) {
    // Evitar mensagens duplicadas
    this.errors.removeIf(error -> error.getFieldName().equals(fieldName));
    this.errors.add(new FieldMessage(fieldName, message));
  }
}
