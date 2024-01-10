package com.Mkassa_API.controller;


import com.Mkassa_API.request.ApiRequest;
import lombok.Getter;

import static com.Mkassa_API.mkassa.EndPoint.BASE_HEADERS;

@Getter
public class MkassaController extends ApiRequest {

    public MkassaController(String url){
        super(url,BASE_HEADERS);
    }
}
