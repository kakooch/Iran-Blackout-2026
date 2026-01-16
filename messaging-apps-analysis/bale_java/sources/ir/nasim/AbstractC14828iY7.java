package ir.nasim;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;

/* renamed from: ir.nasim.iY7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC14828iY7 {
    public static final int a(Context context, float f) {
        AbstractC13042fc3.i(context, "<this>");
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static final int b(View view, float f) {
        AbstractC13042fc3.i(view, "<this>");
        Context context = view.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return a(context, f);
    }

    public static final void c(View view) {
        d(view, true);
    }

    public static final void d(View view, boolean z) {
        e(view, z, true);
    }

    public static final void e(View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            return;
        }
        if (view.getVisibility() != 8) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(z2 ? 300 : 150);
            alphaAnimation.setInterpolator(YU3.a.a());
            view.clearAnimation();
            view.startAnimation(alphaAnimation);
            view.setVisibility(8);
        }
    }

    public static final void f(View view) {
        g(view, true);
    }

    public static final void g(View view, boolean z) {
        h(view, z, true);
    }

    public static final void h(View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(4);
            return;
        }
        if (view.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(z2 ? 300 : 150);
            alphaAnimation.setInterpolator(YU3.a.a());
            view.clearAnimation();
            view.startAnimation(alphaAnimation);
            view.setVisibility(4);
        }
    }

    public static final boolean i(View view) {
        AbstractC13042fc3.i(view, "<this>");
        Rect rect = new Rect();
        return view.getGlobalVisibleRect(rect) && rect.top >= 0 && rect.height() == view.getHeight() && rect.width() == view.getWidth();
    }

    public static final void j(View view, Float f, Float f2, Float f3, Float f4) {
        AbstractC13042fc3.i(view, "<this>");
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (f != null) {
                marginLayoutParams.leftMargin = b(view, f.floatValue());
            }
            if (f2 != null) {
                marginLayoutParams.topMargin = b(view, f2.floatValue());
            }
            if (f3 != null) {
                marginLayoutParams.rightMargin = b(view, f3.floatValue());
            }
            if (f4 != null) {
                marginLayoutParams.bottomMargin = b(view, f4.floatValue());
            }
        }
    }

    public static /* synthetic */ void k(View view, Float f, Float f2, Float f3, Float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        if ((i & 2) != 0) {
            f2 = null;
        }
        if ((i & 4) != 0) {
            f3 = null;
        }
        if ((i & 8) != 0) {
            f4 = null;
        }
        j(view, f, f2, f3, f4);
    }

    public static final void l(View view) {
        m(view, true);
    }

    public static final void m(View view, boolean z) {
        n(view, z, true);
    }

    public static final void n(View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(0);
            return;
        }
        if (view.getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(z2 ? 300 : 150);
            alphaAnimation.setInterpolator(YU3.a.a());
            view.clearAnimation();
            view.startAnimation(alphaAnimation);
            view.setVisibility(0);
        }
    }

    public static final void o(View view) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(150L);
        scaleAnimation.setInterpolator(YU3.a.a());
        view.clearAnimation();
        view.startAnimation(scaleAnimation);
        view.setVisibility(0);
    }

    public static final void p(View view) {
        if (view == null || view.getVisibility() == 4) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(150L);
        scaleAnimation.setInterpolator(YU3.a.a());
        view.clearAnimation();
        view.startAnimation(scaleAnimation);
        view.setVisibility(4);
    }
}
