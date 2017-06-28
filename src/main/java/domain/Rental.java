package domain;

class Rental {
	
	private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
    	
    	if(movie == null) {
    		throw new IllegalArgumentException();
    	}
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return this.daysRented;
    }
    
    public Movie getMovie() {
        return this.movie;
    }
    
    public Amount getAmount() {
    	return this.movie.getAmount(daysRented);
    }
    
    public FrequentRenterPoints getFrequentRenterPoints() {
    	return this.movie.getFrequentRenterPoints(daysRented);
    }
    
    @Override
    public String toString() {
    	return "movie[" + this.movie + "],daysRented[" + this.daysRented + "]"; 
    }
}
