public class ModifiedSearchEngine {
    LinkedList<Word>[] letters;

    ModifiedSearchEngine(){
        letters = new LinkedList[26];
        for(int i = 0; i < letters.length; i++){
            letters[i] = new LinkedList<Word>();
        }
    }

    void insert(String word, String url){    /** O(N) */
        insertWord(word);
        LinkedList<Word> Wlist = letters[word.toUpperCase().charAt(0) - 65];
        Word w = new Word(word.toUpperCase());
        LinkedList<URL> urlList = (Wlist.search(w)).urls;
        if(urlList == null) return;

        urlList.insert(new URL(url.toUpperCase()));
    }

    void insertWord(String word){   /** O(N) */
        LinkedList<Word> Wlist = letters[word.toUpperCase().charAt(0) - 65];
        if(Wlist.search(new Word(word.toUpperCase())) != null) return;

        Wlist.insert(new Word(word.toUpperCase()));
    }

    void delete(String word){  /** O(N) */
        LinkedList<Word> Wlist = letters[word.toUpperCase().charAt(0) - 65];
        if(Wlist.search(new Word(word.toUpperCase())) == null) return;
        Wlist.delete(new Word(word.toUpperCase()));
    }

    void Search(String word){   /** O(N) */
        LinkedList<Word> Wlist = letters[word.toUpperCase().charAt(0) - 65];
        if(Wlist.search(new Word(word.toUpperCase())) == null){
            System.out.println("NO URLS IN DATABASE");
            return;
        }
        System.out.println((Wlist.search(new Word(word.toUpperCase()))).urls);
    }

    public String toString(){   /** O(N*N) */
        String str = "";
        int letter = 65;
        for(LinkedList list : letters){
            str += (char) letter++ + ": \n";
            str += list.toString();
        }
        return str;
    }




}
