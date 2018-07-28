package com.jacksonnn.ChatCore.configuration;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    public static Config defaultConfig;
    public static Config languageConfig;

    public ConfigManager() {
        defaultConfig = new Config(new File("config.yml"));
        languageConfig = new Config(new File("language.yml"));
        configCheck(ConfigType.DEFAULT);
        configCheck(ConfigType.LANGUAGE);
    }

    public static void configCheck(ConfigType type) {
        if (type == ConfigType.LANGUAGE) {
            FileConfiguration lang;
            lang = languageConfig.get();

            lang.addDefault("Commands.noPermission", "You do not have sufficient permission to execute this command.");
            lang.addDefault("Commands.mustBePlayer", "This command must be executed by a player!");

            languageConfig.save();

        } else if (type == ConfigType.DEFAULT) {
            FileConfiguration config;
            config = defaultConfig.get();


            defaultConfig.save();
        }
    }
}
