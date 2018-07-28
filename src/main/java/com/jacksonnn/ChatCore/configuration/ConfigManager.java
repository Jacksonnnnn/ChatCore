package com.jacksonnn.ChatCore.configuration;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    public static Config defaultConfig;
    public static Config languageConfig;
    public static Config bannedWords;

    public ConfigManager() {
        defaultConfig = new Config(new File("config.yml"));
        languageConfig = new Config(new File("language.yml"));
        bannedWords = new Config(new File("bannedWords.yml"));
        configCheck(ConfigType.ANTICURSE);
        configCheck(ConfigType.DEFAULT);
        configCheck(ConfigType.LANGUAGE);
    }

    public static void configCheck(ConfigType type) {
        FileConfiguration config;
        if (type == ConfigType.LANGUAGE) {
            config = languageConfig.get();

            config.addDefault("Commands.noPermission", "You do not have sufficient permission to execute this command.");
            config.addDefault("Commands.mustBePlayer", "This command must be executed by a player!");

            languageConfig.save();

        } else if (type == ConfigType.DEFAULT) {
            config = defaultConfig.get();


            defaultConfig.save();
        } else if (type == ConfigType.ANTICURSE) {
            config = bannedWords.get();

            ArrayList<String> bannedWordsList = new ArrayList<>();

            bannedWordsList.add("bitch");
            bannedWordsList.add("fuck");
            bannedWordsList.add("shit");

            config.addDefault("AntiCurse.bannedWords", bannedWordsList);
            bannedWords.save();
        }
    }
}
