
public class TextStrategyPattern {
    public static void main(String[] args) {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        editor.publishText("tExT ExAmPlE");

        formatter = new LowerTextFormatter();
        editor = new TextEditor(formatter);
        editor.publishText("tExT ExAmPlE");
    }
}
