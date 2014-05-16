package utils;
import java.math.BigDecimal;

/**
 * The Vector is a container of two BigDecimals.
 * As it is, it works fine in a 2D plane. 
 * It can be used for position, velocity and accelleration.
 * @see BigDecimal
 */

public class Vector {
	
	/**
	 * The X value.
	 */
	private BigDecimal x;
	
	/**
	 * The Y value.
	 */
	private BigDecimal y;
	
	/**
	 * Creates a Vector.
	 * @param x The X value in BigDecimal.
	 * @param y The Y value in BigDecimal.
	 */
	public Vector(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Used to get the X component.
	 * @return The actual X component in a BigDecimal.
	 */
	public BigDecimal getX() {
		return x;
	}

	/**
	 * Used to get the Y component.
	 * @return The actual Y component in a BigDecimal.
	 */
	public BigDecimal getY() {
		return y;
	}
	
	/**
	 * Used to get the X component.
	 * @param x The new X component in BigDecimal.
	 */
	public void setX(BigDecimal x) {
		this.x = x;
	}

	/**
	 * Used to get the Y component.
	 * @param y The new Y component in BigDecimal.
	 */
	public void setY(BigDecimal y) {
		this.y = y;
	}

	/**
	 * Used to multiply a Vector for n times.
	 * @param n A BigDecimal containing the number for which you need to multiply the Vector.
	 * @return A Vector that is n times the starting one.
	 */
	public Vector times(BigDecimal n){
		return new Vector(x.multiply(n),y.multiply(n));
	}
	
	/**
	 * Used to divide a Vector for n times.
	 * @param n A BigDecimal containing the number for which you need to divide the Vector.
	 * @return A Vector that is 1/n the starting one.
	 */
	public Vector divide(BigDecimal n){
		return new Vector(x.divide(n,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND),y.divide(n,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND));
	}
	
	/**
	 * Used to subtract a Vector from the calling one.
	 * @param other The Vector to subtract.
	 * @return A new Vector that is the result of the subtraction.
	 */
	public Vector minus(Vector other){
		return new Vector(x.add(other.getX().negate()),y.add(other.getY().negate()));
	}

	/**
	 * Used to add a Vector from the calling one.
	 * @param other The Vector to add.
	 * @return A new Vector that is the result of the addition.
	 */
	public Vector add(Vector other) {
		return new Vector(x.add(other.getX()),y.add(other.getY()));
	}
	
	/**
	 * Used to get the length of the Vector.
	 * @return The length of the Vector calculated by the Babylonian square root method.
	 */
	public BigDecimal getLength() {
		return sqrt((x.multiply(x)).add(y.multiply(y)));
	}
	
	/**
	 * Return the distance from a choosen Vector.
	 * @param other The Vector from which I need the distance.
	 * @return A BigDecimal containing the distance between the two vectors.
	 */
	public BigDecimal getDistance(Vector other){
		BigDecimal dx = x.add(other.getX().negate());
		BigDecimal dy = y.add(other.getY().negate());
		return sqrt((dx.multiply(dx)).add(dy.multiply(dy)));
	}
	
	/**
	 * Returns the square root of a BigDecimal using the Babylonian method.
	 * @param number The BigDecimal of which I need his square root.
	 * @return A BigDecimal containing the square root.
	 */
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
	
	/**
	 * Used to check if a Vector has the same components of another.
	 */
	public boolean equals(Object o){
		if(o instanceof Vector){
			Vector a = (Vector)o;
			return this.x.equals(a.x) && this.y.equals(a.y) ; 
		}
		return false;
		
	}
	
	/**
	 * Returns a string providing informations about the Vector.
	 */
	public String toString(){
		return "" + x.toBigInteger() + ", " + y.toBigInteger();
	}
}
