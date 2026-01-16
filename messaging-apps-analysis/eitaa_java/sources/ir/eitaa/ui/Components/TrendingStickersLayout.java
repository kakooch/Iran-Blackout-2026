package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_messages_featuredStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getOldFeaturedStickers;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.StickersSearchAdapter;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.FeaturedStickerSetCell2;
import ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.StickerEmojiCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.StickersAlert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class TrendingStickersLayout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private final TrendingStickersAdapter adapter;
    private final int currentAccount;
    private final Delegate delegate;
    ValueAnimator glueToTopAnimator;
    private boolean gluedToTop;
    private long hash;
    private float highlightProgress;
    private boolean ignoreLayout;
    private final LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets;
    private final GridLayoutManager layoutManager;
    private final RecyclerListView listView;
    private boolean loaded;
    private boolean motionEventCatchedByListView;
    private RecyclerView.OnScrollListener onScrollListener;
    Paint paint;
    private BaseFragment parentFragment;
    private final TLRPC$StickerSetCovered[] primaryInstallingStickerSets;
    private final LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean scrollFromAnimator;
    private TLRPC$StickerSetCovered scrollToSet;
    private final StickersSearchAdapter searchAdapter;
    private final FrameLayout searchLayout;
    private final SearchField searchView;
    private final View shadowView;
    private boolean shadowVisible;
    private int topOffset;
    private boolean wasLayout;

    public static abstract class Delegate {
        private String[] lastSearchKeyboardLanguage = new String[0];

        public boolean canSendSticker() {
            return false;
        }

        public boolean isInScheduleMode() {
            return false;
        }

        public boolean onListViewInterceptTouchEvent(RecyclerListView listView, MotionEvent event) {
            return false;
        }

        public boolean onListViewTouchEvent(RecyclerListView listView, RecyclerListView.OnItemClickListener onItemClickListener, MotionEvent event) {
            return false;
        }

        public void onStickerSelected(TLRPC$Document sticker, Object parent, boolean clearsInputField, boolean notify, int scheduleDate) {
        }

        public abstract void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet, boolean primary);

        public abstract void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet);

        public String[] getLastSearchKeyboardLanguage() {
            return this.lastSearchKeyboardLanguage;
        }

        public void setLastSearchKeyboardLanguage(String[] language) {
            this.lastSearchKeyboardLanguage = language;
        }
    }

    public TrendingStickersLayout(Context context, Delegate delegate) {
        this(context, delegate, new TLRPC$StickerSetCovered[10], new LongSparseArray(), new LongSparseArray(), null, null);
    }

    public TrendingStickersLayout(Context context, final Delegate delegate, TLRPC$StickerSetCovered[] primaryInstallingStickerSets, LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets, LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets, TLRPC$StickerSetCovered scrollToSet, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.highlightProgress = 1.0f;
        this.paint = new Paint();
        this.delegate = delegate;
        this.primaryInstallingStickerSets = primaryInstallingStickerSets;
        this.installingStickerSets = installingStickerSets;
        this.removingStickerSets = removingStickerSets;
        this.scrollToSet = scrollToSet;
        this.resourcesProvider = resourcesProvider;
        TrendingStickersAdapter trendingStickersAdapter = new TrendingStickersAdapter(context);
        this.adapter = trendingStickersAdapter;
        this.searchAdapter = new StickersSearchAdapter(context, new StickersSearchAdapter.Delegate() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.1
            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void onSearchStart() {
                TrendingStickersLayout.this.searchView.getProgressDrawable().startAnimation();
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void onSearchStop() {
                TrendingStickersLayout.this.searchView.getProgressDrawable().stopAnimation();
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void setAdapterVisible(boolean visible) {
                boolean z = true;
                if (!visible || TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.searchAdapter) {
                    if (visible || TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.adapter) {
                        z = false;
                    } else {
                        TrendingStickersLayout.this.listView.setAdapter(TrendingStickersLayout.this.adapter);
                    }
                } else {
                    TrendingStickersLayout.this.listView.setAdapter(TrendingStickersLayout.this.searchAdapter);
                }
                if (!z || TrendingStickersLayout.this.listView.getAdapter().getItemCount() <= 0) {
                    return;
                }
                TrendingStickersLayout.this.layoutManager.scrollToPositionWithOffset(0, (-TrendingStickersLayout.this.listView.getPaddingTop()) + AndroidUtilities.dp(58.0f) + TrendingStickersLayout.this.topOffset, false);
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet, boolean primary) {
                delegate.onStickerSetAdd(stickerSet, primary);
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet) {
                delegate.onStickerSetRemove(stickerSet);
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public int getStickersPerRow() {
                return TrendingStickersLayout.this.adapter.stickersPerRow;
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public String[] getLastSearchKeyboardLanguage() {
                return delegate.getLastSearchKeyboardLanguage();
            }

            @Override // ir.eitaa.ui.Adapters.StickersSearchAdapter.Delegate
            public void setLastSearchKeyboardLanguage(String[] language) {
                delegate.setLastSearchKeyboardLanguage(language);
            }
        }, primaryInstallingStickerSets, installingStickerSets, removingStickerSets, resourcesProvider);
        FrameLayout frameLayout = new FrameLayout(context);
        this.searchLayout = frameLayout;
        frameLayout.setBackgroundColor(getThemedColor("dialogBackground"));
        SearchField searchField = new SearchField(context, true, resourcesProvider) { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.2
            @Override // ir.eitaa.ui.Components.SearchField
            public void onTextChange(String text) {
                TrendingStickersLayout.this.searchAdapter.search(text);
            }
        };
        this.searchView = searchField;
        searchField.setHint(LocaleController.getString("SearchTrendingStickersHint", R.string.SearchTrendingStickersHint));
        frameLayout.addView(searchField, LayoutHelper.createFrame(-1, -1, 48));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.3
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent event) {
                return super.onInterceptTouchEvent(event) || delegate.onListViewInterceptTouchEvent(this, event);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                TrendingStickersLayout.this.motionEventCatchedByListView = true;
                return super.dispatchTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                if (TrendingStickersLayout.this.glueToTopAnimator != null) {
                    return false;
                }
                return super.onTouchEvent(e);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (TrendingStickersLayout.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) (TrendingStickersLayout.this.topOffset + AndroidUtilities.dp(58.0f)));
            }
        };
        this.listView = recyclerListView;
        final RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$oLGmdnTc5b-xZURviXF-vmv9rbk
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$new$0$TrendingStickersLayout(view, i2);
            }
        };
        recyclerListView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$hKMtR1MbyuVZEYzXXif6NyBRIdU
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$new$1$TrendingStickersLayout(delegate, onItemClickListener, view, motionEvent);
            }
        });
        recyclerListView.setOverScrollMode(2);
        recyclerListView.setClipToPadding(false);
        recyclerListView.setItemAnimator(null);
        recyclerListView.setLayoutAnimation(null);
        FillLastGridLayoutManager fillLastGridLayoutManager = new FillLastGridLayoutManager(context, 5, AndroidUtilities.dp(58.0f), recyclerListView) { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.4
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected boolean isLayoutRTL() {
                return LocaleController.isRTL;
            }

            @Override // ir.eitaa.ui.Components.FillLastGridLayoutManager
            protected boolean shouldCalcLastItemHeight() {
                return TrendingStickersLayout.this.listView.getAdapter() == TrendingStickersLayout.this.searchAdapter;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                int i2;
                View viewFindViewByPosition;
                if (TrendingStickersLayout.this.scrollFromAnimator) {
                    return super.scrollVerticallyBy(dy, recycler, state);
                }
                TrendingStickersLayout trendingStickersLayout = TrendingStickersLayout.this;
                int i3 = 0;
                if (trendingStickersLayout.glueToTopAnimator != null) {
                    return 0;
                }
                if (trendingStickersLayout.gluedToTop) {
                    while (true) {
                        i2 = 1;
                        if (i3 >= getChildCount()) {
                            break;
                        }
                        int childAdapterPosition = TrendingStickersLayout.this.listView.getChildAdapterPosition(getChildAt(i3));
                        if (childAdapterPosition < 1) {
                            i2 = childAdapterPosition;
                            break;
                        }
                        i3++;
                    }
                    if (i2 == 0 && (viewFindViewByPosition = TrendingStickersLayout.this.layoutManager.findViewByPosition(i2)) != null && viewFindViewByPosition.getTop() - dy > AndroidUtilities.dp(58.0f)) {
                        dy = viewFindViewByPosition.getTop() - AndroidUtilities.dp(58.0f);
                    }
                }
                return super.scrollVerticallyBy(dy, recycler, state);
            }
        };
        this.layoutManager = fillLastGridLayoutManager;
        recyclerListView.setLayoutManager(fillLastGridLayoutManager);
        fillLastGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter) {
                    return TrendingStickersLayout.this.searchAdapter.getSpanSize(position);
                }
                if ((TrendingStickersLayout.this.adapter.cache.get(position) instanceof Integer) || position >= TrendingStickersLayout.this.adapter.totalItems) {
                    return TrendingStickersLayout.this.adapter.stickersPerRow;
                }
                return 1;
            }
        });
        recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (TrendingStickersLayout.this.onScrollListener != null) {
                    TrendingStickersLayout.this.onScrollListener.onScrolled(TrendingStickersLayout.this.listView, dx, dy);
                }
                if (dy <= 0 || TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter || !TrendingStickersLayout.this.loaded || TrendingStickersLayout.this.adapter.loadingMore || TrendingStickersLayout.this.adapter.endReached) {
                    return;
                }
                if (TrendingStickersLayout.this.layoutManager.findLastVisibleItemPosition() >= (TrendingStickersLayout.this.adapter.getItemCount() - ((TrendingStickersLayout.this.adapter.stickersPerRow + 1) * 10)) - 1) {
                    TrendingStickersLayout.this.adapter.loadMoreStickerSets();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (TrendingStickersLayout.this.onScrollListener != null) {
                    TrendingStickersLayout.this.onScrollListener.onScrollStateChanged(recyclerView, newState);
                }
            }
        });
        recyclerListView.setAdapter(trendingStickersAdapter);
        recyclerListView.setOnItemClickListener(onItemClickListener);
        addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        View view = new View(context);
        this.shadowView = view;
        view.setBackgroundColor(getThemedColor("dialogShadowLine"));
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
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$TrendingStickersLayout(View view, int i) {
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
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$TrendingStickersLayout(Delegate delegate, RecyclerListView.OnItemClickListener onItemClickListener, View view, MotionEvent motionEvent) {
        return delegate.onListViewTouchEvent(this.listView, onItemClickListener, motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Integer num;
        super.onLayout(changed, l, t, r, b);
        if (this.wasLayout) {
            return;
        }
        this.wasLayout = true;
        this.adapter.refreshStickerSets();
        if (this.scrollToSet == null || (num = (Integer) this.adapter.setsToPosition.get(this.scrollToSet)) == null) {
            return;
        }
        this.layoutManager.scrollToPositionWithOffset(num.intValue(), (-this.listView.getPaddingTop()) + AndroidUtilities.dp(58.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int y;
        float f = this.highlightProgress;
        if (f != 0.0f && this.scrollToSet != null) {
            float f2 = f - 0.0053333333f;
            this.highlightProgress = f2;
            if (f2 < 0.0f) {
                this.highlightProgress = 0.0f;
            } else {
                invalidate();
            }
            Integer num = (Integer) this.adapter.setsToPosition.get(this.scrollToSet);
            if (num != null) {
                View viewFindViewByPosition = this.layoutManager.findViewByPosition(num.intValue());
                int y2 = -1;
                if (viewFindViewByPosition != null) {
                    y2 = (int) viewFindViewByPosition.getY();
                    y = ((int) viewFindViewByPosition.getY()) + viewFindViewByPosition.getMeasuredHeight();
                } else {
                    y = -1;
                }
                View viewFindViewByPosition2 = this.layoutManager.findViewByPosition(num.intValue() + 1);
                if (viewFindViewByPosition2 != null) {
                    if (viewFindViewByPosition == null) {
                        y2 = (int) viewFindViewByPosition2.getY();
                    }
                    y = ((int) viewFindViewByPosition2.getY()) + viewFindViewByPosition2.getMeasuredHeight();
                }
                if (viewFindViewByPosition != null || viewFindViewByPosition2 != null) {
                    this.paint.setColor(Theme.getColor("featuredStickers_addButton"));
                    float f3 = this.highlightProgress;
                    this.paint.setAlpha((int) ((f3 < 0.06f ? f3 / 0.06f : 1.0f) * 25.5f));
                    canvas.drawRect(0.0f, y2, getMeasuredWidth(), y, this.paint);
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLastItemInAdapter();
        this.wasLayout = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.motionEventCatchedByListView = false;
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(ev);
        if (!this.motionEventCatchedByListView) {
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            this.listView.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        return zDispatchTouchEvent;
    }

    private void showStickerSet(TLRPC$StickerSet pack) {
        showStickerSet(pack, null);
    }

    public void showStickerSet(TLRPC$StickerSet pack, TLRPC$InputStickerSet inputStickerSet) {
        if (pack != null) {
            inputStickerSet = new TLRPC$TL_inputStickerSetID();
            inputStickerSet.access_hash = pack.access_hash;
            inputStickerSet.id = pack.id;
        }
        if (inputStickerSet != null) {
            showStickerSet(inputStickerSet);
        }
    }

    private void showStickerSet(final TLRPC$InputStickerSet inputStickerSet) {
        StickersAlert stickersAlert = new StickersAlert(getContext(), this.parentFragment, inputStickerSet, null, this.delegate.canSendSticker() ? new StickersAlert.StickersAlertDelegate() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.7
            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertDelegate
            /* renamed from: onStickerSelected */
            public void lambda$onStickerSelected$36(TLRPC$Document sticker, String query, Object parent, MessageObject.SendAnimationData sendAnimationData, boolean clearsInputField, boolean notify, int scheduleDate) {
                TrendingStickersLayout.this.delegate.onStickerSelected(sticker, parent, clearsInputField, notify, scheduleDate);
            }

            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertDelegate
            public boolean isInScheduleMode() {
                return TrendingStickersLayout.this.delegate.isInScheduleMode();
            }
        } : null, this.resourcesProvider);
        stickersAlert.setShowTooltipWhenToggle(false);
        stickersAlert.setInstallDelegate(new StickersAlert.StickersAlertInstallDelegate() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.8
            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetUninstalled() {
            }

            @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertInstallDelegate
            public void onStickerSetInstalled() {
                if (TrendingStickersLayout.this.listView.getAdapter() != TrendingStickersLayout.this.adapter) {
                    TrendingStickersLayout.this.searchAdapter.installStickerSet(inputStickerSet);
                    return;
                }
                for (int i = 0; i < TrendingStickersLayout.this.adapter.sets.size(); i++) {
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) TrendingStickersLayout.this.adapter.sets.get(i);
                    if (tLRPC$StickerSetCovered.set.id == inputStickerSet.id) {
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

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.stickersDidLoad) {
            if (((Integer) args[0]).intValue() == 0) {
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
        if (id == NotificationCenter.featuredStickersDidLoad) {
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

    public void setParentFragment(BaseFragment parentFragment) {
        this.parentFragment = parentFragment;
    }

    public void setContentViewPaddingTop(int paddingTop) {
        int iDp = paddingTop + AndroidUtilities.dp(58.0f);
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
            int itemCount = adapter.getItemCount();
            TrendingStickersAdapter trendingStickersAdapter = this.adapter;
            adapter.notifyItemRangeChanged(0, itemCount, 0);
        }
    }

    private void setShadowVisible(boolean visible) {
        if (this.shadowVisible != visible) {
            this.shadowVisible = visible;
            this.shadowView.animate().alpha(visible ? 1.0f : 0.0f).setDuration(200L).start();
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

    public void getThemeDescriptions(List<ThemeDescription> descriptions, ThemeDescription.ThemeDescriptionDelegate delegate) {
        this.searchView.getThemeDescriptions(descriptions);
        this.adapter.getThemeDescriptions(descriptions, this.listView, delegate);
        this.searchAdapter.getThemeDescriptions(descriptions, this.listView, delegate);
        descriptions.add(new ThemeDescription(this.shadowView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        descriptions.add(new ThemeDescription(this.searchLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
    }

    public void glueToTop(boolean glue) {
        this.gluedToTop = glue;
        if (glue) {
            if (getContentTopOffset() <= 0 || this.glueToTopAnimator != null) {
                return;
            }
            final int contentTopOffset = getContentTopOffset();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.glueToTopAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.9
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
            this.glueToTopAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
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
        private final HashMap<TLRPC$StickerSetCovered, Integer> setsToPosition = new HashMap<>();
        private final ArrayList<TLRPC$StickerSetCovered> otherPacks = new ArrayList<>();
        private int stickersPerRow = 5;

        public TrendingStickersAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalItems + 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == getItemCount() - 1) {
                return 3;
            }
            Object obj = this.cache.get(position);
            if (obj == null) {
                return 1;
            }
            if (obj instanceof TLRPC$Document) {
                return 0;
            }
            return obj.equals(-1) ? 4 : 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$TrendingStickersLayout$TrendingStickersAdapter(View view) {
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
        /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            FrameLayout emptyCell;
            if (i == 0) {
                StickerEmojiCell stickerEmojiCell = new StickerEmojiCell(this.context, false) { // from class: ir.eitaa.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
                stickerEmojiCell.getImageView().setLayerNum(3);
                frameLayout = stickerEmojiCell;
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i == 2) {
                    FeaturedStickerSetInfoCell featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 17, true, true, TrendingStickersLayout.this.resourcesProvider);
                    featuredStickerSetInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$TrendingStickersAdapter$eTFV4CDvVSW74LAf6eBqaSD_asw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$0$TrendingStickersLayout$TrendingStickersAdapter(view);
                        }
                    });
                    emptyCell = featuredStickerSetInfoCell;
                } else if (i == 3) {
                    emptyCell = new View(this.context);
                } else if (i == 4) {
                    emptyCell = new GraySectionCell(this.context, TrendingStickersLayout.this.resourcesProvider);
                } else if (i != 5) {
                    emptyCell = null;
                } else {
                    FeaturedStickerSetCell2 featuredStickerSetCell2 = new FeaturedStickerSetCell2(this.context, TrendingStickersLayout.this.resourcesProvider);
                    featuredStickerSetCell2.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$TrendingStickersAdapter$IVYQYn8icbJzlITZaJLhe0s2BsM
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$1$TrendingStickersLayout$TrendingStickersAdapter(view);
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
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$1$TrendingStickersLayout$TrendingStickersAdapter(View view) {
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ((StickerEmojiCell) holder.itemView).setSticker((TLRPC$Document) this.cache.get(position), this.positionsToSets.get(position), false);
            } else {
                if (itemViewType == 1) {
                    ((EmptyCell) holder.itemView).setHeight(AndroidUtilities.dp(82.0f));
                    return;
                }
                if (itemViewType != 2) {
                    if (itemViewType == 4) {
                        ((GraySectionCell) holder.itemView).setText(LocaleController.getString("OtherStickers", R.string.OtherStickers));
                        return;
                    } else if (itemViewType != 5) {
                        return;
                    }
                }
                bindStickerSetCell(holder.itemView, position, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
            if (payloads.contains(0)) {
                int itemViewType = holder.getItemViewType();
                if (itemViewType == 2 || itemViewType == 5) {
                    bindStickerSetCell(holder.itemView, position, true);
                    return;
                }
                return;
            }
            super.onBindViewHolder(holder, position, payloads);
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
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.bindStickerSetCell(android.view.View, int, boolean):void");
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
        
            if ((r9 instanceof ir.eitaa.ui.Cells.FeaturedStickerSetCell2) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
        
            ((ir.eitaa.ui.Cells.FeaturedStickerSetCell2) r9).setDrawProgress(true, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
        
            if ((r9 instanceof ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell) == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        
            ((ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell) r9).setAddDrawProgress(true, true);
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
        public void installStickerSet(ir.eitaa.tgnet.TLRPC$StickerSetCovered r8, android.view.View r9) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.TrendingStickersLayout.TrendingStickersAdapter.installStickerSet(ir.eitaa.tgnet.TLRPC$StickerSetCovered, android.view.View):void");
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
            this.setsToPosition.clear();
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
                    this.setsToPosition.put(tLRPC$StickerSetCovered, Integer.valueOf(this.totalItems));
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
            ConnectionsManager.getInstance(TrendingStickersLayout.this.currentAccount).sendRequest(tLRPC$TL_messages_getOldFeaturedStickers, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$TrendingStickersAdapter$W8r1x8BJqdqezQL_8j9tOhuwJRY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMoreStickerSets$3$TrendingStickersLayout$TrendingStickersAdapter(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadMoreStickerSets$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadMoreStickerSets$3$TrendingStickersLayout$TrendingStickersAdapter(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$TrendingStickersLayout$TrendingStickersAdapter$pATpYRZkuWTWucG7RZJKkEaMrVc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadMoreStickerSets$2$TrendingStickersLayout$TrendingStickersAdapter(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadMoreStickerSets$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadMoreStickerSets$2$TrendingStickersLayout$TrendingStickersAdapter(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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

        public void updateColors(RecyclerListView listView) {
            int childCount = listView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = listView.getChildAt(i);
                if (childAt instanceof FeaturedStickerSetInfoCell) {
                    ((FeaturedStickerSetInfoCell) childAt).updateColors();
                } else if (childAt instanceof FeaturedStickerSetCell2) {
                    ((FeaturedStickerSetCell2) childAt).updateColors();
                }
            }
        }

        public void getThemeDescriptions(List<ThemeDescription> descriptions, RecyclerListView listView, ThemeDescription.ThemeDescriptionDelegate delegate) {
            FeaturedStickerSetInfoCell.createThemeDescriptions(descriptions, listView, delegate);
            FeaturedStickerSetCell2.createThemeDescriptions(descriptions, listView, delegate);
            GraySectionCell.createThemeDescriptions(descriptions, listView);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
