import java.util.concurrent.TimeUnit;

public class SlowSwapper<T> extends TimedSwapper<T> {

  public SlowSwapper() {
    super(TimeUnit.SECONDS, 1);
  }

}
