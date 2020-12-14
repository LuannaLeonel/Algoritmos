import java.util.Scanner;
import java.util.LinkedList;

class Word_cloud {
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] frase = scan.nextLine().split(" ");
        int size = frase.length;
        HashMap hashMap = new HashMap(size);
        for(String elem : frase){
            hashMap.put(elem);
        }
        
        boolean value = true;
		String entrada;
        
        while(value){
            entrada = scan.nextLine().trim();
            if (entrada.equals("fim")){
                value = false;
            } else {
                System.out.println(hashMap.count(entrada));
            }
        }
    }
}
class HashMap{
    LinkedList<String>[] cloud;

    public HashMap(int size){
        cloud = new LinkedList[size];
    }

    private int hash(String word, int prob){
        return (Math.abs(word.hashCode() % cloud.length) + prob);
    }

    public int count(String elem){
        return cloud[indexOf(elem)].size();
    }

    public void put(String word){
        int prob = 0;
        int hashCode = this.hash(word,prob);
        if(contains(word)){
            cloud[indexOf(word)].add(word);
        } else{
            while(cloud[hashCode] !=null){
                hashCode = hash(word,++prob);
            }
            cloud[hashCode] = new LinkedList<>();
            cloud[hashCode].add(word);
        }
    }

    private boolean contains(String word){
        int prob = 0;
        int hashCode = hash(word,prob);
        while(prob < cloud.length && cloud[hashCode] != null){
            if(cloud[hashCode].contains(word)){
                return true;
            }
            hashCode = hash(word,++prob);
        }
        return false;
    }

    private int indexOf(String word) {
        if (!contains(word)) return -1;
        int prob = 0;
        int hashCode = hash(word, prob);
        while (prob < cloud.length && cloud[hashCode] != null) {
            if (cloud[hashCode].contains(word)) {
                return hashCode;
            }
            hashCode = hash(word, ++prob);
        }
        return -1;
    }
} 


/**import java.util.LinkedList;
import java.util.Scanner;

class WordCloud {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        WordCloud wc = new WordCloud(words.length);

        for(String elem : words){
            wc.put(elem);
        }

        String option = sc.nextLine();
        while(!option.equals("fim")){
            System.out.println(Integer.toString(wc.count(option)));
            option = sc.nextLine();
        }
        sc.close();
    }

    LinkedList<String>[] cloud;

    public WordCloud(int size){
        cloud = new LinkedList[size];
    }

    private int hash(String word, int prob){
        return (Math.abs(word.hashCode() % cloud.length) + prob);
    }

    public int count(String elem){
        return cloud[indexOf(elem)].size();
    }

    public void put(String word){
        int prob = 0;
        int hashCode = this.hash(word,prob);
        if(contains(word)){
            cloud[indexOf(word)].add(word);
        } else{
            while(cloud[hashCode] !=null){
                hashCode = hash(word,++prob);
            }
            cloud[hashCode] = new LinkedList<>();
            cloud[hashCode].add(word);
        }
    }

    private boolean contains(String word){
        int prob = 0;
        int hashCode = hash(word,prob);
        while(prob < cloud.length && cloud[hashCode] != null){
            if(cloud[hashCode].contains(word)){
                return true;
            }
            hashCode = hash(word,++prob);
        }
        return false;
    }

    private int indexOf(String word) {
        if (!contains(word)) return -1;
        int prob = 0;
        int hashCode = hash(word, prob);
        while (prob < cloud.length && cloud[hashCode] != null) {
            if (cloud[hashCode].contains(word)) {
                return hashCode;
            }
            hashCode = hash(word, ++prob);
        }
        return -1;
    }
} **/
