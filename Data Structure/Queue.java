import java.util.Scanner;
 class Queue {
    private int[] array;
    private int tail;
    

	public Queue(int size) {
		array = new int[size];
        tail = -1;
	}


	public boolean isEmpty() {
		return (this.tail == -1);
	}

	public boolean isFull() {
		return (this.tail == array.length -1);
	}

	private void shiftLeft() {
		for(int i = 1; i < array.length;i++){
			this.array[i-1] = array[i];
		}
    }
    public void add(int x){
        if (!this.isFull()){
            this.array[++this.tail] = x;
        
        } else {
            System.out.println("full");
        }
    }
    
    public void remove(){
        if(!isEmpty()){
            tail--;
            shiftLeft();
        } else {
            System.out.println("empty");
        }

    }
    public void element(){
        if(!isEmpty()){
            System.out.println(this.array[0]);
        } else {
            System.out.print("empty");
        }
    }
    public String print(){
        if (this.isEmpty()){
            return "empty";
        } 
         String res = "";
         for(int i = 0; i <= this.tail; i++){
             if(res.length()==0){
                 res += array[i];
             } else {
                 res += " " + array[i];
             }
         }
         return res;
     }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        int k = Integer.parseInt(first);
        Queue queue = new Queue(k);
                
        boolean value = true;
        while (value){
            String input = sc.nextLine();
            String option = input.split(" ")[0];
            switch(option){
                case "end":
                    value = false;
                    break;
                case "print":
                    System.out.println(queue.print());
                    break;
                case "add":
                    Integer x = Integer.parseInt(input.split(" ")[1]);
                    queue.add(x);
                    break;
                case "element":
                    queue.element();
                    break;
                case "remove":
                    queue.remove();
                    break;
            }
        }
        sc.close();
    }
}
