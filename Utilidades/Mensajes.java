package Utilidades;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Core.Principal.Main;

public class Mensajes {


  public static void Jugador(Player Jugador, String Texto) {
	Jugador.sendMessage(Main.MSG("PREFIJO_GENERAL") + Texto);
  }

  public static void NoConsola(CommandSender sender)
  {
    sender.sendMessage(Main.MSG("PREFIJO_CONSOLA") + Main.MSG("NO_CONSOLA"));
  }

  public static void NoPermiso(CommandSender sender) {
    sender.sendMessage(Main.MSG("PREFIJO_GENERAL") + Main.MSG("NO_PERMISO"));
    
  }
}