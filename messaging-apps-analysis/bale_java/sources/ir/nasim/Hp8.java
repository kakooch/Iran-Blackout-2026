package ir.nasim;

import android.util.Log;

/* loaded from: classes3.dex */
final class Hp8 extends AbstractC11344cq8 {
    Hp8(Lp8 lp8, String str, Double d, boolean z) {
        super(lp8, "measurement.test.double_flag", d, true, null);
    }

    @Override // ir.nasim.AbstractC11344cq8
    final /* bridge */ /* synthetic */ Object a(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + super.c() + ": " + ((String) obj));
            return null;
        }
    }
}
