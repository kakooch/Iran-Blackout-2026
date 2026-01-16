package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_messages_featuredStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getOldFeaturedStickers;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.StickersSearchAdapter;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.FeaturedStickerSetCell2;
import org.rbmain.ui.Cells.FeaturedStickerSetInfoCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.StickerEmojiCell;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.StickersAlert;

/* loaded from: classes5.dex */
public class TrendingStickersLayout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private final TrendingStickersAdapter adapter;
    private final int currentAccount;
    private final Delegate delegate;
    ValueAnimator glueToTopAnimator;
    private boolean gluedToTop;
    private int hash;
    private boolean ignoreLayout;
    private final LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets;
    private final GridLayoutManager layoutManager;
    private final RecyclerListView listView;
    private boolean loaded;
    private boolean motionEventCatchedByListView;
    private RecyclerView.OnScrollListener onScrollListener;
    private BaseFragment parentFragment;
    private final TLRPC$StickerSetCovered[] primaryInstallingStickerSets;
    private final LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets;
    private boolean scrollFromAnimator;
    private final StickersSearchAdapter searchAdapter;
    private final FrameLayout searchLayout;
    private final SearchField searchView;
    private final View shadowView;
    private boolean shadowVisible;
    private int topOffset;
    private boolean wasLayout;

    public static abstract class Delegate {
        private String[] lastSearchKeyboardLanguage = new String[0];

        public boolean canSchedule() {
            return false;
        }

        public boolean canSendSticker() {
            return false;
        }

        public boolean isInScheduleMode() {
            return false;
        }

        public boolean onListViewInterceptTouchEvent(RecyclerListView recyclerListView, MotionEvent motionEvent) {
            return false;
        }

        public boolean onListViewTouchEvent(RecyclerListView recyclerListView, RecyclerListView.OnItemClickListener onItemClickListener, MotionEvent motionEvent) {
            return false;
        }

        public void onStickerSelected(TLRPC$Document tLRPC$Document, Object obj, boolean z, boolean z2, int i) {
        }

        public abstract void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered, boolean z);

        public abstract void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered);

        public String[] getLastSearchKeyboardLanguage() {
            return this.lastSearchKeyboardLanguage;
        }

        public void setLastSearchKeyboardLanguage(String[] strArr) {
            this.lastSearchKeyboardLanguage = strArr;
        }
    }

    public TrendingStickersLayout(Context context, Delegate delegate) {
        this(context, delegate, new TLRPC$StickerSetCovered[10], new LongSparseArray(), new LongSparseArray());
    }

    public TrendingStickersLayout(Context context, final Delegate delegate, TLRPC$StickerSetCovered[] tLRPC$StickerSetCoveredArr, LongSparseArray<TLRPC$StickerSetCovered> longSparseArray, LongSparseArray<TLRPC$StickerSetCovered> longSparseArray2) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.delegate = delegate;
        this.primaryInstallingStickerSets = tLRPC$StickerSetCoveredArr;
        this.installingStickerSets = longSparseArray;
        this.removingStickerSets = longSparseArray2;
        TrendingStickersAdapter trendingStickersAdapter = new TrendingStickersAdapter(context);
        this.adapter = trendingStickersAdapter;
        this.searchAdapter = new StickersSearchAdapter(context, new StickersSearchAdapter.Delegate() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.1
            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void onSearchStart() {
                TrendingStickersLayout.this.searchView.getProgressDrawable().startAnimation();
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void onSearchStop() {
                TrendingStickersLayout.this.searchView.getProgressDrawable().stopAnimation();
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void setAdapterVisible(boolean z) {
                boolean z2 = true;
                if (!z || TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.searchAdapter) {
                    if (z || TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.adapter) {
                        z2 = false;
                    } else {
                        TrendingStickersLayout.this.listView.setAdapter(TrendingStickersLayout.this.adapter);
                    }
                } else {
                    TrendingStickersLayout.this.listView.setAdapter(TrendingStickersLayout.this.searchAdapter);
                }
                if (!z2 || TrendingStickersLayout.this.listView.getAdapter().getItemCount() <= 0) {
                    return;
                }
                TrendingStickersLayout.this.layoutManager.scrollToPositionWithOffset(0, (-TrendingStickersLayout.this.listView.getPaddingTop()) + AndroidUtilities.dp(58.0f) + TrendingStickersLayout.this.topOffset, false);
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered, boolean z) {
                delegate.onStickerSetAdd(tLRPC$StickerSetCovered, z);
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
                delegate.onStickerSetRemove(tLRPC$StickerSetCovered);
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public int getStickersPerRow() {
                return TrendingStickersLayout.this.adapter.stickersPerRow;
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public String[] getLastSearchKeyboardLanguage() {
                return delegate.getLastSearchKeyboardLanguage();
            }

            @Override // org.rbmain.ui.Adapters.StickersSearchAdapter.Delegate
            public void setLastSearchKeyboardLanguage(String[] strArr) {
                delegate.setLastSearchKeyboardLanguage(strArr);
            }
        }, tLRPC$StickerSetCoveredArr, longSparseArray, longSparseArray2);
        FrameLayout frameLayout = new FrameLayout(context);
        this.searchLayout = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        SearchField searchField = new SearchField(context, true) { // from class: org.rbmain.ui.Components.TrendingStickersLayout.2
            @Override // org.rbmain.ui.Components.SearchField
            public void onTextChange(String str) {
                TrendingStickersLayout.this.searchAdapter.search(str);
            }
        };
        this.searchView = searchField;
        searchField.setHint(LocaleController.getString("SearchTrendingStickersHint", R.string.SearchTrendingStickersHint));
        frameLayout.addView(searchField, LayoutHelper.createFrame(-1, -1, 48));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.TrendingStickersLayout.3
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return super.onInterceptTouchEvent(motionEvent) || delegate.onListViewInterceptTouchEvent(this, motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                TrendingStickersLayout.this.motionEventCatchedByListView = true;
                return super.dispatchTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (TrendingStickersLayout.this.glueToTopAnimator != null) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (TrendingStickersLayout.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (TrendingStickersLayout.this.topOffset + AndroidUtilities.dp(58.0f)));
            }
        };
        this.listView = recyclerListView;
        final RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$new$0(view, i2);
            }
        };
        recyclerListView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$new$1(delegate, onItemClickListener, view, motionEvent);
            }
        });
        recyclerListView.setOverScrollMode(2);
        recyclerListView.setClipToPadding(false);
        recyclerListView.setItemAnimator(null);
        recyclerListView.setLayoutAnimation(null);
        FillLastGridLayoutManager fillLastGridLayoutManager = new FillLastGridLayoutManager(context, 5, AndroidUtilities.dp(58.0f), recyclerListView) { // from class: org.rbmain.ui.Components.TrendingStickersLayout.4
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected boolean isLayoutRTL() {
                return LocaleController.isRTL;
            }

            @Override // org.rbmain.ui.Components.FillLastGridLayoutManager
            protected boolean shouldCalcLastItemHeight() {
                return TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.searchAdapter;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
                int i3;
                View viewFindViewByPosition;
                if (TrendingStickersLayout.this.scrollFromAnimator) {
                    return super.scrollVerticallyBy(i2, recycler, state);
                }
                TrendingStickersLayout trendingStickersLayout = TrendingStickersLayout.this;
                int i4 = 0;
                if (trendingStickersLayout.glueToTopAnimator != null) {
                    return 0;
                }
                if (trendingStickersLayout.gluedToTop) {
                    while (true) {
                        i3 = 1;
                        if (i4 >= getChildCount()) {
                            break;
                        }
                        int childAdapterPosition = TrendingStickersLayout.this.listView.getChildAdapterPosition(getChildAt(i4));
                        if (childAdapterPosition < 1) {
                            i3 = childAdapterPosition;
                            break;
                        }
                        i4++;
                    }
                    if (i3 == 0 && (viewFindViewByPosition = TrendingStickersLayout.this.layoutManager.findViewByPosition(i3)) != null && viewFindViewByPosition.getTop() - i2 > AndroidUtilities.dp(58.0f)) {
                        i2 = viewFindViewByPosition.getTop() - AndroidUtilities.dp(58.0f);
                    }
                }
                return super.scrollVerticallyBy(i2, recycler, state);
            }
        };
        this.layoutManager = fillLastGridLayoutManager;
        recyclerListView.setLayoutManager(fillLastGridLayoutManager);
        fillLastGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                if (TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter) {
                    return TrendingStickersLayout.this.searchAdapter.getSpanSize(i2);
                }
                if ((TrendingStickersLayout.this.adapter.cache.get(i2) instanceof Integer) || i2 >= TrendingStickersLayout.this.adapter.totalItems) {
                    return TrendingStickersLayout.this.adapter.stickersPerRow;
                }
                return 1;
            }
        });
        recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                if (TrendingStickersLayout.this.onScrollListener != null) {
                    TrendingStickersLayout.this.onScrollListener.onScrolled(TrendingStickersLayout.this.listView, i2, i3);
                }
                if (i3 <= 0 || TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter || !TrendingStickersLayout.this.loaded || TrendingStickersLayout.this.adapter.loadingMore || TrendingStickersLayout.this.adapter.endReached) {
                    return;
                }
                if (TrendingStickersLayout.this.layoutManager.findLastVisibleItemPosition() >= (TrendingStickersLayout.this.adapter.getItemCount() - ((TrendingStickersLayout.this.adapter.stickersPerRow + 1) * 10)) - 1) {
                    TrendingStickersLayout.this.adapter.loadMoreStickerSets();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (TrendingStickersLayout.this.onScrollListener != null) {
                    TrendingStickersLayout.this.onScrollListener.onScrollStateChanged(recyclerView, i2);
                }
            }
        });
        recyclerListView.setAdapter(trendingStickersAdapter);
        recyclerListView.setOnItemClickListener(onItemClickListener);
        addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        View view = new View(context);
        this.shadowView = view;
        view.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        view.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight());
        layoutParams.topMargin = AndroidUtilities.dp(58.0f);
        addView(view, layoutParams);
        addView(frameLayout, LayoutHelper.createFrame(-1, 58, 51));
        updateColors();
        NotificationCenter notificationCenter = NotificationCenter.getInstance(i);
        notificationCenter.addObserver(this, NotificationCenter.stickersDidLoad);
        notificationCenter.addObserver(this, NotificationCenter.featuredStickersDidLoad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        TLRPC$StickerSetCovered setForPosition;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        StickersSearchAdapter stickersSearchAdapter = this.searchAdapter;
        if (adapter == stickersSearchAdapter) {
            setForPosition = stickersSearchAdapter.getSetForPosition(i);
        } else {
            setForPosition = i < this.adapter.totalItems ? (TLRPC$StickerSetCovered) this.adapter.positionsToSets.get(i) : null;
        }
        if (setForPosition != null) {
            showStickerSet(setForPosition.set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(Delegate delegate, RecyclerListView.OnItemClickListener onItemClickListener, View view, MotionEvent motionEvent) {
        return delegate.onListViewTouchEvent(this.listView, onItemClickListener, motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.wasLayout) {
            return;
        }
        this.wasLayout = true;
        this.adapter.refreshStickerSets();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateLastItemInAdapter();
        this.wasLayout = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.motionEventCatchedByListView = false;
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!this.motionEventCatchedByListView) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            this.listView.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        return zDispatchTouchEvent;
    }

    private void showStickerSet(TLRPC$StickerSet tLRPC$StickerSet) {
        showStickerSet(tLRPC$StickerSet, null);
    }

    public void showStickerSet(TLRPC$StickerSet tLRPC$StickerSet, TLRPC$InputStickerSet tLRPC$InputStickerSet) {
        if (tLRPC$StickerSet != null) {
            tLRPC$InputStickerSet = new TLRPC$TL_inputStickerSetID();
            tLRPC$InputStickerSet.access_hash = tLRPC$StickerSet.access_hash;
            tLRPC$InputStickerSet.id = tLRPC$StickerSet.id;
        }
        if (tLRPC$InputStickerSet != null) {
            showStickerSet(tLRPC$InputStickerSet);
        }
    }

    private void showStickerSet(final TLRPC$InputStickerSet tLRPC$InputStickerSet) {
        StickersAlert stickersAlert = new StickersAlert(getContext(), this.parentFragment, tLRPC$InputStickerSet, null, this.delegate.canSendSticker() ? new StickersAlert.StickersAlertDelegate() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.7
            @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
            /* renamed from: onStickerSelected */
            public void lambda$onStickerSelected$33(TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, boolean z2, int i) {
                TrendingStickersLayout.this.delegate.onStickerSelected(tLRPC$Document, obj, z, z2, i);
            }

            @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
            public boolean canSchedule() {
                return TrendingStickersLayout.this.delegate.canSchedule();
            }

            @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
            public boolean isInScheduleMode() {
                return TrendingStickersLayout.this.delegate.isInScheduleMode();
            }
        } : null);
        stickersAlert.setShowTooltipWhenToggle(false);
        stickersAlert.setInstallDelegate(new StickersAlert.StickersAlertInstallDelegate() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.8
            @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetUninstalled() {
            }

            @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetInstalled() {
                if (TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter) {
                    TrendingStickersLayout.this.searchAdapter.installStickerSet(tLRPC$InputStickerSet);
                    return;
                }
                for (int i = 0; i < TrendingStickersLayout.this.adapter.sets.size(); i++) {
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) TrendingStickersLayout.this.adapter.sets.get(i);
                    if (tLRPC$StickerSetCovered.set.id == tLRPC$InputStickerSet.id) {
                        TrendingStickersLayout.this.adapter.installStickerSet(tLRPC$StickerSetCovered, null);
                        return;
                    }
                }
            }
        });
        this.parentFragment.showDialog(stickersAlert);
    }

    public void recycle() {
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
        notificationCenter.removeObserver(this, NotificationCenter.stickersDidLoad);
        notificationCenter.removeObserver(this, NotificationCenter.featuredStickersDidLoad);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.stickersDidLoad) {
            if (((Integer) objArr[0]).intValue() == 0) {
                if (this.loaded) {
                    updateVisibleTrendingSets();
                    return;
                } else {
                    this.adapter.refreshStickerSets();
                    return;
                }
            }
            return;
        }
        if (i == NotificationCenter.featuredStickersDidLoad) {
            if (this.hash != MediaDataController.getInstance(this.currentAccount).getFeaturesStickersHashWithoutUnread()) {
                this.loaded = false;
            }
            if (this.loaded) {
                updateVisibleTrendingSets();
            } else {
                this.adapter.refreshStickerSets();
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setParentFragment(BaseFragment baseFragment) {
        this.parentFragment = baseFragment;
    }

    public void setContentViewPaddingTop(int i) {
        int iDp = i + AndroidUtilities.dp(58.0f);
        if (this.listView.getPaddingTop() != iDp) {
            this.ignoreLayout = true;
            this.listView.setPadding(0, iDp, 0, 0);
            this.ignoreLayout = false;
        }
    }

    private void updateLastItemInAdapter() {
        this.listView.getAdapter().notifyItemChanged(r0.getItemCount() - 1);
    }

    public int getContentTopOffset() {
        return this.topOffset;
    }

    public boolean update() {
        if (this.listView.getChildCount() <= 0) {
            int paddingTop = this.listView.getPaddingTop();
            this.topOffset = paddingTop;
            this.listView.setTopGlowOffset(paddingTop);
            this.searchLayout.setTranslationY(this.topOffset);
            this.shadowView.setTranslationY(this.topOffset);
            setShadowVisible(false);
            return true;
        }
        View childAt = this.listView.getChildAt(0);
        for (int i = 1; i < this.listView.getChildCount(); i++) {
            View childAt2 = this.listView.getChildAt(i);
            if (childAt2.getTop() < childAt.getTop()) {
                childAt = childAt2;
            }
        }
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(58.0f);
        int i2 = (top <= 0 || holder == null || holder.getAdapterPosition() != 0) ? 0 : top;
        setShadowVisible(top < 0);
        if (this.topOffset == i2) {
            return false;
        }
        this.topOffset = i2;
        this.listView.setTopGlowOffset(i2 + AndroidUtilities.dp(58.0f));
        this.searchLayout.setTranslationY(this.topOffset);
        this.shadowView.setTranslationY(this.topOffset);
        return true;
    }

    private void updateVisibleTrendingSets() {
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, adapter.getItemCount(), 0);
        }
    }

    private void setShadowVisible(boolean z) {
        if (this.shadowVisible != z) {
            this.shadowVisible = z;
            this.shadowView.animate().alpha(z ? 1.0f : 0.0f).setDuration(200L).start();
        }
    }

    public void updateColors() {
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        TrendingStickersAdapter trendingStickersAdapter = this.adapter;
        if (adapter == trendingStickersAdapter) {
            trendingStickersAdapter.updateColors(this.listView);
        } else {
            this.searchAdapter.updateColors(this.listView);
        }
    }

    public void getThemeDescriptions(List<ThemeDescription> list, ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate) {
        this.searchView.getThemeDescriptions(list);
        this.adapter.getThemeDescriptions(list, this.listView, themeDescriptionDelegate);
        this.searchAdapter.getThemeDescriptions(list, this.listView, themeDescriptionDelegate);
        list.add(new ThemeDescription(this.shadowView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogShadowLine));
        list.add(new ThemeDescription(this.searchLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogBackground));
    }

    public void glueToTop(boolean z) {
        this.gluedToTop = z;
        if (z) {
            if (getContentTopOffset() <= 0 || this.glueToTopAnimator != null) {
                return;
            }
            final int contentTopOffset = getContentTopOffset();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.glueToTopAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.9
                int dy = 0;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iFloatValue = (int) (contentTopOffset * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    TrendingStickersLayout.this.scrollFromAnimator = true;
                    TrendingStickersLayout.this.listView.scrollBy(0, iFloatValue - this.dy);
                    TrendingStickersLayout.this.scrollFromAnimator = false;
                    this.dy = iFloatValue;
                }
            });
            this.glueToTopAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.TrendingStickersLayout.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TrendingStickersLayout.this.glueToTopAnimator = null;
                }
            });
            this.glueToTopAnimator.setDuration(250L);
            this.glueToTopAnimator.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
            this.glueToTopAnimator.start();
            return;
        }
        ValueAnimator valueAnimator = this.glueToTopAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.glueToTopAnimator.cancel();
            this.glueToTopAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class TrendingStickersAdapter extends RecyclerListView.SelectionAdapter {
        private final Context context;
        private boolean endReached;
        private boolean loadingMore;
        private int totalItems;
        private final SparseArray<Object> cache = new SparseArray<>();
        private final ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();
        private final SparseArray<TLRPC$StickerSetCovered> positionsToSets = new SparseArray<>();
        private final ArrayList<TLRPC$StickerSetCovered> otherPacks = new ArrayList<>();
        private int stickersPerRow = 5;

        public TrendingStickersAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalItems + 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 3;
            }
            Object obj = this.cache.get(i);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            return obj.equals(-1) ? 4 : 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            FeaturedStickerSetInfoCell featuredStickerSetInfoCell = (FeaturedStickerSetInfoCell) view.getParent();
            TLRPC$StickerSetCovered stickerSet = featuredStickerSetInfoCell.getStickerSet();
            if (TrendingStickersLayout.this.installingStickerSets.indexOfKey(stickerSet.set.id) >= 0 || TrendingStickersLayout.this.removingStickerSets.indexOfKey(stickerSet.set.id) >= 0) {
                return;
            }
            if (featuredStickerSetInfoCell.isInstalled()) {
                TrendingStickersLayout.this.removingStickerSets.put(stickerSet.set.id, stickerSet);
                TrendingStickersLayout.this.delegate.onStickerSetRemove(stickerSet);
            } else {
                installStickerSet(stickerSet, featuredStickerSetInfoCell);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            FrameLayout emptyCell;
            if (i == 0) {
                StickerEmojiCell stickerEmojiCell = new StickerEmojiCell(this, this.context, false) { // from class: org.rbmain.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
                stickerEmojiCell.getImageView().setLayerNum(3);
                frameLayout = stickerEmojiCell;
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i == 2) {
                    FeaturedStickerSetInfoCell featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 17, true);
                    featuredStickerSetInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$TrendingStickersAdapter$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$0(view);
                        }
                    });
                    emptyCell = featuredStickerSetInfoCell;
                } else if (i == 3) {
                    emptyCell = new View(this.context);
                } else if (i == 4) {
                    emptyCell = new GraySectionCell(this.context);
                } else if (i != 5) {
                    emptyCell = null;
                } else {
                    FeaturedStickerSetCell2 featuredStickerSetCell2 = new FeaturedStickerSetCell2(this.context);
                    featuredStickerSetCell2.setAddOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$TrendingStickersAdapter$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$1(view);
                        }
                    });
                    featuredStickerSetCell2.getImageView().setLayerNum(3);
                    frameLayout = featuredStickerSetCell2;
                }
                return new RecyclerListView.Holder(emptyCell);
            }
            emptyCell = frameLayout;
            return new RecyclerListView.Holder(emptyCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
            FeaturedStickerSetCell2 featuredStickerSetCell2 = (FeaturedStickerSetCell2) view.getParent();
            TLRPC$StickerSetCovered stickerSet = featuredStickerSetCell2.getStickerSet();
            if (TrendingStickersLayout.this.installingStickerSets.indexOfKey(stickerSet.set.id) >= 0 || TrendingStickersLayout.this.removingStickerSets.indexOfKey(stickerSet.set.id) >= 0) {
                return;
            }
            if (featuredStickerSetCell2.isInstalled()) {
                TrendingStickersLayout.this.removingStickerSets.put(stickerSet.set.id, stickerSet);
                TrendingStickersLayout.this.delegate.onStickerSetRemove(stickerSet);
            } else {
                installStickerSet(stickerSet, featuredStickerSetCell2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((StickerEmojiCell) viewHolder.itemView).setSticker((TLRPC$Document) this.cache.get(i), this.positionsToSets.get(i), false);
            } else {
                if (itemViewType == 1) {
                    ((EmptyCell) viewHolder.itemView).setHeight(AndroidUtilities.dp(82.0f));
                    return;
                }
                if (itemViewType != 2) {
                    if (itemViewType == 4) {
                        ((GraySectionCell) viewHolder.itemView).setText(LocaleController.getString("OtherStickers", R.string.OtherStickers));
                        return;
                    } else if (itemViewType != 5) {
                        return;
                    }
                }
                bindStickerSetCell(viewHolder.itemView, i, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
            if (list.contains(0)) {
                int itemViewType = viewHolder.getItemViewType();
                if (itemViewType == 2 || itemViewType == 5) {
                    bindStickerSetCell(viewHolder.itemView, i, true);
                    return;
                }
                return;
            }
            super.onBindViewHolder(viewHolder, i, list);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void bindStickerSetCell(android.view.View r12, int r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 323
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.bindStickerSetCell(android.view.View, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
        
            r1 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        
            if (r1 >= r7.this$0.primaryInstallingStickerSets.length) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        
            if (r7.this$0.primaryInstallingStickerSets[r1] != null) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
        
            r7.this$0.primaryInstallingStickerSets[r1] = r8;
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
        
            r1 = r1 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
        
            r1 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        
            if (r1 != false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r9 == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        
            if ((r9 instanceof org.rbmain.ui.Cells.FeaturedStickerSetCell2) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
        
            ((org.rbmain.ui.Cells.FeaturedStickerSetCell2) r9).setDrawProgress(true, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
        
            if ((r9 instanceof org.rbmain.ui.Cells.FeaturedStickerSetInfoCell) == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        
            ((org.rbmain.ui.Cells.FeaturedStickerSetInfoCell) r9).setAddDrawProgress(true, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
        
            r7.this$0.installingStickerSets.put(r8.set.id, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
        
            if (r9 == null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
        
            r7.this$0.delegate.onStickerSetAdd(r8, r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
        
            r9 = r7.positionsToSets.size();
            r1 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        
            if (r1 >= r9) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
        
            r2 = r7.positionsToSets.get(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        
            if (r2 == null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
        
            if (r2.set.id != r8.set.id) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cd, code lost:
        
            notifyItemChanged(r1, 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d5, code lost:
        
            r1 = r1 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d8, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void installStickerSet(org.rbmain.tgnet.TLRPC$StickerSetCovered r8, android.view.View r9) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.installStickerSet(org.rbmain.tgnet.TLRPC$StickerSetCovered, android.view.View):void");
        }

        public void refreshStickerSets() {
            int i;
            int measuredWidth = TrendingStickersLayout.this.getMeasuredWidth();
            if (measuredWidth != 0) {
                this.stickersPerRow = Math.max(5, measuredWidth / AndroidUtilities.dp(72.0f));
                if (TrendingStickersLayout.this.layoutManager.getSpanCount() != this.stickersPerRow) {
                    TrendingStickersLayout.this.layoutManager.setSpanCount(this.stickersPerRow);
                    TrendingStickersLayout.this.loaded = false;
                }
            }
            if (TrendingStickersLayout.this.loaded) {
                return;
            }
            this.cache.clear();
            this.positionsToSets.clear();
            this.sets.clear();
            this.totalItems = 0;
            MediaDataController mediaDataController = MediaDataController.getInstance(TrendingStickersLayout.this.currentAccount);
            ArrayList arrayList = new ArrayList(mediaDataController.getFeaturedStickerSets());
            int size = arrayList.size();
            arrayList.addAll(this.otherPacks);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int iCeil = 1;
                if (i2 >= arrayList.size()) {
                    break;
                }
                TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) arrayList.get(i2);
                if (!tLRPC$StickerSetCovered.covers.isEmpty() || tLRPC$StickerSetCovered.cover != null) {
                    if (i2 == size) {
                        SparseArray<Object> sparseArray = this.cache;
                        int i4 = this.totalItems;
                        this.totalItems = i4 + 1;
                        sparseArray.put(i4, -1);
                    }
                    this.sets.add(tLRPC$StickerSetCovered);
                    this.positionsToSets.put(this.totalItems, tLRPC$StickerSetCovered);
                    SparseArray<Object> sparseArray2 = this.cache;
                    int i5 = this.totalItems;
                    this.totalItems = i5 + 1;
                    int i6 = i3 + 1;
                    sparseArray2.put(i5, Integer.valueOf(i3));
                    if (!tLRPC$StickerSetCovered.covers.isEmpty()) {
                        iCeil = (int) Math.ceil(tLRPC$StickerSetCovered.covers.size() / this.stickersPerRow);
                        for (int i7 = 0; i7 < tLRPC$StickerSetCovered.covers.size(); i7++) {
                            this.cache.put(this.totalItems + i7, tLRPC$StickerSetCovered.covers.get(i7));
                        }
                    } else {
                        this.cache.put(this.totalItems, tLRPC$StickerSetCovered.cover);
                    }
                    int i8 = 0;
                    while (true) {
                        i = this.stickersPerRow;
                        if (i8 >= iCeil * i) {
                            break;
                        }
                        this.positionsToSets.put(this.totalItems + i8, tLRPC$StickerSetCovered);
                        i8++;
                    }
                    this.totalItems += iCeil * i;
                    i3 = i6;
                }
                i2++;
            }
            if (this.totalItems != 0) {
                TrendingStickersLayout.this.loaded = true;
                TrendingStickersLayout.this.hash = mediaDataController.getFeaturesStickersHashWithoutUnread();
            }
            notifyDataSetChanged();
        }

        public void loadMoreStickerSets() {
            if (!TrendingStickersLayout.this.loaded || this.loadingMore || this.endReached) {
                return;
            }
            this.loadingMore = true;
            TLRPC$TL_messages_getOldFeaturedStickers tLRPC$TL_messages_getOldFeaturedStickers = new TLRPC$TL_messages_getOldFeaturedStickers();
            tLRPC$TL_messages_getOldFeaturedStickers.offset = this.otherPacks.size();
            tLRPC$TL_messages_getOldFeaturedStickers.limit = 40;
            ConnectionsManager.getInstance(TrendingStickersLayout.this.currentAccount).sendRequest(tLRPC$TL_messages_getOldFeaturedStickers, new RequestDelegate() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$TrendingStickersAdapter$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMoreStickerSets$3(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadMoreStickerSets$3(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.TrendingStickersLayout$TrendingStickersAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadMoreStickerSets$2(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadMoreStickerSets$2(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            int iCeil;
            int i;
            this.loadingMore = false;
            if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_messages_featuredStickers)) {
                ArrayList<TLRPC$StickerSetCovered> arrayList = ((TLRPC$TL_messages_featuredStickers) tLObject).sets;
                if (arrayList.size() < 40) {
                    this.endReached = true;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                if (this.otherPacks.isEmpty()) {
                    SparseArray<Object> sparseArray = this.cache;
                    int i2 = this.totalItems;
                    this.totalItems = i2 + 1;
                    sparseArray.put(i2, -1);
                }
                this.otherPacks.addAll(arrayList);
                int size = this.sets.size();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered = arrayList.get(i3);
                    if (!tLRPC$StickerSetCovered.covers.isEmpty() || tLRPC$StickerSetCovered.cover != null) {
                        this.sets.add(tLRPC$StickerSetCovered);
                        this.positionsToSets.put(this.totalItems, tLRPC$StickerSetCovered);
                        SparseArray<Object> sparseArray2 = this.cache;
                        int i4 = this.totalItems;
                        this.totalItems = i4 + 1;
                        int i5 = size + 1;
                        sparseArray2.put(i4, Integer.valueOf(size));
                        if (!tLRPC$StickerSetCovered.covers.isEmpty()) {
                            iCeil = (int) Math.ceil(tLRPC$StickerSetCovered.covers.size() / this.stickersPerRow);
                            for (int i6 = 0; i6 < tLRPC$StickerSetCovered.covers.size(); i6++) {
                                this.cache.put(this.totalItems + i6, tLRPC$StickerSetCovered.covers.get(i6));
                            }
                        } else {
                            this.cache.put(this.totalItems, tLRPC$StickerSetCovered.cover);
                            iCeil = 1;
                        }
                        int i7 = 0;
                        while (true) {
                            i = this.stickersPerRow;
                            if (i7 >= iCeil * i) {
                                break;
                            }
                            this.positionsToSets.put(this.totalItems + i7, tLRPC$StickerSetCovered);
                            i7++;
                        }
                        this.totalItems += iCeil * i;
                        size = i5;
                    }
                }
                notifyDataSetChanged();
                return;
            }
            this.endReached = true;
        }

        public void updateColors(RecyclerListView recyclerListView) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerListView.getChildAt(i);
                if (childAt instanceof FeaturedStickerSetInfoCell) {
                    ((FeaturedStickerSetInfoCell) childAt).updateColors();
                } else if (childAt instanceof FeaturedStickerSetCell2) {
                    ((FeaturedStickerSetCell2) childAt).updateColors();
                }
            }
        }

        public void getThemeDescriptions(List<ThemeDescription> list, RecyclerListView recyclerListView, ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate) {
            FeaturedStickerSetInfoCell.createThemeDescriptions(list, recyclerListView, themeDescriptionDelegate);
            FeaturedStickerSetCell2.createThemeDescriptions(list, recyclerListView, themeDescriptionDelegate);
            GraySectionCell.createThemeDescriptions(list, recyclerListView);
        }
    }
}
