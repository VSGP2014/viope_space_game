package viope.space.game;

class Element {
	// Fields 
	
	// Bulk(?)/Mass
	float 	mass;
	// The position of the element in the space
	float[] coordinates; 
	
	public Element(float m, float x, float y, float z){
		coordinates = new float[3];
		mass = m;
		coordinates[0] = x;
		coordinates[1] = y;
		coordinates[2] = z;
	}
}
