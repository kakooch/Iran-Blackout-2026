package ir.eitaa.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_reorderStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.RadioColorCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.StickerSetCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ReorderingBulletinLayout;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.StickersAlert;
import ir.eitaa.ui.Components.TrendingStickersAlert;
import ir.eitaa.ui.Components.TrendingStickersLayout;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class StickersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int activeReorderingRequests;
    private ActionBarMenuItem archiveMenuItem;
    private int archivedInfoRow;
    private int archivedRow;
    private final int currentType;
    private ActionBarMenuItem deleteMenuItem;
    private int featuredRow;
    private DefaultItemAnimator itemAnimator;
    private ItemTouchHelper itemTouchHelper;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int loopInfoRow;
    private int loopRow;
    private int masksInfoRow;
    private int masksRow;
    private boolean needReorder;
    private int rowCount;
    private NumberTextView selectedCountTextView;
    private ActionBarMenuItem shareMenuItem;
    private int stickersBotInfo;
    private int stickersEndRow;
    private int stickersShadowRow;
    private int stickersStartRow;
    private int suggestRow;
    private TrendingStickersAlert trendingStickersAlert;

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }

        public TouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return StickersActivity.this.listAdapter.hasSelected();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 0) {
                return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            if (source.getItemViewType() != target.getItemViewType()) {
                return false;
            }
            StickersActivity.this.listAdapter.swapElements(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState == 0) {
                StickersActivity.this.sendReorder();
            } else {
                StickersActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    public StickersActivity(int type) {
        this.currentType = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        MediaDataController.getInstance(this.currentAccount).checkStickers(this.currentType);
        if (this.currentType == 0) {
            MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers();
            MediaDataController.getInstance(this.currentAccount).checkStickers(1);
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.archivedStickersCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.featuredStickersDidLoad);
        updateRows();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.archivedStickersCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.featuredStickersDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("StickersName", R.string.StickersName));
        } else {
            this.actionBar.setTitle(LocaleController.getString("Masks", R.string.Masks));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.StickersActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (StickersActivity.this.onBackPressed()) {
                        StickersActivity.this.finishFragment();
                    }
                } else if (id == 0 || id == 1 || id == 2) {
                    if (!StickersActivity.this.needReorder) {
                        if (StickersActivity.this.activeReorderingRequests == 0) {
                            StickersActivity.this.listAdapter.processSelectionMenu(id);
                            return;
                        }
                        return;
                    }
                    StickersActivity.this.sendReorder();
                }
            }
        });
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode();
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.selectedCountTextView.setTextColor(Theme.getColor("actionBarActionModeDefaultIcon"));
        actionBarMenuCreateActionMode.addView(this.selectedCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$FKNOPUlXyZRyiWWkV5S3GScaCvg
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return StickersActivity.lambda$createView$0(view, motionEvent);
            }
        });
        this.shareMenuItem = actionBarMenuCreateActionMode.addItemWithWidth(2, R.drawable.msg_share, AndroidUtilities.dp(54.0f));
        this.archiveMenuItem = actionBarMenuCreateActionMode.addItemWithWidth(0, R.drawable.msg_archive, AndroidUtilities.dp(54.0f));
        this.deleteMenuItem = actionBarMenuCreateActionMode.addItemWithWidth(1, R.drawable.msg_delete, AndroidUtilities.dp(54.0f));
        this.listAdapter = new ListAdapter(context, MediaDataController.getInstance(this.currentAccount).getStickerSets(this.currentType));
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFocusable(true);
        this.listView.setTag(7);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.StickersActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
                extraLayoutSpace[1] = StickersActivity.this.listView.getHeight();
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchHelperCallback());
        this.itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.listView);
        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) this.listView.getItemAnimator();
        this.itemAnimator = defaultItemAnimator;
        defaultItemAnimator.setSupportsChangeAnimations(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$JAL1cVz-cL-BhJL7rahna4H-cZ8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$2$StickersActivity(context, view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$OfsRCm8RTDw5Ahf1XrgG2BAfXfo
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$3$StickersActivity(view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$StickersActivity(Context context, View view, int i) {
        if (i >= this.stickersStartRow && i < this.stickersEndRow && getParentActivity() != null) {
            if (this.listAdapter.hasSelected()) {
                this.listAdapter.toggleSelected(i);
                return;
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) this.listAdapter.stickerSets.get(i - this.stickersStartRow);
            ArrayList<TLRPC$Document> arrayList = tLRPC$TL_messages_stickerSet.documents;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            showDialog(new StickersAlert(getParentActivity(), this, (TLRPC$InputStickerSet) null, tLRPC$TL_messages_stickerSet, (StickersAlert.StickersAlertDelegate) null));
            return;
        }
        if (i == this.featuredRow) {
            TrendingStickersAlert trendingStickersAlert = new TrendingStickersAlert(context, this, new TrendingStickersLayout(context, new TrendingStickersLayout.Delegate() { // from class: ir.eitaa.ui.StickersActivity.3
                @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet, boolean primary) {
                    MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), stickerSet, 2, StickersActivity.this, false, false);
                }

                @Override // ir.eitaa.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet) {
                    MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), stickerSet, 0, StickersActivity.this, false, false);
                }
            }), null);
            this.trendingStickersAlert = trendingStickersAlert;
            trendingStickersAlert.show();
            return;
        }
        if (i == this.archivedRow) {
            presentFragment(new ArchivedStickersActivity(this.currentType));
            return;
        }
        if (i == this.masksRow) {
            presentFragment(new StickersActivity(1));
            return;
        }
        if (i == this.suggestRow) {
            if (getParentActivity() == null) {
                return;
            }
            final AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("SuggestStickers", R.string.SuggestStickers));
            String[] strArr = {LocaleController.getString("SuggestStickersAll", R.string.SuggestStickersAll), LocaleController.getString("SuggestStickersInstalled", R.string.SuggestStickersInstalled), LocaleController.getString("SuggestStickersNone", R.string.SuggestStickersNone)};
            LinearLayout linearLayout = new LinearLayout(getParentActivity());
            linearLayout.setOrientation(1);
            builder.setView(linearLayout);
            int i2 = 0;
            while (i2 < 3) {
                RadioColorCell radioColorCell = new RadioColorCell(getParentActivity());
                radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                radioColorCell.setTag(Integer.valueOf(i2));
                radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
                radioColorCell.setTextAndValue(strArr[i2], SharedConfig.suggestStickers == i2);
                linearLayout.addView(radioColorCell);
                radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$MIZZpNmHywXqltTACEUQ9JjLLnY
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.lambda$createView$1$StickersActivity(builder, view2);
                    }
                });
                i2++;
            }
            showDialog(builder.create());
            return;
        }
        if (i == this.loopRow) {
            SharedConfig.toggleLoopStickers();
            this.listAdapter.notifyItemChanged(this.loopRow, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$StickersActivity(AlertDialog.Builder builder, View view) {
        SharedConfig.setSuggestStickers(((Integer) view.getTag()).intValue());
        this.listAdapter.notifyItemChanged(this.suggestRow);
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$3$StickersActivity(View view, int i) {
        if (this.listAdapter.hasSelected() || i < this.stickersStartRow || i >= this.stickersEndRow) {
            return false;
        }
        this.listAdapter.toggleSelected(i);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.listAdapter.hasSelected()) {
            this.listAdapter.clearSelected();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.stickersDidLoad) {
            int iIntValue = ((Integer) args[0]).intValue();
            int i = this.currentType;
            if (iIntValue == i) {
                updateRows();
                return;
            } else {
                if (i == 0 && iIntValue == 1) {
                    this.listAdapter.notifyItemChanged(this.masksRow);
                    return;
                }
                return;
            }
        }
        if (id == NotificationCenter.featuredStickersDidLoad) {
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyItemChanged(0);
                return;
            }
            return;
        }
        if (id == NotificationCenter.archivedStickersCountDidLoad && ((Integer) args[0]).intValue() == this.currentType) {
            updateRows();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReorder() {
        if (this.needReorder) {
            MediaDataController.getInstance(this.currentAccount).calcNewHash(this.currentType);
            this.needReorder = false;
            this.activeReorderingRequests++;
            TLRPC$TL_messages_reorderStickerSets tLRPC$TL_messages_reorderStickerSets = new TLRPC$TL_messages_reorderStickerSets();
            tLRPC$TL_messages_reorderStickerSets.masks = this.currentType == 1;
            for (int i = 0; i < this.listAdapter.stickerSets.size(); i++) {
                tLRPC$TL_messages_reorderStickerSets.order.add(Long.valueOf(((TLRPC$TL_messages_stickerSet) this.listAdapter.stickerSets.get(i)).set.id));
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_reorderStickerSets, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$47mJQXM9CxVHOaywML7WQFQzXCc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendReorder$5$StickersActivity(tLObject, tLRPC$TL_error);
                }
            });
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.stickersDidLoad, Integer.valueOf(this.currentType));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendReorder$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendReorder$4$StickersActivity() {
        this.activeReorderingRequests--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendReorder$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendReorder$5$StickersActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$mxfOzoC4qIn7Xr7TaEzLkgY1cBo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendReorder$4$StickersActivity();
            }
        });
    }

    private void updateRows() {
        MediaDataController mediaDataController = MediaDataController.getInstance(this.currentAccount);
        final ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = mediaDataController.getStickerSets(this.currentType);
        if (this.listAdapter != null) {
            diffResultCalculateDiff = this.isPaused ? null : DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: ir.eitaa.ui.StickersActivity.4
                final List<TLRPC$TL_messages_stickerSet> oldList;

                {
                    this.oldList = StickersActivity.this.listAdapter.stickerSets;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.oldList.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return stickerSets.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return this.oldList.get(oldItemPosition).set.id == ((TLRPC$TL_messages_stickerSet) stickerSets.get(newItemPosition)).set.id;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    TLRPC$StickerSet tLRPC$StickerSet = this.oldList.get(oldItemPosition).set;
                    TLRPC$StickerSet tLRPC$StickerSet2 = ((TLRPC$TL_messages_stickerSet) stickerSets.get(newItemPosition)).set;
                    return TextUtils.equals(tLRPC$StickerSet.title, tLRPC$StickerSet2.title) && tLRPC$StickerSet.count == tLRPC$StickerSet2.count;
                }
            });
            this.listAdapter.setStickerSets(stickerSets);
        }
        this.rowCount = 0;
        int i = this.currentType;
        if (i == 0) {
            int i2 = 0 + 1;
            this.rowCount = i2;
            this.suggestRow = 0;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.loopRow = i2;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.loopInfoRow = i3;
            this.rowCount = i4 + 1;
            this.featuredRow = i4;
        } else {
            this.suggestRow = -1;
            this.loopRow = -1;
            this.loopInfoRow = -1;
            this.featuredRow = -1;
        }
        if (mediaDataController.getArchivedStickersCount(i) != 0) {
            boolean z = this.archivedRow == -1;
            int i5 = this.rowCount;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.archivedRow = i5;
            if (this.currentType == 1) {
                this.rowCount = i6 + 1;
            } else {
                i6 = -1;
            }
            this.archivedInfoRow = i6;
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null && z) {
                listAdapter.notifyItemRangeInserted(i5, i6 == -1 ? 1 : 2);
            }
        } else {
            int i7 = this.archivedRow;
            int i8 = this.archivedInfoRow;
            this.archivedRow = -1;
            this.archivedInfoRow = -1;
            ListAdapter listAdapter2 = this.listAdapter;
            if (listAdapter2 != null && i7 != -1) {
                listAdapter2.notifyItemRangeRemoved(i7, i8 == -1 ? 1 : 2);
            }
        }
        if (this.currentType == 0) {
            int i9 = this.rowCount;
            int i10 = i9 + 1;
            this.rowCount = i10;
            this.masksRow = i9;
            this.rowCount = i10 + 1;
            this.stickersBotInfo = i10;
        } else {
            this.masksRow = -1;
            this.stickersBotInfo = -1;
        }
        int size = stickerSets.size();
        if (size > 0) {
            int i11 = this.rowCount;
            this.stickersStartRow = i11;
            int i12 = i11 + size;
            this.rowCount = i12;
            this.stickersEndRow = i12;
            if (this.currentType != 1) {
                this.rowCount = i12 + 1;
                this.stickersShadowRow = i12;
                this.masksInfoRow = -1;
            } else {
                this.rowCount = i12 + 1;
                this.masksInfoRow = i12;
                this.stickersShadowRow = -1;
            }
        } else {
            this.stickersStartRow = -1;
            this.stickersEndRow = -1;
            this.stickersShadowRow = -1;
            this.masksInfoRow = -1;
        }
        ListAdapter listAdapter3 = this.listAdapter;
        if (listAdapter3 == null || diffResultCalculateDiff == null) {
            return;
        }
        final int i13 = this.stickersStartRow;
        if (i13 < 0) {
            i13 = this.rowCount;
        }
        listAdapter3.notifyItemRangeChanged(0, i13);
        diffResultCalculateDiff.dispatchUpdatesTo(new ListUpdateCallback() { // from class: ir.eitaa.ui.StickersActivity.5
            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onMoved(int fromPosition, int toPosition) {
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onInserted(int position, int count) {
                StickersActivity.this.listAdapter.notifyItemRangeInserted(i13 + position, count);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onRemoved(int position, int count) {
                StickersActivity.this.listAdapter.notifyItemRangeRemoved(i13 + position, count);
            }

            @Override // androidx.recyclerview.widget.ListUpdateCallback
            public void onChanged(int position, int count, Object payload) {
                StickersActivity.this.listAdapter.notifyItemRangeChanged(i13 + position, count);
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private final LongSparseArray<Boolean> selectedItems = new LongSparseArray<>();
        private final List<TLRPC$TL_messages_stickerSet> stickerSets;

        public ListAdapter(Context context, List<TLRPC$TL_messages_stickerSet> stickerSets) {
            ArrayList arrayList = new ArrayList();
            this.stickerSets = arrayList;
            this.mContext = context;
            arrayList.addAll(stickerSets);
        }

        public void setStickerSets(List<TLRPC$TL_messages_stickerSet> stickerSets) {
            this.stickerSets.clear();
            this.stickerSets.addAll(stickerSets);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StickersActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            if (i < StickersActivity.this.stickersStartRow || i >= StickersActivity.this.stickersEndRow) {
                if (i == StickersActivity.this.suggestRow || i == StickersActivity.this.loopInfoRow || i == StickersActivity.this.archivedRow || i == StickersActivity.this.archivedInfoRow || i == StickersActivity.this.featuredRow || i == StickersActivity.this.stickersBotInfo || i == StickersActivity.this.masksRow) {
                    return -2147483648L;
                }
                return i;
            }
            return this.stickerSets.get(i - StickersActivity.this.stickersStartRow).set.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processSelectionMenu(final int which) {
            String string;
            TextView textView;
            int i = 0;
            if (which == 2) {
                StringBuilder sb = new StringBuilder();
                int size = this.stickerSets.size();
                while (i < size) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSets.get(i);
                    if (this.selectedItems.get(tLRPC$TL_messages_stickerSet.set.id, Boolean.FALSE).booleanValue()) {
                        if (sb.length() != 0) {
                            sb.append("\n");
                        }
                        sb.append(StickersActivity.this.getLinkForSet(tLRPC$TL_messages_stickerSet));
                    }
                    i++;
                }
                String string2 = sb.toString();
                ShareAlert shareAlertCreateShareAlert = ShareAlert.createShareAlert(((BaseFragment) StickersActivity.this).fragmentView.getContext(), null, string2, false, string2, false);
                shareAlertCreateShareAlert.setDelegate(new ShareAlert.ShareAlertDelegate() { // from class: ir.eitaa.ui.StickersActivity.ListAdapter.1
                    @Override // ir.eitaa.ui.Components.ShareAlert.ShareAlertDelegate
                    public void didShare() {
                        ListAdapter.this.clearSelected();
                    }

                    @Override // ir.eitaa.ui.Components.ShareAlert.ShareAlertDelegate
                    public boolean didCopy() {
                        ListAdapter.this.clearSelected();
                        return true;
                    }
                });
                shareAlertCreateShareAlert.show();
                return;
            }
            if (which == 0 || which == 1) {
                final ArrayList arrayList = new ArrayList(this.selectedItems.size());
                int size2 = this.stickerSets.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    TLRPC$StickerSet tLRPC$StickerSet = this.stickerSets.get(i2).set;
                    if (this.selectedItems.get(tLRPC$StickerSet.id, Boolean.FALSE).booleanValue()) {
                        arrayList.add(tLRPC$StickerSet);
                    }
                }
                int size3 = arrayList.size();
                if (size3 != 0) {
                    if (size3 == 1) {
                        int size4 = this.stickerSets.size();
                        while (true) {
                            if (i >= size4) {
                                break;
                            }
                            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = this.stickerSets.get(i);
                            if (this.selectedItems.get(tLRPC$TL_messages_stickerSet2.set.id, Boolean.FALSE).booleanValue()) {
                                processSelectionOption(which, tLRPC$TL_messages_stickerSet2);
                                break;
                            }
                            i++;
                        }
                        StickersActivity.this.listAdapter.clearSelected();
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(StickersActivity.this.getParentActivity());
                    if (which == 1) {
                        builder.setTitle(LocaleController.formatString("DeleteStickerSetsAlertTitle", R.string.DeleteStickerSetsAlertTitle, LocaleController.formatPluralString("StickerSets", size3)));
                        builder.setMessage(LocaleController.formatString("DeleteStickersAlertMessage", R.string.DeleteStickersAlertMessage, Integer.valueOf(size3)));
                        string = LocaleController.getString("Delete", R.string.Delete);
                    } else {
                        builder.setTitle(LocaleController.formatString("ArchiveStickerSetsAlertTitle", R.string.ArchiveStickerSetsAlertTitle, LocaleController.formatPluralString("StickerSets", size3)));
                        builder.setMessage(LocaleController.formatString("ArchiveStickersAlertMessage", R.string.ArchiveStickersAlertMessage, Integer.valueOf(size3)));
                        string = LocaleController.getString("Archive", R.string.Archive);
                    }
                    builder.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$ListAdapter$hGfObfpIYhaGj05U8IN5B4DV7vk
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.f$0.lambda$processSelectionMenu$0$StickersActivity$ListAdapter(arrayList, which, dialogInterface, i3);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate = builder.create();
                    StickersActivity.this.showDialog(alertDialogCreate);
                    if (which != 1 || (textView = (TextView) alertDialogCreate.getButton(-1)) == null) {
                        return;
                    }
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSelectionMenu$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSelectionMenu$0$StickersActivity$ListAdapter(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
            StickersActivity.this.listAdapter.clearSelected();
            MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSets(arrayList, StickersActivity.this.currentType, i == 1 ? 0 : 1, StickersActivity.this, true);
        }

        private void processSelectionOption(int which, TLRPC$TL_messages_stickerSet stickerSet) {
            int iIndexOf;
            if (which == 0) {
                MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), stickerSet, !stickerSet.set.archived ? 1 : 2, StickersActivity.this, true, true);
                return;
            }
            if (which == 1) {
                MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), stickerSet, 0, StickersActivity.this, true, true);
                return;
            }
            if (which == 2) {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", StickersActivity.this.getLinkForSet(stickerSet));
                    StickersActivity.this.getParentActivity().startActivityForResult(Intent.createChooser(intent, LocaleController.getString("StickersShare", R.string.StickersShare)), 500);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (which != 3) {
                if (which != 4 || (iIndexOf = this.stickerSets.indexOf(stickerSet)) < 0) {
                    return;
                }
                StickersActivity.this.listAdapter.toggleSelected(StickersActivity.this.stickersStartRow + iIndexOf);
                return;
            }
            try {
                ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", String.format(Locale.US, "https://" + MessagesController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).linkPrefix + "/addstickers/%s", stickerSet.set.short_name)));
                BulletinFactory.createCopyLinkBulletin(StickersActivity.this).show();
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                int i = position - StickersActivity.this.stickersStartRow;
                StickerSetCell stickerSetCell = (StickerSetCell) holder.itemView;
                stickerSetCell.setStickersSet(this.stickerSets.get(i), i != this.stickerSets.size() - 1);
                stickerSetCell.setChecked(this.selectedItems.get(getItemId(position), Boolean.FALSE).booleanValue(), false);
                stickerSetCell.setReorderable(hasSelected(), false);
                return;
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position != StickersActivity.this.stickersBotInfo) {
                    if (position == StickersActivity.this.archivedInfoRow) {
                        if (StickersActivity.this.currentType == 0) {
                            textInfoPrivacyCell.setText(LocaleController.getString("ArchivedStickersInfo", R.string.ArchivedStickersInfo));
                            return;
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("ArchivedMasksInfo", R.string.ArchivedMasksInfo));
                            return;
                        }
                    }
                    if (position != StickersActivity.this.loopInfoRow) {
                        if (position == StickersActivity.this.masksInfoRow) {
                            textInfoPrivacyCell.setText(LocaleController.getString("MasksInfo", R.string.MasksInfo));
                            return;
                        }
                        return;
                    }
                    textInfoPrivacyCell.setText(LocaleController.getString("LoopAnimatedStickersInfo", R.string.LoopAnimatedStickersInfo));
                    return;
                }
                textInfoPrivacyCell.setText(addStickersBotSpan(LocaleController.getString("StickersBotInfo", R.string.StickersBotInfo)));
                return;
            }
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    if (itemViewType == 4 && position == StickersActivity.this.loopRow) {
                        ((TextCheckCell) holder.itemView).setTextAndCheck(LocaleController.getString("LoopAnimatedStickers", R.string.LoopAnimatedStickers), SharedConfig.loopStickers, true);
                        return;
                    }
                    return;
                }
                if (position == StickersActivity.this.stickersShadowRow) {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                return;
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            if (position == StickersActivity.this.featuredRow) {
                int size = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).getFeaturedStickerSets().size();
                textSettingsCell.setTextAndValue(LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers), size > 0 ? Integer.toString(size) : "", true);
                return;
            }
            if (position == StickersActivity.this.archivedRow) {
                int archivedStickersCount = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).getArchivedStickersCount(StickersActivity.this.currentType);
                String string2 = archivedStickersCount > 0 ? Integer.toString(archivedStickersCount) : "";
                if (StickersActivity.this.currentType == 0) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("ArchivedStickers", R.string.ArchivedStickers), string2, true);
                    return;
                } else {
                    textSettingsCell.setTextAndValue(LocaleController.getString("ArchivedMasks", R.string.ArchivedMasks), string2, true);
                    return;
                }
            }
            if (position == StickersActivity.this.masksRow) {
                MediaDataController mediaDataController = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount);
                int size2 = mediaDataController.getStickerSets(1).size() + mediaDataController.getArchivedStickersCount(1);
                textSettingsCell.setTextAndValue(LocaleController.getString("Masks", R.string.Masks), size2 > 0 ? Integer.toString(size2) : "", false);
            } else if (position == StickersActivity.this.suggestRow) {
                int i2 = SharedConfig.suggestStickers;
                if (i2 == 0) {
                    string = LocaleController.getString("SuggestStickersAll", R.string.SuggestStickersAll);
                } else if (i2 == 1) {
                    string = LocaleController.getString("SuggestStickersInstalled", R.string.SuggestStickersInstalled);
                } else {
                    string = LocaleController.getString("SuggestStickersNone", R.string.SuggestStickersNone);
                }
                textSettingsCell.setTextAndValue(LocaleController.getString("SuggestStickers", R.string.SuggestStickers), string, true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
            if (payloads.isEmpty()) {
                onBindViewHolder(holder, position);
                return;
            }
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                if (position < StickersActivity.this.stickersStartRow || position >= StickersActivity.this.stickersEndRow) {
                    return;
                }
                StickerSetCell stickerSetCell = (StickerSetCell) holder.itemView;
                if (payloads.contains(1)) {
                    stickerSetCell.setChecked(this.selectedItems.get(getItemId(position), Boolean.FALSE).booleanValue());
                }
                if (payloads.contains(2)) {
                    stickerSetCell.setReorderable(hasSelected());
                }
                if (payloads.contains(3)) {
                    stickerSetCell.setNeedDivider(position - StickersActivity.this.stickersStartRow != this.stickerSets.size() - 1);
                    return;
                }
                return;
            }
            if (itemViewType == 4 && payloads.contains(0) && position == StickersActivity.this.loopRow) {
                ((TextCheckCell) holder.itemView).setChecked(SharedConfig.loopStickers);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2 || itemViewType == 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$1$StickersActivity$ListAdapter(StickerSetCell stickerSetCell, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            StickersActivity.this.itemTouchHelper.startDrag(StickersActivity.this.listView.getChildViewHolder(stickerSetCell));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$3$StickersActivity$ListAdapter(View view) {
            int[] iArr;
            final int[] iArr2;
            CharSequence[] charSequenceArr;
            final TLRPC$TL_messages_stickerSet stickersSet = ((StickerSetCell) view.getParent()).getStickersSet();
            AlertDialog.Builder builder = new AlertDialog.Builder(StickersActivity.this.getParentActivity());
            builder.setTitle(stickersSet.set.title);
            if (stickersSet.set.official) {
                iArr2 = new int[]{0, 4};
                charSequenceArr = new CharSequence[]{LocaleController.getString("StickersHide", R.string.StickersHide), LocaleController.getString("StickersReorder", R.string.StickersReorder)};
                iArr = new int[]{R.drawable.msg_archive, R.drawable.msg_reorder};
            } else {
                CharSequence[] charSequenceArr2 = {LocaleController.getString("StickersHide", R.string.StickersHide), LocaleController.getString("StickersCopy", R.string.StickersCopy), LocaleController.getString("StickersReorder", R.string.StickersReorder), LocaleController.getString("StickersShare", R.string.StickersShare), LocaleController.getString("StickersRemove", R.string.StickersRemove)};
                iArr = new int[]{R.drawable.msg_archive, R.drawable.msg_link, R.drawable.msg_reorder, R.drawable.msg_share, R.drawable.msg_delete};
                iArr2 = new int[]{0, 3, 4, 2, 1};
                charSequenceArr = charSequenceArr2;
            }
            builder.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$ListAdapter$RoVOmJa7zeGZ4tkJ_hbXzoAtobY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateViewHolder$2$StickersActivity$ListAdapter(iArr2, stickersSet, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            StickersActivity.this.showDialog(alertDialogCreate);
            if (iArr2[iArr2.length - 1] == 1) {
                alertDialogCreate.setItemColor(charSequenceArr.length - 1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$2$StickersActivity$ListAdapter(int[] iArr, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, DialogInterface dialogInterface, int i) {
            processSelectionOption(iArr[i], tLRPC$TL_messages_stickerSet);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"ClickableViewAccessibility"})
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textInfoPrivacyCell;
            if (viewType == 0) {
                final StickerSetCell stickerSetCell = new StickerSetCell(this.mContext, 1);
                stickerSetCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                stickerSetCell.setOnReorderButtonTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$ListAdapter$niHjr6ID9nCPLS8j9nwWizYgRTw
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$onCreateViewHolder$1$StickersActivity$ListAdapter(stickerSetCell, view, motionEvent);
                    }
                });
                stickerSetCell.setOnOptionsClick(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$StickersActivity$ListAdapter$UhKlztpC35Ls2MTVFESZHjgO0Dk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$3$StickersActivity$ListAdapter(view);
                    }
                });
                textInfoPrivacyCell = stickerSetCell;
            } else if (viewType == 1) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            } else if (viewType == 2) {
                textInfoPrivacyCell = new TextSettingsCell(this.mContext);
                textInfoPrivacyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 3) {
                textInfoPrivacyCell = new ShadowSectionCell(this.mContext);
            } else {
                textInfoPrivacyCell = new TextCheckCell(this.mContext);
                textInfoPrivacyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
            textInfoPrivacyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= StickersActivity.this.stickersStartRow && i < StickersActivity.this.stickersEndRow) {
                return 0;
            }
            if (i == StickersActivity.this.stickersBotInfo || i == StickersActivity.this.archivedInfoRow || i == StickersActivity.this.loopInfoRow || i == StickersActivity.this.masksInfoRow) {
                return 1;
            }
            if (i == StickersActivity.this.featuredRow || i == StickersActivity.this.archivedRow || i == StickersActivity.this.masksRow || i == StickersActivity.this.suggestRow) {
                return 2;
            }
            if (i == StickersActivity.this.stickersShadowRow) {
                return 3;
            }
            return i == StickersActivity.this.loopRow ? 4 : 0;
        }

        public void swapElements(int fromIndex, int toIndex) {
            if (fromIndex != toIndex) {
                StickersActivity.this.needReorder = true;
            }
            MediaDataController mediaDataController = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount);
            int i = fromIndex - StickersActivity.this.stickersStartRow;
            int i2 = toIndex - StickersActivity.this.stickersStartRow;
            swapListElements(this.stickerSets, i, i2);
            swapListElements(mediaDataController.getStickerSets(StickersActivity.this.currentType), i, i2);
            notifyItemMoved(fromIndex, toIndex);
            if (fromIndex == StickersActivity.this.stickersEndRow - 1 || toIndex == StickersActivity.this.stickersEndRow - 1) {
                notifyItemRangeChanged(fromIndex, 3);
                notifyItemRangeChanged(toIndex, 3);
            }
        }

        private void swapListElements(List<TLRPC$TL_messages_stickerSet> list, int index1, int index2) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, tLRPC$TL_messages_stickerSet);
        }

        public void toggleSelected(int position) {
            long itemId = getItemId(position);
            this.selectedItems.put(itemId, Boolean.valueOf(!r2.get(itemId, Boolean.FALSE).booleanValue()));
            notifyItemChanged(position, 1);
            checkActionMode();
        }

        public void clearSelected() {
            this.selectedItems.clear();
            notifyStickersItemsChanged(1);
            checkActionMode();
        }

        public boolean hasSelected() {
            return this.selectedItems.indexOfValue(Boolean.TRUE) != -1;
        }

        public int getSelectedCount() {
            int size = this.selectedItems.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (this.selectedItems.valueAt(i2).booleanValue()) {
                    i++;
                }
            }
            return i;
        }

        private void checkActionMode() {
            int selectedCount = StickersActivity.this.listAdapter.getSelectedCount();
            boolean zIsActionModeShowed = ((BaseFragment) StickersActivity.this).actionBar.isActionModeShowed();
            if (selectedCount <= 0) {
                if (zIsActionModeShowed) {
                    ((BaseFragment) StickersActivity.this).actionBar.hideActionMode();
                    notifyStickersItemsChanged(2);
                    return;
                }
                return;
            }
            checkActionModeIcons();
            StickersActivity.this.selectedCountTextView.setNumber(selectedCount, zIsActionModeShowed);
            if (zIsActionModeShowed) {
                return;
            }
            ((BaseFragment) StickersActivity.this).actionBar.showActionMode();
            notifyStickersItemsChanged(2);
            if (SharedConfig.stickersReorderingHintUsed) {
                return;
            }
            SharedConfig.setStickersReorderingHintUsed(true);
            Bulletin.make(((BaseFragment) StickersActivity.this).parentLayout, new ReorderingBulletinLayout(this.mContext, LocaleController.getString("StickersReorderHint", R.string.StickersReorderHint), null), 3250).show();
        }

        private void checkActionModeIcons() {
            boolean z;
            if (hasSelected()) {
                int size = this.stickerSets.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = true;
                        break;
                    } else {
                        if (this.selectedItems.get(this.stickerSets.get(i).set.id, Boolean.FALSE).booleanValue() && this.stickerSets.get(i).set.official) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
                int i2 = z ? 0 : 8;
                if (StickersActivity.this.deleteMenuItem.getVisibility() != i2) {
                    StickersActivity.this.deleteMenuItem.setVisibility(i2);
                }
            }
        }

        private void notifyStickersItemsChanged(Object payload) {
            notifyItemRangeChanged(StickersActivity.this.stickersStartRow, StickersActivity.this.stickersEndRow - StickersActivity.this.stickersStartRow, payload);
        }

        private CharSequence addStickersBotSpan(String text) {
            String str = "@stickers";
            int iIndexOf = text.indexOf("@stickers");
            if (iIndexOf != -1) {
                try {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                    spannableStringBuilder.setSpan(new URLSpanNoUnderline(str) { // from class: ir.eitaa.ui.StickersActivity.ListAdapter.2
                        @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            MessagesController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).openByUserName("stickers", StickersActivity.this, 3);
                        }
                    }, iIndexOf, iIndexOf + 9, 18);
                    return spannableStringBuilder;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLinkForSet(TLRPC$TL_messages_stickerSet stickerSet) {
        return String.format(Locale.US, "https://" + MessagesController.getInstance(this.currentAccount).linkPrefix + "/addstickers/%s", stickerSet.set.short_name);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{StickerSetCell.class, TextSettingsCell.class, TextCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_ITEMSCOLOR, null, null, null, null, "actionBarActionModeDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_BACKGROUND, null, null, null, null, "actionBarActionModeDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_TOPBACKGROUND, null, null, null, null, "actionBarActionModeDefaultTop"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_SELECTORCOLOR, null, null, null, null, "actionBarActionModeDefaultSelector"));
        arrayList.add(new ThemeDescription(this.selectedCountTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "actionBarActionModeDefaultIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menuSelector"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menu"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"reorderButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menu"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{StickerSetCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{StickerSetCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        TrendingStickersAlert trendingStickersAlert = this.trendingStickersAlert;
        if (trendingStickersAlert != null) {
            arrayList.addAll(trendingStickersAlert.getThemeDescriptions());
        }
        return arrayList;
    }
}
