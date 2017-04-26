package wolfsoft.fordprofile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ExpandableHeightGridView gridview;

    // Put your images from draweble folder

    private int[] Image = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
    private ArrayList<Beanclass> beans;
    private GridviewAdapter gridviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context;
        Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(),
                R.drawable.pro2);

        ImageView imgv = (ImageView) findViewById(R.id.banar1);

      //  Bitmap bitmap = StringToBitMap(imgv);
        Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setAntiAlias(true);
        Canvas c = new Canvas(circleBitmap);
        c.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);

        imgv.setImageBitmap(circleBitmap);

       /* ImageView imgv = (ImageView) findViewById(R.id.banar1);
        imgv.setImageBitmap(StringToBitMap(immg));
        */

        gridview = (ExpandableHeightGridView)findViewById(R.id.gridview);
        beans= new ArrayList<Beanclass>();

        for (int i= 0; i< Image.length; i++) {

            Beanclass beanclass = new Beanclass(Image[i]);
            beans.add(beanclass);

        }
        gridviewAdapter = new GridviewAdapter(MainActivity.this, beans);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);



    }


}
