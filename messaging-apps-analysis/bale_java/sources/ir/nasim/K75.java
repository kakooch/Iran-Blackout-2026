package ir.nasim;

import android.net.Uri;
import com.google.android.gms.common.api.a;

/* loaded from: classes3.dex */
public abstract class K75 {
    private static final a.g a;
    private static final a.AbstractC0169a b;
    private static final com.google.android.gms.common.api.a c;
    private static final InterfaceC13234fs8 d;

    /* JADX WARN: Type inference failed for: r0v1, types: [ir.nasim.Kl8, ir.nasim.fs8] */
    static {
        a.g gVar = new a.g();
        a = gVar;
        Lr8 lr8 = new Lr8();
        b = lr8;
        c = new com.google.android.gms.common.api.a("Phenotype.API", lr8, gVar);
        d = new Kl8();
    }

    public static Uri a(String str) {
        String strValueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
