import java.io.*;
import java.util.Scanner;

public class HuffmanCompressor {
    // reads original file
    // reads huffman code from file
    // encodes file
    File inputFile;
    File outputFile;


    public HuffmanCompressor(String inputPath, String outputPath){
        this.inputFile = new File(inputPath);
        this.outputFile = new File(outputPath);

        convert();
    }
    public void convert(){
        Scanner sc = null;
        PrintWriter pw = null;

        try{
            sc = new Scanner(inputFile);
            pw = new PrintWriter(outputFile);
        }

        catch(IOException e){
            e.printStackTrace();
        }
        int counter = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); i = i + 7){

                String binary = "";
                int ascii;
                for(int j = 0; j < 7 ; j++){
                    if(i + j >= line.length()) break;
                    binary += line.charAt(j + i);
                }
                ascii = Integer.parseInt(binary,2);
                counter++;
                if(counter == 107) System.out.println(binary + " " + ascii + " " + (char) ascii);

                pw.write((char) ascii);

            }
        }
        sc.close();
        pw.close();
    }
}