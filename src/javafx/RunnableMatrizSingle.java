/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class RunnableMatrizSingle implements Runnable {

    private Label[][] matriz;
    static int quantidade = 0;

    public RunnableMatrizSingle(Label[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public void run() {
        for (int linha = 0; linha <= 9; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {
                try {
                    Label label = matriz[linha][coluna];
                    Platform.runLater(() -> label.setStyle("-fx-border-color:black; -fx-background-color:#90EE90"));
                    Platform.runLater(() -> RunnableMatrizSingle.quantidade++);
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(RunnableMatrizSingle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
