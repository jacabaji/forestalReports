package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BJ
 */
public class MatrizConcepto {
    public String sigla;
    public String conceptoTecnico;
    public String causasIntervencion;
    
    public MatrizConcepto(){
    
    this.sigla = new String();
    this.conceptoTecnico = new String();
    this.causasIntervencion = new String();
    }
    
    public boolean vacio(){
        boolean temp=false;
        if (this.sigla.isEmpty() || this.conceptoTecnico.isEmpty()||this.causasIntervencion.isEmpty()){
            temp=true;
        }
        return temp;
    }
}
