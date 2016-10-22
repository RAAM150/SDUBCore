package Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import Core.Principal.Main;

public class Loop {

	int count = 0;
	
	public static boolean force = true;
	
	@SuppressWarnings("deprecation")
	public Loop()
	{
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(p.hasPermission("sdub.marcador.alertas"))
			{
				p.sendMessage("&c&lScoreboard: &7Setting up loop (type:BukkitRunnable)");
			}
		}
			
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        scheduler.scheduleSyncRepeatingTask(Main.Plugin, new Runnable() {
	            @Override
	            public void run() {
	            	for(Player p : Bukkit.getOnlinePlayers())
			        {
			        	Marcador.setBoardToPlayer(p);
			        }
	            	if(force == true)
	            	{
	            		force = false;
	            	}
	            }
	        }, 0L, 20);	
	        
	
	}
	
}