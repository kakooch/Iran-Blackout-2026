package ir.nasim.features.media.components;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C6011Lu2;

/* loaded from: classes6.dex */
public class EmptyTextProgressView extends FrameLayout {
    private TextView a;
    private ProgressBar b;
    private boolean c;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public EmptyTextProgressView(Context context) {
        super(context);
        ProgressBar progressBar = new ProgressBar(context);
        this.b = progressBar;
        progressBar.setVisibility(4);
        addView(this.b, C14433hu3.a(-2, -2.0f));
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setTypeface(C6011Lu2.k());
        this.a.setTextSize(1, 20.0f);
        this.a.setTextColor(-8355712);
        this.a.setGravity(17);
        this.a.setVisibility(4);
        this.a.setPadding(C22078ud6.a(20.0f), 0, C22078ud6.a(20.0f), 0);
        this.a.setText(AbstractC12217eE5.NoResult);
        addView(this.a, C14433hu3.a(-2, -2.0f));
        setOnTouchListener(new a());
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.c = true;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = (i5 - childAt.getMeasuredWidth()) / 2;
                int measuredHeight = (i6 - childAt.getMeasuredHeight()) / 2;
                childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
            }
        }
        this.c = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.c) {
            return;
        }
        super.requestLayout();
    }

    public void setText(String str) {
        this.a.setText(str);
    }

    public void setTextColor(int i) {
        this.a.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.a.setTextSize(1, i);
    }

    public void showProgress() {
        this.a.setVisibility(4);
        this.b.setVisibility(0);
    }

    public void showTextView() {
        this.a.setVisibility(0);
        this.b.setVisibility(4);
    }
}
