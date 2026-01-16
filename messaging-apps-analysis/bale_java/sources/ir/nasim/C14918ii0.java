package ir.nasim;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: ir.nasim.ii0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14918ii0 {
    public static final C14918ii0 a = new C14918ii0();

    private C14918ii0() {
    }

    public final BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        if (!(i >= 0)) {
            N73.a("negative width");
        }
        if (!(i2 >= 0)) {
            N73.a("negative ellipsized width");
        }
        return Build.VERSION.SDK_INT >= 33 ? C14308hi0.a(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, z2, truncateAt, i2) : C15508ji0.a(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, truncateAt, i2);
    }

    public final boolean b(BoringLayout boringLayout) {
        if (Build.VERSION.SDK_INT >= 33) {
            return C14308hi0.c(boringLayout);
        }
        return false;
    }

    public final BoringLayout.Metrics c(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        return Build.VERSION.SDK_INT >= 33 ? C14308hi0.b(charSequence, textPaint, textDirectionHeuristic) : C15508ji0.b(charSequence, textPaint, textDirectionHeuristic);
    }
}
