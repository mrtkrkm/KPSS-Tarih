package muratk.mktarih.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import muratk.mktarih.Adapters.HistoryAdapter;
import muratk.egkpss.R;

public class HistoryActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Konular");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8034656764343756/1311957628");
        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });

        ArrayList<String> arrSubjects= new ArrayList<String>();
        arrSubjects.add("İLKÇAĞ TARİHİ");
        arrSubjects.add("İSLAM TARİHİ");
        arrSubjects.add("TÜRK - İSLAM TARİHİ");
        arrSubjects.add("OSMANLI TARİHİ YÜKSELİŞ DÖNEMİ");
        arrSubjects.add("OSMANLI DEVLETİ DURAKLAMA VE GERİLEME DÖNEMİ");
        arrSubjects.add("OSMANLI TARİHİ DAĞILMA DÖNEMİ VE ISLAHATLAR");
        arrSubjects.add("20. YÜZYIL OSMANLI, MONDROS, CEMİYETLER, KUVAYİ MİLLİYE");
        arrSubjects.add("KONGRELER, TBMM, AYAKLANMALAR, SEVR ANTLAŞMASI");
        arrSubjects.add("KURTULUŞ SAVAŞI, CEPHELER, ANTLAŞMALAR");
        arrSubjects.add("İNKILAPLAR, İLKELER, DIŞ POLİTİKA");
        arrSubjects.add("AVRUPA TARİHİ");

        ListView listView = (ListView) findViewById(R.id.listview_history);
        listView.setAdapter(new HistoryAdapter(this, arrSubjects));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                startActivity(new Intent(HistoryActivity.this, HistoryDetailActivity.class).putExtra("pos", position));
            }
        });
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_history, menu);
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
