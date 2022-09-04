package BOT.Events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListeners extends ListenerAdapter {


    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        super.onMessageDelete(event);
        String deletedMessage = event.toString();
//        User user=event.getJDA().getUserByTag();
//        event.getGuild().getDefaultChannel().asStandardGuildMessageChannel().sendMessage("Deleted message was "+deletedMessage+" and message  id was"  +user).queue();

    }
}
