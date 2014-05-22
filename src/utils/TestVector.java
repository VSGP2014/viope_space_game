package utils;
import java.util.Random;
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
		//assertNotEquals(vector, null);
	}
	
	@Test
	public void isCorrectlyInitialised(){
		boolean result = vector.equals(new Vector(BigDecimal.ONE,BigDecimal.ONE));
		assertTrue(result);
	}
	
	@Test
	public void isCorrectGetX(){
		BigDecimal a ;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			a = new BigDecimal(b.nextInt(2000000000));
			vector.setX(a);
			if(vector.getX().equals(a))
				j++;
		}
		assertTrue(j==c);
	}
	
	@Test
	public void isCorrectGetY(){
		BigDecimal a ;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			a = new BigDecimal(b.nextInt(2000000000));
			vector.setY(a);
			if(vector.getY().equals(a))
				j++;
		}
		assertTrue(j==c);
	}
	
	@Test
	public void isCorrectSetX(){
		BigDecimal a ;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			a = new BigDecimal(b.nextInt(2000000000));
			vector.setX(a);
			if(vector.getX().equals(a))
				j++;
		}
		assertTrue(j==c);
	}
	
	@Test
	public void isCorrectSetY(){
		BigDecimal a ;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			a = new BigDecimal(b.nextInt(2000000000));
			vector.setY(a);
			if(vector.getY().equals(a))
				j++;
		}
		assertTrue(j==c);
	}
	
	@Test
	public void isCorrectTimes(){
		
		BigDecimal d ;
		Vector test;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.times(d).equals(new Vector(d.multiply(d),d.multiply(d))))
				j++;
		}
		assertTrue(j==c);
	}
	
	@Test
	public void isCorrectDivide(){
		BigDecimal d ;
		Vector test;
		int j=0,c=4;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.divide(d).equals(new Vector(d.divide(d),d.divide(d))))
				j++;
		}
		assertTrue(j==c);
		
		
	}
	
	@Test
	public void isCorrectMinus(){
		BigDecimal d ;
		Vector test;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.minus(new Vector(d,d)).equals(new Vector(BigDecimal.ZERO,BigDecimal.ZERO)))
				j++;
		}
		
		assertTrue(j == c);	
	}
	
	@Test
	public void isCorrectAdd(){
		BigDecimal d ;
		Vector test;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.add(new Vector(d.negate(),d.negate())).equals(new Vector(BigDecimal.ZERO,BigDecimal.ZERO)))
				j++;
		}
		
		assertTrue(j == c);
	}
	
	@Test
	public void isCorrectGetLength(){
		BigDecimal d;
		Vector test;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.getLength().equals(Vector.sqrt(d.multiply(d).add(d.multiply(d)))))
				j++;
		}
		
		assertTrue(j == c);
		
	}
	
	@Test
	public void isCorrectGetDistance(){
		BigDecimal d;
		Vector test;
		int j=0,c=400;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			if(test.getDistance(new Vector(BigDecimal.ONE,BigDecimal.ONE)).equals(Vector.sqrt(d.add(BigDecimal.ONE.negate()))))
				j++;
		}
		assertTrue(j == c);
	}
	
	@Test
	public void isCorrectSqrt(){
		BigDecimal d;
		int j=0,c=40,r;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d = new BigDecimal(r = b.nextInt(20000000));
			if((Vector.sqrt(d).setScale(15, ConstantsSpaceGame.ROUND)).equals((new BigDecimal(Math.sqrt(r))).setScale(15, ConstantsSpaceGame.ROUND)))
				j++;
		}
			assertTrue(j == c);
	}
	
	@Test
	public void isCorrectToString(){
		BigDecimal d;
		Vector test;
		int j=0,c=400;
		String s;
		Random b = new Random();
		for(int i = 1; i<=c;i++){
			d =new BigDecimal( b.nextInt(20000000));
			test = new Vector(d,d);
			s = "" + d.toBigInteger() + ", " + d.toBigInteger();
			if(test.toString().equals(s))
				j++;
		}
			assertTrue(j == c);
	}
	
	
}
