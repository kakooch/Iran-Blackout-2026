package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class EmptyTextProgressView extends FrameLayout {
    private boolean inLayout;
    private View progressView;
    private int showAtPos;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public EmptyTextProgressView(Context context) {
        this(context, null);
    }

    public EmptyTextProgressView(Context context, View view) {
        super(context);
        if (view == null) {
            view = new RadialProgressView(context);
            addView(view, LayoutHelper.createFrame(-2, -2.0f));
        } else {
            addView(view, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.progressView = view;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(1, 20.0f);
        this.textView.setTextColor(Theme.getColor(Theme.key_emptyListPlaceholder));
        this.textView.setGravity(17);
        this.textView.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.textView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        addView(this.textView, LayoutHelper.createFrame(-2, -2.0f));
        view.setAlpha(0.0f);
        this.textView.setAlpha(0.0f);
        setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.EmptyTextProgressView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return EmptyTextProgressView.lambda$new$0(view2, motionEvent);
            }
        });
    }

    public void showProgress() {
        this.textView.animate().alpha(0.0f).setDuration(150L).start();
        this.progressView.animate().alpha(1.0f).setDuration(150L).start();
    }

    public void showTextView() {
        this.textView.animate().alpha(1.0f).setDuration(150L).start();
        this.progressView.animate().alpha(0.0f).setDuration(150L).start();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setProgressBarColor(int i) {
        View view = this.progressView;
        if (view instanceof RadialProgressView) {
            ((RadialProgressView) view).setProgressColor(i);
        }
    }

    public void setTopImage(int i) {
        if (i == 0) {
            this.textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        Drawable drawableMutate = getContext().getResources().getDrawable(i).mutate();
        if (drawableMutate != null) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_emptyListPlaceholder), PorterDuff.Mode.MULTIPLY));
        }
        this.textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate, (Drawable) null, (Drawable) null);
        this.textView.setCompoundDrawablePadding(AndroidUtilities.dp(1.0f));
    }

    public void setTextSize(int i) {
        this.textView.setTextSize(1, i);
    }

    public void setShowAtCenter(boolean z) {
        this.showAtPos = z ? 1 : 0;
    }

    public void setShowAtTop(boolean z) {
        this.showAtPos = z ? 2 : 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int paddingTop;
        this.inLayout = true;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = (i5 - childAt.getMeasuredWidth()) / 2;
                int i8 = this.showAtPos;
                if (i8 == 2) {
                    measuredHeight = (AndroidUtilities.dp(100.0f) - childAt.getMeasuredHeight()) / 2;
                    paddingTop = getPaddingTop();
                } else if (i8 == 1) {
                    measuredHeight = ((i6 / 2) - childAt.getMeasuredHeight()) / 2;
                    paddingTop = getPaddingTop();
                } else {
                    measuredHeight = (i6 - childAt.getMeasuredHeight()) / 2;
                    paddingTop = getPaddingTop();
                }
                int i9 = measuredHeight + paddingTop;
                childAt.layout(measuredWidth, i9, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i9);
            }
        }
        this.inLayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.inLayout) {
            return;
        }
        super.requestLayout();
    }
}
