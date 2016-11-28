package Eventos.Jugador;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import Core.Principal.Main;

public class JugadorEventos
  implements Listener
{
  Main plugin;

  @EventHandler(priority=EventPriority.HIGHEST)
  public void JugadorPuedeTirarItems(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Tirar_Items"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub." + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void JugadorPuedeRecogerItems(PlayerPickupItemEvent e)
  {
    Player p = e.getPlayer();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Recoger_Items"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub." + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void JugadorPuedeRomperBloques(BlockBreakEvent e)
  {
    Player p = e.getPlayer();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Romper_Bloques"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub." + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void JugadorPuedePonerBloques(BlockPlaceEvent e)
  {
    Player p = e.getPlayer();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Poner_Bloques"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub" + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }

  @EventHandler(priority=EventPriority.HIGHEST)
  public void JugadorNoTieneHambre(FoodLevelChangeEvent event) {
    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Hambre"))
      event.setCancelled(true);
  }

  @EventHandler
  public void JugadorPuedeMoverItems(InventoryMoveItemEvent e)
  {
    if (!(e.getSource().getHolder() instanceof Player)) {
      return;
    }

    Player p = (Player)e.getSource().getHolder();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Mover_Inventario"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub." + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }

  @EventHandler
  public void JugadorPuedeClickInventario(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();

    if (Main.Configuración.getBoolean("Eventos_Jugador.No_Mover_Inventario"))
      if (Main.Configuración.getBoolean("Utilidades.Permisos")) {
        if (Main.Configuración.getBoolean("Utilidades.Permisos_Mundos")) {
          if ((!p.hasPermission("sdub." + p.getWorld().getName() + ".bypass")) && 
            (!Main.TOGGLEAR.contains(p))) {
            e.setCancelled(true);
          }
        }
        else if ((!p.hasPermission("sdub.utilidades.bypass")) && 
          (!Main.TOGGLEAR.contains(p))) {
          e.setCancelled(true);
        }

      }
      else if (!Main.TOGGLEAR.contains(p))
        e.setCancelled(true);
  }
}