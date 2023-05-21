import java.io.*;
import java.util.Scanner;

public class HuffmanEncoder {
    // reads original file
    // reads huffman code from file
    // encodes file

    node root;
    File inputFile;
    File outputFile;



    public HuffmanEncoder(String inputPath, String outputPath, String treePath){
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

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            for(int i = 0; i <= line.length(); i++){
                char curr;
                if(i == line.length()) curr = '\n';
                else curr = line.charAt(i);
                node temp = root;
                String bitcode = "";

                while(temp.left != null){
                    if(temp.left.l.l.contains(curr+"")){
                        temp = temp.left;
                        bitcode += 0;
                    }
                    else {
                        temp = temp.right;
                        bitcode += 1;
                    }
                }

                pw.print(bitcode);

            }
        }
        sc.close();
        pw.close();
    }
}