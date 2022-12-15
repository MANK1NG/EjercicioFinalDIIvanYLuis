package es.uem.desarrollofinal.proyectofinalivanyluis;

import es.uem.desarrollofinal.proyectofinalivanyluis.controller.ControladorEmpleado;
import es.uem.desarrollofinal.proyectofinalivanyluis.controller.ControladorRootLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //Este es nuestro PrimaryStage (Contiene tod)
    private Stage primaryStage;

    //Este es el BorderPane de RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1)Declarar una etapa primaria (Tod estará en esta etapa)
        this.primaryStage = primaryStage;



        //Poner untítulo
        this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");

        //2)
        initRootLayout();

        //3) Mostrar la vista de operaciones de empleados
        showEmployeeView();
    }

    //Inicializa el  RootLayout.
    public void initRootLayout() {
        try {
            //Primero, cargue el diseño raíz desde RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //En segundo lugar, muestre la escena que contiene el diseño raíz.
            Scene scene = new Scene(rootLayout); //Estamos enviando rootLayout a la escena.
            primaryStage.setScene(scene); //Establecer la escena en el escenario principal.

            ControladorRootLayout controller = loader.getController();

            //En tercer lugar, muestra la etapa primaria.
            primaryStage.show(); //Mostrar la etapa primaria
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Muestra la vista de operaciones de los empleados dentro del diseño raíz.
    public void showEmployeeView() {
        try {
            //Primero, cargue EmployeeView desde OperacionesEmpleado.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("OperacionesEmpleado.fxml"));
            AnchorPane vistaOperacionesEmpleado =   (AnchorPane) loader.load();

            // Establezca la vista Operaciones de empleados en el centro del diseño raíz.
            rootLayout.setCenter(vistaOperacionesEmpleado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}