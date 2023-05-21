import java.rmi.server.ExportException;

public class LinkedList<T extends Comparable<T>> {
    Node<T> head;
    Node<T> tail;

    void insert(T data){
        Node<T> n = new Node<T>(data);

        if(isEmpty()){
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        tail = n;
    }

    void delete(T data){
        Node<T> n = new Node<T>(data);
        Node<T> temp = head;
        Node<T> prev = head;

        while(temp != null && data.compareTo(temp.data) != 0){
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        if(temp == head){
            head = head.next;
            return;
        }

        prev.next = temp.next;
    }

    T search(T data){
        Node<T> temp = head;

        while(temp != null && data.compareTo(temp.data) != 0){
            temp = temp.next;
        }
        if(temp == null) return null;

        return temp.data;
    }

    boolean isEmpty(){
        return head == null;
    }

    public String toString(){
        Node<T> temp = head;
        String str = " ";
        while (temp != null){
            str += temp.data.toString() + " ";
            temp = temp.next;
        }
        str += "\n";
        return str;
    }

}

class Node<T extends Comparable<T>> {

    T data;

    Node<T> next;

    Node(T data){
        this.data = data;
    }
}

class LLMain{
    public static void main(String[] args) {
        LinkedList<Word> a = new LinkedList();

        a.insert(new Word("Hello1"));
        a.insert(new Word("Hello2"));
        a.insert(new Word("Hello3"));
        a.insert(new Word("Hello4"));
        a.insert(new Word("Hello5"));
        a.insert(new Word("Hello6"));


    }
}
