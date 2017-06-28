package domain;

enum PaymentType {
	    
	CHILDRENS(2, new ChildrensAmount()),
	REGULAR(0, new RegularAmount()),
	NEW_RELEASE(1, new NewReleaseAmount()),
	UNKNOWN(999, new UnknownAmount());
	
    private PayAmount amount;
    private int symbol;
    
    private PaymentType(int symbol, PayAmount amount) {
    	this.symbol = symbol;
    	this.amount = amount;
    }
        
    public int getSymbol() {
    	return this.symbol;
    }
        
    public Amount getAmount(int daysRented) {
    	return this.amount.getAmount(daysRented);
    }
    
    public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {
    	return this.amount.getFrequentRenterPoints(daysRented);
    }
    
    public static PaymentType of(int symbol) {
        
        for(PaymentType type : values()) {
            if(type.getSymbol() == symbol) {
                return type;
            }
        }
        //special-case
        return UNKNOWN;
    }
    
    @Override
    public String toString() {
    	return String.valueOf(this.symbol);
    }
}
