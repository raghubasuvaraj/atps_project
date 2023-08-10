package com.ondc.integration.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.nio.file.Files.readAllLines;

@Slf4j
public class Utils {
	private Utils() {}

	public static <T> CompletableFuture<T> future() {
		return new CompletableFuture<>();
	}

	public static Thread runAsDaemon(String name, Runnable runnable) {
    	final Thread thread = new Thread(runnable);
    	thread.setName(name);
    	thread.setDaemon(true);
		log.info("Starting daemon [{}]", name);
    	thread.start();
    	return thread;
	}

    @SneakyThrows
    public static List<String> readPasswordsFromFile() {
		return readAllLines(Paths.get("src/test/resources/passwords.txt"));
	}
}