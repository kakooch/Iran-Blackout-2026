package ir.resaneh1.iptv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ItemPickerListAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {
    private ArrayList<? extends PresenterItem> areaArrayList;
    private ArrayList<? extends PresenterItem> areaArrayListOrginal;
    Context context;
    View.OnClickListener onItemClickListener;
    OnItemSelectedListener onItemSelectedListener;
    OnStringSelectedListener onStringSelectedListener;
    PickTpye pickTpye;

    enum PickTpye {
        baseItemSingle,
        baseItemMultiple,
        enumSingle
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: ir.resaneh1.iptv.ItemPickerListAdapter.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence != null) {
                    Iterator it = ItemPickerListAdapter.this.areaArrayListOrginal.iterator();
                    while (it.hasNext()) {
                        PresenterItem presenterItem = (PresenterItem) it.next();
                        if (presenterItem.getSearchAbleName().toLowerCase().contains(charSequence.toString())) {
                            arrayList.add(presenterItem);
                        }
                    }
                }
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ItemPickerListAdapter.this.areaArrayList = (ArrayList) filterResults.values;
                ItemPickerListAdapter.this.notifyDataSetChanged();
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        PresenterItem item;
        TextView textViewName;

        public MyViewHolder(View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public ItemPickerListAdapter(Context context, ArrayList<? extends PresenterItem> arrayList, OnItemSelectedListener onItemSelectedListener) {
        this.onItemClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.ItemPickerListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                ItemPickerListAdapter itemPickerListAdapter = ItemPickerListAdapter.this;
                PickTpye pickTpye = itemPickerListAdapter.pickTpye;
                if (pickTpye == PickTpye.baseItemSingle) {
                    itemPickerListAdapter.onItemSelectedListener.onItemSelect(myViewHolder.item);
                } else {
                    if (pickTpye == PickTpye.enumSingle) {
                        itemPickerListAdapter.onStringSelectedListener.onStringSelect(myViewHolder.item.presenterId);
                        return;
                    }
                    myViewHolder.item.presenterIsSelected = !r1.presenterIsSelected;
                    itemPickerListAdapter.bindItemViewHolder(myViewHolder);
                }
            }
        };
        this.context = context;
        this.areaArrayList = arrayList;
        this.areaArrayListOrginal = new ArrayList<>(this.areaArrayList);
        this.onItemSelectedListener = onItemSelectedListener;
        this.pickTpye = PickTpye.baseItemSingle;
    }

    public ItemPickerListAdapter(Context context, ArrayList<? extends PresenterItem> arrayList, OnArrayItemsSelectedListener onArrayItemsSelectedListener) {
        this.onItemClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.ItemPickerListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                ItemPickerListAdapter itemPickerListAdapter = ItemPickerListAdapter.this;
                PickTpye pickTpye = itemPickerListAdapter.pickTpye;
                if (pickTpye == PickTpye.baseItemSingle) {
                    itemPickerListAdapter.onItemSelectedListener.onItemSelect(myViewHolder.item);
                } else {
                    if (pickTpye == PickTpye.enumSingle) {
                        itemPickerListAdapter.onStringSelectedListener.onStringSelect(myViewHolder.item.presenterId);
                        return;
                    }
                    myViewHolder.item.presenterIsSelected = !r1.presenterIsSelected;
                    itemPickerListAdapter.bindItemViewHolder(myViewHolder);
                }
            }
        };
        this.context = context;
        this.areaArrayList = arrayList;
        this.areaArrayListOrginal = new ArrayList<>(this.areaArrayList);
        this.pickTpye = PickTpye.baseItemMultiple;
    }

    public ItemPickerListAdapter(Context context, ArrayList<? extends PresenterItem> arrayList, OnStringSelectedListener onStringSelectedListener) {
        this.onItemClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.ItemPickerListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                ItemPickerListAdapter itemPickerListAdapter = ItemPickerListAdapter.this;
                PickTpye pickTpye = itemPickerListAdapter.pickTpye;
                if (pickTpye == PickTpye.baseItemSingle) {
                    itemPickerListAdapter.onItemSelectedListener.onItemSelect(myViewHolder.item);
                } else {
                    if (pickTpye == PickTpye.enumSingle) {
                        itemPickerListAdapter.onStringSelectedListener.onStringSelect(myViewHolder.item.presenterId);
                        return;
                    }
                    myViewHolder.item.presenterIsSelected = !r1.presenterIsSelected;
                    itemPickerListAdapter.bindItemViewHolder(myViewHolder);
                }
            }
        };
        this.context = context;
        this.areaArrayList = arrayList;
        this.areaArrayListOrginal = new ArrayList<>(this.areaArrayList);
        this.onStringSelectedListener = onStringSelectedListener;
        this.pickTpye = PickTpye.enumSingle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_picker, viewGroup, false);
        viewInflate.setOnClickListener(this.onItemClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        viewInflate.setTag(myViewHolder);
        return myViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.item = this.areaArrayList.get(i);
        bindItemViewHolder(myViewHolder);
    }

    public void bindItemViewHolder(MyViewHolder myViewHolder) {
        myViewHolder.textViewName.setText(myViewHolder.item.getTitle());
        if (myViewHolder.item.presenterIsSelected) {
            myViewHolder.imageView.setVisibility(0);
            myViewHolder.itemView.setBackgroundColor(this.context.getResources().getColor(R.color.selectedRowBackground));
        } else {
            myViewHolder.imageView.setVisibility(4);
            myViewHolder.itemView.setBackgroundColor(this.context.getResources().getColor(R.color.transparent));
        }
    }

    public ArrayList<PresenterItem> getSelectedItems() {
        ArrayList<PresenterItem> arrayList = new ArrayList<>();
        Iterator<? extends PresenterItem> it = this.areaArrayListOrginal.iterator();
        while (it.hasNext()) {
            PresenterItem next = it.next();
            if (next.presenterIsSelected) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.areaArrayList.size();
    }
}
