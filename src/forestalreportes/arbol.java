package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author georeferenciador
 */
public class arbol {
    public String numArb;
    public String nomEspecie;
    public String ubicacion;
    public String DAP;
    public String altTotal;
    public String altCom;
    public String diamCopa1;
    public String diamCopa2;
    public String diamBasal;
    public String estadoFisico;
    public String estadoSanitario;
    public String observaciones;
    public String foto1;
    public String foto2;
    public String concepto;
    
    
    public arbol(){
         numArb=new String();
         nomEspecie=new String();
         ubicacion=new String();
         DAP=new String();
         altTotal=new String();
         altCom=new String();
         diamCopa1=new String();
         diamCopa2=new String();
         diamBasal=new String();
         estadoFisico=new String();
         estadoSanitario=new String();
         observaciones=new String();
         foto1=new String();
         foto2=new String();
         concepto=new String();
    }
    
        public String toCadena(){
        
        return numArb+";"+nomEspecie+";"+ubicacion+";"+DAP+";"+altTotal+";"+altCom+";"+diamCopa1
                +";"+diamCopa2+";"+diamBasal+";"+estadoFisico+";"+estadoSanitario+";"+observaciones
                +";"+foto1+";"+foto2+";"+concepto;
        //return nomEspecie+";"+ubicacion+estadoFisico+";"+estadoSanitario+";"+observaciones+";"+foto1+";"+foto2;
       }
}
