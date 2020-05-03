package aeropuerto.gestion;

import aeropuerto.elementos.Usuario;
import aeropuerto.util.EstadisticasUsuario;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionUsuarios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public Boolean registrarUsuario(Usuario us, String clave) {
        return fbd.insertarUsuario(us, clave);
    }

    public Boolean modificarContrasenha(String idUsuario, String clave) {
        return fbd.modificarContrasenha(idUsuario, clave);
    }

    public Usuario credencialesCorrectos(String id, String cont) {
        return fbd.comprobarCredenciales(id, cont);
    }

    public Boolean modificarUsuario(Usuario us) {
        return fbd.modificarUsuario(us);
    }

    public boolean eliminarUsuario(String dni) {
        return fbd.eliminarUsuario(dni);
    }

    public EstadisticasUsuario obtenerEstadisticasUsuario(String dniUs, String tipo, Integer num) {
        if (tipo.equals("estacion") || tipo.equals("mes") || tipo.equals("anho")) {
            return fbd.obtenerEstadisticasUsuario(dniUs, tipo, num);
        } else {
            System.out.println("Error en los parámetros de entrada");
            return null;
        }
    }

    public EstadisticasUsuario obtenerEstadisticasGlobalesUsuario(String dniUs) {
        return fbd.obtenerEstadisticasGlobalesUsuario(dniUs);
    }

    public Usuario obtenerUsuario(String dni) {
        return fbd.obtenerUsuario(dni);
    }

    public Boolean pasarControlPersExt(String dni) {
        return fbd.pasarControlPersExt(dni);
    }

    public Boolean salirControlPersExt(String dni) {
        return fbd.salirControlPersExt(dni);
    }

    public Boolean usuarioViajado(String dni) {
        return !(fbd.obtenerVuelosUsuario(dni).isEmpty());
    }

}
