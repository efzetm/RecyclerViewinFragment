package com.example.recyclerviewinfragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private ArrayList<HeroesModel> listHero = new ArrayList<>();
    private Context context;

    public HeroesAdapter(ArrayList<HeroesModel> listHero, Context context) {
        this.listHero = listHero;
        this.context = context;
    }


    public ArrayList<HeroesModel> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemRow = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_hero,parent,false);
        return new ViewHolder(itemRow);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Glide.with(context).load(getListHero().get(i).getHeroImage()).into(holder.ivHero);
        holder.tvName.setText(getListHero().get(i).getHeroName());


        holder.btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);


                intent.putExtra("img_url", getListHero().get(i).getHeroImage());
                intent.putExtra("nama",getListHero().get(i).getHeroName());
                intent.putExtra("deskripsi",getListHero().get(i).getHeroDetail());
                context.startActivity(intent);




            }
        });


        holder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                String DetailName = "Nama : "+getListHero().get(i).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT,DetailName);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {

        return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHero;
        TextView tvName;
        Button btn_share;
        Button btn_lihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_img);
            tvName = itemView.findViewById(R.id.itemhero_tv_nama);
            btn_lihat =itemView.findViewById(R.id.button_lihat);
            btn_share = itemView.findViewById(R.id.button_share);


        }
    }
}