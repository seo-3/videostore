package domain;

class NewReleaseAmount implements PayAmount {
	
	@Override
	public Amount getAmount(int daysRented) {
		
		return new Amount(daysRented * 3);
	}
	
	@Override
	public FrequentRenterPoints getFrequentRenterPoints(int daysRented) {

		return new FrequentRenterPoints((daysRented > 1) ? 2 : 1);
	}
}
