//Paquetes que seran necesarios
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.*;

/**Clase utilizada para la creacion de los metodos que seran utilizados en la clase GestionTaller a traves de los menus.
*/
class Taller{
  
  //Datos miembro
  
  /**Dato miembro: ArrayList donde se almacenan los objetos cliente
  */
  ArrayList<Cliente> listaClientes;
  /**Dato miembro: ArrayList donde se almacenan los objetos vehiculo
  */
  ArrayList<Vehiculo> listaVehiculos;
  /**Dato miembro: ArrayList donde se almacenan los objetos partes de reparacion
  */
  ArrayList<ParteReparacion> listaPartes;
  
  //Constructor
  
  /**Constructor que permite crear una lista para cada una de las clases: Cliente, Vehiculo y ParteReparacion
  */
  Taller(){
    
    listaClientes=new ArrayList<Cliente>();
    listaVehiculos=new ArrayList<Vehiculo>();
    listaPartes=new ArrayList<ParteReparacion>();
  }
  
  //CLIENTES
  
  /**Metodo para almacenar en el ArrayList listaClientes unos clientes por defecto. 
  *Este metodo sera ejecutado desde el main directamente al ejecutar el programa.
  */
  public void clientesDePrueba(){
    listaClientes.add(new Cliente("Let�n", "Josechu", "Ja�n", "23457698K"));
    listaClientes.add(new Cliente("Cot�n", "Carmelo", "Granada", "13789745F"));
    listaClientes.add(new Cliente("Vales", "Encarna", "C�rdoba", "20943218X"));
    
  }//Final del metodo clientesDePrueba
  
  /**Metodo utilizado para dar de alta a un cliente.
   *Se introducen los datos miembro propios del cliente.
   *Se comprueba que el cliente no este dado ya de alta, es decir, que no coincida el DNI con el de otro cliente ya almacenado.
   *En caso de no coincidir, se almacena el nuevo cliente.
  */
  public void altaCliente(){
    
    Cliente cliente;
    String apellidos=" ";
    String nombre=" ";
    String direccion=" ";
    String dni=" ";
    String dni2=" ";
    boolean finalizar=false;
  
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      System.out.println("Introduzca el dni");
      dni=br.readLine();
      System.out.println("Introduzca el nombre");
      nombre=br.readLine();
      System.out.println("Introduzca los apellidos");
      apellidos=br.readLine();
      System.out.println("Introduzca la direccion");
      direccion=br.readLine();
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
   
       //Recorremos con el bucle la lista de clientes
       for(int i=0; i<listaClientes.size() && !finalizar; i++){
       //Se accede a cada uno de los clientes
       cliente=listaClientes.get(i);
       //Se accede a su DNI
       dni2=cliente.accederDni();
       //Si los DNIs coinciden, el cliente no se da de alta
       if(dni.equals(dni2)){
        System.out.println("El cliente ya se encuentra en la base de datos");
        finalizar=true;
       }
       }
       //En caso de que no hubiesen coincidido los DNIs, el cliente se da de alta
       if(!finalizar){
         System.out.println("El cliente ha sido dado de alta");
         listaClientes.add(new Cliente(apellidos, nombre, direccion, dni));
       }
       
  }//Final del metodo altaCliente
  
  /**Metodo utilizado para dar de baja a un cliente.
   *Primero se comprueba que el cliente existe, buscando su DNI.
   *Si el cliente existe, comprobamos que no tiene ningun parte de reparacion pendiente.
   *En caso de que todos sus partes de reparacion esten finalizados, se procede a darse de baja.
  */
  public void bajaCliente(){
    
    Cliente cliente;
    ParteReparacion parte;
    String dni=" ";
    String dni2=" ";
    boolean continuar=false;
    boolean eliminacion=true;
    boolean estadoParte;
    
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      System.out.println("Introduzca el DNI del cliente que desea dar de baja");
      dni=br.readLine();
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }

