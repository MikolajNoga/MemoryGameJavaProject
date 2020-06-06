package Sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RulesController implements Initializable {

    @FXML
    TextArea textArea;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/MainScreen.fxml"));
        Scene rulesScene = new Scene(root,750,500);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(rulesScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setDisable(true);
    }
}
