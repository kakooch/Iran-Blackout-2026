package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class ND4 implements CD4 {
    private final C11909dl1 a;

    public ND4(C11909dl1 c11909dl1) {
        AbstractC13042fc3.i(c11909dl1, "container");
        this.a = c11909dl1;
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        C23404wr6 c23404wr6 = new C23404wr6(this.a);
        DD4 dd4 = new DD4(null, null, null, 7, null);
        dd4.f(c23404wr6.a(context, (int) j, null, zn2 == ZN2.GROUP));
        return dd4;
    }
}
