package domain;

import java.util.Objects;

class Amount implements Comparable<Amount> {
	
	private double amount;
	
	public Amount() {}

	public Amount(double amount) {
		this.amount = amount;
	}
	
	public Amount plus(Amount other) {
		
		return newAmount(this.amount + other.amount);
	}

	public Amount subtract(Amount other) {
		
		return newAmount(this.amount - other.amount);
	}
	
	public double doubleValue() {
		return this.amount;
	}
	
	private Amount newAmount(double amount) {
		Amount newAmount = new Amount();
		newAmount.amount = amount;
		return newAmount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(other instanceof Amount) {
			Amount that = (Amount)other;
			return this.amount == that.amount;
		}
		return false;
	}
	
	@Override
	public int compareTo(Amount other) {
		
		if(this.amount < other.amount) {
			return -1;
		} else if(this.amount == other.amount) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.amount);
	}
}
