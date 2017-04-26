package helper;

/**
 * Created by Rp on 4/5/2016.
 */
public class Beanclassde {


    private int deimage;
    private String detitle;

    private String derupee;

    public Beanclassde(int deimage, String detitle, String derupee) {
        this.deimage = deimage;
        this.derupee = derupee;
        this.detitle = detitle;
    }

    public int getDeimage() {
        return deimage;
    }

    public void setDeimage(int deimage) {
        this.deimage = deimage;
    }

    public String getDerupee() {
        return derupee;
    }

    public void setDerupee(String derupee) {
        this.derupee = derupee;
    }

    public String getDetitle() {
        return detitle;
    }

    public void setDetitle(String detitle) {
        this.detitle = detitle;
    }
}
