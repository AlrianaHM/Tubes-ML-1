/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.ml.pkg1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;
import weka.classifiers.trees.J48;
import weka.classifiers.Classifier;
import weka.classifiers.trees.Id3;
import weka.classifiers.Evaluation;

/**
 * @author Alriana
 */
public class TubesML1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int fold = 10;
        
        fileReader tets = new fileReader("E:\\Kuli Ah\\Sem 7 2016-2017\\IF 4071\\Tubes-ML-1\\src\\data\\iris.arff");
        try {
            tets.read();
        } catch (IOException ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Instances data = tets.getData();
        Id3 iTiga = new Id3();
        J48 jKT = new J48();
        
        /* try {
            iTiga.buildClassifier(data);
        } catch (Exception ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(iTiga.toString());
        */
        
        for (int i = 0; i <fold;i++){
            Instances train = data.trainCV(fold, i);
            Instances test = data.testCV(fold, i);         
            try {
                Evaluation validation = new Evaluation(train);
                try {
                    jKT.buildClassifier(data);
                } catch (Exception ex) {
                    Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
                }
                validation.evaluateModel(jKT, test);
                System.out.println(validation.toSummaryString());
           // System.out.println(jKT.toString());
            } catch (Exception ex) {
                Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        
        tets.setFilepath("E:\\Kuli Ah\\Sem 7 2016-2017\\IF 4071\\Tubes-ML-1\\src\\data\\weather.arff");
        try {
            tets.read();
        } catch (IOException ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = tets.getData();
        
        /* try {
            iTiga.buildClassifier(data);
        } catch (Exception ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(iTiga.toString());
        */
        
        for (int i = 0; i <fold;i++){
            Instances train = data.trainCV(fold, i);
            Instances test = data.testCV(fold, i);
            
            
            try {
                Evaluation validation = new Evaluation(train);
                try {
                    jKT.buildClassifier(data);
                } catch (Exception ex) {
                    Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
                }
                validation.evaluateModel(jKT, test);
                System.out.println(validation.toSummaryString());
           // System.out.println(jKT.toString());
            } catch (Exception ex) {
                Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        //System.out.println(iTiga.toString());
        System.out.println(jKT.toString());
    }
    
}
