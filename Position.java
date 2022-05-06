public class Position {
    private String type;
    private boolean accessible;
    private char label;

    public Position(String type, boolean accesible, char label) {
        this.type = type;
        this.accessible = accesible;
        this.label = label;
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

    public String toString() {
        return "Posição: Label: " + label + " | Tipo: " + type + " | Acessível: " + accessible;
    }
}