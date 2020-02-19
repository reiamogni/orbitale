package atom_numerisch;

public class Y00 extends Y {
	
	
	private double value = 1 / Math.sqrt (4 * Math.PI);
	Y00 (){
		
	}
	@Override 
	double value (double theta){
		return value;
	}

}
