package atom_numerisch;


import java.io.FileWriter;
import java.io.IOException;

public class FunktionBerechnen {

	/*static String name = "R20";
	static String remark = "1 / sqrt(2) * (1-r/2 * exp(- r / 2)";*/
	
	static String name = "R10_hohe_genauigkeit";
	static String remark = "2 * exp (-r)";
	
	/*static String name = "R21"; 
	static String remark = "1/sqrt(3) * 2^1.5 r * exp (- R/2)";*/
	static FileWriter write;
	
	static double max = 20;
	static double step = 0.0001;
	
	
	public static void main(String[] args) {
		
		try {
			write = new FileWriter (name);
			write.write(remark + "\n");
			write.write(Double.toString(max) + "\n");
			write.write(Double.toString(step)+ "\n");
			
			System.out.println (remark);
			
			for (double  r = 0.0; r < max + step; r += step){
				System.out.println (r);
				write.write(Double.toString(function1s (r) ) + "\n");
			}
			
			
			write.close();
		} catch (IOException e) {
			System.out.println ("File öffnet nicht zum schreiben");
		}

	}
	
	static double function1s (double r){
		return (2 * Math.exp(- r));
	}
	
	static double function2s (double r){
		return (1 / Math.sqrt(2) * (1 - r/2) * Math.exp(- r/2));
	}
	
	static double function2p (double r){
		return (1 / Math.sqrt(3) * Math.pow(.5, 1.5) * r  * Math.exp(- r/2));
	}

}
