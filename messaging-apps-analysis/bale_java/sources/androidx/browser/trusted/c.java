package androidx.browser.trusted;

import android.os.IBinder;
import ir.nasim.InterfaceC14490i03;

/* loaded from: classes.dex */
public class c {
    private final InterfaceC14490i03 a;

    private c(InterfaceC14490i03 interfaceC14490i03) {
        this.a = interfaceC14490i03;
    }

    static c a(IBinder iBinder) {
        InterfaceC14490i03 interfaceC14490i03B2 = iBinder == null ? null : InterfaceC14490i03.a.B2(iBinder);
        if (interfaceC14490i03B2 == null) {
            return null;
        }
        return new c(interfaceC14490i03B2);
    }
}
