package com.alexxx6.Threeout;
 
import static com.alexxx6.Threeout.titles.plugin;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Set;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main extends JavaPlugin
  implements Listener
{
    
        
        private ArrayList<StatusSign> signs;  
        public static Main plugin;

       
        @Override
        public void onEnable() {


            plugin = this;
            
            this.signs = new ArrayList<StatusSign>();
                
                saveDefaultConfig();
                for (String str : getConfig().getKeys(false)) {
                        ConfigurationSection s = getConfig().getConfigurationSection(str);
                       
                        ConfigurationSection l = s.getConfigurationSection("loc");
                        World w = Bukkit.getServer().getWorld(l.getString("world"));
                        double x = l.getDouble("x"), y = l.getDouble("y"), z = l.getDouble("z");
                        Location loc = new Location(w, x, y, z);
                       
                        if (loc.getBlock() == null) {
                                getConfig().set(str, null);
                        } else {
                                signs.add(new StatusSign(loc, s.getString("name"), s.getString("ip"), s.getInt("port")));
                        }
                }
               
                Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
                    for (StatusSign s : signs) {
                        s.update();
                    }
                }, 0, 20);
               
                Bukkit.getServer().getPluginManager().registerEvents(this, this);
                Bukkit.getServer().getPluginManager().registerEvents(new titles(this), this);
                Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        }
        
        @Override
        public void onDisable(){
                System.out.println("[YOUTUBE] Das Plugin wurde Deaktiviert!");
        }
      
       
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent e) {
                if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
               
                Block block = e.getClickedBlock();
               
                if (block.getType() != Material.SIGN && block.getType() != Material.SIGN_POST && block.getType() != Material.WALL_SIGN) return;
               
                for (StatusSign s : signs) {
                        if (s.getLocation().equals(block.getLocation())) {
                                try {
                                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                                        DataOutputStream out = new DataOutputStream(b);
 
                                        out.writeUTF("Connect");
                                        out.writeUTF(s.getName());
                                       
                                        e.getPlayer().sendPluginMessage(this, "BungeeCord", b.toByteArray());
                                } catch (Exception ex) {
                                }
                        }
                }
        }
       
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
                if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "Only players can create status signs.");
                        return true;
                }
               
                Player p = (Player) sender;
               
                if (cmd.getName().equalsIgnoreCase("statussigns")) {
                        if (args.length < 3) {
                                p.sendMessage(ChatColor.RED + "/statussigns <ip> <port> <name>");
                                return true;
                        }
                       
                        String ip = args[0];
                        int port;
                        String name = args[2];
                       
                        try {
                                port = Integer.valueOf(args[1]);
                        } catch (Exception e) {
                                p.sendMessage(ChatColor.RED + "Port is not a number.");
                                return true;
                        }
                       
                        Block block = p.getTargetBlock((Set)null, 10);
                        if (block == null) {
                                p.sendMessage(ChatColor.RED + "You are not looking at a sign!");
                                return true;
                        }
                       
                        if (block.getType() != Material.SIGN && block.getType() != Material.SIGN_POST && block.getType() != Material.WALL_SIGN) {
                                p.sendMessage(ChatColor.RED + "You are not looking at a sign!");
                                return true;
                        }
                       
                        StatusSign statusSign = new StatusSign(block.getLocation(), name, ip, port);
                        signs.add(statusSign);
                        save(statusSign);
                }
               
                return true;
        }
       
        private void save(StatusSign sign) {
                int size = getConfig().getKeys(false).size() + 1;
               
                getConfig().set(size + ".loc.world", sign.getLocation().getWorld().getName());
                getConfig().set(size + ".loc.x", sign.getLocation().getX());
                getConfig().set(size + ".loc.y", sign.getLocation().getY());
                getConfig().set(size + ".loc.z", sign.getLocation().getZ());
               
                getConfig().set(size + ".name", sign.getName());
                getConfig().set(size + ".ip", sign.getIP());
                getConfig().set(size + ".port", sign.getPort());
               
                saveConfig():


} 




STATUSSIGN

package com.alexxx6.Threeout;
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
 
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
 
public class StatusSign {
 
        private Location location;
        private Sign sign;
        private String name, ip;
        private int port;
       
        public StatusSign(Location location, String name, String ip, int port) {
                this.location = location;
                this.sign = (Sign) location.getBlock().getState();
                this.name = name;
                this.ip = ip;
                this.port = port;
        }



       
        public Location getLocation() {
                return location;
        }
       
        public String getName() {
                return name;
        }
       
        public String getIP() {
                return ip;
        }
       
        public int getPort() {
                return port;
        }
       
        public void update() {
                try (Socket socket = new Socket()) {
                        socket.connect(new InetSocketAddress(ip, port), 1 * 1000);
                       
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                       
                        out.write(0xFE);
                       
                        StringBuilder str = new StringBuilder();
                       
                        int b;
                        while ((b = in.read()) != -1) {
                                if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
                                        str.append((char) b);
                                }
                        }
                       
                        /*
                        <Name>
                        <IP>
                        <Current/Max>
                        <MOTD>
                         */
                       
                        String[] data = str.toString().split("§");
                        String motd = data[0];
                        int onlinePlayers = Integer.valueOf(data[1]);
                        int maxPlayers = Integer.valueOf(data[2]);
                       
                        sign.setLine(0, name);
                        sign.setLine(1, ip);
                        sign.setLine(2, onlinePlayers + "/" + maxPlayers);
                        sign.setLine(3, motd);
                       
                } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
                       
                        sign.setLine(0, name);
                        sign.setLine(1, ip);
                        sign.setLine(2, ChatColor.RED + "Error.");
                }
               
                sign.update();
        }
}



TITLES

package com.alexxx6.Threeout;
 
import java.util.ArrayList;
import java.util.HashMap;
 
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayOutCamera;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
 
import com.connorlinfoot.titleapi.TitleAPI;
 
public class titles implements Listener {
    
 
        public static Plugin plugin;
       
        public titles (Plugin plugin){
                titles.plugin = plugin;
        }
       
 
        @EventHandler
        public void onJoin(PlayerJoinEvent event){
                Player player = (Player)event.getPlayer();
               
                TitleAPI.sendTitle(player, 25, 25, 25, "&eBienvenido", "&7"+player.getName());
        }
        
}


PLUGIN.YML


name: Threeout
author: alexxx6
version: 1.1
main: com.alexxx6.Threeout.Main
descripcion: Plugin Threeout


CONFIG.YML

1:
   loc:
    world:
    x:
    y:
    z:
   name: 
   ip:
   port:

