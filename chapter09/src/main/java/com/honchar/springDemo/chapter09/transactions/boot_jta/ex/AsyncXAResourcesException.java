package com.honchar.springDemo.chapter09.transactions.boot_jta.ex;

public class AsyncXAResourcesException extends RuntimeException {
	public AsyncXAResourcesException(String message) {
		super(message);
	}
}
