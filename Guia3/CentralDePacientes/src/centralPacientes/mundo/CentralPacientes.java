/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) throws YaExisteException {
        // TODO: Realiar el método que agrega al principio
        boolean agregar = true;
        for (int i = 0; i < darNumeroPacientes(); i++){
            if (pacientes.get(i).darCodigo() == pac.darCodigo()){
                agregar = false;
            }
        }
        if (agregar){
            pacientes.add(0, pac);
        } else {
            throw new YaExisteException(pac.darCodigo());
        }
    }




    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) throws YaExisteException {
        // TODO: Agragar un paciente al final de la lista
        boolean agregar = true;
        for (int i = 0; i < darNumeroPacientes(); i++){
            if (pacientes.get(i).darCodigo() == pac.darCodigo()){
                agregar = false;
            }
        }
        if (agregar){
            pacientes.add(pac);
        } else {
            throw new YaExisteException(pac.darCodigo());
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        boolean existe = false;
        boolean agregar = true;
        Paciente pacienteActual = pacientes.get(0);
        for (int i = 0; i < darNumeroPacientes(); ++i){
            if (pacientes.get(i).darCodigo() == cod){
                existe = true;
                pacienteActual = pacientes.get(i);
            }
        }
        if (existe){
            for (int i = 0; i < darNumeroPacientes(); ++i){
                if (pacientes.get(i).darCodigo() == pac.darCodigo()){
                    agregar = false;
                }
            }
        } else throw new NoExisteException(pac.darCodigo());

        if (agregar){
            int posicionPaciente = pacientes.indexOf(pacienteActual);
            pacientes.add(posicionPaciente, pac);
        } else throw new YaExisteException(pac.darCodigo());
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        boolean existe = false;
        boolean agregar = true;
        Paciente pacienteActual = pacientes.get(0);
        for (int i = 0; i < darNumeroPacientes(); ++i){
            if (pacientes.get(i).darCodigo() == cod){
                existe = true;
                pacienteActual = pacientes.get(i);
            }
        }
        if (existe){
            for (int i = 0; i < darNumeroPacientes(); ++i){
                if (pacientes.get(i).darCodigo() == pac.darCodigo()){
                    agregar = false;
                }
            }
        } else throw new NoExisteException(pac.darCodigo());

        if (agregar){
            int posicionPaciente = pacientes.indexOf(pacienteActual);
            pacientes.add(posicionPaciente+1, pac);
        } else throw new YaExisteException(pac.darCodigo());
    }
    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        int paciente = 0;
        for (int i = 0; i < darNumeroPacientes(); ++i){
            if (pacientes.get(i).darCodigo() == codigo){
                paciente = i;
                return pacientes.get(paciente);
            }
        } return null;

    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        int paciente = 0;
        for (int i = 0; i < darNumeroPacientes(); ++i){
            if (pacientes.get(i).darCodigo() == cod){
                paciente = i;
                pacientes.remove(paciente);
            }
        }
    }


    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int cont = 0;
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darSexo() == 1) {
                cont ++;
            }
        }
        return cont;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int cont = 0;
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darSexo() == 2) {
                cont ++;
            }
        }
        return cont;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        int pacientesCountry = 0;
        int pacientesPalermo = 0;
        int pacientesSofia = 0;
        int pacientesBosque = 0;
        int pacientesIgnacio = 0;
        int pacientesOtras = 0;
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darClinica().equals(listaClinicas.get(0))){
                pacientesCountry++;
            } else if (pacientes.get(i).darClinica().equals(listaClinicas.get(1))) {
                pacientesPalermo++;
            } else if (pacientes.get(i).darClinica().equals(listaClinicas.get(2))) {
                pacientesSofia++;
            } else if (pacientes.get(i).darClinica().equals(listaClinicas.get(3))) {
                pacientesBosque++;
            } else if (pacientes.get(i).darClinica().equals(listaClinicas.get(4))) {
                pacientesIgnacio++;
            } else if (pacientes.get(i).darClinica().equals(listaClinicas.get(5))) {
                pacientesOtras++;
            } else return "No hay pacientes registrados";
        }
        int[] pacientesClinicas = new int[] {pacientesCountry, pacientesPalermo, pacientesSofia, pacientesBosque, pacientesIgnacio, pacientesOtras};
        int pacientesMayoritarios = pacientesClinicas[0];

        for (int paciente: pacientesClinicas ){
            if (paciente > pacientesMayoritarios){
                pacientesMayoritarios = paciente;
            }
        }

        String clinicaMasPacientes = "No hay clinicas registradas";

        if (pacientesCountry == pacientesMayoritarios){
            clinicaMasPacientes = listaClinicas.get(0);
        } else if (pacientesPalermo == pacientesMayoritarios) {
            clinicaMasPacientes = listaClinicas.get(1);
        } else if (pacientesSofia == pacientesMayoritarios) {
            clinicaMasPacientes = listaClinicas.get(2);
        } else if (pacientesBosque == pacientesMayoritarios) {
            clinicaMasPacientes = listaClinicas.get(3);
        } else if (pacientesIgnacio == pacientesMayoritarios) {
            clinicaMasPacientes = listaClinicas.get(4);
        } else if (pacientesOtras == pacientesMayoritarios) {
            clinicaMasPacientes = listaClinicas.get(5);
        }
        return clinicaMasPacientes;
    }


}
