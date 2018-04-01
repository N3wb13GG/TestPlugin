package n3wb13.test.guis;

import n3wb13.core.managers.guis.MyGui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestGui extends MyGui {

    public TestGui() {
        Inventory inventory = Bukkit.createInventory(null, 9, "TestGui");

        inventory.setItem(0, new ItemStack(Material.GRASS));

        super.setInventory(inventory);
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage("Clicked TestGui");
        event.setCancelled(true);
    }

    @Override
    public void onInventoryClose(InventoryCloseEvent event) {
        event.getPlayer().sendMessage("Closed TestGui");
    }
}
