package SignIn;

import java.util.ArrayList;
import java.util.List;

public class GetInformation {
    private List<User> Players = new ArrayList<>();

    private int detection = 0;

    @Override
    public String toString() {
        return "GetInformation{" +
                "Players=" + Players +
                '}';
    }

    public void register(String accont, String passord, String name) {
        User user = new User(accont, passord, name);
            if (this.detection == 0) {
                if (Players.size() == 0){
                    Players.add(user);//第一个人注册
                }else {
                    for (int s = 0 ; s < Players.size()  ; s++) {
                        if (Players.get(s).getAccont().equals(accont)) {
                            System.out.println("该账号已被注册");
                            detection = 1;
                            break;//判断账号存在
                        }
                    }
                    if (detection == 0){
                        Players.add(user);//将新账户加入数据库
                    }else if (detection == 1){
                        detection = 0;

                    }                }
            }

    }
}
