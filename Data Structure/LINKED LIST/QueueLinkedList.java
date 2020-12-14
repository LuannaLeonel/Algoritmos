import java.util.Scanner;

class QueueLinkedList {

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
    
    
   
    public void enqueue(int element){
    
	    this.list.insertLast(element);
	
       
    }
    public void element(){
        if(!isEmpty()){
            System.out.println(this.list.getLast());
        } else {
            System.out.println("empty");
        }
    }
    
    public void dequeue(){
        if(!isEmpty()){
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
    public void insertLast(int e){
        if (this.isEmpty()){
            head = new Node(e);
        } else {
            recursiveLast(this.head, e);
            size++;
        }
        
    }
    public int getLast() {
        
        return  recursiveTail(this.head);
    }
    private int recursiveTail(Node current){
        if(current.next == null){
            return current.getValue();
        } else {
            return recursiveTail(current.next);
        }
        
    }
    private void recursiveLast(Node current,int e){
        if(current.next == null){
            Node newNode = new Node(e);
            current.next = newNode;
            newNode.previous = current; 

        } else recursiveLast(current.next,e);
    }
    public void removeFirst(){
        if(!this.isEmpty()){
			if(this.head.next == null) {
                this.head = null;
				
			} else {
				this.head = (this.head.next);
                this.head.previous = null;
            }
        }
    }
    public int search(int element){
        return recursiveSearch(this.head, element);
    }
    private int recursiveSearch(Node current, int e){
        if (!this.contains(current, e)){
            return -1;
        }
        
        
        if(current.getValue() == e){
            return 0;
        } else {
        
            return 1 + recursiveSearch(current.next, e);
        }
        
    }
    private boolean contains(Node current,int e){
        if (current == null) return false;


        if(current.getValue() == e){
            return true;
        } else {
            return contains(current.next, e);
        }
    }

    public String toString(){
        return toStringRecursivo(this.head).trim();
    }
    private String toStringRecursivo(Node current){
        String res = "";
        if (!this.isEmpty() && current != null){
            if (current.next == null){
                res +=  String.valueOf(current.getValue());
            } else {
                res +=  String.valueOf(current.getValue()) + " ";
                res += toStringRecursivo(current.next);
            }
        }
        return res;
    }


}
class Node{
    Node next;
    Node previous;
    private Integer value;
    
    public Node(Integer v){
        this.next = null;
        this.previous = null;
        this.value = v;
    }
    
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public void setNext(Node next) {
        this.next = next;
    }

}