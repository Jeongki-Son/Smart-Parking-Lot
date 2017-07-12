

package seoyunhu.version1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class activity_park1 extends AppCompatActivity {

    Button[] b = new Button[83];
    public String line;
    char[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.str_park1);

        Log.v("받음", "시작");
        b[0] = (Button) findViewById(R.id.button0);
        b[1] = (Button) findViewById(R.id.button1);
        b[2] = (Button) findViewById(R.id.button2);
        b[3] = (Button) findViewById(R.id.button3);
        b[4] = (Button) findViewById(R.id.button4);


        ExampleTask progressTask = new ExampleTask();
        Log.v("받음", "함수 시작");
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB) {
            progressTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            progressTask.execute();
        }
        //ExampleTask progressTask = new ExampleTask();
        //progressTask.execute();


    }

    public class ExampleTask extends AsyncTask<Void, Void, Void> {

        String strUrl;
        URL url;
        // URLConnection connection;
        // InputStream is;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            strUrl = "https://carpark-php-jeongki-son.c9users.io/hello-world.php";
            Log.v("받음", "URL겟");
        }


        @Override
        protected Void doInBackground(Void... voids) {
            Log.v("받음", "백그라운드 시작");
            try {
                url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET"); // get방식 통신
                conn.setDoOutput(true);       // 쓰기모드 지정
                conn.setDoInput(true);        // 읽기모드 지정
                conn.setUseCaches(false);     // 캐싱데이터를 받을지 안받을지
                conn.setDefaultUseCaches(false); // 캐싱데이터 디폴트 값 설정

                String strCookie = conn.getHeaderField("Set-Cookie");
                InputStream is = conn.getInputStream();

                StringBuilder builder = new StringBuilder();
                BufferedReader reader  = new BufferedReader(new InputStreamReader(is, "UTF-8"));


                while ((line = reader.readLine()) != null) {
                    builder.append(line+ "\n");
                    Log.v("라인", line);
                    array = line.toCharArray();
                }

                Log.v("빌더", String.valueOf(builder));
                String result = builder.toString();
                Log.v("문자열", result);
                Log.v("어레이", String.valueOf(array));



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.v("연결", String.valueOf(array));
            Log.v("라인", String.valueOf(array[1]));
            for (int k = 0; k < array.length; k++)
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


    public void event0(View view) {
        if (array[0] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }
    public void event1(View view) {
        if (array[1] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }
    public void event2(View view) {
        if (array[2] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }
    public void event3(View view) {
        if (array[3] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }
    public void event4(View view) {
        if (array[4] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }
    public void event5(View view) {
        if (array[5] == '1')
        {
            Toast.makeText(getApplicationContext(),"Unavailable Site",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Available Site",Toast.LENGTH_SHORT).show();
        }
    }

}