/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forestalreportes;

import java.util.List;
import com.csvreader.CsvReader;
import java.util.ArrayList;

/**
 *
 * @author JBarajas
 */
public class procesandoArchivo {
        public List<arbol> arbolesNP;
        public List<arbolProcesado> arbolesP;
        public List<estadoArbol> estadoFisicoLista;
        public List<estadoArbol> estadoSanitarioLista;
        public List<estadoArbol> estadoObserLista;
        public List<nombreCientifico> nombreCientLista;
        public List<MatrizConcepto> conceptosLista;
        public String rutaLocal;
        public String problemasContenido;
       
        public procesandoArchivo(List<arbol> arbolesE){
         //public procesandoArchivo(){
                arbolesNP = arbolesE;
                
                estadoFisicoLista=getArchivoEstados("C:\\software\\forestalReports\\estadoFisico.csv");
                estadoSanitarioLista=getArchivoEstados("C:\\software\\forestalReports\\estadoSanitario.csv");
                estadoObserLista = getArchivoEstados("C:\\software\\forestalReports\\observaciones.csv");
                getArchivoNomCient("C:\\software\\forestalReports\\nombreCientifico.csv");
                getArchivoMatriz("C:\\software\\forestalReports\\conceptosTecnicos.csv");
                 //System.out.println(conceptosLista.toString());
        }
        
        public void proceso(){
              problemasContenido= new String();
                           //arbolProcesado tempArbolP=new arbolProcesado();
             arbolesP = new ArrayList<arbolProcesado>();
             int numlinea=0;
             
             System.out.println(arbolesP.size()+"\n");
             for(arbol un:arbolesNP){
                 numlinea++;
                 String esfis = new String();
                 String essan = new String();
                 String obs = new String();
                 String foto1=new String();
                 String foto2=new String();
                 String nomCien=new String();
                 MatrizConcepto concCa=new MatrizConcepto();
                 foto1="C:\\software\\fotos\\"+un.foto1+".jpg";
                 foto2="C:\\software\\fotos\\"+un.foto2+".jpg";
                 esfis = procesaEstados(un.estadoFisico, estadoFisicoLista,numlinea);
                 essan = procesaEstados(un.estadoSanitario, estadoSanitarioLista,numlinea);
                 obs=procesaEstados(un.observaciones, estadoObserLista,numlinea);
                 nomCien=buscarNomCient(un.nomEspecie);
                 concCa=buscaConcepto(un.concepto, numlinea);
                 
                 // System.out.println(concCa.conceptoTecnico+"\n");
                 // System.out.println(concCa.causasIntervencion+"\n");
                 //c.getStringCellValue()
                 arbolProcesado tempArbolP=new arbolProcesado( String.valueOf(un.numArb),
                                                                un.nomEspecie,nomCien,String.valueOf(un.DAP),
                                                                String.valueOf(un.altCom),String.valueOf(un.altTotal),
                                                                esfis,essan,obs,
                                                                foto1,foto2,concCa.conceptoTecnico,
                                                                concCa.causasIntervencion);
               
                 arbolesP.add(tempArbolP);
                System.out.print(tempArbolP.toCadena()+"\n");
               }
            if(!arbolesP.isEmpty()){
             generarReporte gr= new generarReporte();
             gr.generar(arbolesP);
            } else {
            System.out.print("Problemas Con el archivo Error 1");
            }
           /* listaEstadoFNP = arbolesNP.get(1).estadoFisico.split(",");
            for(int i=0;i<listaEstadoFNP.length;i++){
                estadoFc += buscarSiglaLista(listaEstadoFNP[i],estadoFisicoLista)+",";
                }
            tempArbolP.estadoFisico = estadoFc;*/
            //System.out.print(estadoFc);
        }
        
        public String procesaEstados(String estado,List<estadoArbol> listas, int numli ){
            String cp=new String();
            String listaEstadoFNP [];
            listaEstadoFNP = estado.split(",");
            for(int i=0;i<listaEstadoFNP.length;i++){
                if(!buscarSiglaLista(listaEstadoFNP[i],listas,numli).isEmpty()){
                cp += buscarSiglaLista(listaEstadoFNP[i],listas,numli)+",";
                }
                
                
                }
           
            return cp;
        }
        
        
       
