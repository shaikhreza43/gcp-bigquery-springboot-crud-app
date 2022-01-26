package com.gcp.bigquery.springboot.crud.app.service;

import com.gcp.bigquery.springboot.crud.app.common.Document;
import com.gcp.bigquery.springboot.crud.app.dto.DatasetDto;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("rawtypes")
public class DatasetServiceImpl implements DatasetService {

    @Override
    public Document createDataset(DatasetDto dto) {

        Document doc = new Document();

        try {

            if (dto == null) {
                throw new NullPointerException("DataSet Details Cannot be Null");
            }

            // Initialize client that will be used to send requests. This client only needs
            // to be created
            // once, and can be reused for multiple requests.
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

            DatasetInfo datasetInfo = DatasetInfo.newBuilder(dto.getDatasetName()).build();

            Dataset newDataset = bigquery.create(datasetInfo);
            String newDatasetName = newDataset.getDatasetId().getDataset();
            System.out.println(newDatasetName + " created successfully");

            doc.setData(newDatasetName);
            doc.setMessage("DataSet Created Successfully");
            doc.setStatusCode(201);

        } catch (BigQueryException ex) {
            doc.setData(ex);
            doc.setMessage(ex.getMessage());
            doc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } catch (Exception ex) {
            doc.setData(null);
            doc.setMessage(ex.getLocalizedMessage());
            doc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return doc;
    }

}