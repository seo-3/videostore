package domain;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;


public class AmountTest {
		
	//等価性を確認する
	@Test
    public void sameAmountAs() {
		assertThat(new Amount(100), equalTo(new Amount(100)));
    }
	
	//料金を足し算する
	@Test
    public void plusAmount() {
		Amount a1 = new Amount(50);
		Amount a2 = new Amount(150);
		
		assertThat(a1.plus(a2), equalTo(new Amount(200)));
    }
	
	//料金を引き算する
	@Test
    public void subtractAmount() {
		Amount a1 = new Amount(150);
		Amount a2 = new Amount(100);
		
		assertThat(a1.subtract(a2), equalTo(new Amount(50)));
		
		//負の数を許容する
		assertThat(a2.subtract(a1), equalTo(new Amount(-50)));
    }
	
	//変換した料金を返却する
	@Test
    public void returnDoubleValue() {
		
		assertThat(new Amount(150).doubleValue(), equalTo(150.0));
    }
	
	//料金の降順で並び替える
	@Test
	public void amountsResultInOrderBy() {
		
		Set<Amount> s = new TreeSet<Amount>();
		s.add(new Amount(10));
		s.add(new Amount(30));
		s.add(new Amount(20));
		
		assertThat(s.toArray(), equalTo(new Amount[] {new Amount(10), new Amount(20), new Amount(30)}));
    }
}
