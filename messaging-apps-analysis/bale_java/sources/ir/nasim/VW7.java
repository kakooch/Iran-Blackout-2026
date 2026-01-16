package ir.nasim;

import java.io.Closeable;

/* loaded from: classes2.dex */
public abstract class VW7 {
    private final YW7 a = new YW7();

    public /* synthetic */ void H0(Closeable closeable) throws Exception {
        AbstractC13042fc3.i(closeable, "closeable");
        YW7 yw7 = this.a;
        if (yw7 != null) {
            yw7.d(closeable);
        }
    }

    public final void I0(String str, AutoCloseable autoCloseable) throws Exception {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(autoCloseable, "closeable");
        YW7 yw7 = this.a;
        if (yw7 != null) {
            yw7.e(str, autoCloseable);
        }
    }

    public final void J0() {
        YW7 yw7 = this.a;
        if (yw7 != null) {
            yw7.f();
        }
        L0();
    }

    public final AutoCloseable K0(String str) {
        AbstractC13042fc3.i(str, "key");
        YW7 yw7 = this.a;
        if (yw7 != null) {
            return yw7.h(str);
        }
        return null;
    }

    protected void L0() {
    }
}
