README

Este programa posee una licencia Creative Commons, que permite, distribuir y comercializar pero debe ser mencionado el creador.

El objetivo del programa es realizar los reportes de acuerdo a un levantamiento de invetarios de arboles, donde el archivo de entrada
debe estar en formato .xls (Excel 2007), y las columnas son
|NoArbol|NombreComun|Ubicacion|DAP(cm)|altTotal(m)|diamCopa1(m)|diamCopa2(m)|diamBasal(cm)|estadoFisico|observaciones|foto1|foto2

Estas columnas no necesariamente tiene que llamarse asi, el programa identifica solo los arboles por el Numero de Arbol, la unica condicion es
que sean numeros el archivo debe tener 12 columnas, cuenta con siglas para identificar el estado fisico, sanitario y las observaciones, 
segun el tipo de arbol ademas con el nombre comun lee un archivo csv para identificar el nombre cientifico.

Requerimientos

Esta creado con JDK 1.7 y se utilizo NetBeans como IDE

las Librerias Utilizadas son
JasperReports 5.5
JavaCSV 
POI 3.1