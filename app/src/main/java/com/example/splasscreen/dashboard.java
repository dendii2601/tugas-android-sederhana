package com.example.splasscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText newUsername, newPassword;
    private Button newcontactpopup_save, newcontactpopup_cancel;
    private TextView hubungi, pesan, deskripsi1,deskripsi2,deskripsi3,deskripsi4,deskripsi5,deskripsi6,deskripsi7,deskripsi8,deskripsi9;
    private ImageView calling, smsCenter, quran,diagnosa,buku,bekam,totok,ruqyahMandiri,ayatRuqyah,mesjid,dzikir;
    private CardView card1, card2, card3, card4, card5, card6, card7, card8, card9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        card1 = (CardView) findViewById(R.id.quran);
        card2 = (CardView) findViewById(R.id.diagnosa);
        card3 = (CardView) findViewById(R.id.book);
        card4 = (CardView) findViewById(R.id.bekam);
        card5 = (CardView) findViewById(R.id.totok);
        card6 = (CardView) findViewById(R.id.ruqyahMandiri);
        card7 = (CardView) findViewById(R.id.ayat);
        card8 = (CardView) findViewById(R.id.mesjid);
        card9 = (CardView) findViewById(R.id.dzikir);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlquranDiaglog();
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDiagnosaDiaglog();
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBukuDiaglog();
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBekamDiaglog();
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTotokDiaglog();
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRuqiahMandiriDiaglog();
            }
        });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAyatDiaglog();
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMesjidDiaglog();
            }
        });

        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDzikirDiaglog();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item0:
                Toast.makeText(this, "Order Ruqyah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(dashboard.this, orderRuqyah.class);
                dashboard.this.startActivity(intent);
                finish();
                return true;
            case R.id.item1:
                Toast.makeText(this, "Call Center", Toast.LENGTH_SHORT).show();
                createNewContactDiaglog1();
                return true;
            case R.id.item2:
                Toast.makeText(this, "SMS Center", Toast.LENGTH_SHORT).show();
                createNewContactDiaglog2();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Lokasi Peruqyah", Toast.LENGTH_SHORT).show();
                maps();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Update User dan Password", Toast.LENGTH_SHORT).show();
                createNewContactDiaglog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void createNewContactDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);
        newUsername = (EditText) contactPopupView.findViewById(R.id.newUsername);
        newPassword = (EditText) contactPopupView.findViewById(R.id.newPassword);

        newcontactpopup_save = (Button) contactPopupView.findViewById(R.id.saveButton);
        newcontactpopup_cancel = (Button) contactPopupView.findViewById(R.id.cancelButton);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        newcontactpopup_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "UPDATE SUKSES",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        newcontactpopup_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "UPDATE CANCEL",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    public void createNewContactDiaglog1() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View contactPopupView1 = getLayoutInflater().inflate(R.layout.popup1, null);
        calling = (ImageView) contactPopupView1.findViewById(R.id.calling);
        hubungi = (TextView) contactPopupView1.findViewById(R.id.hubungi);

        dialogBuilder.setView(contactPopupView1);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createNewContactDiaglog2() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View contactPopupView2 = getLayoutInflater().inflate(R.layout.popup2, null);
        smsCenter = (ImageView) contactPopupView2.findViewById(R.id.smsCenter);
        pesan = (TextView) contactPopupView2.findViewById(R.id.pesan);

        dialogBuilder.setView(contactPopupView2);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void  maps(){
        String location = "Mesjid Terdekat";
        Uri uri = Uri.parse("geo:0,0?q="+location);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void createAlquranDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View alquran = getLayoutInflater().inflate(R.layout.alquran, null);
        dialogBuilder.setView(alquran);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createDiagnosaDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View diagnosa = getLayoutInflater().inflate(R.layout.diagnosa, null);
        dialogBuilder.setView(diagnosa);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createBukuDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View buku = getLayoutInflater().inflate(R.layout.buku, null);
        dialogBuilder.setView(buku);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createBekamDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View bekam = getLayoutInflater().inflate(R.layout.bekam, null);
        dialogBuilder.setView(bekam);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createTotokDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View totok = getLayoutInflater().inflate(R.layout.totok, null);
        dialogBuilder.setView(totok);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createRuqiahMandiriDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View ruqyahMandiri = getLayoutInflater().inflate(R.layout.ruqyah_mandiri, null);
        dialogBuilder.setView(ruqyahMandiri);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createAyatDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View ayat = getLayoutInflater().inflate(R.layout.ayat_ruqyah, null);
        dialogBuilder.setView(ayat);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createMesjidDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View mesjid = getLayoutInflater().inflate(R.layout.mesjid, null);
        dialogBuilder.setView(mesjid);
        dialog = dialogBuilder.create();
        dialog.show();

    }

    public void createDzikirDiaglog() {
        dialogBuilder = new AlertDialog.Builder(dashboard.this);
        final View dzikir = getLayoutInflater().inflate(R.layout.dzikir, null);
        dialogBuilder.setView(dzikir);
        dialog = dialogBuilder.create();
        dialog.show();

    }
}