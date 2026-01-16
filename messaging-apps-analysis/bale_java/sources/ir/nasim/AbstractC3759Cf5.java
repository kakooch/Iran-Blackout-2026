package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;

/* renamed from: ir.nasim.Cf5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3759Cf5 {
    public static final InterfaceC24463yf5 a() {
        return Build.VERSION.SDK_INT >= 28 ? new C3286Af5() : new C3525Bf5();
    }

    public static final String b(String str, C4593Fu2 c4593Fu2) {
        int iT = c4593Fu2.t() / 100;
        if (iT >= 0 && iT < 2) {
            return str + "-thin";
        }
        if (2 <= iT && iT < 4) {
            return str + "-light";
        }
        if (iT == 4) {
            return str;
        }
        if (iT == 5) {
            return str + "-medium";
        }
        if ((6 <= iT && iT < 8) || 8 > iT || iT >= 11) {
            return str;
        }
        return str + "-black";
    }

    public static final Typeface c(Typeface typeface, C4359Eu2 c4359Eu2, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? C12664ez7.a.a(typeface, c4359Eu2, context) : typeface;
    }
}
