import java.io.Serializable;

public class letters implements Comparable<letters>, Serializable {
    int freq;
    String l;

    public letters(String letters, int freq){
        this.freq = freq;
        this.l = letters;
    }

    public int compareTo(letters l){
        return freq - l.freq;
    }

    public String toString(){
        return " " + l + " - " + freq + " ";
    }

}
