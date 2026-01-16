package ir.iranlms.asemnavideoplayerlibrary.player;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.iranlms.asemnavideoplayerlibrary.player.models.SettingItem;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.util.List;

/* loaded from: classes3.dex */
public class SettingListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Activity mActivity;
    public List<SettingItem> mItemList;
    View.OnClickListener mOnClickListener;
    private View.OnClickListener mOnDeleteClickListener;
    SettingItem selectedItem;
    View selectedView = null;
    View.OnFocusChangeListener itemFocusChangeListener = new View.OnFocusChangeListener(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.SettingListAdapter.1
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewDelete;
        public SettingItem item;
        public TextView title;

        public MyViewHolder(SettingListAdapter settingListAdapter, View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.textViewTitle);
            this.imageViewDelete = (ImageView) view.findViewById(R.id.imageViewDelete);
        }

        public void clearAnimation() {
            this.itemView.clearAnimation();
        }
    }

    public SettingListAdapter(Activity activity, List<SettingItem> list, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.selectedItem = null;
        this.mActivity = activity;
        this.mItemList = list;
        this.mOnClickListener = onClickListener;
        this.mOnDeleteClickListener = onClickListener2;
        for (SettingItem settingItem : list) {
            if (settingItem.isSelected) {
                this.selectedItem = settingItem;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_quality, viewGroup, false);
        viewInflate.setFocusable(true);
        viewInflate.setOnFocusChangeListener(this.itemFocusChangeListener);
        viewInflate.requestFocus();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.SettingListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyLog.e("click", "click");
                SettingListAdapter settingListAdapter = SettingListAdapter.this;
                SettingItem settingItem = settingListAdapter.selectedItem;
                if (settingItem != null) {
                    settingItem.isSelected = false;
                }
                View view2 = settingListAdapter.selectedView;
                if (view2 != null) {
                    ((TextView) view2.findViewById(R.id.textViewTitle)).setTextColor(-1);
                    ((TextView) SettingListAdapter.this.selectedView.findViewById(R.id.textViewTitle)).setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                SettingListAdapter.this.selectedItem = ((MyViewHolder) view.getTag()).item;
                SettingListAdapter settingListAdapter2 = SettingListAdapter.this;
                settingListAdapter2.selectedItem.isSelected = true;
                settingListAdapter2.selectedView = view;
                ((MyViewHolder) view.getTag()).title.setTextColor(SettingListAdapter.this.mActivity.getResources().getColor(R.color.colorPrimaryDark));
                SettingListAdapter.this.mOnClickListener.onClick(view);
            }
        });
        MyViewHolder myViewHolder = new MyViewHolder(this, viewInflate);
        myViewHolder.imageViewDelete.setTag(myViewHolder);
        myViewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.SettingListAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingListAdapter.this.mItemList.remove(((MyViewHolder) view.getTag()).item);
                SettingListAdapter.this.notifyDataSetChanged();
                SettingListAdapter.this.mOnDeleteClickListener.onClick(view);
            }
        });
        viewInflate.setTag(myViewHolder);
        return myViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(MyViewHolder myViewHolder) {
        myViewHolder.clearAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.itemView.setOnKeyListener(new View.OnKeyListener(this) { // from class: ir.iranlms.asemnavideoplayerlibrary.player.SettingListAdapter.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return keyEvent.getAction() == 0 && (i2 == 19 || i2 == 20);
            }
        });
        if (i == 0) {
            myViewHolder.itemView.requestFocus();
        }
        SettingItem settingItem = this.mItemList.get(i);
        myViewHolder.title.setText(settingItem.name);
        myViewHolder.item = settingItem;
        if (settingItem.isSelected) {
            this.selectedView = myViewHolder.itemView;
            myViewHolder.title.setTextColor(this.mActivity.getResources().getColor(R.color.colorPrimaryDark));
        } else {
            myViewHolder.itemView.setAlpha(1.0f);
        }
        if (settingItem.type == SettingItem.SettingType.bookmark) {
            myViewHolder.imageViewDelete.setVisibility(0);
        } else {
            myViewHolder.imageViewDelete.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItemList.size();
    }
}
