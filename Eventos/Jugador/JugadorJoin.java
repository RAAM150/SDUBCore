package Eventos.Jugador;

import java.util.ArrayList;
import java.util.List;

import Core.Principal.Main;
import Scoreboard.Marcador;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class JugadorJoin
  implements Listener
{
  Main plugin;

  @EventHandler(priority=EventPriority.HIGHEST)
  public void EntrarAlServidor(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Inventory Inventario = p.getInventory();
    	
// MOTD AL ENTRAR AL SERVIDOR.
    	p.sendMessage("§6» §7Plugin Core: §c§lBETA§7. Creador de Plugins: §aRAAM150§7.");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("§7§m-----------------------------------------------------");
        p.sendMessage("                            §2● §a§lSurvivalDub §2●");
        p.sendMessage("                 §b¡Bienvenido al servidor de SurvivalDub!");
        p.sendMessage("");
        p.sendMessage("§8► §3§lTWITTER: §a@----");
        p.sendMessage("§8► §c§LFORO: §a----");
        p.sendMessage("§8► §2§lTIENDA: §a----");
        p.sendMessage("§7§m-----------------------------------------------------");
        
///////////  PONER MARCADOR
        
        Marcador.Scores.put(e.getPlayer(), Marcador.Manager.getNewScoreboard());
        Marcador.NoDisplay.add(e.getPlayer());
        Marcador.setBoardToPlayer(e.getPlayer());

///////////  MENSAJE DE ENTRADA Y EVENTOS JUGADOR 


    p.setHealth(20.0D);
    p.setFoodLevel(20);
    p.setFireTicks(0);
    p.setSaturation(20.0F);
    

// MENSAJES PARA JUGADORES CON PERMISOS    
    e.setJoinMessage(null);    
    if (p.hasPermission("sdub.rango.vip")) {
        Bukkit.broadcastMessage("§b§lExample " + p.getDisplayName() + " §6Ha §nentrado§6 al servidor.");
    }
    else if (p.hasPermission("sdub.rango.creador")) {
        
       Bukkit.broadcastMessage("§4§lEL DIOS " + p.getDisplayName() + " §6Ha §nentrado§6 al servidor.");
       World world = p.getWorld();
       for (int i = 0; i <= 1; i++) {
       world.strikeLightningEffect(p.getLocation());

       Firework f = (Firework)p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), Firework.class);
       FireworkMeta fm = f.getFireworkMeta();
       fm.addEffect(FireworkEffect.builder()
                      .flicker(true).trail(true)
                      .with(FireworkEffect.Type.STAR).with(FireworkEffect.Type.BALL_LARGE).with(FireworkEffect.Type.BURST)
                      .withColor(Color.PURPLE)
                      .withColor(Color.RED).build());
                      fm.setPower(0);
                      f.setFireworkMeta(fm);
         }
  
///////////  ITEMS JOIN (JUGADOR COMÚN)
    
    ItemStack GadgetsItem = new ItemStack(Material.CHEST);
    ItemMeta GadgetsItemMeta = GadgetsItem.getItemMeta();
    ArrayList<String> GadgetsLore = new ArrayList<>();
    GadgetsItemMeta.setDisplayName("§a● §6Menú de Vanity §a●");
    GadgetsLore.add("§7» §bCambia el estilo de tu personaje.");
    GadgetsLore.add("");
    GadgetsLore.add("§7» §bSelecciona: Partículas, Gadgets, Armario, Música.");
    GadgetsLore.add("§bAlgunos menús requieren rango: §c§lEJEMPLO.");
    GadgetsItemMeta.setLore(GadgetsLore);
    GadgetsItem.setItemMeta(GadgetsItemMeta);


    ItemStack EnderItem = new ItemStack(Material.COMPASS);
    ItemMeta EnderItemMeta = EnderItem.getItemMeta();
    ArrayList<String> EnderLore = new ArrayList<>();
    EnderItemMeta.setDisplayName("§a● §6Modo de Juegos §a●");
    EnderLore.add("§7» §bEntra a los distintos modos de juegos.");
    EnderLore.add("");
    EnderLore.add("§7» §bPuedes encontrar una gran variedad.");
    EnderLore.add("§bSolo dale al §eBotón Derecho §by selecciona uno.");
    EnderItemMeta.setLore(EnderLore);
    EnderItem.setItemMeta(EnderItemMeta);


    ItemStack LobbyItem = new ItemStack(Material.WATCH);
    ItemMeta LobbyItemMeta = LobbyItem.getItemMeta();
    ArrayList<String> LobbyLore = new ArrayList<>();
    LobbyItemMeta.setDisplayName("§a● §6Lobbies §a●");
    LobbyLore.add("§7» §bCambiate de Lobby.");
    LobbyLore.add("");
    LobbyLore.add("§7» §bPuedes elegir cambiarte de Lobby.");
    LobbyLore.add("§bSolo dale al §eBotón Derecho §by selecciona uno.");
    LobbyItemMeta.setLore(LobbyLore);
    LobbyItem.setItemMeta(LobbyItemMeta);


    ItemStack Visibilidad = new ItemStack(Material.INK_SACK, 1, (short)10);
    ItemMeta VisibilidadMeta = Visibilidad.getItemMeta();
    ArrayList<String> VisibilidadLore = new ArrayList<>();
    VisibilidadMeta.setDisplayName("§a● §6Visibilidad: §2ON §a●");
    VisibilidadLore.add("§7» §bCambia la visibilidad.");
    VisibilidadLore.add("");
    VisibilidadLore.add("§7» §bPuedes desactivar o activar tu visibilidad.");
    VisibilidadLore.add("§bSolo dale al §eBotón Derecho §by y cambiala.");
    VisibilidadMeta.setLore(VisibilidadLore);
    Visibilidad.setItemMeta(VisibilidadMeta);



    	List<String> Páginas = Main.LIBRO("Contenido_Libro");
    	List<String> Contenido = new ArrayList<String>();
    	List<String> Página = new ArrayList<String>();
    	for(String Línea : Páginas)  {
    		Línea = Línea.replace("<espacio>", ChatColor.RESET + "\n");
    		Línea = ChatColor.translateAlternateColorCodes('&', Línea);
    		if(!Línea.contains("<nueva_pagina>")) {
    			Página.add(Línea + "\n");
    		} else {
    			String pagestr = "";
    			for(String l : Página)
    				pagestr = pagestr + l;
    			Contenido.add(pagestr);
    			Página.clear();
    		}
    	}
    	
    	String pagestr = "";
    	for(String l : Página)
    		pagestr = pagestr + l;
    	Contenido.add(pagestr);	
    	Página.clear();
    	
    	@SuppressWarnings("deprecation")
		ItemStack Libro = new ItemStack(387,1);
    	
    	BookMeta im = (BookMeta) Libro.getItemMeta();
    		im.setPages(Contenido);
    		im.setAuthor("§a§lWarCraft");
    		im.setTitle("§a● §6Reglas §a●");
    		Libro.setItemMeta(im);
    	


    Inventario.setItem(0, EnderItem);
    Inventario.setItem(1, Visibilidad);
    Inventario.setItem(7, Libro);
    Inventario.setItem(8, GadgetsItem);

    
    // ITEMS PARA EL STAFF O PARA JUGADORES CON PERMISO.

    if ((p.hasPermission("sdub.rango.moderator")))
    {   
       p.getInventory().clear();



    ItemStack Opciones = new ItemStack(Material.WATCH);
    ItemMeta OpcionesMeta = Opciones.getItemMeta();
    ArrayList<String> OpcionesLore = new ArrayList<>();
    OpcionesMeta.setDisplayName("§a● §6Opciones §a●");
    OpcionesLore.add("§7» §bOpciones de uso exclusivo de Staff.");
    OpcionesLore.add("");
    OpcionesLore.add("§7» §bSelecciona una opción a la que más te guste.");
    OpcionesLore.add("§bContacta con un Administrador para más ideas.");
    OpcionesMeta.setLore(OpcionesLore);
    Opciones.setItemMeta(OpcionesMeta);

    ItemStack Herramientas = new ItemStack(Material.ENDER_CHEST);
    ItemMeta HerramientasMeta = Herramientas.getItemMeta();
    ArrayList<String> HerramientasLore = new ArrayList<>();
    HerramientasMeta.setDisplayName("§a● §6Herramientas §a●");
    HerramientasLore.add("§7» §bHerramientas de uso exclusivo para el Staff.");
    HerramientasLore.add("");
    HerramientasLore.add("§7» §bSelecciona una herramienta para mayor comodidad.");
    HerramientasLore.add("§bContacta con un Administrador para más ideas.");
    HerramientasMeta.setLore(HerramientasLore);
    Herramientas.setItemMeta(HerramientasMeta);



    Inventario.setItem(0, EnderItem);
    Inventario.setItem(1, Visibilidad);
    Inventario.setItem(2, Opciones);

    Inventario.setItem(6, Herramientas);
    Inventario.setItem(7, Libro);
    Inventario.setItem(8, GadgetsItem);
    	
   }
  }
 }
}