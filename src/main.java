//http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

    static int nHealth, nMana, nScore, nX, nY, nGold;

    public static void setup() {

        nHealth = 685;
        nScore = 36;
        nX = 600;
        nY = 238;
        nGold = 9;

    }

    public static void main(String[] args) throws IOException {
        setup();
        Save();
        Load();
    }

    static void Save() {
        try {
            // the string to be written in the GaveSave.txt file
            String content = nHealth + " " + nScore + " " + nX + " " + nY + " " + nGold;
            // the location of the file
            File sGaveSave = new File("H:\\NetBeansProjects\\TestWriteFile\\GameSave.txt");

            // if file doesnt exists, then create it
            if (!sGaveSave.exists()) {
                sGaveSave.createNewFile();
            }

            FileWriter fw = new FileWriter(sGaveSave.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            // prints once saved
            System.out.println("Save");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Load() throws IOException {
        Scanner sin = new Scanner(new FileReader("GameSave.txt"));

        nHealth = sin.nextInt();
        nScore = sin.nextInt();
        nX = sin.nextInt();
        nY = sin.nextInt();
        nGold = sin.nextInt();
        //nReadin[i] = sin.next();
        // nHealth=nReadinp[0]

        System.out.println(nHealth + " " + nScore + " " + nX + " " + nY + " " + nGold);
    }
}