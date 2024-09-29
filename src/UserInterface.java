import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserInterface extends Application {
    private TextArea textArea;
    private Pane rootPane;

    @Override
    public void start(Stage primaryStage) {
        rootPane = new Pane();
        textArea = new TextArea();
        textArea.setEditable(false);
        rootPane.getChildren().add(textArea);
        
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(rootPane);
        mainPane.setTop(createMenuBar());

        Scene scene = new Scene(mainPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu Example");
        primaryStage.show();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");

        MenuItem dateItem = new MenuItem("Print Date and Time");
        MenuItem writeFileItem = new MenuItem("Write to File");
        MenuItem changeColorItem = new MenuItem("Change Color");
        MenuItem exitItem = new MenuItem("Exit");

        DateAction dateAction = new DateAction(textArea);
        WriteToFileAction writeToFileAction = new WriteToFileAction(textArea);
        ChangeColorAction changeColorAction = new ChangeColorAction(rootPane);
        ExitAction exitAction = new ExitAction();

        dateItem.setOnAction(e -> dateAction.execute());
        writeFileItem.setOnAction(e -> writeToFileAction.execute());
        changeColorItem.setOnAction(e -> changeColorAction.execute());
        exitItem.setOnAction(e -> exitAction.execute());

        menu.getItems().addAll(dateItem, writeFileItem, changeColorItem, exitItem);
        menuBar.getMenus().add(menu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}