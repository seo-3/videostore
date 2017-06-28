package domain;

interface PayAmount {
	Amount getAmount(int daysRented);
	FrequentRenterPoints getFrequentRenterPoints(int daysRented);
}