        public List<estadoArbol> getArchivoEstados(String ruta ){
            CsvReader reader = null;
            List<estadoArbol> listaTemp = new ArrayList();
                try {
                        int contador=0;
                        reader = new CsvReader(ruta);
                        reader.setDelimiter(';');
                        estadoArbol temp=new estadoArbol();
                        
                        while (reader.readRecord()) {
                            temp.sigla = reader.get(0);
                            temp.nombre =reader.get(1);
                            listaTemp.add(temp);
                            
                            temp = new estadoArbol();
                          } // end while - recorrido del csv
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                            reader.close();        
            }
                return listaTemp;
    }
        
       public void getArchivoNomCient(String ruta ){
            CsvReader reader = null;
            List<nombreCientifico> listaTemp = new ArrayList();
                try {
                        int contador=0;
                        reader = new CsvReader(ruta);
                          reader.setDelimiter(';');
                        nombreCientifico temp=new nombreCientifico();
                        
                        while (reader.readRecord()) {
                            temp.nombreVulgar= verificaCampo(reader.get(0));
                            temp.nombreCien= verificaCampo(reader.get(1));
                            
                           
                            //System.out.print(temp.nombreVulgar + "; " +temp.nombreCien + ";"+"\n");
                            listaTemp.add(temp);
                            temp = new nombreCientifico();
                          } // end while - recorrido del csv
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                            reader.close();        
            }
                nombreCientLista = listaTemp;
    }
        
       public void getArchivoMatriz(String ruta ){
            CsvReader reader = null;
            List<MatrizConcepto> listaTemp = new ArrayList();
                try {
                        int contador=0;
                        reader = new CsvReader(ruta);
                          reader.setDelimiter(';');
                        MatrizConcepto temp=new MatrizConcepto();
                         //System.out.print(reader.getColumnCount());
                        
                        while (reader.readRecord()) {
                             //System.out.print("tedxto:"+reader.get(0));
                            temp.sigla=reader.get(0);
                                temp.conceptoTecnico=reader.get(1);
                            temp.causasIntervencion=reader.get(2);
                            
                            listaTemp.add(temp);
                            temp = new MatrizConcepto();
                          } // end while - recorrido del csv
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                            reader.close();        
            }
                conceptosLista = listaTemp;
    }
         public String verificaCampo(String campo){
             String resultado=new String();
             if(campo.isEmpty()){
                resultado="No Aplica";
                    //System.out.print("No Aplica");
             } else {
                 resultado = campo;
             }
             return resultado;
         }
        
        public void mostrarLista(List<estadoArbol> muestra){
            for (estadoArbol u:muestra){
                  System.out.print(u.sigla + "; " + u.nombre+"\n");
                    
            }
        }
        
        
        
       /* public void mostrarListaNC(){
            for (nombreCientifico u:nombreCientLista){
                  System.out.print(u.nombreCien + ";"+u.familia + "; " + u.genero+";"+u.especie+"\n");
                    
            }
        }*/
        
        public MatrizConcepto buscaConcepto(String con, int numli){
            MatrizConcepto temp=new MatrizConcepto();
            for(MatrizConcepto u:conceptosLista){
                if(u.sigla.equals(con)){
                    temp=u;
                }
            }
            if(temp.vacio()){
                problemasContenido+="No se encuentra el concepto tecnico del arbol"+numli+"\n";
            }
            return temp;
        }
        
        
        public String buscarSiglaLista(String sentencia, List<estadoArbol> lista, int numli){
            estadoArbol temp= new estadoArbol();
            String nombre = new String();
            
            for(estadoArbol u:lista){
                if(u.sigla.compareTo(sentencia)==0){
                    nombre=u.nombre;
                    //return u.nombre;
                }       
            }
            if(nombre.isEmpty()){
                problemasContenido+="No se encuentra la sigla"+sentencia+" del arbol"+numli+"\n";
            }
            return nombre;
        }
        
       
        public String buscarNomCient(String nombreComun){
           nombreCientifico temp= new nombreCientifico();
            
           String nombreCientresult = new String();
            
            for(nombreCientifico u:nombreCientLista){
                
                if(u.nombreVulgar.equals(nombreComun)){
                   nombreCientresult= u.nombreCien;                   
                } 
            }
            return nombreCientresult;
        }
}
