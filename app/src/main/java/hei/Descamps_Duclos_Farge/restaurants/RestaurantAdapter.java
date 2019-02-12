package hei.Descamps_Duclos_Farge.restaurants;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(List<Restaurant> _restaurantList){
        restaurantList=_restaurantList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_simple, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Restaurant restaurant = restaurantList.get(position);
       // holder.favoriteColor.setBackgroundColor(restaurant.getFavoriteColor());
        //holder.firstname.setText(restaurant.getFirstname());
        //holder.lastname.setText(restaurant.getLastname());
        holder.restaurantName.setText(restaurant.getName());


    }

    @Override
    public int getItemCount(){
        return restaurantList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView restaurantName;
       // private View img;


        public ViewHolder(View view){
            super(view);
            restaurantName = view.findViewById(R.id.liste_restaurant);

        }

    }
}

