package seoyunhu.version1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by seoyu_000 on 2015-08-03.
 */
public class activity_park5 extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.str_park5);
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

}

