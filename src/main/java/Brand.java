import java.util.HashMap;
import java.util.Map;

public class Brand {
    private static final Map<String,String> namesEN = new HashMap<>(){{
        put("iphone", "Apple");
        put("realme", "Oppo");
        put("htc", "HTC");

        put("honor", "Honor");
        put("nokia", "Nokia");
        put("oppo", "Oppo");
        put("oneplus", "OnePlus");
        put("samsung", "Samsung");
        put("vivo", "Vivo");
        put("xiaomi", "Xiaomi");
        put("google", "Google");
        put("infinix", "Infinix");
        put("motorola", "Motorola");
        put("huawei", "Huawei");
    }};
    private static final Map<String,String> namesAR = new HashMap<>(){{
        put("iphone", "ابل");
        put("realme", "اوبو");
        put("htc", "اتش تي سي");

        put("honor", "اونور");
        put("nokia", "نوكيا");
        put("oppo", "اوبو");
        put("oneplus", "وان بلس");
        put("samsung", "سامسونج");
        put("vivo", "فيفو");
        put("xiaomi", "شاومي");
        put("google", "جوجل");
        put("infinix", "انفينكنس");
        put("motorola", "موتورولا");
        put("huawei", "هواوي");
    }};
    String name;
    String brandName, brandNameAR;

    Brand(String name) throws Exception {
        this.name = name;
        brandName = namesEN.getOrDefault(name,null);
        brandNameAR = namesAR.getOrDefault(name,null);

        if(brandName == null || brandNameAR == null)
            throw new Exception("Error this brand " + name + " does not exist");
    }

    public String getBrandName() {
        return brandName;
    }

    public String getBrandNameAR() {
        return brandNameAR;
    }
}