package ir.eitaa.ui.Components;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LiveDialogCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HotLiveList extends LinearLayout {
    private List<TLRPC$Chat> chats;
    private int currentAccount;
    private Delegate delegate;
    private RecyclerListView listView;
    private ShadowSectionCell shadowCell;
    private GraySectionCell title;

    public interface Delegate {
        void onClickedItem(TLRPC$Chat chat);
    }

    static /* synthetic */ boolean lambda$new$1(View view, int i) {
        return true;
    }

    public HotLiveList(Context context) {
        super(context);
        this.chats = new ArrayList();
        this.currentAccount = UserConfig.selectedAccount;
        setOrientation(1);
        GraySectionCell graySectionCell = new GraySectionCell(context);
        this.title = graySectionCell;
        graySectionCell.setText(LocaleController.getString("ChatLiveStream", R.string.ChatLiveStream));
        addView(this.title, LayoutHelper.createLinear(-1, -2));
        ShadowSectionCell shadowSectionCell = new ShadowSectionCell(context);
        this.shadowCell = shadowSectionCell;
        shadowSectionCell.setVisibility(0);
        if (this.chats.isEmpty()) {
            this.title.setVisibility(8);
        }
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.Components.HotLiveList.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(0);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setAdapter(new ListAdapter());
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$HotLiveList$EZYI1hJvEU7jzJvjLx0mFXvuS8k
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0$HotLiveList(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$HotLiveList$Vc2VaBz02bZtIrPDQqsZf-2gnlk
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return HotLiveList.lambda$new$1(view, i);
            }
        });
        addView(this.listView, LayoutHelper.createLinear(-1, -2));
        addView(this.shadowCell, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$HotLiveList(View view, int i) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.onClickedItem((TLRPC$Chat) view.getTag());
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(e);
    }

    public void showChats(List<TLRPC$Chat> chats) {
        this.chats.clear();
        if (!chats.isEmpty()) {
            this.chats.addAll(chats);
        }
        this.listView.getAdapter().notifyDataSetChanged();
    }

    public void setTitle(String titleText) {
        if (titleText == null || titleText.isEmpty()) {
            this.title.setText(LocaleController.getString("Ads", R.string.Ads));
        } else {
            this.title.setText(titleText);
        }
    }

    public void setIndex(int value) {
        ((ListAdapter) this.listView.getAdapter()).setIndex(value);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        private ListAdapter() {
        }

        public void setIndex(int value) {
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LiveDialogCell liveDialogCell = new LiveDialogCell(parent.getContext());
            liveDialogCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(80.0f), -2));
            return new RecyclerListView.Holder(liveDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            LiveDialogCell liveDialogCell = (LiveDialogCell) holder.itemView;
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) HotLiveList.this.chats.get(position);
            int i = (int) tLRPC$Chat.id;
            liveDialogCell.setTag(tLRPC$Chat);
            liveDialogCell.setDialog(-i, true, tLRPC$Chat.title);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return HotLiveList.this.chats.size();
        }
    }
}
