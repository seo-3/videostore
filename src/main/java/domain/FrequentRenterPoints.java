package domain;

import java.util.Objects;

class FrequentRenterPoints {
	
	private int frequentRenterPoints;
	
	public FrequentRenterPoints() {}
	
	public FrequentRenterPoints(int frequentRenterPoints) {
		this.frequentRenterPoints = frequentRenterPoints;
	}
	
	public int intValue() {
		return this.frequentRenterPoints;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(frequentRenterPoints);
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(other instanceof FrequentRenterPoints) {
			FrequentRenterPoints that = (FrequentRenterPoints)other;
			return this.frequentRenterPoints == that.frequentRenterPoints;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.frequentRenterPoints);
	}
}
