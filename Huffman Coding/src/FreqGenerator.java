import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FreqGenerator {
    private String inputFilePath;
    private String outputFilePath;
    private int[] charFreqs;
    private int charCount = 0;

    public FreqGenerator(String inputFilePath, String outputFilePath){
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        charFreqs = new int[128];

        ReadFile();
    }

    void ReadFile(){


        File f = new File(inputFilePath);
        Scanner sc = null;

        try{
            sc = new Scanner(f);
        }
        catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        int total = 0;
        while(sc.hasNext()){
            String s = sc.nextLine();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                charFreqs[c]++;
                total++;
            }
            charFreqs[10]++;
            total++;
        }
/*
        for(int i = 0; i < charFreqs.length; i++){
            System.out.println((char) i + " : " + charFreqs[i]);
        }*/

        writeFile();
    }

    void CountChars(){
        for(int i : charFreqs) if(i != 0) charCount++;
    }
    void writeFile(){

        CountChars();

        File f = new File(outputFilePath);
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(f);
        }
        catch (IOException e){
            System.out.println("Writing Error");
            e.printStackTrace();
            return;
        }

        pw.println(charCount);

        for(int i = 0; i < charFreqs.length; i++){
            if(charFreqs[i] == 0) continue;
            pw.println((char) i + " " + charFreqs[i]);
        }

        pw.close();

    }
}
