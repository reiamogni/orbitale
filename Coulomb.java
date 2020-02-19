package atom_numerisch;

public class Coulomb extends Function {
	
	double [] a = {0,0,0};
	
	Coulomb (){}
	
	Coulomb (double [] a){
		this.a = a;
	}
	
	
	@Override 
	double value (double r , double theta ){
		double h = r * r - 2 * this.a[2] * r * Math.cos(theta) + this.a[2] * this.a[2];
		if (h <= 0.0) {return 0;} 
		else return 1 / Math.sqrt(h);
		/* Auslenkung um a in z_Richtung*/
	}
}
