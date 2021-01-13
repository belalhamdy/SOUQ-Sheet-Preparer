import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public final class CloudinaryConfigs {
    private static final List<Map> configs = new ArrayList<>() {{
        /*
        For Skins data
         */
        add(generateConfig("ozoskins", "927622871781775", "i7PmM4-w6dzIvyAEQoDvtTdZwQ4"));
        add(generateConfig("ozoskins2", "358333887259691", "4KTsWlPVHQpYb-WYhwqCkgdvnbk"));
        //-----------------------------------
        add(generateConfig("belalhamdy", "222965862679467", "4Umi23WOzm72bAMMJxPYac2rBZk"));
        add(generateConfig("ozoskins1", "373114824266665", "xpHOGT7bOj-v3kI0tqgWM1x6MZc"));

    }};
    private static Map generateConfig(String cloud_name, String api_key,String api_secret ){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name", cloud_name);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        return config;
    }

    public static Map getConfig() throws Exception {
        if(Main.currCloudinaryConfig >= configs.size()) throw new Exception("Configs limit exceeded");
        return configs.get(Main.currCloudinaryConfig);
    }
}
