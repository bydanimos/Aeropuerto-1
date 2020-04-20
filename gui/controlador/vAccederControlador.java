/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controlador;

import aeropuerto.Usuario;
import gui.modelo.Modelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class vAccederControlador extends Controlador implements Initializable {

    @FXML
    private Label labTitulo;
    @FXML
    private Label labSubrayado;
    @FXML
    private Label labErro;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField textFieldId;
    @FXML
    private PasswordField textFieldContrasenha;

    /**
     * Inicializa o controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labErro.setVisible(false);
    }

    @FXML
    private void accionBtnAcceder(ActionEvent event) {
        //Abrese a venta. Falta a comprobacion das credenciais
        Usuario usuario = Modelo.getInstanceModelo().credencialesCorrectos(textFieldId.getText(), textFieldContrasenha.getText());
        if (usuario != null) {
            ((vPrincipalControlador) loadWindow(getClass().getResource("/gui/vista/vPrincipal.fxml"), "AeroETSE", null)).setUsuario(usuario);
            //Pechase a venta de rexistro
            getVenta().close();
        } else {
            labErro.setVisible(true);
            //Modelo.getInstanceModelo().mostrarError("Usuario o contraseña incorrectos");
        }

    }

    @FXML
    private void accionCancelar(ActionEvent event) {
        if (getVenta() != null) {
            getVenta().close();
        } else {
            System.out.println("Erro, a venta esta a null.");
        }

    }

    @FXML
    private void accionRegistrar(ActionEvent event) {
        loadWindow(getClass().getResource("/gui/vista/vRegistrarse.fxml"), "Registrarse", null); //Se usa super ya que el atributo está en controlador
    }

}
