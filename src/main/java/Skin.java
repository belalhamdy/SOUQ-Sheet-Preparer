public class Skin {
    private final String name;


    private final String URL;
    private final String titleEN;
    private final String titleAR;
    private final String descriptionEN;
    private final String descriptionAR;
    private final String type;
    private final String typeAR;

    public String getType() {
        return type;
    }

    public String getTypeAR() {
        return typeAR;
    }

    public String getURL() {
        return URL;
    }
    public Skin(String name, String titleEN, String titleAR, String descriptionEN, String descriptionAR,String URL) {
        this.name = name;
        this.titleEN = titleEN;
        this.titleAR = titleAR;
        this.descriptionEN = descriptionEN;
        this.descriptionAR = descriptionAR;
        this.URL = URL;
        this.type = "Mobile Phone Skins";
        this.typeAR = "ملصقات و اغطية حماية للهواتف المحمولة";
    }

    public String getTitleEN() {
        return titleEN;
    }

    public String getTitleAR() {
        return titleAR;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getDescriptionAR() {
        return descriptionAR;
    }

    @Override
    public String toString() {
        return "Skin{" +
                "name='" + name + '\'' +
                ", titleEN='" + titleEN + '\'' +
                ", titleAR='" + titleAR + '\'' +
                ", descriptionEN='" + descriptionEN + '\'' +
                ", descriptionAR='" + descriptionAR + '\'' +
                '}';
    }
}
