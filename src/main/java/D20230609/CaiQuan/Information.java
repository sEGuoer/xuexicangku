package D20230609.CaiQuan;

import java.util.Random;
import java.util.Scanner;

public class Information {
    private String caiQuan;
    private String computerInput;

    public void setCaiQuan() {
        System.out.println("Enter rock, paper or scissors");
        Scanner SC = new Scanner(System.in);
        String caiQuan=SC.next();
        this.caiQuan =caiQuan;
    }

    public String getCaiQuan() {
        return caiQuan;
    }
    public String computerInput(){
        Random random = new Random();
        int j = (int)(Math.random()*3+1);
        String computerInput = "";
        if (j == 1){
            computerInput = "rock";
            this.computerInput=computerInput;
        } else if (j == 2) {
            computerInput = "paper";
            this.computerInput=computerInput;
        }else {
            computerInput = "scissors";
            this.computerInput=computerInput;
        }
        return computerInput;
    }

    public String getComputerInput(){
        return computerInput;
    }

    public String compare(){
        if ((caiQuan.equals("rock")) || (caiQuan.equals("paper")) || (caiQuan.equals("scissors"))) {
            if (computerInput.equals(caiQuan)){
                return "draw";
            } else if (((computerInput.equals("rock")) && (caiQuan.equals("paper"))) || ((computerInput.equals("paper")) && (caiQuan.equals( "scissors")))|| ((computerInput.equals("scissors")) && (caiQuan.equals("rock"))) ) {
                return "win";
            } else {
                return "lose";
            }
        }else {
            System.out.println("请输入正确的英文");
            System.exit(1);
            return "";
        }
    }

    public void run(){
        System.out.println("User Input : " + getCaiQuan());
        System.out.println("Computer Input : " + getComputerInput());
        System.out.println(compare());
    }
}
