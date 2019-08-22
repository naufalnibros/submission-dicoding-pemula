package id.co.naufalnibros.dicoding_pemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.co.naufalnibros.dicoding_pemula.activities.AboutActivity;
import id.co.naufalnibros.dicoding_pemula.adapters.PesanAdapter;
import id.co.naufalnibros.dicoding_pemula.models.Pesan;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Toolbar toolbar;
    private RecyclerView recyclerViewPesan;
    private PesanAdapter pesanAdapter;
    private List<Pesan> pesanList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView imageNoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        toolbar.setTitle("Daftar Pesan");
        setSupportActionBar(toolbar);

        swipeRefreshLayout = findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);

        imageNoData = findViewById(R.id.image_view_blank_data);
        recyclerViewPesan = findViewById(R.id.recyclerview_pesan);

        addPesanList();

        pesanAdapter = new PesanAdapter(getApplicationContext(), pesanList);
        recyclerViewPesan.setAdapter(pesanAdapter);
        recyclerViewPesan.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
    }

    private void addPesanList(){
        pesanList.add(new Pesan("L", "NAUFAL", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("L", "RAHMAT Arifin", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("L", "RAHMAT Arifin", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Syintia", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("L", "RAHMAT Arifin", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Adinda", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Riska", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Rahma", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Alfiyah", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));
        pesanList.add(new Pesan("P", "Indah", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'"));

        if (!pesanList.isEmpty()){
            recyclerViewPesan.setVisibility(View.VISIBLE);
            imageNoData.setVisibility(View.GONE);
        }

        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_about: {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        addPesanList();
        pesanAdapter.notifyDataSetChanged();
    }
}
