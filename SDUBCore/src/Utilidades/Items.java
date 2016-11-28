package Utilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import Core.Principal.Main;

public class Items {
	  
	// ITEMS USUARIOS
	@SuppressWarnings("deprecation")
	public static void ItemsUsuario(Player Jugador)
	  {
		Jugador.getInventory().clear();
	    Inventory Inventario = Jugador.getInventory();
	      
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


	    ItemStack LobbyItem = new ItemStack(Material.SKULL);
	    ItemMeta LobbyItemMeta = LobbyItem.getItemMeta();
	    ArrayList<String> LobbyLore = new ArrayList<>();
	    LobbyItemMeta.setDisplayName("§a● §6Mi perfil §a●");
	    LobbyLore.add("§7» §bVisualiza tu perfil.");
	    LobbyLore.add("");
	    LobbyLore.add("§7» §bObserva estadísticas y demás.");
	    LobbyLore.add("§bSolo dale al §eBotón Derecho§b.");
	    LobbyItemMeta.setLore(LobbyLore);
	    LobbyItem.setItemMeta(LobbyItemMeta);


	    ItemStack Visibilidad = new ItemStack(Material.REDSTONE_COMPARATOR);
	    ItemMeta VisibilidadMeta = Visibilidad.getItemMeta();
	    ArrayList<String> VisibilidadLore = new ArrayList<>();
	    VisibilidadMeta.setDisplayName("§a● §6Opciones §a●");
	    VisibilidadLore.add("§7» §bCambia la opciones del Lobby.");
	    VisibilidadLore.add("");
	    VisibilidadLore.add("§7» §bPersonaliza las opciones a tu gusto.");
	    VisibilidadLore.add("§bSolo dale al §eBotón Derecho §by y cambialas.");
	    VisibilidadLore.add("§bAlgunos menús requieren rango: §c§lEJEMPLO.");
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
	    	
			ItemStack Libro = new ItemStack(387,1);
	    	
	    	BookMeta im = (BookMeta) Libro.getItemMeta();
	    		im.setPages(Contenido);
	    		im.setAuthor("§a§lSurvivalDub");
	    		im.setTitle("§a● §6Reglas §a●");
	    		Libro.setItemMeta(im);
	    	


	    Inventario.setItem(0, EnderItem);
	    Inventario.setItem(1, LobbyItem);
	    Inventario.setItem(4, Libro);
	    Inventario.setItem(7, Visibilidad);
	    Inventario.setItem(8, GadgetsItem);
	  }
	  
	
	// ITEMS STAFF
		@SuppressWarnings("deprecation")
		public static void ItemsStaff(Player Jugador){
			Jugador.getInventory().clear();
		    Inventory Inventario = Jugador.getInventory();
		    
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


		    ItemStack LobbyItem = new ItemStack(Material.SKULL);
		    ItemMeta LobbyItemMeta = LobbyItem.getItemMeta();
		    ArrayList<String> LobbyLore = new ArrayList<>();
		    LobbyItemMeta.setDisplayName("§a● §6Mi perfil §a●");
		    LobbyLore.add("§7» §bVisualiza tu perfil.");
		    LobbyLore.add("");
		    LobbyLore.add("§7» §bObserva estadísticas y demás.");
		    LobbyLore.add("§bSolo dale al §eBotón Derecho§b.");
		    LobbyItemMeta.setLore(LobbyLore);
		    LobbyItem.setItemMeta(LobbyItemMeta);


		    ItemStack Visibilidad = new ItemStack(Material.REDSTONE_COMPARATOR);
		    ItemMeta VisibilidadMeta = Visibilidad.getItemMeta();
		    ArrayList<String> VisibilidadLore = new ArrayList<>();
		    VisibilidadMeta.setDisplayName("§a● §6Opciones §a●");
		    VisibilidadLore.add("§7» §bCambia la opciones del Lobby.");
		    VisibilidadLore.add("");
		    VisibilidadLore.add("§7» §bPersonaliza las opciones a tu gusto.");
		    VisibilidadLore.add("§bSolo dale al §eBotón Derecho §by y cambialas.");
		    VisibilidadLore.add("§bAlgunos menús requieren rango: §c§lEJEMPLO.");
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
		    	
				ItemStack Libro = new ItemStack(387,1);
		    	
		    	BookMeta im = (BookMeta) Libro.getItemMeta();
		    		im.setPages(Contenido);
		    		im.setAuthor("§a§lSurvivalDub");
		    		im.setTitle("§a● §6Reglas §a●");
		    		Libro.setItemMeta(im);
		    	

		    
	    ItemStack Opciones = new ItemStack(Material.WATCH);
	    ItemMeta OpcionesMeta = Opciones.getItemMeta();
	    ArrayList<String> OpcionesLore = new ArrayList<>();
	    OpcionesMeta.setDisplayName("§a● §cOpciones §a●");
	    OpcionesLore.add("§7» §bOpciones de uso exclusivo de Staff.");
	    OpcionesLore.add("");
	    OpcionesLore.add("§7» §bSelecciona una opción a la que más te guste.");
	    OpcionesLore.add("§bContacta con un Administrador para más ideas.");
	    OpcionesMeta.setLore(OpcionesLore);
	    Opciones.setItemMeta(OpcionesMeta);

	    ItemStack Herramientas = new ItemStack(Material.ENDER_CHEST);
	    ItemMeta HerramientasMeta = Herramientas.getItemMeta();
	    ArrayList<String> HerramientasLore = new ArrayList<>();
	    HerramientasMeta.setDisplayName("§a● §cHerramientas §a●");
	    HerramientasLore.add("§7» §bHerramientas de uso exclusivo para el Staff.");
	    HerramientasLore.add("");
	    HerramientasLore.add("§7» §bSelecciona una herramienta para mayor comodidad.");
	    HerramientasLore.add("§bContacta con un Administrador para más ideas.");
	    HerramientasMeta.setLore(HerramientasLore);
	    Herramientas.setItemMeta(HerramientasMeta);


	    
	    Inventario.setItem(0, EnderItem);
	    Inventario.setItem(1, LobbyItem);
	    Inventario.setItem(2, Opciones);
	    
	    Inventario.setItem(4, Libro);
	    
	    Inventario.setItem(6, Herramientas);
	    Inventario.setItem(7, Visibilidad);
	    Inventario.setItem(8, GadgetsItem);
	    }
		  
}