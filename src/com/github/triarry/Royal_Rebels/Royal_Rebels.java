package com.github.triarry.Royal_Rebels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.triarry.Royal_Rebels.commands.InfoCommand;
import com.github.triarry.Royal_Rebels.listeners.PlayerListener;
import com.github.triarry.Royal_Rebels.utilities.Utilities;

public class Royal_Rebels extends JavaPlugin {
	
	public final PlayerListener playerListener = new PlayerListener(this);
	
    File configFile;
    FileConfiguration config;
    
    public static String ver = "";
    
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(this.playerListener, this);
		Utilities.getUtilities().startUp(this);
	    configFile = new File(getDataFolder(), "config.yml");
	    
	    try {
	        firstRun();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    config = new YamlConfiguration();
	    loadYamls();
	    
	    if (getConfig().getDouble("version") != 0.1) {
	    	this.getLogger().info("Your config is out of date. Regenerating...");
            configFile.setWritable(true);
            configFile.renameTo(new File(getDataFolder() + "/old-config.yml"));
	    	reConfig();
	    }
	    
	    getCommand("royal_rebels").setExecutor(new InfoCommand(this));
	    

	}
	
	private void firstRun() throws Exception {
	    if(!configFile.exists()){
	        configFile.getParentFile().mkdirs();
	        copy(getResource("config.yml"), configFile);
	    }
	}
	
	private void reConfig() {
        configFile.getParentFile().mkdirs();
        copy(getResource("config.yml"), configFile);
	}
	
    
	private void copy(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void saveYamls() {
	    try {
	        config.save(configFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadYamls() {
	    try {
	        config.load(configFile);
            this.getLogger().info("Succesfully loaded config.yml");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}