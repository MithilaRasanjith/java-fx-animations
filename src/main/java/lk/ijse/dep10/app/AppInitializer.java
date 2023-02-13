package lk.ijse.dep10.app;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class AppInitializer extends Application {

    private Stage stageTransition;
    ;private Stage stageAnimation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }

    public void mainScene(Stage stage) {
        stage.setTitle("JavaFx Animation Demo");
        Label label = new Label("JavaFx Animation Model");
        Button btnTransaction = new Button("Transaction");
        Button btnAnimation = new Button("Animation");
        Label lblTime = new Label(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        KeyFrame key1 = new KeyFrame(Duration.seconds(1), event -> {
            lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        });

        Timeline timeline = new Timeline(key1);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();


        lblTime.setFont(new Font(18));
        lblTime.setMaxWidth(Double.MAX_VALUE);
        lblTime.setAlignment(Pos.CENTER);
        //

        label.setFont(new Font("ubuntu",20));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);

        btnTransaction.setFont(new Font("Ubuntu",20));
        btnTransaction.setMaxWidth(Double.MAX_VALUE);

        btnAnimation.setFont(new Font("Ubuntu",20));
        btnAnimation.setMaxWidth(Double.MAX_VALUE);






        //

        VBox root = new VBox(label, btnAnimation, btnTransaction, lblTime);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.setBackground(Background.fill(Color.web("grey")));

        stage.setScene(new Scene(root));

        btnTransaction.setOnAction(event -> {
            boolean flag = true;

            transaction();
        });
        btnAnimation.setOnAction(event -> {
            animation();
        });

    }

    public void transaction() {
        if(stageTransition != null) return;
        stageTransition = new Stage();
        stageTransition.setTitle("Transaction");

        stageTransition.setOnCloseRequest(event -> {
            stageTransition = null;

        });


        Button btnPlay = new Button("PLAY");
        Button btnStop = new Button("STOP");
        Label lblPreview = new Label("PREVIEW");

        VBox vBox = new VBox(btnPlay, btnStop);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(15));

        for (Node child : vBox.getChildren()) {
            Button btn = (Button) child;
            btn.setFont(new Font(20));
            btn.setMaxWidth(Double.MAX_VALUE);
            VBox.setVgrow(btn, Priority.ALWAYS);
        }
        HBox root = new HBox(vBox, lblPreview);

        lblPreview.setFont(new Font(50));
        lblPreview.setPadding(new Insets(150));
        lblPreview.setMaxHeight(Double.MAX_VALUE);
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);

        stageTransition.setScene(new Scene(root));
        stageTransition.show();

        KeyFrame key1 = new KeyFrame(Duration.millis(500), event -> {
            lblPreview.setTextFill(Color.GREEN);
        });

        KeyFrame key2 = new KeyFrame(Duration.millis(750), event -> {
            //lblPreview.setTranslateX(1.5);
            lblPreview.setTextFill(Color.YELLOW);
        });

        KeyFrame key3 = new KeyFrame(Duration.millis(1000), event -> {
            lblPreview.setTextFill(Color.RED);
//            lblPreview.setScaleX(1);
//            lblPreview.setScaleY(1);
        });

        KeyFrame key4 = new KeyFrame(Duration.millis(1250), event -> {
            //lblPreview.setTranslateX(50);
            lblPreview.setTextFill(Color.BLUE);
        });

        KeyFrame key5 = new KeyFrame(Duration.millis(1500), event -> {
            lblPreview.setTextFill(Color.PINK);
            //lblPreview.setTranslateX(0);
        });

        Timeline timeline = new Timeline(key1, key2, key3, key4, key5);
        timeline.setCycleCount(Animation.INDEFINITE);

        btnPlay.setOnAction(event -> {
            timeline.playFromStart();
        });

        btnStop.setOnAction(event -> {
            timeline.stop();
        });
    }

    public void animation() {
        if(stageAnimation != null) return;
        stageAnimation = new Stage();
        stageAnimation.setTitle("Animation");

        stageAnimation.setOnCloseRequest(event -> {
            stageTransition = null;

        });

        Button btn1 = new Button("FadeIn");
        Button btn2 = new Button("FadeOut");
        Button btn3 = new Button("Scale");
        Button btn4 = new Button("Rotate");
        Button btn5 = new Button("Translate X");
        Button btn6 = new Button("Translate Y");
        Label label = new Label("Preview");


        HBox hBox = new HBox(btn1, btn2,btn3,btn4,btn5,btn6);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));

        for (Node child : hBox.getChildren()) {
            Button btn = (Button) child;
            btn.setFont(new Font(20));
            btn.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(btn, Priority.ALWAYS);
        }

        VBox root = new VBox(hBox, label);

        label.setFont(new Font(50));
        label.setPadding(new Insets(150));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);



        stageAnimation.setScene(new Scene(root));
        stageAnimation.show();


        btn1.setOnAction(event -> {
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(5),label);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

        });
        btn2.setOnAction(event -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(5),label);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.play();

        });
        btn3.setOnAction(event -> {
            ScaleTransition scale = new ScaleTransition(Duration.seconds(5),label);
            scale.setFromX(1);
            scale.setToY(1);
            scale.setToY(2);
            scale.setFromX(2);
            scale.play();


        });
        btn4.setOnAction(event -> {
            RotateTransition rotate = new RotateTransition(Duration.seconds(1), label);
            rotate.setFromAngle(0);
            rotate.setToAngle(180);
            rotate.setAutoReverse(true);
            rotate.setOnFinished(e -> rotate.jumpTo(Duration.ZERO));
            rotate.play();
        });
        btn5.setOnAction(event -> {
            TranslateTransition translateX = new TranslateTransition(Duration.seconds(1), label);
            translateX.setFromX(-500);
            translateX.setToX(0);
            translateX.play();
        });
        btn6.setOnAction(event -> {
            TranslateTransition translateY = new TranslateTransition(Duration.seconds(1), label);
            translateY.setFromY(-500);
            translateY.setToY(0);
            translateY.play();
        });

    }


}