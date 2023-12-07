import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class TimedComparator<T extends Comparable<T>> implements Comparator<T> {

  private TimeUnit time;
  private long interval;

  public TimedComparator() {
  }

  public TimedComparator(TimeUnit time, long interval) {
    this.time = time;
    this.interval = interval;
  }

  @Override
  public int compare(T o1, T o2) {
    try {
      if (time != null) {
        time.sleep(interval);
      }
      return o1.compareTo(o2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 0;
  }

}
