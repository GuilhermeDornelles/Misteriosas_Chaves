import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

//The class Map works like a Graph but with some changes
public class Map {
    private ArrayList<Position> players;
    private ArrayList<Position> markedPositions;
    // After the running, pass through this list to see if exists doors to unlock
    private ArrayList<Position> listOfDoors;
    private ArrayList<Position> listOfKeys;

    public Map(File file) {
        this.players = new ArrayList<>();
        this.markedPositions = new ArrayList<>();
        this.listOfDoors = new ArrayList<>();
        this.listOfKeys = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String line = "hi";
            while (line != null) {
                line = lerArq.readLine();
                if (line != null && line.length() == 0) {
                    break;
                }
                if (line != null) {
                    lines.add(line);
                }
            }
            arq.close();
        } catch (IOException e) {
            System.out.printf("Error while reading the file: %s.\n", e.getMessage());
        }

        int width = lines.get(0).length();
        int height = lines.size();

        Position[][] matrix = new Position[height][width];

        for (int h = 0; h < height; h++) {
            String line = lines.get(h);
            for (int w = 0; w < width; w++) {
                matrix[h][w] = new Position(line.charAt(w));
                if (Character.isDigit(matrix[h][w].getLabel())) {
                    players.add(matrix[h][w]);
                }
            }
        }
        ArrayList<Position> list = transformToGraph(matrix);
    }

    // Transform matrix to graph
    private ArrayList<Position> transformToGraph(Position[][] matrix) {
        ArrayList<Position> positions = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Connects the first line
        // Pass from the second column beacuse the first one is always wall
        // Until the last but one, because the last is always wall
        for (int i = 1; i < columns - 1; i++) { // For each column
            // Always connecting with the next Position
            Position current = matrix[1][i];
            if (!(current.getType() == Type.WALL)) {
                positions.add(current);
                Position next = matrix[1][i + 1];
                if (!(i == columns - 2) && !(next.getType() == Type.WALL)) {
                    // Connect the nodes
                    current.addNeighbor(next);
                    next.addNeighbor(current);
                }
            }
        }

        // Connect the others lines with the next node and the above
        // Pass from the second line until the last but one because the last has only
        // walls
        for (int h = 2; h < rows - 1; h++) { // For each row
            // Pass from the second column beacuse the first one is always wall
            for (int w = 1; w < columns - 1; w++) {// For each column
                Position current = matrix[h][w];
                if (!(current.getType() == Type.WALL)) {
                    positions.add(current);
                    Position next = matrix[h][w + 1];
                    if (!(w == columns - 2) && !(next.getType() == Type.WALL)) {
                        // Connect the nodes
                        current.addNeighbor(next);
                        next.addNeighbor(current);
                    }
                    Position above = matrix[h - 1][w];
                    if (above.getType() != Type.WALL) {
                        // Connect the nodes
                        current.addNeighbor(above);
                        above.addNeighbor(current);
                    }
                }
            }
        }
        return positions;
    }

    private int walk(Position position) {
        // It means that the method is called by a player and it's needed to markOff all
        // the nodes
        if (position.getType() == Type.PLAYER) {
            beginWalk();
            System.out.println("Jogando com o player: " + position.getLabel());
        }

        ArrayList<Position> list = new ArrayList<Position>();

        // This number will be returned meaning the number of positions
        // that the node can "walk"
        int count = 0;
        position.markPosition(true);
        markedPositions.add(position);
        list.add(position);
        while (!list.isEmpty()) {
            Position v = list.get(0);
            // Counts the position
            count++;
            for (Position neighbor : v.getNeighbors()) {
                if (!neighbor.IsMarked()) {
                    if (neighbor.getType() == Type.KEY) {
                        System.out.println("Chave encontrada: " + neighbor.getLabel());
                        listOfKeys.add(neighbor);
                        neighbor.markPosition(true);
                        markedPositions.add(neighbor);
                        list.add(neighbor);
                    } else if (neighbor.getType() == Type.DOOR) {
                        System.out.println("Porta encontrada: " + neighbor.getLabel());
                        listOfDoors.add(neighbor);
                    } else {
                        neighbor.markPosition(true);
                        markedPositions.add(neighbor);
                        list.add(neighbor);
                    }
                }

            }
            list.remove(0);
        }

        if (!listOfDoors.isEmpty()) {
            for (Position door : listOfDoors) {
                // Verify if there is a key for each door
                if (!door.isAccessible()) {
                    for (Position key : listOfKeys) {
                        // The actual key is for the actual door
                        if (Character.toLowerCase(door.getLabel()) == key.getLabel()) {
                            door.markPosition(true);
                            markedPositions.add(door);
                            door.setAcessible(true);
                            listOfDoors.remove(door);
                            count += walk(door);
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    // beginWalk will prepare the lists to start a new walk in the map
    private void beginWalk() {
        clearMarkedPositions();
        clearListOfDoors();
        clearListOfKeys();
    }

    private void clearMarkedPositions() {
        for (Position p : markedPositions) {
            p.markPosition(false);
        }
        markedPositions.clear();
    }

    private void clearListOfKeys() {
        listOfKeys.clear();
    }

    private void clearListOfDoors() {
        listOfDoors.clear();
    }

    private void sortPLayers() {
        players.sort((x, y) -> x.getLabel());
    }

    public String results() {
        String results = "Results\n";
        for (Position player : players) {
            results += "Players " + player.getLabel() + " pode percorrer por " + walk(player) + " posições!\n";
        }
        return results;
    }
}
