/**Clase para la creacion de los objetos "clientes".
*/
public class Cliente{
  
  //Datos miembro
  
  /**Datos miembro de los objetos, es decir, de los clientes.
    * apellidos, nombre, direccion y dni son de la clase String, puesto que son cadenas de caracteres.
  */
  private String apellidos;
  private String nombre;
  private String direccion;
  private String dni;
  
  //Constructores
  
  /**Constructor que inicializa a 0 todos los datos.
  */
  Cliente (){}
  
  /**Constructor que permite almacenar todos los datos de los clientes.
  */
  Cliente (String nuevoApellidos, String nuevoNombre, String nuevoDireccion, String nuevoDni)
  {apellidos=nuevoApellidos;
   nombre=nuevoNombre;
   direccion=nuevoDireccion;
   dni=nuevoDni;}
 
 
    //Metodos de asignacion de valores a los datos de los clientes.
  
    /**Metodo con el que asignamos nuevos apellidos a un cliente.
    * @param nuevoApellidos Dato que pasamos como argumento para obtener unos apellidos para el cliente.
    */
    public void asignarApellidos (String nuevoApellidos){
    apellidos=new String(nuevoApellidos);}
    
    /**Metodo con el que asignamos nuevo nombre a un cliente.
    * @param nuevoNombre Dato que pasamos como argumento para obtener un nombre para el cliente.
    */
    public void asignarNombre (String nuevoNombre){
    nombre=new String (nuevoNombre);}
    
    /**Metodo con el que asignamos nueva direccion a un cliente.
    * @param nuevoDireccion Dato que pasamos como argumento para obtener una direccion para el cliente.
    */
    public void asignarDireccion (String nuevoDireccion){
    direccion=new String (nuevoDireccion);}
    
    /**Metodo con el que asignamos nuevo DNI a un cliente.
    * @param nuevoDni Dato que pasamos como argumento para obtener un DNI para el cliente.
    */
    public void asignarDni (String nuevoDni){
    dni=new String (nuevoDni);}
    
  
    //Metodos de impresion por pantalla de datos.
    
    
    /**Metodo que imprime por pantalla los datos de un cliente.
    */
    //Lo del final esta para que se nos separen los clientes a la hora de mostrarlos todos por pantalla.
    public void imprimir(){
    System.out.println("Apellidos: "+apellidos+"\nNombre: "+nombre+"\nDireccion: "+direccion+"\nDNI: "+dni+"\n");}
    
    //Metodos de acceso de datos
    
    /**Metodo para acceder a los apellidos
    * @return apellidos Apellidos de un cliente.
    */
    public String accederApellidos(){
    return apellidos;}
    
    /**Metodo para acceder al nombre
    * @return nombre Nombre de un cliente.
    */
    public String accederNombre(){
    return nombre;}
    
    /**Metodo para acceder a la direccion
    * @return direccion Direccion de un cliente.
    */
    public String accederDireccion(){
    return direccion;}
    
    /**Metodo para acceder al DNI
    * @return dni DNI de un cliente.
    */
    public String accederDni(){
    return dni;}


}//Final de la clase Cliente