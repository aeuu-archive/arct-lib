package io.arct.testplugin

import io.arct.arctlib.plugin.Plugin
import io.arct.testplugin.command.Configuration
import io.arct.testplugin.command.Gui
import io.arct.testplugin.command.Simple
import io.arct.testplugin.command.TabComplete

class TestPlugin : Plugin() {
    override fun commands() {
        super.commands()

        Configuration(this).register()
        Gui(this).register()
        Simple(this).register()
        TabComplete(this).register()
    }
}
