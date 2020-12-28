public class Skin {
    private String name;
    private String titleEN,titleAR;
    private String descriptionEN,descriptionAR;
    public Skin(String name,String titleEN, String titleAR, String descriptionEN, String descriptionAR) {
        this.name = name;
        this.titleEN = titleEN;
        this.titleAR = titleAR;
        this.descriptionEN = descriptionEN;
        this.descriptionAR = descriptionAR;
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
