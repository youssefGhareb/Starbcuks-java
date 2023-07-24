package com.starbucks;

import java.time.LocalDate;

public class Drink extends Product {
	private boolean lactoseFree;
	private LocalDate from;
	private LocalDate to;

	public Drink(int id, String title, double price, boolean lactoseFree, LocalDate from, LocalDate to) {
		super(id, title, price);
		this.lactoseFree = lactoseFree;
		this.setFrom(from);
		this.setTo(to);
	}

	public boolean isLactoseFree() {
		return lactoseFree;
	}

	public void setLactoseFree(boolean lactoseFree) {
		this.lactoseFree = lactoseFree;
	}

	@Override
	public String toString() {
		return "Drink [lactoseFree=" + lactoseFree + ", " + super.toString() + "]";
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

}
