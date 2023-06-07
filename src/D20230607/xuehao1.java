package D20230607;

import java.lang.reflect.Array;

public class xuehao1 {
    public static void main(String[] args) {
        Student student = new Student();
        student.xuehao = "201921149061";
        student.age =22;
        student.name="zcy";

        dog dog1=new dog();
        dog1.bianhao="1";
        dog1.name="1b";
        dog1.color="black";

        dog dog2=new dog();
        dog2.bianhao="2";
        dog2.name="2b";
        dog2.color="green";

        dog[] ds1=new dog[]{dog1,dog2};
        student.count=ds1;
        student.show();
        for (int i=0;i<ds1.length;i++){
            ds1[i].dogshow();
        }
        System.out.println();

        Student student1 = new Student();
        student1.xuehao = "201921149058";
        student1.age =21;
        student1.name="asd";

        dog dog3=new dog();
        dog3.bianhao="3";
        dog3.name="3b";
        dog3.color="drak";

        dog[] ds2=new dog[]{dog3};
        student1.count=ds2;
        student1.show();
        for (int i=0;i<ds2.length;i++){
            ds2[i].dogshow();
        }

    }
}
