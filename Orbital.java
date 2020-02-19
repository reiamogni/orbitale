package atom_numerisch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Orbital {
	
	public String file; 
	public String remark;
	
	public double max;
	public double step;
	private double factor;
	
	public Y y; 
	
	public int Z;
	private double a[] = {0 , 0, 0};
	private double betrag_a = 0;
	
	/* beachte : f(x - x0) also negatives VZ*/
	
	
	private ArrayList<Double> values;
	
	
	Orbital (String file , Y y , int Z){

		this.file = file;
		this.Z = Z;
		this.values = new ArrayList<Double> ();
		this.factor = Math.pow(Z, 1.5);
		this.y = y;
		
		initial();

	}
	
	Orbital (String file , Y y , int Z , double [] a){

		this.file = file;
		this.Z = Z;
		this.values = new ArrayList<Double> ();
		this.factor = Math.pow(Z, 1.5);
		this.y = y;
		
		this.betrag_a = Math.sqrt(a[0] * a[0] + a[1] * a[1] + a[2] * a[2]);
		
		initial();
		System.out.println (this.betrag_a);

	}
	
	
	void initial (){
		try {
			FileReader  read_h = new FileReader (file);
			BufferedReader read = new BufferedReader (read_h);
			try {
				
				this.remark = read.readLine();
				this.max 	= Double.valueOf(read.readLine());
				this.step 	= Double.valueOf(read.readLine());
				
				String in = read.readLine();
				while (in != null ){
					values.add(Double.valueOf(in));
					in = read.readLine();
				}
				read.close();
				
			} catch (IOException e) {
				System.out.println ("einlesen geht nicht");
			}
		} catch (FileNotFoundException e) {
			System.out.println ("File öffnet nicht zum lesen");
		}
	}
	
	
	
	
	double value (double r ,  double theta ){
		double h = r * r + this.betrag_a * this.betrag_a - 2 * r * (this.a[0] * Math.sin(theta) + this.a[2] * Math.cos(theta));
		if (h < 0) return 0;
		h = Math.sqrt(h);
		if ( h > max ) return 0;
		else {
			theta = Math.acos( (r * Math.cos(theta) - a[2]) / h);
			return y.value (theta ) * factor * values.get((int) Math.rint(Z * h / step) );
		}
	}
}
