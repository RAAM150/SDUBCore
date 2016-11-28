package Utilidades;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Core.Principal.Main;

public class Mensajes {


  public static void Consola(String Texto) {
	Bukkit.getConsoleSender().sendMessage(Main.MSG("PREFIJO_CONSOLA") + Texto);
  }
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
  
  public static void MOTD(Player Jugador) {

	  Jugador.sendMessage("§6» §7Plugin Core: §c§lBETA§7. Creador de Plugins: §aRAAM150§7.");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("§7§m-----------------------------------------------------");
	  Jugador.sendMessage("                            §2● §a§lSurvivalDub §2●");
	  Jugador.sendMessage("                 §b¡Bienvenido al servidor de SurvivalDub!");
	  Jugador.sendMessage("");
	  Jugador.sendMessage("§8► §3§lTWITTER: §a@----");
	  Jugador.sendMessage("§8► §c§LFORO: §a----");
	  Jugador.sendMessage("§8► §2§lTIENDA: §a----");
	  Jugador.sendMessage("§7§m-----------------------------------------------------");
	  
  
	
}
}