package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: ir.nasim.hi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14316hi8 extends Bh8 {
    C14316hi8(C22130ui8 c22130ui8, String str, String str2) {
        super(c22130ui8, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // ir.nasim.Bh8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final String f(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.b, null);
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(this.b);
            Log.e("PhenotypeFlag", strValueOf.length() != 0 ? "Invalid string value in SharedPreferences for ".concat(strValueOf) : new String("Invalid string value in SharedPreferences for "), e);
            return null;
        }
    }

    @Override // ir.nasim.Bh8
    protected final /* synthetic */ Object m(String str) {
        return str;
    }
}
