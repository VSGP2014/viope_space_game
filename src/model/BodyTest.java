package model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
import java.awt.Color;

import model.Body;
import utils.*;

public class BodyTest {

	Body body= new Body ("test",new BigDecimal("123"), 123,123, new Vector(new BigDecimal ("123"), new BigDecimal("123")), new Vector(new BigDecimal ("123"), new BigDecimal("123")), Color.red);
	
	@Test
	public void testLocation() {
		Vector test1 = new Vector(new BigDecimal("123"),new BigDecimal("123"));
		body.setLocation(new Vector(new BigDecimal("123"),new BigDecimal("123")));
		assertEquals(test1.getX(),body.getLocation().getX());
		assertEquals(test1.getY(), body.getLocation().getY());
		
	}
	
	@Test
	public void testLocationRandomSeed(){
		Random random = new Random(400);
		int n1 = random.nextInt(500);
		int n2 = random.nextInt(500);
		while(n1==n2){
			n1=random.nextInt(500);
		}
		Vector test1 = new Vector(new BigDecimal(n1),new BigDecimal(n2));
		body.setLocation(new Vector(new BigDecimal(n1), new BigDecimal(n2)));
		assertEquals(test1.getX(),body.getLocation().getX());
		assertEquals(test1.getY(),body.getLocation().getY());
		test1 = new Vector(new BigDecimal(n2),new BigDecimal(n1));
		assertFalse(test1==body.getLocation());
	}
	
	@Test
	public void testMARSLocation() {
		Vector test1 = new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516"));
		body.setLocation(new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516")));
		assertEquals(test1.getX(),body.getLocation().getX());
		assertEquals(test1.getY(), body.getLocation().getY());
	}
	
	@Test
	public void testColor(){
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
	
	@Test
	public void testVelocityRandomSeed(){
		Random random = new Random(400);
		int n1 = random.nextInt(600);
		int n2 = random.nextInt(600);
		while(n1==n2){
			n1=random.nextInt(600);
		}
		Vector test = new Vector(new BigDecimal(n1),new BigDecimal(n2));
		body.setVelocity(new Vector(new BigDecimal(n1),new BigDecimal(n2)));
		assertEquals(test.getX(),body.getVelocity().getX());
		assertEquals(test.getY(),body.getVelocity().getY());
		body.setVelocity(new Vector(new BigDecimal(n2),new BigDecimal(n1)));
		assertFalse(test==body.getVelocity());
	}
	
	@Test
	public void testBody() {
		Body body1=new Body("test",new BigDecimal("20"), 100, 100,new Vector(new BigDecimal("20"),new BigDecimal("130")),new Vector(new BigDecimal("10"),new BigDecimal("10")),Color.black);
		assertNotNull(body1.getName());
		assertNotNull(body1.getColor());
		assertNotNull(body1.getLocation());
		assertNotNull(body1.getSize());
		assertNotNull(body1.getVelocity());
		assertNotNull(body1.getWeight());		
	}

	@Test
	public void testGetName() {
		body.setName("testname");
		String name="testname";
		assertEquals(body.getName(),name);
	}

	@Test
	public void testGetWeight() {
		body.setWeight(ConstantsUniverse.MARS_MASS);
		BigDecimal test = ConstantsUniverse.MARS_MASS;
		assertEquals(test,body.getWeight());
	}
	
	@Test
	public void testWeightRandomSeed(){
		Random random = new Random(400);
		BigDecimal n1= new BigDecimal(random.nextInt(600));
		BigDecimal test = n1;
		body.setWeight(n1);
		assertEquals(test,body.getWeight());
		n1 = new BigDecimal(random.nextInt(600));
		assertFalse(n1==body.getWeight());
	}

	@Test
	public void testGetSize() {
		body.setSize(256);
		int testSize = 256;
		assertEquals(testSize,body.getSize());
	}
	
	@Test
	public void testMove() {
		Vector start= new Vector(new BigDecimal("2034.76"), new BigDecimal("5365.87"));
		body.setLocation(start);
		body.setVelocity(new Vector(new BigDecimal("10"),new BigDecimal("10")));
		body.move(new Vector(new BigDecimal("15.15"), new BigDecimal("0.5")));
		Vector force= new Vector(new BigDecimal("15.15"), new BigDecimal("0.5"));
		Vector velocity= new Vector(new BigDecimal("10"),new BigDecimal("10"));
		//assertEquals(start,body.getLocation());
		velocity=velocity.add(force);
		start=start.add(velocity);
		assertEquals(start.getX(),body.getLocation().getX());
		assertEquals(start.getY(),body.getLocation().getY());
	}
	
	@Test
	public void testGetDistance(){
		Body other= new Body("Tests",new BigDecimal("50"),100,100,new Vector(new BigDecimal("50"),new BigDecimal("50")),new Vector(new BigDecimal("50"),new BigDecimal("50")),Color.BLACK);
		BigDecimal num= body.getDistance(other);
		BigDecimal num2 = body.getLocation().getDistance(other.getLocation()); 
		assertEquals(num,num2);
	}
	
	@Test
	public void testStringToString(){
	String derp = "" + "test" + ", location: " + new Vector(new BigDecimal ("123"), new BigDecimal("123")).toString()+ ", speed: "+new Vector(new BigDecimal ("123"), new BigDecimal("123")).toString();
	body.toString();
	assertEquals(derp, body.toString());
	}
	
}
