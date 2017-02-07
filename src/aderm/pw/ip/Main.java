package aderm.pw.ip;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	public void onEnable() {
		getCommand("ip").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if (c.getName().equalsIgnoreCase("ip")) {
			if (args.length == 0) {
				Player p = (Player) s;
				String IP = p.getAddress().toString().split("/")[(p.getAddress().toString().split("/").length - 1)].split(":")[0];
				p.sendMessage(col("&cIP: &7" + IP));
				return true;
			} else if (args.length == 1) {
				Player player = Bukkit.getPlayer(args[0]);
				if (s.hasPermission("ip.use")) {
					if (player == null) {
						s.sendMessage("&cPlayer not found.");
						return true;
					} else {
						String IP = player.getAddress().toString()
								.split("/")[(player.getAddress().toString().split("/").length - 1)].split(":")[0];
						s.sendMessage(col("&a" + player.getName() + "'s IP is: &7" + IP));
						return true;
					}
				}
			}
		}
		return false;
	}

	private String col(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}
