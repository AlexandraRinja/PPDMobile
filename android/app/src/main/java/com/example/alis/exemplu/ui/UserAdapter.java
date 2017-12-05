package com.example.alis.exemplu.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.User;

import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> names;
    public UserAdapter(List<User> names) {
        this.names=names;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.firstName.setText(names.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        public ViewHolder(View itemView) {
            super(itemView);
            firstName=itemView.findViewById(R.id.first_name);
        }
    }
}
