package BOT.Events;



import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.SplitUtil;
import org.jetbrains.annotations.NotNull;
public class ButtonListeners extends ListenerAdapter {
    private String[] badWords = {"badword"};

    // http://www.bannedwordlist.com/lists/swearWords.txt use this link to get a list of bad words and feed it using file reader
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        for (String badword : badWords) {
            if (event.getMessage().getContentRaw().contains(badword)) {
//                event.getChannel().sendMessage("Bad word detected");

                System.out.println("Bad word detected");
                TextChannel adminChannel = event.getJDA().getTextChannelById("1015567314634145852");

                adminChannel.sendMessage("Bad word detected by "+event.getMember().getEffectiveName()).queue();
            }
        }

    }
}
