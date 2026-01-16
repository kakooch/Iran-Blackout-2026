package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class Tooltip extends TextView {
    private View anchor;
    private ViewPropertyAnimator animator;
    Runnable dismissRunnable;
    private boolean showing;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$Tooltip() {
        ViewPropertyAnimator duration = animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Tooltip.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Tooltip.this.setVisibility(8);
            }
        }).setDuration(300L);
        this.animator = duration;
        duration.start();
    }

    public Tooltip(Context context, ViewGroup parentView, int backgroundColor, int textColor) {
        super(context);
        this.dismissRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$Tooltip$Du-G95JRt4CNldVh9tkmw9gl8DM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$Tooltip();
            }
        };
        setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(3.0f), backgroundColor));
        setTextColor(textColor);
        setTextSize(1, 14.0f);
        setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f));
        setGravity(16);
        parentView.addView(this, LayoutHelper.createFrame(-2, -2.0f, 51, 5.0f, 0.0f, 5.0f, 3.0f));
        setVisibility(8);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateTooltipPosition();
    }

    private void updateTooltipPosition() {
        if (this.anchor == null) {
            return;
        }
        View view = (View) getParent();
        int measuredWidth = 0;
        int left = 0;
        int top = 0;
        for (View view2 = this.anchor; view2 != view; view2 = (View) view2.getParent()) {
            top += view2.getTop();
            left += view2.getLeft();
        }
        int width = (left + (this.anchor.getWidth() / 2)) - (getMeasuredWidth() / 2);
        if (width >= 0) {
            measuredWidth = getMeasuredWidth() + width > view.getMeasuredWidth() ? (view.getMeasuredWidth() - getMeasuredWidth()) - AndroidUtilities.dp(16.0f) : width;
        }
        setTranslationX(measuredWidth);
        setTranslationY(top - getMeasuredHeight());
    }

    public void show(View anchor) {
        if (anchor == null) {
            return;
        }
        this.anchor = anchor;
        updateTooltipPosition();
        this.showing = true;
        AndroidUtilities.cancelRunOnUIThread(this.dismissRunnable);
        AndroidUtilities.runOnUIThread(this.dismissRunnable, 2000L);
        ViewPropertyAnimator viewPropertyAnimator = this.animator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setListener(null);
            this.animator.cancel();
            this.animator = null;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
            setVisibility(0);
            ViewPropertyAnimator listener = animate().setDuration(300L).alpha(1.0f).setListener(null);
            this.animator = listener;
            listener.start();
        }
    }

    public void hide() {
        if (this.showing) {
            ViewPropertyAnimator viewPropertyAnimator = this.animator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.setListener(null);
                this.animator.cancel();
                this.animator = null;
            }
            AndroidUtilities.cancelRunOnUIThread(this.dismissRunnable);
            this.dismissRunnable.run();
        }
        this.showing = false;
    }
}
