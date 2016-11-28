package Eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColorChat
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGHEST)
  public void CambiarColorChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    String m = e.getMessage();

    if (p.hasPermission("sdub.chat.color"))
    e.setMessage(ChatColor.translateAlternateColorCodes('&', m));
    m = m.replace(":)", "☺");
    m = m.replace(":(", "☹");
    m = m.replace("<3", "♥");
    e.setMessage(m);
  }
}