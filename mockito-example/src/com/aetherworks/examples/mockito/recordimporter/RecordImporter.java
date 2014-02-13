package com.aetherworks.examples.mockito.recordimporter;

import java.util.List;

public class RecordImporter {

	private final Dao dao;

	public RecordImporter(final Dao dao) {
		this.dao = dao;
	}
	
	public int importRecords(final List<Record> records) throws Exception {
		int successful = 0;
		for (Record record : records) {
			if(dao.put(record)) {
				successful++;
			}
		}
		return successful;
	}
	
}
