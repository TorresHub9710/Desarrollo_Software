import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.*;

public class ManejadorBolsa {
    public static void main(String[] args) throws SQLException {
        Logger.setGlobalLogLevel(Level.OFF);
        Scanner teclado = new Scanner(System.in);
        // Ubicación del archivo de la base de datos
        String url = "jdbc:h2:file:./bolsa";
        ConnectionSource conexion =
                new JdbcConnectionSource(url);
        // Obtener acceso a la lista de objetos => Tabla(DAO)
        // Primer parametro = clase que contiene la tabla.
        // Segundo parametro = El tipo de dato de la llave primaria
        Dao<Aspirante, String> listaAspirantes =
                DaoManager.createDao(conexion, Aspirante.class);
        int opcion = 1;
        while (opcion != 0){
            System.out.println("Menu: ");
            System.out.println("1. Agregar nuevo aspirante");
            System.out.println("2. Mostrar cédulas de aspirantes");
            System.out.println("3. Información detallada de aspirante");
            System.out.println("4. Buscar aspirante por nombre");
            System.out.println("5. Ordenar aspirantes por edad");
            System.out.println("6. Ordenar aspirantes por experiencia");
            System.out.println("7. Ordenar aspirantes por profesión");
            System.out.println("8. Aspirante con mayor experiencia");
            System.out.println("9. Aspirante más joven");
            System.out.println("10. Contratar aspirante");
            System.out.println("11. Eliminar aspirantes cuya experiencia sea menor a la establecida");
            System.out.println("12. Promedio de edad de aspirantes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una de las opciones del menú: ");
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion){

                case 1:
                    System.out.print("Ingrese el número de cédula del aspirante: ");
                    String cedula = teclado.nextLine();
                    System.out.print("Ingrese el nombre del aspirante: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese la edad del aspirante: ");
                    int edad = Integer.parseInt(teclado.nextLine());
                    System.out.print("Ingrese la experiencia (en años) del aspirante: ");
                    int experiencia = Integer.parseInt(teclado.nextLine());
                    System.out.print("Ingrese la profesión del aspirante: ");
                    String profesion = teclado.nextLine();
                    System.out.print("Ingrese el teléfono del aspirante: ");
                    String telefono = teclado.nextLine();

                    Aspirante aspirante = new Aspirante(cedula, nombre, edad, experiencia, profesion, telefono);
                    listaAspirantes.create(aspirante);
                    break;

                case 2:
                    int i = 1;
                    for (Aspirante a: listaAspirantes){
                        System.out.println("Cédula " + i + ": " + a.getCedula());
                        i++;
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número de cédula que quiere buscar: ");
                    String cedulaBuscar = teclado.nextLine();
                    Aspirante aspiranteBuscado = listaAspirantes.queryForId(cedulaBuscar);
                    if (aspiranteBuscado == null){
                        System.out.println("No existe el aspirante identificado con la cédula: " + cedulaBuscar);
                    } else {
                        System.out.println("Información del aspirante:");
                        System.out.println("\tCédula: " + aspiranteBuscado.getCedula());
                        System.out.println("\tNombre: " + aspiranteBuscado.getNombre());
                        System.out.println("\tEdad: " + aspiranteBuscado.getEdad());
                        System.out.println("\tExperiencia: " + aspiranteBuscado.getExperiencia() + " AÑOS");
                        System.out.println("\tProfesión: " + aspiranteBuscado.getProfesion());
                        System.out.println("\tTeléfono: " + aspiranteBuscado.getTelefono());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre que desee buscar: ");
                    String nombreBuscado = teclado.nextLine().toLowerCase();
                    LinkedList<Aspirante> aspirantesEncontrados = new LinkedList<>();


                    for (Aspirante a: listaAspirantes){
                        String nombreAspirante = a.getNombre().toLowerCase();
                        if (nombreAspirante.contains(nombreBuscado)){
                            aspirantesEncontrados.add(a);
                        }
                    }
                    if (aspirantesEncontrados.size() == 0){
                        System.out.println("No se encontró a ningún aspirante con el nombre: " + nombreBuscado);
                    } else {
                        i = 1;
                        for (Aspirante b: aspirantesEncontrados){
                            System.out.println("Aspirante " + i + ": ");
                            System.out.println("\tNombre: " + b.getNombre());
                            System.out.println("\tCédula: " + b.getCedula());
                            i++;
                        }
                    }
                    break;

                case 5:
                    LinkedList<Integer> aspirantesEdad = new LinkedList<>();
                    for (Aspirante a : listaAspirantes){
                        aspirantesEdad.add(a.getEdad());
                    }
                    Collections.sort(aspirantesEdad);
                    LinkedList<Aspirante> aspirantesOrdenados = new LinkedList<>();
                    int ed = 0;
                    for (i = 0; i < aspirantesEdad.size(); i++){
                        for (Aspirante b : listaAspirantes){
                            if (b.getEdad() == aspirantesEdad.get(ed)){
                                aspirantesOrdenados.add(b);
                            }
                        }
                        if (ed < aspirantesEdad.size()-1){
                            ed++;
                        }
                    }

                    Set<Aspirante> conjuntoAspirantes = new LinkedHashSet<>(aspirantesOrdenados);
                    LinkedList<Aspirante> aspirantesSinDuplicar = new LinkedList<>(conjuntoAspirantes);

                    i = 1;
                    for (Aspirante c : aspirantesSinDuplicar){
                        System.out.println("Aspirante " + i + ": ");
                        System.out.println("\tCédula: " + c.getCedula());
                        System.out.println("\tNombre: " + c.getNombre());
                        System.out.println("\tEdad: " + c.getEdad());
                        i++;
                    }
                    System.out.println(aspirantesEdad);
                    break;

                case 6:
                    LinkedList<Integer> aspirantesExperiencia = new LinkedList<>();
                    for (Aspirante a : listaAspirantes){
                        aspirantesExperiencia.add(a.getExperiencia());
                    }
                    Collections.sort(aspirantesExperiencia);
                    aspirantesOrdenados = new LinkedList<>();
                    int ex = 0;
                    for (i = 0; i < aspirantesExperiencia.size(); i++){
                        for (Aspirante b : listaAspirantes){
                            if (b.getExperiencia() == aspirantesExperiencia.get(ex)){
                                aspirantesOrdenados.add(b);
                            }
                        }
                        if (ex < aspirantesExperiencia.size()-1){
                            ex++;
                        }
                    }

                    conjuntoAspirantes = new LinkedHashSet<>(aspirantesOrdenados);
                    aspirantesSinDuplicar = new LinkedList<>(conjuntoAspirantes);

                    i = 1;
                    for (Aspirante c : aspirantesSinDuplicar){
                        System.out.println("Aspirante " + i + ": ");
                        System.out.println("\tCédula: " + c.getCedula());
                        System.out.println("\tNombre: " + c.getNombre());
                        System.out.println("\tExperiencia: " + c.getExperiencia() + " años");
                        i++;
                    }
                    System.out.println(aspirantesExperiencia);
                    break;

                case 7:
                    LinkedList<String> aspirantesProfesion = new LinkedList<>();
                    for (Aspirante a : listaAspirantes){
                        aspirantesProfesion.add(a.getProfesion());
                    }
                    Collections.sort(aspirantesProfesion);

                    aspirantesOrdenados = new LinkedList<>();
                    int prof = 0;
                    for (i = 0; i < aspirantesProfesion.size(); i++){
                        for (Aspirante b : listaAspirantes){
                            if (b.getProfesion().equals(aspirantesProfesion.get(prof)) ){
                                aspirantesOrdenados.add(b);
                            }
                        }
                        if (prof < aspirantesProfesion.size()-1){
                            prof++;
                        }
                    }

                    conjuntoAspirantes = new LinkedHashSet<>(aspirantesOrdenados);
                    aspirantesSinDuplicar = new LinkedList<>(conjuntoAspirantes);

                    i = 1;
                    for (Aspirante c : aspirantesSinDuplicar){
                        System.out.println("Aspirante " + i + ": ");
                        System.out.println("\tCédula: " + c.getCedula());
                        System.out.println("\tNombre: " + c.getNombre());
                        System.out.println("\tProfesión: " + c.getProfesion());
                        i++;
                    }
                    System.out.println(aspirantesProfesion);
                    break;

                case 8:
                    aspirantesExperiencia = new LinkedList<>();
                    for (Aspirante a : listaAspirantes){
                        aspirantesExperiencia.add(a.getExperiencia());
                    }
                    int mayorExperiencia = 0;
                    for (int e : aspirantesExperiencia){
                        if (e > mayorExperiencia){
                            mayorExperiencia = e;
                        }
                    }
                    LinkedList<Aspirante> aspirantesMayorExp = new LinkedList<>();
                    for (Aspirante b: listaAspirantes){
                        if (b.getExperiencia() == mayorExperiencia){
                            aspirantesMayorExp.add(b);
                        }
                    }
                    System.out.println("Aspirantes con mayor experiencia: ");

                    i=1;
                    for (Aspirante c : aspirantesMayorExp){
                        System.out.println("Aspirante " + i + ": ");
                        System.out.println("\tCédula: " + c.getCedula());
                        System.out.println("\tNombre: " + c.getNombre());
                        System.out.println("\tExperiencia: " + c.getExperiencia() + " años");
                    }
                    break;

                case 9:
                    aspirantesEdad = new LinkedList<>();
                    for (Aspirante a : listaAspirantes){
                        aspirantesEdad.add(a.getEdad());
                    }

                    int masJoven = 100;
                    for (int e : aspirantesEdad) {
                        if (e < masJoven) {
                            masJoven = e;
                        }
                    }
                    LinkedList<Aspirante> aspirantesJovenes = new LinkedList<>();
                    for (Aspirante b : listaAspirantes){
                        if (b.getEdad() == masJoven){
                            aspirantesJovenes.add(b);
                        }
                    }
                    System.out.println("Aspirantes con más jovenes: ");

                    i=1;
                    for (Aspirante c : aspirantesJovenes){
                        System.out.println("Aspirante " + i + ": ");
                        System.out.println("\tCédula: " + c.getCedula());
                        System.out.println("\tNombre: " + c.getNombre());
                        System.out.println("\tEdad: " + c.getEdad());
                    }
                    break;

                case 10:
                    System.out.print("Ingrese la cédula del aspirante que desea contratar: ");
                    String cedulaContratado = teclado.nextLine();

                    String aspiranteContratado = "no";
                    for (Aspirante a : listaAspirantes){
                        if (a.getCedula().equals(cedulaContratado)){
                            aspiranteContratado = "si";
                            listaAspirantes.delete(a);
                        }
                    }
                    if (aspiranteContratado.equals("no")){
                    System.out.println("No existe el aspirante identificado con la cédula: " + cedulaContratado);
                    } else {
                        System.out.println("¡Aspirante Contratado!");
                    }
                    break;

                case 11:
                    System.out.print("Ingrese la experiencia mínima que deben tener los aspirantes" +
                            " que se encuentran dentro de la bolsa de empleo: ");

                    int experienciaMinima = Integer.parseInt(teclado.nextLine());
                    for (Aspirante a : listaAspirantes){
                        if (a.getExperiencia() < experienciaMinima) {
                            listaAspirantes.delete(a);
                        }
                    }
                    System.out.println("Aspirantes eliminados con éxito");
                    break;

                case 12:
                    int numeroAspirantes = 0;
                    int sumaEdades = 0;

                    for (Aspirante a : listaAspirantes){
                        sumaEdades += a.getEdad();
                        numeroAspirantes++;
                    }

                    int promedioEdades = sumaEdades/numeroAspirantes;
                    System.out.println("El promedio de edad de los aspirantes es de: " +
                             promedioEdades + " años");
                    break;
            }
        }

    }


}
