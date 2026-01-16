package ir.nasim;

import android.util.Log;

/* loaded from: classes3.dex */
final class Gp8 extends AbstractC11344cq8 {
    Gp8(Lp8 lp8, String str, Boolean bool, boolean z) {
        super(lp8, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.AbstractC11344cq8
    final /* bridge */ /* synthetic */ Object a(Object obj) {
        if (AbstractC11334cp8.c.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (AbstractC11334cp8.d.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.c() + ": " + ((String) obj));
        return null;
    }
}
