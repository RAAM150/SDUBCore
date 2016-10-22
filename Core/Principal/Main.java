package Core.Principal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import Eventos.Jugador.JugadorJoin;
import Eventos.Jugador.JugadorLeave;
import Scoreboard.Loop;
import Scoreboard.Marcador;


public class Main extends JavaPlugin
  implements Listener
{
  
  public static Main Plugin;
  
  public static File ConfiguraciónArchivo;
  public static FileConfiguration Configuración;
  
  public static File LibroArchivo;
  public static FileConfiguration Libro;
  
  public static File MensajesArchivo;
  public static FileConfiguration MensajesC;
  
  public static File MarcadorArchivo;
  public static FileConfiguration MarcadorC;
  
  public static PluginDescriptionFile PDF;
  public static HashSet<Player> TOGGLEAR = new HashSet<>();
  public static boolean AntiFlicker = true;
  
  public static String PREFIJO_CONSOLA = "§e[ §a§lSDUBCore §e] §f- §7";
  public static String PREFIJO_GENERAL = "§e● §a§lSDUBCore §e● §f- §7";

@Override
public void onEnable() {
        
	    Plugin = this;

        Bukkit.getServer().getConsoleSender().sendMessage("§3archivos cargados correctamente.");
	    CargarComandos();
	    PluginManager Eventos = getServer().getPluginManager();

	    // Paquete: Eventos
	    Eventos.registerEvents(new JugadorJoin(), Plugin);
	    Eventos.registerEvents(new JugadorLeave(), Plugin);
    
	    // Cargar configuraciones, leerlas y asignar nombres ".yml"
	    	ConfiguraciónArchivo = new File(getDataFolder(), "Configuración.yml");
	    	LibroArchivo = new File(getDataFolder(), "Libro.yml");
	    	MensajesArchivo = new File(getDataFolder(), "Mensajes.yml");
	    	MarcadorArchivo = new File(getDataFolder(), "Marcador.yml");
    	    
	        try {
	            firstRun();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        Configuración = new YamlConfiguration();
	        Libro = new YamlConfiguration();
	        MensajesC = new YamlConfiguration();
	        MarcadorC = new YamlConfiguration();
	        CargarArchivos();
	 
	        
	    }
	 
	    private void firstRun() throws Exception {
	        if(!ConfiguraciónArchivo.exists()){                      
	        	ConfiguraciónArchivo.getParentFile().mkdirs(); 
	        	Copiar(getResource("Configuración.yml"), ConfiguraciónArchivo); 
	        }
	        
	        if(!LibroArchivo.exists()){
	        	LibroArchivo.getParentFile().mkdirs();
	        	Copiar(getResource("Libro.yml"), LibroArchivo);
	        }	        
	        
	        if(!MensajesArchivo.exists()){
	        	MensajesArchivo.getParentFile().mkdirs();
	        	Copiar(getResource("Mensajes.yml"), MensajesArchivo);
	        }	
	        
	        if(!MarcadorArchivo.exists()){
	        	MarcadorArchivo.getParentFile().mkdirs();
	        	Copiar(getResource("Marcador.yml"), MarcadorArchivo);
	        	

	        }
	  }
	 

	    private void Copiar(InputStream in, File file) {
	        try {
	            OutputStream out = new FileOutputStream(file);
	            byte[] buf = new byte[1024];
	            int len;
	            while((len=in.read(buf))>0){
	                out.write(buf,0,len);

	            }
	            out.close();
	            in.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 

	    public void CargarArchivos() {
	        try {
	        	Configuración.load(ConfiguraciónArchivo); 
	        	Libro.load(LibroArchivo); 
	        	MensajesC.load(MensajesArchivo); 
	        	MarcadorC.load(MarcadorArchivo); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    @SuppressWarnings("deprecation")
		public void GuardarArchivos()  {
	        try {
	        	Configuración.save(ConfiguraciónArchivo);
	        	Libro.save(LibroArchivo);
	        	MensajesC.save(MensajesArchivo); 
	        	MarcadorC.save(MarcadorArchivo); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    
	    for (Player p : Bukkit.getOnlinePlayers())
	    {
	      Marcador.Scores.put(p, Marcador.Manager.getNewScoreboard());
	      p.setScoreboard((Scoreboard)Marcador.Scores.get(p));
	      Marcador.NoDisplay.add(p);
	    }

	    new Loop();
	  }
	    
	    
@Override
public void onDisable() {
}

public void CargarComandos() {
  //getCommand("ausente").setExecutor(new ComandoAusente(this));
}

  //Teletransportar a servidores...
public void TeletransportarServidor(final Player Jugador, final String Servidor) {
    final Main plugin = this;
    Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {
        @Override
        public void run() {

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            getLogger().info(Jugador.getName() + " -> " + Servidor);
            try {
                out.writeUTF("Connect");
                out.writeUTF(Servidor);
            } catch (IOException dummy) {
            }
            Jugador.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());

        }
    });

}

  // Leer configuraciones para Colorizar textos...

  public static MemorySection getLibro() {
      return Libro;
    }
  public static MemorySection getMensajes() {
      return MensajesC;
    }
  public static MemorySection getMarcador() {
      return MarcadorC;
    }
  public static MemorySection getConfiguración() {
      return Configuración;
    }
  
  // Reemplazar caracteres de: "Libro.yml"
  public static List<String> LIBRO(String patch)
  {
    if (getLibro().getStringList(patch) == null) {
    	Bukkit.getServer().getConsoleSender().sendMessage("§c" + patch + " §7no existe en el archivo: §eLibro.yml");
    }
    return getLibro().getStringList(patch);
  }
  
  // Reemplazar caracteres de: "Mensajes.yml"
  public static String MSG(String patch)
  {
    if (getMensajes().getString(patch) == null) {
    	Bukkit.getServer().getConsoleSender().sendMessage("§c" + patch + " §7no existe en el archivo: §eMensajes.yml");
    }
    return getMensajes().getString(patch).replaceAll("&", "§")
      .replaceAll("[*]", "●");
  }
  
  // Reemplazar caracteres de: "Marcador.yml"
  public static List<String> SBOARD(String patch)
  {
    if (getMarcador().getStringList(patch) == null) {
    	Bukkit.getServer().getConsoleSender().sendMessage("§c" + patch + " §7no existe en el archivo: §eMarcador.yml");
    }
    return getMarcador().getStringList(patch);
  }

  // Reemplazar caracteres de: "Configuración.yml"
  public static String CONFIG(String patch)
  {
    if (getConfiguración().getString(patch) == null) {
    	Bukkit.getServer().getConsoleSender().sendMessage("§c" + patch + " §7no existe en el archivo: §eConfiguración.yml");
    }
    return getConfiguración().getString(patch).replaceAll("&", "§")
      .replaceAll("[*]", "●");
  }
}