import java.util.ArrayList;

public class Position {
    private Type type;
    private boolean accessible, marked;
    private char label;
    private int id;
    private static int countId = 1;
    ArrayList<Integer> neighbors;

    public Position(char label) {
        this.accessible = true;
        this.label = label;
        this.type = type();
        this.marked = false;
        this.neighbors = new ArrayList<Integer>();
        this.id = countId;
        countId++;
    }

    private Type type() {
        switch (label) {
            case '.':
                return Type.COMMON;
            default: {
                // The label is in lowerCase, what means that it's a key
                if (Character.toLowerCase(label) == label) {
                    return Type.KEY;
                } else {
                    return Type.DOOR;
                }
            }
        }
    }

    public Type getType() {
        return type;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public int getId() {
        return this.id;
    }

    public char getLabel() {
        return label;
    }

    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(int neighborId) {
        this.neighbors.add(neighborId);
    }

    public void markPosition(boolean bool) {
        this.marked = bool;
    }

    public void setAcessible(Boolean bool) {
        this.accessible = bool;
    }

    public boolean IsMarked() {
        return this.marked;
    }

    public String toString() {
        return "Posição: Id:" + id + " | Label: '" + label + "' | Tipo: " + type + " | Acessível: " + accessible;
    }
}