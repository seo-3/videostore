package domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class CustomerTest {
	
	private Customer customer;
	
	@Before
	public void createCustomer() {
		customer = new Customer("Fred");
	}
	
	//新作映画をレンタルする
	@Test
    public void newReleaseRental() {
		customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 1));
		
        assertThat(customer.getTotalAmount(), equalTo(new Amount(3)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(1)));
    }
	
    //新作映画の貸出日が境界値(1日)を超えた場合はレンタルポイントが2ptsに加算される
	@Test
	public void newReleaseRentalAddBonusPoints() {
		customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 2));
		
        assertThat(customer.getTotalAmount(), equalTo(new Amount(6)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(2)));
    }

	//子供向け映画をレンタルする
	@Test
    public void childrensRental() {		
        customer.addRental(new Rental(new Movie("The Cell", Movie.CHILDRENS), 3));
        
        assertThat(customer.getTotalAmount(), equalTo(new Amount(1.5)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(1)));
    }

    //貸出日が3日(境界値)を経過した場合は日別に追加料金(1.5)が加算される
	@Test
    public void childrenRentalAddFee() {

        customer.addRental(new Rental(new Movie("The Cell", Movie.CHILDRENS), 4));
        
        assertThat(customer.getTotalAmount(), equalTo(new Amount(3.0)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(1)));
	}
	
	//通常映画をレンタルする
	@Test
    public void regularRental() {
		customer.addRental(new Rental(new Movie("The Cell", Movie.REGULAR), 2));
                
        assertThat(customer.getTotalAmount(), equalTo(new Amount(2)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(1)));
    }
	
	//貸出日が2日(境界値)を経過した場合は日別に追加料金(1.5)が加算される
	@Test
    public void regularRentalAddFee() {
		customer.addRental(new Rental(new Movie("The Cell", Movie.REGULAR), 3));
        
        assertThat(customer.getTotalAmount(), equalTo(new Amount(3.5)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(1)));
	}

	//複数映画をレンタルする
	@Test
	public void multiRental() {
		//cross-checks
		customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 2));
		customer.addRental(new Rental(new Movie("The Cell", Movie.CHILDRENS), 4));
		customer.addRental(new Rental(new Movie("The Cell", Movie.REGULAR), 3));
		
		assertThat(customer.getTotalAmount(), equalTo(new Amount(12.5)));
        assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(4)));
	}

	//レンタルにnullを追加すると例外が発生する
	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenAddNull() {
		customer.addRental(null);
	}
	
	//何もレンタルされていない場合はゼロを返却する
	@Test
    public void rentalZeroWhenNoElementAdd() {
		assertThat(customer.getTotalAmount(), equalTo(new Amount(0)));
		assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(0)));
    }
	
	//存在しないMovieタイプの場合はゼロを返却する
	@Test
    public void rentalZeroWhenNoMovieType() {
		customer.addRental(new Rental(new Movie("The Cell", -1), 2));
		
		assertThat(customer.getTotalAmount(), equalTo(new Amount(0)));
		assertThat(customer.getTotalFrequentRenterPoints(), equalTo(new FrequentRenterPoints(0)));
    }
	
	//映画にnullを追加すると例外が発生する
	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenAddNullMovie() {
		customer.addRental(new Rental(null, 3));
	}
}
