package utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.Before;

public class TestVector {
	private Vector vector;
	
	@Before
	public void init(){
		vector = new Vector(BigDecimal.ONE,BigDecimal.ONE);
	}
	
	@Test
	public void isNotNull(){
		assertNotEquals(vector, null);
	}
	
	@Test
	public void isCorrectlyInitialised(){
		boolean result = vector.equals(new Vector(BigDecimal.ONE,BigDecimal.ONE));
		assertTrue(result);
	}
	
	@Test
	public void isCorrectGetX(){
		assertTrue(vector.getX().equals(BigDecimal.ONE));
	}
	
	@Test
	public void isCorrectGetY(){
		assertTrue(vector.getY().equals(BigDecimal.ONE));
	}
	
	@Test
	public void isCorrectSetX(){
		vector.setX(BigDecimal.TEN);
		assertTrue(vector.getX().equals(BigDecimal.TEN));
	}
	
	@Test
	public void isCorrectSetY(){
		vector.setY(BigDecimal.TEN);
		assertTrue(vector.getY().equals(BigDecimal.TEN));
	}
	
	@Test
	public void isCorrectTimes(){
		Vector test = vector.times(BigDecimal.TEN);
		Vector expected = new Vector(BigDecimal.TEN,BigDecimal.TEN);
		assertTrue(test.equals(expected));
	}
	
	@Test
	public void isCorrectDivide(){
		Vector to_divide = new Vector(BigDecimal.TEN,BigDecimal.TEN);
		int a = to_divide.getX().compareTo(to_divide.divide(BigDecimal.ONE).getX());
		int b = to_divide.getY().compareTo(to_divide.divide(BigDecimal.ONE).getY());
		assertTrue(a + b == 0 & a == 0);
	}
	
	@Test
	public void isCorrectMinus(){
		Vector m = new Vector(BigDecimal.TEN,BigDecimal.TEN);
		Vector i = new Vector(BigDecimal.TEN,BigDecimal.TEN);
		assertTrue(m.minus(i).equals(new Vector(BigDecimal.ZERO,BigDecimal.ZERO)));	
	}
	
	@Test
	public void isCorrectAdd(){
		Vector m = new Vector(BigDecimal.ZERO,BigDecimal.ZERO);
		Vector i = new Vector(BigDecimal.ONE,BigDecimal.ONE);
		assertTrue(m.add(i).equals(new Vector(BigDecimal.ONE,BigDecimal.ONE)));	
	}
	
	@Test
	public void isCorrectGetLength(){
		BigDecimal a = new BigDecimal(Math.sqrt(2));
		Vector i = new Vector(BigDecimal.ONE,BigDecimal.ONE);
		//System.out.println("a: "+ a.setScale(15, ConstantsSpaceGame.ROUND).toString());
		//System.out.println("i: "+ i.getLength().setScale(15, ConstantsSpaceGame.ROUND).toString());
		assertTrue((i.getLength().setScale(15, ConstantsSpaceGame.ROUND).compareTo(a.setScale(15, ConstantsSpaceGame.ROUND)))==0);	
	}
	
	@Test
	public void isCorrectGetDistance(){
		Vector m = new Vector(BigDecimal.ZERO,BigDecimal.ZERO);
		Vector i = new Vector(BigDecimal.ONE,BigDecimal.ONE);
		assertTrue(i.getDistance(m).setScale(15, ConstantsSpaceGame.ROUND).compareTo(new BigDecimal(Math.sqrt(2)).setScale(15, ConstantsSpaceGame.ROUND))==0);
	}
	
}
