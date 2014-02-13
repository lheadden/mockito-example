package com.aetherworks.examples.mockito.recordimporter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class RecordImporterTest {

	private Dao dao;
	private RecordImporter recordImporter;

	@Before
	public void setUp() throws Exception {
		dao = new MysqlDao();
		recordImporter = new RecordImporter(dao);
	}

	@Test
	public void testNoRecords() throws Exception {
		int successes = recordImporter.importRecords(Collections.<Record>emptyList());
		
		assertThat(dao.count(), is(0));
		assertThat(successes, is(0));
	}
	
	@Test
	public void testOneRecord() throws Exception {
		int successes = recordImporter.importRecords(Lists.newArrayList(new Record(1)));
		
		assertThat(dao.count(), is(1));
		assertThat(successes, is(1));
	}
	
	@Test
	public void testManyRecords() throws Exception {
		int successes = recordImporter.importRecords(Lists.newArrayList(new Record(1), new Record(2), new Record(3)));
		
		assertThat(dao.count(), is(3));
		assertThat(successes, is(3));
	}
	
}
