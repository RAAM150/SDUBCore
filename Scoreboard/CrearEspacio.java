package Scoreboard;

import java.util.Random;

public class CrearEspacio
{
  public static String crearEspacio()
  {
    String build = "";

    for (int i = 0; i < 15; i++)
    {
      build = agregar(build);
    }

    return build;
  }

  private static String agregar(String build)
  {
    Random random = new Random();

    int r = random.nextInt(7) + 1;

    build = build + org.bukkit.ChatColor.values()[r];

    return build;
  }
}