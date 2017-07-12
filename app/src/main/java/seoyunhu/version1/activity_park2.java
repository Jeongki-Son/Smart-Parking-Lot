package seoyunhu.version1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class activity_park2 extends ActionBarActivity {

    Button[] b = new Button[83];
    public String inputLine;
    char[] array;
    URL uglobal;
    String sglobal;
    TextView tt1,tt2,tt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.str_park1);


        b[0] = (Button) findViewById(R.id.button0);
        b[1] = (Button) findViewById(R.id.button1);
        b[2] = (Button) findViewById(R.id.button2);
        b[3] = (Button) findViewById(R.id.button3);
        b[4] = (Button) findViewById(R.id.button4);
        b[5] = (Button) findViewById(R.id.button5);
        b[6] = (Button) findViewById(R.id.button6);
        b[7] = (Button) findViewById(R.id.button7);
        b[8] = (Button) findViewById(R.id.button8);
        b[9] = (Button) findViewById(R.id.button9);
        b[10] = (Button) findViewById(R.id.button10);
        b[11] = (Button) findViewById(R.id.button11);
        b[12] = (Button) findViewById(R.id.button12);
        b[13] = (Button) findViewById(R.id.button13);
        b[14] = (Button) findViewById(R.id.button14);
        b[15] = (Button) findViewById(R.id.button15);
        b[16] = (Button) findViewById(R.id.button16);
        b[17] = (Button) findViewById(R.id.button17);

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


    public void event0(View view) throws MalformedURLException {


        uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/Atime.html");

        URLamolang mola = new URLamolang();
        mola.execute();

        if (array[0] == '1')
        {
            Toast.makeText(getApplicationContext(),sglobal,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }
    }


    public void event1(View view) throws MalformedURLException {

        if (array[1] == '1')
        {
            Toast.makeText(getApplicationContext(),"주차중입니다",Toast.LENGTH_SHORT).show();
            uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/Atime.php");
            URLamolang mola = new URLamolang();
            mola.execute();
            Toast.makeText(getApplicationContext(),sglobal,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }
    }

    public void event2(View view) throws MalformedURLException {


        if (array[2] == '1')
        {
            Toast.makeText(getApplicationContext(),"주차중입니다",Toast.LENGTH_SHORT).show();
            uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/Atime.html");
            URLamolang mola = new URLamolang();
            mola.execute();
            Toast.makeText(getApplicationContext(),sglobal,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }

    }

    public void event3(View view) throws MalformedURLException {


        uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/Atime.html");

        URLamolang mola = new URLamolang();
        mola.execute();

        if (array[3] == '1')
        {
            Toast.makeText(getApplicationContext(),"주차불가입니다",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }
    }


    public void event4(View view) throws MalformedURLException {


        uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");

        URLamolang mola = new URLamolang();
        mola.execute();

        if (array[4] == '1')
        {
            Toast.makeText(getApplicationContext(),"주차불가입니다",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }

    }


    public void event5(View view) throws MalformedURLException {


        uglobal = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");

        URLamolang mola = new URLamolang();
        mola.execute();

        if (array[5] == '1')
        {
            Toast.makeText(getApplicationContext(),"주차불가입니다",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"주차가능합니다",Toast.LENGTH_SHORT).show();
        }
    }


    public void event6(View view) {
    }


    public void event7(View view) {
    }


    public void event8(View view) {
    }


    public void event9(View view) {
    }


    public void event10(View view) {
    }


    public void event11(View view) {
    }


    public void event12(View view) {
    }


    public void event13(View view) {
    }


    public void event14(View view) {
    }


    public void event15(View view) {
    }


    public void event16(View view) {
    }


    public void event17(View view) {
    }

    public void str1_refresh(View view) {

        ExampleTask progressTask = new ExampleTask();
        progressTask.execute();
    }


    public class ExampleTask extends AsyncTask<Void, Void, Void> {

        URL url;
        URLConnection connection;
        InputStream is;

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                url = new URL("http://ec2-52-68-246-215.ap-northeast-1.compute.amazonaws.com/arrayall.html");
                connection = url.openConnection();
            }
            catch (Exception e) {
            }

            try {
                is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                inputLine = br.readLine();
                array = inputLine.toCharArray();
            }
            catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            for (int k = 0; k < inputLine.length(); k++)
            {
                if (array[k] == '1') // 어레이는 1부터 저장됨
                {
                    b[k].setBackgroundResource(R.drawable.disable);
                }
                else
                {
                    b[k].setBackgroundResource(R.drawable.able);
                }
            }
        }
    }

    public class URLamolang extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params)
        {
            try
            {
                URLConnection c = uglobal.openConnection();
                InputStream i = c.getInputStream();
                InputStreamReader ir = new InputStreamReader(i, "UTF-8");
                BufferedReader b = new BufferedReader(ir);
                sglobal = b.readLine();
            }
            catch (Exception e) {
            }
            return null;
        }
    }











}
