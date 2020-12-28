public class Skin {
    private String name;


    private String URL;
    private String titleEN,titleAR;
    private String descriptionEN,descriptionAR;
    private String type,typeAR;

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

    public String getName() {
        return name;
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
