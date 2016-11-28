package Eventos.Servidor;

import Core.Principal.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Servidor
  implements Listener
{
  @EventHandler
  public void LluviaServer(WeatherChangeEvent event)
  {
    if (Main.Configuración.getBoolean("Eventos_Servidor.Lluvia"))
      event.setCancelled(true);
  }
  
  @EventHandler
  public void Daños(EntityDamageEvent event)
  {
    if (Main.Configuración.getBoolean("Eventos_Servidor.Daños"))
      event.setCancelled(true);

  }
}