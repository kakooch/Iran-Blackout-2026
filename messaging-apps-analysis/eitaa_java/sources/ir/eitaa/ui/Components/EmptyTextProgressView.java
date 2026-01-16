package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class EmptyTextProgressView extends FrameLayout {
    private boolean inLayout;
    private View progressView;
    private final Theme.ResourcesProvider resourcesProvider;
    private int showAtPos;
    private TextView textView;

    static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public EmptyTextProgressView(Context context) {
        this(context, null, null);
    }

    public EmptyTextProgressView(Context context, View progressView, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        if (progressView == null) {
            progressView = new RadialProgressView(context);
            addView(progressView, LayoutHelper.createFrame(-2, -2.0f));
        } else {
            addView(progressView, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.progressView = progressView;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(1, 20.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setTextColor(getThemedColor("emptyListPlaceholder"));
        this.textView.setGravity(17);
        this.textView.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.textView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        addView(this.textView, LayoutHelper.createFrame(-2, -2.0f));
        AndroidUtilities.updateViewVisibilityAnimated(this.textView, false, 2.0f, false);
        AndroidUtilities.updateViewVisibilityAnimated(progressView, false, 1.0f, false);
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmptyTextProgressView$FekERVtHYhbr3q0pEZxGyZX6WN0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EmptyTextProgressView.lambda$new$0(view, motionEvent);
            }
        });
    }

    public void showProgress() {
        showProgress(true);
    }

    public void showProgress(boolean animated) {
        AndroidUtilities.updateViewVisibilityAnimated(this.textView, false, 0.9f, animated);
        AndroidUtilities.updateViewVisibilityAnimated(this.progressView, true, 1.0f, animated);
    }

    public void showTextView() {
        AndroidUtilities.updateViewVisibilityAnimated(this.textView, true, 0.9f, true);
        AndroidUtilities.updateViewVisibilityAnimated(this.progressView, false, 1.0f, true);
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setProgressBarColor(int color) {
        View view = this.progressView;
        if (view instanceof RadialProgressView) {
            ((RadialProgressView) view).setProgressColor(color);
        }
    }

    public void setTopImage(int resId) {
        if (resId == 0) {
            this.textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        Drawable drawableMutate = getContext().getResources().getDrawable(resId).mutate();
        if (drawableMutate != null) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("emptyListPlaceholder"), PorterDuff.Mode.MULTIPLY));
        }
        this.textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate, (Drawable) null, (Drawable) null);
        this.textView.setCompoundDrawablePadding(AndroidUtilities.dp(1.0f));
    }

    public void setTextSize(int size) {
        this.textView.setTextSize(1, size);
    }

    public void setShowAtCenter(boolean z) {
        this.showAtPos = z ? 1 : 0;
    }

    public void setShowAtTop(boolean value) {
        this.showAtPos = value ? 2 : 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int measuredHeight;
        int paddingTop;
        this.inLayout = true;
        int i = r - l;
        int i2 = b - t;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = (i - childAt.getMeasuredWidth()) / 2;
                View view = this.progressView;
                if (childAt == view && (view instanceof FlickerLoadingView)) {
                    measuredHeight = (i2 - childAt.getMeasuredHeight()) / 2;
                    paddingTop = getPaddingTop();
                } else {
                    int i4 = this.showAtPos;
                    if (i4 == 2) {
                        measuredHeight = (AndroidUtilities.dp(100.0f) - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    } else if (i4 == 1) {
                        measuredHeight = ((i2 / 2) - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    } else {
                        measuredHeight = (i2 - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    }
                }
                int i5 = measuredHeight + paddingTop;
                childAt.layout(measuredWidth, i5, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i5);
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

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
