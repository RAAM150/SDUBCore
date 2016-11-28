package Utilidades;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

public class Tabulador
  implements Listener
{
  @EventHandler
  public void Tab(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    if (isPlayerRightVersion(p))
    {
      PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
      IChatBaseComponent header = ChatSerializer.a("{'text': '§e● §a§lSurvivalDub §e● §7» §6mc.survivaldub.com'}");
      IChatBaseComponent footer = ChatSerializer.a("{'text': '§c§lTienda: §bwww.survivaldub.com/tienda'}");
      connection.sendPacket(new ProtocolInjector.PacketTabHeader(header, footer));
    }
  }

  public boolean isPlayerRightVersion(Player player)
  {
    return ((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() >= 47;
  }
}