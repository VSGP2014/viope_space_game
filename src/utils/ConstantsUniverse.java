package utils;

import java.math.BigDecimal;

public class ConstantsUniverse {
	// General
	// G = (6,67428 +/- 0,00067) * 10-11 Nm2 kg-2 ConstantsSpaceGame.INTERVAL-2.
	public static BigDecimal G = new BigDecimal("0.0000000000667428").multiply(new BigDecimal(Math.pow(ConstantsSpaceGame.INTERVAL,2)));
	
	// Masses in kg
	//- Planets
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
	//- Moons 
	public static BigDecimal MOON_MASS =		new BigDecimal("73476730924573500000000");
	public static BigDecimal IO_MASS = 			new BigDecimal("89319380000000000000000");
	public static BigDecimal EUROPA_MASS = 		new BigDecimal("47998440000000000000000");
	public static BigDecimal GANYMEDE_MASS = 	new BigDecimal("148190000000000000000000");
	public static BigDecimal CALLISTO_MASS = 	new BigDecimal("107593800000000000000000");
	public static BigDecimal MIMAS_MASS = 		new BigDecimal("37493000000000000000");
	public static BigDecimal IAPETUS_MASS = 	new BigDecimal("1805635000000000000000");
	public static BigDecimal TETHYS_MASS = 		new BigDecimal("617449000000000000000");
	public static BigDecimal DIONE_MASS = 		new BigDecimal("1095452000000000000000");
	public static BigDecimal RHEA_MASS = 		new BigDecimal("2306518000000000000000");
	public static BigDecimal TITAN_MASS = 		new BigDecimal("134520000000000000000000");
	public static BigDecimal TITANIA_MASS = 	new BigDecimal("352700000000000000000");
	public static BigDecimal TRITON_MASS = 		new BigDecimal("21400000000000000000000");
		
	// Orbits in m
	//- Planets
	public static BigDecimal SOL_ORBIT =        new BigDecimal("0");
	public static BigDecimal MERCURY_ORBIT =   	new BigDecimal("58000000000");
	public static BigDecimal VENUS_ORBIT =     	new BigDecimal("108000000000");
	public static BigDecimal EARTH_ORBIT =     	new BigDecimal("150000000000");
	public static BigDecimal MARS_ORBIT = 		new BigDecimal("228000000000");
	public static BigDecimal JUPITER_ORBIT = 	new BigDecimal("786000000000");
	public static BigDecimal SATURN_ORBIT =   	new BigDecimal("1433000000000");
	public static BigDecimal URANUS_ORBIT =  	new BigDecimal("2825000000000");
	public static BigDecimal NEPTUNE_ORBIT = 	new BigDecimal("4500000000000");
	public static BigDecimal PLUTO_ORBIT =   	new BigDecimal("6000000000000");
	//- Moons - checked
	public static BigDecimal MOON_ORBIT =     new BigDecimal("384400000");
	public static BigDecimal IO_ORBIT =     new BigDecimal("421800000");
	public static BigDecimal EUROPA_ORBIT =     new BigDecimal("671100000");
	public static BigDecimal GANYMEDE_ORBIT =     new BigDecimal("1070400000");
	public static BigDecimal CALLISTO_ORBIT =     new BigDecimal("1882700000");
	public static BigDecimal MIMAS_ORBIT =     new BigDecimal("185536000");
	public static BigDecimal IAPETUS_ORBIT =     new BigDecimal("3560820000");
	public static BigDecimal TETHYS_ORBIT =     new BigDecimal("294619000");
	public static BigDecimal DIONE_ORBIT =     new BigDecimal("377396000");
	public static BigDecimal RHEA_ORBIT =     new BigDecimal("527108000");
	public static BigDecimal TITAN_ORBIT =     new BigDecimal("1221870000");
	public static BigDecimal TITANIA_ORBIT =     new BigDecimal("436300000");
	public static BigDecimal TRITON_ORBIT =     new BigDecimal("354759000");
	
	// Speeds in m/ConstantsSpaceGame.INTERVAL
	//- Planets
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
	//- Moons 
	public static BigDecimal IO_SPEED =     new BigDecimal("17334").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal EUROPA_SPEED =     new BigDecimal("13740").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal GANYMEDE_SPEED =     new BigDecimal("10880").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal CALLISTO_SPEED =     new BigDecimal("8204").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal MIMAS_SPEED =     new BigDecimal("14320").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal IAPETUS_SPEED =    new BigDecimal("19330").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal TETHYS_SPEED =     new BigDecimal("11360").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal DIONE_SPEED =     new BigDecimal("10030").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal RHEA_SPEED =    new BigDecimal("8490").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal TITAN_SPEED =     new BigDecimal("5580").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal TITANIA_SPEED =    new BigDecimal("36500").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
	public static BigDecimal TRITON_SPEED =     new BigDecimal("4390").multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL));
}
