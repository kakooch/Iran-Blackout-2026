package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class N26 {
    public static final N26 a = new N26("IN_CALL", 0);
    public static final N26 b = new N26(TokenNames.INVITE, 1);
    private static final /* synthetic */ N26[] c;
    private static final /* synthetic */ F92 d;

    static {
        N26[] n26ArrA = a();
        c = n26ArrA;
        d = G92.a(n26ArrA);
    }

    private N26(String str, int i) {
    }

    private static final /* synthetic */ N26[] a() {
        return new N26[]{a, b};
    }

    public static N26 valueOf(String str) {
        return (N26) Enum.valueOf(N26.class, str);
    }

    public static N26[] values() {
        return (N26[]) c.clone();
    }
}
