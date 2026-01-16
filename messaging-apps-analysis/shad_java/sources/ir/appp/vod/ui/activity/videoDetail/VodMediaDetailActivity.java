package ir.appp.vod.ui.activity.videoDetail;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.domain.model.output.VodBriefEpisodeEntity;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.appp.vod.ui.activity.videoDetail.VodMediaDetailViewModel;
import ir.appp.vod.ui.customViews.VodLoadingCell;
import ir.appp.vod.ui.customViews.VodTrailerPreviewCell;
import ir.appp.vod.ui.customViews.VodVideoDetailCell;
import ir.appp.vod.ui.customViews.VodViewPagerLayout;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* compiled from: VodMediaDetailActivity.kt */
/* loaded from: classes3.dex */
public final class VodMediaDetailActivity extends LifecycleAwareBaseFragment {
    private boolean allowPullingDown;
    private final VodBriefMediaEntity briefMedia;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private final int listViewTopMargin;
    private VodLoadingCell loadingView;
    private int rowCount;
    private int sharedMediaRow;
    private final int trailerHeight;
    private VodTrailerPreviewCell trailerView;
    private VodVideoDetailCell videoDetailCell;
    private int videoDetailRow;
    private final Lazy viewModel$delegate;
    private VodMediaEntity vodDetailObject;
    private boolean vodSharedMediaLayoutAttached;
    private final int vodSharedMediaTopMargin;
    private VodViewPagerLayout vodViewPagerLayout;
    private final Paint whitePaint;

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPlayerActivity(VodBriefEpisodeEntity vodBriefEpisodeEntity) {
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return false;
    }

