package ir.nasim;

import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: ir.nasim.bi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C10501bi8 extends Bh8 {
    C10501bi8(C22130ui8 c22130ui8, String str, Boolean bool) {
        super(c22130ui8, str, bool, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // ir.nasim.Bh8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.b, false));
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(this.b);
            Log.e("PhenotypeFlag", strValueOf.length() != 0 ? "Invalid boolean value in SharedPreferences for ".concat(strValueOf) : new String("Invalid boolean value in SharedPreferences for "), e);
            return null;
        }
    }

    @Override // ir.nasim.Bh8
    protected final /* synthetic */ Object m(String str) {
        if (Iv8.c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (Iv8.d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
