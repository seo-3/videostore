package domain;

class RegularAmount implements PayAmount {
	
	@Override
	public Amount getAmount(int daysRented) {
		
		Amount amount = new Amount(2);
		if(daysRented > 2) {
			return amount.plus(new Amount((daysRented - 2) * 1.5));
		}
		return amount;
		
	}
	
	@Override
	public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {
		return new FrequentRenterPoints(1);
	}
}
