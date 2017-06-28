package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RentalLines implements Cloneable {

	private List<Rental> rentals;
	
	public RentalLines() {
		this.rentals = new ArrayList<Rental>();
	}
	
	public RentalLines(List<Rental> rentals) {
		if(rentals == null) {
    		throw new IllegalArgumentException();
    	}
		this.rentals = new ArrayList<>(rentals);
	}
	 
	public void addRental(Rental rental) {
    	if(rental == null) {
    		throw new IllegalArgumentException();
    	}
		this.rentals.add(rental);
	}
	
	public Amount getTotalAmount() {
		
		return new Amount(
				this.rentals.stream()
				.mapToDouble(r -> r.getAmount().doubleValue())
				.sum());
	}
	
	public FrequentRenterPoints getTotalFrequentRenterPoints() {
	
		return new FrequentRenterPoints(
				this.rentals.stream()
				.mapToInt(r -> r.getFrequentRenterPoints().intValue())
				.sum());
	}
	
	public void clear() {
        this.rentals.clear();
    }
	
    @Override
    public RentalLines clone() {
        return new RentalLines(this.rentals);
    }
    
    public String displayLines(String name) {

    	String result = "Rental Record for " + name + "\n";

    	result += this.rentals.stream()
    			.map(r -> "\t" + r.getMovie().getTitle() + "\t" + r.getAmount().toString() + "\n")
    	    	.collect(Collectors.joining());

    	result += "Amount owed is " + this.getTotalAmount().toString() + "\n";
    	result += "You earned " + this.getTotalFrequentRenterPoints().toString() +
    			" frequent renter points";
    	
    	return result;
    }
    
    @Override
    public String toString() {
    	return this.rentals.toString();
    }
}
