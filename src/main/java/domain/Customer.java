package domain;


class Customer {
	
	private String name;
    private RentalLines rentalLines = new RentalLines();
    
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
    	this.rentalLines.addRental(rental);
    }
  
    public String getName() {
        return this.name;
    }

    public String statement() {
    	return this.displayLine();
    }
    
	public String displayLine() {
		return this.rentalLines.displayLines(this.getName());
	}

    public Amount getTotalAmount() {
    	return this.rentalLines.getTotalAmount();
    }
    
    public FrequentRenterPoints getTotalFrequentRenterPoints() {
    	return this.rentalLines.getTotalFrequentRenterPoints();
    }
    
    @Override
    public String toString() {
    	return "name[" + this.name + "],rentalLines[" + this.rentalLines + "]"; 
    }
}
