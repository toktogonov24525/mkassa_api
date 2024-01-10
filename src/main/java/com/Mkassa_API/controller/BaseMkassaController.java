package com.Mkassa_API.controller;


import com.Mkassa_API.providers.ConfigReader;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class BaseMkassaController {


    private final MkassaController mkassaController;


    public BaseMkassaController (){
        this.mkassaController = new MkassaController(ConfigReader.getProperty("url"));
    }


}
