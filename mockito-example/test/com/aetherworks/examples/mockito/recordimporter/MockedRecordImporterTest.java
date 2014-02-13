package com.aetherworks.examples.mockito.recordimporter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class MockedRecordImporterTest {

	@Mock
	private Dao dao;
	
	private RecordImporter recordImporter;

	@Before
	public void setUp() throws Exception {
		recordImporter = new RecordImporter(dao);
	}

	@Test
	public void testNoRecords() throws Exception {
		int successes = recordImporter.importRecords(Collections.<Record>emptyList());

		verifyZeroInteractions(dao);
		assertThat(successes, is(0));
	}
	
	@Test
	public void testOneRecord() throws Exception {
		when(dao.put(new Record(1))).thenReturn(true);
		
		int successes = recordImporter.importRecords(Lists.newArrayList(new Record(1)));
		
		verify(dao).put(new Record(1));
		assertThat(successes, is(1));
	}
	
	@Test
	public void testManyRecords() throws Exception {
		when(dao.put(new Record(1))).thenReturn(true);
		when(dao.put(new Record(2))).thenReturn(false);
		when(dao.put(new Record(3))).thenReturn(true);
		
		int successes = recordImporter.importRecords(Lists.newArrayList(new Record(1), new Record(2), new Record(3)));
		
		verify(dao).put(new Record(1));
		verify(dao).put(new Record(2));
		verify(dao).put(new Record(3));
		assertThat(successes, is(2));
	}
	
}
