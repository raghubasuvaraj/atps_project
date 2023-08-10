package com.ondc.integration.service;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerService {
    @Autowired
    private ScheduledExecutorService scheduler;

    public void timeout(Duration delay, Runnable callback) {
        scheduler.schedule(callback, delay.toMillis(), MILLISECONDS);
    }
}
