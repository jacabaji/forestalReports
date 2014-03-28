/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forestalreportes;

/**
 *
 * @author georeferenciador
 */
public class arbol {
    public int numArb;
    public String nomEspecie;
    public String ubicacion;
    public double DAP;
    public double altTotal;
    public double altCom;
    public double diamCopa1;
    public double diamCopa2;
    public double diamBasal;
    public String estadoFisico;
    public String estadoSanitario;
    public String observaciones;
    public int foto1;
    public int foto2;
    public String concepto;
    
    
    public arbol(){
         numArb=0;
         nomEspecie=new String();
         ubicacion=new String();
         DAP=0;
         altTotal=0;
         altCom=0;
         diamCopa1=0;
         diamCopa2=0;
         diamBasal=0;
         estadoFisico=new String();
         estadoSanitario=new String();
         observaciones=new String();
         foto1=0;
         foto2=0;
         concepto=new String();
    }
    
    public void llena(){
        numArb=1;
         nomEspecie="uno";
         ubicacion="dos";
         DAP=2;
         altTotal=3;
         altCom=4;
         diamCopa1=5;
         diamCopa2=6;
         diamBasal=7;
         estadoFisico="tres";
         estadoSanitario="cuatro";
         observaciones="cinco";
         foto1=4;
         foto2=5;
    }
    public String toCadena(){
        
        return numArb+";"+nomEspecie+";"+ubicacion+";"+DAP+";"+altTotal+";"+altCom+";"+diamCopa1
                +";"+diamCopa2+";"+diamBasal+";"+estadoFisico+";"+estadoSanitario+";"+observaciones
                +";"+foto1+";"+foto2+";"+concepto;
        //return nomEspecie+";"+ubicacion+estadoFisico+";"+estadoSanitario+";"+observaciones+";"+foto1+";"+foto2;
       }
}
