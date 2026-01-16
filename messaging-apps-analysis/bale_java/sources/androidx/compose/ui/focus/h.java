package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.focus.d;
import androidx.compose.ui.focus.g;
import androidx.compose.ui.platform.AndroidComposeView;
import ir.nasim.CK5;
import ir.nasim.EnumC12613eu3;

/* loaded from: classes2.dex */
public abstract class h {
    public static final CK5 a(View view, View view2) {
        g.a aVar = g.a;
        view.getLocationInWindow(aVar.a());
        int i = aVar.a()[0];
        int i2 = aVar.a()[1];
        view2.getLocationInWindow(aVar.a());
        float f = i - aVar.a()[0];
        float f2 = i2 - aVar.a()[1];
        return new CK5(f, f2, view.getWidth() + f, view.getHeight() + f2);
    }

    public static final boolean b(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !view.hasFocus()) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    public static final Integer c(int i) {
        d.a aVar = d.b;
        if (d.l(i, aVar.h())) {
            return 33;
        }
        if (d.l(i, aVar.a())) {
            return 130;
        }
        if (d.l(i, aVar.d())) {
            return 17;
        }
        if (d.l(i, aVar.g())) {
            return 66;
        }
        if (d.l(i, aVar.e())) {
            return 2;
        }
        return d.l(i, aVar.f()) ? 1 : null;
    }

    public static final d d(int i) {
        if (i == 1) {
            return d.i(d.b.f());
        }
        if (i == 2) {
            return d.i(d.b.e());
        }
        if (i == 17) {
            return d.i(d.b.d());
        }
        if (i == 33) {
            return d.i(d.b.h());
        }
        if (i == 66) {
            return d.i(d.b.g());
        }
        if (i != 130) {
            return null;
        }
        return d.i(d.b.a());
    }

    public static final EnumC12613eu3 e(int i) {
        if (i == 0) {
            return EnumC12613eu3.a;
        }
        if (i != 1) {
            return null;
        }
        return EnumC12613eu3.b;
    }
}
