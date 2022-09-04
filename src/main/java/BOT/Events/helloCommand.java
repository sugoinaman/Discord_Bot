package BOT.Events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class helloCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();

        if(args[0].equalsIgnoreCase("hi")){
            if(!event.getMember().getUser().isBot()){
                event.getChannel().sendMessage("Hello "+name ).queue();
            }
        }
        super.onMessageReceived(event);
    }


}
