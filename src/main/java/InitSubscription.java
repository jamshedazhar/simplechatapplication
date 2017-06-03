import redis.clients.jedis.Jedis;

/**
 * Created by jamshed on 3/6/17.
 */
public class InitSubscription extends Thread {

    private final String channnnelName;
    private final String hostName;
    private final CustomJedisPubSub jedisPubSub;

    public InitSubscription(final String channnnelName, String hostName) {
        this.channnnelName = channnnelName;
        this.hostName = hostName;
        this.jedisPubSub = new CustomJedisPubSub();
    }

    public void run() {
        new Jedis(hostName).subscribe(jedisPubSub, channnnelName);
    }
}
