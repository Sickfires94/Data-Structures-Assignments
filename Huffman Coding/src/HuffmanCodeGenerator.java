import java.io.*;
import java.util.Scanner;

public class HuffmanCodeGenerator {
    // reads freq file
    // generates huffmancode
    // writes huffman code to file

    char[] c;
    node[] charFreq;
    String freqFilePath;
    String outputFilePath;

    String codeOutputFilePath;
    node root;

    public HuffmanCodeGenerator(String freqFilePath, String outputFilePath, String codeOutputFilePath){
        this.freqFilePath = freqFilePath;
        this.outputFilePath = outputFilePath;
        this.codeOutputFilePath = codeOutputFilePath;
        readFreq();
    }

    void readFreq(){
        File f = new File(freqFilePath);
        Scanner sc = null;

        try{
            sc = new Scanner(f);
        }
        catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        int charCount = sc.nextInt();
        charFreq = new node[charCount];

        charFreq[0] = new node(new letters("\n", sc.nextInt()));
        charFreq[1] = new node (new letters(" ", sc.nextInt()));

        for(int i = 2; i < charCount; i++) {
            //if(sc.hasNext()){
            letters l = new letters(sc.next(), sc.nextInt());
            charFreq[i] = new node(l);
            // }
        }

        GenerateTree();
    }

    void GenerateTree(){
        HeapTree<node> ht = new HeapTree<node>();

        node[] tempCharFreq = charFreq.clone();

        ht.buildMinHeap(tempCharFreq);

        while(tempCharFreq[1] != null){

        node n1 = ht.delete(tempCharFreq);
        node n2 = ht.delete(tempCharFreq);


        node n = new node(new letters(n1.l.l + n2.l.l, n1.l.freq + n2.l.freq));

        n.left = n1;
        n.right = n2;

        ht.insert(tempCharFreq, n);
        }

        root = tempCharFreq[0];
        writeKey();


    }


    void writeKey(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath));
            oos.writeObject(root);
            oos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        File f = new File(codeOutputFilePath);
        PrintWriter pw = null;


        try{
            pw = new PrintWriter(f);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        for(node n : charFreq){
            char curr;
            curr = n.l.l.charAt(0);
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

            pw.println((int) curr + " " + curr + " : " +  bitcode);
        }
        pw.close();

    }

}

class node implements Serializable, Comparable<node> {
    letters l;
    node left;
    node right;

    public node(letters l){
        this.l = l;
    }

    public String toString(){
        String s = "";
        if(left != null) s += left.toString() + "\n";
        s += l.toString() + "\n";
        if(right != null) s+= right.toString() + "\n";
        return s;
    }

    public int compareTo(node n){
        return l.compareTo(n.l);
    }
}


