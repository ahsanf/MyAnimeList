package com.example.ahsan.myanimelist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListKarakterAdapter extends RecyclerView.Adapter<ListKarakterAdapter.CategoryViewHolder> {
    private Context context;

    public ArrayList<Karakter> getListKarakter() {
        return listKarakter;
    }

    public void setListKarakter(ArrayList<Karakter> listKarakter) {
        this.listKarakter = listKarakter;
    }

    private ArrayList<Karakter> listKarakter;

    public ListKarakterAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_karakter, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListKarakter().get(position).getName());
        holder.tvRemarks.setText(getListKarakter().get(position).getRemarks());
        holder.tvDetail.setText(getListKarakter().get(position).getDetail());
        holder.link = getListKarakter().get(position).getPhoto();

        Glide.with(context)
                .load(getListKarakter().get(position).getPhoto())
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListKarakter().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        TextView tvDetail;
        String link = "";

        public CategoryViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvDetail = (TextView) itemView.findViewById(R.id.tv_item_dtl);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("Name", tvName.getText());
                    intent.putExtra("Remarks", tvRemarks.getText());
                    intent.putExtra("Detail", tvDetail.getText());
                    intent.putExtra("Photo", link);
                    context.startActivity(intent);
                    try {
                        this.finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
        }
    }
}

