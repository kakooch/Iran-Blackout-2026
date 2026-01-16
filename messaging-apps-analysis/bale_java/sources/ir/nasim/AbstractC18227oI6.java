package ir.nasim;

import android.text.Spanned;

/* renamed from: ir.nasim.oI6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18227oI6 {
    public static final boolean a(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public static final boolean b(Spanned spanned, Class cls, int i, int i2) {
        return spanned.nextSpanTransition(i - 1, i2, cls) != i2;
    }
}
