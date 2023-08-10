package com.ondc.integration.configuration;


import static java.util.concurrent.Executors.newScheduledThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ondc.integration.utils.Utils.runAsDaemon;
import com.ondc.integration.model.opswat.PendingOpSwatScan;
import com.ondc.integration.service.DocScanCheckScheduler;

@Configuration
public class DocumentScanConfiguration {
    public static final String PENDING_OPSWAT_SCAN_QUEUE = "pending-opswat-scan-queue";

    @Bean(PENDING_OPSWAT_SCAN_QUEUE)
    public BlockingQueue<PendingOpSwatScan> pendingScanQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public Thread docScanCheckSchedulerThread(DocScanCheckScheduler docScanCheckScheduler) {
        return runAsDaemon("doc-scan-check-scheduler", docScanCheckScheduler);
    }

    @Bean
    public ScheduledExecutorService localOneTimeScheduler(
            @Value("${ondcIntegration.checkThreads}") int threads) {
        return newScheduledThreadPool(threads);
    }
}
