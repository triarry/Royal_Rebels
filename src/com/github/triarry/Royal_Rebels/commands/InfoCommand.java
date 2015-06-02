package com.github.triarry.Royal_Rebels.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.triarry.Royal_Rebels.Royal_Rebels;

public class InfoCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Royal_Rebels plugin;
	  
	public InfoCommand(Royal_Rebels plugin){ 
		this.plugin = plugin; 
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("royal_rebels")) {
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "#####");
			sender.sendMessage(ChatColor.GREEN + "Currently running iRestore version 1.6.0");
			sender.sendMessage(ChatColor.GREEN + "Plugin made by triarry");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "#####");
			return true;
		}
		
		else {
			return true;
		}
	}
}