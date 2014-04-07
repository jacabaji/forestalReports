/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forestalreportes;

import java.util.List;

/**
 *
 * @author JBarajas
 */
public class arbolProcesado {
    private String numArb;
    private String nomEspecie;
    private String nomCientifico;
    private String ubicacion; //Direccion
    private String DAP;
    private String volumen;
    private String altTotal;
    private String altCom;
    private String diamCopa1;
    private String diamCopa2;
    private String diamBasal;
    private String estadoFisico;
    private String estadoSanitario;
    private String observaciones;
    private String conceptoTecnico;
  
    private String causasIntervencion;
    private String foto1;
    private String foto2;
    
   public arbolProcesado(String numarb,String nomespecie,String nomcien,String dap,String altcom,
           String alttotal,String estadofisico,String estadosanitario,String obs,
           String foto1, String foto2,String conte,String caint){
   this.setNumArb(numarb);
   this.setNomEspecie(nomespecie);
   this.setNomCientifico(nomcien);
   this.setDAP(dap);
   this.setAltCom(altcom);
   this.setAltTotal(alttotal);
   this.setEstadoFisico(estadofisico);
   this.setEstadoSanitario(estadosanitario);
   this.setObservaciones(obs);
   this.setFoto1(foto1);
   this.setFoto2(foto2);
   this.setConceptoTecnico(conte);
   this.setCausasIntervencion(caint);
   }
   public String getConceptoTecnico() {
        return conceptoTecnico;
    }

    public void setConceptoTecnico(String conceptoTecnico) {
        this.conceptoTecnico = conceptoTecnico;
    }

    public String getCausasIntervencion() {
        return causasIntervencion;
    }

    public void setCausasIntervencion(String causasIntervencion) {
        this.causasIntervencion = causasIntervencion;
    }
    public String toCadena(){
        
        return numArb+";"+nomEspecie+";"+ubicacion+";"+DAP+";"+altTotal+";"+altCom+";"+diamCopa1
                +";"+diamCopa2+";"+diamBasal+";"+estadoFisico+";"+estadoSanitario+";"+observaciones
                +";"+foto1+";"+foto2;
        //return nomEspecie+";"+ubicacion+estadoFisico+";"+estadoSanitario+";"+observaciones+";"+foto1+";"+foto2;
       }
    
    public String getNumArb() {
        return numArb;
    }

    public void setNumArb(String numArb) {
        this.numArb = numArb;
    }

    public String getNomEspecie() {
        return nomEspecie;
    }

    public void setNomEspecie(String nomEspecie) {
        this.nomEspecie = nomEspecie;
    }

    public String getNomCientifico() {
        return nomCientifico;
    }

    public void setNomCientifico(String nomCientifico) {
        this.nomCientifico = nomCientifico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDAP() {
        return DAP;
    }

    public void setDAP(String DAP) {
        this.DAP = DAP;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getAltTotal() {
        return altTotal;
    }

    public void setAltTotal(String altTotal) {
        this.altTotal = altTotal;
    }

    public String getAltCom() {
        return altCom;
    }

    public void setAltCom(String altCom) {
        this.altCom = altCom;
    }

    public String getDiamCopa1() {
        return diamCopa1;
    }

    public void setDiamCopa1(String diamCopa1) {
        this.diamCopa1 = diamCopa1;
    }

    public String getDiamCopa2() {
        return diamCopa2;
    }

    public void setDiamCopa2(String diamCopa2) {
        this.diamCopa2 = diamCopa2;
    }

    public String getDiamBasal() {
        return diamBasal;
    }

    public void setDiamBasal(String diamBasal) {
        this.diamBasal = diamBasal;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public String getEstadoSanitario() {
        return estadoSanitario;
    }

    public void setEstadoSanitario(String estadoSanitario) {
        this.estadoSanitario = estadoSanitario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }
    
    

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }
}
