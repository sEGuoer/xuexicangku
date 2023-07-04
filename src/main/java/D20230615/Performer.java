package D20230615;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Performer {
    public static void main(String[] args) {
        System.out.println("刘德华".length());
        List<String> performerman = Arrays.asList("刘德华","成龙","吴彦祖","周润发","周星驰","吴京");
        List<String> performerwoman = Arrays.asList("林心如","孙俪","柳岩","林青霞","王祖贤","张曼玉");
        List<String> selectman = performerman.stream().filter(o -> o.length() == 3).limit(3).collect(Collectors.toList());/*.forEach(o ->{
            System.out.println(o);
        })*/
        List<String> selectwoman = performerwoman.stream().filter(o -> o.charAt(0) == '林').skip(1).collect(Collectors.toList());/*.forEach(o ->{
            System.out.println(o);
        })*/
        List selectperson = (Stream.concat(selectman.stream(),selectwoman.stream()).collect(Collectors.toList()));
        /*selectperson.forEach(o -> {
            System.out.println(o);
        })*/
        Actor actor1 = new Actor();
        Actor actor2 = new Actor();
        Actor actor3 = new Actor();
        Actor actor4 = new Actor();
        actor1.setName( selectperson.get(0));
        actor2.setName( selectperson.get(1));
        actor3.setName( selectperson.get(2));
        actor4.setName( selectperson.get(3));
        Map<Integer, String> actor = new HashMap<>();
        actor.put(1,actor1.toString());
        actor.put(2,actor2.toString());
        actor.put(3,actor3.toString());
        actor.put(4,actor4.toString());
        Set<Integer> xinxi = actor.keySet();
        for (Integer k : xinxi){
            System.out.println(actor.get(k));
            System.out.println("————————————————————————————————————————");
        }


    }
}
