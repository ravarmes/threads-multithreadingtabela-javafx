/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Rafael Vargas Mequita
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPaneSingleThread;
    @FXML
    private AnchorPane anchorPaneMultiThread;

    private Label[][] matrizSingleThread = new Label[10][10];

    private Label[][] matrizMultiThread = new Label[10][10];
    @FXML
    private Label labelTimerSingleThread;
    @FXML
    private Label labelTimerMultiThread;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        iniciarMatriz(anchorPaneSingleThread, matrizSingleThread);
        iniciarMatriz(anchorPaneMultiThread, matrizMultiThread);

        RunnableMatrizSingle runnableMatrizSingle = new RunnableMatrizSingle(this.matrizSingleThread);
        Thread t1 = new Thread(runnableMatrizSingle);
        
        
        RunnableMatrizMulti runnableMatrizMulti1 = new RunnableMatrizMulti(this.matrizMultiThread, 0);
        Thread t2 = new Thread(runnableMatrizMulti1);
        RunnableMatrizMulti runnableMatrizMulti2 = new RunnableMatrizMulti(this.matrizMultiThread, 1);
        Thread t3 = new Thread(runnableMatrizMulti2);
        RunnableMatrizMulti runnableMatrizMulti3 = new RunnableMatrizMulti(this.matrizMultiThread, 2);
        Thread t4 = new Thread(runnableMatrizMulti3);
        RunnableMatrizMulti runnableMatrizMulti4 = new RunnableMatrizMulti(this.matrizMultiThread, 3);
        Thread t5 = new Thread(runnableMatrizMulti4);
        RunnableMatrizMulti runnableMatrizMulti5 = new RunnableMatrizMulti(this.matrizMultiThread, 4);
        Thread t6 = new Thread(runnableMatrizMulti5);
        RunnableMatrizMulti runnableMatrizMulti6 = new RunnableMatrizMulti(this.matrizMultiThread, 5);
        Thread t7 = new Thread(runnableMatrizMulti6);
        RunnableMatrizMulti runnableMatrizMulti7 = new RunnableMatrizMulti(this.matrizMultiThread, 6);
        Thread t8 = new Thread(runnableMatrizMulti7);
        RunnableMatrizMulti runnableMatrizMulti8 = new RunnableMatrizMulti(this.matrizMultiThread, 7);
        Thread t9 = new Thread(runnableMatrizMulti8);
        RunnableMatrizMulti runnableMatrizMulti9 = new RunnableMatrizMulti(this.matrizMultiThread, 8);
        Thread t10 = new Thread(runnableMatrizMulti9);
        RunnableMatrizMulti runnableMatrizMulti10 = new RunnableMatrizMulti(this.matrizMultiThread, 9);
        Thread t11 = new Thread(runnableMatrizMulti10);
        
        RunnableTimer runnableTimer = new RunnableTimer(this.labelTimerSingleThread, this.labelTimerMultiThread);
        Thread threadTimer = new Thread(runnableTimer);
        
        threadTimer.start();
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
    }

    public void iniciarMatriz(AnchorPane anchorPane, Label[][] matriz) {
        int x = 25;
        int y = 50;
        for (int linha = 0; linha <= 9; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {

                Label label = new Label();
                label.setPrefHeight(25);
                label.setPrefWidth(25);
                label.setLineSpacing(1);
                label.setLayoutX(x);
                label.setLayoutY(y);
                label.setStyle("-fx-border-color:black;");
                anchorPane.getChildren().addAll(label);

                matriz[linha][coluna] = label;

                x = x + 25;
            }
            y = y + 25;
            x = 25;
        }
    }

}
