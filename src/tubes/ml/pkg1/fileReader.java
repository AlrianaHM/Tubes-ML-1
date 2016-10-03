/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.ml.pkg1;

/*Import*/
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alriana
 */
public class fileReader {
   
   public void read() throws FileNotFoundException, IOException{
       
       String filename = "./src/data/weather.nominal.arff";
       BufferedReader reader = new BufferedReader(new FileReader(filename));
       
       Instances data = new Instances(reader);
       reader.close();
   }
}
