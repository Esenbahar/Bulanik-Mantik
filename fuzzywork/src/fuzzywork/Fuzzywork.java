/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzywork;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

/**
 *
 * @author yenib
 */
public class Fuzzywork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
         
        System.out.print("Su Miktarı:");
        double sumiktari=in.nextDouble();
        System.out.print("Bugday Tohumu Miktarı:");
        double bugdaytohumu=in.nextDouble();
        System.out.print("Güneşli Saat Miktarı:");
        double guneslisaatmiktari=in.nextDouble();
        
        
        Tarla tarla=new Tarla(sumiktari,bugdaytohumu,guneslisaatmiktari);
        JFuzzyChart.get().chart(tarla.getFis());
       
       for(Rule r :tarla.getFis().getFunctionBlock("model").getFuzzyRuleBlock("kurallarblock1")){
       
           if(r.getDegreeOfSupport()>0){
                   System.out.println(r);
               }
      }
       
   }
    
}