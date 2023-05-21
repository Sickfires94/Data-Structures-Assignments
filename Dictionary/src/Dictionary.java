import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dictionary {

    // variables
    BST<Word> Dict_tree;

    // constants
    static String TXT_FILE_PATH = "Dictionary.txt";

    // constructor
    public Dictionary() {
        Dict_tree = new BST<Word>();

        ArrayList<Word> words = read_txt_file(); // read_txt_file();

        printToFile(words);
        Collections.shuffle(words);
        fill_tree(words);
    }

    void fill_tree(ArrayList<Word> words) {
        for (Word w : words)
            Dict_tree.insert(w);
    }

    void insert_word(String word, String meaning) {
        Dict_tree.insert(new Word(word, meaning));
    }

    String find_meaning(String word) {
        node<Word> n = Dict_tree.find(new Word(word, null));
        if (n == null)
            return "Word does not exist in dictionary";
        Word w = n.data;
        return w.word + " - " + w.meaning;
    }

    void delete_word(String word) {
        Dict_tree.Delete(new Word(word, null));
    }

    void print_words_inOrder() {
        Dict_tree.LNR(Dict_tree.root);
    }

    void print_words_LRN() {
        Dict_tree.LRN(Dict_tree.root);
    }

    void print_words_NLR() {
        Dict_tree.NLR(Dict_tree.root);
    }

    void printToFile(ArrayList<Word> words) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
            for (Word w : words)
                pw.println(w.toString());

            pw.close();
            System.out.println("written");
        } catch (IOException e) {
            e.getStackTrace();

        }
    }

    // method to read words from file
    ArrayList<Word> read_txt_file() {
        ArrayList<Word> words = new ArrayList<Word>();
        File f = new File(TXT_FILE_PATH);
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("file was not found");
            return null;
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] currWord = line.split(" ");
            if (!line.isBlank()) {
                if (line.toLowerCase().startsWith("usage") && !words.get(words.size() - 1).word.equals("Usaf".toLowerCase())) {
                    Word w = words.get(words.size() - 1);
                    w.meaning += ", " + line;
                    continue;
                }
                boolean meaning_start = false;
                String word = "";
                String meaning = "";
                for (int i = 0; i < currWord.length; i++) {
                    if (currWord[i].length() == 0)
                        meaning_start = true;
                    if (meaning_start)
                        meaning += " " + currWord[i];
                    else
                        word += currWord[i];
                }

                // System.out.println(word + " -------- " + meaning);
                words.add(new Word(word, meaning));
            }
        }
        sc.close();
        System.out.println("Read everything");
        return words;

    }
}

class Dictionary_main {
    public static void main(String[] args) {
        Dictionary d = new Dictionary();

        System.out.println(d.Dict_tree.maxDepth(d.Dict_tree.root));


        d.print_words_inOrder();

    }
}
