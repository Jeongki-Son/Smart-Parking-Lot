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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class list extends ActionBarActivity {

    public CheckBox ch1,ch2,ch3,ch4,ch5;
    Boolean checked1,checked2,checked3,checked4,checked5;
    public static final boolean defualt = false;
    Button base1,base2,base3,base4,base5;

    TextView t1,t2,t3,t4,t5;
    int sum1,sum2,sum3,remain1,remain2,remain3;
    String inputLine1,inputLine2,inputLine3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox4);
        ch5 = (CheckBox) findViewById(R.id.checkBox5);


        base1 = (Button) findViewById(R.id.base1);
        base2 = (Button) findViewById(R.id.base2);
        base3 = (Button) findViewById(R.id.base3);
        t1 = (TextView) findViewById(R.id.textbar1);
        t2 = (TextView) findViewById(R.id.textbar2);
        t3 = (TextView) findViewById(R.id.textbar3);
        t4 = (TextView) findViewById(R.id.textbar4);
        t5 = (TextView) findViewById(R.id.textbar5);


        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        Boolean ch1boolean = SP.getBoolean("checkornot1", defualt);
        Boolean ch2boolean = SP.getBoolean("checkornot2", defualt);
        Boolean ch3boolean = SP.getBoolean("checkornot3", defualt);
        Boolean ch4boolean = SP.getBoolean("checkornot4", defualt);
        Boolean ch5boolean = SP.getBoolean("checkornot5", defualt);
        ch1.setChecked(ch1boolean);
        ch2.setChecked(ch2boolean);
        ch3.setChecked(ch3boolean);
        ch4.setChecked(ch4boolean);
        ch5.setChecked(ch5boolean);


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
                Intent intent3 = new Intent(this,list.class);
                startActivity(intent3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void clickevent1(View view) {

        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor ED = SP.edit();
        checked1 = ch1.isChecked();
        ED.putBoolean("checkornot1", checked1);
        ED.commit();
    }

    public void clickevent2(View view) {

        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor ED = SP.edit();
        checked2 = ch2.isChecked();
        ED.putBoolean("checkornot2",checked2);
        ED.commit();
    }

    public void clickevent3(View view) {

        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor ED = SP.edit();
        checked3 = ch3.isChecked();
        ED.putBoolean("checkornot3",checked3);
        ED.commit();
    }

    public void clickevent4(View view) {

        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor ED = SP.edit();
        checked4 = ch4.isChecked();
        ED.putBoolean("checkornot4",checked4);
        ED.commit();
    }

    public void clickevent5(View view) {

        SharedPreferences SP = getSharedPreferences("FavoritePreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor ED = SP.edit();
        checked5 = ch5.isChecked();
        ED.putBoolean("checkornot5",checked5);
        ED.commit();
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

    public void list_refresh(View view) {

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
            t1.setText(remain1+" SITES REMAINING");
            t2.setText(remain2+" SITES REMAINING");
            t3.setText(remain3+" SITES REMAINING");
            t4.setText(remain3+" SITES REMAINING");
            t5.setText(remain3+" SITES REMAINING");
        }
    }

}
