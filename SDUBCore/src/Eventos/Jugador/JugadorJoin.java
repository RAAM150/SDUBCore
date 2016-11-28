package Eventos.Jugador;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Core.Principal.Main;
import Utilidades.Items;
import Utilidades.Mensajes;
import Utilidades.MensajesEntrada;
import Utilidades.Titulos;

public class JugadorJoin
  implements Listener
{
  Main plugin;

  @SuppressWarnings("deprecation")
@EventHandler(priority=EventPriority.HIGHEST)
  public void EntrarAlServidor(PlayerJoinEvent e)
  {
	e.setJoinMessage(null);
    Player p = e.getPlayer();
    
// ITEMS
    Items.ItemsUsuario(p);
    if (p.hasPermission("warcraft.rango.creador"))
    {
    Items.ItemsStaff(p);
    }
// MOTD Y TITLE AL ENTRAR AL SERVIDOR.
    Mensajes.MOTD(p);
    Titulos.EnviarTitulo(p, "§e● §a§lSurvivalDub §e●");
    Titulos.EnviarSubTitulo(p, "§7IP: §cmc.survivaldub.com");
    Titulos.EnviarEnTiempo(p, 20, 70, 40);
//  PONER MARCADOR
    //Marcador.setBoardToPlayer(e.getPlayer());
//  EVENTOS JUGADOR 
    p.setHealth(2.0D);
    p.setMaxHealth(1);
    p.setFoodLevel(20);
    p.setFireTicks(0);
    p.setSaturation(20.0F);
// MENSAJES PARA JUGADORES CON PERMISOS    
    MensajesEntrada.MensajesJoin(p);
    
    if (p.hasPermission("warcraft.rango.developer"))
    {
    p.sendMessage(Bukkit.getBukkitVersion());
    p.sendMessage("§9¡LA CLASE SI CARGO HASTA ACÁ!...");
    }
 }
}