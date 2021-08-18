package com.example.booknow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.booknow.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ArrayList<MainData> arrayList=new ArrayList<MainData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

PostAdapter postAdapter= new PostAdapter(arrayList);
binding.rcView.setLayoutManager(new LinearLayoutManager(this));
binding.rcView.setAdapter(postAdapter);

        AppDatabase db=AppDatabase.getDBInstance(MainActivity.this);

        db.userDao().getAll().observe(MainActivity.this, new Observer<List<MainData>>() {
            @Override
            public void onChanged(List<MainData> mainData) {
                Log.d("array", String.valueOf(mainData));
                    arrayList.clear();
                arrayList.addAll(mainData);
                int s=0,p=0;
                for(int i=0;i<arrayList.size();i++)
                {
                    if(arrayList.get(i).sell==0)
                    {
                        p=p+(arrayList.get(i).Price*arrayList.get(i).Quantity);
                    }
                    else
                    {
                        s=s+(arrayList.get(i).Price*arrayList.get(i).Quantity);
                    }


                }

                binding.tvTotP.setText(p+"");
                binding.tvTotS.setText(s+"");

                    postAdapter.notifyDataSetChanged();

            }
        });

binding.btPurchase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,DataEntry.class);
        intent.putExtra("purchasevalue","0");
        startActivity(intent);
    }
});

binding.btSell.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this,DataEntry.class);
        i.putExtra("purchasevalue","1");
        startActivity(i);
    }
});
    }
}