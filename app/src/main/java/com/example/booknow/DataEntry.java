package com.example.booknow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.booknow.databinding.ActivityDataEntryBinding;
import com.example.booknow.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataEntry extends AppCompatActivity {

    AppDatabase db;
    ActivityDataEntryBinding binding;
    SimpleDateFormat simpleDateFormat;
  //  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataEntryBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        db=AppDatabase.getDBInstance(this);
        if(db==null)
        {
            Log.d("donanshul","string ");
        }
        //textView=findViewById(R.id.textView);
               Calendar calendar=Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy     hh:mm:ss a");
                String datetime=simpleDateFormat.format(calendar.getTime());

    // binding.tvId.setText(datetime);
        String data = getIntent().getExtras().getString("purchasevalue");

      binding.btSave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
Log.d("anurag","arjis");
              String dt=datetime;
              String productname=binding.etProductName.getText().toString();
              int Pre=Integer.parseInt(binding.etPrice.getText().toString());
              String Unit=binding.etUnit.getText().toString();
              int purchase =-1,sell=-1;
              int Quantity=Integer.parseInt(binding.etQuantity.getText().toString());
              if(data.equals("0"))
              {
                  purchase=1;sell=0;
              }
              else if(data.equals("1"))
              {
                  purchase=0;sell=1;
              }
              MainData m=new MainData();
              m.setDateTime(dt);
              m.setProductNAME(productname);
              m.setPrice(Pre);
              m.setUnit(Unit);
              m.setQuantity(Quantity);
              m.setPurchase(purchase);
              m.setSell(sell);
Log.d("values",m.DateTime);
              Log.d("values1",m.ProductNAME);

                db.userDao().InsertAll(m);
                Intent i=new Intent(DataEntry.this,MainActivity.class);
                startActivity(i);
                finish();
          }
      });
    }



}