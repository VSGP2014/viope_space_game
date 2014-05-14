package utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Vector {
	private BigDecimal x;
	private BigDecimal y;
	
	public Vector(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}
	
	public BigDecimal getX() {
		return x;
	}

	public BigDecimal getY() {
		return y;
	}
	
	public void setX(BigDecimal x) {
		this.x = x;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	public Vector times(BigDecimal n){
		return new Vector(x.multiply(n),y.multiply(n));
	}
	
	public Vector divide(BigDecimal n){
		return new Vector(x.divide(n,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND),y.divide(n,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND));
	}
	
	public Vector minus(Vector other){
		return new Vector(x.add((other.getX()).negate()),y.add((other.getY()).negate()));
	}
	
	public Vector add(Vector other) {
		return new Vector(x.add(other.getX()),y.add(other.getY()));
	}
	
	public BigDecimal getLength() {
		return sqrt((x.multiply(x)).add(y.multiply(y)));
	}
	
	
	public BigDecimal getDistance(Vector other){
		BigDecimal dx = x.add(other.getX().negate());
		BigDecimal dy = y.add(other.getY().negate());
		return sqrt((dx.multiply(dx)).add(dy.multiply(dy)));
	}
	
	public BigDecimal sqrt(BigDecimal number){
	//	System.out.println("Vector sqrt number: " + number);
		if(number.compareTo(BigDecimal.ZERO) < 0){
			return new BigDecimal("-1");
		} else if (number.compareTo(BigDecimal.ZERO) == 0){
			return BigDecimal.ZERO;
		} else {
			BigDecimal two = new BigDecimal("2");
			BigDecimal nr0 = two;
			BigDecimal nr1 = new BigDecimal("20");
			for (int i = 0; i < 10000; i++){
				nr1 = (nr0.add(number.divide(nr0,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND))).divide(two,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND);
				if(nr1.compareTo(nr0) == 0){
					return nr1;
				} 
				nr0 = nr1;
			}
			return nr1;
		}
	}
	
	public boolean equals(Object o){
		if (o instanceof Vector)
			return x.equals(((Vector) o).x) && y.equals(((Vector) o).y);
		else
			return false;
	}
	
	public String toString(){
		return "" + x.toBigInteger() + ", " + y.toBigInteger();
	}
}
