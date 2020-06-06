package Sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ExtremeLvlController implements Initializable {
    private int numberOfPars = 0, score = 0, numberOfMoves = 0;
    private boolean startStop = false;
    private String lastPicturePath = null, currentPath = null;
    private Button lastBtn = null;
    private ImageView lastImage = null, penultimateImage = null;
    private Map<Integer, String> paths = new TreeMap<>();
    private List<Integer> imagesId = new ArrayList<>(42);

    @FXML
    private Label movesLabel;

    @FXML
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30, img31, img32, img33, img34, img35, img36, img37, img38, img39, img40, img41, img42;
    private List<ImageView> imagesList = new ArrayList<>(42);

    @FXML
    private Button startStopBtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42;
    private List<Button> buttonsList = new ArrayList<>(42);

    @FXML
    private void StartStopBtnClicked() {
        if (!startStop) {
            for (int i=0;i<42;i++)
                imagesList.get(i).setImage(new Image(paths.get(imagesId.get(i))));
            startStop = true;
            startStopBtn.setText("Stop");
        } else {
            for (int i=0;i<42;i++)
                imagesList.get(i).setImage(new Image("file:src/Files/OtherImages/java.png"));
            startStopBtn.setDisable(true);
            for (int i=0;i<42;i++)
                buttonsList.get(i).setDisable(false);
        }
    }

    @FXML private void Btn1Clicked() throws IOException { BtnClicked(0); }
    @FXML private void Btn2Clicked() throws IOException { BtnClicked(1); }
    @FXML private void Btn3Clicked() throws IOException { BtnClicked(2); }
    @FXML private void Btn4Clicked() throws IOException { BtnClicked(3); }
    @FXML private void Btn5Clicked() throws IOException { BtnClicked(4); }
    @FXML private void Btn6Clicked() throws IOException { BtnClicked(5); }
    @FXML private void Btn7Clicked() throws IOException { BtnClicked(6); }
    @FXML private void Btn8Clicked() throws IOException { BtnClicked(7); }
    @FXML private void Btn9Clicked() throws IOException { BtnClicked(8); }
    @FXML private void Btn10Clicked() throws IOException { BtnClicked(9); }
    @FXML private void Btn11Clicked() throws IOException { BtnClicked(10); }
    @FXML private void Btn12Clicked() throws IOException { BtnClicked(11); }
    @FXML private void Btn13Clicked() throws IOException { BtnClicked(12); }
    @FXML private void Btn14Clicked() throws IOException { BtnClicked(13); }
    @FXML private void Btn15Clicked() throws IOException { BtnClicked(14); }
    @FXML private void Btn16Clicked() throws IOException { BtnClicked(15); }
    @FXML private void Btn17Clicked() throws IOException { BtnClicked(16); }
    @FXML private void Btn18Clicked() throws IOException { BtnClicked(17); }
    @FXML private void Btn19Clicked() throws IOException { BtnClicked(18); }
    @FXML private void Btn20Clicked() throws IOException { BtnClicked(19); }
    @FXML private void Btn21Clicked() throws IOException { BtnClicked(20); }
    @FXML private void Btn22Clicked() throws IOException { BtnClicked(21); }
    @FXML private void Btn23Clicked() throws IOException { BtnClicked(22); }
    @FXML private void Btn24Clicked() throws IOException { BtnClicked(23); }
    @FXML private void Btn25Clicked() throws IOException { BtnClicked(24); }
    @FXML private void Btn26Clicked() throws IOException { BtnClicked(25); }
    @FXML private void Btn27Clicked() throws IOException { BtnClicked(26); }
    @FXML private void Btn28Clicked() throws IOException { BtnClicked(27); }
    @FXML private void Btn29Clicked() throws IOException { BtnClicked(28); }
    @FXML private void Btn30Clicked() throws IOException { BtnClicked(29); }
    @FXML private void Btn31Clicked() throws IOException { BtnClicked(30); }
    @FXML private void Btn32Clicked() throws IOException { BtnClicked(31); }
    @FXML private void Btn33Clicked() throws IOException { BtnClicked(32); }
    @FXML private void Btn34Clicked() throws IOException { BtnClicked(33); }
    @FXML private void Btn35Clicked() throws IOException { BtnClicked(34); }
    @FXML private void Btn36Clicked() throws IOException { BtnClicked(35); }
    @FXML private void Btn37Clicked() throws IOException { BtnClicked(36); }
    @FXML private void Btn38Clicked() throws IOException { BtnClicked(37); }
    @FXML private void Btn39Clicked() throws IOException { BtnClicked(38); }
    @FXML private void Btn40Clicked() throws IOException { BtnClicked(39); }
    @FXML private void Btn41Clicked() throws IOException { BtnClicked(40); }
    @FXML private void Btn42Clicked() throws IOException { BtnClicked(41); }

    void BtnClicked(int id) throws IOException {
        numberOfMoves++;
        movesLabel.setText(String.valueOf(numberOfMoves / 2));
        currentPath = paths.get(imagesId.get(id));
        if (numberOfMoves % 2 != 0) {
            imagesList.get(id).setImage(new Image(currentPath));
            if (numberOfMoves > 1) {
                penultimateImage.setImage(new Image("file:src/Files/OtherImages/java.png"));
                lastImage.setImage(new Image("file:src/Files/OtherImages/java.png"));
            }
        } else {
            if (lastPicturePath == currentPath && lastBtn != buttonsList.get(id)) {
                imagesList.get(id).setImage(new Image(currentPath));
                lastImage.setImage(new Image(lastPicturePath));
                buttonsList.get(id).setDisable(true);
                lastBtn.setDisable(true);
                numberOfPars++;
                score += 100;
            } else {
                imagesList.get(id).setImage(new Image(currentPath));
            }
        }
        penultimateImage = lastImage;
        lastPicturePath = currentPath;
        lastBtn = buttonsList.get(id);
        lastImage = imagesList.get(id);
        // sprawdzanie warunku i koniec gry
        if (numberOfPars == 21) {
            score += 1050 - (numberOfMoves / 2) * 50;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("                                            ****BRAWO!****");
            alert.setHeaderText(null);
            alert.setContentText("Udało ci się ukończyć grę, ale zachęcam do wbijania wyższych wyników :)\n" + "Ilość ruchów: " + numberOfMoves / 2 + "\nIlosć punktów: " + score);
            alert.showAndWait();
            EasyLvlController.savingScores(score);
            Parent root = FXMLLoader.load(getClass().getResource("Design/Fxml/LevelChoice.fxml"));
            Scene scene = new Scene(root, 750, 500);
            Stage thisStage = (Stage) buttonsList.get(id).getScene().getWindow();
            thisStage.setScene(scene);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random random = new Random();
        int rand;
        for (int i = 0; i < 42; ) {
            rand = random.nextInt(42) + 1;
            if (!imagesId.contains(rand)) {
                imagesId.add(rand);
                i++;
            }
        }
        settingCollections();
        for (int i=0;i<42;i++)
            buttonsList.get(i).setDisable(true);
    }

    private void settingCollections() {
        paths.put(1, "file:src/Files/ExtremeLevelImages/design.png");
        paths.put(2, "file:src/Files/ExtremeLevelImages/document.png");
        paths.put(3, "file:src/Files/ExtremeLevelImages/files-and-folders.png");
        paths.put(4, "file:src/Files/ExtremeLevelImages/files-and-folders1.png");
        paths.put(5, "file:src/Files/ExtremeLevelImages/files-and-folders2.png");
        paths.put(6, "file:src/Files/ExtremeLevelImages/files-and-folders3.png");
        paths.put(7, "file:src/Files/ExtremeLevelImages/files-and-folders4.png");
        paths.put(8, "file:src/Files/ExtremeLevelImages/files-and-folders5.png");
        paths.put(9, "file:src/Files/ExtremeLevelImages/files-and-folders6.png");
        paths.put(10, "file:src/Files/ExtremeLevelImages/files-and-folders7.png");
        paths.put(11, "file:src/Files/ExtremeLevelImages/files-and-folders8.png");
        paths.put(12, "file:src/Files/ExtremeLevelImages/financial-report.png");
        paths.put(13, "file:src/Files/ExtremeLevelImages/medical-report.png");
        paths.put(14, "file:src/Files/ExtremeLevelImages/music.png");
        paths.put(15, "file:src/Files/ExtremeLevelImages/save.png");
        paths.put(16, "file:src/Files/ExtremeLevelImages/table.png");
        paths.put(17, "file:src/Files/ExtremeLevelImages/typography.png");
        paths.put(18, "file:src/Files/ExtremeLevelImages/user-data.png");
        paths.put(19, "file:src/Files/ExtremeLevelImages/video.png");
        paths.put(20, "file:src/Files/ExtremeLevelImages/volume.png");
        paths.put(21, "file:src/Files/ExtremeLevelImages/warning.png");
        paths.put(22, "file:src/Files/ExtremeLevelImages/design.png");
        paths.put(23, "file:src/Files/ExtremeLevelImages/document.png");
        paths.put(24, "file:src/Files/ExtremeLevelImages/files-and-folders.png");
        paths.put(25, "file:src/Files/ExtremeLevelImages/files-and-folders1.png");
        paths.put(26, "file:src/Files/ExtremeLevelImages/files-and-folders2.png");
        paths.put(27, "file:src/Files/ExtremeLevelImages/files-and-folders3.png");
        paths.put(28, "file:src/Files/ExtremeLevelImages/files-and-folders4.png");
        paths.put(29, "file:src/Files/ExtremeLevelImages/files-and-folders5.png");
        paths.put(30, "file:src/Files/ExtremeLevelImages/files-and-folders6.png");
        paths.put(31, "file:src/Files/ExtremeLevelImages/files-and-folders7.png");
        paths.put(32, "file:src/Files/ExtremeLevelImages/files-and-folders8.png");
        paths.put(33, "file:src/Files/ExtremeLevelImages/financial-report.png");
        paths.put(34, "file:src/Files/ExtremeLevelImages/medical-report.png");
        paths.put(35, "file:src/Files/ExtremeLevelImages/music.png");
        paths.put(36, "file:src/Files/ExtremeLevelImages/save.png");
        paths.put(37, "file:src/Files/ExtremeLevelImages/table.png");
        paths.put(38, "file:src/Files/ExtremeLevelImages/typography.png");
        paths.put(39, "file:src/Files/ExtremeLevelImages/user-data.png");
        paths.put(40, "file:src/Files/ExtremeLevelImages/video.png");
        paths.put(41, "file:src/Files/ExtremeLevelImages/volume.png");
        paths.put(42, "file:src/Files/ExtremeLevelImages/warning.png");
        imagesList.add(img1);
        imagesList.add(img2);
        imagesList.add(img3);
        imagesList.add(img4);
        imagesList.add(img5);
        imagesList.add(img6);
        imagesList.add(img7);
        imagesList.add(img8);
        imagesList.add(img9);
        imagesList.add(img10);
        imagesList.add(img11);
        imagesList.add(img12);
        imagesList.add(img13);
        imagesList.add(img14);
        imagesList.add(img15);
        imagesList.add(img16);
        imagesList.add(img17);
        imagesList.add(img18);
        imagesList.add(img19);
        imagesList.add(img20);
        imagesList.add(img21);
        imagesList.add(img22);
        imagesList.add(img23);
        imagesList.add(img24);
        imagesList.add(img25);
        imagesList.add(img26);
        imagesList.add(img27);
        imagesList.add(img28);
        imagesList.add(img29);
        imagesList.add(img30);
        imagesList.add(img31);
        imagesList.add(img32);
        imagesList.add(img33);
        imagesList.add(img34);
        imagesList.add(img35);
        imagesList.add(img36);
        imagesList.add(img37);
        imagesList.add(img38);
        imagesList.add(img39);
        imagesList.add(img40);
        imagesList.add(img41);
        imagesList.add(img42);
        buttonsList.add(btn1);
        buttonsList.add(btn2);
        buttonsList.add(btn3);
        buttonsList.add(btn4);
        buttonsList.add(btn5);
        buttonsList.add(btn6);
        buttonsList.add(btn7);
        buttonsList.add(btn8);
        buttonsList.add(btn9);
        buttonsList.add(btn10);
        buttonsList.add(btn11);
        buttonsList.add(btn12);
        buttonsList.add(btn13);
        buttonsList.add(btn14);
        buttonsList.add(btn15);
        buttonsList.add(btn16);
        buttonsList.add(btn17);
        buttonsList.add(btn18);
        buttonsList.add(btn19);
        buttonsList.add(btn20);
        buttonsList.add(btn21);
        buttonsList.add(btn22);
        buttonsList.add(btn23);
        buttonsList.add(btn24);
        buttonsList.add(btn25);
        buttonsList.add(btn26);
        buttonsList.add(btn27);
        buttonsList.add(btn28);
        buttonsList.add(btn29);
        buttonsList.add(btn30);
        buttonsList.add(btn31);
        buttonsList.add(btn32);
        buttonsList.add(btn33);
        buttonsList.add(btn34);
        buttonsList.add(btn35);
        buttonsList.add(btn36);
        buttonsList.add(btn37);
        buttonsList.add(btn38);
        buttonsList.add(btn39);
        buttonsList.add(btn40);
        buttonsList.add(btn41);
        buttonsList.add(btn42);
    }
}