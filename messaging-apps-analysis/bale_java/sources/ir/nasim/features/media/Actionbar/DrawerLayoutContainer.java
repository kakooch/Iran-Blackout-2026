package ir.nasim.features.media.Actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C19406qI3;
import ir.nasim.KB5;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes6.dex */
public class DrawerLayoutContainer extends FrameLayout {
    private ActionBarLayout a;
    private Object b;
    private boolean c;
    private int d;
    private Drawable e;
    private boolean f;

    class a implements View.OnApplyWindowInsetsListener {
        a() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            DrawerLayoutContainer drawerLayoutContainer = (DrawerLayoutContainer) view;
            DrawerLayoutContainer.this.b = windowInsets;
            drawerLayoutContainer.setWillNotDraw(windowInsets.getSystemWindowInsetTop() <= 0 && DrawerLayoutContainer.this.getBackground() == null);
            drawerLayoutContainer.requestLayout();
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public DrawerLayoutContainer(Context context) {
        super(context);
        this.f = true;
        this.d = (int) ((AbstractC7426Rr.B() * 64.0f) + 0.5f);
        setDescendantFocusability(262144);
        setFocusableInTouchMode(true);
        setFitsSystemWindows(true);
        setOnApplyWindowInsetsListener(new a());
        setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
        this.e = getResources().getDrawable(KB5.menu_shadow);
    }

    private void b(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i, boolean z) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = z ? 0 : windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
    }

    private void c(View view, Object obj, int i) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!this.f) {
            return false;
        }
        getHeight();
        boolean z = view != null;
        getWidth();
        int iSave = canvas.save();
        if (z) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != view) {
                    childAt.getVisibility();
                }
            }
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (this.e != null) {
            float fMax = Math.max(0.0f, Math.min(0.0f, 1.0f));
            if (fMax != 0.0f) {
                this.e.setBounds(0, view.getTop(), this.e.getIntrinsicWidth(), view.getBottom());
                this.e.setAlpha((int) (fMax * 255.0f));
                this.e.draw(canvas);
            }
        }
        return zDrawChild;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.y() || onTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.c = true;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                try {
                    int i6 = layoutParams.leftMargin;
                    childAt.layout(i6, layoutParams.topMargin, childAt.getMeasuredWidth() + i6, layoutParams.topMargin + childAt.getMeasuredHeight());
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                }
            }
        }
        this.c = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        boolean z = this.b != null;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (z) {
                    if (childAt.getFitsSystemWindows()) {
                        c(childAt, this.b, layoutParams.gravity);
                    } else if (childAt.getTag() == null) {
                        b(layoutParams, this.b, layoutParams.gravity, true);
                    }
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.y();
        return false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.c) {
            return;
        }
        super.requestLayout();
    }

    public void setParentActionBarLayout(ActionBarLayout actionBarLayout) {
        this.a = actionBarLayout;
    }
}
