package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.C4049Dl7;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.nq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17951nq {
    public static final InterfaceC12378eW4 a(String str, C9348Zn7 c9348Zn7, List list, List list2, WH1 wh1, AbstractC9998au2.b bVar) {
        return new C17360mq(str, c9348Zn7, list, list2, bVar, wh1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(C9348Zn7 c9348Zn7) {
        C17847nf5 c17847nf5A;
        C23283wf5 c23283wf5W = c9348Zn7.w();
        return !(((c23283wf5W == null || (c17847nf5A = c23283wf5W.a()) == null) ? null : C24136y62.d(c17847nf5A.b())) == null ? false : C24136y62.g(r1.j(), C24136y62.b.c()));
    }

    public static final int d(int i, IH3 ih3) {
        Locale localeA;
        C4049Dl7.a aVar = C4049Dl7.b;
        if (C4049Dl7.j(i, aVar.b())) {
            return 2;
        }
        if (!C4049Dl7.j(i, aVar.c())) {
            if (C4049Dl7.j(i, aVar.d())) {
                return 0;
            }
            if (C4049Dl7.j(i, aVar.e())) {
                return 1;
            }
            if (!(C4049Dl7.j(i, aVar.a()) ? true : C4049Dl7.j(i, aVar.f()))) {
                throw new IllegalStateException("Invalid TextDirection.".toString());
            }
            if (ih3 == null || (localeA = ih3.i(0).a()) == null) {
                localeA = Locale.getDefault();
            }
            int iA = AbstractC14985io7.a(localeA);
            if (iA == 0 || iA != 1) {
                return 2;
            }
        }
        return 3;
    }
}
