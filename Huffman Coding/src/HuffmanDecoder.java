import java.io.*;
import java.util.Scanner;

public class HuffmanDecoder {
    // reads encoded file
    // reads huffman code from file
    // decodes file

    node root;
    File inputFile;
    File outputFile;

    String[] bitcode;


    public HuffmanDecoder(String inputPath, String outputPath, String treePath){
        this.inputFile = new File(inputPath);
        this.outputFile = new File(outputPath);

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(treePath));
            root = (node) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

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

        String line = sc.next();
        node temp = root;
        System.out.println(line.length()/8);
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '0') temp = temp.left;
                else temp = temp.right;

                if(temp.left == null){
                    pw.print(temp.l.l);
                    temp = root;
                }
            }


        sc.close();
        pw.close();
    }
}