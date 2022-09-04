package BOT;

import BOT.Events.ButtonListeners;
import BOT.Events.EventListeners;
import BOT.Events.helloCommand;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Main {
    private final ShardManager shardManager;
    private final Dotenv config;

    // Using ShardManager so our  bot can be used by more than one user
    public Main() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.IDLE);
        builder.setActivity(Activity.watching("Youtube"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_MEMBERS,GatewayIntent.MESSAGE_CONTENT);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);

        shardManager = builder.build();

        shardManager.addEventListener(new EventListeners());
        shardManager.addEventListener(new ButtonListeners());
        shardManager.addEventListener(new helloCommand());


    }
    public Dotenv getConfig(){
        return config;
    }


    public static void main(String[] args) {
        try {
            Main bot = new Main();
        } catch (LoginException e) {
            System.out.println("Login token invalid");
        }



    }
}
