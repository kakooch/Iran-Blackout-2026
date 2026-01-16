package ir.nasim;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* renamed from: ir.nasim.ki8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16107ki8 extends Bh8 {
    private final Object m;
    private String n;
    private Object o;
    private final /* synthetic */ InterfaceC20262ri8 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C16107ki8(C22130ui8 c22130ui8, String str, Object obj, InterfaceC20262ri8 interfaceC20262ri8) {
        super(c22130ui8, str, obj, null);
        this.p = interfaceC20262ri8;
        this.m = new Object();
    }

    @Override // ir.nasim.Bh8
    protected final Object f(SharedPreferences sharedPreferences) {
        try {
            return m(sharedPreferences.getString(this.b, ""));
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(this.b);
            Log.e("PhenotypeFlag", strValueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(strValueOf) : new String("Invalid byte[] value in SharedPreferences for "), e);
            return null;
        }
    }

    @Override // ir.nasim.Bh8
    protected final Object m(String str) {
        Object obj;
        try {
            synchronized (this.m) {
                try {
                    if (!str.equals(this.n)) {
                        Object objA = this.p.a(Base64.decode(str, 3));
                        this.n = str;
                        this.o = objA;
                    }
                    obj = this.o;
                } finally {
                }
            }
            return obj;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
