package com.example.booknow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booknow.databinding.ActivityDataEntryBinding;
import com.example.booknow.databinding.LayoutNowbookBinding;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.myviewholder> {

    ArrayList<MainData> arrayList;
    PostAdapter(ArrayList<MainData> a)
    {
        arrayList=a;
    }
    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
LayoutNowbookBinding binding=LayoutNowbookBinding.
        inflate(LayoutInflater.from(parent.getContext()),parent,false);
return new myviewholder(binding);
    }

    @Override
    public void onBindViewHolder(myviewholder holder, int position) {
holder.activityDataEntryBinding.tvDateTime.setText(arrayList.get(position).DateTime);
holder.activityDataEntryBinding.tvProductName.setText(arrayList.get(position).ProductNAME);
String k=arrayList.get(position).getUnit();
holder.activityDataEntryBinding.tvQuantity.setText(arrayList.get(position).Quantity+"*1"+k);
        if (arrayList.get(position).getSell()==0)
        {
            holder.activityDataEntryBinding.tvSell.setText("0");
            holder.activityDataEntryBinding.tvPurchase.
                    setText(arrayList.get(position).Price*arrayList.get(position).Quantity+"");
        }
        if (arrayList.get(position).getPurchase()==0)
        {
            holder.activityDataEntryBinding.tvPurchase.setText("0");
            holder.activityDataEntryBinding.tvSell.
                    setText(arrayList.get(position).Price*arrayList.get(position).Quantity+"");
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class myviewholder extends RecyclerView.ViewHolder{

LayoutNowbookBinding activityDataEntryBinding;
        public myviewholder(LayoutNowbookBinding activityDataEntryBinding)
        {
            super(activityDataEntryBinding.getRoot());
            this.activityDataEntryBinding=activityDataEntryBinding;
        }

    }
}