      //Comprobamos que el cliente existe
      for(int i=0; i<listaClientes.size(); i++){
       cliente=listaClientes.get(i);
       dni2=cliente.accederDni();
       if(dni.equals(dni2)){
         continuar=true;
       }
      }
      
      
     //Si el cliente existe, comprobamos que no hay ningun parte pendiente asociado
     if(continuar==true){
      
      for(int j=0; j<listaPartes.size(); j++){
        parte=listaPartes.get(j);
        dni2=parte.accederDni();
        //Si los DNIs coinciden, comprobamos el estado del parte
        if(dni.equals(dni2)){
          estadoParte=parte.accederEstadoParte();
          //Si no esta finalizado, no podemos darlo de baja
          if(estadoParte==false){
            eliminacion=false;
          }
        //Si los DNIs no coinciden, no hay ningun parte asociado al cliente, por tanto podemos darlo de baja tranquilamente
        }
      }
     }
       
      
     if(continuar==true && eliminacion==true){
      //Se busca la posicion del cliente y se procede a eliminarlo con el metodo remove
      for(int k=0; k<listaClientes.size(); k++){
       cliente=listaClientes.get(k);
       dni2=cliente.accederDni();
       if(dni.equals(dni2)){
         listaPartes.remove(k);
         System.out.println("El cliente ha sido dado de baja");
       }
      }
     //En caso de que el cliente no se haya encontrado en la lista o tuviese un parte pendiente, se muestra el siguiente mensaje
     }else{
       System.out.println("El cliente no se encuentra en la base de datos o tiene un parte asociado");
     }
    
    
  }//Final del metodo bajaCliente
  
  /**Metodo utilizado para mostrar los datos de un cliente tras introducir su DNI.
  *Si el DNI no coincide con el de ningun cliente, muestra un mensaje diciendo que el cliente no esta en la base de datos
  */
  public void mostrarCliente(){
    
    Cliente cliente;
    String dni=" ";
    String dni2=" ";
    boolean finalizar=false;
    
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      System.out.println("Introduzca el DNI del cliente del que desea ver sus datos");
      dni=br.readLine();
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
    
    //Se recorre la lista de clientes
    for(int i=0; i<listaClientes.size(); i++){
       cliente=listaClientes.get(i);
       dni2=cliente.accederDni();
       //Si lo encuentra, imprime sus datos
       if(dni.equals(dni2)){
         cliente.imprimir();
         finalizar=true;
       }
    }
    
    //En caso de no encontrarlo, se nos muestra el siguiente mensaje
    if(!finalizar){
      System.out.println("El cliente no se ha encontrado en la base de datos");
    }
    
  }//Final del metodo mostrarCliente
  
  /**Muestra los datos de todos los clientes.
  *Se recorre la lista de todos los clientes y se imprimen los datos de cada uno de ellos
  */
  public void inventarioClientes(){
    
    Cliente cliente;
    
    //Se recorre la lista de clientes y se imprimen los datos
    for(int i=0; i<listaClientes.size(); i++){
       cliente=listaClientes.get(i);
       cliente.imprimir();
    }
    
  }//Final del metodo inventarioClientes
  
  /**Metodo utilizado para modificar los datos de un cliente, excepto el DNI.
  *Se introduce el DNI del cliente y se busca.
  *Si se encuentra, se sigue una serie de instrucciones para modificar o no los datos del cliente
  */
  public void modificarCliente(){
    
    Cliente cliente;
    String nuevoApellidos=" ";
    String nuevoNombre=" ";
    String nuevoDireccion=" ";
    String dni=" ";
    String dni2=" ";
    boolean finalizar=false;
    String respuesta=" ";
  
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      System.out.println("Introduzca el dni del cliente del que desea modificar sus datos");
      dni=br.readLine();
      
      //Se recorre la lista de clientes comparandose los DNIs
      for(int i=0; i<listaClientes.size() && !finalizar; i++){
       cliente=listaClientes.get(i);
       dni2=cliente.accederDni();
       
       //Si se encuentra el cliente, se deberan seguir los pasos que se muestran para modificar o no los datos del cliente
       if(dni.equals(dni2)){
         
         System.out.println("�Desea modificar los apellidos del cliente? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee los nuevos apellidos");
           nuevoApellidos=br.readLine();
           cliente.asignarApellidos(nuevoApellidos);
         }
           
         System.out.println("�Desea modificar el nombre del cliente? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee el nuevo nombre");
           nuevoNombre=br.readLine();
           cliente.asignarNombre(nuevoNombre);
         }
           
         System.out.println("�Desea modificar la direccion del cliente? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee la nueva direccion");
           nuevoDireccion=br.readLine();
           cliente.asignarDireccion(nuevoDireccion);
         }
         
        finalizar=true;
         
       }
      }
            
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
   
       //En caso de no encontrarse el cliente, se nos muestra el siguiente mensaje
       if(!finalizar){
         System.out.println("El cliente no se encuentra en la base de datos");
       }
       
  }//Final del metodo modificarCliente
  
  
  
  
    
  //VEHICULOS
  
   GregorianCalendar fecha1=new GregorianCalendar(2008,Calendar.NOVEMBER,12);
   GregorianCalendar fecha2=new GregorianCalendar(2005,Calendar.JANUARY,4);
   GregorianCalendar fecha3=new GregorianCalendar(1834,Calendar.MARCH,2);
   GregorianCalendar fecha4=new GregorianCalendar(1990,Calendar.JANUARY,1);
  
  /**Metodo para almacenar en el ArrayList listaVehiculos unos vehiculos por defecto. 
  *Este metodo sera ejecutado desde el main directamente al ejecutar el programa.
  */
  public void vehiculosDePrueba(){
    listaVehiculos.add(new Vehiculo("1234 BCD", "Ferrari Lentini", 't', fecha1, false));
    listaVehiculos.add(new Vehiculo("4321 DCB", "Locar Gatodo", 'f', fecha2, true));
    listaVehiculos.add(new Vehiculo("GR-0000-A", "Troncom�vil Cicleta++", 'm', fecha3, false));
    listaVehiculos.add(new Vehiculo("GR-9999-XY", "Seat Anda", 't', fecha4, true));
  }
   
   /**Metodo utilizado para dar de alta a un vehiculo.
   *Se introducen los datos miembro propios del vehiculo.
   *Se comprueba que el vehiculo no este dado ya de alta, es decir, que no coincida la matricula con la de otro vehiculo ya almacenado.
   *En caso de no coincidir, se almacena el nuevo vehiculo en la posicion correspondiente en orden alfabetico segun la matricula.
   */
   public void altaVehiculo(){
    
    Vehiculo vehiculo;
    String modelo=" ";
    char tipo=' ';
    String matricula=" ";
    String matricula2=" ";
    int diaAnioDeCompra=1;
    int mesAnioDeCompra=1;
    int anioAnioDeCompra=0001;
    boolean enReparacion=false;
    boolean finalizar=false;
    String respuesta=" ";
    int contador=0;
  
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    //Se introducen los datos del vehiculo
    try{
      
      System.out.println("Introduzca la matricula");
      matricula=br.readLine();
      
      System.out.println("Introduzca el modelo");
      modelo=br.readLine();
      
      System.out.println("Introduzca la fecha de compra");
      System.out.print("Dia de compra");
      do{
      diaAnioDeCompra=Integer.parseInt(br.readLine());
      }while(diaAnioDeCompra < 1 || diaAnioDeCompra >30);
      System.out.print("Mes de compra");
      do{
      mesAnioDeCompra=Integer.parseInt(br.readLine());
      }while(mesAnioDeCompra < 1 || mesAnioDeCompra > 12);
      System.out.print("Anio de compra");
      anioAnioDeCompra=Integer.parseInt(br.readLine());
      
      System.out.println("Introduzca el tipo de vehiculo (t para turismo, m para motocicleta y f para furgoneta)");
      do{
        tipo=(br.readLine()).charAt(0);
      
      }while(tipo != 't' && tipo != 'm' && tipo != 'f');
      
      System.out.println("�Se encuentra el vehiculo actualmente en reparacion? En caso afirmativo teclee SI");
      respuesta=br.readLine();
      if (respuesta.equals("SI"));
      enReparacion=true;      
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
      
      GregorianCalendar anioDeCompra=new GregorianCalendar(anioAnioDeCompra, mesAnioDeCompra-1, diaAnioDeCompra);
         
       //Se comprueba que el vehiculo no se encuentra ya almacenado, es decir, que la matricula no se encuentra ya en la lista de vehiculos
       for(int i=0; i<listaVehiculos.size() && !finalizar; i++){
       vehiculo=listaVehiculos.get(i);
       matricula2=vehiculo.accederMatricula();
       //Si las matricula se encuentra en la lista, se muestra el siguiente mensaje y no se almacena el vehiculo
       if(matricula.equals(matricula2)){
        System.out.println("El vehiculo ya se encuentra en la base de datos");
        finalizar=true;
       }
       }
       
       //En caso de que la matricula no se haya encontrado, se almacena el vehiculo en orden alfabetico segun la matricula
       if(finalizar==false){
         
         for(int j=0; j<listaVehiculos.size(); j++){
           vehiculo=listaVehiculos.get(j);
           matricula2=vehiculo.accederMatricula();
           contador++;
           //Se comparan las matriculas. Si la matricula introducida da como resultado con el metodo compareTo un numero menor que cero
           //tomamos esa posicion y almacenamos en ella al vehiculo, desplazando al resto una posicion
           if(matricula.compareTo(matricula2) < 0){
             System.out.println("El vehiculo ha sido dado de alta");
             listaVehiculos.add(j, new Vehiculo(matricula, modelo, tipo, anioDeCompra, enReparacion ));
             break;
           }
           //En caso de haber llegado al final de la lista y no haber encontrado con el metodo compareTo un numero menor que cero, agregamos
           //el nuevo vehiculo al final
           if(contador==listaVehiculos.size()){
             System.out.println("El vehiculo ha sido dado de alta");
             listaVehiculos.add(new Vehiculo(matricula, modelo, tipo, anioDeCompra, enReparacion));
             break;
           }
         }
       }
       
       
  }//Final del metodo altaVehiculo
   
   
   /**Metodo utilizado para dar de baja a un vehiculo.
   *Primero se comprueba que el vehiculo existe, buscando su matricula.
   *Si el vehiculo existe, comprobamos que no tiene ningun parte de reparacion pendiente.
   *En caso de que todos sus partes de reparacion esten finalizados, se procede a darse de baja.
   */
   public void bajaVehiculo(){
    
    Vehiculo vehiculo;
    ParteReparacion parte;
    String matricula=" ";
    String matricula2=" ";
    boolean continuar=false;
    boolean eliminacion=true;
    boolean estadoParte;
    
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      System.out.println("Introduzca la matricula del vehiculo que desea dar de baja");
      matricula=br.readLine();
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }

      //Comprobamos que el vehiculo existe
      
      for(int i=0; i<listaVehiculos.size(); i++){
       vehiculo=listaVehiculos.get(i);
       matricula2=vehiculo.accederMatricula();
       if(matricula.equals(matricula2)){
         continuar=true;
       }
      }
      
      
      //Si el vehiculo existe, comprobamos que no hay ningun parte pendiente asociado
      
     if(continuar==true){
      
      for(int j=0; j<listaPartes.size(); j++){
        parte=listaPartes.get(j);
        matricula2=parte.accederMatricula();
        //Si las matriculas coinciden, comprobamos el estado del parte
        if(matricula.equals(matricula2)){
          estadoParte=parte.accederEstadoParte();
          //Si no esta finalizado, no podemos darlo de baja
          if(estadoParte==false){
            eliminacion=false;
          }
        //Si las matriculas no coinciden, no hay ningun parte asociado al vehiculo, por tanto podemos darlo de baja tranquilamente
        }
      }
     }
       
      
     if(continuar==true && eliminacion==true){
      //Se busca el vehiculo en la lista de vehiculos y se procede a darlo de baja mediante el metodo remove
      for(int k=0; k<listaVehiculos.size(); k++){
       vehiculo=listaVehiculos.get(k);
       matricula2=vehiculo.accederMatricula();
       if(matricula.equals(matricula2)){
         listaVehiculos.remove(k);
         System.out.println("El vehiculo ha sido dado de baja");
       }
      }
     //En caso de que el vehiculo no se haya encontrado en la lista o tuviese un parte pendiente, se muestra el siguiente mensaje
     }else{
       System.out.println("El vehiculo no se encuentra en la base de datos o tiene un parte asociado");
     }
    
  }//Final del metodo bajaVehiculo
   
   /**Metodo utilizado para mostrar los datos de un vehiculo tras introducir su matricula.
   *Si el vehiculo no es encontrado en la lista de vehiculos, nos muestra un mensaje diciendo que no esta dado de alta.
   */
   public void mostrarVehiculo(){
    
    Vehiculo vehiculo;
    String matricula=" ";
    String matricula2=" ";
    boolean finalizar=false;
    
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    //Introducimos la matricula
    try{
      
      System.out.println("Introduzca la matricula del vehiculo del que desea ver sus datos");
      matricula=br.readLine();
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
    
    //Recorremos la lista de vehiculos comparando las matriculas
    for(int i=0; i<listaVehiculos.size(); i++){
       vehiculo=listaVehiculos.get(i);
       matricula2=vehiculo.accederMatricula();
       //Si se encuentra la matricula, se imprimen los datos del vehiculo
       if(matricula.equals(matricula2)){
         vehiculo.imprimir();
         finalizar=true;
       }
    }
    
    //En caso de no encontrar la matricula, se muestra el siguiente mensaje
    if(!finalizar){
      System.out.println("El vehiculo no se ha encontrado en la base de datos");
    }
    
  }//Final del metodo mostrarVehiculo
   
   /**Metodo utilizado para mostrar los datos de todos los vehiculos de la lista de vehiculos.
   *Se recorre la lista de vehiculos y se imprimen los datos de cada uno de ellos
   */
   public void inventarioVehiculos(){
    
    Vehiculo vehiculo;
    
    //Se recorre la lista de vehiculos y se imprimen los datos de cada uno de ellos
    for(int i=0; i<listaVehiculos.size(); i++){
       vehiculo=listaVehiculos.get(i);
       vehiculo.imprimir();
    }
    
  }//Final del metodo inventarioVehiculos
     
  /**Metodo utilizado para modificar los datos de un vehiculo, excepto si se encuentra o no en reparacion.
  *Para ello se introduce su matricula.
  *Si se encuentra se siguen los pasos que se muestran y se van modificando o no los datos.
  *Si no se encuentra el vehiculo, se nos muestra un mensaje diciendo que no esta dado de alta en la base de datos.
  */
  public void modificarVehiculo(){
    
    Vehiculo vehiculo;
    String nuevoMatricula=" ";
    String nuevoModelo=" ";
    char nuevoTipo=' ';
    int nuevoDiaAnioDeCompra=0;
    int nuevoMesAnioDeCompra=0;
    int nuevoAnioAnioDeCompra=0;
    String matricula=" ";
    String matricula2=" ";
    boolean finalizar=false;
    String respuesta=" ";
  
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    //Introducimos la matricula del vehiculo
    try{
      
      System.out.println("Introduzca la matricula del vehiculo del que desea modificar sus datos");
      matricula=br.readLine();
      
      //Se recorre la lista de vehiculos comparando sus matriculas
      for(int i=0; i<listaVehiculos.size() && !finalizar; i++){
       vehiculo=listaVehiculos.get(i);
       matricula2=vehiculo.accederMatricula();
       
       //Si las matriculas coinciden, se siguen los pasos indicados para modificar o no sus datos
       if(matricula.equals(matricula2)){
         
         System.out.println("�Desea modificar la matricula del vehiculo? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee la nueva matricula");
           nuevoMatricula=br.readLine();
           vehiculo.asignarMatricula(nuevoMatricula);
         }
           
         System.out.println("�Desea modificar el modelo del vehiculo? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee el nuevo modelo");
           nuevoModelo=br.readLine();
           vehiculo.asignarModelo(nuevoModelo);
         }
         
         System.out.println("�Desea modificar el tipo de vehiculo? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee el nuevo tipo (t para turismo, m para motocicleta y f para furgoneta)");
           do{
            nuevoTipo=(br.readLine()).charAt(0);
           }while(nuevoTipo != 't' && nuevoTipo != 'm' && nuevoTipo != 'f');
           vehiculo.asignarTipo(nuevoTipo);
         }
           
         System.out.println("�Desea modificar la fecha de compra del vehiculo? En caso afirmativo teclee SI");
         respuesta=br.readLine();
         if (respuesta.equals("SI")){
           System.out.println("Teclee la nueva fecha de compra");
           System.out.print("Dia de compra");
           do{
           nuevoDiaAnioDeCompra=Integer.parseInt(br.readLine());
           }while(nuevoDiaAnioDeCompra < 1 || nuevoDiaAnioDeCompra > 30);
           System.out.print("Mes de compra");
           do{
           nuevoMesAnioDeCompra=Integer.parseInt(br.readLine());
           }while(nuevoMesAnioDeCompra < 1 || nuevoMesAnioDeCompra > 12);
           System.out.print("Anio de compra");
           nuevoAnioAnioDeCompra=Integer.parseInt(br.readLine());
           
           GregorianCalendar nuevoAnioDeCompra=new GregorianCalendar(nuevoAnioAnioDeCompra, nuevoMesAnioDeCompra-1, nuevoDiaAnioDeCompra);
  
           vehiculo.asignarAnioDeCompra(nuevoAnioDeCompra);
         }
         
        finalizar=true;
         
       }
      }
      
      }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
   
       //En caso de que no se hubiese encontrado la matricula del vehiculo, se nos muestra el siguiente mensaje
       if(!finalizar){
         System.out.println("El vehiculo no se encuentra en la base de datos");
       }
       
  }//Final del metodo modificarVehiculo
  
  /**Metodo utilizado para mostrar el historial de reparaciones del vehiculo, es decir, los partes asociados a este.
  *Para ello se introduce su matricula.
  *Si se encuentra la matricula, se muestran todos los partes.
  *En caso contrario se nos muestra un mensaje diciendo que el vehiculo no se encuentra dado de alta en la base de datos.
  */
  public void historialReparaciones(){
     
     ParteReparacion parte;
     String matricula=" ";
     String matricula2=" ";
     boolean finalizar=false;
     
     InputStreamReader isr= new InputStreamReader(System.in);
     BufferedReader br= new BufferedReader(isr);
      
    //Introducimos la matricula del vehiculo
    try{
      
      System.out.println("Introduzca la matricula del vehiculo del que desea ver sus partes de reparacion");
      matricula=br.readLine();
      
      }catch(IOException e){
        System.out.println("Error en la lectura");
        System.exit(0);
      }
    
      //Se recorre la lista de partes comparando la matricula del vehiculo con la matricula de los partes
      for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       matricula2=parte.accederMatricula();
       //Si se encuentra, se muestran los datos de todos los partes de reparacion
       if(matricula.equals(matricula2)){
         parte.imprimir();
         finalizar=true;
       }
      }
      
      //Si el vehiculo no se ha encontrado, se muestra el siguiente mensaje
      if(!finalizar){
      System.out.println("El parte del vehiculo no se ha encontrado en la base de datos");
      }
      
   }//Final del metodo historialReparaciones
  
  
  
   
  //PARTES DE REPARACION
   
   GregorianCalendar fechaEntrada1=new GregorianCalendar(2009,Calendar.MAY,10);
   GregorianCalendar fechaSalida1=new GregorianCalendar(2009,Calendar.MAY,12);
    
   GregorianCalendar fechaEntrada2=new GregorianCalendar(2009,Calendar.JULY,1);
   GregorianCalendar fechaSalida2=new GregorianCalendar(2009,Calendar.JULY,8);
    
   GregorianCalendar fechaEntrada3=new GregorianCalendar(2009,Calendar.OCTOBER,22);
   GregorianCalendar fechaSalida3=new GregorianCalendar(0001,Calendar.JANUARY,1);
    
   GregorianCalendar fechaEntrada4=new GregorianCalendar(2010,Calendar.JANUARY,5);
   GregorianCalendar fechaSalida4=new GregorianCalendar(0001,Calendar.JANUARY,1);
   
   /**Metodo para almacenar en el ArrayList listaPartes unos partes de reparacion por defecto. 
   *Este metodo sera ejecutado desde el main directamente al ejecutar el programa
   */
   public void partesDePrueba(){
   
     listaPartes.add(new ParteReparacion(0, "23457698K", "1234 BCD", fechaEntrada1, true, 10, 8, fechaSalida1, 250.0, "Embrague roto"));
     listaPartes.add(new ParteReparacion(1, "23457698K", "GR-0000-A", fechaEntrada2, true, 56, 64, fechaSalida2, 2500.0, "Chapa y pintura completo"));
     listaPartes.add(new ParteReparacion(2, "13789745F", "GR-9999-XY", fechaEntrada3, false, 15, 0, fechaSalida3, 0.0, "Fallo general de la electricidad. Se ha cambiado la dinamo. Continuamos con las pruebas"));
     listaPartes.add(new ParteReparacion(3, "20943218X", "4321 DCB", fechaEntrada4, false, 100, 0, fechaSalida4, 0.0, "Este coche est� hecho polvo. Le fallan hasta los tapones de las v�lvulas de las ruedas. Yo que el due�o le ped�a uno nuevo a los Reyes porque vale m�s el arreglo que uno nuevo"));
   
   }
   
   /**Metodo auxiliar utilizado para generar las horas estimadas de reparacion de un vehiculo.
   *Devuelve un entero de 0 a 100
   *@return horasEstimadas Numero de horas estimadas para la reparacion de un vehiculo
   */
   public int generarHorasEstimadas(){
     
     Random generador=new Random();
     int horasEstimadas=0;
     
     horasEstimadas=generador.nextInt(101);
     
     return horasEstimadas;
     
   }//Final del metodo generarHorasEstimadas
   
   /**Metodo utilizado para dar de alta un nuevo parte de reparacion.
   *Se introducen el DNI del cliente y la matricula del vehiculo.
   *Primero se comprueba que el cliente esta dado de alta.
   *Se comprueba que el vehiculo esta dado de alta tambien.
   *Se comprueba si el vehiculo ya tiene algun parte de reparacion y si es asi, que corresponde al mismo cliente, puesto que un mismo vehiculo
   *no puede pertenecer a distintos clientes.
   *Si todo esta correcto, se procede a la creacion del parte.
   *En caso contrario, se nos muestra un mensaje.
   */
   public void altaParte(){
     
    ParteReparacion parte;
    Cliente cliente;
    Vehiculo vehiculo;
    String dni=" ";
    String dni2=" ";
    String matricula=" ";
    String matricula2=" ";
    boolean continuar=false;
    boolean continuar2=false;
    boolean continuar3=true;
    String respuesta=" ";
    int codigo=0;
    int diaFechaEntrada=0;
    int mesFechaEntrada=0;
    int anioFechaEntrada=0001;
    int diaFechaSalida=0;
    int mesFechaSalida=0;
    int anioFechaSalida=0001;
    boolean estadoParte=false;
    int horasEstimadas=0;
    int horasReales=0;
    double cuantia=0.0;
    String averia=" ";
    boolean nuevoEnReparacion=false;
    
    InputStreamReader isr= new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    
    try{
      
      //Introducimos el DNI del cliente
      System.out.println("Introduzca el DNI del cliente del que desea crear el parte");
      dni=br.readLine();
      
      //Se comprueba que el cliente este dado de alta
      for(int i=0; i<listaClientes.size(); i++){
       cliente=listaClientes.get(i);
       dni2=cliente.accederDni();
       if(dni.equals(dni2)){
         continuar=true;
       }
      }
       
  
       //Se introduce la matricula del vehiculo
       System.out.println("Introduzca la matricula del vehiculo del que desea crear el parte");
       matricula=br.readLine();
            
       //Se comprueba que el vehiculo esta dado de alta
       for(int j=0; j<listaVehiculos.size(); j++){
        vehiculo=listaVehiculos.get(j);
        matricula2=vehiculo.accederMatricula();
        if(matricula.equals(matricula2)){
         continuar2=true;
        }
       }
           
          
       if(continuar==true && continuar2==true){
            
            //Se recorre la lista de los partes comprobando si existe alguno con la matricula introducida
            for(int k=0; k<listaPartes.size(); k++){
              parte=listaPartes.get(k);
              matricula2=parte.accederMatricula();
              //Si las matriculas coinciden, tenemos dos casos
              if(matricula.equals(matricula2)){
                dni2=parte.accederDni();
                //Si los DNIs coinciden, se trata de un nuevo parte para el vehiculo, por tanto si es posible dar de alta el parte
                if(dni.equals(dni2)){
                  continuar3=true;
                  //Si los DNIs no coinciden, quiere decir que se esta intentando asociar un vehiculo a varios clientes, cosa que no es posible
                }else{
                  continuar3=false;
                }
              }
            }
       }
              
                  
      //En caso de que todo marche bien, se procede a la creacion del parte de reparacion        
      if(continuar==true && continuar2==true && continuar3==true){         
        
        //El codigo coincidira con la posicion en el ArrayList. Puesto que no puede haber varios objetos en una misma posicion, este sera unico
        for(int k=0; k<listaPartes.size(); k++){
              codigo++;
        }

      System.out.println("Introduzca la fecha de entrada");
      System.out.print("Dia de entrada");
      do{
      diaFechaEntrada=Integer.parseInt(br.readLine());
      }while(diaFechaEntrada < 1 || diaFechaEntrada > 30);
      System.out.print("Mes de entrada");
      do{
      mesFechaEntrada=Integer.parseInt(br.readLine());
      }while(mesFechaEntrada < 1 || mesFechaEntrada > 12);
      System.out.print("Anio de entrada");
      anioFechaEntrada=Integer.parseInt(br.readLine());
      
      //Puesto que el minimo de horas estimadas es 1, repetimos el proceso en caso de que se generen 0 horas
      do{
      horasEstimadas= generarHorasEstimadas();
      }while(horasEstimadas == 0);
      
      System.out.println("Describa la averia del vehiculo");
      averia=br.readLine();

      System.out.println("�Tiene datos suficientes para finalizar el parte de reparacion? En caso afirmativo teclee SI");
      respuesta=br.readLine();
      
      if(respuesta.equals("SI")){
        
        estadoParte=true;
        
        System.out.println("Introduzca el numero de horas reales para la reparacion del vehiculo");
        horasReales=Integer.parseInt(br.readLine());
        
        System.out.println("Introduzca la cuantia de la reparacion");
        cuantia=Double.parseDouble(br.readLine());
      
       //Al vehiculo le asignamos que ya ha sido reparado
       for(int j=0; j<listaVehiculos.size(); j++){
        vehiculo=listaVehiculos.get(j);
        matricula2=vehiculo.accederMatricula();
        //Se busca en la lista de vehiculos comparando matriculas y una vez se encuentra, se le asigna que no esta en reparacion
        if(matricula.equals(matricula2)){
          vehiculo.asignarEnReparacion(nuevoEnReparacion);
        }
       }
      
       //Creamos la fecha de salida mediante el siguiente metodo:
  
      int totalDias=0;
      
      //Se suman los dias de la fecha y los resultantes de dividir entre 8 las horas de trabajo (8 puesto que son las horas laborales que tiene un dia)
      totalDias=diaFechaEntrada+(horasReales/8);
      //El resultado se divide entre 30 y el cociente se suma a los meses y el resto a los dias
      diaFechaSalida=totalDias%30;
      mesFechaSalida=mesFechaEntrada+(totalDias/30);
      anioFechaSalida=anioFechaEntrada;
      //Si se sobrepaan los 12 meses, se vuelve al valor 1 y a los a�os se le suma 1
      if(mesFechaSalida > 12){
        mesFechaSalida=1;
        anioFechaSalida=anioFechaEntrada+1;
      }
      
      }//Final del if respuesta
      
      GregorianCalendar fechaEntrada=new GregorianCalendar(anioFechaEntrada, mesFechaEntrada-1, diaFechaEntrada);
      GregorianCalendar fechaSalida=new GregorianCalendar(anioFechaSalida, mesFechaSalida-1, diaFechaSalida);
      
      listaPartes.add(new ParteReparacion(codigo, dni, matricula, fechaEntrada, estadoParte, horasEstimadas, horasReales, fechaSalida, cuantia, averia));
      
      }
      
      
      
    }catch(IOException e){
     System.out.println("Error en la lectura");
     System.exit(0);
      }
    
    //En caso de que alguna de las condiciones para crear el nuevo parte no se halla dado, se muestra el siguiente mensaje
    if(continuar==false || continuar2==false || continuar3==false){
      System.out.println("El cliente y/o vehiculo no se encuentra en la base de datos o el vehiculo esta asociado ya a un cliente");
    }
      
       
  }//Final del metodo altaParte
   
   /**Metodo utilizado para finalizar la reparacion del primer vehiculo no reparado que se encuentre en la lista.
   *Para ello se recorre la lista de partes, accediendo al estado de la reparacion.
   *Si se encuentra un parte sin finalizar, se van pidiendo los datos necesarios para finalizarlo
   */
   public void finalizarReparacion(){
     
     Vehiculo vehiculo;
     ParteReparacion parte;
     boolean estadoParte;
     boolean finalizar=false;
     int nuevoHorasReales;
     int nuevoCuantia;
     int nuevoDiaFechaSalida=0;
     int nuevoMesFechaSalida=0;
     int nuevoAnioFechaSalida=0;
     boolean nuevoEstadoParte;
     boolean nuevoEnReparacion=false;
     String matricula=" ";
     String matricula2=" ";
     
     InputStreamReader isr= new InputStreamReader(System.in);
     BufferedReader br= new BufferedReader(isr);
     
     //Se recorre la lista de partes, accediendo al estado del parte
     for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       estadoParte=parte.accederEstadoParte();
       matricula=parte.accederMatricula();
       //En cuanto encontramos un parte cuyo estado este sin finalizar, se procede a la introduccion de datos
       if(estadoParte == false){
        
       try{
         
         System.out.println("Escriba la cuantia de la reparacion");
         nuevoCuantia=Integer.parseInt(br.readLine());
         parte.asignarCuantia(nuevoCuantia);
         System.out.println("Escriba las horas reales de la reparacion");
         nuevoHorasReales=Integer.parseInt(br.readLine());
         parte.asignarHorasReales(nuevoHorasReales);
         System.out.println("Escriba la fecha de salida");
         System.out.println("Escriba el dia");
         do{
         nuevoDiaFechaSalida=Integer.parseInt(br.readLine());
         }while(nuevoDiaFechaSalida < 1 || nuevoDiaFechaSalida > 30);
         System.out.println("Escriba el mes");
         do{
         nuevoMesFechaSalida=Integer.parseInt(br.readLine());
         }while(nuevoMesFechaSalida < 1 || nuevoMesFechaSalida > 12);
         System.out.println("Escriba el anio");
         nuevoAnioFechaSalida=Integer.parseInt(br.readLine());
         
         GregorianCalendar nuevoFechaSalida=new GregorianCalendar(nuevoAnioFechaSalida, nuevoMesFechaSalida-1, nuevoDiaFechaSalida);
         
         parte.asignarFechaSalida(nuevoFechaSalida);
         
         //El parte pasa a estar finalizado
         nuevoEstadoParte=true;
         
         parte.asignarEstadoParte(nuevoEstadoParte);
        
       }catch(IOException e){
            System.out.println("Error en la lectura");
            System.exit(0);
       }
       
       //Al vehiculo le asignamos que ya ha sido reparado
       for(int j=0; j<listaVehiculos.size(); j++){
        vehiculo=listaVehiculos.get(i);
        matricula2=vehiculo.accederMatricula();
        if(matricula.equals(matricula2)){
          vehiculo.asignarEnReparacion(nuevoEnReparacion);
        }
       }
         
       finalizar=true;
       //Se usa la sentencia break para que no continue finalizando los siguientes partes
       break;
       }
     }
         //En caso de que no se encontrase ninguno sin finalizar se nos muestra el siguiente mensaje
         if(!finalizar){
           System.out.println("No se encuentra ningun parte sin finalizar");
         }
         
   }//Final del metodo FinalizarReparacion
         
   /**Metodo que muestra una lista de los partes no finalizados.
   *Se recorre la lista de partes, se comprueba si su estado es false, es decir, no finalizado.
   *Si es asi, se imprimen sus datos
   */
   public void partesPendientes(){
     
     ParteReparacion parte;
     boolean estadoParte;
     
      //Recorremos la lista de partes
      for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       estadoParte=parte.accederEstadoParte();
       //Si el estado es no finalizado, se imprimen sus datos
       if(estadoParte == false){
         parte.imprimir();
       }
      }
      
   }//Final del metodo partesPendientes
   
   /**Metodo utilizado para mostrar los partes de reparacion asignados a un cliente.
   *Para ello se introduce el DNI del cliente y se busca en la lista de partes.
   *Si coincide, se muestran los datos del/de los parte/s
   *En caso de no encontrarse, se muestra un mensaje
   */
   public void partesCliente(){
     
     ParteReparacion parte;
     String dni=" ";
     String dni2=" ";
     boolean finalizar=false;
     
     InputStreamReader isr= new InputStreamReader(System.in);
     BufferedReader br= new BufferedReader(isr);
    
    //Introducimos el DNI del cliente
    try{
      
      System.out.println("Introduzca el DNI del cliente del que desea ver sus partes de reparacion");
      dni=br.readLine();
      
      }catch(IOException e){
        System.out.println("Error en la lectura");
        System.exit(0);
      }
    
      //Se recorre la lista de partes comparando el DNI introducido con los DNIs de los clientes de los partes
      for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       dni2=parte.accederDni();
       //Si coinciden, se imprimen los datos
       if(dni.equals(dni2)){
         parte.imprimir();
         finalizar=true;
       }
      }
    
      //Si no se encuentra el cliente, se nos muestra el siguiente mensaje
      if(!finalizar){
      System.out.println("No se encuentra ningun parte asociado al cliente");
      }
      
   }//Final del metodo partesCliente
   
   /**Metodo utilizado para calcular las horas medias reales de los partes ya finalizados.
   *Para ello se recorren todos los partes.
   *Si el estado es finalizado, se almacenan sus horas en una variable y a otra variable utilizada como contador se le a�ade 1
   *Tras terminar el recorrido, se dividen las horas almacenadas entre el contador, que corresponde con el numero de partes finalizados
   */
   public void horasMedias(){
     
     ParteReparacion parte;
     boolean estadoParte;
     int horasReales=0;
     int totalHorasReales=0;
     int numeroPartes=0;
     int horasMedias=0;
     
      //Se recorre la lista de partes
      for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       estadoParte=parte.accederEstadoParte();
       //Si el estado del parte es finalizado, se accede a las horas reales y se almacenan en una variable y al contador se le a�ade 1
       if(estadoParte != false){
         horasReales=parte.accederHorasReales();
         totalHorasReales=totalHorasReales+horasReales;
         numeroPartes++;
       }
      }
      
      //El numero de horas medias sera el total de horas reales almacenadas entre el numero de partes finalizados
      horasMedias=(totalHorasReales/numeroPartes);
      System.out.println("El numero de horas medias es: "+horasMedias);
      
   }//Final del metodo horasMedias
   
   /**Metodo utilizado para modificar el numero de horas estimadas en un parte.
   *Se introduce el DNI del cliente y la matricula del vehiculo.
   *Si se encuentra, se modifican las horas estimadas.
   *En caso contrario, se nos muestra un mensaje.
   */
   public void modificarParte(){
     
     ParteReparacion parte;
     String dni=" ";
     String dni2=" ";
     String matricula=" ";
     String matricula2=" ";
     int nuevoHorasEstimadas=0;
     boolean finalizar=false;
     
     InputStreamReader isr= new InputStreamReader(System.in);
     BufferedReader br= new BufferedReader(isr);
     
      //Se introduce el DNI del cliente y la matricula del vehiculo
      try{
        
        System.out.println("Introduzca el DNI del cliente");
        dni=br.readLine();
        System.out.println("Introduzca la matricula del vehiculo");
        matricula=br.readLine();
      
      }catch(IOException e){
        System.out.println("Error en la lectura");
        System.exit(0);
      }
     
     //Se comparan el DNI y la matricula introducidos con los de cada uno de los partes
     for(int i=0; i<listaPartes.size(); i++){
       parte=listaPartes.get(i);
       dni2=parte.accederDni();
       matricula2=parte.accederMatricula();
       //Si ambos coinciden, se modifica el numero de horas estimadas
       if(dni.equals(dni2) && matricula.equals(matricula2)){
         
         do{
         nuevoHorasEstimadas= generarHorasEstimadas();
         }while(nuevoHorasEstimadas == 0);
         System.out.println("Horas estimadas cambiadas");
         
         parte.asignarHorasEstimadas(nuevoHorasEstimadas);
         finalizar=true;
     
       }
     }
     
     //Si no se encuentra el vehiculo y/o cliente se nos muestra el siguiente mensaje
     if(!finalizar){
       System.out.println("No se encuentra el cliente y/o vehiculo");
     }
     
   }//Final del metodo modificarParte
   
  //ESTADO GENERAL
  
   /**Metodo utilizado para mostrar una lista de todos los clientes, vehiculos y partes de reparacion.
   *Se recorren cada una de las listas y se van imprimiendo los datos de cada uno de sus objetos
   */
   public void imprimirTodo(){
     
     Cliente cliente;
     Vehiculo vehiculo;
     ParteReparacion parte;
     
     System.out.println("CLIENTES");
     System.out.println("");
     for(int i=0; i<listaClientes.size(); i++){
       cliente=listaClientes.get(i);
       cliente.imprimir();
     }
       
     System.out.println("VEHICULOS");
     System.out.println("");
      for(int j=0; j<listaVehiculos.size(); j++){
       vehiculo=listaVehiculos.get(j);
       vehiculo.imprimir();
      }
     
     System.out.println("PARTES DE REPARACION");
     System.out.println("");
      for(int k=0; k<listaPartes.size(); k++){
       parte=listaPartes.get(k);
       parte.imprimir();
      }
      
   }//Final del metodo imprimirTodo
     
  
}//Final de la clase
       
    