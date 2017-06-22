package com.imac.insantappsample.register;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imac on 6/19/17.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.myHolder> {

    Context mContext;
    List<String> mList;
    itemClickListener itemClickListener;

    public RecyclerviewAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public myHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(myHolder myHolder, int i) {

        myHolder.tvTitle.setText(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setItemClickListener(RecyclerviewAdapter.itemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    protected class myHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public myHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView)itemView.findViewById(R.id.tv_item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemSelect(getAdapterPosition());
                }
            });
        }
    }

    public interface itemClickListener{
        void onItemSelect(int position);
    }
}
