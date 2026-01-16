package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class BotCommandsMenuContainer extends FrameLayout implements NestedScrollingParent {
    Paint backgroundPaint;
    private ObjectAnimator currentAnimation;
    boolean dismissed;
    private boolean entering;
    public RecyclerListView listView;
    private NestedScrollingParentHelper nestedScrollingParentHelper;
    float scrollYOffset;
    Drawable shadowDrawable;
    Paint topBackground;

    protected void onDismiss() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    public BotCommandsMenuContainer(Context context) {
        super(context);
        this.currentAnimation = null;
        this.backgroundPaint = new Paint();
        this.topBackground = new Paint(1);
        this.dismissed = true;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.shadowDrawable = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.BotCommandsMenuContainer.1
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (BotCommandsMenuContainer.this.listView.getLayoutManager() == null || BotCommandsMenuContainer.this.listView.getAdapter() == null || BotCommandsMenuContainer.this.listView.getAdapter().getItemCount() == 0) {
                    super.dispatchDraw(canvas);
                    return;
                }
                View viewFindViewByPosition = BotCommandsMenuContainer.this.listView.getLayoutManager().findViewByPosition(0);
                float y = viewFindViewByPosition != null ? viewFindViewByPosition.getY() : 0.0f;
                if (y < 0.0f) {
                    y = 0.0f;
                }
                BotCommandsMenuContainer.this.scrollYOffset = y;
                float fDp = y - AndroidUtilities.dp(8.0f);
                if (fDp > 0.0f) {
                    int i = (int) fDp;
                    BotCommandsMenuContainer.this.shadowDrawable.setBounds(-AndroidUtilities.dp(8.0f), i - AndroidUtilities.dp(24.0f), getMeasuredWidth() + AndroidUtilities.dp(8.0f), i);
                    BotCommandsMenuContainer.this.shadowDrawable.draw(canvas);
                }
                canvas.drawRect(0.0f, fDp, getMeasuredWidth(), getMeasuredHeight() + AndroidUtilities.dp(16.0f), BotCommandsMenuContainer.this.backgroundPaint);
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set((getMeasuredWidth() / 2.0f) - AndroidUtilities.dp(12.0f), fDp - AndroidUtilities.dp(4.0f), (getMeasuredWidth() / 2.0f) + AndroidUtilities.dp(12.0f), fDp);
                canvas.drawRoundRect(rectF, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), BotCommandsMenuContainer.this.topBackground);
                super.dispatchDraw(canvas);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        addView(this.listView);
        updateColors();
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return !this.dismissed && nestedScrollAxes == 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
        if (this.dismissed) {
            return;
        }
        cancelCurrentAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View target) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target);
        if (this.dismissed) {
            return;
        }
        checkDismiss();
    }

    private void checkDismiss() {
        if (this.dismissed) {
            return;
        }
        if (this.listView.getTranslationY() > AndroidUtilities.dp(16.0f)) {
            dismiss();
        } else {
            playEnterAnim(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (this.dismissed) {
            return;
        }
        cancelCurrentAnimation();
        if (dyUnconsumed != 0) {
            float translationY = this.listView.getTranslationY() - dyUnconsumed;
            if (translationY < 0.0f) {
                translationY = 0.0f;
            }
            this.listView.setTranslationY(translationY);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        if (this.dismissed) {
            return;
        }
        cancelCurrentAnimation();
        float translationY = this.listView.getTranslationY();
        if (translationY <= 0.0f || dy <= 0) {
            return;
        }
        float f = translationY - dy;
        consumed[1] = dy;
        this.listView.setTranslationY(f >= 0.0f ? f : 0.0f);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    private void cancelCurrentAnimation() {
        ObjectAnimator objectAnimator = this.currentAnimation;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.currentAnimation.cancel();
            this.currentAnimation = null;
        }
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
            this.listView.scrollToPosition(0);
            this.entering = true;
            this.dismissed = false;
            return;
        }
        if (this.dismissed) {
            this.dismissed = false;
            cancelCurrentAnimation();
            playEnterAnim(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.entering || this.dismissed) {
            return;
        }
        this.listView.setTranslationY((r2.getMeasuredHeight() - this.listView.getPaddingTop()) + AndroidUtilities.dp(16.0f));
        playEnterAnim(true);
        this.entering = false;
    }

    private void playEnterAnim(boolean firstTime) {
        if (this.dismissed) {
            return;
        }
        RecyclerListView recyclerListView = this.listView;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) FrameLayout.TRANSLATION_Y, recyclerListView.getTranslationY(), 0.0f);
        this.currentAnimation = objectAnimatorOfFloat;
        if (firstTime) {
            objectAnimatorOfFloat.setDuration(320L);
            this.currentAnimation.setInterpolator(new OvershootInterpolator(0.8f));
        } else {
            objectAnimatorOfFloat.setDuration(150L);
            this.currentAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
        }
        this.currentAnimation.start();
    }

    public void dismiss() {
        if (this.dismissed) {
            return;
        }
        this.dismissed = true;
        cancelCurrentAnimation();
        RecyclerListView recyclerListView = this.listView;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) FrameLayout.TRANSLATION_Y, recyclerListView.getTranslationY(), (getMeasuredHeight() - this.scrollYOffset) + AndroidUtilities.dp(40.0f));
        this.currentAnimation = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.BotCommandsMenuContainer.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                BotCommandsMenuContainer.this.setVisibility(8);
                BotCommandsMenuContainer.this.currentAnimation = null;
            }
        });
        this.currentAnimation.setDuration(150L);
        this.currentAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.currentAnimation.start();
        onDismiss();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() != 0 || ev.getY() >= this.scrollYOffset - AndroidUtilities.dp(24.0f)) {
            return super.dispatchTouchEvent(ev);
        }
        return false;
    }

    public void updateColors() {
        this.topBackground.setColor(Theme.getColor("dialogGrayLine"));
        this.backgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhite"), PorterDuff.Mode.MULTIPLY));
        invalidate();
    }
}
