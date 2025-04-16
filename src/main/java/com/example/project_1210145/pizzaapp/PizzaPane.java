/*
Name : yazan AbuAlown
ID : 1210145
Lecture Section : 3
Lab Section : 4L
 */

package com.example.project_1210145.pizzaapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
    Pane class that encapsulates PizzaApp UI and its methods such as calculating the order
 */
public class PizzaPane extends BorderPane {

    //declaring data fields for Pizza Pane
    ArrayList<PizzaOrder> pizzaOrders = new ArrayList<>();
    protected  Label[] lbDelivery;
    protected  Label[] lbSeated;
    Label[] labels = {new Label("Topping Price"), new Label("Order Price")};
    protected GridPane gridPane = new GridPane();
    protected ComboBox<String> cbOrderType = new ComboBox<>();
    protected CheckBox[] boxes = {new CheckBox("Olive"),
            new CheckBox("Onions"),
            new CheckBox("Green Peppers")};

    RadioButton[] radioButtons = new RadioButton[3];
    Button[] buttons =
            {new Button("Process Order"), new Button("Print Order"), new Button("RESET")};
    TextField tfName = new TextField();
    TextField tfService = new TextField();
    TextField tfNumber = new TextField();
    TextField tfZone = new TextField();
    TextField tfTrip = new TextField();


