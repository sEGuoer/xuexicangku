package D20230620;

import D20230613.Itelegent;
import D20230613.Son;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main implements Itelegent {
    public static void main(String[] args) throws IOException {
        Player player1 = new Player(1, "name1");
        Player player2 = new Player(2, "name2");
        Player player3 = new Player(3, "name3");
        Player player4 = new Player(4, "name4");
        Player player5 = new Player(5, "name5");
        List<Player> Players = new ArrayList<>();
        Players.add(player1);
        Players.add(player2);
        Players.add(player3);
        Players.add(player4);
        Players.add(player5);
        System.out.println(Players);
        Gson gson = new Gson();
        String s = gson.toJson(Players);
      /*  String s = "";
        for (Player player : Players){
            s = s + Players.get(player.getId()-1) + ",";
        }*/
        System.out.println(s);
        File f = new File("C:/Users/Administrator/Desktop/xuexicangku/src/D20230620/Players.json");
        boolean newFile = f.createNewFile();
        System.out.println(newFile);
        byte[] biff =  s.getBytes();
        RandomAccessFile randomAccessFile = new RandomAccessFile(f,"rws");
        randomAccessFile.write(biff);

        InputStream inputStream = new FileInputStream(f);
        byte[] input = new byte[(int) f.length()];
        inputStream.read(input);
        String s1 = new String(input);
        System.out.println(s1);
    }

    @Override
    public List<Son> getnumber() {
        return null;
    }
}
