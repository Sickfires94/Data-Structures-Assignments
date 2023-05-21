public class SearchEngine {
    LinkedList<Word> Wlist;

    SearchEngine(){
        Wlist = new LinkedList<Word>();
    }

    void insert(String word, String url){    /** O(N) */
        insertWord(word);
        Word w = new Word(word.toUpperCase());
        LinkedList<URL> urlList = (Wlist.search(w)).urls;

        urlList.insert(new URL(url.toUpperCase()));
    }

    private void insertWord(String word){    /** O(N) */
        if(Wlist.search(new Word(word.toUpperCase())) != null) return;
        Wlist.insert(new Word(word.toUpperCase()));
    }

    void delete(String word){                /** O(N) */
        if(Wlist.search(new Word(word.toUpperCase())) == null) return;
        Wlist.delete(new Word(word.toUpperCase()));
    }


    void Search(String word){               /** O(N) */
        if(Wlist.search(new Word(word.toUpperCase())) == null){
            System.out.println("NO URLS IN DATABASE");
            return;
        }
        System.out.println((Wlist.search(new Word(word.toUpperCase()))).urls);
    }

    public String toString(){               /** O(N*N) */
        String str = "";
        str += Wlist.toString();
        return str;
    }




}

