package atom_numerisch;

public class RechnungenStart {

	public static void main(String[] args) {
		System.out.println ("start");
		
		Orbital H_1s_1 = new Orbital ("R10" ,new Y00 () ,  1);
		
		double a[] = { 0 , 0 , 0};
		
		for (int i = 0; i < 11; i++){
			a[2] = (double) i / 10;
			Orbital H_1s_2 = new Orbital("R10" , new Y00() , 1 , a);
			System.out.printf ("%.12f   %.12f \n" , integrate (H_1s_1 , H_1s_2 , new Eins()) , (1 + a[2] + a[2]* a[2] / 3)*Math.exp(- a[2] ));
		}
	}
	
	static double integrate (Orbital orbital1 , Orbital orbital2 ,  Function ww){
		double step = Math.max(orbital1.step, orbital2.step);
		double thetaStep = Math.min(orbital1.y.thetaStep , orbital2.y.thetaStep);
		double max = Math.min(orbital1.max , orbital2.max);
		double result = 0;
		for (double r = 0; r < max ; r+= step){
			for (double theta = 0; theta <= Math.PI ; theta += thetaStep){
				result += Math.sin(theta) * r * r * orbital1.value(r , theta ) * orbital2.value(r , theta ) * ww.value (r  , theta  );				
			}
		}
		return result * step * thetaStep * Math.PI * 2;
	}

	static double [] sphere  (double [] v){
		
		double [] value = new double [3];
		
		value [0] = Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
		value [1] = 0;
		value [2] = Math.acos(v[0] / value[0]);
		
		
		return value;
		/* return im Format (r , phi , theta)*/
		
	}

}
