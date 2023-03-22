/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
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
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) throws YaExisteException {
        // TODO: Realiar el m�todo que agrega al principio
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
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
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
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
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
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException, YaExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
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
     * Busca el paciente con el c�digo dado en la lista de pacientes.
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
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
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
     * Retorna la lista de cl�nicas manejadas por la central
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
    // Puntos de Extensi�n
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
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
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
