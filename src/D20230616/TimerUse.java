package D20230616;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUse {
    static TimerTask task = new TimerTask() {
        private int i = 1;

        @Override

        public void run() {
            System.out.println(new Date());

        }
    };

    public static TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(getTask(), 4000, 2000);
        System.out.println();
    }
}
