package com.example.commande;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.commande.adapters.ClientItemAdapter;
import com.example.commande.models.clientitem;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {

    public Boolean isSearchMenuOn = false;
    List<clientitem> clientitemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //item list

        clientitemList.add(new clientitem( "ML123000", 120.50, "grossis", true));
        clientitemList.add(new clientitem( "IP520001", 52000.00, "clientn", false));
        clientitemList.add(new clientitem( "PM456086", 120.50, "clientf", true));

        LinearLayout searchlayout = findViewById(R.id.searchlayout);
        searchlayout.setVisibility(View.GONE);

        ListView  clientlistView = findViewById(R.id.liste_clients);
        clientlistView.setAdapter(new ClientItemAdapter( this, clientitemList));

    }


    public void showsearchlayout(View view) {
        LinearLayout searchlayout = findViewById(R.id.searchlayout);
        if (isSearchMenuOn) {
            searchlayout.setVisibility(View.GONE);
            isSearchMenuOn = false;
        } else {
            searchlayout.setVisibility(View.VISIBLE);
            isSearchMenuOn = true;
        }
    }

    public void clearfields(View view) {
        EditText reffield = findViewById(R.id.ref);
        EditText designationfield = findViewById(R.id.designation);
        CheckBox urgentcheckbox = findViewById(R.id.isUrgent);
        EditText prixfield = findViewById(R.id.prixunit);
        EditText quantitefield = findViewById(R.id.qte);

        reffield.setText("");
        designationfield.setText("");
        urgentcheckbox.setChecked(false);
        prixfield.setText("");
        quantitefield.setText("");
        clientitemList.clear();
    }

    public void addclient(View view) {
        EditText reffield = findViewById(R.id.ref);
        EditText designationfield = findViewById(R.id.designation);
        CheckBox urgentcheckbox = findViewById(R.id.isUrgent);
        Spinner typeclient = findViewById(R.id.spinner);
        EditText prixfield = findViewById(R.id.prixunit);
        EditText quantitefield = findViewById(R.id.qte);

        if (reffield.getText().toString() != "" && designationfield.getText().toString() != "" && prixfield.getText().toString() != "" && quantitefield.getText().toString() != "" ) {
            String ref = reffield.getText().toString();
            String designation = designationfield.getText().toString();
            boolean isurgent;
            if (urgentcheckbox.isChecked()) {
                isurgent = true;
            } else {
                isurgent = false;
            }
            String tclient = "";
            if (typeclient.getSelectedItem().toString().equals("Grossiste")){
                tclient = "grossis";
            } else if (typeclient.getSelectedItem().toString().equals("Client Fidèle")){
                tclient = "clientf";
            } else if (typeclient.getSelectedItem().toString().equals("Client Normale")){
                tclient = "clientn";
            }

            double prixut = parseDouble(prixfield.getText().toString());
            int qte = parseInt(quantitefield.getText().toString());

            double price = (prixut * qte)*1.2;
            clientitemList.add(new clientitem( ref, price, tclient, isurgent));
        } else {
            Toast.makeText(MainActivity.this, "Empty Field!",
                    Toast.LENGTH_LONG).show();
        }


    }

    public void clearsearch(View view) {
        EditText searchfield = findViewById(R.id.searchfield);
        searchfield.setText("");
    }
}
