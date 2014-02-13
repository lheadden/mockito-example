package com.aetherworks.examples.mockito.recordimporter;

import java.util.Random;

public class MysqlDao implements Dao {

	private static int count;

	@Override
	public boolean put(Record record) throws InterruptedException {
		Thread.sleep(3000);
		count++;
		return new Random().nextBoolean();
	}
	
	public int count() throws InterruptedException {
		Thread.sleep(1000);
		if(new Random().nextDouble() < 0.2) {
			throw new RuntimeException("Failed to connect to database.");
		} else {
			return count;
		}
	}

}
