package org.rbmain.ui.Components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Components.ChatAttachAlert;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes5.dex */
public class ChatAttachAlertLiveLayout extends ChatAttachAlert.AttachAlertLayout {
    private boolean ignoreLayout;
    private final LinearLayoutManager layoutManager;
    private final RecyclerListView listView;

    public interface ChatAttachAlertLiveDelegate {
        void onStartLive();
    }

    public ChatAttachAlertLiveLayout(ChatAttachAlert chatAttachAlert, Context context, final ChatAttachAlertLiveDelegate chatAttachAlertLiveDelegate) {
        super(chatAttachAlert, context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(context, 1, false, AndroidUtilities.dp(9.0f), recyclerListView);
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView.setLayoutManager(fillLastLinearLayoutManager);
        recyclerListView.setHorizontalScrollBarEnabled(false);
        recyclerListView.setVerticalScrollBarEnabled(false);
        addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        recyclerListView.setAdapter(new LiveAdapter(context));
        recyclerListView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLiveLayout.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ChatAttachAlertLiveLayout chatAttachAlertLiveLayout = ChatAttachAlertLiveLayout.this;
                chatAttachAlertLiveLayout.parentAlert.updateLayout(chatAttachAlertLiveLayout, true, i2);
            }
        });
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertLiveLayout$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                ChatAttachAlertLiveLayout.lambda$new$0(chatAttachAlertLiveDelegate, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(ChatAttachAlertLiveDelegate chatAttachAlertLiveDelegate, View view, int i) {
        if (i == 1) {
            chatAttachAlertLiveDelegate.onStartLive();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            org.rbmain.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            org.rbmain.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r0 = 1101004800(0x41a00000, float:20.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            r1 = 1
            r2 = 0
            if (r4 <= r0) goto L1e
            r4 = 1090519040(0x41000000, float:8.0)
            int r4 = org.rbmain.messenger.AndroidUtilities.dp(r4)
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r2)
            goto L3c
        L1e:
            boolean r4 = org.rbmain.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L32
            android.graphics.Point r4 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r0 = r4.x
            int r4 = r4.y
            if (r0 <= r4) goto L32
            float r4 = (float) r5
            r5 = 1080033280(0x40600000, float:3.5)
            float r4 = r4 / r5
            int r4 = (int) r4
            goto L37
        L32:
            int r5 = r5 / 5
            int r5 = r5 * 2
            r4 = r5
        L37:
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L3c:
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L4d
            r3.ignoreLayout = r1
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            r5.setPadding(r2, r4, r2, r2)
            r3.ignoreLayout = r2
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlertLiveLayout.onPreMeasure(int, int):void");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return new ArrayList<>();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        this.layoutManager.scrollToPositionWithOffset(0, 0);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.listView.getChildCount() <= 0) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (top < 0 || holder == null || holder.getAdapterPosition() != 0) {
            top = i;
        }
        return top + AndroidUtilities.dp(12.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(4.0f);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    private static class LiveAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        private void updatePositions() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 0;
            }
            return i == 1 ? 1 : 2;
        }

        public LiveAdapter(Context context) {
            int i = UserConfig.selectedAccount;
            this.mContext = context;
            updatePositions();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 0) {
                view = new HeaderCell(this.mContext);
            } else if (i == 1) {
                view = new SharedDocumentCell(this.mContext);
            } else {
                view = new View(this.mContext);
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i == 0) {
                ((HeaderCell) viewHolder.itemView).setText("Live");
            } else if (i == 1) {
                ((SharedDocumentCell) viewHolder.itemView).setTextAndValueAndTypeAndThumb(LocaleController.getString("StartLiveTitle", R.string.StartLiveTitle), LocaleController.getString("StartLiveDes", R.string.StartLiveDes), null, null, R.drawable.ic_broadcast, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updatePositions();
            super.notifyDataSetChanged();
        }
    }
}
