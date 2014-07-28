//Se importan los paquetes necesarios para la clase
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.*;

/**Clase para la creacion de los objetos "partes".
*/
public class ParteReparacion{
  
  //Datos miembro
  
  /**Datos miembro de los objetos, es decir, de los partes de reparacion.
    * dni, matricula y tipoAveria son de la clase String, puesto que son cadenas de caracteres.
    * codigo, horasEstimadas y horasReales son del tipo int, puesto que se tratan de enteros.
    * cuantia es del tipo double, puesto que se trata de un numero racional.
    * fechaEntrada y fechaSalida son de la clase GregorianCalendar, puesto que se tratan de fechas.
    * estadoParte es del tipo boolean, puesto que se trata de un valor logico (si o no).
  */
 
  private int codigo;
  private String dni;
  private String matricula;
  private GregorianCalendar fechaEntrada=new GregorianCalendar();
  private boolean estadoParte; 
  private int horasEstimadas;
  private int horasReales;
  private GregorianCalendar fechaSalida=new GregorianCalendar();
  private double cuantia;
  private String tipoAveria;
  
  //Constructores
  
  /**Constructor que inicializa a 0 todos los datos.
  */
  ParteReparacion(){}
  
  /**Constructor que permite almacenar todos los datos de los partes.
  */
  ParteReparacion (int nuevoCodigo, String nuevoDni, String nuevoMatricula, GregorianCalendar nuevoFechaEntrada, 
                   boolean nuevoEstadoParte, int nuevoHorasEstimadas, int nuevoHorasReales, GregorianCalendar nuevoFechaSalida,
                   double nuevoCuantia, String nuevoTipoAveria)
  {codigo=nuevoCodigo;
   dni=nuevoDni;
   matricula=nuevoMatricula;
   fechaEntrada=nuevoFechaEntrada;
   estadoParte=nuevoEstadoParte;
   horasEstimadas=nuevoHorasEstimadas;
   horasReales=nuevoHorasReales;
   fechaSalida=nuevoFechaSalida;
   cuantia=nuevoCuantia;
   tipoAveria=nuevoTipoAveria;}
  
  //Metodos de asignacion de valores a los datos de los partes.
  
    /**Metodo con el que asignamos nuevo codigo a un parte.
    * @param nuevoCodigo Dato que pasamos como argumento para obtener un nuevo codigo para el parte.
    */
    public void asignarCodigo (int nuevoCodigo){
    codigo=nuevoCodigo;}
    
    /**Metodo con el que asignamos el DNI de un cliente a un parte.
    * @param nuevoDni Dato que pasamos como argumento para obtener un nuevo DNI para el parte.
    */
    public void asignarDni (String nuevoDni){
    dni=new String(nuevoDni);}
    
    /**Metodo con el que asignamos la matricula de un vehiculo a un parte.
    * @param nuevoMatricula Dato que pasamos como argumento para obtener una nueva matricula para el parte.
    */
    public void asignarVehiculo (String nuevoMatricula){
    matricula=new String (nuevoMatricula);}
    
    /**Metodo con el que asignamos nueva fecha de entrada del vehiculo a un parte.
    * @param nuevoFechaEntrada Dato que pasamos como argumento para obtener una fecha de entrada del vehiculo para el parte.
    */
    public void asignarFechaEntrada (GregorianCalendar nuevoFechaEntrada){
    fechaEntrada=nuevoFechaEntrada;}
    
    /**Metodo con el que asignamos nuevo estado del parte a un parte.
    * @param nuevoEstadoParte Dato que pasamos como argumento para obtener un nuevo estado del parte para el parte.
    */
    public void asignarEstadoParte (boolean nuevoEstadoParte){
    estadoParte=nuevoEstadoParte;}
    
    /**Metodo con el que asignamos nuevas horas estimadas de reparacion a un parte.
    * @param nuevoHorasEstimadas Dato que pasamos como argumento para obtener unas nuevas horas estimadas de reparacion para el parte.
    */
    public void asignarHorasEstimadas (int nuevoHorasEstimadas){
    horasEstimadas=nuevoHorasEstimadas;}
    
