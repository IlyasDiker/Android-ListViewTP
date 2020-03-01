package com.example.commande.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commande.R;
import com.example.commande.models.clientitem;

import java.util.List;

public class ClientItemAdapter extends BaseAdapter {

    // fields
    private Context context;
    private List<clientitem> clientitemList;
    private LayoutInflater inflater;

    public ClientItemAdapter(Context context, List<clientitem> clientitemList) {
        this.context = context;
        this.clientitemList = clientitemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return clientitemList.size();
    }

    @Override
    public clientitem getItem(int i) {
        return clientitemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item, null);

        clientitem currentitem = getItem(i);
        String itemRef = currentitem.getRef();
        double itemPrice = currentitem.getPrice();
        String itemIcon = currentitem.getIcon();
        boolean itemalert = currentitem.isIsurgent();

        // get item ref
        TextView clientnameview = view.findViewById(R.id.item_name);
        clientnameview.setText(itemRef);

        // get item price
        TextView clientpriceview = view.findViewById(R.id.item_price);
        clientpriceview.setText("Montant TTC : "+ itemPrice);

        // get item icon
        ImageView iconitemview = view.findViewById(R.id.item_icon);
        String resourceName = itemIcon;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        iconitemview.setImageResource(resId);

        // get item isurgent
        ImageView alertitemview = view.findViewById(R.id.item_alert);
        if (itemalert == true){
            alertitemview.setVisibility(View.VISIBLE);
        } else {
            alertitemview.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}
