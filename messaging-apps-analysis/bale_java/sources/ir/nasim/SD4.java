package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class SD4 implements CD4 {
    private final C11909dl1 a;

    public SD4(C11909dl1 c11909dl1) {
        AbstractC13042fc3.i(c11909dl1, "container");
        this.a = c11909dl1;
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        C20941sr6 c20941sr6 = new C20941sr6(this.a);
        DD4 dd4 = new DD4(null, null, null, 7, null);
        dd4.f(c20941sr6.a(context, (int) j, null, zn2 == ZN2.GROUP));
        return dd4;
    }
}
