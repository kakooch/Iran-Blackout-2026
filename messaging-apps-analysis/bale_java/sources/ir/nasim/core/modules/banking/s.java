package ir.nasim.core.modules.banking;

import ir.nasim.C12736f7;
import ir.nasim.C19390qG5;
import ir.nasim.C6517Nv5;
import ir.nasim.C9057Yh4;
import ir.nasim.K6;
import ir.nasim.V6;
import ir.nasim.Z6;
import ir.nasim.core.modules.banking.r;

/* loaded from: classes5.dex */
public class s extends Z6 {
    public s(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().e("banking/actor/transactor", new V6() { // from class: ir.nasim.vu7
            @Override // ir.nasim.V6
            public final K6 create() {
                return ir.nasim.core.modules.banking.s.n(c9057Yh4);
            }
        }, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 n(C9057Yh4 c9057Yh4) {
        return new r(c9057Yh4);
    }

    public C6517Nv5 k(String str, String str2, String str3) {
        return c(new r.a(str, str2, str3));
    }

    public C6517Nv5 l(String str, String str2, String str3, String str4, String str5, String str6) {
        return c(new r.d(str, str3, str2, str4, str5, str6));
    }

    public C6517Nv5 m(String str, String str2, String str3, String str4, String str5, String str6) {
        return c(new r.c(str, str2, str3, str4, new C19390qG5().c(), str5, str6));
    }

    public C6517Nv5 o(String str, String str2, int i, long j, String str3, String str4) {
        return c(new r.f(str, str2, i, j, str3, str4));
    }

    public C6517Nv5 p(String str, String str2, String str3, String str4, String str5, String str6) {
        return c(new r.b(str, str2, str3, str4, str5, str6));
    }

    C6517Nv5 q(String str, long j, String str2) {
        return c(new r.e(str, j, str2));
    }
}
