package ir.nasim;

import android.util.Log;

/* loaded from: classes3.dex */
final class Ep8 extends AbstractC11344cq8 {
    Ep8(Lp8 lp8, String str, Long l, boolean z) {
        super(lp8, str, l, true, null);
    }

    @Override // ir.nasim.AbstractC11344cq8
    final /* bridge */ /* synthetic */ Object a(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid long value for " + super.c() + ": " + ((String) obj));
            return null;
        }
    }
}
