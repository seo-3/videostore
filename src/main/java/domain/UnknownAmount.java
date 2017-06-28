package domain;

class UnknownAmount implements PayAmount {
	
	@Override
	public Amount getAmount(int daysRented) {
			
		return new Amount(0);
	}
	
	@Override
	public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {
		return new FrequentRenterPoints(0);
	}
}
