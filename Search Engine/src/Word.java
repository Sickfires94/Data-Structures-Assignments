public class Word implements Comparable<Word>{
    LinkedList<URL> urls;
    String word;

    Word(String word){
        this.word = word;
        this.urls = new LinkedList<>();
    }

    public String toString(){
        return word + " : \n" + urls.toString() + "\n" ;
    }

    public int compareTo(Word w) {
        if(this.word.equals(w.word)) return 0;
        return -1;
    }


}
