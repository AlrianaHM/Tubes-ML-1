/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.ml.pkg1;
import weka.classifiers.trees.Id3;
import weka.core.Instances;
/**
 *
 * @author LUCKY
 */
public class myID3 extends Id3 {

    @Override
    public void buildClassifier(Instances data) throws Exception {
        getCapabilities().testWithFail(data); //To change body of generated methods, choose Tools | Templates.
        data = new Instances(data);
        data.deleteWithMissingClass();
        
        makeTree(data);
    }
        
    private void makeTree(Instances data){
        
    }
}
