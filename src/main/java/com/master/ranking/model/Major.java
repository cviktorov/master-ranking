package com.master.ranking.model;

import java.util.UUID;

public class Major {

	private String id;
	private String name;
	private int quote;
	private int ratedCounter;

	public Major(String name, int quote) {
		this(UUID.randomUUID().toString(), name, quote, 0);
	}

	private Major(String id, String name, int quote, int ratedCounter) {
		this.id = id;
		this.name = name;
		this.quote = quote;
		this.ratedCounter = ratedCounter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuote() {
		return quote;
	}

	public void setQuote(int quote) {
		this.quote = quote;
	}

	public int getRatedCounter() {
		return ratedCounter;
	}

	public void setRatedCounter(int ratedCounter) {
		this.ratedCounter = ratedCounter;
	}

	@Override
	public String toString() {
		return name;
	}

	
}
