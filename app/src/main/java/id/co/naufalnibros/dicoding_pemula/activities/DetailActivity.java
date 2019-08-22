package id.co.naufalnibros.dicoding_pemula.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.naufalnibros.dicoding_pemula.R;
import id.co.naufalnibros.dicoding_pemula.models.Pesan;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageGender, imageGenderToolbar;
    private TextView txtNamaPenngirim, txtNamaPenngirimToolbar, txtPesan;

    private Pesan pesan;
    public static final String TAG_DETAIL_PESAN = "tag_detail_pesan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        pesan = extras.getParcelable(TAG_DETAIL_PESAN);

        toolbar = findViewById(R.id.toolbar_detail_pesan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back));

        imageGender = findViewById(R.id.image_gender);
        imageGenderToolbar = findViewById(R.id.image_gender_toolbar);
        txtNamaPenngirim = findViewById(R.id.txt_nama_pengirim);
        txtNamaPenngirimToolbar = findViewById(R.id.txt_nama_pengirim_toolbar);
        txtPesan = findViewById(R.id.txt_pesan);

        if (pesan.getGender().equals("P")){
            imageGender.setImageResource(R.drawable.ic_girl);
            imageGenderToolbar.setImageResource(R.drawable.ic_girl);
        }

        txtNamaPenngirim.setText(pesan.getNama_pengirim());
        txtNamaPenngirimToolbar.setText(pesan.getNama_pengirim());
        txtPesan.setText(pesan.getPesan());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
