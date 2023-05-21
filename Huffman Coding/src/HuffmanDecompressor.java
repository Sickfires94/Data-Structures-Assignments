import java.io.*;
import java.util.Scanner;

public class HuffmanDecompressor {
    // reads original file
    // reads huffman code from file
    // encodes file
    File inputFile;
    File outputFile;



    public HuffmanDecompressor(String inputPath, String outputPath){
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
            String binary = null;
            char c = 'i';
            for(int i = 0; i < line.length(); i++){
                c = line.charAt(i);
                binary = Integer.toBinaryString(c);

                while(binary.length() < 7) binary = '0' + binary;

                pw.write(binary);
                counter++;
                if(counter == 107) System.out.println(binary + " " + (int) c + " " + c);
            }


            if(sc.hasNextLine()){
                c = '\n';
                binary = Integer.toBinaryString(c);

                while(binary.length() < 7) binary = '0' + binary;

                if(binary.length() != 7) System.out.println(binary + " " + binary.length());
                pw.write(binary);
                counter++;
                if(counter == 107) System.out.println(binary + " " + (int) c + " " + c);
            }
        }
        sc.close();
        pw.close();
    }
}
