package utils;

import java.math.BigDecimal;

public class ConstantsSpaceGame {
	//The number of decimals of the BigDecimals
	public static final int DECIMALS = 50;
	//Rounding method for the BigDecimals
	public static final int ROUND = BigDecimal.ROUND_HALF_UP;
	//To speed things up we don't use seconds, but INTERVAL seconds
	public static final int INTERVAL = 60*60;
	//If bodies are within this distance, they are considered to be together
	public static final BigDecimal MINIMUMDISTANCE = new BigDecimal("100000000000");
	//This far from the sun, you are lost in space
	public static final BigDecimal LOST = ConstantsUniverse.PLUTO_ORBIT.add(MINIMUMDISTANCE);
	//The amount of years the crew can survive on the food and drink supply
	public static final int YEARSSUPPLY = 4;
}
