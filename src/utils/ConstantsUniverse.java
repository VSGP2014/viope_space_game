package utils;

import java.math.BigDecimal;

public class ConstantsUniverse {
	// General
	// G = (6,67428 ± 0,00067) × 10-11 Nm2 kg-2 ConstantsSpaceGame.INTERVAL-2.
	public static BigDecimal G = new BigDecimal("0.0000000000667428").multiply(new BigDecimal(Math.pow(ConstantsSpaceGame.INTERVAL,2)));
	
	// Masses in kg
	public static BigDecimal SOL_MASS =     new BigDecimal("1988920000000000000000000000000");
	public static BigDecimal MERCURY_MASS = new BigDecimal("330220000000000000000000");
	public static BigDecimal VENUS_MASS =   new BigDecimal("4867600000000000000000000");
	public static BigDecimal EARTH_MASS =   new BigDecimal("5972600000000000000000000");
	public static BigDecimal MARS_MASS =    new BigDecimal("641850000000000000000000");
	public static BigDecimal JUPITER_MASS = new BigDecimal("1898600000000000000000000000");
	public static BigDecimal SATURN_MASS =  new BigDecimal("568460000000000000000000000");
	public static BigDecimal URANUS_MASS =  new BigDecimal("86810000000000000000000000");
	public static BigDecimal NEPTUNE_MASS = new BigDecimal("102430000000000000000000000");
	public static BigDecimal PLUTO_MASS =   new BigDecimal("13050000000000000000000");
	
	// Orbits in m
	public static BigDecimal SOL_ORBIT =                 new BigDecimal("0");
	public static BigDecimal MERCURY_ORBIT =   new BigDecimal("58000000000");
	public static BigDecimal VENUS_ORBIT =    new BigDecimal("108000000000");
	public static BigDecimal EARTH_ORBIT =    new BigDecimal("150000000000");
	public static BigDecimal MARS_ORBIT =     new BigDecimal("228000000000");
	public static BigDecimal JUPITER_ORBIT =  new BigDecimal("786000000000");
	public static BigDecimal SATURN_ORBIT =  new BigDecimal("1433000000000");
	public static BigDecimal URANUS_ORBIT =  new BigDecimal("2825000000000");
	public static BigDecimal NEPTUNE_ORBIT = new BigDecimal("4500000000000");
	public static BigDecimal PLUTO_ORBIT =   new BigDecimal("6000000000000");
	
	// Speeds in m/ConstantsSpaceGame.INTERVAL
	public static BigDecimal SOL_SPEED = new BigDecimal("0").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal MERCURY_SPEED = new BigDecimal("47870").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal VENUS_SPEED = new BigDecimal("35020").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal EARTH_SPEED = new BigDecimal("29806").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal MARS_SPEED = new BigDecimal("24077").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal JUPITER_SPEED = new BigDecimal("13070").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal SATURN_SPEED = new BigDecimal("9690").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal URANUS_SPEED = new BigDecimal("6810").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal NEPTUNE_SPEED = new BigDecimal("5430").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal PLUTO_SPEED = new BigDecimal("4700").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
}
