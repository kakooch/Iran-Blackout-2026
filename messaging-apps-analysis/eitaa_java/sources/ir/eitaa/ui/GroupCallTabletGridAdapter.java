package ir.eitaa.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.voip.GroupCallGridCell;
import ir.eitaa.ui.Components.voip.GroupCallMiniTextureView;
import ir.eitaa.ui.Components.voip.GroupCallRenderersContainer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupCallTabletGridAdapter extends RecyclerListView.SelectionAdapter {
    private final GroupCallActivity activity;
    private ArrayList<GroupCallMiniTextureView> attachedRenderers;
    private final int currentAccount;
    private ChatObject.Call groupCall;
    private GroupCallRenderersContainer renderersContainer;
    private final ArrayList<ChatObject.VideoParticipant> videoParticipants = new ArrayList<>();
    private boolean visible = false;

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return false;
    }

    public GroupCallTabletGridAdapter(ChatObject.Call groupCall, int currentAccount, GroupCallActivity activity) {
        this.groupCall = groupCall;
        this.currentAccount = currentAccount;
        this.activity = activity;
    }

    public void setRenderersPool(ArrayList<GroupCallMiniTextureView> attachedRenderers, GroupCallRenderersContainer renderersContainer) {
        this.attachedRenderers = attachedRenderers;
        this.renderersContainer = renderersContainer;
    }

    public void setGroupCall(ChatObject.Call groupCall) {
        this.groupCall = groupCall;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerListView.Holder(new GroupCallGridCell(parent.getContext(), true) { // from class: ir.eitaa.ui.GroupCallTabletGridAdapter.1
            @Override // ir.eitaa.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                if (!GroupCallTabletGridAdapter.this.visible || getParticipant() == null) {
                    return;
                }
                GroupCallTabletGridAdapter.this.attachRenderer(this, true);
            }

            @Override // ir.eitaa.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                GroupCallTabletGridAdapter.this.attachRenderer(this, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachRenderer(GroupCallGridCell cell, boolean attach) {
        if (attach && cell.getRenderer() == null) {
            cell.setRenderer(GroupCallMiniTextureView.getOrCreate(this.attachedRenderers, this.renderersContainer, null, null, cell, cell.getParticipant(), this.groupCall, this.activity));
        } else {
            if (attach || cell.getRenderer() == null) {
                return;
            }
            cell.getRenderer().setTabletGridView(null);
            cell.setRenderer(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GroupCallGridCell groupCallGridCell = (GroupCallGridCell) holder.itemView;
        ChatObject.VideoParticipant participant = groupCallGridCell.getParticipant();
        ChatObject.VideoParticipant videoParticipant = this.videoParticipants.get(position);
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.videoParticipants.get(position).participant;
        groupCallGridCell.spanCount = getSpanCount(position);
        groupCallGridCell.position = position;
        groupCallGridCell.gridAdapter = this;
        if (groupCallGridCell.getMeasuredHeight() != getItemHeight(position)) {
            groupCallGridCell.requestLayout();
        }
        AccountInstance accountInstance = AccountInstance.getInstance(this.currentAccount);
        ChatObject.Call call = this.groupCall;
        groupCallGridCell.setData(accountInstance, videoParticipant, call, MessageObject.getPeerId(call.selfPeer));
        if (participant != null && !participant.equals(videoParticipant) && groupCallGridCell.attached && groupCallGridCell.getRenderer() != null) {
            attachRenderer(groupCallGridCell, false);
            attachRenderer(groupCallGridCell, true);
        } else if (groupCallGridCell.getRenderer() != null) {
            groupCallGridCell.getRenderer().updateAttachState(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.videoParticipants.size();
    }

    public void setVisibility(RecyclerListView listView, boolean visibility, boolean updateAttach) {
        this.visible = visibility;
        if (updateAttach) {
            for (int i = 0; i < listView.getChildCount(); i++) {
                View childAt = listView.getChildAt(i);
                if (childAt instanceof GroupCallGridCell) {
                    GroupCallGridCell groupCallGridCell = (GroupCallGridCell) childAt;
                    if (groupCallGridCell.getParticipant() != null) {
                        attachRenderer(groupCallGridCell, visibility);
                    }
                }
            }
        }
    }

    public void update(boolean animated, RecyclerListView listView) {
        if (this.groupCall == null) {
            return;
        }
        if (animated) {
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.videoParticipants);
            this.videoParticipants.clear();
            this.videoParticipants.addAll(this.groupCall.visibleVideoParticipants);
            DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: ir.eitaa.ui.GroupCallTabletGridAdapter.2
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return true;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return arrayList.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return GroupCallTabletGridAdapter.this.videoParticipants.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    if (oldItemPosition >= arrayList.size() || newItemPosition >= GroupCallTabletGridAdapter.this.videoParticipants.size()) {
                        return false;
                    }
                    return ((ChatObject.VideoParticipant) arrayList.get(oldItemPosition)).equals(GroupCallTabletGridAdapter.this.videoParticipants.get(newItemPosition));
                }
            }).dispatchUpdatesTo(this);
            AndroidUtilities.updateVisibleRows(listView);
            return;
        }
        this.videoParticipants.clear();
        this.videoParticipants.addAll(this.groupCall.visibleVideoParticipants);
        notifyDataSetChanged();
    }

    public int getSpanCount(int position) {
        int itemCount = getItemCount();
        if (itemCount > 1 && itemCount != 2) {
            return (itemCount != 3 || position == 0 || position == 1) ? 3 : 6;
        }
        return 6;
    }

    public int getItemHeight(int position) {
        RecyclerListView recyclerListView = this.activity.tabletVideoGridView;
        int itemCount = getItemCount();
        if (itemCount <= 1) {
            return recyclerListView.getMeasuredHeight();
        }
        if (itemCount <= 4) {
            return recyclerListView.getMeasuredHeight() / 2;
        }
        return (int) (recyclerListView.getMeasuredHeight() / 2.5f);
    }
}
