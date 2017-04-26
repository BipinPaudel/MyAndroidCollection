package helper;

/**
 * Created by Rp on 4/5/2016.
 */
public class Beanclassmd {


    private int mdimage;
    private String mdtitle;
    private String mdrupee;

    public Beanclassmd(int mdimage,String mdtitle,String mdrupee) {
        this.mdimage = mdimage;
        this.mdtitle = mdtitle;
        this.mdrupee = mdrupee;
    }

    public int getMdimage() {
        return mdimage;
    }

    public void setMdimage(int mdimage) {
        this.mdimage = mdimage;
    }

    public String getMdrupee() {
        return mdrupee;
    }

    public void setMdrupee(String mdrupee) {
        this.mdrupee = mdrupee;
    }

    public String getMdtitle() {
        return mdtitle;
    }

    public void setMdtitle(String mdtitle) {
        this.mdtitle = mdtitle;
    }



}
