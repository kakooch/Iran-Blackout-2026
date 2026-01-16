package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PullToRefreshLayout extends FrameLayout implements View.OnTouchListener {
    private boolean allowPullToRefresh;
    private ObjectAnimator backToTopAnimation;
    private boolean didPassRefreshThreshold;
    private boolean forceEndTouchSession;
    private boolean isRefreshTriggered;
    private int lastTouchY;
    private float maxPullDownY;
    private boolean maybeStartTracking;
    private View.OnTouchListener onListTouchListener;
    private OnRefreshListener onRefreshListener;
    PullToRefreshProgressView progressView;
    private int progressViewSize;
    private float pullToRefreshThreshold;
    private int pulledDownY;
    private int startedTrackingY;
    private View targetListView;

    public interface OnRefreshListener {
        void onRefresh();

        void onRefreshViewAnimatingStatusChanged(boolean z);
    }

    public void setOnListViewTouchListener(View.OnTouchListener onTouchListener) {
        this.onListTouchListener = onTouchListener;
    }

    public PullToRefreshLayout(Context context) {
        super(context);
        this.pulledDownY = 0;
        this.lastTouchY = -1;
        this.allowPullToRefresh = false;
        this.isRefreshTriggered = false;
        this.forceEndTouchSession = false;
        setClipChildren(false);
        setClipToPadding(false);
        PullToRefreshProgressView pullToRefreshProgressView = new PullToRefreshProgressView(context);
        this.progressView = pullToRefreshProgressView;
        this.progressViewSize = 33;
        addView(pullToRefreshProgressView, LayoutHelper.createFrame(33, 33, 49, 0.0f, 19.0f, 0.0f, 0.0f));
        float fDp = AndroidUtilities.dp(80.0f);
        this.pullToRefreshThreshold = fDp;
        this.maxPullDownY = fDp * 3.0f;
        this.progressView.setOnTouchListener(this);
        this.progressView.setClickable(true);
        this.progressView.setFocusable(true);
    }

    public void setRefreshing(boolean z, boolean z2) {
        this.didPassRefreshThreshold = z;
        if (!this.maybeStartTracking) {
            changePullToRefreshMode(z2);
        } else {
            this.forceEndTouchSession = true;
        }
    }

    public boolean isRefreshing() {
        return this.didPassRefreshThreshold || this.isRefreshTriggered;
    }

    public void setUserInteractionEnabled(boolean z) {
        if (z) {
            this.targetListView.setOnTouchListener(this);
            this.progressView.setOnTouchListener(this);
        } else {
            this.targetListView.setOnTouchListener(null);
            this.progressView.setOnTouchListener(null);
        }
    }

    public void bindListViewToLayout(final RecyclerView recyclerView) {
        if (this.targetListView != null) {
            return;
        }
        this.targetListView = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                PullToRefreshLayout.this.checkForPullAllowance(recyclerView);
            }
        });
        this.targetListView.setOnTouchListener(this);
    }

    public void bindListViewToLayout(RecyclerView recyclerView, final RecyclerView recyclerView2) {
        if (this.targetListView != null) {
            return;
        }
        this.targetListView = recyclerView;
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView3, int i) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int i, int i2) {
                PullToRefreshLayout.this.checkForPullAllowance(recyclerView2);
            }
        });
        this.targetListView.setOnTouchListener(this);
    }

    public void setRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 0 || this.targetListView == null) {
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.targetListView == null) {
            return;
        }
        this.progressView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.progressViewSize), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.progressViewSize), 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForPullAllowance(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        if (recyclerView == null || (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()) == null) {
            return;
        }
        this.allowPullToRefresh = linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
    }

    private void updateListTop() {
        int i;
        if (this.backToTopAnimation != null || (i = this.pulledDownY) < 0) {
            return;
        }
        this.progressView.setProgress(i / this.pullToRefreshThreshold);
        View view = this.targetListView;
        if (view != null) {
            view.setTranslationY(this.pulledDownY);
        }
    }

    private void changePullToRefreshMode(boolean z) {
        float f = this.didPassRefreshThreshold ? this.pullToRefreshThreshold : 0.0f;
        if (f != this.pulledDownY) {
            if (z) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.targetListView, "translationY", f);
                this.backToTopAnimation = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                if (!((RecyclerView) this.targetListView).isComputingLayout()) {
                    ((RecyclerView) this.targetListView).suppressLayout(true);
                    OnRefreshListener onRefreshListener = this.onRefreshListener;
                    if (onRefreshListener != null) {
                        onRefreshListener.onRefreshViewAnimatingStatusChanged(true);
                    }
                    this.backToTopAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullToRefreshLayout.this.backToTopAnimation = null;
                            PullToRefreshLayout.this.settlePullToRefreshView();
                            ((RecyclerView) PullToRefreshLayout.this.targetListView).suppressLayout(false);
                            if (PullToRefreshLayout.this.onRefreshListener != null) {
                                PullToRefreshLayout.this.onRefreshListener.onRefreshViewAnimatingStatusChanged(false);
                            }
                            super.onAnimationEnd(animator);
                        }
                    });
                    this.backToTopAnimation.start();
                    return;
                }
                this.backToTopAnimation = null;
                settlePullToRefreshView();
                OnRefreshListener onRefreshListener2 = this.onRefreshListener;
                if (onRefreshListener2 != null) {
                    onRefreshListener2.onRefreshViewAnimatingStatusChanged(false);
                    return;
                }
                return;
            }
            settlePullToRefreshView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void settlePullToRefreshView() {
        if (!this.didPassRefreshThreshold || this.forceEndTouchSession) {
            if (this.forceEndTouchSession) {
                this.forceEndTouchSession = false;
                this.targetListView.setOnTouchListener(this);
            }
            this.progressView.resetState();
            this.pulledDownY = 0;
        } else {
            this.pulledDownY = (int) this.pullToRefreshThreshold;
        }
        updateListTop();
        if (this.pulledDownY == 0) {
            this.isRefreshTriggered = false;
        } else {
            triggerRefreshCallback();
        }
    }

    private void triggerRefreshCallback() {
        OnRefreshListener onRefreshListener = this.onRefreshListener;
        if (onRefreshListener == null || this.isRefreshTriggered) {
            return;
        }
        onRefreshListener.onRefresh();
        this.isRefreshTriggered = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        View.OnTouchListener onTouchListener = this.onListTouchListener;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        if (action == 2) {
            if (this.forceEndTouchSession) {
                endOfTouchSession();
                return super.onTouchEvent(motionEvent);
            }
            if (this.backToTopAnimation == null) {
                if (this.maybeStartTracking) {
                    int iAbs = (int) Math.abs(this.startedTrackingY - motionEvent.getRawY());
                    int rawY = (int) (this.startedTrackingY - motionEvent.getRawY());
                    boolean z = false;
                    boolean z2 = ((float) this.lastTouchY) < motionEvent.getRawY();
                    this.lastTouchY = (int) motionEvent.getRawY();
                    if (Math.abs(iAbs) > 1) {
                        boolean z3 = this.didPassRefreshThreshold;
                        if (z3) {
                            if (rawY <= 0) {
                                iAbs = (int) (iAbs + this.pullToRefreshThreshold);
                            } else {
                                iAbs = (int) (this.pullToRefreshThreshold - iAbs);
                            }
                        }
                        if (!z2 && ((i = this.pulledDownY) <= 0 || (rawY > 0 && i - rawY <= 0 && !z3))) {
                            z = true;
                        }
                        if (!z) {
                            float f = iAbs;
                            float f2 = this.maxPullDownY;
                            if (f > f2) {
                                iAbs = (int) f2;
                            }
                            this.pulledDownY = iAbs;
                            if (iAbs >= this.pullToRefreshThreshold) {
                                triggerRefreshCallback();
                            }
                            updateListTop();
                            return true;
                        }
                        endOfTouchSession();
                        return super.onTouchEvent(motionEvent);
                    }
                } else if (this.allowPullToRefresh) {
                    this.maybeStartTracking = true;
                    int rawY2 = (int) motionEvent.getRawY();
                    this.startedTrackingY = rawY2;
                    this.lastTouchY = rawY2;
                } else {
                    endOfTouchSession();
                }
            }
        } else if (action == 1 || action == 3) {
            endOfTouchSession();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void endOfTouchSession() {
        this.lastTouchY = -1;
        this.startedTrackingY = 0;
        this.maybeStartTracking = false;
        if (this.forceEndTouchSession) {
            this.targetListView.setOnTouchListener(null);
        } else {
            int i = this.pulledDownY;
            if (i != 0) {
                this.didPassRefreshThreshold = ((float) i) >= this.pullToRefreshThreshold;
            }
        }
        changePullToRefreshMode(true);
    }

    public int getPulledDownY() {
        return this.pulledDownY;
    }

    public boolean isInteracted() {
        return this.maybeStartTracking || this.didPassRefreshThreshold || this.pulledDownY > 0 || this.backToTopAnimation != null;
    }
}
