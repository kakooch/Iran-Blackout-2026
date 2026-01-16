package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class UI_rubinoEmojiPickerRow {
    private Activity context;
    CharSequence[] emojiChars;
    public FrameLayout frameLayout;
    public int itemWidth;
    public SelectEmojiListener listener;
    RecyclerListView recyclerView;
    public View view;

    public interface SelectEmojiListener {
        void onSelectColor(CharSequence charSequence);
    }

    public View createView(Activity activity, CharSequence[] charSequenceArr, int i, int i2, SelectEmojiListener selectEmojiListener) {
        this.context = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.listener = selectEmojiListener;
        this.emojiChars = charSequenceArr;
        this.itemWidth = ((i2 - 1) / i) - 1;
        RecyclerListView recyclerListView = new RecyclerListView(activity);
        this.recyclerView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(activity, 0, Build.VERSION.SDK_INT < 17));
        this.recyclerView.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        this.recyclerView.setPadding(0, 0, AndroidUtilities.dp(3.0f), 0);
        this.recyclerView.setClipToPadding(false);
        this.frameLayout.addView(this.recyclerView, layoutParams);
        this.recyclerView.setAdapter(new PickerAdapter());
        if (this.listener != null) {
            this.recyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoEmojiPickerRow.1
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public void onItemClick(View view, int i3) {
                    UI_rubinoEmojiPickerRow.this.listener.onSelectColor(((UI_rubinoEmojiPickerCell) view).getEmojiChar());
                }
            });
        }
        return this.view;
    }

    public class PickerAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public PickerAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            UI_rubinoEmojiPickerCell uI_rubinoEmojiPickerCell = new UI_rubinoEmojiPickerCell(UI_rubinoEmojiPickerRow.this.context);
            int i2 = UI_rubinoEmojiPickerRow.this.itemWidth;
            uI_rubinoEmojiPickerCell.setLayoutParams(new RecyclerView.LayoutParams(i2, i2));
            return new RecyclerListView.Holder(uI_rubinoEmojiPickerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((UI_rubinoEmojiPickerCell) viewHolder.itemView).setEmoji(UI_rubinoEmojiPickerRow.this.emojiChars[i]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UI_rubinoEmojiPickerRow.this.emojiChars.length;
        }
    }
}
