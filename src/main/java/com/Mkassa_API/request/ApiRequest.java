package com.Mkassa_API.request;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static org.apache.cassandra.db.ReadVerbHandler.getResponse;

@Slf4j
@Data
public class ApiRequest {

    protected String url;
    protected Map<String, String > headers;
    public Response response;
    protected RequestSpecification specification;

    public ApiRequest(String url, Map<String, String> headers){
        this.headers = headers;
        this.url = url;
        PreemptiveOAuth2HeaderScheme authScheme = new PreemptiveOAuth2HeaderScheme();
        authScheme.setAccessToken("");
        specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAuth(authScheme)
                .setBaseUri(this.url)
                .setAccept(ContentType.JSON)
                .addHeaders(this.headers)
                //.addFilter(new AllureRestAssured())
                .build();
        specification.log();
    }


    public static final String SLASH = "/";
    public static String DEFAULT_ENDPOINTS = "";


    public static String getEndPoint (String... args){
        StringBuilder endPoint = new StringBuilder();
        for (String arg : args){
            endPoint.append(arg).append(SLASH);
        }
        return endPoint.substring(0,endPoint.length() -1);
    }

    public static String formatParameters(HashMap<String, String> parameters) {
        if (parameters.isEmpty()) {
            return "";
        }
        StringBuilder query = new StringBuilder("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            query.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return query.deleteCharAt(query.length() - 1).toString();
    }

    public ApiRequest logResponse(){
        log.info("Response is:");
        log.warn(getResponse().getBody().asString());
        log.warn(String.valueOf(getResponse().getStatusCode()));
        return this;
    }

    public Response get(String endPoint){
        log.info("Perform Get Request: {}", endPoint);
        this.response = RestAssured.given()
                .spec(specification)
                .get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body){
        log.info("Perform Post Request: {}", endPoint);
        log.info("Body is: {}", body);
        this.response = RestAssured.given()
                .spec(specification)
                .body(body).log().all()
                .post(endPoint);
        logResponse();
        return this.response;
    }

    public Response put(String endPoint, String body){
        log.info("Perform Put Request: {}", endPoint);
        log.info("Body is: {}",body);
        this.response = RestAssured.given()
                .spec(specification)
                .body(body).log().all()
                .put(endPoint);
        logResponse();
        return this.response;
    }

    public Response patch (String endPoint, String body){
        log.info("Perform Patch Request: {}", endPoint);
        log.info("Body is: {}", body);
        this.response = RestAssured.given()
                .spec(specification)
                .body(body).log().all()
                .patch(endPoint);
        logResponse();
        return this.response;
    }


    public Response delete(String endPoint){
        log.info("Perform Delete Request: {}",endPoint);
        this.response = RestAssured.given()
                .spec(specification)
                .delete(endPoint);
        logResponse();
        return this.response;
    }

    public Response delete(String endPoint, String body){
        log.info("Perform Delete Request: {}", endPoint);
        log.info("Body is: {}", body);
        this.response = RestAssured.given()
                .spec(specification)
                .body(body).log().all()
                .delete(endPoint);
        logResponse();
        return this.response;
    }
}
