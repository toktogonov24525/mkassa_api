package com.Mkassa_API.asserts;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import io.restassured.response.Response;


@Slf4j
public class ApiAsserts {

    private final Response response;

    public ApiAsserts(Response response){
        this.response = response;
    }

    public static ApiAsserts assertThatResponse(Response response){
        log.info("Start assert response...");
        return new ApiAsserts(response);
    }

    public ApiAsserts isCorrectHttpStatusCode(Integer expectedStatusCode){
        Assertions.assertThat(this.response.getStatusCode())
                .isEqualTo(expectedStatusCode)
                .withFailMessage("Response code is incorrect, Expected %s, but found %s",
                        expectedStatusCode, this.response.getStatusCode());
        log.info("Status code is correct: Actual {} Expected {}", this.response.getStatusCode(),expectedStatusCode);
        return this;
    }
}
