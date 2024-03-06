package net.projecttl.plugin.example

import net.projecttl.plugin.example.listeners.JoinListener
import org.bukkit.plugin.java.JavaPlugin

lateinit var instance: CorePlugin

class CorePlugin : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(JoinListener(), this)
    }

    override fun onDisable() {}
}