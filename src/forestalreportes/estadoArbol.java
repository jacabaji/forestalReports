package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author JBarajas
 */
public class estadoArbol {
    public String sigla;
    public String nombre;
    
    public estadoArbol(){
        sigla="";
        nombre="";
    }
    
    public boolean vacio(){
        boolean temp=false;
        if (this.sigla.isEmpty() || this.nombre.isEmpty()){
            temp=true;
        }
        return temp;
    }
    
}
