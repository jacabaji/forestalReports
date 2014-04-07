package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import com.csvreader.CsvReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
        public int numArb;
       
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
             boolean puedeGenerar=true;
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
                 if(!un.observaciones.isEmpty()){
                    obs=procesaEstados(un.observaciones, estadoObserLista,numlinea);
                 } else {
                     problemasContenido+="No hay valores de observaciones en el arbol "+numlinea+"\n";
                 }
                 //System.out.println(un.nomEspecie+"\n");
                 nomCien=buscarNomCient(un.nomEspecie,numlinea);
                 concCa=buscaConcepto(un.concepto, numlinea);
                 if(!un.DAP.isEmpty() && !un.altTotal.isEmpty() && !un.altCom.isEmpty() &&
                         !un.diamCopa1.isEmpty() &&!un.diamCopa2.isEmpty() &&!un.diamBasal.isEmpty()){
                     double dap=0,dapaux,altto=0,altcom=0,diam1=0,diam2=0,diamb=0,volumen=0;
                    //System.out.println(numlinea+"\n");
                    dapaux=obtieneValor(un.DAP);
                    altcom=obtieneValor(un.altCom);
                    altto=obtieneValor(un.altTotal);
                    diam1=obtieneValor(un.diamCopa1);
                    diam2=obtieneValor(un.diamCopa2);
                    diamb=obtieneValor(un.diamBasal);
                    dap=(dapaux*dapaux)*(3.14);
                    volumen=dap*(altcom)*(0.7)*(0.25);
                    
                    if(dap<diam1 || dap<diam2){
                        puedeGenerar=false;
                        problemasContenido+="El DAP no puede ser menor que los diametros de copa "+numlinea+"\n";
                    }
                    
                    if(altcom>altto){
                       puedeGenerar=false;
                       problemasContenido+="La altura comercial no puede ser mayor que la total "+numlinea+"\n";
                    }
                 }
                 // System.out.println(concCa.conceptoTecnico+"\n");
                  
                 //c.getStringCellValue()
                if(puedeGenerar){
                    System.out.println(numlinea+";"+puedeGenerar+"\n");
                 arbolProcesado tempArbolP=new arbolProcesado( un.numArb,
                                                                un.nomEspecie,nomCien,un.DAP,
                                                                un.altCom,un.altTotal,
                                                                esfis,essan,obs,
                                                                foto1,foto2,concCa.conceptoTecnico,
                                                                concCa.causasIntervencion);
               
                 arbolesP.add(tempArbolP);
                //System.out.print(tempArbolP.toCadena()+"\n");
                }
                puedeGenerar=true;
               }
           
           /* listaEstadoFNP = arbolesNP.get(1).estadoFisico.split(",");
            for(int i=0;i<listaEstadoFNP.length;i++){
                estadoFc += buscarSiglaLista(listaEstadoFNP[i],estadoFisicoLista)+",";
                }
            tempArbolP.estadoFisico = estadoFc;*/
            //System.out.print(estadoFc);
        }
        
        public void generarReporteArbol(){
         if(!arbolesP.isEmpty()){
             generarReporte gr= new generarReporte();
             this.numArb=this.arbolesP.size();
             gr.generar(arbolesP);
            } else {
            System.out.print("Problemas Con el archivo Error 1");
            }
        }
        
        public double obtieneValor(String val){
            double temp=0;
            String cad= new String();
            if(val.contains(",")){
                   cad = val.replace(",", ".");
                   //System.out.print(cad);
                   temp=Double.parseDouble(cad);
            } else {
                temp=Double.parseDouble(val);
            }
            return temp;
        }
        public String procesaEstados(String estado,List<estadoArbol> listas, int numli ){
            String cp=new String();
            String cadenaTemp=new String();
            String listaEstadoFNP [];
            listaEstadoFNP = estado.split(",");
            for(int i=0;i<listaEstadoFNP.length;i++){
                cadenaTemp=quitarEspacios(listaEstadoFNP[i]);
                System.out.print(cadenaTemp+";");
                if(!cadenaTemp.isEmpty()){
                    if(!buscarSiglaLista(cadenaTemp,listas,numli).isEmpty()){

                    cp += buscarSiglaLista(cadenaTemp,listas,numli)+",";
                    } else {
                    problemasContenido+="No encontro "+cadenaTemp+" en el arbol "+numli+"\n";
                    }
                }/* else {
                    problemasContenido+="No hay valor en el arbol "+numli+"\n";
                }*/
                
                }
            System.out.print("\n");
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
            String cadenaTemp=new String();
            cadenaTemp=quitarEspacios(con);
            for(MatrizConcepto u:conceptosLista){
                
                if(u.sigla.equals(con)){
                    temp=u;
                }
            }
            if(temp.vacio()){
                problemasContenido+="No se encuentra el concepto tecnico del arbol "+numli+"\n";
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
                problemasContenido+="No se encuentra la sigla "+sentencia+" del arbol "+numli+"\n";
            }
            return nombre;
        }
        
       
        public String buscarNomCient(String nombreComun, int numli){
           nombreCientifico temp= new nombreCientifico();
            
           String nombreCientresult = new String();
            
            for(nombreCientifico u:nombreCientLista){
                
                if(u.nombreVulgar.equals(nombreComun)){
                   nombreCientresult= u.nombreCien;                   
                } 
            }
            
            if(nombreCientresult.isEmpty()){
                problemasContenido+=" No se encuentra nombre comun de "+nombreComun+" en el arbol "+numli+"\n";
                
            }
            return nombreCientresult;
        }
        
        public String quitarEspacios(String cadena){
        String result= new String();
              
        StringTokenizer tokenizer = new StringTokenizer(cadena);
        StringBuilder cadenaSinEspacios = new StringBuilder();
        if(cadena.contains(" ")){
            while(tokenizer.hasMoreTokens()){
                cadenaSinEspacios.append(tokenizer.nextToken());
            }
            result= cadenaSinEspacios.toString();
        } else {
            result=cadena;
        
        }
 
        return result;
   
        }
}
