package Eventos;

import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.SimplePluginManager;

import Core.Principal.Main;

public class ComandoNoEncontrado
  implements Listener
{
  public boolean isCmdRegistered(String cmd)
  {
    return getCommandMap().getCommand(cmd.replaceFirst("/", "")) != null;
  }
  private SimpleCommandMap getCommandMap() {
    if ((Bukkit.getPluginManager() instanceof SimplePluginManager)) {
      Field f = null;
      try {
        f = SimplePluginManager.class
          .getDeclaredField("commandMap");
      } catch (NoSuchFieldException|SecurityException e) {
        e.printStackTrace();
        return null;
      }
      f.setAccessible(true);
      try {
        return (SimpleCommandMap)f.get(Bukkit.getPluginManager());
      } catch (IllegalArgumentException|IllegalAccessException e) {
        e.printStackTrace();
        return null;
      }
    }
    return null;
  }
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
    if (event.isCancelled()) return;
    String cmd = event.getMessage();
    if ((cmd == null) || (cmd.equalsIgnoreCase(""))) {
      event.getPlayer().sendMessage(Main.MSG("PREFIJO_GENERAL") + Main.MSG("COMANDO_NO_ENCONTRADO"));
      event.setCancelled(true);
      return;
    }
    cmd = cmd.split(" ")[0];

    if (!isCmdRegistered(cmd)) {
        event.getPlayer().sendMessage(Main.MSG("PREFIJO_GENERAL") + Main.MSG("COMANDO_NO_ENCONTRADO"));
      event.setCancelled(true);
    }
  }
}