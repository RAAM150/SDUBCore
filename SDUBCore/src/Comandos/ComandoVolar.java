package Comandos;

import Core.Principal.Main;
import Utilidades.Mensajes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoVolar
  implements CommandExecutor
{
  Main plugin;

  public ComandoVolar(Main SDUBCore)
  {
    this.plugin = SDUBCore;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) { Mensajes.NoConsola(sender); return false;
    }
    Player p = (Player)sender;

    if (!p.hasPermission("sdub.comando.volar")) { Mensajes.NoPermiso(p); return false; }
    if (args.length > 1) { p.sendMessage(Main.MSG("PREFIJO_GENERAL") + "§c/volar <jugador>"); return false;
    }
    if (args.length == 0) {
        if (p.getAllowFlight()) {
          p.setAllowFlight(false);
          p.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §c§lDesactivado§7.");
        } else {
          p.setAllowFlight(true);
          p.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §2§lActivado§7.");
        }
        return true;
      }

    if ((p.hasPermission("sdub.comando.volar.otros")) && 
      (args.length == 1)) {
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
        p.sendMessage(Main.MSG("PREFIJO_GENERAL") + Main.MSG("JUGADOR_NO_ESTA_CONECTADO"));
      }
      else if (target.getAllowFlight()) {
        target.setAllowFlight(false);
        if (target != p)
        {
          target.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §c§lDesactivado§7.");
          sender.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §c§lDesactivado§7 Para: " + target.getDisplayName() + "§7.");
        }
      } else {
        target.setAllowFlight(true);
        if (target != p)
        {
          target.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §2§lActivado§7.");
          sender.sendMessage(Main.MSG("PREFIJO_GENERAL") + "Modo de vuelo: §2§lActivado§7 Para: " + target.getDisplayName() + "§7.");
        }
      }
    }

  

  return true;
}
}