package domain;

class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return this.priceCode;
    }

    public String getTitle() {
        return this.title;
    }
    
    public Amount getAmount(int daysRented) {
    	
    	return PaymentType.of
    			(this.priceCode).getAmount(daysRented);
    }
    
    public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {
    	
    	return PaymentType.of
    			(this.priceCode).getFrequentRenterPoints(daysRented);
    }
    
    @Override
    public String toString() {
    	return "title[" + this.title + "],priceCode[" + this.priceCode + "]"; 
    }
}
