package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MessagesSearchAdapter extends RecyclerListView.SelectionAdapter {
    private Context mContext;
    private final Theme.ResourcesProvider resourcesProvider;
    private ArrayList<MessageObject> searchResultMessages = new ArrayList<>();
    private int currentAccount = UserConfig.selectedAccount;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MessagesSearchAdapter(Context context, Theme.ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyDataSetChanged() {
        this.searchResultMessages = MediaDataController.getInstance(this.currentAccount).getFoundMessageObjects();
        super.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.searchResultMessages.size();
    }

    public Object getItem(int i) {
        if (i < 0 || i >= this.searchResultMessages.size()) {
            return null;
        }
        return this.searchResultMessages.get(i);
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return holder.getItemViewType() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View dialogCell;
        if (viewType == 0) {
            dialogCell = new DialogCell(null, this.mContext, false, true, this.currentAccount, this.resourcesProvider);
        } else {
            dialogCell = viewType != 1 ? null : new LoadingCell(this.mContext);
        }
        dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new RecyclerListView.Holder(dialogCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            DialogCell dialogCell = (DialogCell) holder.itemView;
            dialogCell.useSeparator = true;
            MessageObject messageObject = (MessageObject) getItem(position);
            dialogCell.setDialog(messageObject.getDialogId(), messageObject, messageObject.messageOwner.date, true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i < this.searchResultMessages.size() ? 0 : 1;
    }
}
