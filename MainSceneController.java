import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainSceneController {

    // Vamos fazer uma função CreateScene que irá
    // criar a cena apartir de um FXMLLoader carregando
    // o .fxml.
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = LoginSceneController.class.getResource("Main-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    // Variáveis que representam os componentes
    // Note que id/field devem ser iguais ao nome
    // que aparece aqui.
    @FXML
    protected Button btNext;

    // Evento submit executado ao rodar a aplicação.
    @FXML
    protected void tryNext(ActionEvent e) throws Exception {
        // Fechando a main
        Stage crrStage = (Stage) btNext
                .getScene().getWindow();
        crrStage.close();

        try {
            // Abrindo a tela excel
            Stage stage = new Stage();
            Scene scene = ExcelSceneController.CreateScene();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Erro ao processar a tela. Consulte o apoio de TI",
                    ButtonType.OK);
            alert.showAndWait();
            ex.printStackTrace();
        }
    }
}