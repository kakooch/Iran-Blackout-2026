package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.StatsController;
import ir.eitaa.messenger.time.JalaliCalendar;
import ir.eitaa.messenger.time.PersianDateFormatter;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScrollSlidingTextTabStrip;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DataUsageActivity extends BaseFragment {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.-$$Lambda$DataUsageActivity$pa67VEKyZKbz8VmRhVNVcffgcD4
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return DataUsageActivity.lambda$static$0(f);
        }
    };
    private boolean animatingForward;
    private boolean backAnimation;
    private int maximumVelocity;
    private ListAdapter mobileAdapter;
    private ListAdapter roamingAdapter;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private ListAdapter wifiAdapter;
    private Paint backgroundPaint = new Paint();
    private ViewPage[] viewPages = new ViewPage[2];
    private boolean swipeBackEnabled = true;

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    private class ViewPage extends FrameLayout {
        private LinearLayoutManager layoutManager;
        private RecyclerListView listView;
        private int selectedType;

        public ViewPage(Context context) {
            super(context);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        RecyclerListView.Holder holder;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("NetworkUsage", R.string.NetworkUsage));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setAddToContainer(false);
        int i = 1;
        this.actionBar.setClipContent(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.DataUsageActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    DataUsageActivity.this.finishFragment();
                }
            }
        });
        this.hasOwnBackground = true;
        this.mobileAdapter = new ListAdapter(context, 0);
        this.wifiAdapter = new ListAdapter(context, 1);
        this.roamingAdapter = new ListAdapter(context, 2);
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setUseSameWidth(true);
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.DataUsageActivity.2
            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public /* synthetic */ void onSamePageSelected() {
                ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int id, boolean forward) {
                if (DataUsageActivity.this.viewPages[0].selectedType == id) {
                    return;
                }
                DataUsageActivity dataUsageActivity = DataUsageActivity.this;
                dataUsageActivity.swipeBackEnabled = id == dataUsageActivity.scrollSlidingTextTabStrip.getFirstTabId();
                DataUsageActivity.this.viewPages[1].selectedType = id;
                DataUsageActivity.this.viewPages[1].setVisibility(0);
                DataUsageActivity.this.switchToCurrentSelectedMode(true);
                DataUsageActivity.this.animatingForward = forward;
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float progress) {
                if (progress != 1.0f || DataUsageActivity.this.viewPages[1].getVisibility() == 0) {
                    if (DataUsageActivity.this.animatingForward) {
                        DataUsageActivity.this.viewPages[0].setTranslationX((-progress) * DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                        DataUsageActivity.this.viewPages[1].setTranslationX(DataUsageActivity.this.viewPages[0].getMeasuredWidth() - (DataUsageActivity.this.viewPages[0].getMeasuredWidth() * progress));
                    } else {
                        DataUsageActivity.this.viewPages[0].setTranslationX(DataUsageActivity.this.viewPages[0].getMeasuredWidth() * progress);
                        DataUsageActivity.this.viewPages[1].setTranslationX((DataUsageActivity.this.viewPages[0].getMeasuredWidth() * progress) - DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                    }
                    if (progress == 1.0f) {
                        ViewPage viewPage = DataUsageActivity.this.viewPages[0];
                        DataUsageActivity.this.viewPages[0] = DataUsageActivity.this.viewPages[1];
                        DataUsageActivity.this.viewPages[1] = viewPage;
                        DataUsageActivity.this.viewPages[1].setVisibility(8);
                    }
                }
            }
        });
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.DataUsageActivity.3
            private boolean globalIgnoreLayout;
            private boolean maybeStartTracking;
            private boolean startedTracking;
            private int startedTrackingPointerId;
            private int startedTrackingX;
            private int startedTrackingY;
            private VelocityTracker velocityTracker;

            private boolean prepareForMoving(MotionEvent ev, boolean forward) {
                int nextPageId = DataUsageActivity.this.scrollSlidingTextTabStrip.getNextPageId(forward);
                if (nextPageId < 0) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                this.maybeStartTracking = false;
                this.startedTracking = true;
                this.startedTrackingX = (int) ev.getX();
                ((BaseFragment) DataUsageActivity.this).actionBar.setEnabled(false);
                DataUsageActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
                DataUsageActivity.this.viewPages[1].selectedType = nextPageId;
                DataUsageActivity.this.viewPages[1].setVisibility(0);
                DataUsageActivity.this.animatingForward = forward;
                DataUsageActivity.this.switchToCurrentSelectedMode(true);
                if (forward) {
                    DataUsageActivity.this.viewPages[1].setTranslationX(DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                } else {
                    DataUsageActivity.this.viewPages[1].setTranslationX(-DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                }
                return true;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                measureChildWithMargins(((BaseFragment) DataUsageActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                int measuredHeight = ((BaseFragment) DataUsageActivity.this).actionBar.getMeasuredHeight();
                this.globalIgnoreLayout = true;
                for (int i2 = 0; i2 < DataUsageActivity.this.viewPages.length; i2++) {
                    if (DataUsageActivity.this.viewPages[i2] != null && DataUsageActivity.this.viewPages[i2].listView != null) {
                        DataUsageActivity.this.viewPages[i2].listView.setPadding(0, measuredHeight, 0, AndroidUtilities.dp(4.0f));
                    }
                }
                this.globalIgnoreLayout = false;
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) DataUsageActivity.this).actionBar) {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (((BaseFragment) DataUsageActivity.this).parentLayout != null) {
                    ((BaseFragment) DataUsageActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) DataUsageActivity.this).actionBar.getMeasuredHeight() + ((int) ((BaseFragment) DataUsageActivity.this).actionBar.getTranslationY()));
                }
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.globalIgnoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean checkTabsAnimationInProgress() {
                /*
                    r7 = this;
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    boolean r0 = ir.eitaa.ui.DataUsageActivity.access$1500(r0)
                    r1 = 0
                    if (r0 == 0) goto Lc3
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    boolean r0 = ir.eitaa.ui.DataUsageActivity.access$1600(r0)
                    r2 = -1
                    r3 = 0
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 1
                    if (r0 == 0) goto L59
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r1]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r1]
                    r0.setTranslationX(r3)
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r5]
                    ir.eitaa.ui.DataUsageActivity r3 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r3 = ir.eitaa.ui.DataUsageActivity.access$000(r3)
                    r3 = r3[r1]
                    int r3 = r3.getMeasuredWidth()
                    ir.eitaa.ui.DataUsageActivity r4 = ir.eitaa.ui.DataUsageActivity.this
                    boolean r4 = ir.eitaa.ui.DataUsageActivity.access$500(r4)
                    if (r4 == 0) goto L52
                    r2 = 1
                L52:
                    int r3 = r3 * r2
                    float r2 = (float) r3
                    r0.setTranslationX(r2)
                    goto L9e
                L59:
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r5]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r1]
                    ir.eitaa.ui.DataUsageActivity r4 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r4 = ir.eitaa.ui.DataUsageActivity.access$000(r4)
                    r4 = r4[r1]
                    int r4 = r4.getMeasuredWidth()
                    ir.eitaa.ui.DataUsageActivity r6 = ir.eitaa.ui.DataUsageActivity.this
                    boolean r6 = ir.eitaa.ui.DataUsageActivity.access$500(r6)
                    if (r6 == 0) goto L8a
                    goto L8b
                L8a:
                    r2 = 1
                L8b:
                    int r4 = r4 * r2
                    float r2 = (float) r4
                    r0.setTranslationX(r2)
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity$ViewPage[] r0 = ir.eitaa.ui.DataUsageActivity.access$000(r0)
                    r0 = r0[r5]
                    r0.setTranslationX(r3)
                    goto L9e
                L9d:
                    r5 = 0
                L9e:
                    if (r5 == 0) goto Lbc
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.DataUsageActivity.access$1700(r0)
                    if (r0 == 0) goto Lb7
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.DataUsageActivity.access$1700(r0)
                    r0.cancel()
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    r2 = 0
                    ir.eitaa.ui.DataUsageActivity.access$1702(r0, r2)
                Lb7:
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    ir.eitaa.ui.DataUsageActivity.access$1502(r0, r1)
                Lbc:
                    ir.eitaa.ui.DataUsageActivity r0 = ir.eitaa.ui.DataUsageActivity.this
                    boolean r0 = ir.eitaa.ui.DataUsageActivity.access$1500(r0)
                    return r0
                Lc3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DataUsageActivity.AnonymousClass3.checkTabsAnimationInProgress():boolean");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return checkTabsAnimationInProgress() || DataUsageActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(ev);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                DataUsageActivity.this.backgroundPaint.setColor(Theme.getColor("windowBackgroundGray"));
                canvas.drawRect(0.0f, ((BaseFragment) DataUsageActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) DataUsageActivity.this).actionBar.getTranslationY(), getMeasuredWidth(), getMeasuredHeight(), DataUsageActivity.this.backgroundPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent ev) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (((BaseFragment) DataUsageActivity.this).parentLayout.checkTransitionAnimation() || checkTabsAnimationInProgress()) {
                    return false;
                }
                if (ev != null) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(ev);
                }
                if (ev != null && ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                    this.startedTrackingPointerId = ev.getPointerId(0);
                    this.maybeStartTracking = true;
                    this.startedTrackingX = (int) ev.getX();
                    this.startedTrackingY = (int) ev.getY();
                    this.velocityTracker.clear();
                } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                    int x = (int) (ev.getX() - this.startedTrackingX);
                    int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                    if (this.startedTracking && ((DataUsageActivity.this.animatingForward && x > 0) || (!DataUsageActivity.this.animatingForward && x < 0))) {
                        if (!prepareForMoving(ev, x < 0)) {
                            this.maybeStartTracking = true;
                            this.startedTracking = false;
                            DataUsageActivity.this.viewPages[0].setTranslationX(0.0f);
                            DataUsageActivity.this.viewPages[1].setTranslationX(DataUsageActivity.this.animatingForward ? DataUsageActivity.this.viewPages[0].getMeasuredWidth() : -DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                            DataUsageActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DataUsageActivity.this.viewPages[1].selectedType, 0.0f);
                        }
                    }
                    if (!this.maybeStartTracking || this.startedTracking) {
                        if (this.startedTracking) {
                            if (DataUsageActivity.this.animatingForward) {
                                DataUsageActivity.this.viewPages[0].setTranslationX(x);
                                DataUsageActivity.this.viewPages[1].setTranslationX(DataUsageActivity.this.viewPages[0].getMeasuredWidth() + x);
                            } else {
                                DataUsageActivity.this.viewPages[0].setTranslationX(x);
                                DataUsageActivity.this.viewPages[1].setTranslationX(x - DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                            }
                            DataUsageActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DataUsageActivity.this.viewPages[1].selectedType, Math.abs(x) / DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                        }
                    } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                        prepareForMoving(ev, x < 0);
                    }
                } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                    this.velocityTracker.computeCurrentVelocity(1000, DataUsageActivity.this.maximumVelocity);
                    if (ev == null || ev.getAction() == 3) {
                        xVelocity = 0.0f;
                        yVelocity = 0.0f;
                    } else {
                        xVelocity = this.velocityTracker.getXVelocity();
                        yVelocity = this.velocityTracker.getYVelocity();
                        if (!this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                            prepareForMoving(ev, xVelocity < 0.0f);
                        }
                    }
                    if (this.startedTracking) {
                        float x2 = DataUsageActivity.this.viewPages[0].getX();
                        DataUsageActivity.this.tabsAnimation = new AnimatorSet();
                        DataUsageActivity.this.backAnimation = Math.abs(x2) < ((float) DataUsageActivity.this.viewPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                        if (!DataUsageActivity.this.backAnimation) {
                            measuredWidth = DataUsageActivity.this.viewPages[0].getMeasuredWidth() - Math.abs(x2);
                            if (DataUsageActivity.this.animatingForward) {
                                DataUsageActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, -DataUsageActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            } else {
                                DataUsageActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, DataUsageActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            }
                        } else {
                            measuredWidth = Math.abs(x2);
                            if (DataUsageActivity.this.animatingForward) {
                                DataUsageActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, DataUsageActivity.this.viewPages[1].getMeasuredWidth()));
                            } else {
                                DataUsageActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DataUsageActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, -DataUsageActivity.this.viewPages[1].getMeasuredWidth()));
                            }
                        }
                        DataUsageActivity.this.tabsAnimation.setInterpolator(DataUsageActivity.interpolator);
                        int measuredWidth3 = getMeasuredWidth();
                        float f = measuredWidth3 / 2;
                        float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                        float fAbs = Math.abs(xVelocity);
                        if (fAbs > 0.0f) {
                            measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                        } else {
                            measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                        }
                        DataUsageActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                        DataUsageActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DataUsageActivity.3.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                DataUsageActivity.this.tabsAnimation = null;
                                if (DataUsageActivity.this.backAnimation) {
                                    DataUsageActivity.this.viewPages[1].setVisibility(8);
                                } else {
                                    ViewPage viewPage = DataUsageActivity.this.viewPages[0];
                                    DataUsageActivity.this.viewPages[0] = DataUsageActivity.this.viewPages[1];
                                    DataUsageActivity.this.viewPages[1] = viewPage;
                                    DataUsageActivity.this.viewPages[1].setVisibility(8);
                                    DataUsageActivity dataUsageActivity = DataUsageActivity.this;
                                    dataUsageActivity.swipeBackEnabled = dataUsageActivity.viewPages[0].selectedType == DataUsageActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                    DataUsageActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DataUsageActivity.this.viewPages[0].selectedType, 1.0f);
                                }
                                DataUsageActivity.this.tabsAnimationInProgress = false;
                                AnonymousClass3.this.maybeStartTracking = false;
                                AnonymousClass3.this.startedTracking = false;
                                ((BaseFragment) DataUsageActivity.this).actionBar.setEnabled(true);
                                DataUsageActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                            }
                        });
                        DataUsageActivity.this.tabsAnimation.start();
                        DataUsageActivity.this.tabsAnimationInProgress = true;
                        this.startedTracking = false;
                    } else {
                        this.maybeStartTracking = false;
                        ((BaseFragment) DataUsageActivity.this).actionBar.setEnabled(true);
                        DataUsageActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                return this.startedTracking;
            }
        };
        this.fragmentView = frameLayout;
        frameLayout.setWillNotDraw(false);
        int i2 = 0;
        int iFindFirstVisibleItemPosition = -1;
        int top = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i2 >= viewPageArr.length) {
                break;
            }
            if (i2 == 0 && viewPageArr[i2] != null && viewPageArr[i2].layoutManager != null) {
                iFindFirstVisibleItemPosition = this.viewPages[i2].layoutManager.findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition == this.viewPages[i2].layoutManager.getItemCount() - 1 || (holder = (RecyclerListView.Holder) this.viewPages[i2].listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
                    iFindFirstVisibleItemPosition = -1;
                } else {
                    top = holder.itemView.getTop();
                }
            }
            ViewPage viewPage = new ViewPage(context) { // from class: ir.eitaa.ui.DataUsageActivity.4
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (DataUsageActivity.this.tabsAnimationInProgress && DataUsageActivity.this.viewPages[0] == this) {
                        DataUsageActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DataUsageActivity.this.viewPages[1].selectedType, Math.abs(DataUsageActivity.this.viewPages[0].getTranslationX()) / DataUsageActivity.this.viewPages[0].getMeasuredWidth());
                    }
                }
            };
            frameLayout.addView(viewPage, LayoutHelper.createFrame(-1, -1.0f));
            ViewPage[] viewPageArr2 = this.viewPages;
            viewPageArr2[i2] = viewPage;
            LinearLayoutManager linearLayoutManager = viewPageArr2[i2].layoutManager = new LinearLayoutManager(context, i, z) { // from class: ir.eitaa.ui.DataUsageActivity.5
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }
            };
            final RecyclerListView recyclerListView = new RecyclerListView(context);
            this.viewPages[i2].listView = recyclerListView;
            this.viewPages[i2].listView.setScrollingTouchSlop(1);
            this.viewPages[i2].listView.setItemAnimator(null);
            this.viewPages[i2].listView.setClipToPadding(false);
            this.viewPages[i2].listView.setSectionsType(2);
            this.viewPages[i2].listView.setLayoutManager(linearLayoutManager);
            ViewPage[] viewPageArr3 = this.viewPages;
            viewPageArr3[i2].addView(viewPageArr3[i2].listView, LayoutHelper.createFrame(-1, -1.0f));
            this.viewPages[i2].listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DataUsageActivity$Fp-qEYX9_J6sluKCyhFLxk9cCbY
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i3) {
                    this.f$0.lambda$createView$2$DataUsageActivity(recyclerListView, view, i3);
                }
            });
            this.viewPages[i2].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.DataUsageActivity.6
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState != 1) {
                        int i3 = (int) (-((BaseFragment) DataUsageActivity.this).actionBar.getTranslationY());
                        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                        if (i3 == 0 || i3 == currentActionBarHeight) {
                            return;
                        }
                        if (i3 < currentActionBarHeight / 2) {
                            DataUsageActivity.this.viewPages[0].listView.smoothScrollBy(0, -i3);
                        } else {
                            DataUsageActivity.this.viewPages[0].listView.smoothScrollBy(0, currentActionBarHeight - i3);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (recyclerView == DataUsageActivity.this.viewPages[0].listView) {
                        float translationY = ((BaseFragment) DataUsageActivity.this).actionBar.getTranslationY();
                        float f = translationY - dy;
                        if (f < (-ActionBar.getCurrentActionBarHeight())) {
                            f = -ActionBar.getCurrentActionBarHeight();
                        } else if (f > 0.0f) {
                            f = 0.0f;
                        }
                        if (f != translationY) {
                            DataUsageActivity.this.setScrollY(f);
                        }
                    }
                }
            });
            if (i2 == 0 && iFindFirstVisibleItemPosition != -1) {
                linearLayoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
            }
            if (i2 != 0) {
                this.viewPages[i2].setVisibility(8);
            }
            i2++;
        }
        frameLayout.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        updateTabs();
        switchToCurrentSelectedMode(false);
        this.swipeBackEnabled = this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$DataUsageActivity(RecyclerListView recyclerListView, View view, int i) {
        if (getParentActivity() == null) {
            return;
        }
        final ListAdapter listAdapter = (ListAdapter) recyclerListView.getAdapter();
        if (i == listAdapter.resetRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("ResetStatisticsAlertTitle", R.string.ResetStatisticsAlertTitle));
            builder.setMessage(LocaleController.getString("ResetStatisticsAlert", R.string.ResetStatisticsAlert));
            builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DataUsageActivity$IT4FZZL9NCse7aTA2HZT4CRZwLI
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$1$DataUsageActivity(listAdapter, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$DataUsageActivity(ListAdapter listAdapter, DialogInterface dialogInterface, int i) {
        StatsController.getInstance(this.currentAccount).resetStats(listAdapter.currentType);
        listAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.mobileAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        ListAdapter listAdapter2 = this.wifiAdapter;
        if (listAdapter2 != null) {
            listAdapter2.notifyDataSetChanged();
        }
        ListAdapter listAdapter3 = this.roamingAdapter;
        if (listAdapter3 != null) {
            listAdapter3.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return this.swipeBackEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollY(float value) {
        this.actionBar.setTranslationY(value);
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i < viewPageArr.length) {
                viewPageArr[i].listView.setPinnedSectionOffsetY((int) value);
                i++;
            } else {
                this.fragmentView.invalidate();
                return;
            }
        }
    }

    private void updateTabs() {
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip == null) {
            return;
        }
        scrollSlidingTextTabStrip.addTextTab(0, LocaleController.getString("NetworkUsageMobileTab", R.string.NetworkUsageMobileTab));
        this.scrollSlidingTextTabStrip.addTextTab(1, LocaleController.getString("NetworkUsageWiFiTab", R.string.NetworkUsageWiFiTab));
        this.scrollSlidingTextTabStrip.addTextTab(2, LocaleController.getString("NetworkUsageRoamingTab", R.string.NetworkUsageRoamingTab));
        this.scrollSlidingTextTabStrip.setVisibility(0);
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        int currentTabId = this.scrollSlidingTextTabStrip.getCurrentTabId();
        if (currentTabId >= 0) {
            this.viewPages[0].selectedType = currentTabId;
        }
        this.scrollSlidingTextTabStrip.finishAddingTabs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        ViewPage[] viewPageArr;
        int i = 0;
        while (true) {
            viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                break;
            }
            viewPageArr[i].listView.stopScroll();
            i++;
        }
        RecyclerView.Adapter adapter = viewPageArr[z ? 1 : 0].listView.getAdapter();
        this.viewPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(null);
        if (this.viewPages[z ? 1 : 0].selectedType != 0) {
            if (this.viewPages[z ? 1 : 0].selectedType != 1) {
                if (this.viewPages[z ? 1 : 0].selectedType == 2 && adapter != this.roamingAdapter) {
                    this.viewPages[z ? 1 : 0].listView.setAdapter(this.roamingAdapter);
                }
            } else if (adapter != this.wifiAdapter) {
                this.viewPages[z ? 1 : 0].listView.setAdapter(this.wifiAdapter);
            }
        } else if (adapter != this.mobileAdapter) {
            this.viewPages[z ? 1 : 0].listView.setAdapter(this.mobileAdapter);
        }
        this.viewPages[z ? 1 : 0].listView.setVisibility(0);
        if (this.actionBar.getTranslationY() != 0.0f) {
            this.viewPages[z ? 1 : 0].layoutManager.scrollToPositionWithOffset(0, (int) this.actionBar.getTranslationY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private int audiosBytesReceivedRow;
        private int audiosBytesSentRow;
        private int audiosReceivedRow;
        private int audiosSection2Row;
        private int audiosSectionRow;
        private int audiosSentRow;
        private int callsBytesReceivedRow;
        private int callsBytesSentRow;
        private int callsReceivedRow;
        private int callsSection2Row;
        private int callsSectionRow;
        private int callsSentRow;
        private int callsTotalTimeRow;
        private int currentType;
        private int filesBytesReceivedRow;
        private int filesBytesSentRow;
        private int filesReceivedRow;
        private int filesSection2Row;
        private int filesSectionRow;
        private int filesSentRow;
        private Context mContext;
        private int messagesBytesReceivedRow;
        private int messagesBytesSentRow;
        private int messagesSection2Row;
        private int messagesSectionRow;
        private int photosBytesReceivedRow;
        private int photosBytesSentRow;
        private int photosReceivedRow;
        private int photosSection2Row;
        private int photosSentRow;
        private int resetRow;
        private int resetSection2Row;
        private int rowCount;
        private int totalBytesReceivedRow;
        private int totalBytesSentRow;
        private int totalSection2Row;
        private int totalSectionRow;
        private int videosBytesReceivedRow;
        private int videosBytesSentRow;
        private int videosReceivedRow;
        private int videosSection2Row;
        private int videosSectionRow;
        private int videosSentRow;
        private int photosSectionRow = 0;
        private int messagesSentRow = -1;
        private int messagesReceivedRow = -1;

        public ListAdapter(Context context, int type) {
            this.mContext = context;
            this.currentType = type;
            this.rowCount = 0;
            int i = 0 + 1;
            this.rowCount = i;
            int i2 = i + 1;
            this.rowCount = i2;
            this.photosSentRow = i;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.photosReceivedRow = i2;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.photosBytesSentRow = i3;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.photosBytesReceivedRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.photosSection2Row = i5;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.videosSectionRow = i6;
            int i8 = i7 + 1;
            this.rowCount = i8;
            this.videosSentRow = i7;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.videosReceivedRow = i8;
            int i10 = i9 + 1;
            this.rowCount = i10;
            this.videosBytesSentRow = i9;
            int i11 = i10 + 1;
            this.rowCount = i11;
            this.videosBytesReceivedRow = i10;
            int i12 = i11 + 1;
            this.rowCount = i12;
            this.videosSection2Row = i11;
            int i13 = i12 + 1;
            this.rowCount = i13;
            this.audiosSectionRow = i12;
            int i14 = i13 + 1;
            this.rowCount = i14;
            this.audiosSentRow = i13;
            int i15 = i14 + 1;
            this.rowCount = i15;
            this.audiosReceivedRow = i14;
            int i16 = i15 + 1;
            this.rowCount = i16;
            this.audiosBytesSentRow = i15;
            int i17 = i16 + 1;
            this.rowCount = i17;
            this.audiosBytesReceivedRow = i16;
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.audiosSection2Row = i17;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.filesSectionRow = i18;
            int i20 = i19 + 1;
            this.rowCount = i20;
            this.filesSentRow = i19;
            int i21 = i20 + 1;
            this.rowCount = i21;
            this.filesReceivedRow = i20;
            int i22 = i21 + 1;
            this.rowCount = i22;
            this.filesBytesSentRow = i21;
            int i23 = i22 + 1;
            this.rowCount = i23;
            this.filesBytesReceivedRow = i22;
            int i24 = i23 + 1;
            this.rowCount = i24;
            this.filesSection2Row = i23;
            int i25 = i24 + 1;
            this.rowCount = i25;
            this.callsSectionRow = i24;
            int i26 = i25 + 1;
            this.rowCount = i26;
            this.callsSentRow = i25;
            int i27 = i26 + 1;
            this.rowCount = i27;
            this.callsReceivedRow = i26;
            int i28 = i27 + 1;
            this.rowCount = i28;
            this.callsBytesSentRow = i27;
            int i29 = i28 + 1;
            this.rowCount = i29;
            this.callsBytesReceivedRow = i28;
            int i30 = i29 + 1;
            this.rowCount = i30;
            this.callsTotalTimeRow = i29;
            int i31 = i30 + 1;
            this.rowCount = i31;
            this.callsSection2Row = i30;
            int i32 = i31 + 1;
            this.rowCount = i32;
            this.messagesSectionRow = i31;
            int i33 = i32 + 1;
            this.rowCount = i33;
            this.messagesBytesSentRow = i32;
            int i34 = i33 + 1;
            this.rowCount = i34;
            this.messagesBytesReceivedRow = i33;
            int i35 = i34 + 1;
            this.rowCount = i35;
            this.messagesSection2Row = i34;
            int i36 = i35 + 1;
            this.rowCount = i36;
            this.totalSectionRow = i35;
            int i37 = i36 + 1;
            this.rowCount = i37;
            this.totalBytesSentRow = i36;
            int i38 = i37 + 1;
            this.rowCount = i38;
            this.totalBytesReceivedRow = i37;
            int i39 = i38 + 1;
            this.rowCount = i39;
            this.totalSection2Row = i38;
            int i40 = i39 + 1;
            this.rowCount = i40;
            this.resetRow = i39;
            this.rowCount = i40 + 1;
            this.resetSection2Row = i40;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                if (position == this.resetSection2Row) {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                } else {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
            }
            int i = 3;
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        return;
                    }
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    long resetStatsDate = StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getResetStatsDate(this.currentType);
                    JalaliCalendar jalaliCalendar = new JalaliCalendar(resetStatsDate);
                    String persianFullDate = PersianDateFormatter.getPersianFullDate(jalaliCalendar.weekDay, jalaliCalendar.day, jalaliCalendar.month, jalaliCalendar.year, LocaleController.getInstance().formatterDay.format(new Date(resetStatsDate)));
                    Object[] objArr = new Object[1];
                    if (!Locale.getDefault().getLanguage().toLowerCase().equals("fa")) {
                        persianFullDate = LocaleController.getInstance().formatterStats.format(resetStatsDate);
                    }
                    objArr[0] = persianFullDate;
                    textInfoPrivacyCell.setText(LocaleController.formatString("NetworkUsageSince", R.string.NetworkUsageSince, objArr));
                    return;
                }
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position == this.totalSectionRow) {
                    headerCell.setText(LocaleController.getString("TotalDataUsage", R.string.TotalDataUsage));
                    return;
                }
                if (position == this.callsSectionRow) {
                    headerCell.setText(LocaleController.getString("CallsDataUsage", R.string.CallsDataUsage));
                    return;
                }
                if (position == this.filesSectionRow) {
                    headerCell.setText(LocaleController.getString("FilesDataUsage", R.string.FilesDataUsage));
                    return;
                }
                if (position == this.audiosSectionRow) {
                    headerCell.setText(LocaleController.getString("LocalAudioCache", R.string.LocalAudioCache));
                    return;
                }
                if (position == this.videosSectionRow) {
                    headerCell.setText(LocaleController.getString("LocalVideoCache", R.string.LocalVideoCache));
                    return;
                } else if (position == this.photosSectionRow) {
                    headerCell.setText(LocaleController.getString("LocalPhotoCache", R.string.LocalPhotoCache));
                    return;
                } else {
                    if (position == this.messagesSectionRow) {
                        headerCell.setText(LocaleController.getString("MessagesDataUsage", R.string.MessagesDataUsage));
                        return;
                    }
                    return;
                }
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            if (position == this.resetRow) {
                textSettingsCell.setTag("windowBackgroundWhiteRedText2");
                textSettingsCell.setText(LocaleController.getString("ResetStatistics", R.string.ResetStatistics), false);
                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText2"));
                return;
            }
            textSettingsCell.setTag("windowBackgroundWhiteBlackText");
            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            int i2 = this.callsSentRow;
            if (position == i2 || position == this.callsReceivedRow || position == this.callsBytesSentRow || position == this.callsBytesReceivedRow) {
                i = 0;
            } else if (position == this.messagesSentRow || position == this.messagesReceivedRow || position == this.messagesBytesSentRow || position == this.messagesBytesReceivedRow) {
                i = 1;
            } else if (position == this.photosSentRow || position == this.photosReceivedRow || position == this.photosBytesSentRow || position == this.photosBytesReceivedRow) {
                i = 4;
            } else if (position != this.audiosSentRow && position != this.audiosReceivedRow && position != this.audiosBytesSentRow && position != this.audiosBytesReceivedRow) {
                if (position == this.videosSentRow || position == this.videosReceivedRow || position == this.videosBytesSentRow || position == this.videosBytesReceivedRow) {
                    i = 2;
                } else {
                    i = (position == this.filesSentRow || position == this.filesReceivedRow || position == this.filesBytesSentRow || position == this.filesBytesReceivedRow) ? 5 : 6;
                }
            }
            if (position == i2) {
                textSettingsCell.setTextAndValue(LocaleController.getString("OutgoingCalls", R.string.OutgoingCalls), String.format("%d", Integer.valueOf(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getSentItemsCount(this.currentType, i))), true);
                return;
            }
            if (position == this.callsReceivedRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("IncomingCalls", R.string.IncomingCalls), String.format("%d", Integer.valueOf(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getRecivedItemsCount(this.currentType, i))), true);
                return;
            }
            if (position == this.callsTotalTimeRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("CallsTotalTime", R.string.CallsTotalTime), AndroidUtilities.formatShortDuration(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getCallsTotalTime(this.currentType)), false);
                return;
            }
            if (position == this.messagesSentRow || position == this.photosSentRow || position == this.videosSentRow || position == this.audiosSentRow || position == this.filesSentRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("CountSent", R.string.CountSent), String.format("%d", Integer.valueOf(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getSentItemsCount(this.currentType, i))), true);
                return;
            }
            if (position == this.messagesReceivedRow || position == this.photosReceivedRow || position == this.videosReceivedRow || position == this.audiosReceivedRow || position == this.filesReceivedRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("CountReceived", R.string.CountReceived), String.format("%d", Integer.valueOf(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getRecivedItemsCount(this.currentType, i))), true);
                return;
            }
            if (position == this.messagesBytesSentRow || position == this.photosBytesSentRow || position == this.videosBytesSentRow || position == this.audiosBytesSentRow || position == this.filesBytesSentRow || position == this.callsBytesSentRow || position == this.totalBytesSentRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("BytesSent", R.string.BytesSent), AndroidUtilities.formatFileSize(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getSentBytesCount(this.currentType, i)), true);
                return;
            }
            if (position == this.messagesBytesReceivedRow || position == this.photosBytesReceivedRow || position == this.videosBytesReceivedRow || position == this.audiosBytesReceivedRow || position == this.filesBytesReceivedRow || position == this.callsBytesReceivedRow || position == this.totalBytesReceivedRow) {
                textSettingsCell.setTextAndValue(LocaleController.getString("BytesReceived", R.string.BytesReceived), AndroidUtilities.formatFileSize(StatsController.getInstance(((BaseFragment) DataUsageActivity.this).currentAccount).getReceivedBytesCount(this.currentType, i)), position == this.callsBytesReceivedRow);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getAdapterPosition() == this.resetRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View shadowSectionCell;
            if (viewType == 0) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (viewType == 1) {
                shadowSectionCell = new TextSettingsCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 2) {
                shadowSectionCell = new HeaderCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == this.resetSection2Row) {
                return 3;
            }
            if (position == this.callsSection2Row || position == this.filesSection2Row || position == this.audiosSection2Row || position == this.videosSection2Row || position == this.photosSection2Row || position == this.messagesSection2Row || position == this.totalSection2Row) {
                return 0;
            }
            return (position == this.totalSectionRow || position == this.callsSectionRow || position == this.filesSectionRow || position == this.audiosSectionRow || position == this.videosSectionRow || position == this.photosSectionRow || position == this.messagesSectionRow) ? 2 : 1;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabActiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabUnactiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, "actionBarTabLine"));
        arrayList.add(new ThemeDescription(null, 0, null, null, new Drawable[]{this.scrollSlidingTextTabStrip.getSelectorDrawable()}, null, "actionBarTabSelector"));
        for (int i = 0; i < this.viewPages.length; i++) {
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class}, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
            arrayList.add(new ThemeDescription(this.viewPages[i].listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText2"));
        }
        return arrayList;
    }
}
