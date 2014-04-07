/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forestalreportes;


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
    
   public archivoInventario(String ruta){
       rutaArchivo = ruta;
      
   }
   public void principal(){
       try { 
          problemasArchivo = new String();
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(rutaArchivo));
        String nombreHoja = workbook.getSheetName(0);
        arbol temp= new arbol();
        arboles = new ArrayList();
        boolean banderaArb = false,puedeInsert=true;
        int numCol=0, numFilas=0,numArb=0;
        int cuenta=0;
         HSSFSheet sheet= workbook.getSheet(nombreHoja);
         for (Row r : sheet){
           numCol=0;
             for (Cell c: r)
            {
             if(c!=null){
              try{
                if(banderaArb){
                    switch(numCol) {
                        case 1: 
                            cuenta++;
                            if(c.getCellType()>0){
                                if(!c.getStringCellValue().isEmpty()){
                                    temp.nomEspecie = c.getStringCellValue();
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
                            if(c.getCellType()>0){
                                if(!c.getStringCellValue().isEmpty()){
                               temp.ubicacion = c.getStringCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                               temp.DAP = c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                                temp.altTotal = c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                               temp.altCom = c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                               temp.diamCopa1 = c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                                temp.diamCopa2 = c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                                temp.diamBasal = c.getNumericCellValue();
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
                            if(c.getCellType()>0){
                                if(!c.getStringCellValue().isEmpty()){
                               temp.estadoFisico = c.getStringCellValue();
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
                            if(c.getCellType()>0){
                                if(!c.getStringCellValue().isEmpty()){
                               temp.estadoSanitario = c.getStringCellValue();
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
                            if(c.getCellType()>0){
                                if(!c.getStringCellValue().isEmpty()){
                                temp.observaciones = c.getStringCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                               temp.foto1 = (int) c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(c.getNumericCellValue()>0){
                               temp.foto2 = (int) c.getNumericCellValue();
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
                            if(c.getCellType()>=0){
                                if(!c.getStringCellValue().isEmpty()){
                               temp.concepto= c.getStringCellValue();
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
                    //System.out.println("NUMERIC CELL--> " + c.getNumericCellValue());
                   
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
            numFilas++;
            puedeInsert=true;
           
        }
         numArboles = numArb;
       System.out.println("Numero de Arboles:"+arboles.size());
       
       } catch (Exception e){
           System.out.println("problema fue :"+e.toString());
       }
       
       
   }
   
   public void mostratArchivo(){
      if(!arboles.isEmpty()){
            for(arbol u:arboles){
                System.out.println(u.toCadena()+"\n");
            }
      }
   
   }
  
}
