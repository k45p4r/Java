package mod5_3;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }


    public Pen(Color color) {
        this.color = color;
    }
    public Pen() {
        this(Color.RED);
    }


    public void changeColor(Color color) {
        if (isCapOn) {
            this.color = color;
        }
    }

    private Color color;
    Boolean isCapOn = true;

    public String draw() {
        if (isCapOn) {
            return "";
        } else {
            return "Drawing " + color;
        }
    }
    public void capOff() {
        isCapOn = false;
    }
    public void capOn() {
        isCapOn = true;
    }
}
