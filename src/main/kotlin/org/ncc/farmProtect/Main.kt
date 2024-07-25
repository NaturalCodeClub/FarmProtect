package org.ncc.farmProtect

import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Ageable
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import kotlin.math.log

class Main : JavaPlugin(), Listener {
    override fun onEnable() {
        logger.info("Config File Loaded")
        Bukkit.getPluginManager().registerEvents(this, this)
        logger.info("Event registered")
    }

    override fun onDisable() {
        logger.info("Disabled")
    }


    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onBreakFarmlandEntity(event: EntityInteractEvent) {
        if (event.block.type != Material.FARMLAND) return
        if (event.entityType != EntityType.PLAYER) {
            event.isCancelled = true
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onBreakFarmlandPlayer(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL) return
        if (event.clickedBlock?.type == Material.FARMLAND) {
            event.isCancelled = true
        }
    }
}



