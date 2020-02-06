import java.util.*;

class Smoothie {
    private static  Map<String, List<String>> smoothies;
    public static String ingredients(String order) {
        initializeMenu();
        String[] arguments = order.split(",");
        checkArguments(arguments);
        String name = arguments[0];
        name.substring(1);
        List<String> requestedIngredients = new ArrayList<>();
        List<String> excludeIngredients = new ArrayList<>();
        for(int i=1; i< arguments.length; i++){
            if(arguments[i].indexOf("-")>=0){
                excludeIngredients.add(arguments[i]);
            }else {
                requestedIngredients.add(arguments[i]);
            }
        }

        List<String> ingredients = new ArrayList<>(getSmoothies().get(name));
        ingredients.removeAll(excludeIngredients);
        return String.join(",", ingredients);
    }
    private static void checkArguments(String arguments[]){

        if(arguments == null || arguments.length==0){
            throw new IllegalArgumentException();
        }
        String name = arguments[0];
        if(!getSmoothies().containsKey(name)){
            throw new IllegalArgumentException();
        }
    }
    private static void initializeMenu(){
        smoothies = new HashMap<>();
        smoothies.put("Classic", Arrays.asList(new String[]{"strawberry", "banana", "pineapple", "mango", "peach", "honey"}));
        smoothies.put("Freezie",Arrays.asList(new String[]{"blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"}));
        smoothies.put("Greenie",Arrays.asList(new String[]{"green apple", "lime", "avocado", "spinach", "ice", "apple juice"}));
        smoothies.put("Just Desserts",Arrays.asList(new String[]{"banana", "ice cream", "chocolate", "peanut", "cherry"}));


    }
    public static Map<String, List<String>> getSmoothies(){
        return smoothies;
    }
    public static void addSmoothie(String name, List<String> ingredients){
        getSmoothies().put(name,ingredients);
    }
}
