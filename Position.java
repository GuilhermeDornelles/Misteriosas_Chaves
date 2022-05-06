public class Position {
    private boolean door;
    private boolean accessible;
    private char label;

    public Position(boolean door, boolean accesible, char label) {
        this.door = door;
        this.accessible = accesible;
        this.label = label;
    }

    public boolean isDoor() {
        return door;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public char getLabel() {
        return label;
    }

    public String toString() {
        return "Posição: Label: " + label + " | Porta: " + door + " | Acessível: " + accessible;
    }
}