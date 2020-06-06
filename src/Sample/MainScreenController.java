package Sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    void PlayBtnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/LevelChoice.fxml"));
        Scene gameScene = new Scene(root,750,500);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(gameScene);
    }

    @FXML
    void RulesBtnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/RulesScreen.fxml"));
        Scene rulesScene = new Scene(root,750,500);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(rulesScene);
    }

    @FXML
    void ScoreBtnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/ScoreScreen.fxml"));
        Scene rulesScene = new Scene(root,750,500);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(rulesScene);
    }

    @FXML
    void ExitBtnClicked(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wyjście z gry");
        alert.setHeaderText("Czy na pewno chcesz wyjść?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            thisStage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
