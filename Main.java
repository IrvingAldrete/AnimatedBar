package fr.Yoyo522.animatedbar;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import fr.Yoyo522.animatedbar.utils.ActionBarAPI;
import fr.Yoyo522.animatedbar.utils.AirBar;

public class Main extends JavaPlugin implements Listener{
	
	
	//Create ArrayList for actionbar broadcast
	static ArrayList<String> actionbar = new ArrayList<>();
	//and airbar !
	static ArrayList<String> airbar = new ArrayList<>();	
	
	public static Main instance;
	
	public static Main getInstance(){
		return instance;
	}
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
		instance = this;
		super.onEnable();
		System.out.println("["+this.getDescription().getName()+"] is load !");
	}
	
	public void onDisable(){
		super.onDisable();
		System.out.println("["+this.getDescription().getName()+"] is unload !");
	}
	//How to set to player ?
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		this.addactionbar(p);
		this.airbar(p);
	}
	
	
	
	//How create animated action bar Message ?
	
	
	
	public void addactionbar(final Player p){
		actionbar.clear();
		actionbar.add("1");
		
		BukkitScheduler s = Bukkit.getServer().getScheduler();
		s.scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				
				Integer i = actionbar.size();
				
				if(i == 1){
					ActionBarAPI.sendActionbar(p, "§c§l-50% §fSummer sale §l➜ §cSHOP.SERVERNAME.NET");
					actionbar.add("A");
				}
				if(i == 2){
					ActionBarAPI.sendActionbar(p, "§6§l-50% §fSummer sale §l➜ §cSHOP.SERVERNAME.NET");
					actionbar.add("B");
				}
				if(i == 2){
					actionbar.clear();
					actionbar.add("1");
				}
				
			}
			
		}, 0, 10);
	}
	
	
	public void airbar(final Player p){
		airbar.clear();
		airbar.add("1");
		
		BukkitScheduler s = Bukkit.getServer().getScheduler();
		s.scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				
				Integer i = airbar.size();
				
				if(i == 1){
					AirBar.sendAirBar(p, "§aRank§7, §bBooster§7, §6Cosmetics §f§l➜ §eSHOP.SERVERNAME.NET", BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.CREATE_FOG);
					airbar.add("A");
				}
				if(i == 2){
					AirBar.sendAirBar(p, "§cRank§7, §bBooster§7, §6Cosmetics §f§l➜ §eSHOP.SERVERNAME.NET", BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.CREATE_FOG);
					airbar.add("B");
				}
				if(i == 3){
					AirBar.sendAirBar(p, "§aRank§7, §cBooster§7, §6Cosmetics §f§l➜ §eSHOP.SERVERNAME.NET", BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.CREATE_FOG);
					airbar.add("C");	
				}
				if(i == 4){
					AirBar.sendAirBar(p, "§aRank§7, §bBooster§7, §cCosmetics §f§l➜ §eSHOP.SERVERNAME.NET", BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.CREATE_FOG);
					airbar.add("D");	
				}
				if(i == 5){
					AirBar.sendAirBar(p, "§aRank§7, §bBooster§7, §6Cosmetics §f§l➜ §cSHOP.SERVERNAME.NET", BarColor.BLUE, BarStyle.SEGMENTED_10, BarFlag.CREATE_FOG);
					airbar.add("E");	
				}
				if(i == 5){
					airbar.clear();
					airbar.add("1");
				}
				
			}
			
		}, 0, 40);
	}

}
