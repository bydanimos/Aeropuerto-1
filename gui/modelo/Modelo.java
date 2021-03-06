package gui.modelo;

import aeropuerto.FachadaAplicacion;
import aeropuerto.elementos.Aerolinea;
import aeropuerto.elementos.Coche;
import aeropuerto.elementos.Parking;
import aeropuerto.elementos.PersonalLaboral;
import aeropuerto.elementos.Tienda;
import aeropuerto.elementos.Usuario;
import aeropuerto.elementos.Vuelo;
import aeropuerto.util.EstadisticasAerolinea;
import aeropuerto.util.EstadisticasUsuario;
import aeropuerto.util.PorcentajeDisponibilidad;
import aeropuerto.util.reservas.Reserva;
import aeropuerto.util.Time;
import aeropuerto.util.reservas.ReservaCoche;
import aeropuerto.util.reservas.ReservaParking;
import gui.FachadaGui;
import static gui.controlador.Controlador.loadWindow;
import static gui.controlador.Controlador.loadWindowConfirm;
import gui.controlador.VErrorController;
import gui.controlador.VNotificacionController;
import gui.controlador.vConfirmacionControlador;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Modelo {

    private static Modelo mod = null; //Instancia do modelo
    private final FachadaAplicacion fa;
    private final FachadaGui fgui;

    private Modelo(FachadaAplicacion fa) {
        this.fa = fa;
        this.fgui = fa.getFgui();
    }

    //Singleton
    public static Modelo newModelo(FachadaAplicacion fa) {
        if (mod == null) {
            mod = new Modelo(fa);
        }

        return mod;
    }

    public static Modelo getInstanceModelo() {
        return mod;
    }

    public Boolean registrarUsuario(Usuario us, String clave) {
        return fa.registrarUsuario(us, clave);
    }

    public Boolean modificarContrasenha(String idUsuario, String clave) {
        return fa.modificarContrasenha(idUsuario, clave);
    }

    public void mostrarError(String mensaje, Stage pai) {
        Stage stage = new Stage();
        stage.initOwner(pai);
        VErrorController controlador = ((VErrorController) loadWindow(getClass().
                getResource("/gui/vista/vError.fxml"), "Error", stage));
        controlador.mostrarMensaje(mensaje);
        controlador.getVenta().setResizable(false);
    }

    public void mostrarError(String mensaje) {
        VErrorController controlador = ((VErrorController) loadWindow(getClass().
                getResource("/gui/vista/vError.fxml"), "Error", null));
        controlador.mostrarMensaje(mensaje);
        controlador.getVenta().setResizable(false);
    }

    public Usuario credencialesCorrectos(String id, String cont) {
        return fa.credencialesCorrectos(id, cont);
    }

    public void mostrarNotificacion(String mensaje, Stage pai) {
        Stage stage = new Stage();
        stage.initOwner(pai);
        VNotificacionController controlador = ((VNotificacionController) loadWindow(getClass().
                getResource("/gui/vista/vNotificacion.fxml"), "Notificación", stage));
        controlador.mostrarMensaje(mensaje);
        controlador.getVenta().setResizable(false);

    }

    public Boolean mostrarConfirmacion(String mensaje, Stage pai) {
        Stage stage = new Stage();
        stage.initOwner(pai);
        vConfirmacionControlador controlador = ((vConfirmacionControlador) loadWindowConfirm(getClass().
                getResource("/gui/vista/vConfirmacion.fxml"), "Confirmación", stage));
        controlador.mostrarMensaje(mensaje);
        controlador.getVenta().setResizable(false);
        controlador.getVenta().showAndWait();
        return controlador.getConfirmado();
    }

    //Vuelos


    public List<Vuelo> buscarVuelos(String numVuelo, String origen, String destino, Time fechaSalida) {
        return fa.buscarVuelos(numVuelo, origen, destino, fechaSalida);
    }

    public List<Vuelo> obtenerVuelosUsuario(String dniUs) {
        return fa.obtenerVuelosUsuario(dniUs);
    }

    public List<Vuelo> obtenerVuelosRealizadosUsuario(String dniUs) {
        return fa.obtenerVuelosRealizadosUsuario(dniUs);
    }

    public List<Vuelo> obtenerVuelosFuturosUsuario(String dniUs) {
        return fa.obtenerVuelosFuturosUsuario(dniUs);
    }

    //Función cambiar datos
    public boolean modificarUsuario(Usuario usuario) {
        return fa.modificarUsuario(usuario);
    }

    public boolean eliminarUsuario(String dni) {
        return fa.eliminarUsuario(dni);
    }

    public EstadisticasUsuario mostrarEstadisticasUsuario(String dniUs, String tipo, Integer num) {
        return fa.obtenerEstadisticasUsuario(dniUs, tipo, num);
    }

    public EstadisticasUsuario obtenerEstadisticasGlobalesUsuario(String dniUs) {
        return fa.obtenerEstadisticasGlobalesUsuario(dniUs);
    }

    public List<ReservaParking> obterResParkingUsuario(String dniUs) {
        return fa.obterResParkingUsuario(dniUs);
    }

    public List<ReservaCoche> obterResCocheUsuario(String dniUs) {
        return fa.obterResCocheUsuario(dniUs);
    }

    public Boolean cancelarReserva(Reserva res, String dniUs) {
        return fa.cancelarReserva(res, dniUs);
    }

    public void obtenerDatosAvionVuelo(Vuelo v) {
        fa.obtenerDatosAvionVuelo(v);
    }

    public void obtenerAsientos(Vuelo vuelo) {
        fa.obtenerAsientos(vuelo);
    }

    public Boolean comprarBilletes(ObservableList<Usuario> usuarios) {
        return fa.comprarBilletes(usuarios);
    }

    public Boolean vueloRealizado(String vuelo) {
        return fa.vueloRealizado(vuelo);
    }

    public Boolean devolverBillete(String vuelo, String dni) {
        return fa.devolverBillete(vuelo, dni);
    }

    public Usuario obtenerUsuario(String dni) {
        return fa.obtenerUsuario(dni);
    }

    public List<Integer> buscarTerminais() {
        return fa.buscarTerminais();
    }

    public List<String> obterTipoVentas() {
        return fa.obterTipoVentas();
    }

    public List<Tienda> buscarTiendas(String nombre, String tipo, String terminal) {
        return fa.buscarTiendas(nombre, tipo, terminal);
    }

    public PorcentajeDisponibilidad obterPrazasRestantesParkingTerminal(Integer numTerminal, Time inicio, Time fin) {
        return fa.obterPrazasRestantesParkingTerminal(numTerminal, inicio, fin);
    }

    public Parking buscarParking(Integer terminal, Time inicio, Time fin) {
        return fa.buscarParking(terminal, inicio, fin);
    }

    public List<Coche> buscarCoches(Time llegada, Time retorno, Integer numPlazas) {
        return fa.buscarCoches(llegada, retorno, numPlazas);
    }

    public List<Coche> buscarCoches(Time llegada, Time retorno, Integer numPlazas, String modelo, String matricula) {
        return fa.buscarCoches(llegada, retorno, numPlazas, modelo, matricula);
    }

    public Integer obterPrazaLibre(Integer numTerminal, Integer piso, Time inicio, Time fin) {
        return fa.obterPrazaLibre(numTerminal, piso, inicio, fin);
    }

    public Boolean reservarParking(ReservaParking reserva, String dniUsuario) {
        return fa.reservarParking(reserva, dniUsuario);
    }

    public Boolean reservarCoche(ReservaCoche reserva, String dniUsuario) {
        return fa.reservarCoche(reserva, dniUsuario);
    }

    public List<Vuelo> mostrarSalidas() {
        return fa.verSalidas();
    }

    public List<Vuelo> mostrarLlegadas() {
        return fa.verLlegadas();
    }

    public List<String> obtenerAerolineasConVuelos() {
        return fa.obtenerAerolineasConVuelos();
    }

    public EstadisticasAerolinea obtenerEstadisticasAerolinea(String aer) {
        return fa.obtenerEstAerolineas(aer);
    }

    public Boolean pasarControlPersExt(String dni) {
        return fa.pasarControlPersExt(dni);
    }

    public Boolean salirControlPersExt(String dni) {
        return fa.salirControlPersExt(dni);
    }

    public Boolean pasarControlBillete(String dni, String vuelo) {
        return fa.pasarControlBillete(dni, vuelo);
    }

    public Boolean salirControlBillete(String dni, String vuelo) {
        return fa.salirControlBillete(dni, vuelo);
    }

    public Boolean facturarMaleta(String dni, String vuelo, Float peso) {
        return fa.facturarMaleta(dni, vuelo, peso);
    }

    /*Se debe llamar después de facturar una maleta*/
    public Float getPrecioExtraDespuesFacturar(String dni, String vuelo, Float peso) {
        return fa.getPrecioExtraDespuesFacturar(dni, vuelo, peso);
    }

    public List<String> obtenerAnhosViajados(String dni) {
        return fa.obtenerAnhosViajados(dni);
    }

    public Boolean usuarioViajado(String dni) {
        return fa.usuarioViajado(dni);
    }

    public Boolean estaDentroPersLab(PersonalLaboral us) {
        return fa.estaDentroPersLaboral(us);
    }

    public void entrarPersLaboral(PersonalLaboral usu) {
        fa.entrarPersLaboral(usu);
    }

    public void salirPersLaboral(PersonalLaboral usu) {
        fa.salirPersLaboral(usu);
    }

    public Boolean obtenerHistorialPersLaboral(PersonalLaboral usu, Time fechaInicio, Time fechaFin) {
        return fa.obtenerHistorialPersLaboral(usu, fechaInicio, fechaFin);
    }

    public List<ReservaCoche> obtenerReservasCocheUsuario(String dniUsuario) {
        return fa.obtenerReservasCocheUsuario(dniUsuario);
    }

    public Boolean introducirAlquiler(String matricula, Time fin, String dni) {
        return fa.introducirAlquiler(matricula, fin, dni);
    }

    public Boolean comprobarRegistrado(String dni) {
        return fa.comprobarRegistrado(dni);
    }

    public ReservaCoche buscarAlquilerDevolucion(String matricula) {
        return fa.buscarAlquilerDevolucion(matricula);
    }

    public Boolean devolucionCoche(Reserva alquiler) {
        return fa.devolucionCoche(alquiler);
    }

    public Aerolinea obtenerDatosAerolinea(String numvuelo) {
        return fa.obtenerDatosAerolinea(numvuelo);
    }

    public Boolean obtenerDatosPersLab(PersonalLaboral trab) {
        return fa.obtenerDatosPersLab(trab);
    }

    public Boolean sePuedeAmpliarReservaCoche(Time fechaFinOriginal, Time fechaFinNueva, String matricula, String usuario) {
        return fa.sePuedeAmpliarReservaCoche(fechaFinOriginal, fechaFinNueva, matricula, usuario);
    }
}
