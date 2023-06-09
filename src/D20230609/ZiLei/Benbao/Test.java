package D20230609.ZiLei.Benbao;


public class Test {
    public static void main(String[] args) {

        Test.XiuShiFu xiuShiFu = new Test.XiuShiFu();
        xiuShiFu.publictest="a";
        xiuShiFu.test="a";
        xiuShiFu.privatetest="a";
        xiuShiFu.publicMethod();
        xiuShiFu.Method();
        xiuShiFu.privateMethod();
    }
    public static class XiuShiFu {
        public String publictest;
        String test;
        private String privatetest;

        public void publicMethod() {
        }

        void Method() {
        }

        private void privateMethod() {
        }
    }

    class Run{

    }
}
