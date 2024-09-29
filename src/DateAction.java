import javafx.scene.control.TextArea;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAction implements Action {
    private TextArea textArea;

    public DateAction(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        textArea.setText(currentDateTime);
    }
}