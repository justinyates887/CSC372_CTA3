import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileAction implements Action {
    private TextArea textArea;

    public WriteToFileAction(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(textArea.getText() + "\n");
            showAlert("Content written to log.txt");
        } catch (IOException e) {
            showAlert("Error writing to file");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
