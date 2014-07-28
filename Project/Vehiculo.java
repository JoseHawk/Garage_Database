//Se importan los paquetes necesarios para la clase
import java.util.GregorianCalendar;
import java.util.Calendar;

/**Clase para la creacion de los objetos "vehiculos".
*/
public class Vehiculo{
  
  //Datos miembro
  
  /**Datos miembro de los objetos, es decir, de los vehiculos.
    * matricula y modelo son de la clase String, puesto que son cadenas de caracteres.
    * tipo es del tipo char, puesto que se trata de un caracter.
    * anioDeCompra es de la clase GregorianCalendar, puesto que se trata de una fecha.
    * enReparacion es del tipo boolean, puesto que se trata de un valor logico (si o no).
  */
  private String matricula;
  private String modelo;
  private char tipo;
  private GregorianCalendar anioDeCompra=new GregorianCalendar();
  private boolean enReparacion;
  
  //Constructores
  
  /**Constructor que inicializa a 0 todos los datos.
  */
  Vehiculo(){}
  
  /**Constructor que permite almacenar todos los datos de los vehiculos.
  */
  Vehiculo (String nuevoMatricula, String nuevoModelo, char nuevoTipo, GregorianCalendar nuevoAnioDeCompra, boolean nuevoEnReparacion)
  {matricula=nuevoMatricula;
   modelo=nuevoModelo;
   tipo=nuevoTipo;
   anioDeCompra=nuevoAnioDeCompra;
   enReparacion=nuevoEnReparacion;}
  
    
    //Metodos de asignacion de valores a los datos de los vehiculos.
  
    /**Metodo con el que asignamos nueva matricula a un vehiculo.
    * @param nuevoMatricula Dato que pasamos como argumento para obtener una nueva matricula para el vehiculo.
    */
    public void asignarMatricula (String nuevoMatricula){
    matricula=new String(nuevoMatricula);}
    
    /**Metodo con el que asignamos nuevo modelo a un vehiculo.
    * @param nuevoModelo Dato que pasamos como argumento para obtener un nuevo modelo para el vehiculo.
    */
    public void asignarModelo (String nuevoModelo){
    modelo=new String(nuevoModelo);}
    
    /**Metodo con el que asignamos nuevo tipo a un vehiculo.
    * @param nuevoTipo Dato que pasamos como argumento para obtener un nuevo tipo para el vehiculo.
    */
    public void asignarTipo (char nuevoTipo){
    tipo=nuevoTipo;}
    
    /**Metodo con el que asignamos nuevo anio de compra a un vehiculo.
    * @param nuevoAnioDeCompra Dato que pasamos como argumento para obtener un nuevo anio de compra para el vehiculo.
    */
    public void asignarAnioDeCompra (GregorianCalendar nuevoAnioDeCompra){
    anioDeCompra=nuevoAnioDeCompra;}
    
    /**Metodo con el que asignamos nuevo estado de reparacion a un vehiculo.
    * @param nuevoEnReparacion Dato que pasamos como argumento para obtener un nuevo estado de reparacion para el vehiculo.
    */
    public void asignarEnReparacion (boolean nuevoEnReparacion){
    enReparacion=nuevoEnReparacion;}
    
    //Metodos de impresion por pantalla de datos.
    
    
    /**Metodo que imprime por pantalla los datos de un vehiculo.
    */
    public void imprimir(){
      
    System.out.println("Matricula: "+matricula+"\nModelo: "+modelo+"\nTipo: "+tipo+"\nAnio de compra: "+anioDeCompra.getTime()+"\n¿En reparacion?: "+enReparacion+"\n");
    
    }
    
   //Metodos de acceso de datos
    
    /**Metodo para acceder a la matricula
    *@return matricula Matricula de un vehiculo.
    */
    public String accederMatricula(){
    return matricula;}
    
    /**Metodo para acceder al modelo
    *@return modelo Modelo de un vehiculo.
    */
    public String accederModelo(){
    return modelo;}
    
    /**Metodo para acceder al tipo de vehiculo
    *@return tipo Tipo de un vehiculo.
    */
    public char accederTipo(){
    return tipo;}
    
    /**Metodo para acceder al anio de compra
    *@return anioDeCompra Anio de compra de un vehiculo.
    */
    public GregorianCalendar accederAnioDeCompra(){
    return anioDeCompra;}
    
    /**Metodo para acceder al estado de reparacion
    *@return enReparacion Estado de reparacion de un vehiculo.
    */
    public boolean accederEnReparacion(){
    return enReparacion;}
    
    
    
}//Final de la clase Vehiculo