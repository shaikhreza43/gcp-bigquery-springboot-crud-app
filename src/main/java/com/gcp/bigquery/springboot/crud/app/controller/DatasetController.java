package com.gcp.bigquery.springboot.crud.app.controller;

import com.gcp.bigquery.springboot.crud.app.common.Document;
import com.gcp.bigquery.springboot.crud.app.dto.DatasetDto;
import com.gcp.bigquery.springboot.crud.app.service.DatasetService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gcp/bigquery")
@SuppressWarnings("rawtypes")
public class DatasetController {

    private DatasetService datasetService;

    @PostMapping("/create-dataset")
    public ResponseEntity<Document> createDataset(@RequestBody DatasetDto dto) {

        Document response = datasetService.createDataset(dto);

        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}