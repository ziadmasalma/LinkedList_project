package com.example.project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
    LinkedList westBankL = new LinkedList();//list that have the Literary west bank student
    LinkedList westBankS = new LinkedList();//list that have the Science gaza student
    LinkedList gazaL = new LinkedList();//list that have the Literary gaza student
    LinkedList gazaS = new LinkedList();//list that have the Science gaza student
    Tawjihi tawjihi = new Tawjihi();//save the data in it and add it to list
    String branch = new String();//use it when add a student from fx to set a branch defult

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Tawjihi");
        interfaseStart(stage);
        stage.show();

    }

    public void interfaseStart(Stage stage) {//the first interfase in project
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label lbStart = new Label("Welcome to the programme");
        lbStart.setTextFill(Color.GOLD);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        lbStart.setFont(font);

        Button btStart = new Button("Start");
        btStart.setFont(new Font(30));
        btStart.setMinSize(300, 100);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btStart.setFont(font1);
        btStart.setTextFill(Color.BLACK);

        btStart.setOnAction(e -> {
            region(stage);
        });

        Button btClose = new Button("Close");
        btClose.setFont(new Font(30));
        btClose.setMinSize(300, 100);
        btClose.setTextFill(Color.BLACK);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btClose.setFont(font2);
        btClose.setOnAction(e -> {
            stage.close();
        });

        vStart.getChildren().addAll(lbStart, btStart, btClose);
        Scene sceneStart = new Scene(vStart, 1200, 700);
        stage.setScene(sceneStart);
    }

    public void region(Stage stage) {//inter fase for select the region

        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label lbStart = new Label("Select your region");
        lbStart.setTextFill(Color.GOLD);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        lbStart.setFont(font);
        vStart.getChildren().add(lbStart);

        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Button btWest = new Button("WestBank");
        btWest.setFont(new Font(30));
        btWest.setMinSize(300, 100);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btWest.setFont(font1);
        btWest.setTextFill(Color.BLACK);
        btWest.setOnAction(e -> {
            if (westBankL.front == null && westBankS.front == null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose West Bank.txt");
                File file = fileChooser.showOpenDialog(stage);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String in = scanner.nextLine();
                        String[] sp = in.split(",");
                        tawjihi = new Tawjihi(Long.parseLong(sp[0]), sp[1], Double.parseDouble(sp[2]));
                        if (tawjihi.getBranch().compareTo("Scientific") == 0) {
                            westBankS.addSort(tawjihi);
                        } else
                            westBankL.addSort(tawjihi);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            westBankInterFase(stage);
        });

        Button btGaza = new Button("Gaza");
        btGaza.setFont(new Font(30));
        btGaza.setMinSize(300, 100);
        btGaza.setTextFill(Color.BLACK);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btGaza.setFont(font2);
        btGaza.setOnAction(e -> {
            if (gazaL.front == null && gazaS.front == null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose Gaza.txt");
                File file = fileChooser.showOpenDialog(stage);
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String in = scanner.nextLine();
                        String[] sp = in.split(",");
                        tawjihi = new Tawjihi(Long.parseLong(sp[0]), sp[1], Double.parseDouble(sp[2]));
                        if (tawjihi.getBranch().compareTo("Scientific") == 0) {
                            gazaS.addSort(tawjihi);
                        } else
                            gazaL.addSort(tawjihi);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            gazaInterFase(stage);
        });
        hStart.getChildren().addAll(btWest, btGaza);
        vStart.getChildren().add(hStart);
        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(300, 100);
        btBack.setTextFill(Color.BLACK);
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btBack.setFont(font3);
        vStart.getChildren().add(btBack);

        btBack.setOnAction(e -> {
            interfaseStart(stage);
        });

        Scene sceneStart = new Scene(vStart, 1200, 700);
        stage.setScene(sceneStart);

    }

    public void westBankInterFase(Stage stage) {//westbank interfase for chose youre branch
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label lbStart = new Label("Select your region");
        lbStart.setTextFill(Color.GOLD);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        lbStart.setFont(font);
        vStart.getChildren().add(lbStart);

        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Button btscientific = new Button("Scientific");
        btscientific.setFont(new Font(30));
        btscientific.setMinSize(300, 100);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btscientific.setFont(font1);
        btscientific.setTextFill(Color.BLACK);
        btscientific.setOnAction(e -> {
            branch = "Scientific";
            interfase4(stage, westBankS);
        });

        Button btliterary = new Button("Literary");
        btliterary.setFont(new Font(30));
        btliterary.setMinSize(300, 100);
        btliterary.setTextFill(Color.BLACK);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btliterary.setFont(font2);
        btliterary.setOnAction(e -> {
            branch = "Literary";
            interfase4(stage, westBankL);
        });
        hStart.getChildren().addAll(btscientific, btliterary);
        vStart.getChildren().add(hStart);
        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(300, 100);
        btBack.setTextFill(Color.BLACK);
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btBack.setFont(font3);
        vStart.getChildren().add(btBack);

        btBack.setOnAction(e -> {
            region(stage);
        });

        Scene sceneStart = new Scene(vStart, 1200, 700);
        stage.setScene(sceneStart);


    }

    public void gazaInterFase(Stage stage) {//gaza interfase for chose youre branch
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label lbStart = new Label("Select your region");
        lbStart.setTextFill(Color.GOLD);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        lbStart.setFont(font);
        vStart.getChildren().add(lbStart);

        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Button btscientific = new Button("Scientific");
        btscientific.setFont(new Font(30));
        btscientific.setMinSize(300, 100);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btscientific.setFont(font1);
        btscientific.setTextFill(Color.BLACK);
        btscientific.setOnAction(e -> {
            branch = "Scientific";
            interfase4(stage, gazaS);
        });

        Button btliterary = new Button("Literary");
        btliterary.setFont(new Font(30));
        btliterary.setMinSize(300, 100);
        btliterary.setTextFill(Color.BLACK);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btliterary.setFont(font2);
        btliterary.setOnAction(e -> {
            branch = "Literary";
            interfase4(stage, gazaL);
        });
        hStart.getChildren().addAll(btscientific, btliterary);
        vStart.getChildren().add(hStart);
        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(300, 100);
        btBack.setTextFill(Color.BLACK);
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btBack.setFont(font3);
        vStart.getChildren().add(btBack);

        btBack.setOnAction(e -> {
            region(stage);
        });

        Scene sceneStart = new Scene(vStart, 1200, 700);
        stage.setScene(sceneStart);


    }


    public void interfase4(Stage stage, LinkedList add) {//interfase for chose what you wont to edit in list

        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label lbStart = new Label("Choose what you want");
        lbStart.setTextFill(Color.GOLD);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        lbStart.setFont(font);
        vStart.getChildren().add(lbStart);

        HBox hStart = new HBox(40);
        hStart.setAlignment(Pos.CENTER);

        Button btDelete = new Button("Delete Students");
        btDelete.setFont(new Font(30));
        btDelete.setMinSize(300, 100);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25);
        btDelete.setFont(font1);
        btDelete.setTextFill(Color.BLACK);
        btDelete.setOnAction(e -> {
            deleatInterFace(stage, add);
        });

        Button btSearch = new Button("Search Students");
        btSearch.setFont(new Font(30));
        btSearch.setMinSize(300, 100);
        btSearch.setTextFill(Color.BLACK);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25);
        btSearch.setFont(font2);
        btSearch.setTextFill(Color.BLACK);
        btSearch.setOnAction(e -> {
            searchInterFase(stage, add);
        });

        hStart.getChildren().addAll(btDelete, btSearch);

        HBox hStart2 = new HBox(40);
        hStart2.setAlignment(Pos.CENTER);

        Button btTop = new Button("Top 10 Students");
        btTop.setFont(new Font(30));
        btTop.setMinSize(300, 100);
        btTop.setTextFill(Color.BLACK);
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25);
        btTop.setFont(font3);
        btTop.setTextFill(Color.BLACK);
        btTop.setOnAction(e -> {
            topInterFase(stage, add);
        });

        Button btPercentage = new Button("Percentage Of Students");
        btPercentage.setFont(new Font(30));
        btPercentage.setMinSize(300, 100);
        btPercentage.setTextFill(Color.BLACK);
        Font font4 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20);
        btPercentage.setFont(font4);
        btPercentage.setTextFill(Color.BLACK);
        btPercentage.setOnAction(e -> {
            aboveInterface(stage, add);
        });

        hStart2.getChildren().addAll(btTop, btPercentage);

        HBox hStart3 = new HBox(40);
        hStart3.setAlignment(Pos.CENTER);

        Button btMean = new Button("Mean Students");
        btMean.setFont(new Font(30));
        btMean.setMinSize(300, 100);
        btMean.setTextFill(Color.BLACK);
        Font font5 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25);
        btMean.setFont(font5);
        btMean.setTextFill(Color.BLACK);
        btMean.setOnAction(e -> {
            meanInterfase(stage, add);
        });


        Button btMode = new Button("Mode Students");
        btMode.setFont(new Font(30));
        btMode.setMinSize(300, 100);
        btMode.setTextFill(Color.BLACK);
        Font font6 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25);
        btMode.setFont(font6);
        btMode.setTextFill(Color.BLACK);
        btMode.setOnAction(e -> {
            modeInterFase(stage, add);
        });

        hStart3.getChildren().addAll(btMean, btMode);

        HBox hStart4 = new HBox(500);
        hStart4.setAlignment(Pos.CENTER);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(300, 100);
        btBack.setTextFill(Color.BLACK);
        Font font7 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btBack.setFont(font7);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            region(stage);
        });

        Button btAdd = new Button("Add Students");
        btAdd.setFont(new Font(30));
        btAdd.setMinSize(300, 100);
        btAdd.setTextFill(Color.BLACK);
        Font font8 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
        btAdd.setFont(font8);
        btAdd.setTextFill(Color.BLACK);
        btAdd.setOnAction(e -> {
            addInterFace(stage, add);
        });

        hStart4.getChildren().addAll(btBack, btAdd);

        vStart.getChildren().addAll(hStart, hStart2, hStart3, hStart4);
        Scene sceneStart = new Scene(vStart, 1200, 700);
        stage.setScene(sceneStart);

    }

    public void deleatInterFace(Stage stage, LinkedList<Tawjihi> add) {//interfase for delete student from list
        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Seat Number:");
        l1.setFont(new Font(14));
        l1.setTextFill(Color.GOLD);

        TextField t1 = new TextField();

        hStart.getChildren().addAll(l1, t1);

        HBox hStart1 = new HBox(30);
        hStart1.setAlignment(Pos.CENTER);

        Label l2 = new Label("Average:");
        l2.setFont(new Font(20));
        l2.setTextFill(Color.GOLD);

        TextField t2 = new TextField();
        t2.setDisable(true);

        hStart1.getChildren().addAll(l2, t2);

        HBox hStart2 = new HBox(30);
        hStart2.setAlignment(Pos.CENTER);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });

        Button btDelete = new Button("Delete");
        btDelete.setFont(new Font(30));
        btDelete.setMinSize(100, 50);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btDelete.setFont(font1);
        btDelete.setTextFill(Color.BLACK);
        btDelete.setDisable(true);
        btDelete.setOnAction(e -> {
            if (add.deleteStudent(add, Long.parseLong(t1.getText()))) {
                t2.setText("delete student");
            }
            btDelete.setDisable(true);
        });

        Button btSearch = new Button("Search");
        btSearch.setFont(new Font(30));
        btSearch.setMinSize(100, 50);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btSearch.setFont(font2);
        btSearch.setTextFill(Color.BLACK);
        btSearch.setOnAction(e -> {
            Long n = Long.parseLong(t1.getText());
            Tawjihi serach = add.Ser(add, n);
            if (serach == null)
                t2.setText("student not found");
            else {
                t2.setText(Double.toString(serach.getAvg()));
                btDelete.setDisable(false);
            }
        });

        hStart2.getChildren().addAll(btBack, btDelete, btSearch);

        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);
        vStart.getChildren().addAll(hStart, hStart1, hStart2);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);


    }

    public void addInterFace(Stage stage, LinkedList add) {//interfase for add a student node to list
        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Seat Number:");
        l1.setFont(new Font(14));
        l1.setTextFill(Color.GOLD);

        TextField t1 = new TextField();

        hStart.getChildren().addAll(l1, t1);

        HBox hStart1 = new HBox(30);
        hStart1.setAlignment(Pos.CENTER);

        Label l2 = new Label("Average:");
        l2.setFont(new Font(20));
        l2.setTextFill(Color.GOLD);

        TextField t2 = new TextField();
        t2.setDisable(true);
        hStart1.getChildren().addAll(l2, t2);

        HBox hStart2 = new HBox(30);
        hStart2.setAlignment(Pos.CENTER);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });

        Button btAdd = new Button("Add");
        btAdd.setFont(new Font(30));
        btAdd.setMinSize(100, 50);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btAdd.setFont(font1);
        btAdd.setTextFill(Color.BLACK);
        btAdd.setDisable(true);
        btAdd.setOnAction(e -> {
            tawjihi = new Tawjihi(Long.parseLong(t1.getText()), branch, Double.parseDouble(t2.getText()));
            add.addSort(tawjihi);
            btAdd.setDisable(true);
            t2.setDisable(true);
            t2.setText("done");
        });

        Button btsearch = new Button("Search");
        btsearch.setFont(new Font(30));
        btsearch.setMinSize(100, 50);
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btsearch.setFont(font2);
        btsearch.setTextFill(Color.BLACK);
        btsearch.setOnAction(e -> {
            Long n = Long.parseLong(t1.getText());
            Tawjihi serach = add.Ser(add, n);
            if (serach == null) {
                t2.setDisable(false);
                btAdd.setDisable(false);
            } else {
                t2.setText(Double.toString(serach.getAvg()));
            }
        });

        hStart2.getChildren().addAll(btBack, btAdd, btsearch);

        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);
        vStart.getChildren().addAll(hStart, hStart1, hStart2);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);


    }

    public void searchInterFase(Stage stage, LinkedList add) {//search for a student by his seat number
        HBox hStart = new HBox(30);
        hStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Seat Number:");
        l1.setFont(new Font(14));
        l1.setTextFill(Color.GOLD);

        TextField t1 = new TextField();

        hStart.getChildren().addAll(l1, t1);

        HBox hStart1 = new HBox(30);
        hStart1.setAlignment(Pos.CENTER);

        Label l2 = new Label("Average:");
        l2.setFont(new Font(20));
        l2.setTextFill(Color.GOLD);

        TextField t2 = new TextField();
        t2.setDisable(true);

        hStart1.getChildren().addAll(l2, t2);

        HBox hStart2 = new HBox(30);
        hStart2.setAlignment(Pos.CENTER);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });

        Button btSearch = new Button("Search");
        btSearch.setFont(new Font(30));
        btSearch.setMinSize(100, 50);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btSearch.setFont(font1);
        btSearch.setTextFill(Color.BLACK);
        btSearch.setOnAction(e -> {
            Tawjihi search = add.Ser(add, Long.parseLong(t1.getText()));
            if (search != null)
                t2.setText(Double.toString(search.getAvg()));
            else t2.setText("student not found");
        });

        hStart2.getChildren().addAll(btBack, btSearch);

        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);
        vStart.getChildren().addAll(hStart, hStart1, hStart2);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);


    }

    public void topInterFase(Stage stage, LinkedList add) {//get the top 10
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Top 10 Students according to their grades");
        l1.setFont(new Font(22));
        l1.setTextFill(Color.GOLD);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        TextArea t1 = new TextArea();
        t1.setMinSize(200, 400);
        pane.add(t1, 0, 0);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });
        Button btprint = new Button("Print");
        btprint.setFont(new Font(30));
        btprint.setMinSize(100, 50);
        btprint.setTextFill(Color.BLACK);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btprint.setFont(font1);
        btprint.setTextFill(Color.BLACK);
        btprint.setOnAction(e -> {
            t1.setText(add.topTen().toString());
        });

        vStart.getChildren().addAll(l1, pane, btBack, btprint);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);
    }

    public void meanInterfase(Stage stage, LinkedList add) {//get the mean
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Mean Students");
        l1.setFont(new Font(22));
        l1.setTextFill(Color.GOLD);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        TextField t1 = new TextField();
        t1.setDisable(true);
        pane.add(t1, 0, 0);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });
        Button btmean = new Button("calculate mean");
        btmean.setFont(new Font(30));
        btmean.setMinSize(100, 50);
        btmean.setTextFill(Color.BLACK);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btmean.setFont(font1);
        btmean.setTextFill(Color.BLACK);
        btmean.setOnAction(e -> {
            t1.setText(Double.toString(add.getMean()));
        });

        vStart.getChildren().addAll(l1, pane, btBack, btmean);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);
    }

    public void aboveInterface(Stage stage, LinkedList add) {//get the number and per for a specific grade

                VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);


        TextField t1 = new TextField();
        Label l1 = new Label("Grade");
        l1.setFont(new Font(22));
        l1.setTextFill(Color.GOLD);
        HBox hb1 = new HBox(30);
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(l1, t1);

        TextField t2 = new TextField();
        t2.setDisable(true);
        Label l2 = new Label("Number of avg above");
        l2.setFont(new Font(17));
        l2.setTextFill(Color.GOLD);
        HBox hb2 = new HBox(30);
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(l2, t2);

        TextField t3 = new TextField();
        t3.setDisable(true);
        Label l3 = new Label("Percentage of avg above");
        l3.setFont(new Font(17));
        l3.setTextFill(Color.GOLD);
        HBox hb3 = new HBox(30);
        hb3.setAlignment(Pos.CENTER);
        hb3.getChildren().addAll(l3, t3);

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(hb1, hb2, hb3);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });
        Button btget = new Button("Calculate");
        btget.setFont(new Font(30));
        btget.setMinSize(100, 50);
        btget.setTextFill(Color.BLACK);
        btget.setFont(font);
        btget.setTextFill(Color.BLACK);
        HBox hb4 = new HBox(30);
        hb4.setAlignment(Pos.CENTER);
        hb4.getChildren().addAll(btBack, btget);

        vStart.getChildren().addAll(vb, hb4);
        btget.setOnAction(e -> {
            t2.setText(Integer.toString(add.numberAboveGrade(Double.parseDouble(t1.getText()))));
            t3.setText(Double.toString(add.perAboveGrade(Double.parseDouble(t1.getText()))));
        });

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);
    }

    public void modeInterFase(Stage stage, LinkedList add) { //get the mode for a list
        VBox vStart = new VBox(30);
        vStart.setAlignment(Pos.CENTER);

        Label l1 = new Label("Mode Students");
        l1.setFont(new Font(22));
        l1.setTextFill(Color.GOLD);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        TextField t1 = new TextField();
        t1.setDisable(true);
        pane.add(t1, 0, 0);

        Button btBack = new Button("Back");
        btBack.setFont(new Font(30));
        btBack.setMinSize(100, 50);
        btBack.setTextFill(Color.BLACK);
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        btBack.setFont(font);
        btBack.setTextFill(Color.BLACK);

        btBack.setOnAction(e -> {
            interfase4(stage, add);
        });
        Button btMode = new Button("Mode");
        btMode.setFont(new Font(30));
        btMode.setMinSize(100, 50);
        btMode.setTextFill(Color.BLACK);
        btMode.setFont(font);
        btMode.setTextFill(Color.BLACK);
        btMode.setOnAction(e -> {
            t1.setText(Double.toString(add.mode()));
        });

        vStart.getChildren().addAll(l1, pane, btBack, btMode);

        Scene scene = new Scene(vStart, 1200, 700);
        stage.setScene(scene);
    }


}