package org.nearbyshops.enduser.ShopsByCategory.Shops;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.nearbyshops.enduser.Model.Shop;
import org.nearbyshops.enduser.MyApplication;
import org.nearbyshops.enduser.R;
import org.nearbyshops.enduser.Utility.UtilityGeneral;

import java.util.List;

/**
 * Created by sumeet on 25/5/16.
 */
public class AdapterShop extends RecyclerView.Adapter<AdapterShop.ViewHolder> {


    private List<Shop> dataset = null;
    private Context context;


    public AdapterShop(List<Shop> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @Override
    public AdapterShop.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_shops_by_item_category,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterShop.ViewHolder holder, int position) {


        holder.shopName.setText(dataset.get(position).getShopName());


        holder.distance.setText(String.format( "%.2f", dataset.get(position).getDistance() )+ " Km");

//        Log.d("applog","on BInd()");

        String imagePath = UtilityGeneral.getImageEndpointURL(MyApplication.getAppContext())
                + dataset.get(position).getImagePath();

        Picasso.with(context)
                .load(imagePath)
                .placeholder(R.drawable.nature_people)
                .into(holder.shopImage);


    }

    @Override
    public int getItemCount() {

//        Log.d("applog",String.valueOf(dataset.size()));

        return dataset.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView shopName;
        ImageView shopImage;
        TextView distance;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            distance = (TextView) itemView.findViewById(R.id.distance);
            shopName = (TextView) itemView.findViewById(R.id.shopName);
            shopImage = (ImageView) itemView.findViewById(R.id.shopImage);
        }

        @Override
        public void onClick(View v) {

            //Toast.makeText(context,"Item Click : " + String.valueOf(getLayoutPosition()),Toast.LENGTH_SHORT).show();
        }
    }
}
