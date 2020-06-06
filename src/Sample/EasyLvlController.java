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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasyLvlController implements Initializable {
    private int numberOfPars = 0, score = 0, numberOfMoves = 0;
    private boolean startStop = false;
    private String lastPicturePath = null, currentPath = null;
    private Button lastBtn = null;
    private ImageView lastImage = null, penultimateImage = null;
    private Map<Integer, String> paths = new TreeMap<>();
    private List<Integer> imagesId = new ArrayList<>(8);

    @FXML
    private Label movesLabel;

    @FXML
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    private List<ImageView> imagesList = new ArrayList<>(8);

    @FXML
    private Button startStopBtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private List<Button> buttonsList = new ArrayList<>(8);

    @FXML
    private void StartStopBtnClicked() {
        if (startStop == false) {
            for (int i=0;i<8;i++)
                imagesList.get(i).setImage(new Image(paths.get(imagesId.get(i))));
            startStop = true;
            startStopBtn.setText("Stop");
        } else {
            for (int i=0;i<8;i++)
                imagesList.get(i).setImage(new Image("file:src/Files/OtherImages/java.png"));
            startStopBtn.setDisable(true);
            for (int i=0;i<8;i++)
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
                buttonsList.get(id).setOpacity(0.5);
                numberOfPars++;
                score += 20;
            } else {
                imagesList.get(id).setImage(new Image(currentPath));
            }
        }
        penultimateImage = lastImage;
        lastPicturePath = currentPath;
        lastBtn = buttonsList.get(id);
        lastImage = imagesList.get(id);
        // sprawdzanie warunku i koniec gry
        if (numberOfPars == 4) {
            score += 40 - (numberOfMoves / 2) * 10;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("                                            ****BRAWO!****");
            alert.setHeaderText(null);
            alert.setContentText("Udało ci się ukończyć łatwy poziom :)\n" + "Ilość ruchów: " + numberOfMoves / 2 + "\nIlosć punktów: " + score);
            alert.showAndWait();
            unlocking();
            savingScores(score);
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
        for (int i = 0; i < 8; ) {
            rand = random.nextInt(8) + 1;
            if (!imagesId.contains(rand)) {
                imagesId.add(rand);
                i++;
            }
        }
        settingCollections();
        for (int i=0;i<8;i++)
            buttonsList.get(i).setDisable(true);
    }

    private void unlocking() throws IOException {
        File file = new File("src/Files/lock.txt");
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        int i = Integer.parseInt(str);
        if (i == 0) {
            FileWriter fr = null;
            try {
                fr = new FileWriter(file);
                fr.write(str.replaceAll("\\d", "1"));
            } catch (IOException e) { e.printStackTrace(); }
            finally {
                try {
                    fr.close();
                } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    static void savingScores(int score) throws FileNotFoundException {
        int[] fiveBestScores = new int[6];
        File file = new File("src/Files/score.txt");
        Scanner scanner = new Scanner(file);
        String str = "";
        while (scanner.hasNextLine()){ str += scanner.nextLine() + "\n"; }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        int i=0;
        while (matcher.find()){
            fiveBestScores[i] = Integer.parseInt(matcher.group());
            i++;
        }
        FileWriter fr = null;
        try{
            fr = new FileWriter(file);
            if (score > fiveBestScores[0]){ fr.write(str.replaceAll("a\\)\\s\\d+\\spkt","a) " + score + " pkt")); }
            else if (score > fiveBestScores[1]){ fr.write(str.replaceAll("b\\)\\s\\d+\\spkt","b) " + score + " pkt")); }
            else if (score > fiveBestScores[2]){ fr.write(str.replaceAll("c\\)\\s\\d+\\spkt","c) " + score + " pkt")); }
            else if (score > fiveBestScores[3]){ fr.write(str.replaceAll("d\\)\\s\\d+\\spkt","d) " + score + " pkt")); }
            else if (score > fiveBestScores[4]){ fr.write(str.replaceAll("e\\)\\s\\d+\\spkt","e) " + score + " pkt")); }
            else { fr.write(str); }
        } catch (IOException e) { e.printStackTrace(); }
        finally { try { fr.close(); } catch (IOException e) { e.printStackTrace(); } }
    }

    private void settingCollections() {
        paths.put(1, "file:src/Files/EasyLevelImages/nurse.png");
        paths.put(2, "file:src/Files/EasyLevelImages/nurse.png");
        paths.put(3, "file:src/Files/EasyLevelImages/people.png");
        paths.put(4, "file:src/Files/EasyLevelImages/people.png");
        paths.put(5, "file:src/Files/EasyLevelImages/person.png");
        paths.put(6, "file:src/Files/EasyLevelImages/person.png");
        paths.put(7, "file:src/Files/EasyLevelImages/person1.png");
        paths.put(8, "file:src/Files/EasyLevelImages/person1.png");
        imagesList.add(img1);
        imagesList.add(img2);
        imagesList.add(img3);
        imagesList.add(img4);
        imagesList.add(img5);
        imagesList.add(img6);
        imagesList.add(img7);
        imagesList.add(img8);
        buttonsList.add(btn1);
        buttonsList.add(btn2);
        buttonsList.add(btn3);
        buttonsList.add(btn4);
        buttonsList.add(btn5);
        buttonsList.add(btn6);
        buttonsList.add(btn7);
        buttonsList.add(btn8);
    }
}