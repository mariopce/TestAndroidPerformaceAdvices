package com.example.testapp.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.alg1);
        text2 = (TextView)findViewById(R.id.alg2);
        text3 = (TextView)findViewById(R.id.alg3);
        text4 = (TextView)findViewById(R.id.alg4);

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<User> generated = new ArrayList<User>();
        for (int i = 0; i < 1000; i++) {
            generated.add(User.generate());
        }
        warmup(generated);
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        l3 = alg3(generated, l3);
        l1 = alg1(generated, l1);
        l2 = alg2(generated, l2);

        text1.setText("alg1 " + (l1/1000));
        text2.setText("alg2 " + (l2/1000));
        text3.setText("alg3 " + (l3 / 1000));

    }

    private void warmup(List<User> generated) {
        for (int i = 0; i <  1000; i++) {
            resAlgor(new LoopAlgorithm3(generated));
            resAlgor(new LoopAlgorithm2(generated));
            resAlgor(new LoopAlgorithm1(generated));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static long alg3(List<User> generated, long l3) {
        for (int i = 0; i <  1000; i++) {
            long alg3 =  resAlgor(new LoopAlgorithm3(generated));



            l3 += alg3;
        }
        return l3;
    }

    private static long alg2(List<User> generated, long l2) {
        for (int i = 0; i <  1000; i++) {
            long alg2 =  resAlgor(new LoopAlgorithm2(generated));



            l2 += alg2;
        }
        return l2;
    }

    private static long alg1(List<User> generated, long l1) {
        for (int i = 0; i <  1000; i++) {

            long alg1 =  resAlgor(new LoopAlgorithm1(generated));

            l1 += alg1;

        }
        return l1;
    }

    private static long resAlgor(Runnable alg) {

        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            alg.run();
        }
        long stop = System.nanoTime()- start;
//        System.out.println("Time " + (stop));
        return stop;
    }

}
