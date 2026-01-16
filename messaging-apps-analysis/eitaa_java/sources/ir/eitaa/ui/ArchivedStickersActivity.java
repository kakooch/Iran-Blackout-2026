package ir.eitaa.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetShortName;
import ir.eitaa.tgnet.TLRPC$TL_messages_archivedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getArchivedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.ArchivedStickerSetCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.StickersAlert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ArchivedStickersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int archiveInfoRow;
    private int currentType;
    private Runnable doOnTransitionEnd;
    private EmptyTextProgressView emptyView;
    private boolean endReached;
    private boolean firstLoaded;
    private boolean isInTransition;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loadingStickers;
    private int rowCount;
    private int stickersEndRow;
    private int stickersLoadingRow;
    private int stickersShadowRow;
    private int stickersStartRow;
    private final LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets = new LongSparseArray<>();
    private ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();

    public ArchivedStickersActivity(int type) {
        this.currentType = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getStickers();
        updateRows();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.needAddArchivedStickers);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needAddArchivedStickers);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("ArchivedStickers", R.string.ArchivedStickers));
        } else {
            this.actionBar.setTitle(LocaleController.getString("ArchivedMasks", R.string.ArchivedMasks));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ArchivedStickersActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ArchivedStickersActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        if (this.currentType == 0) {
            emptyTextProgressView.setText(LocaleController.getString("ArchivedStickersEmpty", R.string.ArchivedStickersEmpty));
        } else {
            emptyTextProgressView.setText(LocaleController.getString("ArchivedMasksEmpty", R.string.ArchivedMasksEmpty));
        }
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        if (this.loadingStickers) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFocusable(true);
        this.listView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ArchivedStickersActivity$nlVHfYhbkmbjQy99p34Qir1ucJg
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$ArchivedStickersActivity(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ArchivedStickersActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (ArchivedStickersActivity.this.loadingStickers || ArchivedStickersActivity.this.endReached || ArchivedStickersActivity.this.layoutManager.findLastVisibleItemPosition() <= ArchivedStickersActivity.this.stickersLoadingRow - 2) {
                    return;
                }
                ArchivedStickersActivity.this.getStickers();
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ArchivedStickersActivity(final View view, int i) {
        TLRPC$InputStickerSet tLRPC$TL_inputStickerSetShortName;
        if (i < this.stickersStartRow || i >= this.stickersEndRow || getParentActivity() == null) {
            return;
        }
        final TLRPC$StickerSetCovered tLRPC$StickerSetCovered = this.sets.get(i - this.stickersStartRow);
        if (tLRPC$StickerSetCovered.set.id != 0) {
            tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetID();
            tLRPC$TL_inputStickerSetShortName.id = tLRPC$StickerSetCovered.set.id;
        } else {
            tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetShortName();
            tLRPC$TL_inputStickerSetShortName.short_name = tLRPC$StickerSetCovered.set.short_name;
        }
        TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$TL_inputStickerSetShortName;
        tLRPC$InputStickerSet.access_hash = tLRPC$StickerSetCovered.set.access_hash;
        StickersAlert stickersAlert = new StickersAlert(getParentActivity(), this, tLRPC$InputStickerSet, (TLRPC$TL_messages_stickerSet) null, (StickersAlert.StickersAlertDelegate) null);
        stickersAlert.setInstallDelegate(new StickersAlert.StickersAlertInstallDelegate() { // from class: ir.eitaa.ui.ArchivedStickersActivity.2
            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetUninstalled() {
            }

            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetInstalled() {
                ((ArchivedStickerSetCell) view).setDrawProgress(true, true);
                LongSparseArray longSparseArray = ArchivedStickersActivity.this.installingStickerSets;
                TLRPC$StickerSetCovered tLRPC$StickerSetCovered2 = tLRPC$StickerSetCovered;
                longSparseArray.put(tLRPC$StickerSetCovered2.set.id, tLRPC$StickerSetCovered2);
            }
        });
        showDialog(stickersAlert);
    }

    private void updateRows() {
        int i;
        this.rowCount = 0;
        if (!this.sets.isEmpty()) {
            if (this.currentType == 0) {
                i = this.rowCount;
                this.rowCount = i + 1;
            } else {
                i = -1;
            }
            this.archiveInfoRow = i;
            int i2 = this.rowCount;
            this.stickersStartRow = i2;
            this.stickersEndRow = i2 + this.sets.size();
            int size = this.rowCount + this.sets.size();
            this.rowCount = size;
            if (!this.endReached) {
                this.rowCount = size + 1;
                this.stickersLoadingRow = size;
                this.stickersShadowRow = -1;
                return;
            } else {
                this.rowCount = size + 1;
                this.stickersShadowRow = size;
                this.stickersLoadingRow = -1;
                return;
            }
        }
        this.archiveInfoRow = -1;
        this.stickersStartRow = -1;
        this.stickersEndRow = -1;
        this.stickersLoadingRow = -1;
        this.stickersShadowRow = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStickers() {
        long j;
        if (this.loadingStickers || this.endReached) {
            return;
        }
        this.loadingStickers = true;
        EmptyTextProgressView emptyTextProgressView = this.emptyView;
        if (emptyTextProgressView != null && !this.firstLoaded) {
            emptyTextProgressView.showProgress();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        TLRPC$TL_messages_getArchivedStickers tLRPC$TL_messages_getArchivedStickers = new TLRPC$TL_messages_getArchivedStickers();
        if (this.sets.isEmpty()) {
            j = 0;
        } else {
            ArrayList<TLRPC$StickerSetCovered> arrayList = this.sets;
            j = arrayList.get(arrayList.size() - 1).set.id;
        }
        tLRPC$TL_messages_getArchivedStickers.offset_id = j;
        tLRPC$TL_messages_getArchivedStickers.limit = 15;
        tLRPC$TL_messages_getArchivedStickers.masks = this.currentType == 1;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getArchivedStickers, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ArchivedStickersActivity$lqvp0pjyrY8y2Go4TsE2iQPhwvU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getStickers$2$ArchivedStickersActivity(tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getStickers$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getStickers$2$ArchivedStickersActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArchivedStickersActivity$W9vcjDqxX-4TfLVpZiL56P7Kvco
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getStickers$1$ArchivedStickersActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getStickers$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getStickers$1$ArchivedStickersActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            lambda$processResponse$3((TLRPC$TL_messages_archivedStickers) tLObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processResponse, reason: merged with bridge method [inline-methods] */
    public void lambda$processResponse$3$ArchivedStickersActivity(final TLRPC$TL_messages_archivedStickers res) {
        if (!this.isInTransition) {
            this.sets.addAll(res.sets);
            this.endReached = res.sets.size() != 15;
            this.loadingStickers = false;
            this.firstLoaded = true;
            EmptyTextProgressView emptyTextProgressView = this.emptyView;
            if (emptyTextProgressView != null) {
                emptyTextProgressView.showTextView();
            }
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.doOnTransitionEnd = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ArchivedStickersActivity$E1B-72NodfrAvnB6u5U7IVYrMVg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processResponse$3$ArchivedStickersActivity(res);
            }
        };
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        this.isInTransition = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        this.isInTransition = false;
        Runnable runnable = this.doOnTransitionEnd;
        if (runnable != null) {
            runnable.run();
            this.doOnTransitionEnd = null;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        RecyclerListView recyclerListView;
        ArchivedStickerSetCell archivedStickerSetCell;
        TLRPC$StickerSetCovered stickersSet;
        if (id == NotificationCenter.needAddArchivedStickers) {
            ArrayList arrayList = new ArrayList((List) args[0]);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int size2 = this.sets.size();
                int i = 0;
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    if (this.sets.get(i).set.id == ((TLRPC$StickerSetCovered) arrayList.get(size)).set.id) {
                        arrayList.remove(size);
                        break;
                    }
                    i++;
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.sets.addAll(0, arrayList);
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyItemRangeInserted(this.stickersStartRow, arrayList.size());
                return;
            }
            return;
        }
        if (id != NotificationCenter.stickersDidLoad || (recyclerListView = this.listView) == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.listView.getChildAt(i2);
            if ((childAt instanceof ArchivedStickerSetCell) && (stickersSet = (archivedStickerSetCell = (ArchivedStickerSetCell) childAt).getStickersSet()) != null) {
                boolean zIsStickerPackInstalled = MediaDataController.getInstance(this.currentAccount).isStickerPackInstalled(stickersSet.set.id);
                if (zIsStickerPackInstalled) {
                    this.installingStickerSets.remove(stickersSet.set.id);
                    archivedStickerSetCell.setDrawProgress(false, true);
                }
                archivedStickerSetCell.setChecked(zIsStickerPackInstalled, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ArchivedStickersActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == 0) {
                int i = position - ArchivedStickersActivity.this.stickersStartRow;
                ArchivedStickerSetCell archivedStickerSetCell = (ArchivedStickerSetCell) holder.itemView;
                final TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) ArchivedStickersActivity.this.sets.get(i);
                archivedStickerSetCell.setStickersSet(tLRPC$StickerSetCovered, i != ArchivedStickersActivity.this.sets.size() - 1);
                boolean zIsStickerPackInstalled = MediaDataController.getInstance(((BaseFragment) ArchivedStickersActivity.this).currentAccount).isStickerPackInstalled(tLRPC$StickerSetCovered.set.id);
                archivedStickerSetCell.setChecked(zIsStickerPackInstalled, false, false);
                if (zIsStickerPackInstalled) {
                    ArchivedStickersActivity.this.installingStickerSets.remove(tLRPC$StickerSetCovered.set.id);
                    archivedStickerSetCell.setDrawProgress(false, false);
                } else {
                    archivedStickerSetCell.setDrawProgress(ArchivedStickersActivity.this.installingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) >= 0, false);
                }
                archivedStickerSetCell.setOnCheckedChangeListener(new ArchivedStickerSetCell.OnCheckedChangeListener() { // from class: ir.eitaa.ui.-$$Lambda$ArchivedStickersActivity$ListAdapter$Go4RO_DXlmJh1fx6aIUuv4cNt-k
                    @Override // ir.eitaa.ui.Cells.ArchivedStickerSetCell.OnCheckedChangeListener
                    public final void onCheckedChanged(ArchivedStickerSetCell archivedStickerSetCell2, boolean z) {
                        this.f$0.lambda$onBindViewHolder$0$ArchivedStickersActivity$ListAdapter(tLRPC$StickerSetCovered, archivedStickerSetCell2, z);
                    }
                });
                return;
            }
            if (getItemViewType(position) == 2) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == ArchivedStickersActivity.this.archiveInfoRow) {
                    textInfoPrivacyCell.setTopPadding(17);
                    textInfoPrivacyCell.setBottomPadding(10);
                    textInfoPrivacyCell.setText(LocaleController.getString("ArchivedStickersInfo", R.string.ArchivedStickersInfo));
                } else {
                    textInfoPrivacyCell.setTopPadding(10);
                    textInfoPrivacyCell.setBottomPadding(17);
                    textInfoPrivacyCell.setText(null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onBindViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onBindViewHolder$0$ArchivedStickersActivity$ListAdapter(TLRPC$StickerSetCovered tLRPC$StickerSetCovered, ArchivedStickerSetCell archivedStickerSetCell, boolean z) {
            if (z) {
                archivedStickerSetCell.setChecked(false, false, false);
                if (ArchivedStickersActivity.this.installingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) >= 0) {
                    return;
                }
                archivedStickerSetCell.setDrawProgress(true, true);
                ArchivedStickersActivity.this.installingStickerSets.put(tLRPC$StickerSetCovered.set.id, tLRPC$StickerSetCovered);
            }
            MediaDataController.getInstance(((BaseFragment) ArchivedStickersActivity.this).currentAccount).toggleStickerSet(ArchivedStickersActivity.this.getParentActivity(), tLRPC$StickerSetCovered, !z ? 1 : 2, ArchivedStickersActivity.this, false, false);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View loadingCell;
            if (viewType == 0) {
                ArchivedStickerSetCell archivedStickerSetCell = new ArchivedStickerSetCell(this.mContext, true);
                archivedStickerSetCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                loadingCell = archivedStickerSetCell;
            } else if (viewType == 1) {
                loadingCell = new LoadingCell(this.mContext);
                loadingCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            } else if (viewType != 2) {
                loadingCell = null;
            } else {
                loadingCell = new TextInfoPrivacyCell(this.mContext);
                loadingCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            }
            loadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= ArchivedStickersActivity.this.stickersStartRow && i < ArchivedStickersActivity.this.stickersEndRow) {
                return 0;
            }
            if (i == ArchivedStickersActivity.this.stickersLoadingRow) {
                return 1;
            }
            return (i == ArchivedStickersActivity.this.stickersShadowRow || i == ArchivedStickersActivity.this.archiveInfoRow) ? 2 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ArchivedStickerSetCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LoadingCell.class, TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ArchivedStickerSetCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ArchivedStickerSetCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ArchivedStickerSetCell.class}, new String[]{"deleteButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_removeButtonText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{ArchivedStickerSetCell.class}, new String[]{"deleteButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_removeButtonText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ArchivedStickerSetCell.class}, new String[]{"addButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{ArchivedStickerSetCell.class}, new String[]{"addButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{ArchivedStickerSetCell.class}, new String[]{"addButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButtonPressed"));
        return arrayList;
    }
}
