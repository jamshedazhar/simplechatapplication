import redis.clients.jedis.JedisPubSub;

/**
 * Created by jamshed on 3/6/17.
 */
public class CustomJedisPubSub extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("'" + channel + "' says: " + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("Subscribed to channel:" + channel);
    }
}
