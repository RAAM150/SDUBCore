package Scoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import Core.Principal.Main;

public class Marcador {

	public static ScoreboardManager Manager = Bukkit.getScoreboardManager();
	public static ArrayList<Player> NoDisplay = new ArrayList<Player>();
	public static HashMap<Player, Scoreboard> Scores = new HashMap<Player, Scoreboard>();
	public static HashMap<Player, ObjectiveContainer> Objetivos = new HashMap<Player, ObjectiveContainer>();
	
	public static void setBoardToPlayer(Player p)
	{
		
		if(!NoDisplay.contains(p)) return;
		Scoreboard board = Scores.get(p);

		ArrayList<String> objc = new ArrayList<String>();

	    int r = new Random().nextInt(5999);
	    int r2 = new Random().nextInt(5999);
	    r = 1; r2 = 1;

	    for (Objective unreg : board.getObjectives())
	    {
	      unreg.unregister();
	    }

		Objective obj = board.registerNewObjective("sb" + r , r2 + "");
		int maxchars = Integer.parseInt(Main.MarcadorC.getString("Caracteristicas.Caracteres_Maximos"));
		

		
		if(obj.getDisplaySlot() != DisplaySlot.SIDEBAR)
		{
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			obj.setDisplayName("Marcador.Titulo");
		}
		
		int length = Main.SBOARD("Marcador.Scores").size();
		
		try{
			
			for(String s : Main.SBOARD("Marcador.Scores"))
			{
				if(s.trim().equals("SPACER") || s.trim().isEmpty())
				{
					String spacer = CrearEspacio.crearEspacio();
					if(spacer.length() > maxchars)
					{
						Score score = obj.getScore(spacer.substring(0, maxchars));
						score.setScore(length);
					} else {
						Score score = obj.getScore(spacer);
						score.setScore(length);
					}
					
					length = length - 1;
				}
			}
			
			boolean update = true;
			
			if(!Loop.force){
				
			if(Main.AntiFlicker == true)
			{
				if(Objetivos.containsKey(p))
				{
					ObjectiveContainer last = Objetivos.get(p);
					
					
					
					for(String s : last.scores)
					{
						if(!objc.contains(s))
						{
							if(last != null)
							{
								if(p.getScoreboard() != null)
								{
									update = false;
								}
							}
						} else {
						}
					}
					
					
					Objetivos.remove(p);
					Objetivos.put(p, new ObjectiveContainer(objc));
					
				} else {
					Objetivos.put(p, new ObjectiveContainer(objc));
				}
			}
			
			}
			Loop.force = false;
			
			if(!update){
				p.setScoreboard(board);
			}
			
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}