package com.example.splasscreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class orderRuqyah extends AppCompatActivity {

    int Jumlah_orang = 0;
    int price = 0;
    TextView tvSummary;
    public final static  String STATE_HASIL="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ruqyah);

        tvSummary = findViewById(R.id.tvSummary);
        if(savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvSummary.setText(hasil);
        }
    }

    public void decrement(View view){
        if(Jumlah_orang == -0){
            display (Jumlah_orang);
        }
        else{
            Jumlah_orang-=1;
            display(Jumlah_orang);
        }
    }
    //fungsi penambah
    public void increnent(View view){
        Jumlah_orang+=1;
        display(Jumlah_orang);
    }
    public void display(int quantity){
        TextView tvQuantity = findViewById(R.id.tvQuantity);
        tvQuantity.setText(""+quantity);
    }
    public void btnReport(View view){
        //edittext
        EditText edtName = findViewById(R.id.edtName);
        String nama = edtName.getText().toString();

        EditText edtAlamat = findViewById(R.id.edtAlamat);
        String Alamat = edtAlamat.getText().toString();

        EditText edtNoHp = findViewById(R.id.edtNoHp);
        String NoHp = edtNoHp.getText().toString();

        EditText edtEmail = findViewById(R.id.edtEmail);
        String Email = edtEmail.getText().toString();
        //checkbox
        String pilihOrder = "";
        CheckBox Totok = findViewById(R.id.cbTotok);
        boolean hasTotok = Totok.isChecked();

        CheckBox Bekam = findViewById(R.id.cbBekam);
        boolean hasBekam = Bekam.isChecked();

        //kondisi
        if(hasTotok == true && hasBekam == true){
            pilihOrder = "Totok & Bekam";
        }else if (hasBekam == true){
            pilihOrder = "Bekam";
        }else if (hasTotok == true){
            pilihOrder = "Totok";
        }else{
            pilihOrder = "Hanya Ruqyah";
        }
        price = CalculatePrice (hasTotok,hasBekam);
        String orderSummary = CreateOrderSummary(price,nama,Alamat,NoHp,Email,pilihOrder);
        DisplaySummary(price, orderSummary);
    }


    public void submitOrder(View view) {
        //edittext
        EditText edtName = findViewById(R.id.edtName);
        String nama = edtName.getText().toString();

        EditText edtAlamat = findViewById(R.id.edtAlamat);
        String Alamat = edtAlamat.getText().toString();

        EditText edtNoHp = findViewById(R.id.edtNoHp);
        String NoHp = edtNoHp.getText().toString();

        EditText edtEmail = findViewById(R.id.edtEmail);
        String Email = edtEmail.getText().toString();
        //checkbox
        String pilihOrder = "";
        CheckBox Totok = findViewById(R.id.cbTotok);
        boolean hasTotok = Totok.isChecked();

        CheckBox Bekam = findViewById(R.id.cbBekam);
        boolean hasBekam = Bekam.isChecked();

        //kondisi
        if(hasTotok == true && hasBekam == true){
            pilihOrder = "Totok & Bekam";
        }else if (hasTotok == true){
            pilihOrder = "Totok";
        }else if (hasBekam == true){
            pilihOrder = "Bekam";
        }else{
            pilihOrder = "Hanya Ruqyah";
        }
        price = CalculatePrice (hasTotok,hasBekam);
        String orderSummary = CreateOrderSummary(price,nama,Alamat,NoHp,Email,pilihOrder);

        Toast.makeText(this,"Terimakasih Telah Order",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(orderRuqyah.this, dashboard.class);
        orderRuqyah.this.startActivity(intent);
        finish();
    }

    public int CalculatePrice(boolean hasTotok, boolean hasBekam){
        int hargaAwal = 50000;
        if (hasTotok){
            hargaAwal = hargaAwal + 20000;
        }
        if (hasBekam){
            hargaAwal = hargaAwal + 25000;
        }
        return Jumlah_orang * hargaAwal;
    }

    private String CreateOrderSummary(int price,String nama , String Alamat, String NoHp, String Email, String pilihOrder){
        String priceMeesage =
                "Nama                        : "+nama
                +"\nAlamat                      : "+Alamat
                +"\nNo Hp                        : "+NoHp
                +"\nEmail                         : "+Email
                +"\nJumlahOrder             : "+Jumlah_orang
                +"\nTambahanOrder        : "+pilihOrder
                +"\nTotal Harga                : "+price;
        return priceMeesage;
    }
    public void DisplaySummary(int price, String Summary){
        TextView tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(Summary);
    }

}