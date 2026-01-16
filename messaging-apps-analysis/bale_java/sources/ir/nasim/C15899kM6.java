package ir.nasim;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: ir.nasim.kM6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15899kM6 {
    public static final C15899kM6 a = new C15899kM6();
    private static final InterfaceC16490lM6 b = new XL6();
    public static final int c = 8;

    private C15899kM6() {
    }

    public final StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i, int i2, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2) {
        return b.b(new C17081mM6(charSequence, i2, i3, textPaint, i, textDirectionHeuristic, alignment, i4, truncateAt, i5, f, f2, i6, z, z2, i7, i8, i9, i10, iArr, iArr2));
    }

    public final boolean c(StaticLayout staticLayout, boolean z) {
        return b.a(staticLayout, z);
    }
}
