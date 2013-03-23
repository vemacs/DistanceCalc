package com.nullblock.vemacs.DistanceCalc;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class DistanceCalc extends JavaPlugin {
	

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		}
	
	@Override
	public void onDisable() {
	}
	
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			if(cmd.getName().equalsIgnoreCase("distance")){ // If the player typed /basic then do the following...
				Player player = (Player) sender;
				Location loc = player.getLocation();
				double x = loc.getBlockX();
				double y = loc.getBlockY();
				double z = loc.getBlockZ();
				Location spawn = new Location(player.getWorld(), player.getWorld().getSpawnLocation().getX(), player.getWorld().getSpawnLocation().getY(), player.getWorld().getSpawnLocation().getZ());
				double x1 = spawn.getBlockX();
				double y1 = Integer.parseInt(DistanceCalc.this.getConfig().getString("spawnheight"));
				//bukkit's getSpawnLocation returns the incorrect height, I'm going to rely on the server owner to supply this value
				double z1 = spawn.getBlockZ();
				double xdiff = x1 - x;
				double ydiff = y1 - y;
				double zdiff = z1 - z;
				double distance = Math.sqrt( Math.pow(xdiff, 2) + Math.pow(ydiff, 2) + Math.pow(zdiff, 2));
				double distanceplane = Math.sqrt( Math.pow(xdiff, 2) + Math.pow(zdiff, 2));
			    DecimalFormat twoDForm = new DecimalFormat("#.##"); 
			    distance = Double.valueOf(twoDForm.format(distance));
			    distanceplane = Double.valueOf(twoDForm.format(distanceplane));
				player.sendMessage(ChatColor.AQUA + "Your 3-dimensional distance from spawn is " + distance + " blocks.");
				player.sendMessage(ChatColor.AQUA + "Your 2-dimensional distance from spawn is " + distanceplane + " blocks.");
				return true;
			} 
			Player player = (Player) sender;
			player.sendMessage(ChatColor.DARK_RED + "An internal error has occurred.");
			return false; 
		}
}