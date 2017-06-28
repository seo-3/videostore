package domain;

class ChildrensAmount implements PayAmount {
	
	@Override
	public Amount getAmount(int daysRented) {
		
		Amount amount = new Amount(1.5);
	
        if(daysRented > 3) {
        	return amount.plus(new Amount((daysRented - 3) * 1.5));
        }
        return amount;
	}
	
	@Override
	public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {
		return new FrequentRenterPoints(1);
	}
}
