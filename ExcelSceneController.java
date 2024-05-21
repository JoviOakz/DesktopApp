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

public class ExcelSceneController {

    // Vamos fazer uma função CreateScene que irá
    // criar a cena apartir de um FXMLLoader carregando
    // o .fxml.
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = LoginSceneController.class.getResource("Excel-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    // Variáveis que representam os componentes
    // Note que id/field devem ser iguais ao nome
    // que aparece aqui.
    @FXML
    protected Button btPrev;

    // Evento submit executado ao rodar a aplicação.
    @FXML
    protected void tryPrev(ActionEvent e) throws Exception {
        // Fechando o excel
        Stage crrStage = (Stage) btPrev
                .getScene().getWindow();
        crrStage.close();

        try {
            // Abrindo a tela main
            Stage stage = new Stage();
            Scene scene = MainSceneController.CreateScene();
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