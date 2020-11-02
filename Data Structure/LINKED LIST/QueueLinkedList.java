import java.util.Scanner;

class FilaComLinkedList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Fila fila = new Fila();

        boolean value = true;
		String[] entrada;
		String operacao = "";
        
        while (value) {
            
            entrada = scan.nextLine().split(" ");
            operacao = entrada[0];
            
            switch(operacao){
                case "end":
                    value = false;
                    break;
                case "add":
                    int e = Integer.parseInt(entrada[1]);
                    fila.enqueue(e);
                    break;

                case"remove":
                    fila.dequeue();
                    break;
                case "element":
                    fila.element();
                    break;
                case "print":
                    System.out.println(fila.print());
                    break;
                case "search":
                    int elemento = Integer.parseInt(entrada[1]);
                    System.out.println(fila.search(elemento));
                    break;
                }

        }
        scan.close();
	}

class Fila{
    LinkedList list; 
    
    
    public Fila() {
        list = new LinkedList();
        
    }
    
    
    public boolean isEmpty() {
        return (this.list.isEmpty());
    }
    public int search(int element){
        return list.search(element);
    }
    
    
   
    public void enqueue(int x){
        if(element != null){
			this.list.insertLast(element);
		}
       
    }
    public void element(){
        if(!isEmpty()){
            System.out.println(this.list.getHead());
        } else {
            System.out.print("empty");
        }
    }
    
    public void dequeue(){
        if(!isEmpty()){
            tail--;
            list.removeFirst();
        } else {
            System.out.println("empty");
        }
    
    }
    public String print(){
        if (this.isEmpty()){
            return "empty";
        } 
       
         return list.toString();
    }
}


class LinkedList {
    Node head;
    int size;
    LinkedList(){
        head = null;
        size = 0;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public insertLast(int e){
        if (this.isEmpty()){
            head = new Node(e);
        } else {
            recursiveLast(this.head, e);
            size++;
        }
        
    }
    public Node getHead() {
        return head;
    }
    private recursiveLast(Node current,int e){
        if(current.next == null){
            Node newNode = new Node(e);
            current.next = newNode;
            newNode.previous = current; 

        } else recursiveLast(current.next,e);
    }
    public void removeFirst(){
        if(!this.isEmpty()){
			if(this.head.next == null) {
				this.setData(null);
				this.setPrevious(null);
				this.setNext(null);
			} else {
				this.head = (this.head.next);
                this.head.next = (this.head.next.next);
                this.head.next = this.head;
            }
        }
    }
    public int search(int element){
        return recursiveSearch(this.head, element);
    }
    private int recursiveSearch(Node current, int e){
        int res = -1;
        
        if(current.getValue() == e){
            res += 1;
        } else {
            if (current.next == null){
                return -1;
            }
            res += recursiveSearch(current.next, e);
        }
        return res;
    }
    public String toString(){
        return toStringRecursivo(this.head).trim();
    }
    private String toStringRecursivo(Node current){
        String res = "";
        if (!this.isEmpty()){
            if (current.next == null){
                res +=  String.valueOf(current.getValue()) + " ";
            } else {
                res += toStringRecursivo(current.next);
            }
        }
        return res;
    }


}
class Node{
    Node next;
    Node previous;
    private int value;
    
    public Node(int v){
        this.next = null;
        this.previous = null;
        this.value = v;
    }
    
    public int getValue() {
        return value;
    }

}

}