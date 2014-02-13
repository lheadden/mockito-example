package com.aetherworks.examples.mockito.recordimporter;

import java.util.Objects;

public class Record {

	private final int id;

	public Record(final int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Record) {
			final Record o = (Record) obj;
			return Objects.equals(id, o.id);
		} else {
			return false;
		}
	}
	
}