     /**Metodo con el que asignamos nuevas horas reales de reparacion a un parte
    * @param nuevoHorasReales Dato que pasamos como argumento para obtener unas nuevas horas reales de reparacion para el parte.
    */
    public void asignarHorasReales (int nuevoHorasReales){
    horasReales=nuevoHorasReales;}
    
     /**Metodo con el que asignamos nueva fecha de salida de un vehiculo a un parte.
    * @param nuevoFechaSalida Dato que pasamos como argumento para obtener una nueva fecha de salida del vehiculo para el parte.
    */
    public void asignarFechaSalida (GregorianCalendar nuevoFechaSalida){
    fechaSalida=nuevoFechaSalida;}
    
     /**Metodo con el que asignamos nueva cuantia a un parte.
    * @param nuevoCuantia Dato que pasamos como argumento para obtener una nueva cuantia para el parte.
    */
    public void asignarCuantia (double nuevoCuantia){
    cuantia=nuevoCuantia;}
    
     /**Metodo con el que asignamos nueva averia a un parte
    * @param nuevoTipoAveria Dato que pasamos como argumento para obtener una nueva averia para el parte.
    */
    public void asignarTipoAveria(String nuevoTipoAveria){
    tipoAveria=new String(nuevoTipoAveria);}

    //Metodos de impresion por pantalla de datos.
    
    
    /**Metodo que imprime por pantalla los datos de un parte.
    */
    public void imprimir(){
    System.out.println("Codigo: "+codigo+"\nCliente: "+dni+"\nVehiculo: "+matricula+"\nFecha de entrada en el taller: "+fechaEntrada.getTime()+
                       "\n¿Finalizado?: "+estadoParte+"\nNumero de horas estimadas de mano de obra: "+horasEstimadas+
                       "\nNumero de horas reales de mano de obra: "+horasReales+"\nFecha de salida del taller del vehiculo: "+fechaSalida.getTime()+
                       "\nCuantia: "+cuantia+"\nTipo de Averia: "+tipoAveria+"\n");}
    
    //Metodos de acceso de datos
    
    /**Metodo para acceder al codigo
    * @return codigo Codigo de un parte.
    */
    public int accederCodigo(){
    return codigo;}
    
    /**Metodo para acceder al DNI del cliente
    *@return dni DNI del cliente de un parte.
    */
    public String accederDni(){
    return dni;}
    
    /**Metodo para acceder a la matricula del vehiculo
    *@return matricula Matricula del vehiculo de un parte.
    */
    public String accederMatricula(){
    return matricula;}
    
    /**Metodo para acceder a la fecha de entrada del vehiculo
    *@return fechaEntrada Fecha de entrada del vehiculo de un parte.
    */
    public GregorianCalendar accederFechaEntrada(){
    return fechaEntrada;}
    
    /**Metodo para acceder al estado del parte
    *@return estadoParte Estado del parte de un parte.
    */
    public boolean accederEstadoParte(){
    return estadoParte;}
    
    /**Metodo para acceder al numero de horas de mano de obra estimadas
    *@return horasEstimadas Horas estimadas de reparacion del vehiculo de un parte.
    */
    public int accederHorasEstimadas(){
    return horasEstimadas;}
    
    /**Metodo para acceder al numero de horas de mano de obra reales
    *@return horasReales Horas reales de reparacion del vehiculo de un parte.
    */
    public int accederHorasReales(){
    return horasReales;}
    
    /**Metodo para acceder a la fecha de salida del taller
    *@return fechaEntrada Fecha de salida del vehiculo de un parte.
    */
    public GregorianCalendar accederFechaSalida(){
    return fechaSalida;}
    
    /**Metodo para acceder a la cuantia
    *@return cuantia Cuantia de la reparacion del vehiculo de un parte.
    */
    public double accederCuantia(){
    return cuantia;}
    
    /**Metodo para acceder al tipo de averia
    *@return tipoAveria Tipo de averia del vehiculo de un parte.
    */
    public String accederTipoAveria(){
    return tipoAveria;}
    
}//Final de la clase