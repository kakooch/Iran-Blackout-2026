package ir.appp.vod.ui.customViews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.domain.model.VodSeasonReadEntity;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodBriefEpisodeEntity;
import ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity;
import ir.appp.vod.ui.activity.videoDetail.VodMediaExtraDataViewModel;
import ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip;
import ir.appp.vod.ui.customViews.VodViewPagerLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.RecyclerAnimationScrollHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: VodViewPagerLayout.kt */
/* loaded from: classes3.dex */
public final class VodViewPagerLayout extends FrameLayout {
    private boolean animatingForward;
    private boolean backAnimation;
    private final VodBriefMediaEntity briefMedia;
    private int episodeItemEndRow;
    private int episodeItemStartRow;
    private int episodeLoadingRow;
    private Map<Integer, Boolean> episodeObserved;
    private int episodeRowCount;
    private ArrayList<VodBriefEpisodeEntity> episodes;
    private EpisodesAdapter episodesAdapter;
    private int initialTab;
    private final Interpolator interpolator;
    private int lastMeasuredTopPadding;
    private boolean loadingEpisodes;
    private boolean loadingRelated;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    private final ArrayList<MediaPage> mediaPages;
    private final Function1<VodBriefEpisodeEntity, Unit> onEpisodeClicked;
    private int relatedItemEndRow;
    private int relatedItemStartRow;
    private int relatedLoadingRow;
    private boolean relatedObserved;
    private int relatedRowCount;
    private ArrayList<VodBriefMediaEntity> relatedVideos;
    private RelatedVideosAdapter relatedVideosAdapter;
    private GetRelatedOutput relatedVideosObject;
    private VodScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private int seasonTabRow;
    private List<VodSeasonReadEntity> seasons;
    private View shadowLine;
    private boolean showEpisodesTab;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private int topPadding;
    private VelocityTracker velocityTracker;
    private final VodMediaDetailActivity videoDetailActivity;
    private VodMediaExtraDataViewModel videoExtraDataViewModel;
    private VodListView vodListView;

