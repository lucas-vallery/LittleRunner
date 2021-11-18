import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CustomText {
    public CustomText (int v, int v1, int w,  String string1, String string2) {
        this.v =v;
        this.v1 = v1;
        this.string1 = string1;
        this.string2 = string2;
        Font font = Font.loadFont("file:.idea/font/press_any_key_to_continue.ttf", w);

        text = new Text(v, v1, string1);
        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);
        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(10.0);
        text.setEffect(shadow);
    }

    public Text getText() {
        return text;
    }

    public void render (long time) {
        if(time%1000000000 <= 1000000000/2)
            text.setText(string1);
        else
            text.setText(string2);
    }

    private Text text;
    private String string1;
    private String string2;
    private int v;
    private int v1;
}
