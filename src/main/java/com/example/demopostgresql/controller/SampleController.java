package com.example.demopostgresql.controller;

import com.example.demopostgresql.model.SampleModel;
import com.example.demopostgresql.service.SampleService;
import org.springframework.web.bind.annotation.*;

@RestController("/test")
public class SampleController {

    final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/input/get")
    public SampleModel testInputByGet() {
        return service.testInput(null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/input/post")
    public SampleModel testInputByPost(@RequestBody SampleModel model) {
        return service.testInput(model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public SampleModel testGetData(@RequestParam Long id) {
        return service.testGet(id);
    }
}
