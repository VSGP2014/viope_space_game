package model;

import static org.junit.Assert.*;

import java.awt.Color;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;

public class UniverseTest {
	private Universe u;
	
	@Before
	public void init(){
		u = new Universe(); 
		
	}
	
	@Test
	public void testGetBodies() {
		
		Body[] test = new Body[3];
		test[0] = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[1] = new Body("Marte",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[2] = new Body("venus",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);

		u.add(test[0]);
		u.add(test[1]);
		u.add(test[2]);
		
		for (int i = 0; i < test.length; i++) {
			if(test[i]==(u.getBodies()[i]))
				System.out.println(i+": true");
					
		}

	}
	

    @Test
	public void testSetBodies() {
    	Body[] test = new Body[3];
    	test[0] = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[1] = new Body("Marte",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[2] = new Body("venus",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		
		u.add(test[0]);
		u.add(test[1]);
		u.add(test[2]);

		
		for(int i = 0; i < test.length; i++){
			System.out.println("Old Name: "+test[i].getName());	
			test[i].setName("Earth");
		}
			
		u.setBodies(test);
		
		for(int i = 0; i < test.length; i++)
			System.out.println("New Name: "+test[i].getName());	
		
		for(int i = 0; i < test.length; i++)
			assertEquals(u.getBodies()[i], test[i]);	
	}

    @Test
	public void testAdd() {
    	Body[] test = new Body[3];
    	test[0] = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[1] = new Body("Marte",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[2] = new Body("venus",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
    	
		u.add(test[0]);
		u.add(test[1]);
		u.add(test[2]);
		
		int ul = u.getBodies().length;
		System.out.println(ul);
		
		for(int i = 0; i < u.getBodies().length; i++)
			assertEquals(u.getBodies()[i], test[i]);
	
    }
    
    
	@Test
	public void testToString() {
		
		Body[] test = new Body[3];
		test[0] = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[1] = new Body("Marte",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
		test[2] = new Body("venus",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,ConstantsUniverse.MERCURY_RADIUS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL)),(new BigDecimal("-35094.635")).multiply(new BigDecimal(ConstantsSpaceGame.INTERVAL))), Color.gray);
    	
		u.add(test[0]);
		u.add(test[1]);
		u.add(test[2]);
		
		String expected = "";
		
		for (int i = 0; i < test.length; i++) {
			expected = expected + test[i].toString()+ ", distance to " + test[0].getName() + ": " + (test[i].getLocation()).getDistance(test[0].getLocation()) + "\n";
		}
	
		assertEquals(expected,u.toString());
				
	}

}

