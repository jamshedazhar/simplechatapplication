import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;
import static java.lang.Thread.sleep;

/**
 * Created by jamshed on 3/6/17.
 */
public class Main {

    private static final String HOSTNAME = "127.0.0.1";
    private static Jedis jedis = new Jedis(HOSTNAME);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        if (args.length < 1) {
            System.out.println("Usage: " + Main.class + " <username>");
            exit(0);
        }

        String rawText;
        String username;
        String message;

        if (jedis.pubsubChannels("*").contains(args[0])) {
            System.out.println("User '" + args[0] + " already exists. Try with different user");
            exit(0);
        }

        createAndSubscribeToChannel(args[0]);
        sleep(100);

        System.out.println("Your user name is:  " + args[0]);

        while (true) {
            System.out.print("Enter <username> <message> to send message: ");
            rawText = br.readLine();
            username = rawText.split(" ")[0];
            message = rawText.substring(username.length());

            jedis.publish(username, message.trim());

            System.out.println("Your message '" + message + "' sent to '" + username + "'");
        }
    }

    private static void createAndSubscribeToChannel(String channelName) {
        new InitSubscription(channelName, HOSTNAME).start();
    }
}
