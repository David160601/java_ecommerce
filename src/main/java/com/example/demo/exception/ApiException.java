package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiException {
    private final String message;
    private final HttpStatusCode code;
    private final ZonedDateTime zonedDateTime;
}
