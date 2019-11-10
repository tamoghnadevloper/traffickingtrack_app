package com.wwf.traffikingtrack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Prodsuminner> android;
    private Context context;
    Model basee;


    public DataAdapter(Context context, List<Prodsuminner> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        Prodsuminner model = android.get(i);
        basee =  Model.getInstance();
        viewHolder.prodtype.setText("Product Type Name "+model.getProdtypname());
        viewHolder.prodlstw.setText("Product List Name "+model.getProdlstnam());
        viewHolder.prodaged.setText("Product Age "+model.getAgge());
        if(model.getIsIssesnd().equalsIgnoreCase("true")){
            viewHolder.prodscndx.setText("Seasoned");
        }else {
            viewHolder.prodscndx.setText("Not Seasoned");
        }



    }

    @Override
    public int getItemCount() {

        return android.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView prodtype,prodlstw,prodaged,prodscndx;
        public ViewHolder(View view) {
            super(view);
            prodtype = (TextView) view.findViewById(R.id.prodtyp);
            prodlstw = (TextView) view.findViewById(R.id.prodlst);
            prodaged = (TextView) view.findViewById(R.id.prodage);
            prodscndx = (TextView) view.findViewById(R.id.issecnd);
        }
    }

}