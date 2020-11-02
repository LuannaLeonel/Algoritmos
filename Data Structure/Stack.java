import java.util.Scanner;

 class Stack {
    
    private int[] array;
    private int top;

    public Stack(int k){
        this.array = new int[k];
        this.top = -1; 
    }
    public void push(Integer x){
        if (!IsFull()){
            this.array[++this.top] = x;
            
        } else {
            System.out.println("full");
        }
    }
    public void pop(){
        if(!isEmpty()){
            this.top--;
        } else {
            System.out.println("empty");
        }
    }
    public void peek(){
        if (this.isEmpty()){
            System.out.println("empty");
        } else {
        System.out.println(this.array[top]);
        }
    }
    public String print(){
       if (this.isEmpty()){
           return "empty";
       } 
        String res = "";
        for(int i = 0; i <= this.top; i++){
            if(res.length()==0){
                res += array[i];
            } else {
                res += " " + array[i];
            }
        }
        return res;
    }
    public boolean IsFull(){
        return (this.top == array.length-1);

    }
    public boolean isEmpty(){
        return (this.top == -1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        int k = Integer.parseInt(first);
        Stack stack = new Stack(k);
                
        boolean value = true;
        while (value){
            String input = sc.nextLine();
            String option = input.split(" ")[0];
            switch(option){
                case "end":
                    value = false;
                    break;
                case "print":
                    System.out.println(stack.print());
                    break;
                case "push":
                    Integer x = Integer.parseInt(input.split(" ")[1]);
                    stack.push(x);
                    break;
                case "peek":
                    stack.peek();
                    break;
                case "pop":
                    stack.pop();
                    break;
            }
        }
        sc.close();
    }
}
