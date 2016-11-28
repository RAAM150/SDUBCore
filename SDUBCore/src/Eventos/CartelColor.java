package Eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class CartelColor
  implements Listener
{
  @EventHandler(priority=EventPriority.LOWEST)
  public void CarteldeColor(SignChangeEvent e)
  {
    Player p = e.getPlayer();

    if (p.hasPermission("sdub.cartel.color"))
    {
      e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
      e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
      e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
      e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
    }
  }
}