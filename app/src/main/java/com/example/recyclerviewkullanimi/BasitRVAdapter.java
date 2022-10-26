package com.example.recyclerviewkullanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasitRVAdapter extends RecyclerView.Adapter<BasitRVAdapter.CardViewTasarimNesnelerininTutucu>{
    private Context mContext;
    private List<String> ulkelerDisaridanGelenList;

    public BasitRVAdapter(Context mContext, List<String> ulkelerDisaridanGelenList) {
        this.mContext = mContext;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }
    public class CardViewTasarimNesnelerininTutucu extends RecyclerView.ViewHolder{
        public TextView satirYazi;
        public CardView satirCardView;
        public ImageView noktaResim;
        public CardViewTasarimNesnelerininTutucu(View view){
            super(view);
            satirYazi=view.findViewById(R.id.satirYazi);
            satirCardView=view.findViewById(R.id.satirCardView);
            noktaResim = view.findViewById(R.id.noktaResim);
        }

    }

    @NonNull
    @Override
    public CardViewTasarimNesnelerininTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_tasarim,parent,false);

        return new CardViewTasarimNesnelerininTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesnelerininTutucu holder, int position) {
        final String ulke = ulkelerDisaridanGelenList.get(position);

        holder.satirYazi.setText(ulke);

        holder.satirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Seçtiğiniz ülke : "+ulke,Toast.LENGTH_SHORT).show();
            }
        });
        holder.noktaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(mContext,view);
                popup.getMenuInflater().inflate(R.menu.card_menu, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_sil:
                                Toast.makeText(mContext,"Sil Tıklandı:  "+ulke,Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_duzenle:
                                Toast.makeText(mContext,"Düzenle Tıklandı: "+ulke,Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;

                        }

                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }


}
