/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzywork;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author yenib
 */
public class Tarla {
      private FIS fis;
       private double sumiktari;
       private double bugdaytohumu;
       private double guneslisaatmiktari;
      

       public Tarla (double sumiktari, double bugdaytohumu, double guneslisaatmiktari)throws URISyntaxException{
           this.sumiktari = sumiktari;
           this.bugdaytohumu = bugdaytohumu;
           this.guneslisaatmiktari = guneslisaatmiktari;
           
           
           File dosya=new File(getClass().getResource("Model.fcl").toURI());
           fis=FIS.load(dosya.getPath(),true);
           fis.setVariable("sumiktari", sumiktari);
           fis.setVariable("bugdaytohumu", bugdaytohumu);
           fis.setVariable("guneslisaatmiktari", guneslisaatmiktari);
           fis.evaluate();
           System.out.println ("Çıkan Bugday:" + fis.getVariable ("cikanbugday").getValue ());

       }
       
        public FIS getFis(){
        return this.fis;
        }
        
        public Tarla () throws URISyntaxException{
            File dosya=new File(getClass().getResource("Model.fcl").toURI());
            fis=FIS.load(dosya.getPath(),true);
        }
          @Override
    public String toString(){
        return "Su miktari "+sumiktari+"\nBugday Tohumu "+bugdaytohumu+"\nGünesli saat miktari "+guneslisaatmiktari+"\n"+"Çıkan bugday "+fis.getVariable("cikanbugday").getValue();
      }
    
     public double sumiktari() {
        return sumiktari;
    }

    public double bugdaytohumu() {
        return bugdaytohumu;
    }
    
    public double guneslisaatmiktari() {
        return guneslisaatmiktari;
    }
    
}
