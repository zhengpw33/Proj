package com.example.vince.proj.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vince.proj.DB.Role;
import com.example.vince.proj.R;

import java.util.List;

/**
 * Created by vince on 2017/11/13.
 */

public class RoleAdapter extends RecyclerView.Adapter<RoleAdapter.ViewHolder> {

    final private List<Role> roleLists;
    private RoleAdapterHelper roleAdapterHelper = new RoleAdapterHelper();
    protected OnItemClickListener myOnItemClickListener;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameField;
        ImageView portraitField;
        public ViewHolder(View view){
            super(view);
            //nameField = (TextView) view.findViewById(R.id.name_main_list);
            portraitField = (ImageView) view.findViewById(R.id.role_content);
        }
    }

    public RoleAdapter(List<Role> roleLists){
        this.roleLists = roleLists;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.role_list, parent, false);
        //final ViewHolder holder = new ViewHolder(view);
        roleAdapterHelper.onCreateViewHolder(parent, view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        roleAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
        Role role = roleLists.get(position);
//        holder.nameField.setText(character.getName());
        holder.portraitField.setImageResource(role.getImageId());
        if(myOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    myOnItemClickListener.onClick(holder.getAdapterPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    myOnItemClickListener.onLongClick(holder.getAdapterPosition());
                    return false;
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return roleLists.size();
    }

    public interface  OnItemClickListener{//接口
        void onClick(int position);
        void onLongClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.myOnItemClickListener=onItemClickListener;
    }
}