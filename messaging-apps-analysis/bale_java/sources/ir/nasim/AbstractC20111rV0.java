package ir.nasim;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: ir.nasim.rV0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20111rV0 {
    private static final long a = ViewConfiguration.getTapTimeout();

    public static final long a() {
        return a;
    }

    public static final boolean b(JG1 jg1) {
        return c(LG1.a(jg1));
    }

    private static final boolean c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }
}
