package Utilidades;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class MensajesEntrada {
	

	  public static void MensajesJoin(Player p) {
		  
		      if (p.hasPermission("sdub.rango.vip")) {
		        Bukkit.broadcastMessage("§b§lExample " + p.getDisplayName() + " §6Ha §nentrado§6 al servidor.");
		      }
		    
		      else if (p.hasPermission("sdub.rango.creador"))
		      {
		        Bukkit.broadcastMessage("§4§lEL DIOS " + p.getDisplayName() + " §6Ha §nentrado§6 al servidor.");
		        World world = p.getWorld();
		        for (int i = 0; i <= 1; i++) {
		          world.strikeLightningEffect(p.getLocation());

		          Firework f = (Firework)p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), Firework.class);
		          FireworkMeta fm = f.getFireworkMeta();
		          fm.addEffect(FireworkEffect.builder()
		            .flicker(true).trail(true)
		            .with(FireworkEffect.Type.STAR).with(FireworkEffect.Type.BALL_LARGE).with(FireworkEffect.Type.BURST)
		            .withColor(Color.PURPLE)
		            .withColor(Color.RED).build());
		          fm.setPower(0);
		          f.setFireworkMeta(fm);
		        }
		      }
	  }
}
