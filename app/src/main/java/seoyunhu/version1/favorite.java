package seoyunhu.version1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class favorite extends ActionBarActivity {


    LinearLayout l1;
    public static final boolean defualt = false;

    TextView item_t1,item_t2,item_t3,item_t4,item_t5;
    int sum1, sum2, sum3, remain1, remain2, remain3;
    String inputLine1, inputLine2, inputLine3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        l1 = (LinearLayout) findViewById(R.id.lo1);
        View view1 = getLayoutInflater().inflate(R.layout.item_park1, null);
        View view2 = getLayoutInflater().inflate(R.layout.item_park2, null);
        View view3 = getLayoutInflater().inflate(R.layout.item_park3, null);
        View view4 = getLayoutInflater().inflate(R.layout.item_park4, null);
        View view5 = getLayoutInflater().inflate(R.layout.item_park5, null);

        // view1,2,3,4,5???? ?????? ??? find view by id ?? ?? ????????
        item_t1 = (TextView) view1.findViewById(R.id.item_textbar1);
        item_t2 = (TextView) view2.findViewById(R.id.item_textbar2);
        item_t3 = (TextView) view3.findViewById(R.id.item_textbar3);
        item_t4 = (TextView) view4.findViewById(R.id.item_textbar4);
        item_t5 = (TextView) view5.findViewById(R.id.item_textbar5);




        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        Boolean ch1boolean = SP.getBoolean("checkornot1", defualt);
        Boolean ch2boolean = SP.getBoolean("checkornot2", defualt);
        Boolean ch3boolean = SP.getBoolean("checkornot3", defualt);
        Boolean ch4boolean = SP.getBoolean("checkornot4", defualt);
        Boolean ch5boolean = SP.getBoolean("checkornot5", defualt);




        if (ch1boolean == true) {
            l1.addView(view1);
        } else
            l1.removeView(view1);

        if (ch2boolean == true) {
            l1.addView(view2);
        } else
            l1.removeView(view2);

        if (ch3boolean == true) {
            l1.addView(view3);
        } else
            l1.removeView(view3);

        if (ch4boolean == true) {
            l1.addView(view4);
        } else {
            l1.removeView(view4);
        }

        if (ch5boolean == true) {
            l1.addView(view5);
        } else
            l1.removeView(view5);



        ExampleTask progressTask = new ExampleTask();
        progressTask.execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.favor:
                Intent intent1 = new Intent(this, favorite.class);
                startActivity(intent1);
                break;

            case R.id.list:
                Intent intent3 = new Intent(this, list.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void p1_link_intent(View view) {
        Intent p1_intetnt = new Intent(this, activity_park1.class);
        startActivity(p1_intetnt);
    }

    public void p2_link_intent(View view) {
        Intent p2_intetnt = new Intent(this, activity_park2.class);
        startActivity(p2_intetnt);
    }

    public void p3_link_intent(View view) {
        Intent p3_intetnt = new Intent(this, activity_park3.class);
        startActivity(p3_intetnt);
    }

    public void p4_link_intent(View view) {
        Intent p4_intetnt = new Intent(this, activity_park4.class);
        startActivity(p4_intetnt);
    }

    public void p5_link_intent(View view) {
        Intent p5_intetnt = new Intent(this, activity_park5.class);
        startActivity(p5_intetnt);
    }

    public void favorite_refresh(View view) {

        ExampleTask progressTask = new ExampleTask();
        progressTask.execute();
    }


    public class ExampleTask extends AsyncTask<Void, Void, Void> {

        URL url1,url2,url3;
        URLConnection connection1,connection2,connection3;
        InputStream is1,is2,is3;
        InputStreamReader isr1,isr2,isr3;
        BufferedReader br1,br2,br3;

        @Override
        protected Void doInBackground(Void... arg0)
        {
            sum1=sum2=sum3=remain1=remain2=remain3=0;

            try
            {
                url1 = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");
                connection1 = url1.openConnection();

                url2 = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");
                connection2 = url2.openConnection();

                url3 = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");
                connection3 = url3.openConnection();
            }
            catch (Exception e)
            {e.getMessage();}

            try
            {
                is1 = connection1.getInputStream();
                isr1 = new InputStreamReader(is1, "UTF-8");
                br1 = new BufferedReader(isr1);
                inputLine1 = br1.readLine();
                char[] array1 = inputLine1.toCharArray();
                for (int k = 0; k < inputLine1.length(); k++)
                {
                    if (array1[k] == '1')
                    {
                        sum1 = sum1 + 1;
                    }
                }
                remain1=18-sum1;



                is2 = connection2.getInputStream();
                isr2 = new InputStreamReader(is2, "UTF-8");
                br2 = new BufferedReader(isr2);
                inputLine2 = br2.readLine();
                char[] array2 = inputLine2.toCharArray();

                for (int k = 0; k < inputLine2.length(); k++)
                {
                    if (array2[k] == '1')
                    {
                        sum2 = sum2 + 1;
                    }
                }
                remain2=18-sum2;


                is3 = connection3.getInputStream();
                isr3 = new InputStreamReader(is3, "UTF-8");
                br3 = new BufferedReader(isr3);
                inputLine3 = br3.readLine();
                char[] array3 = inputLine3.toCharArray();

                for (int k = 0; k < inputLine3.length(); k++)
                {
                    if (array3[k] == '1')
                    {
                        sum3 = sum3 + 1;
                    }
                }
                remain3=18-sum3;
            }
            catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            item_t1.setText(remain1+" SITES REMAINING");
            item_t2.setText(remain2+" SITES REMAINING");
            item_t3.setText(remain3+" SITES REMAINING");
            item_t4.setText(remain1+" SITES REMAINING");
            item_t5.setText(remain2+" SITES REMAINING");
        }
    }

}

