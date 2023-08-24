package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * zet honderd random stipjes in beeld
 */
public class RandomStipjes extends Application {

    private static final int HOOGTE = 400;
    private static final int BREEDTE = 600;

    @FXML
    private static Canvas canvas;

    @FXML
    private static GraphicsContext context;

    @FXML
    private static Label coordinatenTekst;

    @Override
    public void start(Stage stage) {

        maakCanvas();
        plaatsStipjes();
        maakGUI(stage);
    }

    private void maakGUI(Stage stage) {
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(20,20,20,20 ));
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        coordinatenTekst = new Label("klik in het veld");
        coordinatenTekst.setFont(Font.font("Arial", FontWeight.MEDIUM, FontPosture.ITALIC,20));
        flowPane.getChildren().addAll(canvas, coordinatenTekst, maakKnoppenveld());

        Scene scene = new Scene(flowPane);
        stage.setScene(scene);
        stage.setTitle("honderd random stipjes");
        stage.show();
    }

    private HBox maakKnoppenveld() {
        Button btnVul = new Button("vul");
        btnVul.setOnAction(new VulHandler());
        Button btnLeeg = new Button("leeg");
        btnLeeg.setOnAction(new LeegHandler());
        HBox knoppenVeld = new HBox();
        knoppenVeld.getChildren().addAll(btnVul, btnLeeg);
        return knoppenVeld;
    }

    private static void maakCanvas() {
        canvas = new Canvas(BREEDTE,HOOGTE);
        context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        context.fillRect(0,0,BREEDTE, HOOGTE);
        canvas.setOnMouseClicked(new CanvasClickHandler());
    }

   static  class LeegHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            context.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
            context.setFill(Color.BLACK);
            context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        }
    }

    static class VulHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            plaatsStipjes();
        }
    }

    private static class CanvasClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            int x = (int)mouseEvent.getX();
            int y = (int)mouseEvent.getY();
            coordinatenTekst.setText(String.format("x: %d\ny: %d", x,y));
        }
    }
    private static void plaatsStipjes() {
        for(int i = 0; i < 100; i++){
                int pointX = getRandom(BREEDTE);
                int pointY = getRandom(HOOGTE);
                context.setStroke(new Color(Math.random(), Math.random(), Math.random(),1 ));
                context.strokeLine(pointX, pointY, pointX, pointY);
        }
    }

    public static int getRandom(int maxIncl){
        int spreidingBreedte = maxIncl + 1;
        double randomVanafNul = Math.random() * spreidingBreedte;
        return (int)randomVanafNul;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
