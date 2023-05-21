public class URL implements Comparable<URL> {
    String url;

    URL(String url){
        this.url = url;
    }

    public String toString(){
        return url;
    }

    public int compareTo(URL url) {
        if(this.url.equals(url.url)) return 0;
        return -1;
    }
}
