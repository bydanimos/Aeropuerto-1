package gui;

import aeropuerto.FachadaAplicacion;
import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FachadaGui {

    FachadaAplicacion fa;

    public FachadaGui(FachadaAplicacion fa) {
        this.fa = fa;
    }

    public void iniciarVista(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(FachadaGui.class.getResource("/gui/vista/vAcceder.fxml"));
        Pane root = (Pane) loader.load();

        //Collemos o controlador de Acceder
        Controlador contAcceder = loader.getController();

        primaryStage.setTitle("Aeropuerto");
        primaryStage.setScene(new Scene(root));

        contAcceder.setVenta(primaryStage);

        primaryStage.show();
    }

}
