package n3wb13.test.commands.test.subcommands;

import n3wb13.core.Core;
import n3wb13.core.managers.items.ItemManager;
import n3wb13.test.Main;
import n3wb13.test.commands.test.TestCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GetSubCommand extends TestCommand {

    public GetSubCommand() {
        this.setName("get");
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {
        if (args.length >= 2 && Core.getInstance().managers.getManager(Main.getInstance(), ItemManager.class).getMyItems().containsKey(args[1].toLowerCase()))
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.getInventory().addItem(Core.getInstance().managers.getManager(Main.getInstance(), ItemManager.class).getMyItem(args[1].toLowerCase()).getItemStack());
            }

        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        if (args.length <= 1)
            return new ArrayList<>(Core.getInstance().managers.getManager(Main.getInstance(), ItemManager.class).getMyItems().keySet());
        return new ArrayList<>();
    }
}
