package org.rbmain.ui;

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
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_reorderStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.RadioColorCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.StickerSetCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberTextView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ReorderingBulletinLayout;
import org.rbmain.ui.Components.StickersAlert;
import org.rbmain.ui.Components.TrendingStickersAlert;
import org.rbmain.ui.Components.TrendingStickersLayout;
import org.rbmain.ui.Components.URLSpanNoUnderline;

/* loaded from: classes4.dex */
public class StickersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int activeReorderingRequests;
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
    private int reactionsDoubleTapRow;
    private int rowCount;
    private NumberTextView selectedCountTextView;
    private int stickersBotInfo;
    private int stickersEndRow;
    private int stickersShadowRow;
    private int stickersStartRow;
    private int suggestRow;
    private TrendingStickersAlert trendingStickersAlert;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
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
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
                return false;
            }
            StickersActivity.this.listAdapter.swapElements(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (i == 0) {
                StickersActivity.this.sendReorder();
            } else {
                StickersActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    public StickersActivity(int i) {
        this.currentType = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        MediaDataController.getInstance(this.currentAccount).checkStickers(this.currentType);
        if (this.currentType == 0) {
            MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers(true);
            MediaDataController.getInstance(this.currentAccount).checkStickers(1);
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.archivedStickersCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.featuredStickersDidLoad);
        updateRows();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.archivedStickersCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.featuredStickersDidLoad);
        getContactProxy().saveStickerSettings();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("StickersName", R.string.StickersName));
        } else {
            this.actionBar.setTitle(LocaleController.getString("Masks", R.string.Masks));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.StickersActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    if (StickersActivity.this.onBackPressed()) {
                        StickersActivity.this.finishFragment();
                    }
                } else if (i == 0 || i == 1) {
                    if (!StickersActivity.this.needReorder) {
                        if (StickersActivity.this.activeReorderingRequests == 0) {
                            StickersActivity.this.listAdapter.processSelectionMenu(i);
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
        this.selectedCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedCountTextView.setTextColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon));
        actionBarMenuCreateActionMode.addView(this.selectedCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return StickersActivity.lambda$createView$0(view, motionEvent);
            }
        });
        actionBarMenuCreateActionMode.addItemWithWidth(0, R.drawable.msg_archive, AndroidUtilities.dp(54.0f));
        this.deleteMenuItem = actionBarMenuCreateActionMode.addItemWithWidth(1, R.drawable.msg_delete, AndroidUtilities.dp(54.0f));
        this.listAdapter = new ListAdapter(context, MediaDataController.getInstance(this.currentAccount).getStickerSets(this.currentType));
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFocusable(true);
        this.listView.setTag(7);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: org.rbmain.ui.StickersActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                iArr[1] = StickersActivity.this.listView.getHeight();
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$2(context, view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda5
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$3(view, i);
            }
        });
        getStickerSettingsFromServer();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(Context context, View view, int i) {
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
            showDialog(new StickersAlert(getParentActivity(), this, null, tLRPC$TL_messages_stickerSet, null));
            return;
        }
        if (i == this.featuredRow) {
            TrendingStickersAlert trendingStickersAlert = new TrendingStickersAlert(context, this, new TrendingStickersLayout(context, new TrendingStickersLayout.Delegate() { // from class: org.rbmain.ui.StickersActivity.3
                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered, boolean z) {
                    MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), tLRPC$StickerSetCovered, 2, StickersActivity.this, false, false);
                }

                @Override // org.rbmain.ui.Components.TrendingStickersLayout.Delegate
                public void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
                    MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), tLRPC$StickerSetCovered, 0, StickersActivity.this, false, false);
                }
            }));
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
                radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
                radioColorCell.setTextAndValue(strArr[i2], SharedConfig.suggestStickers == i2);
                linearLayout.addView(radioColorCell);
                radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.lambda$createView$1(builder, view2);
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
        } else if (i == this.reactionsDoubleTapRow) {
            presentFragment(new ReactionsDoubleTapManageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(AlertDialog.Builder builder, View view) {
        SharedConfig.setSuggestStickers(((Integer) view.getTag()).intValue());
        this.listAdapter.notifyItemChanged(this.suggestRow);
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$3(View view, int i) {
        if (this.listAdapter.hasSelected() || i < this.stickersStartRow || i >= this.stickersEndRow) {
            return false;
        }
        this.listAdapter.toggleSelected(i);
        return true;
    }

    private void getStickerSettingsFromServer() {
        getContactProxy().getStickerSettings();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.listAdapter.hasSelected()) {
            this.listAdapter.clearSelected();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.stickersDidLoad) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            int i3 = this.currentType;
            if (iIntValue == i3) {
                updateRows();
                return;
            } else {
                if (i3 == 0 && iIntValue == 1) {
                    this.listAdapter.notifyItemChanged(this.masksRow);
                    return;
                }
                return;
            }
        }
        if (i == NotificationCenter.featuredStickersDidLoad) {
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyItemChanged(0);
                return;
            }
            return;
        }
        if (i == NotificationCenter.archivedStickersCountDidLoad && ((Integer) objArr[0]).intValue() == this.currentType) {
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
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().reorderStickers(tLRPC$TL_messages_reorderStickerSets, new RequestDelegate() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendReorder$5(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReorder$4() {
        this.activeReorderingRequests--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReorder$5(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.StickersActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendReorder$4();
            }
        });
    }

    private void updateRows() {
        final ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = MediaDataController.getInstance(this.currentAccount).getStickerSets(this.currentType);
        if (this.listAdapter != null) {
            diffResultCalculateDiff = this.isPaused ? null : DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: org.rbmain.ui.StickersActivity.4
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
                public boolean areItemsTheSame(int i, int i2) {
                    return this.oldList.get(i).set.id == ((TLRPC$TL_messages_stickerSet) stickerSets.get(i2)).set.id;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i, int i2) {
                    TLRPC$StickerSet tLRPC$StickerSet = this.oldList.get(i).set;
                    TLRPC$StickerSet tLRPC$StickerSet2 = ((TLRPC$TL_messages_stickerSet) stickerSets.get(i2)).set;
                    return TextUtils.equals(tLRPC$StickerSet.title, tLRPC$StickerSet2.title) && tLRPC$StickerSet.count == tLRPC$StickerSet2.count;
                }
            });
            this.listAdapter.setStickerSets(stickerSets);
        }
        this.rowCount = 0;
        if (this.currentType == 0) {
            int i = 0 + 1;
            this.rowCount = i;
            this.suggestRow = 0;
            this.loopRow = -1;
            this.loopInfoRow = -1;
            int i2 = i + 1;
            this.rowCount = i2;
            this.featuredRow = i;
            this.rowCount = i2 + 1;
            this.reactionsDoubleTapRow = i2;
        } else {
            this.suggestRow = -1;
            this.loopRow = -1;
            this.loopInfoRow = -1;
            this.featuredRow = -1;
            this.reactionsDoubleTapRow = -1;
        }
        boolean z = this.archivedRow == -1;
        int i3 = this.rowCount;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.archivedRow = i3;
        this.rowCount = i4 + 1;
        this.archivedInfoRow = i4;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null && z) {
            listAdapter.notifyItemRangeInserted(i3, i4 != -1 ? 2 : 1);
        }
        this.masksRow = -1;
        this.stickersBotInfo = -1;
        int size = stickerSets.size();
        if (size > 0) {
            int i5 = this.rowCount;
            this.stickersStartRow = i5;
            int i6 = i5 + size;
            this.rowCount = i6;
            this.stickersEndRow = i6;
            if (this.currentType != 1) {
                this.rowCount = i6 + 1;
                this.stickersShadowRow = i6;
                this.masksInfoRow = -1;
            } else {
                this.rowCount = i6 + 1;
                this.masksInfoRow = i6;
                this.stickersShadowRow = -1;
            }
        } else {
            this.stickersStartRow = -1;
            this.stickersEndRow = -1;
            this.stickersShadowRow = -1;
            this.masksInfoRow = -1;
        }
        ListAdapter listAdapter2 = this.listAdapter;
        if (listAdapter2 != null && diffResultCalculateDiff != null) {
            final int i7 = this.stickersStartRow;
            if (i7 < 0) {
                i7 = this.rowCount;
            }
            listAdapter2.notifyItemRangeChanged(0, i7);
            diffResultCalculateDiff.dispatchUpdatesTo(new ListUpdateCallback() { // from class: org.rbmain.ui.StickersActivity.5
                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onMoved(int i8, int i9) {
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onInserted(int i8, int i9) {
                    StickersActivity.this.listAdapter.notifyItemRangeInserted(i7 + i8, i9);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onRemoved(int i8, int i9) {
                    StickersActivity.this.listAdapter.notifyItemRangeRemoved(i7 + i8, i9);
                }

                @Override // androidx.recyclerview.widget.ListUpdateCallback
                public void onChanged(int i8, int i9, Object obj) {
                    StickersActivity.this.listAdapter.notifyItemRangeChanged(i7 + i8, i9);
                }
            });
        }
        ListAdapter listAdapter3 = this.listAdapter;
        if (listAdapter3 != null) {
            listAdapter3.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

        public ListAdapter(Context context, List<TLRPC$TL_messages_stickerSet> list) {
            ArrayList arrayList = new ArrayList();
            this.stickerSets = arrayList;
            this.mContext = context;
            arrayList.addAll(list);
        }

        public void setStickerSets(List<TLRPC$TL_messages_stickerSet> list) {
            this.stickerSets.clear();
            this.stickerSets.addAll(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StickersActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            if (i < StickersActivity.this.stickersStartRow || i >= StickersActivity.this.stickersEndRow) {
                if (i == StickersActivity.this.suggestRow || i == StickersActivity.this.loopInfoRow || i == StickersActivity.this.archivedRow || i == StickersActivity.this.archivedInfoRow || i == StickersActivity.this.featuredRow || i == StickersActivity.this.stickersBotInfo || i == StickersActivity.this.masksRow || i == StickersActivity.this.reactionsDoubleTapRow) {
                    return -2147483648L;
                }
                return i;
            }
            return this.stickerSets.get(i - StickersActivity.this.stickersStartRow).set.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processSelectionMenu(final int i) {
            String string;
            TextView textView;
            if (i == 0 || i == 1) {
                final ArrayList arrayList = new ArrayList(this.selectedItems.size());
                int size = this.stickerSets.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    TLRPC$StickerSet tLRPC$StickerSet = this.stickerSets.get(i3).set;
                    if (this.selectedItems.get(tLRPC$StickerSet.id, Boolean.FALSE).booleanValue()) {
                        arrayList.add(tLRPC$StickerSet);
                    }
                }
                int size2 = arrayList.size();
                if (size2 != 0) {
                    if (size2 == 1) {
                        int size3 = this.stickerSets.size();
                        while (true) {
                            if (i2 >= size3) {
                                break;
                            }
                            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSets.get(i2);
                            if (this.selectedItems.get(tLRPC$TL_messages_stickerSet.set.id, Boolean.FALSE).booleanValue()) {
                                processSelectionOption(i, tLRPC$TL_messages_stickerSet);
                                break;
                            }
                            i2++;
                        }
                        StickersActivity.this.listAdapter.clearSelected();
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(StickersActivity.this.getParentActivity());
                    if (i == 1) {
                        builder.setTitle(LocaleController.formatString("DeleteStickerSetsAlertTitle", R.string.DeleteStickerSetsAlertTitle, LocaleController.formatPluralString("StickerSets", size2)));
                        builder.setMessage(LocaleController.formatString("DeleteStickersAlertMessage", R.string.DeleteStickersAlertMessage, Integer.valueOf(size2)));
                        string = LocaleController.getString("Delete", R.string.Delete);
                    } else {
                        builder.setTitle(LocaleController.formatString("ArchiveStickerSetsAlertTitle", R.string.ArchiveStickerSetsAlertTitle, LocaleController.formatPluralString("StickerSets", size2)));
                        builder.setMessage(LocaleController.formatString("ArchiveStickersAlertMessage", R.string.ArchiveStickersAlertMessage, Integer.valueOf(size2)));
                        string = LocaleController.getString("Archive", R.string.Archive);
                    }
                    builder.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.StickersActivity$ListAdapter$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            this.f$0.lambda$processSelectionMenu$0(arrayList, i, dialogInterface, i4);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate = builder.create();
                    StickersActivity.this.showDialog(alertDialogCreate);
                    if (i != 1 || (textView = (TextView) alertDialogCreate.getButton(-1)) == null) {
                        return;
                    }
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processSelectionMenu$0(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
            StickersActivity.this.listAdapter.clearSelected();
            MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSets(arrayList, StickersActivity.this.currentType, i == 1 ? 0 : 1, StickersActivity.this, true);
        }

        private void processSelectionOption(int i, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
            int iIndexOf;
            if (i == 0) {
                MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), tLRPC$TL_messages_stickerSet, !tLRPC$TL_messages_stickerSet.set.archived ? 1 : 2, StickersActivity.this, true, true);
                return;
            }
            if (i == 1) {
                MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).toggleStickerSet(StickersActivity.this.getParentActivity(), tLRPC$TL_messages_stickerSet, 0, StickersActivity.this, true, true);
                return;
            }
            if (i == 2) {
                try {
                    String str = tLRPC$TL_messages_stickerSet.set.shareString;
                    if (str == null || str.isEmpty()) {
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", tLRPC$TL_messages_stickerSet.set.shareString);
                    StickersActivity.this.getParentActivity().startActivityForResult(Intent.createChooser(intent, LocaleController.getString("StickersShare", R.string.StickersShare)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (i != 3) {
                if (i != 4 || (iIndexOf = this.stickerSets.indexOf(tLRPC$TL_messages_stickerSet)) < 0) {
                    return;
                }
                StickersActivity.this.listAdapter.toggleSelected(StickersActivity.this.stickersStartRow + iIndexOf);
                return;
            }
            try {
                String str2 = tLRPC$TL_messages_stickerSet.set.shareString;
                if (str2 == null || str2.isEmpty()) {
                    return;
                }
                ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", tLRPC$TL_messages_stickerSet.set.shareString));
                BulletinFactory.createCopyLinkBulletin(StickersActivity.this).show();
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                int i2 = i - StickersActivity.this.stickersStartRow;
                StickerSetCell stickerSetCell = (StickerSetCell) viewHolder.itemView;
                stickerSetCell.setStickersSet(this.stickerSets.get(i2), i2 != this.stickerSets.size() - 1);
                stickerSetCell.setChecked(this.selectedItems.get(getItemId(i), Boolean.FALSE).booleanValue(), false);
                stickerSetCell.setReorderable(hasSelected(), false);
                return;
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i != StickersActivity.this.stickersBotInfo) {
                    if (i == StickersActivity.this.archivedInfoRow) {
                        if (StickersActivity.this.currentType == 0) {
                            textInfoPrivacyCell.setText(LocaleController.getString("ArchivedStickersInfo", R.string.ArchivedStickersInfo));
                            return;
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("ArchivedMasksInfo", R.string.ArchivedMasksInfo));
                            return;
                        }
                    }
                    if (i != StickersActivity.this.loopInfoRow) {
                        if (i == StickersActivity.this.masksInfoRow) {
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
                    if (itemViewType == 4 && i == StickersActivity.this.loopRow) {
                        ((TextCheckCell) viewHolder.itemView).setTextAndCheck(LocaleController.getString("LoopAnimatedStickers", R.string.LoopAnimatedStickers), SharedConfig.loopStickers, true);
                        return;
                    }
                    return;
                }
                if (i == StickersActivity.this.stickersShadowRow) {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                return;
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
            int i3 = StickersActivity.this.featuredRow;
            String string2 = BuildConfig.FLAVOR;
            if (i != i3) {
                if (i == StickersActivity.this.archivedRow) {
                    int archivedStickersCount = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).getArchivedStickersCount(StickersActivity.this.currentType);
                    if (archivedStickersCount > 0) {
                        string2 = Integer.toString(archivedStickersCount);
                    }
                    if (StickersActivity.this.currentType == 0) {
                        textSettingsCell.setTextAndValue(LocaleController.getString("ArchivedStickers", R.string.ArchivedStickers), string2, true);
                        return;
                    } else {
                        textSettingsCell.setTextAndValue(LocaleController.getString("ArchivedMasks", R.string.ArchivedMasks), string2, true);
                        return;
                    }
                }
                if (i == StickersActivity.this.masksRow) {
                    MediaDataController mediaDataController = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount);
                    int size = mediaDataController.getStickerSets(1).size() + mediaDataController.getArchivedStickersCount(1);
                    String string3 = LocaleController.getString("Masks", R.string.Masks);
                    if (size > 0) {
                        string2 = Integer.toString(size);
                    }
                    textSettingsCell.setTextAndValue(string3, string2, false);
                    return;
                }
                if (i != StickersActivity.this.suggestRow) {
                    if (i == StickersActivity.this.reactionsDoubleTapRow) {
                        textSettingsCell.setText(LocaleController.getString("DoubleTapSetting", R.string.DoubleTapSetting), true);
                        return;
                    }
                    return;
                }
                int i4 = SharedConfig.suggestStickers;
                if (i4 == 0) {
                    string = LocaleController.getString("SuggestStickersAll", R.string.SuggestStickersAll);
                } else if (i4 == 1) {
                    string = LocaleController.getString("SuggestStickersInstalled", R.string.SuggestStickersInstalled);
                } else {
                    string = LocaleController.getString("SuggestStickersNone", R.string.SuggestStickersNone);
                }
                textSettingsCell.setTextAndValue(LocaleController.getString("SuggestStickers", R.string.SuggestStickers), string, true);
                return;
            }
            textSettingsCell.setTextAndValue(LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers), BuildConfig.FLAVOR, true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
            if (list.isEmpty()) {
                onBindViewHolder(viewHolder, i);
                return;
            }
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                if (i < StickersActivity.this.stickersStartRow || i >= StickersActivity.this.stickersEndRow) {
                    return;
                }
                StickerSetCell stickerSetCell = (StickerSetCell) viewHolder.itemView;
                if (list.contains(1)) {
                    stickerSetCell.setChecked(this.selectedItems.get(getItemId(i), Boolean.FALSE).booleanValue());
                }
                if (list.contains(2)) {
                    stickerSetCell.setReorderable(hasSelected());
                }
                if (list.contains(3)) {
                    stickerSetCell.setNeedDivider(i - StickersActivity.this.stickersStartRow != this.stickerSets.size() - 1);
                    return;
                }
                return;
            }
            if (itemViewType == 4 && list.contains(0) && i == StickersActivity.this.loopRow) {
                ((TextCheckCell) viewHolder.itemView).setChecked(SharedConfig.loopStickers);
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2 || itemViewType == 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$1(StickerSetCell stickerSetCell, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            StickersActivity.this.itemTouchHelper.startDrag(StickersActivity.this.listView.getChildViewHolder(stickerSetCell));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$3(View view) {
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
            builder.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.StickersActivity$ListAdapter$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateViewHolder$2(iArr2, stickersSet, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            StickersActivity.this.showDialog(alertDialogCreate);
            if (iArr2[iArr2.length - 1] == 1) {
                alertDialogCreate.setItemColor(charSequenceArr.length - 1, Theme.getColor(Theme.key_text_RedBold), Theme.getColor(Theme.key_text_RedRegular));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$2(int[] iArr, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, DialogInterface dialogInterface, int i) {
            processSelectionOption(iArr[i], tLRPC$TL_messages_stickerSet);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textInfoPrivacyCell;
            if (i == 0) {
                final StickerSetCell stickerSetCell = new StickerSetCell(this.mContext, 1);
                stickerSetCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                stickerSetCell.setOnReorderButtonTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.StickersActivity$ListAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$onCreateViewHolder$1(stickerSetCell, view, motionEvent);
                    }
                });
                stickerSetCell.setOnOptionsClick(new View.OnClickListener() { // from class: org.rbmain.ui.StickersActivity$ListAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$3(view);
                    }
                });
                textInfoPrivacyCell = stickerSetCell;
            } else if (i == 1) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
            } else if (i == 2) {
                textInfoPrivacyCell = new TextSettingsCell(this.mContext);
                textInfoPrivacyCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                textInfoPrivacyCell = new ShadowSectionCell(this.mContext);
            } else if (i != 4) {
                textInfoPrivacyCell = null;
            } else {
                textInfoPrivacyCell = new TextCheckCell(this.mContext);
                textInfoPrivacyCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
            if (i == StickersActivity.this.featuredRow || i == StickersActivity.this.archivedRow || i == StickersActivity.this.masksRow || i == StickersActivity.this.suggestRow || i == StickersActivity.this.reactionsDoubleTapRow) {
                return 2;
            }
            if (i == StickersActivity.this.stickersShadowRow) {
                return 3;
            }
            return i == StickersActivity.this.loopRow ? 4 : 0;
        }

        public void swapElements(int i, int i2) {
            if (i != i2) {
                StickersActivity.this.needReorder = true;
            }
            MediaDataController mediaDataController = MediaDataController.getInstance(((BaseFragment) StickersActivity.this).currentAccount);
            int i3 = i - StickersActivity.this.stickersStartRow;
            int i4 = i2 - StickersActivity.this.stickersStartRow;
            swapListElements(this.stickerSets, i3, i4);
            swapListElements(mediaDataController.getStickerSets(StickersActivity.this.currentType), i3, i4);
            notifyItemMoved(i, i2);
            if (i == StickersActivity.this.stickersEndRow - 1 || i2 == StickersActivity.this.stickersEndRow - 1) {
                notifyItemRangeChanged(i, 3);
                notifyItemRangeChanged(i2, 3);
            }
        }

        private void swapListElements(List<TLRPC$TL_messages_stickerSet> list, int i, int i2) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = list.get(i);
            list.set(i, list.get(i2));
            list.set(i2, tLRPC$TL_messages_stickerSet);
        }

        public void toggleSelected(int i) {
            long itemId = getItemId(i);
            this.selectedItems.put(itemId, Boolean.valueOf(!r2.get(itemId, Boolean.FALSE).booleanValue()));
            notifyItemChanged(i, 1);
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
            Bulletin.make(((BaseFragment) StickersActivity.this).parentLayout, new ReorderingBulletinLayout(this.mContext, LocaleController.getString("StickersReorderHint", R.string.StickersReorderHint)), 3250).show();
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

        private void notifyStickersItemsChanged(Object obj) {
            notifyItemRangeChanged(StickersActivity.this.stickersStartRow, StickersActivity.this.stickersEndRow - StickersActivity.this.stickersStartRow, obj);
        }

        private CharSequence addStickersBotSpan(String str) {
            String str2 = "@stickers";
            int iIndexOf = str.indexOf("@stickers");
            if (iIndexOf != -1) {
                try {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new URLSpanNoUnderline(str2) { // from class: org.rbmain.ui.StickersActivity.ListAdapter.1
                        @Override // org.rbmain.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                        public void onClick(View view) {
                            MessagesController.getInstance(((BaseFragment) StickersActivity.this).currentAccount).openByUserName("stickers", StickersActivity.this, 3);
                        }
                    }, iIndexOf, iIndexOf + 9, 18);
                    return spannableStringBuilder;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return str;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{StickerSetCell.class, TextSettingsCell.class, TextCheckCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        ActionBar actionBar2 = this.actionBar;
        int i4 = ThemeDescription.FLAG_AB_AM_ITEMSCOLOR;
        int i5 = Theme.key_actionBarActionModeDefaultIcon;
        arrayList.add(new ThemeDescription(actionBar2, i4, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_BACKGROUND, null, null, null, null, Theme.key_actionBarActionModeDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_TOPBACKGROUND, null, null, null, null, Theme.key_actionBarActionModeDefaultTop));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarActionModeDefaultSelector));
        arrayList.add(new ThemeDescription(this.selectedCountTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        int i6 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        int i7 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menuSelector));
        int i8 = Theme.key_stickers_menu;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"optionsButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StickerSetCell.class}, new String[]{"reorderButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{StickerSetCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{StickerSetCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxCheck));
        TrendingStickersAlert trendingStickersAlert = this.trendingStickersAlert;
        if (trendingStickersAlert != null) {
            arrayList.addAll(trendingStickersAlert.getThemeDescriptions());
        }
        return arrayList;
    }
}