    public VodMediaDetailActivity(VodBriefMediaEntity briefMedia) {
        Intrinsics.checkNotNullParameter(briefMedia, "briefMedia");
        this.briefMedia = briefMedia;
        this.trailerHeight = 218;
        this.listViewTopMargin = 5;
        this.vodSharedMediaTopMargin = AndroidUtilities.dp(0.0f);
        this.whitePaint = new Paint();
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(new Function0<VodMediaDetailViewModel>() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VodMediaDetailViewModel invoke() {
                VodMediaDetailActivity vodMediaDetailActivity = this.this$0;
                ViewModel viewModel = new ViewModelProvider(vodMediaDetailActivity, new VodMediaDetailViewModel.VodMediaDetailViewModelFactory(vodMediaDetailActivity.briefMedia)).get(VodMediaDetailViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …del::class.java\n        )");
                return (VodMediaDetailViewModel) viewModel;
            }
        });
        this.hasOwnBackground = true;
    }

    public final RecyclerListView getListView() {
        return this.listView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VodMediaDetailViewModel getViewModel() {
        return (VodMediaDetailViewModel) this.viewModel$delegate.getValue();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRowsIds();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        if (actionBarCreateActionBar == null) {
            return null;
        }
        actionBarCreateActionBar.setItemsColor(-1, false);
        actionBarCreateActionBar.setBackgroundColor(-16777216);
        actionBarCreateActionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$createActionBar$1$1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    this.this$0.finishFragment();
                }
            }
        });
        return actionBarCreateActionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.createView(context);
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.rbmain.ui.LaunchActivity");
        }
        ((LaunchActivity) parentActivity).applyTheme(true);
        NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(this, context);
        final VodLoadingCell vodLoadingCell = new VodLoadingCell(context);
        vodLoadingCell.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodMediaDetailActivity.m347createView$lambda2$lambda1(vodLoadingCell, this, view);
            }
        });
        this.loadingView = vodLoadingCell;
        nestedFrameLayout.setBackgroundColor(-16777216);
        nestedFrameLayout.addView(this.loadingView);
        this.fragmentView = nestedFrameLayout;
        initViews();
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createView$lambda-2$lambda-1, reason: not valid java name */
    public static final void m347createView$lambda2$lambda1(VodLoadingCell this_apply, VodMediaDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_apply.getLoadingMode() == VodLoadingCell.LoadingMode.RETRY) {
            this$0.getViewModel().getUseCaseGetMediaDetail().retry();
        }
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment
    public void onLifecycleCreate() {
        super.onLifecycleCreate();
        observeLiveData();
    }

    private final void initViews() {
        View view = this.fragmentView;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VodTrailerPreviewCell vodTrailerPreviewCell = new VodTrailerPreviewCell(context);
        vodTrailerPreviewCell.setOnWatchVideoClick(new Function0<Unit>() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$initViews$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.startPlayerActivity(null);
            }
        });
        this.trailerView = vodTrailerPreviewCell;
        linearLayout.addView(vodTrailerPreviewCell, LayoutHelper.createLinear(-1, this.trailerHeight));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        VodViewPagerLayout vodViewPagerLayout = new VodViewPagerLayout(context2, this, this.briefMedia, new Function1<VodBriefEpisodeEntity, Unit>() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.initViews.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VodBriefEpisodeEntity vodBriefEpisodeEntity) {
                invoke2(vodBriefEpisodeEntity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VodBriefEpisodeEntity episode) {
                Intrinsics.checkNotNullParameter(episode, "episode");
                VodMediaDetailActivity.this.startPlayerActivity(episode);
            }
        });
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.vodSharedMediaTopMargin;
        vodViewPagerLayout.setLayoutParams(layoutParams);
        this.vodViewPagerLayout = vodViewPagerLayout;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.listAdapter = new ListAdapter(this, context3);
        this.layoutManager = new LinearLayoutManager(getContext()) { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.initViews.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(recycler, "recycler");
                Intrinsics.checkNotNullParameter(state, "state");
                LinearLayoutManager linearLayoutManager = VodMediaDetailActivity.this.layoutManager;
                Intrinsics.checkNotNull(linearLayoutManager);
                boolean z = false;
                View viewFindViewByPosition = linearLayoutManager.findViewByPosition(0);
                if (viewFindViewByPosition != null) {
                    int top = viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f);
                    if (VodMediaDetailActivity.this.allowPullingDown || top <= i) {
                        if (VodMediaDetailActivity.this.allowPullingDown) {
                            if (i >= top) {
                                VodMediaDetailActivity.this.allowPullingDown = false;
                            } else {
                                RecyclerListView listView = VodMediaDetailActivity.this.getListView();
                                if (listView != null && listView.getScrollState() == 1) {
                                    z = true;
                                }
                                if (z) {
                                    i /= 2;
                                }
                            }
                        }
                    } else if (!AndroidUtilities.isTablet()) {
                        VodMediaDetailActivity.this.allowPullingDown = true;
                    }
                    i = top;
                }
                return super.scrollVerticallyBy(i, recycler, state);
            }
        };
        RecyclerListView recyclerListView = new RecyclerListView(getContext()) { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.initViews.5
            private VelocityTracker velocityTracker;

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            {
                new LinkedHashMap();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView
            protected boolean allowSelectChildAtPosition(View child) {
                Intrinsics.checkNotNullParameter(child, "child");
                return child != VodMediaDetailActivity.this.vodViewPagerLayout;
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                View view2 = VodMediaDetailActivity.this.fragmentView;
                if (view2 != null) {
                    view2.invalidate();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "e"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    int r0 = r7.getAction()
                    r1 = 0
                    r2 = 3
                    r3 = 1
                    if (r0 == 0) goto L38
                    if (r0 == r3) goto L2b
                    r4 = 2
                    if (r0 == r4) goto L16
                    if (r0 == r2) goto L2b
                    goto L51
                L16:
                    android.view.VelocityTracker r4 = r6.velocityTracker
                    if (r4 == 0) goto L51
                    if (r4 != 0) goto L1d
                    goto L20
                L1d:
                    r4.addMovement(r7)
                L20:
                    android.view.VelocityTracker r4 = r6.velocityTracker
                    if (r4 != 0) goto L25
                    goto L51
                L25:
                    r5 = 1000(0x3e8, float:1.401E-42)
                    r4.computeCurrentVelocity(r5)
                    goto L51
                L2b:
                    android.view.VelocityTracker r4 = r6.velocityTracker
                    if (r4 == 0) goto L51
                    if (r4 != 0) goto L32
                    goto L35
                L32:
                    r4.recycle()
                L35:
                    r6.velocityTracker = r1
                    goto L51
                L38:
                    android.view.VelocityTracker r4 = r6.velocityTracker
                    if (r4 != 0) goto L43
                    android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
                    r6.velocityTracker = r4
                    goto L49
                L43:
                    if (r4 != 0) goto L46
                    goto L49
                L46:
                    r4.clear()
                L49:
                    android.view.VelocityTracker r4 = r6.velocityTracker
                    if (r4 != 0) goto L4e
                    goto L51
                L4e:
                    r4.addMovement(r7)
                L51:
                    boolean r7 = super.onTouchEvent(r7)
                    if (r0 == r3) goto L5a
                    if (r0 == r2) goto L5a
                    goto L89
                L5a:
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r0 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    boolean r0 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.access$getAllowPullingDown$p(r0)
                    if (r0 == 0) goto L89
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.getLayoutManager()
                    r2 = 0
                    if (r0 != 0) goto L6a
                    goto L6e
                L6a:
                    android.view.View r1 = r0.findViewByPosition(r2)
                L6e:
                    if (r1 == 0) goto L89
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r0 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r0 = r0.getListView()
                    if (r0 != 0) goto L79
                    goto L89
                L79:
                    int r1 = r1.getTop()
                    r3 = 1118830592(0x42b00000, float:88.0)
                    int r3 = org.rbmain.messenger.AndroidUtilities.dp(r3)
                    int r1 = r1 - r3
                    org.rbmain.ui.Components.CubicBezierInterpolator r3 = org.rbmain.ui.Components.CubicBezierInterpolator.EASE_OUT_QUINT
                    r0.smoothScrollBy(r2, r1, r3)
                L89:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.AnonymousClass5.onTouchEvent(android.view.MotionEvent):boolean");
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean drawChild(android.graphics.Canvas r10, android.view.View r11, long r12) {
                /*
                    r9 = this;
                    java.lang.String r0 = "canvas"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    java.lang.String r0 = "child"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                    androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r9.getItemAnimator()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    boolean r0 = r0.isRunning()
                    if (r0 == 0) goto Ld6
                    android.graphics.drawable.Drawable r0 = r11.getBackground()
                    if (r0 != 0) goto Ld6
                    float r0 = r11.getTranslationY()
                    r1 = 0
                    r2 = 1
                    r3 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 != 0) goto L2a
                    r0 = 1
                    goto L2b
                L2a:
                    r0 = 0
                L2b:
                    if (r0 != 0) goto Ld6
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r0 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r0 = r0.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.getChildAdapterPosition(r11)
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    int r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.access$getSharedMediaRow$p(r1)
                    if (r0 != r1) goto L52
                    float r0 = r11.getAlpha()
                    r1 = 1065353216(0x3f800000, float:1.0)
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 != 0) goto L4e
                    r0 = 1
                    goto L4f
                L4e:
                    r0 = 0
                L4f:
                    if (r0 != 0) goto L52
                    goto L53
                L52:
                    r2 = 0
                L53:
                    r0 = 255(0xff, float:3.57E-43)
                    if (r2 == 0) goto L77
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    android.graphics.Paint r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.access$getWhitePaint$p(r1)
                    float r3 = (float) r0
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r4 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r4 = r4.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                    float r4 = r4.getAlpha()
                    float r3 = r3 * r4
                    float r4 = r11.getAlpha()
                    float r3 = r3 * r4
                    int r3 = (int) r3
                    r1.setAlpha(r3)
                L77:
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r1 = r1.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                    float r4 = r1.getX()
                    float r5 = r11.getY()
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r1 = r1.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                    float r1 = r1.getX()
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r3 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r3 = r3.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                    int r3 = r3.getMeasuredWidth()
                    float r3 = (float) r3
                    float r6 = r1 + r3
                    float r1 = r11.getY()
                    int r3 = r11.getHeight()
                    float r3 = (float) r3
                    float r7 = r1 + r3
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    android.graphics.Paint r8 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.access$getWhitePaint$p(r1)
                    r3 = r10
                    r3.drawRect(r4, r5, r6, r7, r8)
                    if (r2 == 0) goto Ld6
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    android.graphics.Paint r1 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.access$getWhitePaint$p(r1)
                    float r0 = (float) r0
                    ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity r2 = ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.this
                    ir.resaneh1.iptv.fragment.rubino.RecyclerListView r2 = r2.getListView()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    float r2 = r2.getAlpha()
                    float r0 = r0 * r2
                    int r0 = (int) r0
                    r1.setAlpha(r0)
                Ld6:
                    boolean r10 = super.drawChild(r10, r11, r12)
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity.AnonymousClass5.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        VodMediaDetailActivity$initViews$6$1 vodMediaDetailActivity$initViews$6$1 = new VodMediaDetailActivity$initViews$6$1(this);
        vodMediaDetailActivity$initViews$6$1.setSupportsChangeAnimations(false);
        vodMediaDetailActivity$initViews$6$1.setDelayAnimations(false);
        recyclerListView.setItemAnimator(vodMediaDetailActivity$initViews$6$1);
        recyclerListView.setClipToPadding(false);
        recyclerListView.setHideIfEmpty(false);
        recyclerListView.setBackgroundColor(-16777216);
        recyclerListView.setLayoutManager(this.layoutManager);
        recyclerListView.setGlowColor(0);
        recyclerListView.setAdapter(this.listAdapter);
        linearLayout.addView(this.listView, LayoutHelper.createLinear(-1, -1, 0.0f, this.listViewTopMargin, 0.0f, 0.0f));
        ((FrameLayout) view).addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f));
    }

    private final void observeLiveData() {
        getViewModel().getUseCaseGetMediaDetail().getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VodMediaDetailActivity.m348observeLiveData$lambda10(this.f$0, (BaseResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeLiveData$lambda-10, reason: not valid java name */
    public static final void m348observeLiveData$lambda10(VodMediaDetailActivity this$0, BaseResponse baseResponse) {
        VodLoadingCell vodLoadingCell;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseResponse instanceof BaseResponse.Loading) {
            this$0.showLoading(true);
            return;
        }
        if (baseResponse instanceof BaseResponse.Success) {
            this$0.vodDetailObject = ((VodMediaEntityOutput) ((BaseResponse.Success) baseResponse).getData()).getMedia();
            VodTrailerPreviewCell vodTrailerPreviewCell = this$0.trailerView;
            if (vodTrailerPreviewCell != null) {
                vodTrailerPreviewCell.setData(null, null);
            }
            ListAdapter listAdapter = this$0.listAdapter;
            if (listAdapter != null && listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
            this$0.showLoading(false);
            return;
        }
        if (!(baseResponse instanceof BaseResponse.Error) || (vodLoadingCell = this$0.loadingView) == null) {
            return;
        }
        vodLoadingCell.setMode(VodLoadingCell.LoadingMode.RETRY);
    }

    private final void showLoading(boolean z) {
        VodLoadingCell vodLoadingCell = this.loadingView;
        if (vodLoadingCell != null) {
            vodLoadingCell.setMode(VodLoadingCell.LoadingMode.LOADING);
        }
        VodLoadingCell vodLoadingCell2 = this.loadingView;
        if (vodLoadingCell2 != null) {
            vodLoadingCell2.setVisibility(z ? 0 : 8);
        }
        VodTrailerPreviewCell vodTrailerPreviewCell = this.trailerView;
        if (vodTrailerPreviewCell != null) {
            vodTrailerPreviewCell.setVisibility(z ? 4 : 0);
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            return;
        }
        recyclerListView.setVisibility(z ? 4 : 0);
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment
    public void onLifecycleResume() {
        super.onLifecycleResume();
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.rbmain.ui.LaunchActivity");
        }
        ((LaunchActivity) parentActivity).applyTheme(true);
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.listAdapter != null) {
            saveScrollPosition();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
        VodTrailerPreviewCell vodTrailerPreviewCell = this.trailerView;
        if (vodTrailerPreviewCell == null) {
            return;
        }
        vodTrailerPreviewCell.onResume();
    }

    private final void updateRowsIds() {
        this.rowCount = 0;
        this.videoDetailRow = -1;
        this.sharedMediaRow = -1;
        int i = 0 + 1;
        this.rowCount = i;
        this.videoDetailRow = 0;
        this.rowCount = i + 1;
        this.sharedMediaRow = i;
    }

    private final void saveScrollPosition() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null || this.layoutManager == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerListView);
        if (recyclerListView.getChildCount() > 0) {
            View childAt = null;
            int i = 0;
            RecyclerListView recyclerListView2 = this.listView;
            Intrinsics.checkNotNull(recyclerListView2);
            int childCount = recyclerListView2.getChildCount();
            int i2 = -1;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                int i3 = i + 1;
                RecyclerListView recyclerListView3 = this.listView;
                Intrinsics.checkNotNull(recyclerListView3);
                RecyclerListView recyclerListView4 = this.listView;
                Intrinsics.checkNotNull(recyclerListView4);
                int childAdapterPosition = recyclerListView3.getChildAdapterPosition(recyclerListView4.getChildAt(i));
                if (childAdapterPosition != -1) {
                    RecyclerListView recyclerListView5 = this.listView;
                    Intrinsics.checkNotNull(recyclerListView5);
                    childAt = recyclerListView5.getChildAt(i);
                    i2 = childAdapterPosition;
                    break;
                }
                i = i3;
                i2 = childAdapterPosition;
            }
            if (childAt != null) {
                LinearLayoutManager linearLayoutManager = this.layoutManager;
                Intrinsics.checkNotNull(linearLayoutManager);
                int top = childAt.getTop();
                RecyclerListView recyclerListView6 = this.listView;
                Intrinsics.checkNotNull(recyclerListView6);
                linearLayoutManager.scrollToPositionWithOffset(i2, top - recyclerListView6.getPaddingTop());
            }
        }
    }

    /* compiled from: VodMediaDetailActivity.kt */
    private final class NestedFrameLayout extends FrameLayout implements NestedScrollingParent3 {
        private final NestedScrollingParentHelper nestedScrollingParentHelper;
        final /* synthetic */ VodMediaDetailActivity this$0;

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5) {
            Intrinsics.checkNotNullParameter(target, "target");
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NestedFrameLayout(VodMediaDetailActivity this$0, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            Intrinsics.checkNotNull(context);
            new LinkedHashMap();
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        }

        @Override // androidx.core.view.NestedScrollingParent3
        public void onNestedScroll(View target, int i, int i2, int i3, int i4, int i5, int[] consumed) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            if (Intrinsics.areEqual(target, this.this$0.getListView()) && this.this$0.vodSharedMediaLayoutAttached) {
                VodViewPagerLayout vodViewPagerLayout = this.this$0.vodViewPagerLayout;
                org.rbmain.ui.Components.RecyclerListView currentListView = vodViewPagerLayout == null ? null : vodViewPagerLayout.getCurrentListView();
                VodViewPagerLayout vodViewPagerLayout2 = this.this$0.vodViewPagerLayout;
                Integer numValueOf = vodViewPagerLayout2 != null ? Integer.valueOf(vodViewPagerLayout2.getTop()) : null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    consumed[1] = i4;
                    if (currentListView == null) {
                        return;
                    }
                    currentListView.scrollBy(0, i4);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View target, float f, float f2) {
            Intrinsics.checkNotNullParameter(target, "target");
            return super.onNestedPreFling(target, f, f2);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View target, int i, int i2, int[] consumed, int i3) {
            View view;
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(consumed, "consumed");
            if (Intrinsics.areEqual(target, this.this$0.getListView())) {
                int top = -1;
                if (this.this$0.sharedMediaRow == -1 || !this.this$0.vodSharedMediaLayoutAttached) {
                    return;
                }
                VodViewPagerLayout vodViewPagerLayout = this.this$0.vodViewPagerLayout;
                Intrinsics.checkNotNull(vodViewPagerLayout);
                int top2 = vodViewPagerLayout.getTop();
                if (i2 >= 0 || top2 > 0) {
                    return;
                }
                VodViewPagerLayout vodViewPagerLayout2 = this.this$0.vodViewPagerLayout;
                org.rbmain.ui.Components.RecyclerListView currentListView = vodViewPagerLayout2 == null ? null : vodViewPagerLayout2.getCurrentListView();
                RecyclerView.LayoutManager layoutManager = currentListView == null ? null : currentListView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                Intrinsics.checkNotNull(linearLayoutManager);
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition != -1) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = currentListView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                    if (viewHolderFindViewHolderForAdapterPosition != null && (view = viewHolderFindViewHolderForAdapterPosition.itemView) != null) {
                        top = view.getTop();
                    }
                    int paddingTop = currentListView.getPaddingTop();
                    if (top == paddingTop && iFindFirstVisibleItemPosition == 0) {
                        return;
                    }
                    consumed[1] = iFindFirstVisibleItemPosition != 0 ? i2 : Math.max(i2, top - paddingTop);
                    currentListView.scrollBy(0, i2);
                }
            }
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View child, View target, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            return this.this$0.sharedMediaRow != -1 && i == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View child, View target, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(target, "target");
            this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, i);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View target, int i) {
            Intrinsics.checkNotNullParameter(target, "target");
            this.nestedScrollingParentHelper.onStopNestedScroll(target);
        }
    }

    /* compiled from: VodMediaDetailActivity.kt */
    private final class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;
        final /* synthetic */ VodMediaDetailActivity this$0;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return true;
        }

        public ListAdapter(VodMediaDetailActivity this$0, Context mContext) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.this$0 = this$0;
            this.mContext = mContext;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == 1) {
                this.this$0.videoDetailCell = new VodVideoDetailCell(this.this$0, this.mContext);
                VodVideoDetailCell vodVideoDetailCell = this.this$0.videoDetailCell;
                if (vodVideoDetailCell != null) {
                    final VodMediaDetailActivity vodMediaDetailActivity = this.this$0;
                    vodVideoDetailCell.setActionOnMediaListener(new VodVideoDetailCell.ActionOnMediaListener() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$ListAdapter$onCreateViewHolder$1
                        @Override // ir.appp.vod.ui.customViews.VodVideoDetailCell.ActionOnMediaListener
                        public void likeMedia(VodMediaEntity.LikeStatus action) {
                            Intrinsics.checkNotNullParameter(action, "action");
                            vodMediaDetailActivity.getViewModel().rateVideo(action);
                        }

                        @Override // ir.appp.vod.ui.customViews.VodVideoDetailCell.ActionOnMediaListener
                        public void playMedia() {
                            VodTrailerPreviewCell vodTrailerPreviewCell = vodMediaDetailActivity.trailerView;
                            if (vodTrailerPreviewCell != null) {
                                vodTrailerPreviewCell.hideWatchVideoView();
                            }
                            VodMediaEntity unused = vodMediaDetailActivity.vodDetailObject;
                        }
                    });
                }
                viewGroup = this.this$0.videoDetailCell;
            } else if (i == 2) {
                VodViewPagerLayout vodViewPagerLayout = this.this$0.vodViewPagerLayout;
                ViewParent parent2 = vodViewPagerLayout == null ? null : vodViewPagerLayout.getParent();
                viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.this$0.vodViewPagerLayout);
                }
                viewGroup = this.this$0.vodViewPagerLayout;
            }
            if (i != 2 && viewGroup != null) {
                viewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(viewGroup);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (Intrinsics.areEqual(holder.itemView, this.this$0.vodViewPagerLayout)) {
                this.this$0.vodSharedMediaLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (Intrinsics.areEqual(holder.itemView, this.this$0.vodViewPagerLayout)) {
                this.this$0.vodSharedMediaLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            VodMediaEntity unused = this.this$0.vodDetailObject;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.this$0.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.this$0.videoDetailRow) {
                return 1;
            }
            return i == this.this$0.sharedMediaRow ? 2 : 0;
        }
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        VodTrailerPreviewCell vodTrailerPreviewCell = this.trailerView;
        if (vodTrailerPreviewCell == null) {
            return;
        }
        vodTrailerPreviewCell.onPause();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        VodTrailerPreviewCell vodTrailerPreviewCell = this.trailerView;
        if (vodTrailerPreviewCell != null) {
            vodTrailerPreviewCell.onDestroy();
        }
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.rbmain.ui.LaunchActivity");
        }
        ((LaunchActivity) parentActivity).applyTheme();
    }
}
