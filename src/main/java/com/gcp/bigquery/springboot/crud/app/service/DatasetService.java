package com.gcp.bigquery.springboot.crud.app.service;

import com.gcp.bigquery.springboot.crud.app.common.Document;
import com.gcp.bigquery.springboot.crud.app.dto.DatasetDto;

@SuppressWarnings("rawtypes")
public interface DatasetService{

	Document createDataset(DatasetDto dto);
    
}