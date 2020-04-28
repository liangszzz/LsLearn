package schedule;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduleLearn {

    private ScheduledExecutorService executor;

    public ScheduleLearn() {
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }


    public static void main(String[] args) {


    }

    private void schedule(CronTask task) {

        LocalDateTime runTime = task.getNextRunTime();


    }

    class CronTask implements Runnable {

        private final String expression;

        private final Runnable runnable;

        CronTask(String expression, Runnable runnable) {
            this.expression = expression;
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }

        private Timer parseTimer() {
            String s = expression;


            return null;
        }

        public LocalDateTime getNextRunTime() {
            return LocalDateTime.now().plusSeconds(4);
        }
    }
}
