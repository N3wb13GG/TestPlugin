package n3wb13.test.items;

import n3wb13.core.Core;
import n3wb13.core.managers.guis.GuiManager;
import n3wb13.core.managers.items.MyItem;
import n3wb13.test.Main;
import n3wb13.test.guis.TestGui;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class TestItem extends MyItem {

    private final Material material = Material.APPLE;
    private final String displayName = ChatColor.GOLD + "Test Item";
    private final List<String> lore = Arrays.asList(ChatColor.DARK_GRAY + "This is Test Item!");

    public TestItem() {
        super(Main.getInstance(), "testitem");

        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        super.setItemStack(itemStack);
    }


    @Override
    public void onItemUse(PlayerInteractEvent event) {
        event.getPlayer().sendMessage("Used TestItem!");

        Core.getInstance().managers.getManager(Main.getInstance(), GuiManager.class).openMyGui(event.getPlayer(), new TestGui());
    }

    public void onDrop(PlayerDropItemEvent event) {
        event.getPlayer().sendMessage("Droped TestItem!");
    }

    public void onItemSpawn(ItemSpawnEvent event) {
        Bukkit.getServer().broadcastMessage("Droped TestItem!");
    }

    public void onInventoryClick(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage("Inventory Clicked TestItem!");
    }
}
