package com.metaarch.testservice;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class TestController {
  private final String messagePrefix;

  public TestController(@Value("${test-service.message-prefix:Hello }") String messagePrefix) {
    this.messagePrefix = messagePrefix;
  }

  @GetMapping("/api/test")
  public String test(@RequestParam @NotBlank String name) {
    return messagePrefix + name;
  }
}
