import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String dir0 = "casoFDS.txt";
        File file0 = new File(dir0);
        Map mapa0 = new Map(file0);

        // String dir1 = "casoTeste.txt";
        // File file1 = new File(dir1);
        // Map mapa1 = new Map(file1);

        // String dir2 = "caso05.txt";
        // File file2 = new File(dir2);
        // Map mapa2 = new Map(file2);

        // String dir3 = "caso06.txt";
        // File file3 = new File(dir3);
        // Map mapa3 = new Map(file3);

        // String dir4 = "caso07.txt";
        // File file4 = new File(dir4);
        // Map mapa4 = new Map(file4);

        // String dir5 = "caso08.txt";
        // File file5 = new File(dir5);
        // Map mapa5 = new Map(file5);

        // String dir6 = "caso09.txt";
        // File file6 = new File(dir6);
        // Map mapa6 = new Map(file6);

        // String dir7 = "caso10.txt";
        // File file7 = new File(dir7);
        // Map mapa7 = new Map(file7);

        System.out.println(mapa0.results());
    }
}