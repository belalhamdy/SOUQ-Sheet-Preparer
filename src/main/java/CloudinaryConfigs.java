import com.cloudinary.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public final class CloudinaryConfigs {
    static final List<Map> configs = new ArrayList<>() {{
        add(generateConfig("belalhamdy", "222965862679467", "4Umi23WOzm72bAMMJxPYac2rBZk"));
    }};
    static int currConfig = 0;
    private static Map generateConfig(String cloud_name, String api_key,String api_secret ){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name", cloud_name);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        return config;
    }
    public static Map getConfig() throws Exception {
        if(currConfig >= configs.size()) throw new Exception("Configs limit exceeded");
        return configs.get(currConfig++);
    }
}
