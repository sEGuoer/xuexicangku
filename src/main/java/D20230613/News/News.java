package D20230613.News;

import java.util.*;

public class News {
    public static void main(String[] args) {
        Information information1 = new Information();
        Information information2 = new Information();
        Information information3 = new Information();
        Information information4 = new Information();
        information1.setContent("新闻一");
        information2.setContent("新闻二");
        information3.setContent("新闻三");
        information4.setContent("新闻四");
        information1.setTitle("中国多地遭雾霾笼罩空气质量再成热议话题");
        information2.setTitle("中国多地遭雾霾笼罩空气质量再成热议话题2");
        information3.setTitle("中国多地遭雾霾笼罩空气质量再成热议话题3");
        information4.setTitle("中国多地遭雾霾笼罩空气质量再成热议话题3");
        List<String> list = new ArrayList<>();
        list.add(information1.getTitle());
        list.add(information2.getTitle());
        list.add(information3.getTitle());
        list.add(information4.getTitle());

        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("————————————————————————————————————————");

        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i).equals(list.get(i+1)) ) {
                System.out.println("标题" + (i + 1) + "与标题" + (i + 2) + "相同");
            } else {
                System.out.println("标题" + (i + 1) + "与标题" + (i + 2) + "不相同");
            }
        }
        System.out.println("————————————————————————————————————————");
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put(information1.getContent(), information1.toString());
        hashMap.put(information2.getContent(), information2.toString());
        hashMap.put(information3.getContent(), information3.toString());
        hashMap.put(information4.getContent(), information4.toString());
/*
        System.out.println(hashMap);
*/
        Set<String> xinxi = hashMap.keySet();
        for (String k : xinxi){
            System.out.println(hashMap.get(k));
            System.out.println("————————————————————————————————————————");
        }
      /*  Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String,String> entry : entries) {
            entry.getValue();

        }*/



        System.out.println("新闻数量为"+hashMap.size());
    }
}
