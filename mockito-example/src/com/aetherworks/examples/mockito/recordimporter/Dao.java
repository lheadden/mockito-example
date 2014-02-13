package com.aetherworks.examples.mockito.recordimporter;

public interface Dao {

	boolean put(final Record record) throws Exception;

	int count() throws InterruptedException;
	
}
