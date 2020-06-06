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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ScoreController implements Initializable {

    @FXML
    private TextArea textArea;

    @FXML
    void backBtnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/MainScreen.fxml"));
        Scene rulesScene = new Scene(root,750,500);
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        thisStage.setScene(rulesScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/Files/score.txt");
        Scanner scanner = null;
        try { scanner = new Scanner(file); } catch (FileNotFoundException e) { e.printStackTrace(); }
        while (scanner.hasNextLine()){
            textArea.setText(textArea.getText() + scanner.nextLine() + "\n");
        }
        textArea.setDisable(true);

    }
}
