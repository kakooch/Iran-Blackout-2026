package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.Fe5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4452Fe5 implements QY7 {
    private final String b;
    private final long c;

    public /* synthetic */ C4452Fe5(String str, long j, ED1 ed1) {
        this(str, j);
    }

    @Override // ir.nasim.QY7
    public C18600ov7 a(C13245fu c13245fu) {
        AbstractC13042fc3.i(c13245fu, ParameterNames.TEXT);
        return AbstractC8426Vx4.P0(c13245fu, this.b, this.c);
    }

    private C4452Fe5(String str, long j) {
        AbstractC13042fc3.i(str, "placeholder");
        this.b = str;
        this.c = j;
    }
}
