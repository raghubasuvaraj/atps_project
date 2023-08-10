package com.ondc.integration.service;

import org.springframework.stereotype.Service;

import com.ondc.integration.model.DocumentScanId;
import com.ondc.integration.model.DocumentScanRow;
import com.ondc.integration.model.MalwareScanStatus;
import com.ondc.integration.model.OpSwatScanStatus;


@Service
public class DocumentScanRepository {
    private static final String INSERT_SQL = "insert into dbo.DOCUMENT_SCAN "
            + "(DOCUMENT_NAME, VENDOR_SCAN_ID, DOCUMENT_HASH, "
            + "SCAN_STATUS, IS_INFECTED, REQUEST_SOURCE_NAME, "
            + "PORTAL_USER_ID) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String COMPLETE_SQL = "update dbo.DOCUMENT_SCAN "
            + "set SCAN_STATUS = ?, IS_INFECTED = ? "
            + "where DOCUMENT_SCAN_KEY = ?";

    private static final String FIND_ROW_BY_PK_SQL = "select "
            + " DOCUMENT_NAME, VENDOR_SCAN_ID, SCAN_STATUS,"
            + " IS_INFECTED, DOCUMENT_HASH, PORTAL_USER_ID"
            + " from dbo.DOCUMENT_SCAN where DOCUMENT_SCAN_KEY = ?";


    public DocumentScanId create(DocumentScanRow row) {
            return DocumentScanId.valueOf(1234);
                   
    }

    public void scanCompleted(
            MalwareScanStatus scanStatus,
            DocumentScanId scanId,
            OpSwatScanStatus status) {
    	System.out.printf("scanCompleted");
    }

}
