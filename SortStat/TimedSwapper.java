import java.util.concurrent.TimeUnit;

public class TimedSwapper<T> implements Swapper<T> {

  private TimeUnit time;
  private long interval;

  public TimedSwapper() {
  }

  public TimedSwapper(TimeUnit time, long interval) {
    this.time = time;
    this.interval = interval;
  }

  @Override
  public void swap(T[] array, int i, int j) {
    try {
      if (time != null) {
        time.sleep(interval);
      }
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
