package com.massivecraft.factions.discord;

import com.massivecraft.factions.cmd.CommandContext;
import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.zcore.util.TL;
import mkremins.fanciful.FancyMessage;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import org.bukkit.ChatColor;

public class CmdInviteBot extends FCommand {

    public CmdInviteBot(){
        super();
        this.aliases.add("invitebot");
    }

    @Override
    public void perform(CommandContext context) {
        JDA jda = FactionChatHandler.jda;
        FancyMessage fancyMessage = new FancyMessage();
        fancyMessage.link(jda.asBot().getInviteUrl(Permission.MESSAGE_READ, Permission.MESSAGE_WRITE, Permission.MESSAGE_HISTORY, Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_EMBED_LINKS));
        fancyMessage.text("Click here to invite the bot");
        fancyMessage.color(ChatColor.BLUE);
        fancyMessage.send(context.fPlayer.getPlayer());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.INVITE_BOT_USAGE;
    }
}