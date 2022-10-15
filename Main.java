import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<String,Jumper> hm = new HashMap<>();
        hm.put( "6", new Jumper(new Coordinates(9, 5), new Coordinates(6, 6)));
        hm.put("97", new Jumper(new Coordinates(0, 1), new Coordinates(9, 9)));
        hm.put("21", new Jumper(new Coordinates(7, 0), new Coordinates(0, 9)));
        hm.put("64", new Jumper(new Coordinates(3, 3), new Coordinates(7, 4)));
        Board board = new Board(10, hm);
        Player p1 = new Player("Priyesh","India",22,"Male");
        Player p2 = new Player("Anushka","India",22,"Female");
        Player p3 = new Player("Piyush","India",21,"Male");
        Player p4 = new Player("jatin","India",22,"Male");
        Player p5 = new Player("avni", "India", 21, "Female");
        Game game = new Game(board, new Player[] {p1, p2,p3,p4,p5});
        game.play();
    }
}
