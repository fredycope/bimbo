package com.example.bimbodemo.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bimbodemo.R;
import com.example.bimbodemo.databinding.ListItemBinding;
import com.example.bimbodemo.domain.model.BeerDomain;
import com.example.bimbodemo.domain.model.Results;
import com.example.bimbodemo.utils.OnClickList;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<BeerDomain> items = new ArrayList<>();
    private OnClickList onClickList;

    public ListAdapter(OnClickList onClickList) {
        this.onClickList = onClickList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding view = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false
        );
        return new ViewHolder(view);
    }

    public void addData(List<BeerDomain> list) {
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    private BeerDomain getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding listItem;

        public ViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            listItem = (ListItemBinding) dataBinding;
        }

        public void onBind(BeerDomain item) {
            listItem.tvName.setText(item.name);
            Glide.with(listItem.ivLogo).load(item.imageUrl).into(listItem.ivLogo);
            itemView.setOnClickListener(v -> onClickList.goToFragment(item.beerId, v));
        }

    }
}

