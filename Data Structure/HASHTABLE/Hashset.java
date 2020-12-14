import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        Hashset hashset = new Hashset(size);

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
                case "put":
                    int e = Integer.parseInt(entrada[1]);
                    hashset.put(e);
                    System.out.println(hashset.print());
                    break;

                case"remove":
                    int x = Integer.parseInt(entrada[1]);    
                    hashset.remove(x);
                    System.out.println(hashset.print());
                    break;
                case "contains":
                    int y = Integer.parseInt(entrada[1]);
                
                    System.out.println(hashset.contains(y)); 
                    break;
                
                }

        }
        scan.close();
	}

}

 class Hashset {

    Integer[] array;
    
    public Hashset(int size){
        this.array = new Integer[size];
    }
    private int hash(int key){
        return key % (this.array.length);
    }

    public void put(Integer element){
        if(element != null && !this.contains(element)){
            int i = 0;
            int hash;

            while(i < array.length){
                hash = (hash(element) + i) % array.length;
                if(array[hash] == null){
                    array[hash] = element;
                    break;
                }
                i++;
            }
        }

    }

    public void remove(Integer element){
        if(element != null && this.contains(element)){
            int i = 0;
            int hash;

            while(i < array.length){
                hash = (hash(element) + i) % array.length;
                if(array[hash] != null && array[hash] == element){
                    array[hash] = null;
                    break;
                }
                i++;
            }
        }

    }
    public boolean contains(Integer e){
        boolean v = false;
        if(e != null){
            int i = 0;
            int hash;

            while(i < array.length){
                hash = (hash(e) + i) % array.length;
                if(array[hash] != null && array[hash] == e){
                    return true;
                }
                i++;
            }
        }
        return v;
    }
    public String print(){
        return Arrays.toString(array);
    }
    
}
