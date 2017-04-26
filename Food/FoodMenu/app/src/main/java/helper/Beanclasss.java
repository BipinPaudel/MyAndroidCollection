package helper;

/**
 * Created by Rp on 4/5/2016.
 */
public class Beanclasss {


    private int simage;
    private String stitle;
    private String srupee;

    public Beanclasss(int simage, String stitle, String srupee) {
        this.simage = simage;
        this.stitle = stitle;
        this.srupee = srupee;
    }


    public int getSimage() {
        return simage;
    }

    public void setSimage(int simage) {
        this.simage = simage;
    }

    public String getSrupee() {
        return srupee;
    }

    public void setSrupee(String srupee) {
        this.srupee = srupee;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }
}
