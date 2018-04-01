package n3wb13.test.listeners;

import n3wb13.core.managers.listeners.IMyListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestListener implements Listener, IMyListener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Test Listener : JoinEvent");
    }
}
