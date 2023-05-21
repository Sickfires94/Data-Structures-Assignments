public class Word implements Comparable<Word> {
    String word;
    String meaning;

    public Word(String word, String meaning){
        this.word = word.toLowerCase();
        this.meaning = meaning;
    }

    public int compareTo(Word w) {
        return this.word.compareTo(w.word.toLowerCase());
    }

    public String toString(){
        return word + " " + meaning;
    }
    
}
