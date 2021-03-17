package homework_6;

import java.util.concurrent.TimeUnit;

public final class SleepUtil {

    private SleepUtil(){

    }

    public static void sleep(long milli){
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
