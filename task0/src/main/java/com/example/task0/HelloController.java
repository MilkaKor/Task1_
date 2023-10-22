package com.example.task0;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class HelloController {
    @FXML
    private TextField txtField;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private Label lab3;
    @FXML
    private Button but1;
    @FXML
    private Button but2;
    @FXML
    private Button but3;
    private Procent procent = new Procent();
    @FXML
    protected void onFirstClick() {
        float sum;
        try {
            sum = Float.parseFloat(txtField.getText());
            float pr = 15;
            procent.setSum(sum);
            float total = procent.countSum(sum, pr);
            float plus = procent.countPr(15);
            float totalRound = procent.countSumrnd(15);
            lab1.setFont(new Font("Georgia", 14));
            lab1.setText("Всего " + total + " р." + "\nЧаевые " + plus + " р."
                    + "\nК оплате " + totalRound + " р.");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка...");
            alert.setHeaderText("Сообщение");
            alert.setContentText("Введено не числовое значение");
            alert.show();
        }
    }
    @FXML
    protected void onTwoClick() {
        float sum;
        try {
            sum = Float.parseFloat(txtField.getText());
            float pr = 10;
            procent.setSum(sum);
            float plus = procent.countPr(10);
            float total = procent.countSum(sum, pr);
            lab2.setFont(new Font("Georgia", 15));
            float totalRound = procent.countSumrnd(10);
            lab2.setText("Всего " + total+" р."+"\nЧаевые " +plus+" р."
                    +        "\nК оплате " +totalRound+ " р." );
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка...");
            alert.setHeaderText("Сообщение");
            alert.setContentText("Введено не числовое значение");
            alert.show();

        }
    }
    @FXML
    protected void onThreeClick() {
        float sum;
        try {
            sum = Float.parseFloat(txtField.getText());
            float pr = 3;
            procent.setSum(sum);
            float total = procent.countSum(sum, pr);
            float plus = procent.countPr(3);
            float totalRound = procent.countSumrnd(3);
            lab3.setFont(new Font("Georgia", 15));
            lab3.setText("Всего " + total +" р."+"\nЧаевые " +plus+" р."
                    +"\nК оплате " +totalRound+ " р." );
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка...");
            alert.setHeaderText("Сообщение");
            alert.setContentText("Введено не числовое значение");
            alert.show();
        }
    }

}