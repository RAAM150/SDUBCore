package Eventos.Jugador;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class JugadorLeave
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGHEST)
  public void SalirDelServidor(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
// MARCADOR
// EVENTO Y MENSAJE
    e.setQuitMessage(null);
    p.getInventory().clear();
  }
}