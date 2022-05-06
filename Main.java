import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Position> list = addPositions();
        for (Position p : list) {
            System.out.println(p.toString());
        }
    }

    public static ArrayList<Position> addPositions() {
        ArrayList<Character> listDoors = new ArrayList<Character>();
        listDoors.add('A');
        listDoors.add('B');
        listDoors.add('C');

        ArrayList<Character> listKeys = new ArrayList<Character>();
        listKeys.add('a');
        listKeys.add('b');

        ArrayList<Position> list = new ArrayList<Position>();
        for (Character c : listDoors) {
            list.add(new Position("Door", isAcessible(c, listKeys), c));
        }
        for (Character c : listKeys) {
            list.add(new Position("Key", true, c));
        }
        return list;
    }

    public static boolean isAcessible(char c, ArrayList<Character> list) {
        boolean accesible = false;
        if (list.contains(Character.toLowerCase(c))) {
            accesible = true;
        }
        return accesible;
    }
}