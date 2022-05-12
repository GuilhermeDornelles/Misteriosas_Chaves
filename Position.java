import java.util.ArrayList;

public class Position {
    private String type;
    private boolean accessible, marked;
    private char label;
    ArrayList<Position> neighbors;

    public Position(String type, boolean accesible, char label, ArrayList<Position> neighbors) {
        this.type = type;
        this.accessible = accesible;
        this.label = label;
        this.marked = false;
        this.neighbors = neighbors;
    }

    public String type() {
        return type;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public char getLabel() {
        return label;
    }

    public ArrayList<Position> getNeighbor() {
        return neighbors;
    }

    public void markPosition() {
        this.marked = true;
    }

    public void markOffPosition() {
        this.marked = false;
    }

    public String toString() {
        return "Posição: Label: " + label + " | Tipo: " + type + " | Acessível: " + accessible;
    }
}