package net.projecttl.plugin.example.listeners

import net.kyori.adventure.text.Component
import net.projecttl.plugin.example.PlayerChacheData
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinListener : Listener {
    @EventHandler
    fun joinMessage(event: PlayerJoinEvent) {
        event.joinMessage(Component.text("Wilkommen Auf Azadun! ${event.player.name}"))
    }
    @EventHandler
    fun getPlayerInChache(event: PlayerJoinEvent) {
        val player = event.player
        PlayerChacheData.addPlayerToList(player.uniqueId.toString())
    }
}