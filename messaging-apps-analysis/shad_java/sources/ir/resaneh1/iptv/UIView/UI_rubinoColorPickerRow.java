package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class UI_rubinoColorPickerRow {
    ArrayList<Integer> colors;
    private Activity context;
    UI_rubinoColorPickerCell dropper;
    public FrameLayout frameLayout;
    public int itemWidth;
    public SelectColorListener listener;
    RecyclerListView recyclerView;
    public View view;

    public interface SelectColorListener {
        void onSelectColor(int i);

        void onSelectDropper();
    }

    public View createView(Activity activity, ArrayList<Integer> arrayList, int i, int i2, SelectColorListener selectColorListener) {
        this.context = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.listener = selectColorListener;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.colors = arrayList2;
        arrayList2.addAll(arrayList);
        this.itemWidth = ((i2 - 1) / i) - 1;
        RecyclerListView recyclerListView = new RecyclerListView(activity);
        this.recyclerView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(activity, 0, Build.VERSION.SDK_INT < 17));
        this.recyclerView.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        this.recyclerView.setPadding(0, 0, this.itemWidth + AndroidUtilities.dp(3.0f), 0);
        this.recyclerView.setClipToPadding(false);
        this.frameLayout.addView(this.recyclerView, layoutParams);
        this.recyclerView.setAdapter(new ColorPickerAdapter());
        UI_rubinoColorPickerCell uI_rubinoColorPickerCell = new UI_rubinoColorPickerCell();
        this.dropper = uI_rubinoColorPickerCell;
        uI_rubinoColorPickerCell.createView(activity);
        this.dropper.setDropper(-1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.itemWidth + AndroidUtilities.dp(2.0f), this.itemWidth + AndroidUtilities.dp(2.0f));
        layoutParams2.gravity = 5;
        layoutParams2.setMargins(0, 0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        this.frameLayout.addView(this.dropper.view, layoutParams2);
        if (this.listener != null) {
            this.dropper.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoColorPickerRow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UI_rubinoColorPickerRow.this.listener.onSelectDropper();
                }
            });
            this.recyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoColorPickerRow.2
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public void onItemClick(View view, int i3) {
                    UI_rubinoColorPickerRow.this.listener.onSelectColor(((UI_rubinoColorPickerCell) view.getTag()).getColor());
                }
            });
        }
        return this.view;
    }

    public void setSelectedColor(int i) {
        UI_rubinoColorPickerCell uI_rubinoColorPickerCell = this.dropper;
        if (uI_rubinoColorPickerCell == null || uI_rubinoColorPickerCell.view == null) {
            return;
        }
        uI_rubinoColorPickerCell.setDropper(i);
    }

    public class ColorPickerAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ColorPickerAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            UI_rubinoColorPickerCell uI_rubinoColorPickerCell = new UI_rubinoColorPickerCell();
            uI_rubinoColorPickerCell.createView(UI_rubinoColorPickerRow.this.context);
            int i2 = UI_rubinoColorPickerRow.this.itemWidth;
            uI_rubinoColorPickerCell.view.setLayoutParams(new RecyclerView.LayoutParams(i2, i2));
            return new RecyclerListView.Holder(uI_rubinoColorPickerCell.view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((UI_rubinoColorPickerCell) viewHolder.itemView.getTag()).setColor(UI_rubinoColorPickerRow.this.colors.get(i).intValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UI_rubinoColorPickerRow.this.colors.size();
        }
    }
}
