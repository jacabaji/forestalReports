package forestalreportes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package forestalreportes;


import com.csvreader.CsvReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author georeferenciador
 */
public class archivoInventario {
    
    public String rutaArchivo;
    public String problemasArchivo;
    public List<arbol> arboles;
    public int numArboles;
    public int arbolInsert=0;
    public CsvReader reader;
    
   public archivoInventario(String ruta){
       rutaArchivo = ruta;
      
   }
   
   public boolean pruebaArchivo(){
       reader = null;
       boolean valido=false;
                try {
                        int contador=0;
                        reader = new CsvReader(rutaArchivo);
                          reader.setDelimiter(';');
                          while (reader.readRecord()) {
                          // System.out.println("NUMCOLS: "+reader.getColumnCount());
                          /*  if(reader.getColumnCount()==15){
                              valido=true;
                          }
                           /* if(reader.getColumnCount()){
                            
                            }*/
                          }
                         
                         
                } catch (Exception e) {
                        e.printStackTrace();
                        //valido=false;
                } finally {
                            reader.close();        
                            //valido=false;
            }
         return valido;           
   }
   
   public void principal(){
       reader = null;
       int cuentaArboles=0;
       boolean puedeInsert=true;
       List<arbol> listaTemp = new ArrayList();
       arboles = new ArrayList();
       problemasArchivo= new String();
                try {
                        int contador=0;
                        reader = new CsvReader(rutaArchivo);
                        reader.setDelimiter(';');
                        arbol temp=new arbol();
                        //System.out.print(reader.getColumnCount());
                        //if(reader.getColumnCount()==14){
                        while (reader.readRecord()) {
                            cuentaArboles++;  
                            //System.out.print("cuentaArboles:"+cuentaArboles+";\n");
                            /*System.out.print("\n");
                            for(int i=0;i<reader.getColumnCount();i++){
                                System.out.print(reader.get(i).toString()+"("+i+");");
                            }*/
                           if(cuentaArboles>1){ 
                              
                                if( reader.getColumnCount()==15){
                                   if(!reader.get(0).isEmpty()){
                                       temp.numArb=reader.get(0).toString();
                                       //System.out.print("numArbo:"+temp.numArb);
                                   } else {
                                    problemasArchivo += "El numero del arbol "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }                      
                                   if(!reader.get(1).isEmpty()){
                                        temp.nomEspecie=reader.get(1).toString();
                                        //System.out.print(";nombreComun"+temp.nomEspecie);
                                   } else {
                                    problemasArchivo += "El nombre comun del arbol "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }   
                                   if(!reader.get(2).isEmpty()){
                                        temp.ubicacion=reader.get(2).toString();
                                         // System.out.print(";ubicacion"+ temp.ubicacion);
                                   } else {
                                    problemasArchivo += "La ubicación del arbol "+cuentaArboles+" esta vacio\n";
                                   } 
                                   if(!reader.get(3).isEmpty()){
                                        temp.DAP=reader.get(3).toString();
                                        //System.out.print(";DAP"+temp.DAP);
                                   } else {
                                    problemasArchivo += "El DAP del arbol "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }  
                                   if(!reader.get(4).isEmpty()){
                                         temp.altTotal=reader.get(4).toString();
                                         //System.out.print(";ALTTOTAL"+temp.altTotal);
                                   } else {
                                    problemasArchivo += "La Altura Total "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }  
                                   if(!reader.get(5).isEmpty()){
                                         temp.altCom =reader.get(5).toString();
                                        // System.out.print(";ALTCOM"+temp.altCom );
                                   } else {
                                    problemasArchivo += "La Altura Total "+cuentaArboles+" esta vacio\n";
                                    
                                   } 
                                   if(!reader.get(6).isEmpty()){
                                         temp.diamCopa1=reader.get(6).toString();
                                        // System.out.print(";DIAMCOPA1"+temp.diamCopa1);
                                   } else {
                                    problemasArchivo += "La Diametro Menor de Copa "+cuentaArboles+" esta vacio\n";
                                   } 
                                   if(!reader.get(7).isEmpty()){
                                         temp.diamCopa2=reader.get(7).toString();
                                         //System.out.print(";DIAMCOPA2"+temp.diamCopa2);
                                   } else {
                                    problemasArchivo += "La Diametro Mayor de Copa "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(!reader.get(8).isEmpty()){
                                         temp.diamBasal=reader.get(8).toString();
                                         //System.out.print(";DIAMBASAL"+temp.diamBasal);
                                   } else {
                                    problemasArchivo += "La Diametro Basal "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(!reader.get(9).isEmpty()){
                                         temp.estadoFisico=reader.get(9).toString();
                                         //System.out.print(";ESTADOFISICO"+ temp.estadoFisico);
                                   } else {
                                    problemasArchivo += "El estado Fisico "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(!reader.get(10).isEmpty()){
                                         temp.estadoSanitario=reader.get(10).toString();
                                         //System.out.print(";ESTADOSANITARIO"+ temp.estadoSanitario);
                                   } else {
                                    problemasArchivo += "El estado Sanitario "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(!reader.get(11).isEmpty()){
                                        temp.observaciones=reader.get(11).toString();
                                       // System.out.print(";OBSERVACIONES"+temp.observaciones);
                                   } else {
                                    problemasArchivo += "El observaciones "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(!reader.get(12).isEmpty()){
                                        temp.foto1=reader.get(12).toString();
                                        //System.out.print(";FOTO1"+temp.foto1);
                                   } else {
                                    problemasArchivo += "El foto 1 "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }  
                                   if(!reader.get(13).isEmpty()){
                                        temp.foto2=reader.get(13);
                                        //System.out.print(";FOTO2"+temp.foto2);
                                   } else {
                                    problemasArchivo += "El foto 2 "+cuentaArboles+" esta vacio\n";
                                    puedeInsert=false;
                                   }  
                                   if(!reader.get(14).isEmpty()){
                                         temp.concepto=reader.get(14);
                                         
                                         //System.out.print(";CONCEPTO"+temp.concepto);
                                         
                                   } else {
                                    problemasArchivo += "El concepto "+cuentaArboles+" esta vacio\n";
                                   }  
                                   if(puedeInsert){
                                       //System.out.print("insertando:"+cuentaArboles+";"+puedeInsert+"\n");
                                        arboles.add(temp);
                                       }
                                     
                                     
                                     
                                }else {
                                        problemasArchivo+="El arbol "+cuentaArboles+" no tiene 15 columnas\\n";                                
                                }
                                
                                puedeInsert=true;
                                temp= new arbol();
                                
                            } 
                           
                          }
                        //System.out.print(problemasArchivo);
                       
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                            reader.close();        
            }
                
   }
   /*public void principal2(){
       try { 
          problemasArchivo = new String();
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(rutaArchivo));
        String nombreHoja = workbook.getSheetName(0);
        arbol temp= new arbol();
        arboles = new ArrayList();
        boolean celdaValida=false;
        double celdaNumero=0;
        String celdaCadena= new String();
        boolean banderaArb = false,puedeInsert=true;
        int numCol=0, numFilas=0,numArb=0;
        int cuenta=0;
         HSSFSheet sheet= workbook.getSheet(nombreHoja);
         for (Row r : sheet){
             
           numCol=0;
             for (Cell c: r)
            {
             if(c!=null){
                 if(c.getCellType()==Cell.CELL_TYPE_NUMERIC){
                     celdaNumero = c.getNumericCellValue();
                     /*if(celdaNumero==0){
                         problemasArchivo += "El valor es 0 del arbol "+numFilas+" en la columna numero"+numCol+"\n";
                     }*/
              /*       celdaValida=true;
                 } else {
                     celdaCadena = c.getStringCellValue();
                     /*if(celdaCadena.isEmpty()){
                         problemasArchivo += "No hay valores del arbol "+numFilas+" en la columna numero"+numCol+"\n";
                     }*/
               /*      celdaValida=true;
                 }
                 try{
                
                if(banderaArb && numFilas > 1){
                    System.out.println(numCol+";"+numFilas+";"+c.getCellType()+";");
                    switch(numCol) {
                        case 1: 
                            cuenta++;
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                                    temp.nomEspecie = c.getStringCellValue();
                                    celdaValida=false;
                                    //System.out.println(numCol+";"+c.getStringCellValue()+";");
                                } else {
                                    problemasArchivo += "No hay nombre del arbol "+numFilas+"\n";
                                    puedeInsert=false;
                                }
                            } else {
                              problemasArchivo += "La celda no tiene formato de texto"+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 2:
                            cuenta++;
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                               temp.ubicacion = c.getStringCellValue();
                               celdaValida=false;
                               //System.out.println(numCol+";"+c.getStringCellValue()+";");
                                } else {
                                   problemasArchivo += "No hay ubicación del arbol "+numFilas+"\n";
                                   temp.ubicacion = "";
                                   //puedeInsert=false;
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato de texto"+numFilas+"\n";
                               temp.ubicacion = "";
                            }
                            break;
                        case 3:
                            cuenta++;
                            //System.out.println("DAP"+c.getCellType());
                            if(celdaValida){
                                if(celdaNumero>0){
                               temp.DAP = c.getNumericCellValue();
                               celdaValida=false;
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                } else {
                                   problemasArchivo += "El valor del altura Total no es consistente del arbol "+numFilas+"\n";
                                   puedeInsert=false;
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 4:
                            cuenta++;
                            if(celdaValida){
                                if(celdaNumero>0){
                                temp.altTotal = c.getNumericCellValue();
                                celdaValida=false;
                                //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                 } else {
                                    problemasArchivo += "El valor del altura Total no es consistente del arbol "+numFilas+"\n";
                                    puedeInsert=false;
                                }
                            } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 5: 
                            cuenta++;
                            if(celdaValida){
                                if(celdaNumero>0){
                                temp.altCom = c.getNumericCellValue();
                                celdaValida=false;
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                } else {
                                   problemasArchivo += "El valor del altura Comercial no es consistente del arbol "+numFilas+"\n";
                                   puedeInsert=false;
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            cuenta++;
                            break;
                        case 6: 
                            if(celdaValida){
                                if(celdaNumero>0){
                                    temp.diamCopa1 = c.getNumericCellValue();
                                    celdaValida=false;
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                } else {
                                   problemasArchivo += "El valor del altura Diametro de copa menor no es consistente del arbol "+numFilas+"\n";
                                   puedeInsert=false;
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 7: 
                            cuenta++;
                            if(celdaValida){
                                if(celdaNumero>0){
                                    temp.diamCopa2 = c.getNumericCellValue();
                                    celdaValida=false;
                                //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                 } else {
                                    problemasArchivo += "El valor del altura Diametro de copa meyor no es consistente del arbol "+numFilas+"\n";
                                    puedeInsert=false;
                                }
                            } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 8: 
                            cuenta++;
                            if(celdaValida){
                                if(celdaNumero>0){
                                    temp.diamBasal = c.getNumericCellValue();
                                    celdaValida=false;
                                //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                                 } else {
                                   problemasArchivo += "El valor del altura Diametro Basal no es consistente del arbol "+numFilas+"\n";
                                   puedeInsert=false;
                                }
                            } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                              puedeInsert=false;
                            }
                            break;
                        case 9:
                            cuenta++;
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                                    temp.estadoFisico = c.getStringCellValue();
                                    celdaValida=false;
                               //System.out.println(numCol+";"+c.getStringCellValue()+";");
                               } else {
                                   problemasArchivo += "No introdujo estado fisico del arbol"+numFilas+"\n";
                                   //puedeInsert=false;
                                   temp.estadoFisico ="";
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato de texto"+numFilas+"\n";
                              temp.estadoFisico = "";
                            }
                            break;
                        case 10: 
                             cuenta++;
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                               temp.estadoSanitario = c.getStringCellValue();
                                celdaValida=false;
                               //System.out.println(numCol+";"+c.getStringCellValue()+";");
                               } else {
                                   problemasArchivo += "No introdujo estado sanitario del arbol"+numFilas+"\n";
                                   temp.estadoSanitario = "";
                                   //puedeInsert=false;
                               }
                             } else {
                              problemasArchivo += "La celda no tiene formato de texto"+numFilas+"\n";
                              temp.estadoSanitario="";
                            }
                            break;
                        case 11: 
                           cuenta++;
                           //System.out.println(numCol+";"+c.getCellType()+";");
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                                temp.observaciones = c.getStringCellValue();
                                   celdaValida=false;
                                //System.out.println(numCol+";"+c.getStringCellValue()+";");
                                } else {
                                    problemasArchivo += "No introdujo observaciones del arbol "+numFilas+"\n";
                                    //TODO: se debe habilitar cuando este revisado complemtanmente
                                    //puedeInsert=false;
                                    temp.observaciones = "";
                                }
                            } else {
                              problemasArchivo += "La celda no tiene formato de texto"+numFilas+"\n";
                              //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                              temp.observaciones = "";
                            }
                            break;
                       
                        case 12: 
                            cuenta++;
                            //System.out.println("Arbol12 "+numFilas+" puede insertar "+puedeInsert);
                            if(celdaValida){
                                if(celdaNumero>0){
                               temp.foto1 = (int) c.getNumericCellValue();
                                celdaValida=false;
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                               } else {
                                   problemasArchivo += "El numero de la foto 1 es inconsistente "+numFilas+"\n";
                                     puedeInsert=false;
                               }
                            } else {
                                problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                                puedeInsert=false;
                            }
                            break;
                        case 13: 
                            cuenta++;
                            //System.out.println("Arbol12 "+numFilas+" puede insertar "+puedeInsert);
                            if(celdaValida){
                                if(celdaNumero>0){
                               temp.foto2 = (int) c.getNumericCellValue();
                                celdaValida=false;
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                               } else {
                                   problemasArchivo += "El numero de la foto 1 es inconsistente "+numFilas+"\n";
                                     puedeInsert=false;
                               }
                            } else {
                                problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                                puedeInsert=false;
                            }
                            break;
                        case 14: 
                            cuenta++;
                            //System.out.println("Arbol13 "+numFilas+" puede insertar "+puedeInsert);
                            if(celdaValida){
                                if(!celdaCadena.isEmpty()){
                               temp.concepto= c.getStringCellValue();
                                celdaValida=false;
                                //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                               if(puedeInsert){
                                   //System.out.println(temp.toCadena()+"\n");
                               arboles.add(temp);

                               }
                               //temp.foto2 = c.getStringCellValue();
                               //System.out.println("Content:"+temp.numArb);
                               //System.out.println(numCol+";"+c.getNumericCellValue()+";");
                               } else {
                                   problemasArchivo += "El numero de la foto 2 es inconsistente "+numFilas+"\n";
                               }
                            } else {
                              problemasArchivo += "La celda no tiene formato "+numFilas+"\n";
                            }
                            break;
                        default: 
                            problemasArchivo += "Columna "+numCol+" o esta fuera del rango de columnas;";
                            break;
                        }
                    //System.out.println(c.+";");
                    //System.out.println(c.);
                    }
               
                //System.out.println("COLUMNA:"+numCol);
                //System.out.println("NUMERIC CELL--> " + c.getNumericCellValue());
                if((numCol==0) && (c.getCellType()==Cell.CELL_TYPE_NUMERIC)){
                    numArb++;
                    banderaArb = true;
                    temp= new arbol();
                    System.out.println("NUMERIC CELL--> " + c.getNumericCellValue());
                   
                    temp.numArb = (int) c.getNumericCellValue();
                    }
               
              }catch(Exception e){e.printStackTrace();e=null;}
              
             }
             
             numCol++;
             
            //if(numFilas==1){numCol++;}
            //
             
            }
            //MENSAJE PRUEBA----->
            //System.out.println(temp.toCadena()+"\n");
             //System.out.println(numFilas+";"+cuenta);
             cuenta=0;
            banderaArb=false;
            celdaValida=false;
            numFilas++;
            puedeInsert=true;
           
        }
         numArboles = numArb;
       System.out.println("Numero de Arboles:"+arboles.size());
       
       } catch (Exception e){
           System.out.println("problema fue :"+e.toString());
       }
       
       
   }
   */
   public void mostratArchivo(){
      if(!arboles.isEmpty()){
            for(arbol u:arboles){
                System.out.println(u.toCadena()+"\n");
            }
      }
   
   }
  
}
