package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.view.Window;

/* renamed from: ir.nasim.c32, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10701c32 {
    public static void a(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = num == null || num.intValue() == 0;
        boolean z3 = num2 == null || num2.intValue() == 0;
        if (z2 || z3) {
            int iB = WU3.b(window.getContext(), android.R.attr.colorBackground, -16777216);
            if (z2) {
                num = Integer.valueOf(iB);
            }
            if (z3) {
                num2 = Integer.valueOf(iB);
            }
        }
        AbstractC19329q98.b(window, !z);
        int iC = c(window.getContext(), z);
        int iB2 = b(window.getContext(), z);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        boolean zD = d(iC, WU3.f(num.intValue()));
        boolean zD2 = d(iB2, WU3.f(num2.intValue()));
        C18391oa8 c18391oa8A = AbstractC19329q98.a(window, window.getDecorView());
        if (c18391oa8A != null) {
            c18391oa8A.c(zD);
            c18391oa8A.b(zD2);
        }
    }

    private static int b(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 27) {
            return QY0.k(WU3.b(context, android.R.attr.navigationBarColor, -16777216), 128);
        }
        if (z) {
            return 0;
        }
        return WU3.b(context, android.R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return WU3.b(context, android.R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i, boolean z) {
        return WU3.f(i) || (i == 0 && z);
    }
}
