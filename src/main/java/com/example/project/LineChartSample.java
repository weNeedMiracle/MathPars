package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartSample extends Application {
    @Override public void start(Stage stage) {
        String s = ASS.infixToRpn("x^2+6*3");
        String[] result = s.split("");
        System.out.println(Arrays.toString(result));
        solution sol = new solution();
        int xMin = -5, xMax = 5;

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("График");
        XYChart.Series series = new XYChart.Series();
        series.setName("x");
        for(int i = xMin; i<xMax+1; i++) {
            series.getData().add(new XYChart.Data(i, sol.stacky(result, i)));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