    public  PizzaPane() {      //default constructor


       /* ImageView pizza = new ImageView("C:\\Users\\USER-Q\\Downloads\\pizza3.png");     //Pizza image
        pizza.setFitHeight(30);        //adjusting width and height
        pizza.setFitWidth(30);
        */

        Text txtPizzaSize = new Text("Pizza Size");

        //Changing text font

        txtPizzaSize.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 17));

        Text txtListOfToppings = new Text("List Of Toppings");
        txtListOfToppings.setFont(txtPizzaSize.getFont());


        //constructing a labels and adjusting its style

        Label name = new Label("Customer name : ");
        tfName.setStyle("-fx-border-color: black; -fx-background-color: white");

        //Hbox for placing nodes in the title in a single row

        HBox nameAndField = new HBox(10);
        nameAndField.setPadding(new Insets(5));
        nameAndField.getChildren().addAll(name, tfName);
        setTop(nameAndField);
        nameAndField.setStyle("-fx-background-color: #cbcbcb");

        //This Vbox holds all the nodes at the center of the borderPane in a vertical manner
        VBox orderType = new VBox(5);
        orderType.setPadding(new Insets(10));
        orderType.setAlignment(Pos.TOP_CENTER);
        Text txtOrder = new Text("Order type");
        orderType.getChildren().add(txtOrder);

        setStyle("-fx-pref-width: 120; -fx-pref-height: 1; -fx-border-color: black; -fx-background-color: white");
        cbOrderType.getItems().addAll("ToGo", "Delivery", "Seated");

        cbOrderType.setValue("ToGo");
        orderType.getChildren().add(cbOrderType);
        cbOrderType.setStyle("-fx-border-color: black; -fx-background-color: white");
        txtOrder.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
        HBox rbType = new HBox(50);
        rbType.setAlignment(Pos.CENTER);

        orderType.getChildren().add(txtPizzaSize);


        //buttons for choosing pizza size

        radioButtons[0] = new RadioButton("small");
        radioButtons[1] = new RadioButton("medium");
        radioButtons[2] = new RadioButton("large");

        //this radioButton (small size) is checked by default
        radioButtons[0].setSelected(true);

        ToggleGroup group = new ToggleGroup();


        //this loop groups all radio buttons

        for (int i = 0;i<3;i++) {
            rbType.getChildren().add(radioButtons[i]);
            radioButtons[i].setToggleGroup(group);
        }

        //adds the radioButtons to the Vbox
        orderType.getChildren().add(rbType);
        txtOrder.setTextAlignment(TextAlignment.CENTER);
        buttons[0].setOnAction(e -> {

        });

        //adds the Text reading (List of toppings) to the Vbox
        orderType.getChildren().add(txtListOfToppings);

        //Hbox to place the checkboxes in a horizontal manner

        HBox hbListOfToppings = new HBox(50);
        hbListOfToppings.setPadding(new Insets(5));
        hbListOfToppings.setAlignment(Pos.CENTER);

        //loop for adding all the checkBoxes to the hbox
        for (int i = 0;i<3;i++) {
            hbListOfToppings.getChildren().add(boxes[i]);
        }

        orderType.getChildren().add(hbListOfToppings);


        //sets the Vbox at the center of the border pane(root pane)

        setCenter(orderType);

        //Hbox for containing the control UI buttons
        HBox boxButtons = new HBox(40);
        boxButtons.setAlignment(Pos.CENTER);

        for (int i = 0;i<3;i++) {
            boxButtons.getChildren().add(buttons[i]);
        }
        setBottom(boxButtons);

        //sets the horizontal spacing between the text fields
        gridPane.setHgap(30);
        gridPane.setPadding(new Insets(10));


        //adds labels attached with text fields
        for (int i = 0;i<2;i++) {
            TextField textField = new TextField();
            if (i == 1) {
                textField.setEditable(false);
            }
            textField.setPrefColumnCount(5);
            labels[i].setGraphic(textField);
            labels[i].setAlignment(Pos.CENTER);
            labels[i].setContentDisplay(ContentDisplay.BOTTOM);
            gridPane.addRow(1, labels[i]);
        }


        gridPane.setAlignment(Pos.CENTER);
        orderType.getChildren().add(gridPane);


        tfZone.setPrefColumnCount(5);

        tfNumber.setPrefColumnCount(5);


        tfService.setPrefColumnCount(5);

        tfTrip.setPrefColumnCount(5);
        lbDelivery = new Label[2];

        lbDelivery[0] = new Label("Trip rate");
        lbDelivery[1] = new Label("Zone");

        lbDelivery[0].setGraphic(tfTrip);
        lbDelivery[0].setContentDisplay(ContentDisplay.BOTTOM);

        lbDelivery[1].setGraphic(tfZone);
        lbDelivery[1].setContentDisplay(ContentDisplay.BOTTOM);

        lbSeated = new Label[2];
        lbSeated[0] = new Label("Number of People");
        lbSeated[0].setGraphic(tfNumber);
        lbSeated[0].setContentDisplay(ContentDisplay.BOTTOM);

        lbSeated[1] = new Label("Service Charge");
        lbSeated[1].setGraphic(tfService);
        lbSeated[1].setContentDisplay(ContentDisplay.BOTTOM);



        //Binding the handler with a source object (checkbox)

        cbOrderType.setOnAction(e-> {

            //This if statement is executed if "Delivery" checkbox is chosen and if the gridPane does not already
            //contain the delivery labels that we wish to add

            if (cbOrderType.getValue().equals("Delivery") && (!gridPane.getChildren().contains(lbDelivery[0]))) {

                gridPane.getChildren().removeAll(lbSeated); //removes all nodes pertaining to seated (in lbSeated Array)
                gridPane.addRow(0, lbDelivery);         //adds delivery nodes to the first row of the grid pane

            }

            //This if statement is executed if "ToGo" checkbox is chosen and if the gridPane does not already
            //contain the ToGo labels that we wish to add

            else if (cbOrderType.getValue().equals("ToGo")) {

                gridPane.getChildren().removeAll(lbDelivery);
                gridPane.getChildren().removeAll(lbSeated);
            }

            //This if statement is executed if "Seated" checkbox is chosen and if the gridPane does not already
            //contain the Seated labels that we wish to add

            else if (cbOrderType.getValue().equals("Seated") && (!gridPane.getChildren().contains(lbSeated[0]))) {

                gridPane.getChildren().removeAll(lbDelivery);
                gridPane.addRow(0, lbSeated);

            }
        });


        //setting the action for the first control button
        buttons[1].setOnAction(e->  {
            PizzaOrder.sortOrders(pizzaOrders);
            printOrders();
        });
        buttons[0].setOnAction(e-> {
            calculatePizzaOrder();
        });
        buttons[2].setOnAction(e -> setDefault());

    }

    /*
    method to calculate pizza order price by the aid of the pizzaOrder class
    is attached with process order button, this method also adds the pizza object
    to the array list
    */
    public void calculatePizzaOrder() {


        String name = tfName.getText();
        int size = 0, zone;
        int numberOfToppings = 0, numberOfPeople;
        double tripRate, serviceCharge, toppingPrice;

        TextField tfToppingPrice = (TextField) (labels[0]).getGraphic();
        TextField tfOrder = (TextField) (labels[1]).getGraphic();
        toppingPrice = Double.parseDouble(tfToppingPrice.getText());

        PizzaOrder pizzaOrder;

        for (int i = 0;i<3;i++) {
            if (radioButtons[i].isSelected()) {
                size = i+1;
            }
        }

        for (int i = 0;i<3;i++) {
            if (boxes[i].isSelected()) {
                numberOfToppings++;
            }
        }

        if (cbOrderType.getValue().equals("ToGo")) {
            pizzaOrder = new ToGo(name, size, numberOfToppings, toppingPrice);
            pizzaOrders.add(pizzaOrder);
        }
        else if (cbOrderType.getValue().equals("Delivery")) {

            tripRate = Double.parseDouble(tfTrip.getText());
            zone = Integer.parseInt(tfZone.getText());
            pizzaOrder = new Delivery(name, size, numberOfToppings, toppingPrice, tripRate, zone);
            pizzaOrders.add(pizzaOrder);

        }

        else {
            numberOfPeople = Integer.parseInt(tfNumber.getText());
            serviceCharge = Double.parseDouble(tfService.getText());
            pizzaOrder = new Seated(name, size, numberOfToppings, toppingPrice, serviceCharge, numberOfPeople);
            pizzaOrders.add(pizzaOrder);
        }

        double orderPrice = pizzaOrder.calculateOrderPrice();
        tfOrder.setText(orderPrice + "");



    }



    //is invoked when reset button is pressed
    //sets the default values for the specified nodes
    private void setDefault() {
        cbOrderType.setValue("ToGo");

        radioButtons[0].setSelected(true);

        for (int i = 0;i<3;i++) {
            boxes[i].setSelected(false);
        }
        while (!pizzaOrders.isEmpty()) {
            pizzaOrders.remove(0);
        }

    }

    //Creates and constructs a new stage and appends the contents of the array list to it
    private void printOrders() {

        /*ImageView imageView = new ImageView("C:\\Users\\USER-Q\\Downloads\\pizza1.png");
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        */

        String full = "";
        BorderPane borderPane = new BorderPane();
        Label title = new Label("Pizza Orders");
        title.setContentDisplay(ContentDisplay.BOTTOM);
        title.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.ITALIC, 23));

        title.setTranslateX(175);

        VBox vBox = new VBox(title);

        Text name = new Text("Name");
        name.setFont(new Font(14));
        name.setTranslateX(2);

        Text price = new Text("Price");
        price.setFont(new Font(14));
        price.setTranslateX(2);

        HBox hBox = new HBox(30);
        hBox.getChildren().addAll(name, price);

        vBox.getChildren().add(hBox);

        borderPane.setTop(vBox);

        BorderPane.setAlignment(title, Pos.CENTER);

        //concatenates the contents of the array list so as to
        //display it as one unit in the text area

        for (int i = 0;i<pizzaOrders.size();i++) {
            full += pizzaOrders.get(i).printOrderInfo();
        }

        TextArea textArea = new TextArea(full);
        textArea.setPadding(new Insets(5));
        textArea.setStyle("-fx-border-color: black");

        ScrollPane scrollPane = new ScrollPane(textArea);
        borderPane.setCenter(scrollPane);



        Scene scene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setTitle("Orders Report");
        stage.setScene(scene);
        stage.show();

    }
}
