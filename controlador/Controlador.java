/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gui.FachadaGui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author anton
 */
public class Controlador {

    private Stage venta;

    public void abrirVRegistrar() {
        try {
            Stage vR = new Stage();
            FXMLLoader loader = new FXMLLoader(FachadaGui.class.getResource("/gui/vista/vRegistrarse.fxml"));
            Scene root = (Scene) loader.load();

            vR.setTitle("Aeropuerto");
            vR.setScene(root);

            vR.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Getters
    public Stage getVenta() {
        return venta;
    }

    public void setVenta(Stage venta) {
        this.venta = venta;
    }

}
