package D20230606;

public class shuzupaixu {
    public static void main(String[] args) {
        int[] shuzu = new int[]{7, 3, 5, 8, 9, 20, 2, 15};
        for (int i = shuzu.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (shuzu[j] > shuzu[j + 1]) {
                    int a = shuzu[j];
                    shuzu[j] = shuzu[j + 1];
                    shuzu[j + 1] = a;
                }
            }
        }
        for (int i1 = 0; i1 < shuzu.length; i1++) {
            System.out.print(shuzu[i1] + " ");
        }
    }
}