    static {
        new Companion(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: interpolator$lambda-0, reason: not valid java name */
    public static final float m379interpolator$lambda0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VodViewPagerLayout(Context context, VodMediaDetailActivity videoDetailActivity, VodBriefMediaEntity briefMedia, Function1<? super VodBriefEpisodeEntity, Unit> onEpisodeClicked) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoDetailActivity, "videoDetailActivity");
        Intrinsics.checkNotNullParameter(briefMedia, "briefMedia");
        Intrinsics.checkNotNullParameter(onEpisodeClicked, "onEpisodeClicked");
        new LinkedHashMap();
        this.videoDetailActivity = videoDetailActivity;
        this.briefMedia = briefMedia;
        this.onEpisodeClicked = onEpisodeClicked;
        this.episodeObserved = new LinkedHashMap();
        this.mediaPages = new ArrayList<>();
        this.episodes = new ArrayList<>();
        this.relatedVideos = new ArrayList<>();
        this.interpolator = new Interpolator() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$$ExternalSyntheticLambda0
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return VodViewPagerLayout.m379interpolator$lambda0(f);
            }
        };
        this.videoExtraDataViewModel = (VodMediaExtraDataViewModel) new ViewModelProvider(videoDetailActivity, new VodMediaExtraDataViewModel.VodMediaExtraDataViewModelFactory(briefMedia)).get(VodMediaExtraDataViewModel.class);
        initViews();
    }

    /* compiled from: VodViewPagerLayout.kt */
    public static class MediaPage extends FrameLayout {
        private GridLayoutManager layoutManager;
        private RecyclerListView listView;
        private RecyclerAnimationScrollHelper scrollHelper;
        private int selectedType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaPage(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            new LinkedHashMap();
        }

        public final RecyclerListView getListView() {
            return this.listView;
        }

        public final void setListView(RecyclerListView recyclerListView) {
            this.listView = recyclerListView;
        }

        public final GridLayoutManager getLayoutManager() {
            return this.layoutManager;
        }

        public final void setLayoutManager(GridLayoutManager gridLayoutManager) {
            this.layoutManager = gridLayoutManager;
        }

        public final RecyclerAnimationScrollHelper getScrollHelper() {
            return this.scrollHelper;
        }

        public final void setScrollHelper(RecyclerAnimationScrollHelper recyclerAnimationScrollHelper) {
            this.scrollHelper = recyclerAnimationScrollHelper;
        }

        public final int getSelectedType() {
            return this.selectedType;
        }

        public final void setSelectedType(int i) {
            this.selectedType = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initViews() {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.VodViewPagerLayout.initViews():void");
    }

    private final VodScrollSlidingTextTabStrip createScrollingTextTabStrip(Context context) {
        VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip = new VodScrollSlidingTextTabStrip(context);
        int i = this.initialTab;
        if (i != -1) {
            vodScrollSlidingTextTabStrip.setInitialTabId(i);
            this.initialTab = -1;
        }
        vodScrollSlidingTextTabStrip.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        vodScrollSlidingTextTabStrip.setDelegate(new VodScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout.createScrollingTextTabStrip.1
            @Override // ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float f) {
                if (!(f == 1.0f) || ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).getVisibility() == 0) {
                    if (VodViewPagerLayout.this.animatingForward) {
                        ((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).setTranslationX((-f) * ((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth());
                        ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).setTranslationX(((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth() - (((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth() * f));
                    } else {
                        ((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).setTranslationX(((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth() * f);
                        ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).setTranslationX((((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth() * f) - ((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getMeasuredWidth());
                    }
                    if (f == 1.0f) {
                        Object obj = VodViewPagerLayout.this.mediaPages.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj, "mediaPages[0]");
                        VodViewPagerLayout.this.mediaPages.set(0, VodViewPagerLayout.this.mediaPages.get(1));
                        VodViewPagerLayout.this.mediaPages.set(1, (MediaPage) obj);
                        ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).setVisibility(8);
                    }
                }
            }
        });
        return vodScrollSlidingTextTabStrip;
    }

    private final boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
        VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        Intrinsics.checkNotNull(vodScrollSlidingTextTabStrip);
        int nextPageId = vodScrollSlidingTextTabStrip.getNextPageId(z);
        if (nextPageId < 0) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.startedTrackingX = (int) motionEvent.getX();
        VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip2 = this.scrollSlidingTextTabStrip;
        if (vodScrollSlidingTextTabStrip2 != null) {
            vodScrollSlidingTextTabStrip2.setEnabled(false);
        }
        this.mediaPages.get(1).setSelectedType(nextPageId);
        this.mediaPages.get(1).setVisibility(0);
        this.animatingForward = z;
        switchToCurrentSelectedMode(nextPageId, true);
        if (z) {
            this.mediaPages.get(1).setTranslationX(this.mediaPages.get(0).getMeasuredWidth());
        } else {
            this.mediaPages.get(1).setTranslationX(-this.mediaPages.get(0).getMeasuredWidth());
        }
        return true;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.topPadding = i2;
        int size = this.mediaPages.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mediaPages.get(i5).setTranslationY(this.topPadding - this.lastMeasuredTopPadding);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        ir.resaneh1.iptv.fragment.rubino.RecyclerListView listView = this.videoDetailActivity.getListView();
        Intrinsics.checkNotNull(listView);
        int height = listView.getHeight();
        if (height == 0) {
            height = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(size, height);
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            int i4 = i3 + 1;
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (childAt instanceof MediaPage) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(height, 1073741824), 0);
                    RecyclerListView listView2 = ((MediaPage) childAt).getListView();
                    if (listView2 != null) {
                        listView2.setPadding(0, 0, 0, this.topPadding);
                    }
                } else {
                    measureChildWithMargins(childAt, i, 0, i2, 0);
                }
            }
            i3 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean checkTabsAnimationInProgress() {
        /*
            r7 = this;
            boolean r0 = r7.tabsAnimationInProgress
            r1 = 0
            if (r0 == 0) goto La2
            boolean r0 = r7.backAnimation
            r2 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r0 == 0) goto L4d
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r1)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L8d
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r1)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            r0.setTranslationX(r3)
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r5)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r3 = r7.mediaPages
            java.lang.Object r3 = r3.get(r1)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r3 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r3
            int r3 = r3.getMeasuredWidth()
            boolean r4 = r7.animatingForward
            if (r4 == 0) goto L46
            r2 = 1
        L46:
            int r3 = r3 * r2
            float r2 = (float) r3
            r0.setTranslationX(r2)
            goto L8e
        L4d:
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r5)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L8d
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r1)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r4 = r7.mediaPages
            java.lang.Object r4 = r4.get(r1)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r4 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r4
            int r4 = r4.getMeasuredWidth()
            boolean r6 = r7.animatingForward
            if (r6 == 0) goto L7a
            goto L7b
        L7a:
            r2 = 1
        L7b:
            int r4 = r4 * r2
            float r2 = (float) r4
            r0.setTranslationX(r2)
            java.util.ArrayList<ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage> r0 = r7.mediaPages
            java.lang.Object r0 = r0.get(r5)
            ir.appp.vod.ui.customViews.VodViewPagerLayout$MediaPage r0 = (ir.appp.vod.ui.customViews.VodViewPagerLayout.MediaPage) r0
            r0.setTranslationX(r3)
            goto L8e
        L8d:
            r5 = 0
        L8e:
            if (r5 == 0) goto L9f
            android.animation.AnimatorSet r0 = r7.tabsAnimation
            if (r0 == 0) goto L9d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.cancel()
            r0 = 0
            r7.tabsAnimation = r0
        L9d:
            r7.tabsAnimationInProgress = r1
        L9f:
            boolean r0 = r7.tabsAnimationInProgress
            return r0
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.VodViewPagerLayout.checkTabsAnimationInProgress():boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!checkTabsAnimationInProgress()) {
            VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
            if (!(vodScrollSlidingTextTabStrip != null && vodScrollSlidingTextTabStrip.isAnimatingIndicator()) && !onTouchEvent(ev)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        float fFloatValue;
        float fFloatValue2;
        float measuredWidth;
        float measuredWidth2;
        float fRint;
        boolean z;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.videoDetailActivity.getParentLayout() == null || this.videoDetailActivity.getParentLayout().checkTransitionAnimation() || checkTabsAnimationInProgress()) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
        }
        if (ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking && ev.getY() >= AndroidUtilities.dp(48.0f)) {
            this.startedTrackingPointerId = ev.getPointerId(0);
            this.maybeStartTracking = true;
            this.startedTrackingX = (int) ev.getX();
            this.startedTrackingY = (int) ev.getY();
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        } else if (ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
            int x = (int) (ev.getX() - this.startedTrackingX);
            int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
            if (this.startedTracking && (((z = this.animatingForward) && x > 0) || (!z && x < 0))) {
                if (!prepareForMoving(ev, x < 0)) {
                    this.maybeStartTracking = true;
                    this.startedTracking = false;
                    this.mediaPages.get(0).setTranslationX(0.0f);
                    this.mediaPages.get(1).setTranslationX(this.animatingForward ? this.mediaPages.get(0).getMeasuredWidth() : -this.mediaPages.get(0).getMeasuredWidth());
                    VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
                    if (vodScrollSlidingTextTabStrip != null) {
                        vodScrollSlidingTextTabStrip.selectTabWithId(this.mediaPages.get(1).getSelectedType(), 0.0f);
                    }
                }
            }
            if (!this.maybeStartTracking || this.startedTracking) {
                if (this.startedTracking) {
                    this.mediaPages.get(0).setTranslationX(x);
                    if (this.animatingForward) {
                        this.mediaPages.get(1).setTranslationX(this.mediaPages.get(0).getMeasuredWidth() + x);
                    } else {
                        this.mediaPages.get(1).setTranslationX(x - this.mediaPages.get(0).getMeasuredWidth());
                    }
                    float fAbs = Math.abs(x) / this.mediaPages.get(0).getMeasuredWidth();
                    VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip2 = this.scrollSlidingTextTabStrip;
                    if (vodScrollSlidingTextTabStrip2 != null) {
                        vodScrollSlidingTextTabStrip2.selectTabWithId(this.mediaPages.get(1).getSelectedType(), fAbs);
                    }
                }
            } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                prepareForMoving(ev, x < 0);
            }
        } else if (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6)) {
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, this.maximumVelocity);
            }
            if (ev.getAction() != 3) {
                VelocityTracker velocityTracker4 = this.velocityTracker;
                Float fValueOf = velocityTracker4 == null ? null : Float.valueOf(velocityTracker4.getXVelocity());
                Intrinsics.checkNotNull(fValueOf);
                fFloatValue = fValueOf.floatValue();
                VelocityTracker velocityTracker5 = this.velocityTracker;
                Float fValueOf2 = velocityTracker5 == null ? null : Float.valueOf(velocityTracker5.getYVelocity());
                Intrinsics.checkNotNull(fValueOf2);
                fFloatValue2 = fValueOf2.floatValue();
                if (!this.startedTracking && Math.abs(fFloatValue) >= 3000.0f && Math.abs(fFloatValue) > Math.abs(fFloatValue2)) {
                    prepareForMoving(ev, fFloatValue < 0.0f);
                }
            } else {
                fFloatValue = 0.0f;
                fFloatValue2 = 0.0f;
            }
            if (this.startedTracking) {
                float x2 = this.mediaPages.get(0).getX();
                this.tabsAnimation = new AnimatorSet();
                boolean z2 = Math.abs(x2) < ((float) this.mediaPages.get(0).getMeasuredWidth()) / 3.0f && (Math.abs(fFloatValue) < 3500.0f || Math.abs(fFloatValue) < Math.abs(fFloatValue2));
                this.backAnimation = z2;
                if (z2) {
                    measuredWidth = Math.abs(x2);
                    if (this.animatingForward) {
                        AnimatorSet animatorSet = this.tabsAnimation;
                        if (animatorSet != null) {
                            animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaPages.get(0), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages.get(1), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, this.mediaPages.get(1).getMeasuredWidth()));
                        }
                    } else {
                        AnimatorSet animatorSet2 = this.tabsAnimation;
                        if (animatorSet2 != null) {
                            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mediaPages.get(0), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.mediaPages.get(1), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, -this.mediaPages.get(1).getMeasuredWidth()));
                        }
                    }
                } else {
                    measuredWidth = this.mediaPages.get(0).getMeasuredWidth() - Math.abs(x2);
                    if (this.animatingForward) {
                        AnimatorSet animatorSet3 = this.tabsAnimation;
                        if (animatorSet3 != null) {
                            animatorSet3.playTogether(ObjectAnimator.ofFloat(this.mediaPages.get(0), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, -this.mediaPages.get(0).getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages.get(1), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, 0.0f));
                        }
                    } else {
                        AnimatorSet animatorSet4 = this.tabsAnimation;
                        if (animatorSet4 != null) {
                            animatorSet4.playTogether(ObjectAnimator.ofFloat(this.mediaPages.get(0), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, this.mediaPages.get(0).getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages.get(1), (Property<MediaPage, Float>) FrameLayout.TRANSLATION_X, 0.0f));
                        }
                    }
                }
                AnimatorSet animatorSet5 = this.tabsAnimation;
                if (animatorSet5 != null) {
                    animatorSet5.setInterpolator(this.interpolator);
                }
                int measuredWidth3 = getMeasuredWidth();
                float f = measuredWidth3 / 2;
                float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                if (Math.abs(fFloatValue) > 0.0f) {
                    measuredWidth2 = 4;
                    fRint = (float) Math.rint(Math.abs(fDistanceInfluenceForSnapDuration / r0) * 1000.0f);
                } else {
                    measuredWidth2 = (measuredWidth / getMeasuredWidth()) + 1.0f;
                    fRint = 100.0f;
                }
                int iMax = Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min((int) (measuredWidth2 * fRint), 600));
                AnimatorSet animatorSet6 = this.tabsAnimation;
                if (animatorSet6 != null) {
                    animatorSet6.setDuration(iMax);
                }
                AnimatorSet animatorSet7 = this.tabsAnimation;
                if (animatorSet7 != null) {
                    animatorSet7.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout.onTouchEvent.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Intrinsics.checkNotNullParameter(animator, "animator");
                            VodViewPagerLayout.this.tabsAnimation = null;
                            if (VodViewPagerLayout.this.backAnimation) {
                                ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).setVisibility(8);
                            } else {
                                Object obj = VodViewPagerLayout.this.mediaPages.get(0);
                                Intrinsics.checkNotNullExpressionValue(obj, "mediaPages[0]");
                                VodViewPagerLayout.this.mediaPages.set(0, VodViewPagerLayout.this.mediaPages.get(1));
                                VodViewPagerLayout.this.mediaPages.set(1, (MediaPage) obj);
                                ((MediaPage) VodViewPagerLayout.this.mediaPages.get(1)).setVisibility(8);
                                VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip3 = VodViewPagerLayout.this.scrollSlidingTextTabStrip;
                                if (vodScrollSlidingTextTabStrip3 != null) {
                                    vodScrollSlidingTextTabStrip3.selectTabWithId(((MediaPage) VodViewPagerLayout.this.mediaPages.get(0)).getSelectedType(), 1.0f);
                                }
                            }
                            VodViewPagerLayout.this.tabsAnimationInProgress = false;
                            VodViewPagerLayout.this.maybeStartTracking = false;
                            VodViewPagerLayout.this.startedTracking = false;
                            VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip4 = VodViewPagerLayout.this.scrollSlidingTextTabStrip;
                            if (vodScrollSlidingTextTabStrip4 == null) {
                                return;
                            }
                            vodScrollSlidingTextTabStrip4.setEnabled(true);
                        }
                    });
                }
                AnimatorSet animatorSet8 = this.tabsAnimation;
                Intrinsics.checkNotNull(animatorSet8);
                animatorSet8.start();
                this.tabsAnimationInProgress = true;
                this.startedTracking = false;
            } else {
                this.maybeStartTracking = false;
                VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip3 = this.scrollSlidingTextTabStrip;
                Intrinsics.checkNotNull(vodScrollSlidingTextTabStrip3);
                vodScrollSlidingTextTabStrip3.setEnabled(true);
            }
            VelocityTracker velocityTracker6 = this.velocityTracker;
            if (velocityTracker6 != null) {
                Intrinsics.checkNotNull(velocityTracker6);
                velocityTracker6.recycle();
                this.velocityTracker = null;
            }
        }
        return this.startedTracking;
    }

    private final void switchToCurrentSelectedMode(int i, boolean z) {
        RecyclerListView listView;
        RecyclerListView listView2;
        loadDataIfNeeded(i);
        Iterator<MediaPage> it = this.mediaPages.iterator();
        while (it.hasNext()) {
            RecyclerListView listView3 = it.next().getListView();
            if (listView3 != null) {
                listView3.stopScroll();
            }
        }
        RecyclerListView listView4 = this.mediaPages.get(z ? 1 : 0).getListView();
        RecyclerView.Adapter adapter = listView4 == null ? null : listView4.getAdapter();
        if (this.showEpisodesTab && this.mediaPages.get(z ? 1 : 0).getSelectedType() == 0) {
            if (adapter != this.episodesAdapter && (listView2 = this.mediaPages.get(z ? 1 : 0).getListView()) != null) {
                listView2.setAdapter(this.episodesAdapter);
            }
        } else if (((this.showEpisodesTab && this.mediaPages.get(z ? 1 : 0).getSelectedType() == 1) || (!this.showEpisodesTab && this.mediaPages.get(z ? 1 : 0).getSelectedType() == 0)) && adapter != this.relatedVideosAdapter && (listView = this.mediaPages.get(z ? 1 : 0).getListView()) != null) {
            listView.setAdapter(this.relatedVideosAdapter);
        }
        RecyclerListView listView5 = this.mediaPages.get(z ? 1 : 0).getListView();
        if (listView5 == null) {
            return;
        }
        listView5.setVisibility(0);
    }

    private final void loadDataIfNeeded(int i) {
        PagingRepositoryBuilder<GetRelatedOutput> relatedUseCase;
        LiveData<BaseResponse<GetRelatedOutput>> liveData;
        boolean z = this.showEpisodesTab;
        if ((!(z && i == 1) && (z || i != 0)) || this.relatedObserved) {
            return;
        }
        this.relatedObserved = true;
        VodMediaExtraDataViewModel vodMediaExtraDataViewModel = this.videoExtraDataViewModel;
        if (vodMediaExtraDataViewModel == null || (relatedUseCase = vodMediaExtraDataViewModel.getRelatedUseCase()) == null || (liveData = relatedUseCase.getLiveData()) == null) {
            return;
        }
        liveData.observe(this.videoDetailActivity.getViewLifecycleOwner(), new Observer() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VodViewPagerLayout.m380loadDataIfNeeded$lambda3(this.f$0, (BaseResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadDataIfNeeded$lambda-3, reason: not valid java name */
    public static final void m380loadDataIfNeeded$lambda3(VodViewPagerLayout this$0, BaseResponse baseResponse) {
        List<VodBriefMediaEntity> relatedMedia;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseResponse instanceof BaseResponse.Loading) {
            this$0.loadingRelated = true;
        } else if (baseResponse instanceof BaseResponse.Success) {
            this$0.loadingRelated = false;
            GetRelatedOutput getRelatedOutput = (GetRelatedOutput) ((BaseResponse.Success) baseResponse).getData();
            this$0.relatedVideosObject = getRelatedOutput;
            if (getRelatedOutput != null && (relatedMedia = getRelatedOutput.getRelatedMedia()) != null) {
                this$0.relatedVideos.clear();
                this$0.relatedVideos.addAll(relatedMedia);
            }
        } else if (baseResponse instanceof BaseResponse.Error) {
            this$0.loadingRelated = false;
        }
        this$0.updateRelatedRows();
    }

    /* compiled from: VodViewPagerLayout.kt */
    private final class RelatedVideosAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;
        final /* synthetic */ VodViewPagerLayout this$0;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return false;
        }

        public RelatedVideosAdapter(VodViewPagerLayout this$0, Context mContext) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.this$0 = this$0;
            this.mContext = mContext;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (int) Math.ceil(this.this$0.relatedRowCount / 3.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View vodLoadingCell;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == 0) {
                vodLoadingCell = new VodLoadingCell(this.mContext);
            } else if (i == 1) {
                vodLoadingCell = new VodRelatedVideoCell(this.mContext);
            } else {
                vodLoadingCell = new View(this.mContext);
            }
            vodLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(vodLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder.getItemViewType() == 1) {
                VodRelatedVideoCell vodRelatedVideoCell = (VodRelatedVideoCell) holder.itemView;
                vodRelatedVideoCell.setItemsCount(3);
                int i2 = 0;
                while (i2 < 3) {
                    int i3 = i * 3;
                    Object obj = this.this$0.relatedVideos.get(i3 + i2);
                    Intrinsics.checkNotNullExpressionValue(obj, "relatedVideos[position * columnsCount + a]");
                    VodBriefMediaEntity vodBriefMediaEntity = (VodBriefMediaEntity) obj;
                    vodRelatedVideoCell.setData(i2, vodBriefMediaEntity.getImageUrl());
                    vodRelatedVideoCell.setListener(i2, new VodViewPagerLayout$RelatedVideosAdapter$onBindViewHolder$1$1(vodBriefMediaEntity, vodRelatedVideoCell));
                    i2++;
                    if (i3 + i2 >= this.this$0.relatedVideos.size()) {
                        break;
                    }
                }
                vodRelatedVideoCell.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            boolean z = false;
            if (i == this.this$0.relatedLoadingRow) {
                return 0;
            }
            int i2 = this.this$0.relatedItemStartRow;
            if (i <= this.this$0.relatedItemEndRow && i2 <= i) {
                z = true;
            }
            return z ? 1 : 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSeasonTitleClicked() {
        List<VodSeasonReadEntity> list = this.seasons;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.size() <= 1) {
                return;
            }
            if (this.vodListView == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                final VodListView vodListView = new VodListView(context);
                ArrayList arrayList = new ArrayList();
                List<VodSeasonReadEntity> list2 = this.seasons;
                if (list2 != null) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((VodSeasonReadEntity) it.next()).getSeasonName());
                    }
                }
                vodListView.setList(arrayList);
                vodListView.setSelectedItemPosition(0);
                vodListView.setOnItemClicked(new Function2<Integer, String, Unit>() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$onSeasonTitleClicked$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i, String str) {
                        vodListView.setSelectedItemPosition(i);
                        VodListView vodListView2 = this.vodListView;
                        if (vodListView2 != null) {
                            vodListView2.setVisibility(8);
                        }
                        this.observeEpisodesBySeasonId(i);
                        VodViewPagerLayout.EpisodesAdapter episodesAdapter = this.episodesAdapter;
                        if (episodesAdapter == null) {
                            return;
                        }
                        episodesAdapter.notifyDataSetChanged();
                    }
                });
                vodListView.setOnCloseButtonClicked(new Function0<Unit>() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$onSeasonTitleClicked$1$3
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
                        VodListView vodListView2 = this.this$0.vodListView;
                        if (vodListView2 == null) {
                            return;
                        }
                        vodListView2.setVisibility(8);
                    }
                });
                this.vodListView = vodListView;
                View view = this.videoDetailActivity.fragmentView;
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
                }
                ((FrameLayout) view).addView(vodListView, -1, -1);
            }
            VodListView vodListView2 = this.vodListView;
            if (vodListView2 == null) {
                return;
            }
            vodListView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VodViewPagerLayout.kt */
    final class EpisodesAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;
        final /* synthetic */ VodViewPagerLayout this$0;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return false;
        }

        public EpisodesAdapter(VodViewPagerLayout this$0, Context mContext) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.this$0 = this$0;
            this.mContext = mContext;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.this$0.episodeRowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view;
            Intrinsics.checkNotNullParameter(parent, "parent");
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            if (i == 0) {
                VodSeasonTitleCell vodSeasonTitleCell = new VodSeasonTitleCell(this.mContext);
                final VodViewPagerLayout vodViewPagerLayout = this.this$0;
                vodSeasonTitleCell.setLayoutParams(layoutParams);
                vodSeasonTitleCell.getContentView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$EpisodesAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        VodViewPagerLayout.EpisodesAdapter.m383onCreateViewHolder$lambda1$lambda0(vodViewPagerLayout, view2);
                    }
                });
                view = vodSeasonTitleCell;
            } else if (i == 1) {
                FrameLayout vodLoadingCell = new VodLoadingCell(this.mContext);
                vodLoadingCell.setLayoutParams(layoutParams);
                view = vodLoadingCell;
            } else if (i == 2) {
                FrameLayout vodEpisodeCell = new VodEpisodeCell(this.mContext);
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(18.0f);
                vodEpisodeCell.setLayoutParams(layoutParams);
                view = vodEpisodeCell;
            } else {
                View view2 = new View(this.mContext);
                view2.setLayoutParams(layoutParams);
                view = view2;
            }
            return new RecyclerListView.Holder(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-1$lambda-0, reason: not valid java name */
        public static final void m383onCreateViewHolder$lambda1$lambda0(VodViewPagerLayout this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onSeasonTitleClicked();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
            /*
                r3 = this;
                java.lang.String r0 = "holder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                int r0 = r4.getItemViewType()
                if (r0 == 0) goto L37
                r1 = 2
                if (r0 == r1) goto L10
                goto Lbb
            L10:
                android.view.View r4 = r4.itemView
                ir.appp.vod.ui.customViews.VodEpisodeCell r4 = (ir.appp.vod.ui.customViews.VodEpisodeCell) r4
                ir.appp.vod.ui.customViews.VodViewPagerLayout r0 = r3.this$0
                java.util.ArrayList r1 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getEpisodes$p(r0)
                int r2 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getEpisodeItemStartRow$p(r0)
                int r5 = r5 - r2
                java.lang.Object r5 = r1.get(r5)
                java.lang.String r1 = "episodes[position - episodeItemStartRow]"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
                ir.appp.vod.domain.model.output.VodBriefEpisodeEntity r5 = (ir.appp.vod.domain.model.output.VodBriefEpisodeEntity) r5
                r4.setData(r5)
                ir.appp.vod.ui.customViews.VodViewPagerLayout$EpisodesAdapter$onBindViewHolder$1$1 r1 = new ir.appp.vod.ui.customViews.VodViewPagerLayout$EpisodesAdapter$onBindViewHolder$1$1
                r1.<init>()
                r4.setListener(r1)
                goto Lbb
            L37:
                android.view.View r4 = r4.itemView
                ir.appp.vod.ui.customViews.VodSeasonTitleCell r4 = (ir.appp.vod.ui.customViews.VodSeasonTitleCell) r4
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                r0 = 0
                r1 = 1
                if (r5 == 0) goto L56
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                int r5 = r5.size()
                if (r5 <= r1) goto L56
                r5 = 1
                goto L57
            L56:
                r5 = 0
            L57:
                r4.enableShowMoreOption(r5)
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                ir.appp.vod.ui.customViews.VodListView r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getVodListView$p(r5)
                r2 = 0
                if (r5 == 0) goto L87
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                if (r5 != 0) goto L6c
                goto Lb8
            L6c:
                ir.appp.vod.ui.customViews.VodViewPagerLayout r0 = r3.this$0
                ir.appp.vod.ui.customViews.VodListView r0 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getVodListView$p(r0)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                int r0 = r0.getSelectedItemPosition()
                java.lang.Object r5 = r5.get(r0)
                ir.appp.vod.domain.model.VodSeasonReadEntity r5 = (ir.appp.vod.domain.model.VodSeasonReadEntity) r5
                if (r5 != 0) goto L82
                goto Lb8
            L82:
                java.lang.String r2 = r5.getSeasonName()
                goto Lb8
            L87:
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                if (r5 == 0) goto Lb6
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                boolean r5 = r5.isEmpty()
                r5 = r5 ^ r1
                if (r5 == 0) goto Lb6
                ir.appp.vod.ui.customViews.VodViewPagerLayout r5 = r3.this$0
                java.util.List r5 = ir.appp.vod.ui.customViews.VodViewPagerLayout.access$getSeasons$p(r5)
                if (r5 != 0) goto La8
                goto Lb8
            La8:
                java.lang.Object r5 = r5.get(r0)
                ir.appp.vod.domain.model.VodSeasonReadEntity r5 = (ir.appp.vod.domain.model.VodSeasonReadEntity) r5
                if (r5 != 0) goto Lb1
                goto Lb8
            Lb1:
                java.lang.String r2 = r5.getSeasonName()
                goto Lb8
            Lb6:
                java.lang.String r2 = "Season title"
            Lb8:
                r4.setText(r2)
            Lbb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.ui.customViews.VodViewPagerLayout.EpisodesAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.this$0.seasonTabRow) {
                return 0;
            }
            if (i == this.this$0.episodeLoadingRow) {
                return 1;
            }
            return i <= this.this$0.episodeItemEndRow && this.this$0.episodeItemStartRow <= i ? 2 : 3;
        }
    }

    public final RecyclerListView getCurrentListView() {
        return this.mediaPages.get(0).getListView();
    }

    private final void updateEpisodeRows() {
        this.episodeRowCount = 0;
        this.seasonTabRow = -1;
        this.episodeLoadingRow = -1;
        this.episodeItemStartRow = -1;
        this.episodeItemEndRow = -1;
        int i = 0 + 1;
        this.episodeRowCount = i;
        this.seasonTabRow = 0;
        if (this.loadingEpisodes) {
            this.episodeRowCount = i + 1;
            this.episodeLoadingRow = i;
        } else if (!this.episodes.isEmpty()) {
            int i2 = this.episodeRowCount;
            this.episodeItemStartRow = i2;
            int size = i2 + this.episodes.size();
            this.episodeRowCount = size;
            this.episodeItemEndRow = size;
        }
        EpisodesAdapter episodesAdapter = this.episodesAdapter;
        if (episodesAdapter == null) {
            return;
        }
        episodesAdapter.notifyDataSetChanged();
    }

    private final void updateRelatedRows() {
        this.relatedRowCount = 0;
        this.relatedLoadingRow = -1;
        this.relatedItemStartRow = -1;
        this.relatedItemEndRow = -1;
        if (this.loadingRelated) {
            this.relatedRowCount = 0 + 1;
            this.relatedLoadingRow = 0;
        } else if (!this.relatedVideos.isEmpty()) {
            int i = this.relatedRowCount;
            this.relatedItemStartRow = i;
            int size = i + this.relatedVideos.size();
            this.relatedRowCount = size;
            this.relatedItemEndRow = size;
        }
        RelatedVideosAdapter relatedVideosAdapter = this.relatedVideosAdapter;
        if (relatedVideosAdapter == null) {
            return;
        }
        relatedVideosAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeEpisodesBySeasonId(final int i) {
        VodMediaExtraDataViewModel vodMediaExtraDataViewModel;
        if (!this.episodeObserved.containsKey(Integer.valueOf(i))) {
            boolean z = false;
            if (this.seasons != null && (!r0.isEmpty())) {
                z = true;
            }
            if (!z || (vodMediaExtraDataViewModel = this.videoExtraDataViewModel) == null) {
                return;
            }
            List<VodSeasonReadEntity> list = this.seasons;
            Intrinsics.checkNotNull(list);
            LiveData<BaseResponse<GetEpisodesOutput>> liveDataEpisodesLiveData = vodMediaExtraDataViewModel.episodesLiveData(list.get(i).getSeasonId());
            if (liveDataEpisodesLiveData == null) {
                return;
            }
            liveDataEpisodesLiveData.observe(this.videoDetailActivity.getViewLifecycleOwner(), new Observer() { // from class: ir.appp.vod.ui.customViews.VodViewPagerLayout$$ExternalSyntheticLambda2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    VodViewPagerLayout.m381observeEpisodesBySeasonId$lambda8(this.f$0, i, (BaseResponse) obj);
                }
            });
            return;
        }
        this.episodes.clear();
        VodMediaExtraDataViewModel vodMediaExtraDataViewModel2 = this.videoExtraDataViewModel;
        BaseResponse<GetEpisodesOutput> value = null;
        if (vodMediaExtraDataViewModel2 != null) {
            List<VodSeasonReadEntity> list2 = this.seasons;
            Intrinsics.checkNotNull(list2);
            LiveData<BaseResponse<GetEpisodesOutput>> liveDataEpisodesLiveData2 = vodMediaExtraDataViewModel2.episodesLiveData(list2.get(i).getSeasonId());
            if (liveDataEpisodesLiveData2 != null) {
                value = liveDataEpisodesLiveData2.getValue();
            }
        }
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type ir.appp.common.domain.model.BaseResponse.Success<ir.appp.vod.domain.model.output.GetEpisodesOutput>");
        }
        List<VodBriefEpisodeEntity> episodes = ((GetEpisodesOutput) ((BaseResponse.Success) value).getData()).getEpisodes();
        if (episodes == null) {
            return;
        }
        this.episodes.addAll(episodes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeEpisodesBySeasonId$lambda-8, reason: not valid java name */
    public static final void m381observeEpisodesBySeasonId$lambda8(VodViewPagerLayout this$0, int i, BaseResponse baseResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (baseResponse instanceof BaseResponse.Loading) {
            this$0.loadingEpisodes = true;
        } else if (baseResponse instanceof BaseResponse.Success) {
            this$0.episodeObserved.put(Integer.valueOf(i), Boolean.TRUE);
            this$0.loadingEpisodes = false;
            List<VodBriefEpisodeEntity> episodes = ((GetEpisodesOutput) ((BaseResponse.Success) baseResponse).getData()).getEpisodes();
            if (episodes != null) {
                this$0.episodes.clear();
                this$0.episodes.addAll(episodes);
            }
        } else if (baseResponse instanceof BaseResponse.Error) {
            this$0.loadingEpisodes = false;
        }
        this$0.updateEpisodeRows();
    }

    /* compiled from: VodViewPagerLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
