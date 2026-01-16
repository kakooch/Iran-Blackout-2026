package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EmptyTextProgressView;

/* loaded from: classes7.dex */
public class EmptyTextProgressView extends FrameLayout {
    private final m.h a;
    private TextView b;
    private LinearLayout c;
    private View d;
    private RLottieImageView e;
    private boolean f;
    private int g;

    public EmptyTextProgressView(Context context) {
        this(context, null, null);
    }

    private int b(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int paddingTop;
        this.f = true;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = (i5 - childAt.getMeasuredWidth()) / 2;
                View view = this.d;
                if (childAt == view && (view instanceof FlickerLoadingView)) {
                    measuredHeight = (i6 - childAt.getMeasuredHeight()) / 2;
                    paddingTop = getPaddingTop();
                } else {
                    int i8 = this.g;
                    if (i8 == 2) {
                        measuredHeight = (AbstractC21455b.F(100.0f) - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    } else if (i8 == 1) {
                        measuredHeight = ((i6 / 2) - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    } else {
                        measuredHeight = (i6 - childAt.getMeasuredHeight()) / 2;
                        paddingTop = getPaddingTop();
                    }
                }
                int i9 = measuredHeight + paddingTop;
                childAt.layout(measuredWidth, i9, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i9);
            }
        }
        this.f = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f) {
            return;
        }
        super.requestLayout();
    }

    public void setLottie(int i, int i2, int i3) {
        this.e.setVisibility(i != 0 ? 0 : 8);
        if (i != 0) {
            this.e.setAnimation(i, i2, i3);
            this.e.f();
        }
    }

    public void setProgressBarColor(int i) {
        View view = this.d;
        if (view instanceof RadialProgressView) {
            ((RadialProgressView) view).setProgressColor(i);
        }
    }

    public void setShowAtCenter(boolean z) {
        this.g = z ? 1 : 0;
    }

    public void setShowAtTop(boolean z) {
        this.g = z ? 2 : 0;
    }

    public void setText(String str) {
        this.b.setText(str);
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.b.setTextSize(1, i);
    }

    public void setTopImage(int i) {
        if (i == 0) {
            this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        Drawable drawableMutate = getContext().getResources().getDrawable(i).mutate();
        if (drawableMutate != null) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(b(ir.nasim.tgwidgets.editor.ui.ActionBar.m.L5), PorterDuff.Mode.MULTIPLY));
        }
        this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate, (Drawable) null, (Drawable) null);
        this.b.setCompoundDrawablePadding(AbstractC21455b.F(1.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyTextProgressView(Context context, View view, m.h hVar) {
        super(context);
        View radialProgressView = view;
        this.a = hVar;
        if (radialProgressView == null) {
            radialProgressView = new RadialProgressView(context);
            addView(radialProgressView, AbstractC13840gu3.b(-2, -2.0f));
        } else {
            addView(radialProgressView, AbstractC13840gu3.b(-1, -1.0f));
        }
        this.d = radialProgressView;
        LinearLayout linearLayout = new LinearLayout(context);
        this.c = linearLayout;
        linearLayout.setPadding(AbstractC21455b.F(20.0f), 0, AbstractC21455b.F(20.0f), 0);
        this.c.setGravity(1);
        this.c.setClipChildren(false);
        this.c.setClipToPadding(false);
        this.c.setOrientation(1);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.e = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e.setImportantForAccessibility(2);
        this.e.setVisibility(8);
        this.c.addView(this.e, AbstractC13840gu3.n(150, 150, 17, 0, 0, 0, 20));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextSize(1, 20.0f);
        this.b.setTextColor(b(ir.nasim.tgwidgets.editor.ui.ActionBar.m.L5));
        this.b.setGravity(1);
        this.b.setText(FH3.E("NoResult", TD5.tgwidget_NoResult));
        this.c.addView(this.b, AbstractC13840gu3.m(-2, -2, 17));
        addView(this.c, AbstractC13840gu3.b(-2, -2.0f));
        AbstractC21455b.J1(this.b, false, 2.0f, false);
        AbstractC21455b.J1(radialProgressView, false, 1.0f, false);
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.O72
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return EmptyTextProgressView.c(view2, motionEvent);
            }
        });
    }
}
