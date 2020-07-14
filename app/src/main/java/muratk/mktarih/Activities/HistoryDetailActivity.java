package muratk.mktarih.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import muratk.mktarih.Adapters.HistoryDetailAdapter;
import muratk.mktarih.Database.Database;
import muratk.mktarih.Models.FirstInHistoryModel;
import muratk.egkpss.R;

public class HistoryDetailActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Detay");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int pos = b.getInt("pos", 0);

        Database dbOpenHelper = new Database(this, "kpss.sqlite");
        dbOpenHelper.openDataBase();
        final ArrayList<FirstInHistoryModel> historyModels = dbOpenHelper.GetAllHistory(Integer.toString(pos));

        ListView listView = (ListView) findViewById(R.id.listview_history_detail);
        listView.setAdapter(new HistoryDetailAdapter(this, historyModels));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_history_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        finish();

        return super.onOptionsItemSelected(item);
    }
}
