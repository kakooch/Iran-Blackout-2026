package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import io.sentry.C3155n3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class p {
    public static final void a(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        AbstractC13042fc3.i(onDrawListener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnDrawListener(onDrawListener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void b(View view, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        AbstractC13042fc3.i(onPreDrawListener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final int c(TextView textView) {
        AbstractC13042fc3.i(textView, "<this>");
        try {
            return textView.getTotalPaddingTop();
        } catch (NullPointerException unused) {
            return textView.getExtendedPaddingTop();
        }
    }

    public static final List d(o oVar, Rect rect, int i, int i2) {
        AbstractC13042fc3.i(rect, "globalRect");
        if (oVar == null) {
            return AbstractC9766aX0.e(rect);
        }
        ArrayList arrayList = new ArrayList();
        int lineCount = oVar.getLineCount();
        for (int i3 = 0; i3 < lineCount; i3++) {
            int iE = (int) oVar.e(i3, oVar.b(i3));
            int iH = oVar.h(i3);
            int iG = oVar.g(i3);
            int iE2 = (int) oVar.e(i3, (iG - iH) + (iH > 0 ? 1 : 0));
            if (iE2 == 0 && iG > 0) {
                iE2 = ((int) oVar.e(i3, iG - 1)) + 1;
            }
            int iA = oVar.a(i3);
            int iD = oVar.d(i3);
            Rect rect2 = new Rect();
            int i4 = rect.left + i + iE;
            rect2.left = i4;
            rect2.right = i4 + (iE2 - iE);
            int i5 = rect.top + i2 + iA;
            rect2.top = i5;
            rect2.bottom = i5 + (iD - iA);
            arrayList.add(rect2);
        }
        return arrayList;
    }

    public static final boolean e(View view) {
        AbstractC13042fc3.i(view, "<this>");
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static final boolean f(Drawable drawable) {
        if (drawable instanceof InsetDrawable ? true : drawable instanceof ColorDrawable ? true : drawable instanceof VectorDrawable ? true : drawable instanceof GradientDrawable) {
            return false;
        }
        if (!(drawable instanceof BitmapDrawable)) {
            return true;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (bitmap == null) {
            return false;
        }
        return !bitmap.isRecycled() && bitmap.getHeight() > 10 && bitmap.getWidth() > 10;
    }

    public static final XV4 g(View view) {
        AbstractC13042fc3.i(view, "<this>");
        if (!view.isAttachedToWindow()) {
            return AbstractC4616Fw7.a(Boolean.FALSE, null);
        }
        if (view.getWindowVisibility() != 0) {
            return AbstractC4616Fw7.a(Boolean.FALSE, null);
        }
        Object parent = view;
        while (parent instanceof View) {
            float transitionAlpha = Build.VERSION.SDK_INT >= 29 ? ((View) parent).getTransitionAlpha() : 1.0f;
            View view2 = (View) parent;
            if (view2.getAlpha() <= 0.0f || transitionAlpha <= 0.0f || view2.getVisibility() != 0) {
                return AbstractC4616Fw7.a(Boolean.FALSE, null);
            }
            parent = view2.getParent();
        }
        Rect rect = new Rect();
        return AbstractC4616Fw7.a(Boolean.valueOf(view.getGlobalVisibleRect(rect, new Point())), rect);
    }

    public static final void h(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        AbstractC13042fc3.i(onDrawListener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void i(View view, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        AbstractC13042fc3.i(onPreDrawListener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final int j(int i) {
        return i | (-16777216);
    }

    public static final void k(View view, io.sentry.android.replay.viewhierarchy.b bVar, C3155n3 c3155n3) {
        AbstractC13042fc3.i(view, "<this>");
        AbstractC13042fc3.i(bVar, "parentNode");
        AbstractC13042fc3.i(c3155n3, "options");
        if ((view instanceof ViewGroup) && !io.sentry.android.replay.viewhierarchy.a.a.b(view, bVar, c3155n3)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    io.sentry.android.replay.viewhierarchy.b bVarA = io.sentry.android.replay.viewhierarchy.b.m.a(childAt, bVar, viewGroup.indexOfChild(childAt), c3155n3);
                    arrayList.add(bVarA);
                    k(childAt, bVarA, c3155n3);
                }
            }
            bVar.f(arrayList);
        }
    }
}
