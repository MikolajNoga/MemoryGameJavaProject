package Sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LevelChoiceController implements Initializable {

    @FXML
    private ImageView mediumLvlImage, hardLvlImage, extremeLvlImage;

    @FXML
    private Button backBtn;

    @FXML
    private void EasyLvlBtnClicked() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/EasyLvl.fxml"));
        BtnClicked(root);
    }

    @FXML
    private void MediumLvlBtnClicked() throws IOException{
        if (mediumLvlImage.getImage().getUrl().equals("file:src/Files/OtherImages/icons8-concerned-face-64.png")){
            Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/MediumLvl.fxml"));
            BtnClicked(root);
        }
    }

    @FXML
    private void HardLvlBtnClicked() throws IOException{
        if (hardLvlImage.getImage().getUrl().equals("file:src/Files/OtherImages/icons8-monster-face-64.png")){
            Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/HardLvl.fxml"));
            BtnClicked(root);
        }
    }

    @FXML
    private void ExtremeLvlBtnClicked() throws IOException{
        if (extremeLvlImage.getImage().getUrl().equals("file:src/Files/OtherImages/icons8-coffin-face-64.png")){
            Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/ExtremeLvl.fxml"));
            BtnClicked(root);
        }
    }

    @FXML
    private void backBtnClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/MainScreen.fxml"));
        BtnClicked(root);
    }

    private void BtnClicked(Parent root){
        Scene scene = new Scene(root,750,500);
        Stage thisStage = (Stage) backBtn.getScene().getWindow();
        thisStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/Files/lock.txt");
        Scanner scanner = null;
        try {scanner = new Scanner(file); } catch (FileNotFoundException e) { e.printStackTrace(); }
        String str = scanner.nextLine();
        int i = Integer.parseInt(str);
        switch (i){
            case 3:
                extremeLvlImage.setImage(new Image("file:src/Files/OtherImages/icons8-coffin-face-64.png"));
            case 2:
                hardLvlImage.setImage(new Image("file:src/Files/OtherImages/icons8-monster-face-64.png"));
            case 1:
                mediumLvlImage.setImage(new Image("file:src/Files/OtherImages/icons8-concerned-face-64.png"));
        }
    }
}
