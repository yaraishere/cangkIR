package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import module.Cup;
import utils.Connect;

public class Main extends Application {

	private Stage stage;
	private Scene login, home, regis;
	private BorderPane bpLogin, bpRegis, bpHome;
	private GridPane gpLogin1, gpLogin2, 
			gpRegis1, gpRegis2, 
			gpHome1, gpHome2;
	private FlowPane fpLogin1, fpLogin2, fpLogin3, 
			fpRegis1, fpRegis2, fpRegis3, fpRegis4, 
			fpHome1;
	private Label loginLbl, usernameLbl, passwordLbl, 
			registerLbl, emailLbl, genderLbl, usernameRegisLbl,passwordRegisLbl, 
			cupListLbl, cupNameLbl, priceLbl, cost;
	private TextField usernameTF, emailTF, usernameRegisTF;
	private PasswordField passwordTF, passwordRegisTF;
	private Button loginBtn, regisBtn, addToCartBtn, goToCartBtn;
	private Hyperlink registerLink, loginLink;
	private Font font;
	private RadioButton maleBtn, femaleBtn;
	private ToggleGroup group;
	private TableView<HomeCupList> cupList = new TableView<>();
	private Spinner<Integer> qty;

	public void initiate() {

		// Login Page
		loginLbl = new Label("Login");
		loginLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));

		usernameLbl = new Label("Username");
		usernameTF = new TextField();
		usernameTF.setMinWidth(200);

		passwordLbl = new Label("Password");
		passwordTF = new PasswordField();
		passwordTF.setMinWidth(200);

		loginBtn = new Button("Login");
		loginBtn.setMinHeight(35);
		loginBtn.setMinWidth(100);
		registerLink = new Hyperlink("Don't have an account yet? Register Here!");

		// Layout
		bpLogin = new BorderPane();
		gpLogin1 = new GridPane();
		gpLogin2 = new GridPane();
		fpLogin1 = new FlowPane();
		fpLogin2 = new FlowPane();
		fpLogin3 = new FlowPane();
		login = new Scene(bpLogin, 700, 700);

		// Regis Page
		registerLbl = new Label("Register");
		registerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));

		usernameRegisLbl = new Label("Username");
		usernameRegisTF = new TextField();
		usernameRegisTF.setMinWidth(200);

		passwordRegisLbl = new Label("Password");
		passwordRegisTF = new PasswordField();
		passwordRegisTF.setMinWidth(200);

		emailLbl = new Label("Email");
		emailTF = new TextField();
		emailTF.setMinWidth(200);

		genderLbl = new Label("Gender");
		genderLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

		maleBtn = new RadioButton("Male");
		femaleBtn = new RadioButton("Female");

		ToggleGroup group = new ToggleGroup();
		maleBtn.setToggleGroup(group);
		femaleBtn.setToggleGroup(group);

		regisBtn = new Button("Register");
		regisBtn.setMinHeight(35);
		regisBtn.setMinWidth(100);

		loginLink = new Hyperlink("Already have an account? Click here to login!");

		bpRegis = new BorderPane();
		gpRegis1 = new GridPane();
		gpRegis2 = new GridPane();
		fpRegis1 = new FlowPane();
		fpRegis2 = new FlowPane();
		fpRegis3 = new FlowPane();
		fpRegis4 = new FlowPane();
		regis = new Scene(bpRegis, 700, 700);

		// Home
		cupListLbl = new Label("Cup List");
		cupListLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

		cupNameLbl = new Label("Cup Name");
		cupNameLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		qty = new Spinner<>(1, 20, 1);

		priceLbl = new Label("Price: ");
		priceLbl.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));		

		cost = new Label();
		cost.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		
		addToCartBtn = new Button("Add to Cart");
		addToCartBtn.setMinHeight(35);
		addToCartBtn.setMinWidth(100);
		
		goToCartBtn = new Button("Go to Cart");
		goToCartBtn.setMinHeight(35);
		goToCartBtn.setMinWidth(100);

		bpHome = new BorderPane();
		home = new Scene(bpHome, 1000, 700);
		gpHome1 = new GridPane();
		gpHome2 = new GridPane();
		fpHome1 = new FlowPane();
	}

	public void layouting() {

		// Login Page
		bpLogin.setCenter(gpLogin1);
		gpLogin1.setAlignment(Pos.CENTER);

		gpLogin1.add(fpLogin1, 0, 0);
		fpLogin1.getChildren().add(loginLbl);
		fpLogin1.setAlignment(Pos.CENTER);

		gpLogin1.add(usernameLbl, 0, 1);
		gpLogin1.add(usernameTF, 0, 2);

		gpLogin1.add(passwordLbl, 0, 3);
		gpLogin1.add(passwordTF, 0, 4);

		gpLogin1.add(fpLogin2, 0, 6);
		fpLogin2.getChildren().add(loginBtn);
		fpLogin2.setAlignment(Pos.CENTER);

		gpLogin1.setVgap(10);

		gpLogin1.add(fpLogin3, 0, 8);
		fpLogin3.getChildren().add(registerLink);
		fpLogin3.setAlignment(Pos.CENTER);

		// Regis Page
		bpRegis.setCenter(gpRegis1);
		bpRegis.setCenter(gpRegis1);
		gpRegis1.setAlignment(Pos.CENTER);

		gpRegis1.add(fpRegis1, 0, 0);
		fpRegis1.getChildren().add(registerLbl);
		fpRegis1.setAlignment(Pos.CENTER);

		gpRegis1.add(usernameRegisLbl, 0, 1);
		gpRegis1.add(usernameRegisTF, 0, 2);

		gpRegis1.add(emailLbl, 0, 3);
		gpRegis1.add(emailTF, 0, 4);

		gpRegis1.add(passwordRegisLbl, 0, 5);
		gpRegis1.add(passwordRegisTF, 0, 6);

		gpRegis1.add(genderLbl, 0, 7);
		gpRegis1.add(fpRegis2, 0, 8);

		fpRegis2.getChildren().addAll(maleBtn, femaleBtn);
		fpRegis2.setHgap(10);

		gpRegis1.add(fpRegis3, 0, 9);
		fpRegis3.getChildren().add(regisBtn);
		fpRegis3.setAlignment(Pos.CENTER);

		gpRegis1.setVgap(10);

		gpRegis1.add(fpRegis4, 0, 10);
		fpRegis4.getChildren().add(loginLink);
		fpRegis4.setAlignment(Pos.CENTER);

		// Home Page
		bpHome.setLeft(gpHome1);
		gpHome1.add(cupListLbl, 0, 0);
		gpHome1.add(cupList, 0, 1);
		gpHome1.setPadding(new Insets(20,50,10,10));
		gpHome1.setVgap(20);

		bpHome.setCenter(gpHome2);
		gpHome2.add(cupNameLbl, 0, 0);
		gpHome2.add(qty, 0, 1);
		gpHome2.add(fpHome1, 0, 2);
		fpHome1.getChildren().addAll(priceLbl, cost);

		gpHome2.add(addToCartBtn, 0, 3);
		gpHome2.add(goToCartBtn, 0, 4);
		gpHome2.setVgap(20);
		gpHome2.setPadding(new Insets(20,50,10,10));

	}
	
	public void viewCup() {
			String query = "SELECT * FROM `mscup`";
			Connect con = new Connect();
			ResultSet rs = con.execQuery(query);
			
			try {
				while(rs.next()) {
					try {
						String name = rs.getString("CupName");
						Integer price = rs.getInt("CupPrice");
						String id = rs.getString("CupID");
						
						HomeCupList cup = new HomeCupList(id, name, price);
						cupList.getItems().add(cup);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

	public void setCupListTable() {
		TableColumn<HomeCupList, String> cupName = new TableColumn<HomeCupList, String>("Cup Name");
		cupName.setCellValueFactory(new PropertyValueFactory<>("CupName"));
		cupName.setMinWidth(175);
		cupName.setMaxWidth(175);
		cupName.setResizable(false);

		TableColumn<HomeCupList, Integer> cupPrice = new TableColumn<HomeCupList, Integer>("Cup Price");
		cupPrice.setCellValueFactory(new PropertyValueFactory<>("CupPrice"));
		cupPrice.setMinWidth(175);
		cupPrice.setMaxWidth(175);
		cupPrice.setResizable(false);

		cupList.getColumns().addAll(cupName, cupPrice);

		cupList.setMinWidth(350);
	}

	public boolean validateLogIn() {

		String username = "";
		String password = "";

		boolean cek = false;

		String query = String.format("SELECT * FROM `msuser` WHERE `Username` = '%s' AND `UserPassword` = '%s'",
				usernameTF.getText(), passwordTF.getText());
		Connect conn = new Connect();
		ResultSet rs = conn.execQuery(query);

		try {
			if (rs.next()) {
				username = rs.getString("Username");
				password = rs.getString("UserPassword");

				if (username.equals(usernameTF.getText()) && password.equals(passwordTF.getText())) {
					cek = true;
				} else {
					cek = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cek;

	}

	public String generateID() {
		String ID = null;

		String query = "SELECT MAX(UserID) FROM `msuser`";

		Connect con = new Connect();
		ResultSet rs = con.execQuery(query);

		try {
			if (rs.next()) {
				String id = rs.getString(1);

				int size = Integer.parseInt(id.substring(2));
				size++;

				ID = String.format("US%03d", size);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ID;
	}
	
	public String getUserID() {
		String id = "";
		String query = String.format("SELECT `UserID` FROM `msuser` WHERE Username = '%s'",Register.loggedinUsername);
		
		Connect con = new Connect();
		ResultSet rs = con.execQuery(query);
		
		try {
			if(rs.next()) {
				id = rs.getString("UserID");
				return id;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}
	
	public String getCupID() {
		HomeCupList selectedCup = cupList.getSelectionModel().getSelectedItem();
		String id = "";
		String query = String.format("SELECT `CupID` FROM `mscup` WHERE CupName = '%s'",selectedCup.getCupName());
		Connect con = new Connect();
		ResultSet rs = con.execQuery(query);
		
		try {
			if(rs.next()) {
				id = rs.getString("CupID");
				return id;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}

	public void setAction() {
		// Login Page
		loginBtn.setOnMouseClicked(event -> {

			String username = usernameTF.getText();
			String password = passwordTF.getText();

			while (true) {
				if (username.equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Please input username");
					alert.show();
				} else if (password.equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Please input password");
					alert.show();
				} else if (validateLogIn() == false) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Invalid Credentials");
					alert.show();
				} else {
					stage.setScene(home);
				}
				break;
			}
		});

		registerLink.setOnMouseClicked(event -> {
			stage.setScene(regis);
		});

		// Register Page
		loginLink.setOnMouseClicked(event -> {
			stage.setScene(login);
		});

		regisBtn.setOnMouseClicked(event -> {

			String username = usernameRegisTF.getText();
			String email = emailTF.getText();
			String password = passwordRegisTF.getText();

			while (true) {
				if (username.equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Please input username");
					alert.show();
				} else if (email.equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Please input email");
					alert.show();
				} else if (!email.endsWith("@gmail.com")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Email must end with @gmail.com");
					alert.show();
				} else if (password.equals("")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Please input password");
					alert.show();
				} else if (password.length() < 8 || password.length() > 15) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText("Password must be 8-15 characters long");
					alert.show();
				} else {
					try {

						String query = String.format(
								"INSERT INTO `msuser` (`UserID`, `Username`, `UserEmail`, `UserPassword`, `UserGender`, `UserRole`) VALUES ('%s', '%s', '%s', '%s', 'Female', 'User')",
								generateID(), usernameRegisTF.getText(), emailTF.getText(), passwordRegisTF.getText());
						Connect conn = new Connect();
						conn.execUpdate(query);
						stage.setScene(login);
					} catch (Exception e) {

					}
				}
				break;
			}
		});
		
		

	}
	
	public void home() {
		
//		HomeCupList choosecup = cupList.getSelectionModel().getSelectedItem();
//		cupList = new TableView<HomeCupList>();
		
		qty.valueProperty().addListener((obs, oldSelection, newSelection) ->{
			HomeCupList selectedCup = cupList.getSelectionModel().getSelectedItem();
			if(selectedCup != null) {
				int price = selectedCup.getCupPrice();
				int quantity = qty.getValue();
				int total = price * quantity;
				this.cost.setText("Total Price: " + total);
			}
		});
		
		addToCartBtn.setOnMouseClicked(event ->{
			Alert success = new Alert(AlertType.INFORMATION);
			Alert alert = new Alert(AlertType.ERROR);
			HomeCupList selectedCup = cupList.getSelectionModel().getSelectedItem();
			
			if(selectedCup != null) {
				String query = String.format("INSERT INTO `cart`(`UserID`, `CupID`, `Quantity`) VALUES ('%s','%s','%d')"
						+ "ON DUPLICATE KEY UPDATE `Quantity` = `Quantity` + '%d'",
						getUserID(),getCupID(), qty.getValue(), qty.getValue());
				Connect con = new Connect();
				con.execUpdate(query);
			
				success.setTitle("Message");
				success.setTitle("Cart Info");
				success.setContentText("Item Successfully Added to Cart");
				success.show();
				
				qty.getValueFactory().setValue(1);
							
			} else {
				alert.setTitle("Error");
				alert.setHeaderText("Cart Error");
				alert.setContentText("Please select a cup to be added");
				alert.show();
			}
		});
	}
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initiate();
		layouting();
		validateLogIn();
		setAction();
		setCupListTable();
		viewCup();		
		home();
		stage = primaryStage;
		stage.setTitle("cangkIR");
		stage.setScene(login);
		stage.show();

	}

}
