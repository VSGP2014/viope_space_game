package model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.math.BigDecimal;
import java.awt.Color;
import model.Body;
import utils.*;

public class BodyTest {

	Body body= new Body ("test",new BigDecimal("123"), 123, new Vector(new BigDecimal ("123"), new BigDecimal("123")), new Vector(new BigDecimal ("123"), new BigDecimal("123")), Color.red);
	
	@Test
	public void testGetLocation() {
		Vector test1 = new Vector(new BigDecimal("123"),new BigDecimal("123"));
		body.setLocation(new Vector(new BigDecimal("123"),new BigDecimal("123")));
		assertEquals(test1.getX(),body.getLocation().getX());
		assertEquals(test1.getY(), body.getLocation().getY());
		
	}
	
	@Test
	public void testMARSGetLocation() {
		Vector test1 = new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516"));
		body.setLocation(new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516")));
		assertEquals(test1.getX(),body.getLocation().getX());
		assertEquals(test1.getY(), body.getLocation().getY());
	}
	
	@Test
	public void testGetColor(){
		Color nikke = Color.pink;
		body.setColor(Color.pink);
		assertEquals(nikke,body.getColor());
	}

	@Test
	public void testVelocity(){
		Vector testspeed = new Vector(new BigDecimal("696969"), new BigDecimal("20202"));
		body.setVelocity(new Vector(new BigDecimal("696969"), new BigDecimal("20202")));
		assertEquals(testspeed.getX(),body.getVelocity().getX());
		assertEquals(testspeed.getY(),body.getVelocity().getY());
	}
}
