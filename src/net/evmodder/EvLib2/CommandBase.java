package net.evmodder.EvLib2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommandBase implements CommandExecutor{
//	protected EvPlugin plugin;
	String commandName;
	final static CommandExecutor disabledCmdExecutor = new CommandExecutor(){
		@Override
		public boolean onCommand(CommandSender sender, Command command, String label, String args[]){
			sender.sendMessage(ChatColor.RED+"This command is currently unavailable");
			return true;
		}
	};

	public CommandBase(JavaPlugin pl, boolean enabled){
//		plugin = pl;
		commandName = getClass().getSimpleName().substring(7).toLowerCase();
		pl.getCommand(commandName).setExecutor(enabled ? this : disabledCmdExecutor);//TODO: fix? test?
	}

	public CommandBase(JavaPlugin pl){
		this(pl, true);
	}
}