package Comandos;

import Core.Principal.Main;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Utilidades.Mensajes;

public class ComandoAusente
  implements CommandExecutor
{
  Main plugin;
  public static HashMap<String, Boolean> Ausente = new HashMap<>();

  public ComandoAusente(Main SDUBCore)
  {
	    this.plugin = SDUBCore;
	  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) { Mensajes.NoConsola(sender); return false;
    }
    Player p = (Player)sender;

    if (!p.hasPermission("sdub.comando.ausente")) { Mensajes.NoPermiso(p); return false; }
    if (args.length > 1) { p.sendMessage(Main.MSG("PREFIJO_GENERAL") + "§c/ausente <jugador>"); return false;
    }
    if (args.length == 0) {
      if (!Ausente.containsKey(p.getName())) {
        Ausente.put(p.getName(), Boolean.valueOf(true));
        Bukkit.getServer().broadcastMessage("§6» §e¡El jugador " + p.getDisplayName() + " §eahora está ausente!");
      } else {
        Ausente.remove(p.getName());
        Bukkit.getServer().broadcastMessage("§6» §e¡El jugador " + p.getDisplayName() + " §eya no está ausente!");
      }
      return true;
    }

    if ((p.hasPermission("warcraft.comando.ausente.otros")) && 
      (args.length == 1)) {
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
        p.sendMessage(Main.MSG("PREFIJO_GENERAL") + Main.MSG("JUGADOR_NO_ESTA_CONECTADO"));
      }
      else if (Ausente.containsKey(target.getName()))
        Bukkit.getServer().broadcastMessage("§6» §e¡El jugador " + target.getDisplayName() + " §eahora está ausente!");
      else {
        Bukkit.getServer().broadcastMessage("§6» §e¡El jugador " + target.getDisplayName() + " §eya no está ausente!");
      }

    }

    return false;
  }
}