package ws.wolfsoft.test7;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RangeBar rangebar;
    Typeface fonts1;


    LinearLayout linear1,linear2, linear3, linear4, linear5, linear6, linear7, linear8;
    TextView ss, m, l, xl, xxl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fonts1 =  Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/MavenPro-Regular.ttf");

        Button t5 =(Button)findViewById(R.id.rang1);
        t5.setTypeface(fonts1);
        Button t6 =(Button)findViewById(R.id.rang2);
        t6.setTypeface(fonts1);





        ss = (TextView) findViewById(R.id.ss);
        m = (TextView) findViewById(R.id.m);
        l = (TextView) findViewById(R.id.l);
        xl = (TextView) findViewById(R.id.xl);
        xxl = (TextView) findViewById(R.id.xxl);

        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("S", "1");

            }
        });


        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("M", "2");

            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("L", "3");

            }
        });
        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("XL", "4");

            }
        });
        xxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                clickb("XXL", "5");

            }
        });




        rangebar = (RangeBar) findViewById(R.id.rangebar1);



        final Button leftIndexValue = (Button) findViewById(R.id.rang1);
        final Button rightIndexValue = (Button) findViewById(R.id.rang2);

        // Sets the display values of the indices
        rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex,
                                              String leftPinValue, String rightPinValue) {
                leftIndexValue.setText("$" + leftPinIndex);
                rightIndexValue.setText("$" + rightPinIndex);
            }

        });






//        ***********kids**********

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);


        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);

            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);



            }
        });

//        ***********man**********

        linear3 = (LinearLayout)findViewById(R.id.linear3);
        linear4 = (LinearLayout)findViewById(R.id.linear4);


        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.GONE);

            }
        });

        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);



            }
        });

//        ***********women**********

        linear5 = (LinearLayout)findViewById(R.id.linear5);
        linear6 = (LinearLayout)findViewById(R.id.linear6);


        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.VISIBLE);
                linear5.setVisibility(View.GONE);

            }
        });

        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.GONE);
                linear5.setVisibility(View.VISIBLE);



            }
        });

//        ***********all**********

        linear7 = (LinearLayout)findViewById(R.id.linear7);
        linear8 = (LinearLayout)findViewById(R.id.linear8);


        linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear8.setVisibility(View.VISIBLE);
                linear7.setVisibility(View.GONE);

            }
        });

        linear8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear8.setVisibility(View.GONE);
                linear7.setVisibility(View.VISIBLE);



            }
        });


    }



    private void clickb(String s , String t) {


        ss.setBackgroundResource(R.drawable.sizeround1);
        ss.setTextColor(Color.parseColor("#585858"));
        m.setBackgroundResource(R.drawable.sizeround1);
        m.setTextColor(Color.parseColor("#585858"));
        l.setBackgroundResource(R.drawable.sizeround1);
        l.setTextColor(Color.parseColor("#585858"));
        xl.setBackgroundResource(R.drawable.sizeround1);
        xl.setTextColor(Color.parseColor("#585858"));
        xxl.setBackgroundResource(R.drawable.sizeround1);
        xxl.setTextColor(Color.parseColor("#585858"));




        if(t.equalsIgnoreCase("1")) {
            ss.setBackgroundResource(R.drawable.sizeround2);
            ss.setTextColor(Color.parseColor("#ffffff"));


        }
        else if(t.equalsIgnoreCase("2")){
            m.setBackgroundResource(R.drawable.sizeround2);
            m.setTextColor(Color.parseColor("#ffffff"));


        }

        else if(t.equalsIgnoreCase("3")){
            l.setBackgroundResource(R.drawable.sizeround2);
            l.setTextColor(Color.parseColor("#ffffff"));



        }
        else if(t.equalsIgnoreCase("4")){
            xl.setBackgroundResource(R.drawable.sizeround2);
            xl.setTextColor(Color.parseColor("#ffffff"));



        }
        else if(t.equalsIgnoreCase("5")){
            xxl.setBackgroundResource(R.drawable.sizeround2);
            xxl.setTextColor(Color.parseColor("#ffffff"));



        }








    }
}
