package id.co.naufalnibros.dicoding_pemula.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.co.naufalnibros.dicoding_pemula.R;
import id.co.naufalnibros.dicoding_pemula.activities.DetailActivity;
import id.co.naufalnibros.dicoding_pemula.models.Pesan;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.ViewHolder> {

    private Context context;
    private List<Pesan> pesanList;

    public PesanAdapter(Context context, List<Pesan> pesanList) {
        this.context = context;
        this.pesanList = pesanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_pesan, parent, false);
        return new PesanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Pesan pesan = pesanList.get(position);

        holder.txtPesan.setText(pesan.getPesan());
        holder.txtNama.setText(pesan.getNama_pengirim());
        if (pesan.getGender().equals("P")) {
            holder.imageGender.setImageResource(R.drawable.ic_girl);
        } else {
            holder.imageGender.setImageResource(R.drawable.ic_man);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(DetailActivity.TAG_DETAIL_PESAN, pesan));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pesanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama, txtPesan;
        public ImageView imageGender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txt_nama_pengirim);
            txtPesan = itemView.findViewById(R.id.txt_pesan);
            imageGender = itemView.findViewById(R.id.image_gender);

        }
    }
}
