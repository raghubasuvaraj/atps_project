package com.ondc.integration.service;


import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import static com.ondc.integration.configuration.DocumentScanConfiguration.PENDING_OPSWAT_SCAN_QUEUE;
import com.ondc.integration.model.opswat.PendingOpSwatScan;
import static com.google.common.collect.Iterables.cycle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocScanCheckScheduler implements Runnable {
    @Autowired
    @Qualifier(PENDING_OPSWAT_SCAN_QUEUE)
    private BlockingQueue<PendingOpSwatScan> pendingQueue;

    @Autowired
    private DocScanChecker docScanChecker;

    @Override
    public void run() {
        log.info("document scan check scheduler started");
        try {
            for (long timeout : cycle(10L)) {
                scheduleRightAway(pendingQueue.poll(timeout, SECONDS));
            }
        } catch (InterruptedException e) {
            log.error("document scan check scheduler has been interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            log.info("document scan check scheduler ended");
        }
    }

    private void scheduleRightAway(PendingOpSwatScan scan) {
        if (scan == null) {
            return;
        }
        log.debug("schedule scan {} right away", scan.getContentHash());
        docScanChecker.check(scan);
    }
}
