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
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

/**
 * @author Alriana
 */
public class TubesML1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Discretize filter;
        // TODO code application logic here
        int fold = 10;
        int fold3 = 3;
        int trainNum,testNum;

        /***dataset 1***/
        fileReader tets = new fileReader("./src/data/iris.arff");
        try {
            tets.read();
        } catch (IOException ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Instances data = tets.getData();
        filter= new Discretize();
        try {
            filter.setInputFormat(data);
        } catch (Exception ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*ID3*/
        Instances discreteData;
        discreteData = Filter.useFilter(data, filter);
        trainNum = discreteData.numInstances()*3/4;
        testNum = discreteData.numInstances()/4;
        
        
        for (int i = 0; i <fold;i++){
            try {
                
                Instances train = discreteData.trainCV(trainNum, i);
                Instances test = discreteData.testCV(testNum, i);
            
                Id3 iTiga = new Id3();
                Evaluation validation = new Evaluation(train);
                try {
                    iTiga.buildClassifier(train);
                    System.out.println(iTiga.toString());
                } catch (Exception ex) {
                    Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
                }
                validation.evaluateModel(iTiga, test);
                System.out.println(validation.toSummaryString());
            } catch (Exception ex) {
                Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*J48*/
        trainNum = data.numInstances()*3/4;
        testNum = data.numInstances()/4;
        J48 jKT = new J48();
        for (int i = 0; i <fold;i++){
            Instances train = data.trainCV(trainNum, i);
            Instances test = data.testCV(testNum, i);         
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
        
        
        /*dataset 2*/
        tets.setFilepath("./src/data/weather.arff");
        try {
            tets.read();
        } catch (IOException ex) {
            Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = new Instances(tets.getData());
        /*ID3*/
        
        discreteData = Filter.useFilter(data, filter);
        trainNum = discreteData.numInstances()*3/4;
        testNum = discreteData.numInstances()/4;
        
        
        for (int i = 0; i <fold3;i++){
            try {
                
                Instances train = discreteData.trainCV(trainNum, i);
                Instances test = discreteData.testCV(testNum, i);
            
                Id3 iTiga = new Id3();
                Evaluation validation = new Evaluation(train);
                try {
                    iTiga.buildClassifier(train);
                    System.out.println(iTiga.toString());
                } catch (Exception ex) {
                    Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
                }
                validation.evaluateModel(iTiga, test);
                System.out.println(validation.toSummaryString());
            } catch (Exception ex) {
                Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(testNum);
        /*J48*/
        trainNum = data.numInstances()*3/4;
        testNum = data.numInstances()/4;
        
        for (int i = 0; i <fold3;i++){
            Instances train = data.trainCV(trainNum, i);
            Instances test = data.testCV(testNum, i);
            try {
                Evaluation validation = new Evaluation(train);
                try {
                    jKT.buildClassifier(data);
                } catch (Exception ex) {
                    Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
                }
                validation.evaluateModel(jKT, test);
                System.out.println(validation.toSummaryString());
            System.out.println(jKT.toString());
            } catch (Exception ex) {
                Logger.getLogger(TubesML1.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        System.out.println(jKT.toString());
    }
    
}
