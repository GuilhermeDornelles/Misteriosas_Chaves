import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.geometry.Pos;

//The class Map works like a Graph but with some changes
public class Map {
    ArrayList<Position> players = new ArrayList<>();
    /*
     * public Map(File file) {
     * ArrayList<String> lines = new ArrayList<>();
     * try {
     * FileReader arq = new FileReader(file);
     * BufferedReader lerArq = new BufferedReader(arq);
     * String line = "hi";
     * while (line != null) {
     * line = lerArq.readLine();
     * if (line != null) {
     * lines.add(line);
     * }
     * }
     * arq.close();
     * } catch (IOException e) {
     * System.out.printf("Error while reading the file: %s.\n", e.getMessage());
     * }
     * 
     * //Transform the lines in many nodes and connections
     * for(int lNum=0; lNum<lines.size(); lNum++){
     * String l = lines.get(lNum);
     * for(int i=0; i<l.length(); i++){
     * //The line is the first one
     * if(lines.get(0) == l){
     * Character position = l.charAt(i);
     * if(position != '#'){
     * switch(position){
     * case '.' : Position node = new Position(type, label)
     * break;
     * }
     * 
     * }
     * }
     * //The line is the last one
     * else if(lines.get(lines.size()-1) == l){
     * 
     * }
     * //The line is on the middle
     * else {
     * 
     * }
     * }
     * }
     * }
     */
    /*
     * private ArrayList<Integer> getNeighbors(ArrayList<String> lines, int
     * indexLine, int indexChar, Position position) {
     * if (indexLine < lines.size()) {
     * 
     * }
     * 
     * ArrayList<Position> listOfNeighbors = new ArrayList<>();
     * 
     * // Can't add above because has been read already
     * /*
     * if (indexLine > 0) {
     * // Add neighbor in line above
     * Character above = lines.get(indexLine - 1).charAt(indexChar);
     * if (above != '#') {
     * Position neighbor = new Position(above);
     * neighbor.addNeighbor(position.getId());
     * position.addNeighbor(neighbor.getId());
     * }
     * }
     */
    /*
     * if (indexChar > 0) {
     * // Add previous
     * Character previous = lines.get(indexLine).charAt(indexChar - 1);
     * if (previous != '#') {
     * Position neighbor = new Position(previous);
     * neighbor.addNeighbor(position.getId());
     * position.addNeighbor(neighbor.getId());
     * }
     * }
     * if (indexChar < lines.get(indexLine).length() - 1) {
     * // Add next
     * Character next = lines.get(indexLine).charAt(indexChar + 1);
     * if (next != '#') {
     * Position neighbor = new Position(next);
     * neighbor.addNeighbor(position.getId());
     * position.addNeighbor(neighbor.getId());
     * }
     * }
     * if (indexLine < lines.size() - 1) {
     * // Add below
     * Character below = lines.get(indexLine + 1).charAt(indexChar);
     * if (below != '#') {
     * Position neighbor = new Position(below);
     * neighbor.addNeighbor(position.getId());
     * position.addNeighbor(neighbor.getId());
     * }
     * }
     * 
     * }
     */

    /*
     * public int walk(Position player) {
     * // MarkOff all the nodes
     * // TODO
     * // Start with 1 because player position counts
     * int count = 1;
     * player.markPosition();
     * ArrayList<Position> list = new ArrayList<Position>();
     * list.add(player);
     * while (!list.isEmpty()) {
     * Position v = list.get(0);
     * // TODO
     * // visita v;
     * for (Position position : v.neighbors) {
     * position.markPosition();
     * list.add(position);
     * }
     * list.remove(0);
     * }
     * 
     * return -1;
     * 
     * }
     */
    public String results() {
        // Sum to the String each result of each player
        /*
         * for(Position player : players){
         * walk(map, Players)
         * }
         */
        return "";
    }
}
