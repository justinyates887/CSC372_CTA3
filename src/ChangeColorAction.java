import javafx.scene.layout.Pane;
import java.util.Random;
import javafx.scene.paint.Color;

public class ChangeColorAction implements Action {
    private Pane pane;

    public ChangeColorAction(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void execute() {
        Random rand = new Random();
        float hue = rand.nextFloat() * 0.33f; // 0.33 limits hue to the green range
        Color randomGreen = Color.hsb(hue * 360, 1.0, 1.0);
        pane.setStyle("-fx-background-color: #" + randomGreen.toString().substring(2, 8) + ";");
    }
}