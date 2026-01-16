package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ArchivedStickerSetCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.StickersActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StickersArchiveAlert extends AlertDialog.Builder {
    private int currentType;
    private BaseFragment parentFragment;
    private ArrayList<TLRPC$StickerSetCovered> stickerSets;

    public StickersArchiveAlert(Context context, BaseFragment baseFragment, ArrayList<TLRPC$StickerSetCovered> sets) {
        super(context);
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = sets.get(0);
        if (tLRPC$StickerSetCovered.set.masks) {
            this.currentType = 1;
            setTitle(LocaleController.getString("ArchivedMasksAlertTitle", R.string.ArchivedMasksAlertTitle));
        } else {
            this.currentType = 0;
            setTitle(LocaleController.getString("ArchivedStickersAlertTitle", R.string.ArchivedStickersAlertTitle));
        }
        this.stickerSets = new ArrayList<>(sets);
        this.parentFragment = baseFragment;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        setView(linearLayout);
        TextView textView = new TextView(context);
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        textView.setGravity(LayoutHelper.getAbsoluteGravityStart());
        textView.setTextSize(1, 16.0f);
        textView.setPadding(AndroidUtilities.dp(23.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(23.0f), 0);
        if (tLRPC$StickerSetCovered.set.masks) {
            textView.setText(LocaleController.getString("ArchivedMasksAlertInfo", R.string.ArchivedMasksAlertInfo));
        } else {
            textView.setText(LocaleController.getString("ArchivedStickersAlertInfo", R.string.ArchivedStickersAlertInfo));
        }
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerListView.setAdapter(new ListAdapter(context));
        recyclerListView.setVerticalScrollBarEnabled(false);
        recyclerListView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        recyclerListView.setGlowColor(-657673);
        linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-1, -2, 0.0f, 10.0f, 0.0f, 0.0f));
        setNegativeButton(LocaleController.getString("Close", R.string.Close), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersArchiveAlert$hq1pycbJf9O9dMnRHW2AFIoFfhk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        if (this.parentFragment != null) {
            setPositiveButton(LocaleController.getString("Settings", R.string.Settings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersArchiveAlert$xQgHN9YyXhHK-WtOQysjphvCAOY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$1$StickersArchiveAlert(dialogInterface, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$StickersArchiveAlert(DialogInterface dialogInterface, int i) {
        this.parentFragment.presentFragment(new StickersActivity(this.currentType));
        dialogInterface.dismiss();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        Context context;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StickersArchiveAlert.this.stickerSets.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ArchivedStickerSetCell archivedStickerSetCell = new ArchivedStickerSetCell(this.context, false);
            archivedStickerSetCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(82.0f)));
            return new RecyclerListView.Holder(archivedStickerSetCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ArchivedStickerSetCell) holder.itemView).setStickersSet((TLRPC$StickerSetCovered) StickersArchiveAlert.this.stickerSets.get(position), position != StickersArchiveAlert.this.stickerSets.size() - 1);
        }
    }
}
