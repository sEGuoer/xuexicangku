package D20230613;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

public class Son extends Father implements Itelegent{
    @Override
    public List<Son> getnumber() {
        return null;
    }

    public static void main(String[] args) {

        List<Character> sList = new ArrayList<>();
        sList.add('a');
        sList.add('c');
        sList.add('g');
        sList.add('f');
        sList.add('m');
        sList.add('j');
        sList.remove(0);

        for (Character character : sList){
            System.out.print(character);
            System.out.println();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : sList) {
            if (map.containsKey(character)) {
                Integer num = map.get(character);
                Integer nums = num + 1;
                map.put(character,nums);
            }else {
                map.put(character,1);}
        }
        for (int i = 0; i < 26; i++) {
            char a = (char)(i+97);
            for (int j = 0; j < map.size(); j++) {
                if (map.entrySet().equals(a)){
                    System.out.println(a+":"+map.entrySet());
                }
            }

        }
     /*   for (int i = 97; i < 97 + 26; i++) {
            int num = 0;
            for (int j = 97; j < 97 + sList.size(); j++) {
                int charj = (int) sList.get(j - 97);
                if (charj == i) {
                    num++;
                }
            }
            if (num > 0) {
                System.out.println((char) i + ":" + num);
            }
        }*/
        //Map<String, Character> map = new HashMap<>();
    }
}
