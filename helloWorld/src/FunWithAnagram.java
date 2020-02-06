import java.util.*;

public class FunWithAnagram {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("code", "aaagmnrs", "anagrams", "doce"));
       // List<String> strings = funWithAnagrams(list);
       // strings.forEach(System.out::println);
        System.out.println(isAnagram("aaagmnrs","anagrams"));
    }
    public static List<String> funWithAnagrams(List<String> text) {
        List<String> toremove = new ArrayList<>();
        for(int i =0; i< text.size()-1;i++){
            for(int j=i+1;j<text.size();j++){
                String one = text.get(i);
                if(isAnagram(one,text.get(j))){
                    toremove.add(text.get(j));
                }
            }


        }
        Iterator<String> iterator = text.iterator();
        while(iterator.hasNext()){
             if(toremove.contains(iterator.next())){
                 iterator.remove();
             }
        }
        Collections.sort(text);
        return text ;
        // Write your code her
    }
    public static boolean isAnagram(String one,String two){
        if(one.length()!=two.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        char input[]= one.toCharArray();
        for( char c :input ){
            if(map.containsKey(c)){
                int s = map.get(c);
                map.put(c,++s);
            }else {
                map.put(c, 1);
            }
        }
        char input2[]= two.toCharArray();
        for(char c: input2){
            if(map.containsKey(c)){
                int s = map.get(c);
                map.put(c,s-1);
            }else{
                return false;
            }

        }
        Collection<Integer> values = map.values();
        for(int val:values){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
