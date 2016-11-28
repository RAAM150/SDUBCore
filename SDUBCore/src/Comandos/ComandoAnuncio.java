package Comandos;

import Core.Principal.Main;
import Utilidades.Mensajes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ComandoAnuncio
  implements CommandExecutor
{
  Main plugin;

  public ComandoAnuncio(Main SDUBCore)
  {
    this.plugin = SDUBCore;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!sender.hasPermission("sdub.comando.anuncio")) { Mensajes.NoPermiso(sender); return false; }
    if (args.length == 0) { sender.sendMessage(Main.MSG("PREFIJO_GENERAL") + "§c/anuncio <mensaje>"); return false;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      sb.append(args[i]).append(" ");
    }
    String msg = sb.toString();
    Bukkit.getServer().broadcastMessage("§7[§c§lANUNCIO§7]: §b" + ChatColor.translateAlternateColorCodes('&', msg));

    return true;
  }
}